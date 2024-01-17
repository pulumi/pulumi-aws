//go:build !python && !yaml && !nodejs && !dotnet && !java
// +build !python,!yaml,!nodejs,!dotnet,!java

package provider

import (
	"path/filepath"
	"q"
	"testing"
)

func TestSnsTopicReplacement(t *testing.T) {
	ptest := pulumiTest(t, filepath.Join("test-programs", "sns-topic-replacement"))

	topicName := randSeq(12)
	ptest.SetConfig("topicName", topicName)

	providerName := randSeq(12)
	ptest.SetConfig("providerName", providerName)
	ptest.Up()

	// Change the name of the provider to check if topic replacement works.
	providerName = randSeq(12)
	ptest.SetConfig("providerName", providerName)
	ptest.Up()

	res := ptest.Refresh()
	q.Q(res.Summary.ResourceChanges)
}
