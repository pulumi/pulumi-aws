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

// Note: this module is in the

import * as pulumiAws from ".";

// @pulumi/aws (and submodules) is a deployment-only module.  If someone tries to capture it, and we
// fail for some reason we want to give a good message about what the problem likely is.  Note that
// capturing a deployment time module can be ok in some cases.  For example, using "aws.runtime" is
// fine, and will give runtime access to the right awssdk API. This will ensure that those 'safe to
// serialize' values are captured 'by-value' However, in general, the majority of this API is not
// safe to use at 'run time' and will fail.
(<any>pulumiAws).deploymentOnlyModule = true;

// Now, export a 'runtime' property that provides access to the the aws nodejs sdk.  Note that we're
// exporting *both* the value *and* namespace side.  That's why we need `typeof import("aws-sdk")`
// (which gives the entire share of that module).
//
// With this downstream clients can now write the following in an lambda:
//
//      import * as aws from "@pulumi/aws";
//      ...
//      /* inside a lambda now: */
//      const client = new aws.runtime.DynamoDB.DocumentClient(/*opt-args*/);
//
// Inside the serialized lambda for the above, 'runtime' will be a property with a getter function
// that ends up returning `require("aws-sdk")` inside of it.

declare module "." {
    export const runtime: typeof import("aws-sdk");
}

// Now, actually provide the exported members.  Note, we implement the 'runtime' property as a
// 'getter'.  This is actually important so that we're not actually exporting the aws-sdk module
// itself.  If we exported that module, serialization would either try to actually serialize it
// (bad), or it would try to reference it through the aws node_modules path (also bad).  We don't
// want either of these.  Instead, we want the serialized code to literally contain
//
//      `return require("aws-sdk")...`
//
// By defining things in this way, that require ends up having no impact on closure serialization or
// modules-inclusion.  Instead, if just emits code that works correctly in AWS lambda due to
// 'aws-sdk' being a well known node-module that is always available. import * as pulumiDynamoDB
// from "./dynamodb";
Object.defineProperty(pulumiAws, "runtime", {
  get: () => require("aws-sdk"),
})
