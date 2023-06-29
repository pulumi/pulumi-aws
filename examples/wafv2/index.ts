// Copyright 2016-2023, Pulumi Corporation.

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

new aws.wafv2.RuleGroup("waf", {
    description: "RuleGroup for general purposes",
    scope: "REGIONAL",
    visibilityConfig: {
        cloudwatchMetricsEnabled: false,
        metricName: "metric",
        sampledRequestsEnabled: false,
    },
    capacity: 500,
    rules: [{
        name: 'rule-1',
        action: {
            block: {},
        },
        priority: 1,
        statement: {
            notStatement: {
                statements: [{
                    andStatement: {
                        statements: [
                            {
                                geoMatchStatement: {
                                    countryCodes: ["US"]
                                },
                            },
                            {
                                byteMatchStatement: {
                                    positionalConstraint: "CONTAINS",
                                    searchString: "word",
                                    fieldToMatch: {
                                        allQueryArguments: {}
                                    },
                                    textTransformations: [{
                                        priority: 5,
                                        type: "CMD_LINE",
                                    }, {
                                        priority: 2,
                                        type: "LOWERCASE",
                                    }],
                                },
                            },
                        ],
                    },
                }],
            },
        },
        visibilityConfig: {
            cloudwatchMetricsEnabled: false,
            metricName: 'rule-1',
            sampledRequestsEnabled: false,
        },
    }],
}, providerOpts);
