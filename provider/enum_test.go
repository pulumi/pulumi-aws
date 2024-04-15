// Copyright 2016-2024, Pulumi Corporation.

package provider

import (
	"testing"

	"github.com/stretchr/testify/assert"
)

func TestInstanceTypeName(t *testing.T) {
	type testCase struct {
		Value string
		Name  string
	}

	testCases := []testCase{
		{Name: "A1_2XLarge", Value: "a1.2xlarge"},
		{Name: "A1_Metal", Value: "a1.metal"},
		{Name: "C6a_Large", Value: "c6a.large"},
		{Name: "C7g_Medium", Value: "c7g.medium"},
		{Name: "M1_Small", Value: "m1.small"},
		{Name: "M7a_Metal_48xl", Value: "m7a.metal-48xl"},
		{Name: "T1_Micro", Value: "t1.micro"},
		{Name: "T2_Nano", Value: "t2.nano"},
		{Name: "U_24tb1_112XLarge", Value: "u-24tb1.112xlarge"},
	}

	for _, tc := range testCases {
		actual, err := instanceTypeName(tc.Value)
		assert.NoError(t, err)
		assert.Equal(t, tc.Name, actual)
	}
}

func TestInstanceTypeNameErr(t *testing.T) {
	testCases := []string{
		"a1.metal.pc",
	}

	for _, tc := range testCases {
		actual, err := instanceTypeName(tc)
		assert.Error(t, err)
		assert.Equal(t, "", actual)
	}
}
