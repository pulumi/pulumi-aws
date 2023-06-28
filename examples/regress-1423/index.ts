// Copyright 2016-2023, Pulumi Corporation.
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

import * as aws from "@pulumi/aws";

new aws.wafv2.WebAcl("web-acl", {
  defaultAction: {
    block: {},
  },
  scope: "REGIONAL",
  visibilityConfig: {
    cloudwatchMetricsEnabled: false,
    metricName: "josh-test",
    sampledRequestsEnabled: true,
  },
  rules: [{
    name: "test-aws-rules",
    overrideAction: {
      count: {},
    },
    priority: 1,
    statement: {
      managedRuleGroupStatement: {
        vendorName: "AWS",
        name: "AWSManagedRulesCommonRuleSet",
        version: "Version_1.3",
      },
    },
    visibilityConfig: {
      cloudwatchMetricsEnabled: false,
      metricName: "test-aws-rules",
      sampledRequestsEnabled: true,
    }
  }]
});
