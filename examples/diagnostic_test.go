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
	test := getBaseOptions().
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "bucket-yaml"),
			Quick:         true,
			Stderr:        &outputBuf,
			ExpectFailure: true,
			ExtraRuntimeValidation: func(t *testing.T, stackInfo integration.RuntimeValidationStackInfo) {
				assert.Equal(t, 1, strings.Count(outputBuf.String(), "No valid credential sources found"))
			},
		})

	integration.ProgramTest(t, &test)
}
