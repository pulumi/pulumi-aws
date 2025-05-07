package provider

import (
	"testing"

	"github.com/pulumi/pulumi-aws/provider/v7/pkg/version"
)

func init() {
	version.Version = "1.2.4"
}

func TestProvider(t *testing.T) {
	t.Parallel()

	Provider()
}

func BenchmarkProvider(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider()
	}
}
