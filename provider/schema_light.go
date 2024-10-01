// Copyright 2016-2024, Pulumi Corporation. All rights reserved.

package provider

import (
	"encoding/json"
	"os"
	"reflect"
	"strings"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// The light schema is a correct approximation of the real schema.
//
// In the V6 major version of the provider, the real schema has structural integrity issues such unresolved references
// to types (for example, `aws:iot/policy:Policy`). These issues break third-party tooling that assumes the schema is
// clean. Resolving the issues however necessitates small breaking changes to the user programs, as for historical
// reasons the current output depends on SDK generation behavior over unresolved references.
//
// For the duration of V6 the compromise is to derive a light schema that is clean with respect to references, while
// continuing to feed the existing schema to SDK generation. At the time of V7 release the intent is to take the
// necessary breaking changes to make the real schema clean and remove the light schema.
type lightSchema struct {
	schema.PackageSpec
}

func newLightSchema(realSchema schema.PackageSpec) *lightSchema {
	bytes, err := json.Marshal(realSchema)
	contract.AssertNoErrorf(err, "json.Marshal failed on a schema")

	var sch any
	err = json.Unmarshal(bytes, &sch)
	contract.AssertNoErrorf(err, "json.Unmarshal failed on a schema")

	ls := &lightSchema{realSchema}
	sch = ls.rewrite(sch)

	bytes, err = json.Marshal(sch)
	contract.AssertNoErrorf(err, "json.Marshal failed on a schema")

	var result schema.PackageSpec
	err = json.Unmarshal(bytes, &result)
	contract.AssertNoErrorf(err, "json.Unmarshal failed on a schema")

	return &lightSchema{result}
}

func (ls *lightSchema) isDanglingRef(ref string) bool {
	switch {
	case strings.HasPrefix(ref, "#/types/"):
		clean := strings.TrimPrefix(ref, "#/types/")
		if _, ok := ls.PackageSpec.Types[clean]; !ok {
			return true
		}
		return false
	case ref == "pulumi.json#/Any" ||
		ref == "pulumi.json#/Asset" ||
		ref == "pulumi.json#/Archive":
		// Ignore known special type references.
		return false
	default:
		contract.Failf("Unexpected type reference kind: %q", ref)
		return false
	}
}

func (ls *lightSchema) isTypeString(m map[string]any) bool {
	typ, ok := m["type"]
	if !ok {
		return false
	}
	typs, ok := typ.(string)
	if !ok {
		return false
	}
	if typs != "string" {
		return false
	}
	return true
}

// Recognize { "$ref": "#/types/aws:rds/engineType:EngineType"}
func (ls *lightSchema) isDanglingPlainRef(m map[string]any) bool {
	r, ok := m["$ref"]
	if !ok {
		return false
	}
	ref, ok := r.(string)
	if !ok {
		return false
	}
	if !ls.isDanglingRef(ref) {
		return false
	}
	return true
}

// Recognize { "type": "string", "$ref": "#/types/aws:rds/engineType:EngineType"}
func (ls *lightSchema) isDanglingStringRef(m map[string]any) bool {
	if !ls.isTypeString(m) {
		return false
	}
	if !ls.isDanglingPlainRef(m) {
		return false
	}
	return true
}

// Recognize unions of type String+R where R is dangling, such as:
//
//		{
//	             "type": "string",
//			"oneOf": [
//			    {
//				"type": "string"
//			    },
//			    {
//				"type": "string",
//				"$ref": "#/types/aws:iam/role:Role"
//			    }
//			]
//		}
func (ls *lightSchema) isUnionStringDanglingRef(m map[string]any) bool {
	if !ls.isTypeString(m) {
		return false
	}
	oneOf, ok := m["oneOf"]
	if !ok {
		return false
	}
	cases, ok := oneOf.([]any)
	if !ok {
		return false
	}
	if len(cases) != 2 {
		return false
	}
	if !reflect.DeepEqual(cases[0], map[string]any{"type": "string"}) {
		return false
	}
	case1, ok := cases[1].(map[string]any)
	if !ok {
		return false
	}
	if !ls.isDanglingStringRef(case1) {
		return false
	}
	return true
}

// Recognize unions of two dangling refs R1+R2 where R is stringy:
//
//	{
//		"oneOf": [
//		    {
//		    	"$ref": "#/types/aws:iam/Role:Role"
//		    },
//		    {
//			"type": "string",
//			"$ref": "#/types/aws:iam/role:Role"
//		    }
//		]
//	}
func (ls *lightSchema) isUnion2DanglingRefs(m map[string]any) bool {
	oneOf, ok := m["oneOf"]
	if !ok {
		return false
	}
	cases, ok := oneOf.([]any)
	if !ok {
		return false
	}
	if len(cases) != 2 {
		return false
	}
	case0, ok := cases[0].(map[string]any)
	if !ok {
		return false
	}
	case1, ok := cases[1].(map[string]any)
	if !ok {
		return false
	}
	if !ls.isDanglingPlainRef(case0) {
		return false
	}
	if !ls.isDanglingStringRef(case1) {
		return false
	}
	return true
}

func (ls *lightSchema) rewrite(schema any) any {
	switch x := schema.(type) {
	case map[string]any:
		switch {
		// { "type": "string", "oneOf": [String, DanglingRef] } --> { "type": "string" }
		case ls.isUnionStringDanglingRef(x):
			delete(x, "oneOf")
			return x
		// { "oneOf": [DanglingRef1, StringDanglingRef2] } --> { "type": "string" }
		case ls.isUnion2DanglingRefs(x):
			if !ls.isTypeString(x) {
				_, gotType := x["type"]
				contract.Assertf(!gotType, "refusing to override type")
				x["type"] = "string"
			}
			delete(x, "oneOf")
			return x
		// { "type": "string", "$ref": "#/types/aws:rds/engineType:EngineType"} --> { "type": "string" }
		case ls.isDanglingStringRef(x):
			delete(x, "$ref")
			return x
		default:
			for k, v := range x {
				x[k] = ls.rewrite(v)
			}
			return x
		}

	case []any:
		for i, e := range x {
			x[i] = ls.rewrite(e)
		}
		return x
	default:
		return schema
	}
}

func (ls *lightSchema) write(lightSchemaFile string) {
	bytes, err := json.Marshal(ls.PackageSpec)
	contract.AssertNoErrorf(err, "json.Marshal failed to serialize a schema")
	err = os.WriteFile(lightSchemaFile, bytes, 0600)
	contract.AssertNoErrorf(err, "failed to write the light schema")
}
