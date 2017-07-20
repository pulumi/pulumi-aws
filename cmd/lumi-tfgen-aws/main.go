// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/terraform-bridge/pkg/tfgen"

	"github.com/pulumi/aws"
)

func main() {
	tfgen.Main("aws", aws.Provider())
}
