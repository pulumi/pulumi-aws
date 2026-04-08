// Copyright 2016-2018, Pulumi Corporation.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

import * as pulumi from "@pulumi/pulumi";
// Import the nested module directly to regression test:
// https://github.com/pulumi/pulumi-aws/issues/772
import { Bucket } from "@pulumi/aws/s3";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const bucket = new Bucket("testbucket", {
    serverSideEncryptionConfiguration: {
        rule: {
            applyServerSideEncryptionByDefault: {
                sseAlgorithm: "AES256",
            },
        },
    },
    forceDestroy: true,
}, providerOpts);

bucket.onObjectCreated("bucket-callback", async (event) => {
    const records = event.Records || [];
    for (const record of records) {
        console.log(`Object created: ${record.s3.object.key} (${record.s3.object.size} bytes)`);
    }
});

// Another bucket with some strongly-typed routingRules.
const websiteBucket = new aws.s3.Bucket("websiteBucket", {
    website: {
        indexDocument: "index.html",
        routingRules: [{
            Condition: {
                KeyPrefixEquals: "docs/",
            },
            Redirect: {
                ReplaceKeyPrefixWith: "documents/",
            }
        }]
    }
}, providerOpts);

export const bucketName = bucket.id;