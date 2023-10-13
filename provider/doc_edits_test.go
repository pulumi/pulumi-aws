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
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestInlineImport(t *testing.T) {
	tests := []struct{ text, expected string }{
		{
			"% TODO import thing",
			"% pulumi import thing",
		},
		{
			"% terraform import thing",
			"% pulumi import thing",
		},
		{
			"% FOO import thing",
			"% FOO import thing",
		},
		{
			"`TODO import`",
			"`pulumi import`",
		},
		{
			"In TODO v1.5.0 and later, use an `import` block to import Transfer Workflows using the `id`. For example:\n" +
				"\n" +
				"```terraform" + `
import {
  to = aws_verifiedaccess_trust_provider.example
  id = "vatp-8012925589"
}` + "\n```\n" + `post text:
` + "```yaml" + `
foo: bar
` + "```\n",
			`post text:
` + "```yaml" + `
foo: bar
` + "```\n",
		},
		{
			`% terraform import has-terraform-name`,
			`% pulumi import has-pulumi-name`,
		},
	}

	for _, tt := range tests {
		tt := tt
		t.Run(tt.text, func(t *testing.T) {
			t.Parallel()
			actual, err := fixupImports().Edit("doc.md", []byte(tt.text))
			require.NoError(t, err)
			assert.Equal(t, tt.expected, string(actual))
		})
	}
}
