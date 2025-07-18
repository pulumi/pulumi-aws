# Copyright 2016-2018, Pulumi Corporation.  All rights reserved.

from pulumi_aws import iam

iam.Role(
    "role",
    assume_role_policy=iam.PolicyDocumentArgs(
        version=iam.PolicyDocumentVersion.POLICY_DOCUMENT_VERSION_2012_10_17,
        statement=[
            iam.PolicyStatementArgs(
                effect=iam.PolicyStatementEffect.ALLOW,
                action="sts:AssumeRole",
                principal=iam.ServicePrincipalArgs(service="lambda.amazonaws.com"),
            )
        ],
    ),
)
