// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/pulumi/terraform-bridge/pkg/tfbridge"

	"github.com/pulumi/aws"
)

func main() {
	tfbridge.Main("aws", aws.Provider())
}
