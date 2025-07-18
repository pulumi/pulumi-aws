# Copyright 2016-2018, Pulumi Corporation.  All rights reserved.

from pulumi_aws import s3

web_bucket = s3.Bucket("s3-py-bucket")
