// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-terraform/pkg/tfbridge"

	"github.com/pulumi/pulumi-aws"
	"github.com/pulumi/pulumi-aws/pkg/version"
)

func main() {
	tfbridge.Main("aws", version.Version, aws.Provider())
}
