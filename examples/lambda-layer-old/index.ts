// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";
import { asset } from "@pulumi/pulumi";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

let layer = new aws.lambda.LayerVersion("my-layer-version", {
    code: new asset.AssetArchive({
        "index.js": new asset.StringAsset(
            "exports.handler = (e, c, cb) => cb(null, {statusCode: 200, body: 'Hello, world!'});",
        ),
    }),
    compatibleRuntimes: [
        aws.lambda.NodeJS10dXRuntime,
        aws.lambda.NodeJS12dXRuntime,
    ],
    layerName: "lambda_layer_name",
}, providerOpts);

export let layerSize = layer.sourceCodeSize;
export let layerArn = layer.arn;
