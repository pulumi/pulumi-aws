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
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

func applyTags(
	ctx context.Context, config resource.PropertyMap, meta resource.PropertyMap,
) (resource.PropertyMap, error) {
	ret := config.Copy()
	configTags := resource.NewObjectProperty(resource.PropertyMap{})
	if t, ok := config["tags"]; ok {
		configTags = t
	}

	allTags, err := cleanTags(ctx, configTags)
	if err != nil {
		return nil, err
	}

	ret["tags"] = allTags

	return ret, nil
}

func cleanTags(
	ctx context.Context, tags resource.PropertyValue,
) (resource.PropertyValue, error) {
	// Any unknowns make the result unknown.
	if tags.ContainsUnknowns() {
		return resource.NewOutputProperty(resource.Output{Known: false}), nil
	}

	// Expect the Pulumi CLI to be shielding Check from secrets.
	contract.Assertf(!tags.ContainsSecrets(), "PreCheckCallback got secrets in config")

	var resourceTags awsShim.TagConfig
	if tags.IsObject() {
		resourceTags = awsShim.NewTagConfig(ctx, tags.Mappable())
	}

	allTags := resourceTags.Tags

	if len(allTags) > 0 {
		allTagProperties := make(resource.PropertyMap, len(allTags))
		for k, v := range allTags {
			if k == "__defaults" {
				continue
			}
			pk := resource.PropertyKey(k)
			allTagProperties[pk] = resource.NewStringProperty(v.ValueString())
		}
		return resource.NewObjectProperty(allTagProperties), nil
	} else {
		return resource.NewNullProperty(), nil
	}
}
