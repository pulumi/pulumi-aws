"use strict";
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
var __awaiter = (this && this.__awaiter) || function (thisArg, _arguments, P, generator) {
    return new (P || (P = Promise))(function (resolve, reject) {
        function fulfilled(value) { try { step(generator.next(value)); } catch (e) { reject(e); } }
        function rejected(value) { try { step(generator["throw"](value)); } catch (e) { reject(e); } }
        function step(result) { result.done ? resolve(result.value) : new P(function (resolve) { resolve(result.value); }).then(fulfilled, rejected); }
        step((generator = generator.apply(thisArg, _arguments || [])).next());
    });
};
Object.defineProperty(exports, "__esModule", { value: true });
const aws = require("@pulumi/aws");
const bucket = new aws.s3.Bucket("testbucket", {
    serverSideEncryptionConfiguration: {
        rule: {
            applyServerSideEncryptionByDefault: {
                sseAlgorithm: "AES256",
            },
        },
    },
    forceDestroy: true,
});
const queue = new aws.sqs.Queue("queue", {
    visibilityTimeoutSeconds: 300,
});
queue.onEvent("subscription", (event) => __awaiter(this, void 0, void 0, function* () {
    console.log("Received: " + JSON.stringify(event, null, 2));
    const awssdk = yield Promise.resolve().then(() => require("aws-sdk"));
    const s3 = new awssdk.S3();
    const recordFile = "lastEvent.json";
    console.log("Storing sqs message to S3.");
    yield s3.putObject({
        Bucket: bucket.id.get(),
        Key: recordFile,
        Body: JSON.stringify(event),
    }).promise();
    console.log("Stored sqs message to S3.");
}), { batchSize: 1 });
exports.queueUrl = queue.id;
exports.bucketUrl = bucket.id.apply(id => `s3://${id}`);
//# sourceMappingURL=index.js.map