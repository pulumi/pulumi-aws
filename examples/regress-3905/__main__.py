import json
import pulumi
import pulumi_aws as aws

test = aws.batch.JobDefinition("regress-3905",
    name="regress-3905",
    opts=pulumi.ResourceOptions(ignore_changes=["retry_strategy"]), # retry_strategy is suffering from a perma diff if the dict is empty. This is caused by the upstream provider ignoring empty object types
    type="container",
    retry_strategy={}, # empty dict here causes regression 3905
    container_properties=json.dumps({
        "command": [
            "ls",
            "-la",
        ],
        "image": "busybox",
        "resourceRequirements": [
            {
                "type": "VCPU",
                "value": "4",
            },
            {
                "type": "MEMORY",
                "value": "512",
            },
        ],
        "volumes": [{
            "host": {
                "sourcePath": "/tmp",
            },
            "name": "tmp",
        }],
        "environment": [{
            "name": "VARNAME",
            "value": "VARVAL",
        }],
        "mountPoints": [{
            "sourceVolume": "tmp",
            "containerPath": "/tmp",
            "readOnly": False,
        }],
        "ulimits": [{
            "hardLimit": 1024,
            "name": "nofile",
            "softLimit": 1024,
        }],
    }))
