// Copyright 2016-2026, Pulumi Corporation.
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
	"os"
	"path/filepath"
	"testing"

	"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
	"github.com/pulumi/pulumi/sdk/v3/go/common/resource"
	"github.com/stretchr/testify/require"
)

func TestValidateCredentialsReadsSharedConfigFiles(t *testing.T) {
	home := t.TempDir()
	t.Setenv("HOME", home)
	t.Setenv("AWS_EC2_METADATA_DISABLED", "true")
	for _, env := range []string{
		"AWS_PROFILE", "AWS_CONFIG_FILE", "AWS_SHARED_CREDENTIALS_FILE", "AWS_SHARED_CREDENTIALS_FILES",
		"AWS_ACCESS_KEY_ID", "AWS_SECRET_ACCESS_KEY", "AWS_SESSION_TOKEN",
	} {
		t.Setenv(env, "")
		require.NoError(t, os.Unsetenv(env))
	}

	// The failing credential_process keeps the test offline: validation still fails, but only after finding the profile.
	configPath := filepath.Join(home, "alt-config")
	require.NoError(t, os.WriteFile(configPath,
		[]byte("[profile onlyhere]\ncredential_process = sh -c 'exit 1'\n"), 0o600))

	err := validateCredentials(resource.PropertyMap{
		"region":  resource.NewProperty("us-west-2"),
		"profile": resource.NewProperty("onlyhere"),
		"sharedConfigFiles": resource.NewProperty([]resource.PropertyValue{
			resource.NewProperty(configPath),
		}),
	}, nil)

	var failure tfbridge.CheckFailureError
	require.ErrorAs(t, err, &failure)
	require.Len(t, failure.Failures, 1)
	require.NotContains(t, failure.Failures[0].Reason, "failed to get shared config profile")
}
