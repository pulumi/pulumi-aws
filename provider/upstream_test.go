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

	// Compile these into our test binary directly. Normally these are already
	// compiled and cached, but cold boots take a while and we don't want to
	// time out during the test if it needs to build providerlint from scratch.
	// NB: This is fragile because upstream (and upstream/.ci/providerlint)
	// exist in different modules. If our versioning differs we will end up
	// re-compiling. It would be beneficial to keep everything in one module.
	_ "github.com/bflad/tfproviderlint/passes"
	_ "github.com/bflad/tfproviderlint/xpasses"
	_ "github.com/hashicorp/aws-sdk-go-base/v2"

	"github.com/stretchr/testify/assert"
	"github.com/stretchr/testify/require"
)

func TestUpstreamLint(t *testing.T) {
	t.Parallel()

	cmd := exec.Command("make", "provider-lint")
	cmd.Dir = "../upstream"

	cmd.Stdout = os.Stdout
	cmd.Stderr = os.Stderr

	err := cmd.Start()
	require.NoError(t, err)

	err = cmd.Wait()
	assert.NoError(t, err)
}
