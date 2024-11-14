---
subcategory: "IAM (Identity & Access Management)"
layout: "aws"
description: |-
  Pulumi resource for maintaining exclusive management of customer managed policies assigned to an AWS IAM (Identity & Access Management) role.
---

# Resource: aws.iam.RolePolicyAttachmentsExclusive

Pulumi resource for maintaining exclusive management of customer managed policies assigned to an AWS IAM (Identity & Access Management) role.

-> **NOTE:** To reliably detect drift between customer managed policies listed in this resource and actual policies attached to the role in the cloud, you currently need to run Pulumi with `pulumi up --refresh`. See [#4766](https://github.com/pulumi/pulumi-aws/issues/4766) for tracking making this work with regular `pulumi up` invocations.

!> This resource takes exclusive ownership over customer managed policies attached to a role. This includes removal of customer managed policies which are not explicitly configured. To prevent persistent drift, ensure any `aws_iam_role_policy_attachment` resources managed alongside this resource are included in the `policy_arns` argument.

~> Destruction of this resource means Pulumi will no longer manage reconciliation of the configured policy attachments. It __will not__ detach the configured policies from the role.

## Example Usage

### Basic Usage

```terraform
resource "aws_iam_role_policy_attachments_exclusive" "example" {
  role_name   = aws_iam_role.example.name
  policy_arns = [aws_iam_policy.example.arn]
}
```

### Disallow Customer Managed Policies

To automatically remove any configured customer managed policies, set the `policy_arns` argument to an empty list.

~> This will not __prevent__ customer managed policies from being assigned to a role via Pulumi (or any other interface). This resource enables bringing customer managed policy assignments into a configured state, however, this reconciliation happens only when `apply` is proactively run.

```terraform
resource "aws_iam_role_policy_attachments_exclusive" "example" {
  role_name   = aws_iam_role.example.name
  policy_arns = []
}
```

## Argument Reference

The following arguments are required:

* `role_name` - (Required) IAM role name.
* `policy_arns` - (Required) A list of customer managed policy ARNs to be attached to the role. Policies attached to this role but not configured in this argument will be removed.

## Attribute Reference

This resource exports no additional attributes.
