// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/pulumi-terraform/pkg/tfbridge"

	"github.com/pulumi/pulumi-aws"
)

func main() {
	tfbridge.Main("aws", aws.Provider())
}
