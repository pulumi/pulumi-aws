// Copyright 2024, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//	http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package provider

import (
	"os"
	"os/exec"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestUpstreamLint(t *testing.T) {
	t.Parallel()

	// Clear Go build cache before linting to avoid disk space issues
	cleanCmd := exec.Command("go", "clean", "-cache")
	cleanCmd.Dir = "../upstream"
	cleanCmd.Stdout = os.Stdout
	cleanCmd.Stderr = os.Stderr
	if err := cleanCmd.Run(); err != nil {
		// Log but don't fail - cache cleanup is best effort
		t.Logf("Warning: failed to clean Go cache: %v", err)
	}

	cmd := exec.Command("make", "provider-lint")
	cmd.Dir = "../upstream"

	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	err := cmd.Start()
	require.NoError(t, err)

	err = cmd.Wait()
	assert.NoError(t, err)
}
