"""An AWS Python Pulumi program"""

import pulumi
import pulumi_aws as aws
import pulumi_awsx as awsx
import json


vpc = awsx.ec2.Vpc(
    "vpc",
    cidr_block="172.16.0.0/16",
)


sg = aws.ec2.SecurityGroup(
    "security-group",
    vpc_id=vpc.vpc_id,
    egress=[
        aws.ec2.SecurityGroupEgressArgs(
            description="Allow all outbound traffic",
            from_port=0,
            to_port=0,
            protocol="-1",
            cidr_blocks=["0.0.0.0/0"],
        )
    ],
)

role = aws.iam.Role(
    "role",
    assume_role_policy=json.dumps(
        {
            "Version": "2012-10-17",
            "Statement": [
                {
                    "Effect": "Allow",
                    "Action": "sts:AssumeRole",
                    "Principal": {"Service": "batch.amazonaws.com"},
                }
            ],
        }
    ),
    managed_policy_arns=["arn:aws:iam::aws:policy/service-role/AWSBatchServiceRole"],
)

compute = aws.batch.ComputeEnvironment(
    "arm64",
    compute_environment_name_prefix="arm64",
    type="MANAGED",
    service_role=role.arn,
    compute_resources=aws.batch.ComputeEnvironmentComputeResourcesArgs(
        max_vcpus=10,
        security_group_ids=[sg.id],
        subnets=vpc.private_subnet_ids,
        type="FARGATE",
    ),
)

job_queue = aws.batch.JobQueue(
    "arm64",
    state="ENABLED",
    priority=10,
    compute_environments=[compute.arn],
)

# Create a log group for the job.
log_group = aws.cloudwatch.LogGroup("arm64", retention_in_days=7)

# Create an AWS Batch job definition.
job_execution_role = aws.iam.Role(
    "job-execution-role",
    assume_role_policy=json.dumps(
        {
            "Version": "2012-10-17",
            "Statement": [
                {
                    "Effect": "Allow",
                    "Action": "sts:AssumeRole",
                    "Principal": {"Service": "ecs-tasks.amazonaws.com"},
                }
            ],
        }
    ),
    managed_policy_arns=[
        "arn:aws:iam::aws:policy/service-role/AmazonECSTaskExecutionRolePolicy"
    ],
)

job_role = aws.iam.Role(
    "arm64-job-role",
    assume_role_policy=json.dumps(
        {
            "Version": "2012-10-17",
            "Statement": [
                {
                    "Effect": "Allow",
                    "Action": "sts:AssumeRole",
                    "Principal": {"Service": "ecs-tasks.amazonaws.com"},
                }
            ],
        }
    ),
)

job_definition = aws.batch.JobDefinition(
    "batch-arm64",
    type="container",
    platform_capabilities=["FARGATE"],
    container_properties=pulumi.Output.all(
        execution_role=job_execution_role.arn,
        job_role=job_role.arn,
        log_group=log_group.name,
    ).apply(
        lambda args: json.dumps(
            {
                "image": "arm64v8/hello-world",
                "logConfiguration": {
                    "logDriver": "awslogs",
                    "options": {"awslogs-group": args["log_group"]},
                },
                "fargatePlatformConfiguration": {"platformVersion": "LATEST"},
                "runtimePlatform": {
                    "operatingSystemFamily": "LINUX",
                    "cpuArchitecture": "ARM64",
                },
                "resourceRequirements": [
                    {"type": "VCPU", "value": "0.25"},
                    {"type": "MEMORY", "value": "512"},
                ],
                "executionRoleArn": args["execution_role"],
                "jobRoleArn": args["job_role"],
            }
        )
    ),
    timeout=aws.batch.JobDefinitionTimeoutArgs(attempt_duration_seconds=600),
    propagate_tags=True,
)

# Export stack outputs.
pulumi.export("job_definition", job_definition.name)
pulumi.export("job_queue", job_queue.name)
