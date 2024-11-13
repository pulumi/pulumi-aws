// Copyright 2016-2024, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package iam

import (
	"github.com/hashicorp/terraform-plugin-sdk/v2/helper/schema"
	"github.com/pulumi/pulumi/sdk/v3/go/common/util/contract"
)

// Customize resources in the IAM module.
func ReconfigureResources(p *schema.Provider) {
	iamRoleReconfigure(p)
}

func iamRoleReconfigure(p *schema.Provider) {
	iamRole, ok := p.ResourcesMap["aws_iam_role"]
	contract.Assertf(ok, "Expected to find an aws_iam_role resource")

	// TODO[pulumi/pulumi-aws#4654] there are still some issues with Exclusive Management Resources that affect
	// Pulumi especially poorly, impacting the upgrade path for Pulumi users attempting to address the deprecation
	// of inlinePolicy and managedPolicyArns. Until these are sorted out, deprecation notices are removed from
	// the Pulumi AWS provider.
	inlinePolicy, ok := iamRole.Schema["inline_policy"]
	contract.Assertf(ok, "Expected an inline_policy parameter on the aws_iam_role resource")
	inlinePolicy.Deprecated = ""

	managedPolicyArns, ok := iamRole.Schema["managed_policy_arns"]
	contract.Assertf(ok, "Expected an managed_policy_arns parameter on the aws_iam_role resource")
	managedPolicyArns.Deprecated = ""
}
