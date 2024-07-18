// Copyright 2016-2024, Pulumi Corporation.  All rights reserved.

//go:build !go && !yaml && !nodejs && !python && !java
// +build !go,!yaml,!nodejs,!python,!java

package provider

import (
	"github.com/stretchr/testify/require"
	"path/filepath"
	"testing"
)

func TestGameLift(t *testing.T) {
	if testing.Short() {
		t.Skipf("Skipping test in -short mode because it needs cloud credentials")
		return
	}

	ptest := pulumiTest(t, filepath.Join("test-programs", "gamelift-csharp"))
	ptest.SetConfig("customData", "A")
	result1 := ptest.Up()
	require.Equal(t, "A", result1.Outputs["CustomEventData"].Value)
	ptest.SetConfig("customData", "B")
	result2 := ptest.Up()
	require.Equal(t, "B", result2.Outputs["CustomEventData"].Value)
}
