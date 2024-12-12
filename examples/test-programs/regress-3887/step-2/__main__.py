import json
import pulumi_aws as aws

test = aws.batch.JobDefinition(
    "test",
    name="my_test_batch_job_definition",
    type="container",
    container_properties=json.dumps(
        {
            "command": [
                "ls",
                "-la",
            ],
            "image": "busybox",
            "resourceRequirements": [
                {
                    "type": "VCPU",
                    "value": "3",
                },
                {
                    "type": "MEMORY",
                    "value": "512",
                },
            ],
            "volumes": [
                {
                    "host": {
                        "sourcePath": "/tmp",
                    },
                    "name": "tmp",
                }
            ],
            "environment": [
                {
                    "name": "VARNAME",
                    "value": "VARVAL",
                }
            ],
            "mountPoints": [
                {
                    "sourceVolume": "tmp",
                    "containerPath": "/tmp",
                    "readOnly": False,
                }
            ],
            "ulimits": [
                {
                    "hardLimit": 1024,
                    "name": "nofile",
                    "softLimit": 1024,
                }
            ],
        }
    ),
)
