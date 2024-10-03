// Copyright 2016-2020, Pulumi Corporation.
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

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
)

type compressAndVersionSchemaFileOptions struct {
	sourceFile string
	destFile   string
	version    string
}

func compressAndVersionSchemaFile(opts compressAndVersionSchemaFileOptions) error {
	schemaContents, err := os.ReadFile(opts.sourceFile)
	if err != nil {
		return fmt.Errorf("cannot read sourceFile: %w", err)
	}
	var packageSpec schema.PackageSpec
	err = json.Unmarshal(schemaContents, &packageSpec)
	if err != nil {
		return fmt.Errorf("cannot deserialize schema: %w", err)
	}
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

func main() {
	// Clean up schema.go as it may be present & gitignored and tolerate an error if the file isn't present.
	err := os.Remove("./schema.go")
	if err != nil && !errors.Is(err, fs.ErrNotExist) {
		log.Fatal(err)
	}

	version, found := os.LookupEnv("VERSION")
	if !found {
		log.Fatal("version not found")
	}

	for _, opts := range []compressAndVersionSchemaFileOptions{
		{
			sourceFile: "schema.json",
			destFile:   "schema-embed.json",
			version:    version,
		},
		{
			sourceFile: "schema-light.json",
			destFile:   "schema-light-embed.json",
			version:    version,
		},
	} {
		err = compressAndVersionSchemaFile(opts)
		if err != nil {
			log.Fatal(err)
		}
	}
}
