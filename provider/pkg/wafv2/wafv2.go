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

package wafv2

import (
	"fmt"

	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
)

// Customize resources in the wafv2 module.
func ReconfigureResources(p *schema.Provider) {
	webAclReconfigure(p)
}

func webAclReconfigure(p *schema.Provider) {
	webAcl, ok := p.ResourcesMap["aws_wafv2_web_acl"]
	if !ok {
		return
	}
	webAclIgnoreCustomResponseInSetHash(webAcl)
}

func webAclIgnoreCustomResponseInSetHash(webAcl *schema.Resource) {
	editSchema(webAcl, func(fields map[string]*schema.Schema) {
		oldSet := fields["rule"].Set
		if oldSet == nil {
			oldSet = func(i interface{}) int {
				return schema.HashResource(fields["rule"].Elem.(*schema.Resource))(i)
			}
		}
		fields["rule"].Set = func(i interface{}) int {
			visitValue(i, nil, func(path []any, m map[string]any) {
				if len(path) != 4 {
					return
				}
				if path[0] != "action" || path[2] != "block" {
					return
				}
				cr, ok := m["custom_response"]
				if !ok {
					return
				}
				// Update nil custom_response to an empty slice
				if cr == nil {
					m["custom_response"] = []any{}
				}
			})
			return oldSet(i)
		}
	})
}

func visitValue(value any, path []any, visitMap func(path []any, m map[string]any)) {
	switch value := value.(type) {
	case *schema.Set:
		for i, v := range value.List() {
			visitValue(v, append(path, i), visitMap)
		}
	case map[string]any:
		for k, v := range value {
			visitValue(v, append(path, k), visitMap)
		}
		visitMap(path, value)
	case []any:
		for i, v := range value {
			visitValue(v, append(path, i), visitMap)
		}
	}
}

func editSchema(r *schema.Resource, f func(map[string]*schema.Schema)) {
	if r.SchemaFunc != nil {
		sf := r.SchemaFunc
		r.SchemaFunc = func() map[string]*schema.Schema {
			s := sf()
			f(s)
			return s
		}
		return
	}
	f(r.Schema)
}
