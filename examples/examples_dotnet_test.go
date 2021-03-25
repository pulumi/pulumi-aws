// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.
// +build dotnet all

package examples

import (
	"path/filepath"
	"testing"

	"github.com/pulumi/pulumi/pkg/v3/testing/integration"
	"github.com/stretchr/testify/assert"
)

func TestAccWebserverCs(t *testing.T) {
	test := getCSBaseOptions(t).
		With(integration.ProgramTestOptions{
			RunUpdateTest: false, //this is newly moved to a new namespace
			Dir:           filepath.Join(getCwd(t), "webserver-cs"),
		})

	integration.ProgramTest(t, &test)
}

func TestAccFifoSqsQueueCs(t *testing.T) {
	test := getCSBaseOptions(t).
		With(integration.ProgramTestOptions{
			Dir:           filepath.Join(getCwd(t), "sqs-fifo-queue", "csharp"),
			RunUpdateTest: false,
			ExtraRuntimeValidation: func(t *testing.T, stack integration.RuntimeValidationStackInfo) {
				assert.Contains(t, stack.Outputs["QueueName"].(string), ".fifo")
			},
		})

	integration.ProgramTest(t, &test)
}

func getCSBaseOptions(t *testing.T) integration.ProgramTestOptions {
	envRegion := getEnvRegion(t)
	base := getBaseOptions()
	csharpBase := base.With(integration.ProgramTestOptions{
		Config: map[string]string{
			"aws:region": envRegion,
		},
		Dependencies: []string{
			"Pulumi.Aws",
		},
	})

	return csharpBase
}
