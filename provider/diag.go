// Copyright 2016-2023, Pulumi Corporation.

package provider

import (
	"github.com/hashicorp/aws-sdk-go-base/v2/diag"
)

// formatDiags converts AWS SDK Diagnostics into a human-readable string.
func formatDiags(diag diag.Diagnostics) string {
	details := ""
	for _, d := range diag {
		if details != "" {
			details += "\n"
		}
		details += d.Summary()
		if d.Detail() != "" {
			details += ". " + d.Detail()
		}
	}
	return details
}
