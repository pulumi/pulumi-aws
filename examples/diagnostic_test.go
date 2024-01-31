package examples

import (
	"bytes"
	"path/filepath"
	"strings"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
)

func TestCredentialsErrorNotDuplicated(t *testing.T) {
	var outputBuf bytes.Buffer
	test := integration.ProgramTestOptions{
		Dir:           filepath.Join(getCwd(t), "bucket-yaml"),
		Quick:         true,
		Stderr:        &outputBuf,
		ExpectFailure: true,
		Env: []string{
			"AWS_ACCESS_KEY_ID=INVALID",
			"AWS_SECRET_ACCESS_KEY=INVALID",
		},
		ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
			assert.Contains(t, outputBuf.String(), "Invalid credentials configured.")
			assert.Equal(t, 1, strings.Count(outputBuf.String(),
				"Please see https://www.pulumi.com/registry/packages/aws/installation-configuration/ "+
					"for more information about providing credentials."))
		},
	}

	integration.ProgramTest(t, &test)
}
