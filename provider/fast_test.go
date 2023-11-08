package provider

import (
	"testing"

	"github.com/pulumi/pulumi-aws/provider/v6/pkg/version"
)

func init() {
	version.Version = "1.2.3"
}

func TestProvider(_ *testing.T) {
	Provider()
}

// With embed / json parsing
// goos: darwin
// goarch: arm64
// pkg: github.com/pulumi/pulumi-aws/provider/v6
// BenchmarkProvider-10    	       3	 395742611 ns/op
// PASS
// ok  	github.com/pulumi/pulumi-aws/provider/v6	7.495s

// With simple codegen
// goos: darwin
// goarch: arm64
// pkg: github.com/pulumi/pulumi-aws/provider/v6
// BenchmarkProvider-10    	       7	 155684494 ns/op
// PASS
// ok  	github.com/pulumi/pulumi-aws/provider/v6	4.615s

// With full codegen + auto aliasing
// goos: darwin
// goarch: arm64
// pkg: github.com/pulumi/pulumi-aws/provider/v6
// BenchmarkProvider-10    	       9	 113111389 ns/op
// PASS
// ./provider.test -test.bench BenchmarkProvider   4.47s user 0.23s system 78% cpu 5.988 total

// With codegen + pre-computing aliases, names
// goos: darwin
// goarch: arm64
// pkg: github.com/pulumi/pulumi-aws/provider/v6
// BenchmarkProvider-10    	      21	  56249544 ns/op
// PASS

func BenchmarkProvider(b *testing.B) {
	for n := 0; n < b.N; n++ {
		Provider()
	}
}
