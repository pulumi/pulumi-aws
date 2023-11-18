package provider

import "os"

func init() {
	os.Setenv("PULUMI_REPO_PATHS", "github.com/hashicorp/terraform-provider-aws=./upstream")
}
