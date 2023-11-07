package provider

import (
	"fmt"
	"testing"

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

func init() {
	version.Version = "1.2.3"
}

// func TestInit(_ *testing.T) {
// 	init()
// }

func TestProvider(_ *testing.T) {
	Provider()
}

func TestPrint(_ *testing.T) {
	fmt.Println(MetadataInfo)
}

// With embed / json parsing
// goos: darwin
// goarch: arm64
// pkg: github.com/pulumi/pulumi-aws/provider/v6
// BenchmarkProvider-10    	       3	 395742611 ns/op
// PASS
// ok  	github.com/pulumi/pulumi-aws/provider/v6	7.495s

// With codegen
// goos: darwin
// goarch: arm64
// pkg: github.com/pulumi/pulumi-aws/provider/v6
// BenchmarkProvider-10    	       7	 155684494 ns/op
// PASS
// ok  	github.com/pulumi/pulumi-aws/provider/v6	4.615s
func BenchmarkProvider(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider()
	}
}
