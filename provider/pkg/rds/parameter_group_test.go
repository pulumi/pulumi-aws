// Copyright 2016-2026, Pulumi Corporation.
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
	"testing"

	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestParameterGroupReconfigureSupportsSchemaAndSchemaFunc(t *testing.T) {
	t.Parallel()

	tests := []struct {
		name           string
		parameterGroup *schema.Resource
		getSchema      func(*schema.Resource) map[string]*schema.Schema
	}{
		{
			name: "Schema",
			parameterGroup: &schema.Resource{
				Schema: parameterGroupSchema(),
			},
			getSchema: func(r *schema.Resource) map[string]*schema.Schema {
				return r.Schema
			},
		},
		{
			name: "SchemaFunc",
			parameterGroup: &schema.Resource{
				SchemaFunc: parameterGroupSchema,
			},
			getSchema: func(r *schema.Resource) map[string]*schema.Schema {
				return r.SchemaFunc()
			},
		},
	}

	for _, tt := range tests {
		tt := tt
		t.Run(tt.name, func(t *testing.T) {
			t.Parallel()

			provider := &schema.Provider{
				ResourcesMap: map[string]*schema.Resource{
					"aws_db_parameter_group": tt.parameterGroup,
				},
			}

			parameterGroupReconfigure(provider)

			parameterGroupSchema := tt.getSchema(provider.ResourcesMap["aws_db_parameter_group"])
			parameter, ok := parameterGroupSchema["parameter"]
			require.True(t, ok)

			applyMethod := parameter.Elem.(*schema.Resource).Schema["apply_method"]
			assert.True(t, applyMethod.Computed)
			assert.Nil(t, applyMethod.Default)

			immediateHash := parameter.Set(map[string]interface{}{
				"name":         "max_connections",
				"value":        "100",
				"apply_method": "immediate",
			})
			pendingRebootHash := parameter.Set(map[string]interface{}{
				"name":         "max_connections",
				"value":        "100",
				"apply_method": "pending-reboot",
			})
			assert.Equal(t, immediateHash, pendingRebootHash)
		})
	}
}

func parameterGroupSchema() map[string]*schema.Schema {
	return map[string]*schema.Schema{
		"parameter": {
			Type: schema.TypeSet,
			Elem: &schema.Resource{
				Schema: map[string]*schema.Schema{
					"apply_method": {
						Type:     schema.TypeString,
						Optional: true,
						Default:  "pending-reboot",
					},
					"name": {
						Type:     schema.TypeString,
						Required: true,
					},
					"value": {
						Type:     schema.TypeString,
						Required: true,
					},
				},
			},
			Set: func(v interface{}) int {
				m := v.(map[string]interface{})
				if m["apply_method"] == "immediate" {
					return 1
				}
				return 2
			},
		},
	}
}
