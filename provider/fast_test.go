package provider

import (
	"testing"

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
	//"github.com/pulumi/pulumi-terraform-bridge/v3/pkg/tfbridge"
)

func init() {
	version.Version = "1.2.3"
}

func BenchmarkProviderBare(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider()
	}
}

func BenchmarkProviderMetadataInfo(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider("MetadataInfo")
	}
}

func BenchmarkProviderAliases(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider("Aliases")
	}
}

func BenchmarkProvider(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider("Aliases", "MetadataInfo")
	}
}
