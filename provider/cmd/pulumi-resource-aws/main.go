// Copyright 2016-2018, Pulumi Corporation.
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

//go:generate go run ./generate.go

package main

import (
	"bytes"
	"compress/gzip"
	"context"
	_ "embed"
	"io"
	"os"

	aws "github.com/pulumi/pulumi-aws/provider/v6"
	pf "github.com/pulumi/pulumi-terraform-bridge/v3/pkg/pf/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/cmdutil"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

//go:embed schema-embed.json
var pulumiSchema []byte

//go:embed schema-minimal-embed.json
var pulumiMinimalSchema []byte

// The data in the minimal schema is compressed with GZIP to avoid bloating the provider size at the cost of slightly
// slower init for uses of the feature.
func decompressMinimalSchema() []byte {
	reader, err := gzip.NewReader(bytes.NewReader(pulumiMinimalSchema))
	contract.AssertNoErrorf(err, "Failed to open a reader into schema-minimal-embed.json")
	bytes, err := io.ReadAll(reader)
	contract.AssertNoErrorf(err, "Failed to read schema-minimal-embed.json")
	return bytes
}

func main() {
	ctx := context.Background()
	info := aws.Provider()

	s := pulumiSchema
	if cmdutil.IsTruthy(os.Getenv("PULUMI_AWS_MINIMAL_SCHEMA")) {
		s = decompressMinimalSchema()
	}

	pf.MainWithMuxer(ctx, "aws", *info, s)
}
