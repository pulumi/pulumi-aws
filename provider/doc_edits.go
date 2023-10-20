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

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

func editRules(defaults []tfbridge.DocsEdit) []tfbridge.DocsEdit {
	return append(defaults,
		fixupImports(),
		// This fixes up strings such as:
		//
		//	name        = "terraform-kinesis-firehose-os",
		//
		// Replacing the above with:
		//
		//	name        = "pulumi-kinesis-firehose-os"
		//
		simpleReplace(
			`"terraform-`,
			`"pulumi-`),
		simpleReplace(
			"If omitted, Terraform will assign a random, unique name.",
			"If omitted, the provider will assign a random, unique name."),
		simpleReplace("Read more about sensitive data in state.\n\n", ""),
		reReplace(`(?m)^(\s*)Terraform resource `, "${1}Resource "),
		reReplace(`(?m)^(\s*)Terraform data source `, "${1}Data source "),
		applyReplacementsDotJSON())
}

func simpleReplace(from, to string) tfbridge.DocsEdit {
	fromB, toB := []byte(from), []byte(to)
	return tfbridge.DocsEdit{
		Path: "*",
		Edit: func(_ string, content []byte) ([]byte, error) {
			return bytes.ReplaceAll(content, fromB, toB), nil
		},
	}
}

func reReplace(from string, to string) tfbridge.DocsEdit {
	fromR, toB := regexp.MustCompile(from), []byte(to)
	return tfbridge.DocsEdit{
		Path: "*",
		Edit: func(_ string, content []byte) ([]byte, error) {
			return fromR.ReplaceAll(content, toB), nil
		},
	}
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
		Edit: func(_ string, content []byte) ([]byte, error) {
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

// Apply replacements from `replacements.json` (as search and replace) to read in docs.
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

	fmt.Printf("Gathered %d replacements\n", len(replacements))
	var applied int

	// Print the number of replacements actually applied, then write out the new
	// `replacements.json` with new TODOs for elided text.
	PostTfgenHook = append(PostTfgenHook, func() {
		fmt.Printf("Applied %d replacements", applied)
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

	edit := func(path string, content []byte) ([]byte, error) {
		replacementPath, ok := replacements[path]
		if !ok {
			return content, nil
		}
		applied++
		for _, r := range replacementPath {
			// If no-one has fixed up the TODO, don't replace it. That way the
			// text will show up as elided instead of including the TODO in
			// user facing docs.
			if r.New == elidedText.ReplaceAllLiteralString(r.Old, "TODO") {
				continue
			}

			old, new := []byte(r.Old), []byte(r.New)

			content = bytes.ReplaceAll(content, old, new)
		}

		replacements.checkForTODOs(path, content)

		return content, nil
	}

	return tfbridge.DocsEdit{
		Path: "*",
		Edit: edit,
	}
}

var PostTfgenHook []func()

type replacementFile map[string][]replacement

type replacement struct {
	Old     string `json:"old"`
	New     string `json:"new"`
	wasUsed bool
}

var elidedText = regexp.MustCompile("[tT]erraform")

func (r replacementFile) checkForTODOs(path string, content []byte) {
	var end int
	for _, m := range elidedText.FindAllIndex(content, -1) {
		// If we see ```terraform, we skip that
		if i := m[0]; i > 3 && (content[i-1] == '`' &&
			content[i-2] == '`' && content[i-3] == '`') {
			continue
		}
		if m[0] < end {
			// This match is on the same line as the previous
			// match, so we don't need to add it twice.
			continue
		}
		var start int
		start, end = findLine(content, m[0])
		line := string(content[start:end])

		r[path] = append(r[path], replacement{
			Old:     line,
			New:     elidedText.ReplaceAllLiteralString(line, "TODO"),
			wasUsed: true,
		})
	}
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
