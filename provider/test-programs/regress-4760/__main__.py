import pulumi
from pulumi_aws import sqs

dlq = sqs.Queue("demo-dlq")
queue = sqs.Queue(
    "demo-queue",
    redrive_policy=pulumi.Output.json_dumps(
        {
            "deadLetterTargetArn": dlq.arn,
            "maxReceiveCount": 2,
        }
    )
)

redrive_allow_policy = sqs.RedriveAllowPolicy(
    "demo",
    queue_url=dlq.id,
    redrive_allow_policy=pulumi.Output.json_dumps(
        {
            "redrivePermission": "byQueue",
            "sourceQueueArns": [queue.arn],
        }
    )
)
