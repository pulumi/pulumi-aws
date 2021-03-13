# Copyright 2016-2020, Pulumi Corporation.  All rights reserved.

import pulumi
from pulumi_aws import sqs

queue = sqs.Queue('demo',
    fifo_queue=True)

pulumi.export('name', queue.name)
