package provider

import (
	"testing"

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

func init() {
	version.Version = "1.2.4"
}

func TestProvider(_ *testing.T) {
	Provider()
}

func BenchmarkProvider(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider()
	}
}

func BenchmarkRuntimeProvider(b *testing.B) {
	for n := 0; n < b.N; n++ {
		RuntimeProvider()
	}
}
