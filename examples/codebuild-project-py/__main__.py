"""An AWS Python Pulumi program"""

import pulumi
from pulumi_aws import codebuild, Provider, iam
import json

repo_url = "https://github.com/edalongeville/pulumi_sample_codebuild.git"

source_credentials = codebuild.SourceCredential(
    resource_name="Github-Credentials",
    auth_type="PERSONAL_ACCESS_TOKEN",
    server_type="GITHUB",
    token="12343sdgqbweetb23",
    opts=pulumi.ResourceOptions(
        delete_before_replace=True,),
)

# Create a role for cicd
cicd_role = iam.Role(
    resource_name="CICD-sample-Role",
    assume_role_policy=json.dumps(
        {
            "Version": "2012-10-17",
            "Statement": [
                {
                    "Effect": "Allow",
                    "Principal": {"Service": ["codebuild.amazonaws.com"]},
                    "Action": "sts:AssumeRole",
                }
            ],
        }
    ),
)

# Create a policy for the cicd role
cicd_policy = iam.RolePolicy(
    resource_name="CICD-sample-policy",
    policy=json.dumps(
        {
            "Version": "2012-10-17",
            "Statement": [
                {
                    "Effect": "Allow",
                    "Action": ["s3:GetBucketLocation", "s3:ListAllMyBuckets"],
                    "Resource": "arn:aws:s3:::*",
                },
                {"Effect": "Allow", "Action": "s3:*",
                 "Resource": ["*"], },
                {"Effect": "Allow", "Action": "lambda:*", "Resource": "*", },
                {"Effect": "Allow", "Action": "logs:*", "Resource": "*", },
            ],
        }
    ),
    role=cicd_role.name
)

# Create a build project
prebuild_project = codebuild.Project(
    resource_name="sample",
    name="sample",
    build_timeout=30,  # In minutes
    artifacts={
        "type": "NO_ARTIFACTS",
    },
    environment={
        "computeType": "BUILD_GENERAL1_SMALL",
        "image": "aws/codebuild/amazonlinux2-x86_64-standard:3.0",
        "imagePullCredentialsType": "CODEBUILD",
        "type": "LINUX_CONTAINER",
        "privilegedMode": True,  # Required to use docker
    },
    service_role=cicd_role.arn,
    source={
        "gitCloneDepth": 1,
        "gitSubmodulesConfig": {"fetchSubmodules": True, },
        "location": repo_url,
        "buildspec": "build.yml",
        "type": "GITHUB",
        "report_build_status": True,
        "auths": [{"type": "OAUTH", "resource": source_credentials.arn, }],
    },
)
