// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const secret = pulumi.secret(42);
const secret2 = pulumi.secret("cyrus");

const b = new aws.s3.Bucket("b", {}, providerOpts);
const handler = b.onObjectCreated("newobejct", async (ev, ctx) => {
    console.log(secret.get());
    console.log(ev);
    console.log(secret2.get());
    console.log("hello")
}, {}, providerOpts);

export const functionARN = handler.func.arn;
export const bucketName = b.id;