// Copyright 2016-2023, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package provider

import (
	"context"

	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	shim "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfshim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// This adds special handling for the `tagsAll` properties.
// We rely on the upstream Terraform provider to correctly handle `tags` and `tagsAll` and it
// works fine for pf based resources. For SDKv2 resources, terraform relies on two things for tags handling to work:
// (note: this is only true for a specific scenario where `defaultTags` was non-empty and is then completely removed)
//  1. Terraform is run with `--refresh` (default for Terraform)
//  2. When refresh is run, the latest provider config is used.
//
// When you run Pulumi, by default neither of these two things are true which means that to get the same behavior for
// SKDv2 resources, you would have to:
//  1. Run `pulumi refresh --run-program` (run-program is required to get the latest provider config)
//  2. Run `pulumi up` to apply the tags changes.
//
// In order to handle this scenario we add a callback function that is run prior to `Check` which sets the value of `tagsAll`.
// This is a workaround that allows the program to have the latest `tagsAll` values without having to run `refresh` or `run-program`.
func applyTagsPreCheckCallback(
	prov tfbridge.ProviderInfo,
	upstreamSDKV2Provider *schema.Provider,
	key string,
	res shim.Resource,
) {
	if !hasNonComputedTagsAndTagsAllOptimized(key, res) {
		return
	}

	// only process sdkv2 resources. pf resources are fine
	if _, ok := upstreamSDKV2Provider.ResourcesMap[key]; ok {
		if callback := prov.Resources[key].PreCheckCallback; callback != nil {
			prov.Resources[key].PreCheckCallback = func(
				ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
			) (resource.PropertyMap, error) {
				config, err := callback(ctx, config, meta)
				if err != nil {
					return nil, err
				}
				return applyTags(ctx, config, meta)
			}
		} else {
			prov.Resources[key].PreCheckCallback = applyTags
		}
		if prov.Resources[key].GetFields() == nil {
			prov.Resources[key].Fields = map[string]*tfbridge.SchemaInfo{}
		}
		fields := prov.Resources[key].GetFields()

		if _, ok := fields["tags_all"]; !ok {
			fields["tags_all"] = &tfbridge.SchemaInfo{}
		}

		// `tags_all` is an optional/computed property in TF, but should never
		// be set by the user (TF internals will set it). We can mark it as only an
		// output property on our side so that users don't have the option to set it themselves,
		// but we still can in the callback function
		fields["tags_all"].MarkAsComputedOnly = tfbridge.True()
		fields["tags_all"].MarkAsOptional = tfbridge.False()
	}

}

func applyTags(
	ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
) (resource.PropertyMap, error) {
	ret := config.Copy()
	configTags := resource.NewObjectProperty(resource.PropertyMap{})
	if t, ok := config["tags"]; ok {
		configTags = t
	}
	allTags, err := mergeTags(ctx, configTags, meta)
	if err != nil {
		return nil, err
	}
	if allTags.IsNull() {
		ret["tagsAll"] = resource.NewObjectProperty(resource.PropertyMap{})
		return ret, nil
	}
	ret["tagsAll"] = allTags

	return ret, nil
}

// Wrap mergeTagsSimple with taking care of unknowns, secrets and outputs.
func mergeTags(
	ctx context.Context, tags resource.PropertyValue, meta resource.PropertyMap,
) (resource.PropertyValue, error) {
	// Any unknowns make the result unknown.
	if resource.NewObjectProperty(meta).ContainsUnknowns() || tags.ContainsUnknowns() {
		return resource.NewOutputProperty(resource.Output{Known: false}), nil
	}

	// Expect the Pulumi CLI to be shielding Check from secrets.
	contract.Assertf(!tags.ContainsSecrets(), "PreCheckCallback got secrets in config")
	contract.Assertf(!meta.ContainsSecrets(), "PreCheckCallback got secrets in meta")

	var defaultTags awsShim.TagConfig

	// awsShim.NewTagConfig accepts (context.Context, i interface{}) where i can be one of
	// map[string]interface{} among other types. .Mappable() produces a map[string]interface{}
	// where every value is of type string. This is well handled by awsShim.NewTagConfig.
	//
	// config values are guaranteed to be of the correct type because they have already been
	// seen and approved of by the provider, which verifies its configuration is well typed.

	if defaults, ok := meta["defaultTags"]; ok {
		if defaults.IsObject() {
			defaults := defaults.ObjectValue()
			tags, ok := defaults["tags"]
			if ok {
				defaultTags = awsShim.NewTagConfig(ctx, tags.Mappable())
			}
		}
	}

	ignoredTags := &awsShim.TagIgnoreConfig{}
	if ignores, ok := meta["ignoreTags"]; ok {
		if keys, ok := ignores.ObjectValue()["keys"]; ok {
			ignoredTags.Keys = awsShim.NewTagConfig(ctx, keys.Mappable()).Tags
		}
		if keys, ok := ignores.ObjectValue()["keyPrefixes"]; ok {
			ignoredTags.KeyPrefixes = awsShim.NewTagConfig(ctx, keys.Mappable()).Tags
		}
	}

	var resourceTags awsShim.TagConfig
	if tags.IsObject() {
		resourceTags = awsShim.NewTagConfig(ctx, tags.Mappable())
	}

	allTags := defaultTags.MergeTags(resourceTags.Tags).IgnoreConfig(ignoredTags)

	if len(allTags) > 0 {
		allTagProperties := make(resource.PropertyMap, len(allTags))
		for k, v := range allTags {
			pk := resource.PropertyKey(k)
			allTagProperties[pk] = resource.NewStringProperty(v.ValueString())
		}
		return resource.NewObjectProperty(allTagProperties), nil
	} else {
		return resource.NewNullProperty(), nil
	}
}
