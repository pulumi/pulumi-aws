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

package main

import (
	"bytes"
	"encoding/json"
	"regexp"

	aws "github.com/pulumi/pulumi-aws/provider/v6"
	pftfgen "github.com/pulumi/pulumi-terraform-bridge/pf/tfgen"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

func main() {
	info := aws.Provider()

	info.SchemaPostProcessor = func(spec *schema.PackageSpec) {
		replaceWafV2TypesWithRecursive(spec)
		removeUnusedQuicksightTypes(spec)

		// Temporary workaround until this is exposed in tfbridge.
		if val, ok := spec.Language["go"]; ok {
			var options map[string]any
			err := json.Unmarshal(val, &options)
			contract.AssertNoErrorf(err, "unexpected error unmarshalling go options")
			options["generics"] = "side-by-side"
			spec.Language["go"] = rawMessage(options)
		}

		removeExamples(spec)
	}

	pftfgen.MainWithMuxer("aws", *info)
}

func rawMessage(v any) schema.RawMessage {
	var out bytes.Buffer
	encoder := json.NewEncoder(&out)
	encoder.SetEscapeHTML(false)
	err := encoder.Encode(v)
	contract.AssertNoErrorf(err, "unexpected error while encoding JSON")
	return out.Bytes()
}

var re = regexp.MustCompile(`(?ms)\n?\n?## Example Usage.*`)

func removeExamples(spec *schema.PackageSpec) {
	for tok, t := range spec.Types {
		t.Description = re.ReplaceAllString(t.Description, "")
		spec.Types[tok] = t
	}
	for tok, r := range spec.Resources {
		r.Description = re.ReplaceAllString(r.Description, "")
		spec.Resources[tok] = r
	}
	for tok, f := range spec.Functions {
		f.Description = re.ReplaceAllString(f.Description, "")
		spec.Functions[tok] = f
	}
}
