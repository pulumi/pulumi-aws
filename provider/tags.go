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

	awsShim "github.com/hashicorp/terraform-provider-aws/shim"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
)

// Apply provider tags to an individual resource.
//
// Historically, Pulumi has struggles to handle the "tags" and "tags_all" fields correctly:
// - https://github.com/pulumi/pulumi-aws/issues/2633
// - https://github.com/pulumi/pulumi-aws/issues/1655
//
// terraform-provider-aws has also struggled with implementing their desired behavior:
// - https://github.com/hashicorp/terraform-provider-aws/issues/29747
// - https://github.com/hashicorp/terraform-provider-aws/issues/29842
// - https://github.com/hashicorp/terraform-provider-aws/issues/24449
//
// The Terraform lifecycle simply does not have a good way to map provider configuration
// onto resource values, so terraform-provider-aws is forced to work around limitations in
// unreliable ways. For example, terraform-provider-aws does not apply tags correctly with
// -refresh=false.
//
// This gives pulumi the same limitations by default. However, unlike Terraform, Pulumi
// does have a clear way to insert provider configuration into resource properties:
// Check. By writing a custom check function that applies "default_tags" to "tags" before
// the Terraform provider sees any resource configuration, we can give a consistent,
// reliable and good experience for Pulumi users.
func applyTags(
	ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
) (resource.PropertyMap, error) {
	ret := config.Copy()
	configTags := resource.NewObjectProperty(resource.PropertyMap{})
	if t, ok := config["tags"]; ok {
		configTags = t
	}
	allTags, hasTags, err := mergeTags(ctx, configTags, meta)
	if err != nil {
		return nil, err
	}
	// If there are 0 tags, delete the tags entry rather than sending an empty map. The unknown
	// case is quirky though, prefer to send the unknown marker out rather than deleting it.
	if !hasTags && !allTags.ContainsUnknowns() {
		delete(ret, "tags")
		return ret, nil
	}
	ret["tags"] = allTags
	return ret, nil
}

// Wrap mergeTagsSimple with taking care of unknowns, secrets and outputs.
func mergeTags(
	ctx context.Context, tags resource.PropertyValue, meta resource.PropertyMap,
) (resource.PropertyValue, bool, error) {
	return composePropertyValue(
		func(c *pvComposer) (resource.PropertyValue, bool, error) {
			stags, err := c.Simplify(tags)
			if err != nil {
				return resource.PropertyValue{}, false, err
			}
			smeta, err := c.SimplifyPropertyMap(meta)
			if err != nil {
				return resource.PropertyValue{}, false, err
			}
			return mergeTagsSimple(ctx, stags, smeta)
		})
}

// At this level we do not need to track secret or unknown anymore.
func mergeTagsSimple(
	ctx context.Context, tags resource.PropertyValue, meta resource.PropertyMap,
) (resource.PropertyValue, bool, error) {
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
		return resource.NewObjectProperty(allTagProperties), true, nil
	} else {
		return resource.PropertyValue{}, false, nil
	}
}
