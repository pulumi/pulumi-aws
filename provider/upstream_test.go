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
	"path/filepath"
	"testing"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestUpstreamLint(t *testing.T) {
	t.Parallel()

	upstreamDir := "../upstream"

	// Clear Go build cache and temp directories to free disk space.
	// The issue is that /tmp fills up during compilation of the large upstream provider.
	cleanCacheCmd := exec.Command("go", "clean", "-cache")
	cleanCacheCmd.Dir = upstreamDir
	cleanCacheCmd.Stdout = os.Stdout
	cleanCacheCmd.Stderr = os.Stderr
	if err := cleanCacheCmd.Run(); err != nil {
		t.Logf("Warning: failed to clean Go cache: %v", err)
	}

	// Clean /tmp/go-build* directories which are the temporary build workspaces.
	// These can accumulate and fill up /tmp during parallel compilation.
	cleanTmpCmd := exec.Command("sh", "-c", "rm -rf /tmp/go-build* 2>/dev/null || true")
	cleanTmpCmd.Stdout = os.Stdout
	cleanTmpCmd.Stderr = os.Stderr
	if err := cleanTmpCmd.Run(); err != nil {
		t.Logf("Warning: failed to clean /tmp/go-build directories: %v", err)
	}

	// Set GOTMPDIR to use the workspace directory instead of /tmp.
	// This avoids /tmp space issues by using the workspace which typically has more space.
	workspaceTmpDir, err := filepath.Abs("../.gotmp")
	if err != nil {
		t.Fatalf("Failed to resolve workspace temp directory path: %v", err)
	}
	if err := os.MkdirAll(workspaceTmpDir, 0755); err != nil {
		t.Fatalf("Failed to create workspace temp directory: %v", err)
	}
	defer os.RemoveAll(workspaceTmpDir)

	cmd := exec.Command("make", "provider-lint")
	cmd.Dir = upstreamDir
	cmd.Env = append(os.Environ(), "GOTMPDIR="+workspaceTmpDir)

	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	err = cmd.Start()
	require.NoError(t, err)

	err = cmd.Wait()
	assert.NoError(t, err)
}
