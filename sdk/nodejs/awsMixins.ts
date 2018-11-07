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

import * as pulumiAws from ".";

// @pulumi/aws (and submodules) are deployment-only module.  If someone tries to capture it, and we
// fail for some reason we want to give a good message about what the problem likely is.  Note that
// capturing a deployment time module can be ok in some cases.  For example, using
// "aws.dynamodb.runtime" is fine, and will give runtime access to the right awssdk API. This will
// ensure that those 'safe to serialize' values are cpatured 'by-value' However, in general, the
// majority of this API is not safe to use at 'run time' and will fail.
(<any>pulumiAws).deploymentOnlyModule = true;

// Mark submodules as well.
for (const key in pulumiAws) {
    if (pulumiAws.hasOwnProperty(key) && pulumiAws[key]) {
        pulumiAws[key].deploymentOnlyModule = true;
    }
}

// Now, go through all our @pulumi/aws/xxx submodules and export a 'runtime' property that provides
// access to the relevant sub-module/namespace from the awssdk.  Note that we're exporting *both*
// the value *and* namespace side.  That's why we need both `typeof import("aws-sdk")` (which gives
// the entire share of that module), as well as types like `awsSdkType["DynamoDB"]` which gets the
// entire shape of that submember.
//
// With this downstream clients can now write the following in an lambda:
//
//      import * as aws from "@pulumi/aws";
//      ...
//      /* inside a lambda now: */
//      const client = new aws.dynamodb.runtime.DocumentClient(/*opt-args*/);
//
// Inside the serialized lambda for the above, 'runtime' will be a property with a getter that ends
// up returning `require("aws-sdk").DynamoDB`, which is the right aws-sdk submodule that corresponds
// to the @pulumi/aws 'dynamodb' submodule.
type awsSdkType = typeof import("aws-sdk");

declare module "./dynamodb" {
    export const runtime: awsSdkType["DynamoDB"];
}

declare module "./s3" {
    export const runtime: awsSdkType["S3"];
}

declare module "./sns" {
    export const runtime: awsSdkType["SNS"];
}

// Now, actually provide the exported members.  Note, we implement the 'runtime' properties as
// 'getters'.  This is actually important so that we're not actually exporting an aws-sdk submodule
// here.  If we exported that module, serialization would either try to actually serialize it (bad),
// or it would try to reference it through the aws node_modules path (also bad).  We don't want
// either of these.  Instead, we want the serialized code to literally contain
//
//      `return require("aws-sdk")...`
//
// By defining things in this way, that require ends up having no impact on closure serialization or
// modules-inclusion.  Instead, if just emits code that works correctly in AWS lambda due to 'aws-sdk'
// being a well known node-module that is always available.
import * as pulumiDynamoDB from "./dynamodb";
Object.defineProperty(pulumiDynamoDB, "runtime", {
  get: () => require("aws-sdk").DynamoDB,
})

import * as pulumiS3 from "./s3";
Object.defineProperty(pulumiS3, "runtime", {
  get: () => require("aws-sdk").S3,
})

import * as pulumiSns from "./sns";
Object.defineProperty(pulumiSns, "runtime", {
  get: () => require("aws-sdk").SNS,
})
