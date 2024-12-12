import json
import pulumi
import pulumi_aws as aws

kms_policy = aws.get_caller_identity_output().arn.apply(lambda arn: {
    "Version": "2012-10-17",
    "Id": "key-default-1",
    "Statement": [
        {
            "Sid": "Enable IAM User Permissions",
            "Effect": "Allow",
            "Principal": {"AWS": arn},
            "Action": "kms:*",
            "Resource": "*",
        },
        {
            "Sid": "DenyAllExceptRoot",
            "Effect": "Deny",
            "Principal": "*",
            "Action": "kms:Decrypt",
            "Resource": "*"
        }
    ],
})

my_env_key = aws.kms.Key(
    resource_name="my_env_key",
    description="This key is used to encrypt bucket objects",
    deletion_window_in_days=10,
    policy=kms_policy.apply(json.dumps),
)

# Inline Python code for the Lambda function.
lambda_code = """
import os

def handler(event, context):
    my_env_var = os.getenv('MY_ENV_VAR', 'Default Value')
    return f'Hello from Pulumi! The environment variable value is: {my_env_var}'
"""

# Create an IAM role for the Lambda function.
lambda_role = aws.iam.Role(
    "lambdaRole",
    assume_role_policy="""{
        "Version": "2012-10-17",
        "Statement": [{
            "Action": "sts:AssumeRole",
            "Effect": "Allow",
            "Principal": {
                "Service": "lambda.amazonaws.com"
            }
        }]
    }""",
)

# Attach the AWS Lambda basic execution role policy to the IAM role.
role_policy_attachment = aws.iam.RolePolicyAttachment(
    "lambdaRoleAttachment",
    role=lambda_role.name,
    policy_arn="arn:aws:iam::aws:policy/service-role/AWSLambdaBasicExecutionRole",
)

# Create the Lambda function with the inline code.
lambda_function = aws.lambda_.Function(
    "myInlineLambda",
    role=lambda_role.arn,
    runtime="python3.8",
    handler="index.handler",
    code=pulumi.AssetArchive(
        {
            "index.py": pulumi.StringAsset(
                lambda_code
            ),  # set the inline code as an asset
        }
    ),
    kms_key_arn=my_env_key.arn,
    environment=aws.lambda_.FunctionEnvironmentArgs(
        variables={
            "MY_ENV_VAR": '..'
        }
    ),
    # Ensure the Role is attached before creating the lambda
    opts=pulumi.ResourceOptions(depends_on=[role_policy_attachment, my_env_key]),
)

if not pulumi.runtime.is_dry_run():
    def l_invoke(name):
        return aws.lambda_.get_invocation(function_name=name, input="{}").result
    pulumi.export("invocation", lambda_function.name.apply(l_invoke))

# Export the Lambda function name and ARN
pulumi.export("lambda_function_name", lambda_function.name)
pulumi.export("lambda_function_arn", lambda_function.arn)
