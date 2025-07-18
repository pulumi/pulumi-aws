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

const example_zone = new aws.route53.Zone("example.com", {}, providerOpts);

const www_dev = new aws.route53.Record("www-dev", {
    name: "www",
    records: ["dev.example.com"],
    setIdentifier: "dev",
    ttl: 5,
    type: aws.route53.RecordType.CNAME,
    weightedRoutingPolicies: [{
        weight: 10,
    }],
    zoneId: example_zone.zoneId,
}, providerOpts);
