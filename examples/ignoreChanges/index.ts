// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const bucket = new aws.s3.Bucket("mybucket", {
    bucketPrefix: "foo"
}, { ignoreChanges: ["bucketPrefix"]});