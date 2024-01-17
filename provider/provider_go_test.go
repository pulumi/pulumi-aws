//go:build !python && !yaml && !nodejs && !dotnet && !java
// +build !python,!yaml,!nodejs,!dotnet,!java

package provider

import (
	"path/filepath"
	"testing"

	"github.com/stretchr/testify/require"
)

func TestSnsTopicReplacement(t *testing.T) {
	ptest := pulumiTest(t, filepath.Join("test-programs", "sns-topic-replacement"))
	ptest.InstallStack("test")

	topicName := randSeq(12)
	ptest.SetConfig("topicName", topicName)

	providerName := randSeq(12)
	ptest.SetConfig("providerName", providerName)
	ptest.Up()

	// Change the name of the provider to check if topic replacement works.
	providerName = randSeq(12)
	ptest.SetConfig("providerName", providerName)
	ptest.Up()

	resRef := ptest.Refresh()

	require.Equal(t, 0, (*resRef.Summary.ResourceChanges)["replace"])
}
