// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as aws from "@pulumi/aws";
import * as pulumi from "@pulumi/pulumi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const bucket = new aws.s3.BucketV2("mybucket", {
    bucketPrefix: "bar"
}, { ignoreChanges: ["bucketPrefix"], provider: providerOpts.provider });
