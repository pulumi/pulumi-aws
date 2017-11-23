// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

package main

import (
	"github.com/hashicorp/terraform/helper/logging"

	"github.com/pulumi/pulumi-aws"
	"github.com/pulumi/pulumi-terraform/pkg/tfbridge"
)

func main() {
	// Enable Terraform logging.
	logging.SetOutput()

	tfbridge.Main("aws", aws.Provider())
}
