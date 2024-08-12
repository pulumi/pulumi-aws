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

package provider

import (
	"encoding/json"
	"os"
	"testing"
	"github.com/stretchr/testify/require"
	"github.com/stretchr/testify/assert"
)

// Asserts that the replacements.json file does not include any TODOs.
func TestReplacementDoesNotIncludeTodos(t *testing.T) {
	t.Parallel()

	replacementsJSON, err := os.ReadFile("replacements.json")
	require.NoError(t, err, "Failed to read replacements.json")

	var replacementsFile replacementFile
	err = json.Unmarshal(replacementsJSON, &replacementsFile)
	require.NoError(t, err, "Failed to unmarshal replacements.json")

	for doc, replacements := range replacementsFile {
		for _, replacement := range replacements {
			assert.NotContainsf(t, replacement.New, "TODO", "Replacement value for '%s' contains 'TODO'. Replace the 'TODO' with an appropriate word.", doc)
		}
	}
}
