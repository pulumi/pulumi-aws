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
	"regexp"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

func editRules(defaults []tfbridge.DocsEdit) []tfbridge.DocsEdit {
	return append(defaults, fixupImports)
}

const tfOrTODO = `([tT]erraform|TODO)`

var inlineImportRegexp = regexp.MustCompile("% " + tfOrTODO + " import")
var quotedImportRegexp = regexp.MustCompile("`" + tfOrTODO + " import`")

// (?s) makes the '.' match newlines (in addition to everything else).
var blockImportRegexp = regexp.MustCompile("(?s)In " + tfOrTODO + " v[0-9]+\\.[0-9]+\\.[0-9]+ and later," +
	" use an `import` block.*?```.+?```\n")

var fixupImports = tfbridge.DocsEdit{
	Path: "*",
	Edit: func(path string, content []byte) ([]byte, error) {
		content = blockImportRegexp.ReplaceAllLiteral(content, nil)
		content = inlineImportRegexp.ReplaceAllLiteral(content, []byte("% pulumi import"))
		content = quotedImportRegexp.ReplaceAllLiteral(content, []byte("`pulumi import`"))
		return content, nil
	},
}
