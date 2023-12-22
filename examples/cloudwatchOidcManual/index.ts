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
import * as aws from "@pulumi/aws";
import * as gh from "@actions/core";

const config = new pulumi.Config("aws");
const providerOpts = {
    provider: new aws.Provider("prov", {
        region: <aws.Region>config.require("envRegion"),
        assumeRoleWithWebIdentity: {
            roleArn: process.env["OIDC_ROLE_ARN"],
            webIdentityToken: gh.getIDToken("sts.amazonaws.com"),
            sessionName: "cloudwatchOidcManual-githubActions",
        },
    })
};

const event = aws.cloudwatch.onSchedule("everyMinute", "rate(1 minute)", async (event) => {
    console.log("Received event: " + JSON.stringify(event, null, 2));
}, {}, providerOpts);
