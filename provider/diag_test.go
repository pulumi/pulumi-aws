// Copyright 2016-2023, Pulumi Corporation.

package provider

import (
	"testing"

	"github.com/hashicorp/aws-sdk-go-base/v2/diag"
	"github.com/stretchr/testify/require"
)

func TestFormatDiags(t *testing.T) {
	t.Parallel()

	type testCase struct {
		name   string
		config diag.Diagnostics
		expect string
	}
	testCases := []testCase{
		{
			name:   "empty",
			config: diag.Diagnostics{},
			expect: "",
		},
		{
			name: "single error no details",
			config: diag.Diagnostics{
				diag.NewErrorDiagnostic("something bad happened", ""),
			},
			expect: "something bad happened",
		},
		{
			name: "single error with details",
			config: diag.Diagnostics{
				diag.NewErrorDiagnostic("something bad happened", "take a look at the manual page 523"),
			},
			expect: "something bad happened. take a look at the manual page 523",
		},
		{
			name: "multiple errors",
			config: diag.Diagnostics{
				diag.NewErrorDiagnostic("something bad happened", "take a look at the manual page 523"),
				diag.NewErrorDiagnostic("another error", ""),
				diag.NewErrorDiagnostic("one more", "with details"),
				diag.NewErrorDiagnostic("one more without details", ""),
			},
			expect: `something bad happened. take a look at the manual page 523
another error
one more. with details
one more without details`,
		},
	}

	for _, tc := range testCases {
		t.Run(tc.name, func(t *testing.T) {
			r := formatDiags(tc.config)
			require.Equal(t, tc.expect, r)
		})
	}
}
