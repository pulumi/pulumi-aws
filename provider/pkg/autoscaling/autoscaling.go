// Copyright 2016-2024, Pulumi Corporation.
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

package autoscaling

import (
	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// Customize resources in the autoscaling module.
func ReconfigureResources(p *schema.Provider) {
	autoscalingGroupReconfigure(mustGetResource(p, "aws_autoscaling_group"))
}

func autoscalingGroupReconfigure(r *schema.Resource) {
	suppressUndefinedToDefaultDiffs(mustGetField(r, "force_delete"))
	suppressUndefinedToDefaultDiffs(mustGetField(r, "force_delete_warm_pool"))
	suppressUndefinedToDefaultDiffs(mustGetField(r, "ignore_failed_scaling_activities"))
	suppressUndefinedToDefaultDiffs(mustGetField(r, "wait_for_capacity_timeout"))
}

func mustGetResource(p *schema.Provider, resourceName string) *schema.Resource {
	res, ok := p.ResourcesMap[resourceName]
	contract.Assertf(ok, "expected to find the %q resource", resourceName)
	return res
}

func mustGetField(r *schema.Resource, fieldName string) *schema.Schema {
	fd, ok := r.Schema[fieldName]
	contract.Assertf(ok, "expected to find the %q field", fieldName)
	return fd
}

func suppressUndefinedToDefaultDiffs(field *schema.Schema) {
	contract.Assertf(field.DiffSuppressFunc == nil, "DiffSupppressFunc already defined, refusing to override")
	contract.Assertf(field.Default != nil, "Default must be defined")
	switch field.Type {
	case schema.TypeBool:
		defaultValue, ok := field.Default.(bool)
		contract.Assertf(ok, "Default is not a boolean")
		field.DiffSuppressFunc = func(k, oldValue, newValue string, d *schema.ResourceData) bool {
			// oldValue must be undefined which is encoded as "" for bool
			if oldValue != "" {
				return false
			}
			// if newValue equals default value, suppress the diff
			switch {
			case defaultValue && newValue == "true":
				return true
			case !defaultValue && newValue == "false":
				return true
			default:
				return false
			}
		}
	case schema.TypeString:
		defaultValue, ok := field.Default.(string)
		contract.Assertf(ok, "Default is not a string")
		field.DiffSuppressFunc = func(k, oldValue, newValue string, d *schema.ResourceData) bool {
			// Here oldValue must be undefined.
			//
			// Unfortunately the check will confuse undefined and empty string there does not seem to be any
			// easily available way to determine if a value is defined in state from querying
			// `*schema.ResourceData`.
			//
			// For now, suppress ""->"${default}" diffs together with undefined->"${default}" diffs.
			if oldValue != "" {
				return false
			}
			// if newValue equals default value, suppress the diff
			return newValue == defaultValue
		}
	default:
		contract.Failf("Type not supported yet: %v", field.Type)
	}
}
