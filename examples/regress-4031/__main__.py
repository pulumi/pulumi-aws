import pulumi
import pulumi_aws


role = pulumi_aws.iam.Role(
    "test-role",
    assume_role_policy=pulumi_aws.iam.get_policy_document(
        statements=[
            pulumi_aws.iam.GetPolicyDocumentStatementArgs(
                actions=["sts:AssumeRole"],
                principals=[
                    pulumi_aws.iam.GetPolicyDocumentStatementPrincipalArgs(
                        type="Service",
                        identifiers=["ecs-tasks.amazonaws.com"],
                    ),
                ],
            ),
        ],
    ).json,
    inline_policies=[
        pulumi_aws.iam.RoleInlinePolicyArgs(
            name="bucket1",
            policy=pulumi_aws.iam.get_policy_document(
                statements=[
                    pulumi_aws.iam.GetPolicyDocumentStatementArgs(
                        actions=["s3:GetObject"],
                        resources=["arn:aws:s3:::bucket1/*"],
                    ),
                ],
            ).json,
        ),
        pulumi_aws.iam.RoleInlinePolicyArgs(
            name="bucket2",
            policy=pulumi_aws.iam.get_policy_document(
                statements=[
                    pulumi_aws.iam.GetPolicyDocumentStatementArgs(
                        actions=["s3:GetObject"],
                        resources=["arn:aws:s3:::bucket2/*"],
                    ),
                ],
            ).json,
        ),
    ],
)

pulumi.export("roleName", role.name)
