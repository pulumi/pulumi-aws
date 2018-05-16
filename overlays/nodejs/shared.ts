// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import * as pulumi from "@pulumi/pulumi";
import * as iam from "./iam";
import { ARN } from "./arn";
import * as lambda from "./lambda";
import * as utils from "./utils";

// Expose a common infrastructure resource that all our global resources can consider themselves to
// be parented by.  This helps ensure unique URN naming for these guys as tey cannot conflict with
// any other user resource.
class InfrastructureResource extends pulumi.ComponentResource {
    constructor() {
        super("aws-infra:global:infrastructure", "global-infrastructure");
    }
}

let globalInfrastructureResource: InfrastructureResource | undefined;
export function getGlobalInfrastructureResource(): pulumi.Resource {
    if (!globalInfrastructureResource) {
        globalInfrastructureResource = new InfrastructureResource();
    }

    return globalInfrastructureResource;
}

const defaultComputePolicies = [
    iam.AWSLambdaFullAccess,                 // Provides wide access to "serverless" services (Dynamo, S3, etc.)
    iam.AmazonEC2ContainerServiceFullAccess, // Required for lambda compute to be able to run Tasks
];

export const defaultLambdaRolePolicy: iam.PolicyDocument = {
    "Version": "2012-10-17",
    "Statement": [
        {
            "Action": "sts:AssumeRole",
            "Principal": {
                "Service": "lambda.amazonaws.com",
            },
            "Effect": "Allow",
            "Sid": "",
        },
    ],
};

let defaultLambdaRole: iam.Role | undefined;
export function getDefaultLambdaRole(): iam.Role {
    if (!defaultLambdaRole) {
        defaultLambdaRole = new iam.Role("default-lambda-role", {
            assumeRolePolicy: JSON.stringify(defaultLambdaRolePolicy),
        }, { parent: getGlobalInfrastructureResource() });

        const policies = [...defaultComputePolicies];

        for (const policy of policies) {
            // RolePolicyAttachment objects don't have a phyiscal identity, and create/deletes are processed
            // structurally based on the `role` and `policyArn`.  So we need to make sure our Pulumi name matches the
            // structural identity by using a name that includes the role name and policyArn.
            const attachment = new iam.RolePolicyAttachment(utils.sha1hash(policy), {
                role: defaultLambdaRole,
                policyArn: policy,
            }, { parent: this });
        }
    }

    return defaultLambdaRole;
}