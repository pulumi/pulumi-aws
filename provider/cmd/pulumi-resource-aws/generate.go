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

// +build ignore

package main

import (
	"encoding/json"
	"fmt"
	"io/ioutil"
	"log"
	"os"

	"github.com/pulumi/pulumi/pkg/v3/codegen/schema"
)

func main() {
	version, found := os.LookupEnv("VERSION")
	if !found {
		log.Fatal("version not found")
	}

	schemaContents, err := ioutil.ReadFile("./schema.json")
	if err != nil {
		log.Fatal(err)
	}

	var packageSpec schema.PackageSpec
	err = json.Unmarshal(schemaContents, &packageSpec)
	if err != nil {
		log.Fatalf("cannot deserialize schema: %v", err)
	}

	packageSpec.Version = version
	versionedContents, err := json.Marshal(packageSpec)
	if err != nil {
		log.Fatalf("cannot reserialize schema: %v", err)
	}

	err = ioutil.WriteFile("./schema.go", []byte(fmt.Sprintf(`package main
var pulumiSchema = %#v
`, versionedContents)), 0600)
	if err != nil {
		log.Fatal(err)
	}
}
