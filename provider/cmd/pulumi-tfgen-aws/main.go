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
	"os"
	"path/filepath"
	"strings"

	aws "github.com/pulumi/pulumi-aws/provider/v6"
	pftfgen "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/pf/tfgen"
	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

func main() {
	info := aws.ProviderFromMeta(tfbridge.NewProviderMetadata(locateMetadata()))

	postProcessor := info.SchemaPostProcessor
	info.SchemaPostProcessor = func(spec *schema.PackageSpec) {
		postProcessor(spec)
		replaceWafV2TypesWithRecursive(spec)
	}

	defer func() {
		for _, f := range aws.PostTfgenHook {
			f()
		}
	}()

	pftfgen.MainWithMuxer("aws", *info)
}

func locateMetadata() []byte {
	p := filepath.Join(strings.Split("provider/cmd/pulumi-resource-aws/bridge-metadata.json", "/")...)
	bytes, err := os.ReadFile(p)
	contract.AssertNoErrorf(err, "Failed to read bridge-metadata.json")
	return bytes
}
