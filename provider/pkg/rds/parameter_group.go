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

package rds

import (
	"context"
	"fmt"
	"regexp"

	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
)

// Customize resources in the rds module.
func ReconfigureResources(p *schema.Provider) {
	parameterGroupReconfigure(p)
}

var (
	parameterGroupApplyMethodRegexp = regexp.MustCompile(`^parameter\.(\d+)\.apply_method$`)
)

// Customize the aws_db_parameter_group resource.
func parameterGroupReconfigure(p *schema.Provider) {
	parameterGroup, ok := p.ResourcesMap["aws_db_parameter_group"]
	if !ok {
		return
	}
	// Need to mark apply_method as Computed so that the diff customizer is allowed to clear it.
	parameterGroup.Schema["parameter"].Elem.(*schema.Resource).Schema["apply_method"].Computed = true
	// Need to exclude apply_method from the set hash.
	oldSetFunc := parameterGroup.Schema["parameter"].Set
	parameterGroup.Schema["parameter"].Set = parameterGroupParameterSetFunc(oldSetFunc)
	addDiffCustomizer(parameterGroup, parameterGroupCustomizeDiff)
}

// Exclude "apply_method" from influencing the set element hash for a parameter.
func parameterGroupParameterSetFunc(oldSetFunc schema.SchemaSetFunc) schema.SchemaSetFunc {
	return func(v interface{}) int {
		m := v.(map[string]interface{})
		// Pretend apply_method is always "immediate" to avoid changing the hash
		copy := make(map[string]interface{}, len(m))
		for k, v := range m {
			copy[k] = v
		}
		copy["apply_method"] = "immediate"
		return oldSetFunc(copy)
	}
}

// Customize the diff to pretend that no changes are happening for a parameter that changes its apply_method but not its
// value. This makes the provider match cloud behavior better.
func parameterGroupCustomizeDiff(ctx context.Context, diff *schema.ResourceDiff, meta interface{}) error {
	// If the apply_method is changed, and the value is not, then clear the apply_method change to ignore it.
	for _, changedKey := range diff.GetChangedKeysPrefix("parameter") {
		// Surprisingly GetChangedKeysPrefix returns keys that did not actually change, so skip those.
		if !diff.HasChange(changedKey) {
			continue
		}
		if m := parameterGroupApplyMethodRegexp.FindStringSubmatch(changedKey); m != nil {
			parameterIndex := m[1]
			matchingValueKey := fmt.Sprintf("parameter.%s.value", parameterIndex)
			if !diff.HasChange(matchingValueKey) {
				if err := diff.Clear(changedKey); err != nil {
					return fmt.Errorf("Failed clearing %s: %w", changedKey, err)
				}
			}
		}
	}
	return nil
}

// This could have been a helper function in pulumi-terraform-bridge somewhere.
func addDiffCustomizer(r *schema.Resource, cdf schema.CustomizeDiffFunc) {
	// Just set it if it is not yet customized.
	if r.CustomizeDiff == nil {
		r.CustomizeDiff = cdf
		return
	}
	// Sequence to compose the custom diff functions otherwise.
	oldCDF := r.CustomizeDiff
	r.CustomizeDiff = func(ctx context.Context, diff *schema.ResourceDiff, meta interface{}) error {
		if err := oldCDF(ctx, diff, meta); err != nil {
			return err
		}
		return cdf(ctx, diff, meta)
	}
}
