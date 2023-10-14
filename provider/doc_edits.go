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

package provider

import (
	"bytes"
	"encoding/json"
	"fmt"
	"os"
	"regexp"
	"strings"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

func editRules(defaults []tfbridge.DocsEdit) []tfbridge.DocsEdit {
	return append(defaults, fixupImports(), applyReplacementsDotJSON())
}

func fixupImports() tfbridge.DocsEdit {
	const tfOrTODO = `([tT]erraform|TODO)`

	var inlineImportRegexp = regexp.MustCompile("% " + tfOrTODO + " import.*")
	var quotedImportRegexp = regexp.MustCompile("`" + tfOrTODO + " import`")

	// (?s) makes the '.' match newlines (in addition to everything else).
	var blockImportRegexp = regexp.MustCompile("(?s)In " + tfOrTODO + " v[0-9]+\\.[0-9]+\\.[0-9]+ and later," +
		" use an `import` block.*?```.+?```\n")

	return tfbridge.DocsEdit{
		Path: "*",
		Edit: func(path string, content []byte) ([]byte, error) {
			content = blockImportRegexp.ReplaceAllLiteral(content, nil)
			content = inlineImportRegexp.ReplaceAllFunc(content, func(match []byte) []byte {
				match = bytes.ReplaceAll(match, []byte("terraform"), []byte("pulumi"))
				match = bytes.ReplaceAll(match, []byte("Terraform"), []byte("pulumi"))
				match = bytes.ReplaceAll(match, []byte("TODO"), []byte("pulumi"))
				return match
			})
			content = quotedImportRegexp.ReplaceAllLiteral(content, []byte("`pulumi import`"))
			return content, nil
		},
	}
}

func applyReplacementsDotJSON() tfbridge.DocsEdit {
	filePath := "./provider/replacements.json"
	fileBytes, err := os.ReadFile(filePath)
	if err != nil {
		panic(err)
	}
	var replacements replacementFile
	err = json.Unmarshal(fileBytes, &replacements)
	if err != nil {
		panic(err)
	}

	for k, v := range replacements {
		i := strings.LastIndexByte(k, '/')
		if i == -1 {
			continue
		}
		delete(replacements, k)

		key := k[i+1:]
		replacements[key] = append(replacements[key], v...)
	}

	fmt.Printf("Gathered %d replacements\n", len(replacements))
	var applied int

	checkForTODOs := make(chan struct {
		path    string
		content []byte
	})
	doneWithTODOs := make(chan struct{})

	go func() {
		r := regexp.MustCompile("[tT]erraform")
		for {
			f, ok := <-checkForTODOs
			if !ok {
				// Signal that we are done processing and it is safe to proceed.
				close(doneWithTODOs)
				return
			}
			var end int
			for _, m := range r.FindAllIndex(f.content, -1) {
				// If we see ```terraform, we skip that
				if i := m[0]; i > 3 && (f.content[i-1] == '`' &&
					f.content[i-2] == '`' && f.content[i-3] == '`') {
					continue
				}
				if m[0] < end {
					// This match is on the same line as the previous
					// match, so we don't need to add it twice.
					continue
				}
				var start int
				start, end = findLine(f.content, m[0])
				line := string(f.content[start:end])

				replacements[f.path] = append(replacements[f.path], struct {
					Old string `json:"old"`
					New string `json:"new"`
				}{line, r.ReplaceAllLiteralString(line, "TODO")})
			}
		}
	}()

	PostTfgenHook = append(PostTfgenHook, func() {
		fmt.Printf("Applied %d replacements", applied)
		close(checkForTODOs)
		<-doneWithTODOs
		var b bytes.Buffer
		m := json.NewEncoder(&b)
		m.SetEscapeHTML(false)
		m.SetIndent("", "  ")
		err := m.Encode(replacements)
		if err != nil {
			panic(err)
		}
		err = os.WriteFile(filePath, b.Bytes(), 0600)
		if err != nil {
			panic(err)
		}
	})

	return tfbridge.DocsEdit{
		Path: "*",
		Edit: func(path string, content []byte) ([]byte, error) {
			replacementPath, ok := replacements[path]
			if !ok {
				return content, nil
			}
			applied++
			for _, r := range replacementPath {
				old, new := []byte(r.Old), []byte(r.New)
				content = bytes.ReplaceAll(content, old, new)
			}

			checkForTODOs <- struct {
				path    string
				content []byte
			}{path, content}

			return content, nil
		},
	}
}

var PostTfgenHook []func()

type replacementFile map[string][]struct {
	Old string `json:"old"`
	New string `json:"new"`
}

func findLine(src []byte, i int) (int, int) {
	start, end := i, i
	for start > 0 && src[start-1] != '\n' {
		start--
	}
	for end < len(src) && src[end] != '\n' {
		end++
	}
	return start, end + 1
}
