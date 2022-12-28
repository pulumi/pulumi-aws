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

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const eventBusHealth = new aws.cloudwatch.EventBus("health", {}, providerOpts);
const ec2IssueEventRule = new aws.cloudwatch.EventRule("ec2-issue", {
  description: "Trigger Lambda to respond to EC2 issue events",
  eventPattern: JSON.stringify({
    source: ["aws.health"],
    "detail-type": ["AWS Health Event"],
    detail: {
      service: ["EC2"],
      eventTypeCategory: ["issue"],
    },
  }),
  eventBusName: eventBusHealth.name,
}, providerOpts);

ec2IssueEventRule.onEvent("ec2-issue", (event) => {
  console.log(event);
}, providerOpts);

