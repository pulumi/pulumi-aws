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

//go:build ignore

package main

import (
	"encoding/json"
	"errors"
	"fmt"
	"io/fs"
	"log"
	"os"
	"strings"

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/minimalschema"
	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/cmdutil"
)

const (
	schemaJSON        = "schema.json"
	schemaMinimalJSON = "schema-minimal.json"
)

type compressAndVersionSchemaFileOptions struct {
	sourceFile string
	destFile   string
	version    string
}

func readPackageSpecFile(sourceFile string) (*schema.PackageSpec, error) {
	schemaContents, err := os.ReadFile(sourceFile)
	if err != nil {
		return nil, fmt.Errorf("cannot read sourceFile: %w", err)
	}
	var packageSpec schema.PackageSpec
	err = json.Unmarshal(schemaContents, &packageSpec)
	if err != nil {
		return nil, fmt.Errorf("cannot deserialize schema: %w", err)
	}
	return &packageSpec, nil
}

func compressAndVersionSchemaFile(opts compressAndVersionSchemaFileOptions) error {
	packageSpec, err := readPackageSpecFile(opts.sourceFile)
	packageSpec.Version = opts.version
	versionedContents, err := json.Marshal(packageSpec)
	if err != nil {
		return fmt.Errorf("cannot reserialize schema: %w", err)
	}
	err = os.WriteFile(opts.destFile, versionedContents, 0600)
	if err != nil {
		return fmt.Errorf("cannot write destFile: %w", err)
	}
	return nil
}

// Compute minimal schema and its embedded version from the actual schema.
func computeMinimalSchema(version string) {
	s, err := readPackageSpecFile(schemaJSON)
	if err != nil {
		log.Fatal(err)
	}
	minimalschema.NewMinimalSchema(*s).Write(schemaMinimalJSON)
	embedMinimalSchema(version)
}

func embedMinimalSchema(version string) {
	if err := compressAndVersionSchemaFile(compressAndVersionSchemaFileOptions{
		sourceFile: schemaMinimalJSON,
		destFile:   strings.ReplaceAll(schemaMinimalJSON, ".json", "-embed.json"),
		version:    version,
	}); err != nil {
		log.Fatal(err)
	}
}

func main() {
	version, found := os.LookupEnv("VERSION")
	if !found {
		log.Fatal("VERSION environment variable is required but was not set")
	}

	// If called with PULUMI_AWS_MINIMAL_SCHEMA=true, process the minimal schema only and stop.
	if cmdutil.IsTruthy(os.Getenv("PULUMI_AWS_MINIMAL_SCHEMA")) {
		computeMinimalSchema(version)
		return
	}

	// Clean up schema.go as it may be present & gitignored and tolerate an error if the file is not present.
	err := os.Remove("./schema.go")
	if err != nil && !errors.Is(err, fs.ErrNotExist) {
		log.Fatal(err)
	}

	// Compute the embed version of the regular schema.
	if err := compressAndVersionSchemaFile(compressAndVersionSchemaFileOptions{
		sourceFile: schemaJSON,
		destFile:   strings.ReplaceAll(schemaJSON, ".json", "-embed.json"),
		version:    version,
	}); err != nil {
		log.Fatal(err)
	}

	// Also embed the minimal schema.
	embedMinimalSchema(version)
}
