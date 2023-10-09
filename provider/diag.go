// Copyright 2016-2023, Pulumi Corporation.

package provider

import (
	"strings"

	"github.com/hashicorp/aws-sdk-go-base/v2/diag"
)

// formatDiags converts AWS SDK Diagnostics into a human-readable string.
func formatDiags(diag diag.Diagnostics) string {
	var sb strings.Builder
	for _, d := range diag {
		if sb.Len() > 0 {
			sb.WriteString("\n")
		}
		sb.WriteString(d.Summary())
		if d.Detail() != "" {
			sb.WriteString(". ")
			sb.WriteString(d.Detail())
		}
	}
	return sb.String()
}
