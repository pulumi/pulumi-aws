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
import * as aws from "@pulumi/aws";
import { CannedAcl } from "@pulumi/aws/s3";
import * as pulumi from '@pulumi/pulumi';

// AWS Provider
const awsProvider = new aws.Provider("aws", { });

// IAM Role for replication
const replication = new aws.iam.Role("replication", {
    assumeRolePolicy: {
      Version: "2012-10-17",
      Statement: [
        {
          Action: "sts:AssumeRole",
          Principal: {
            Service: "s3.amazonaws.com"
          },
          Effect: "Allow",
          Sid: ""
        }
      ]
    },
}, { provider: awsProvider });


// Destination bucket
const destinationBucket = new aws.s3.BucketV2("destinationBucket", {
    forceDestroy: true,
    versionings: [{ enabled: true }],
}, { provider: awsProvider });

// Logging bucket
const loggingBucket = new aws.s3.BucketV2("loggingBucket", {
    forceDestroy: true,
}, { provider: awsProvider });

// Ownership controls for logging bucket
const exampleBucketOwnershipControls = new aws.s3.BucketOwnershipControls("exampleBucketOwnershipControls", {
    bucket: loggingBucket.id,
    rule: { objectOwnership: "BucketOwnerPreferred" },
}, { provider: awsProvider });

new aws.s3.BucketAclV2("exampleBucketAcl", {
    bucket: loggingBucket.id,
    acl: 'log-delivery-write',
}, { dependsOn: [exampleBucketOwnershipControls]});

// Migration bucket
const migrationBucket = new aws.s3.BucketV2("migrationBucket", {
    forceDestroy: true,
    acl: CannedAcl.Private,
    serverSideEncryptionConfigurations: [{
        rules: [{
            applyServerSideEncryptionByDefaults: [{
                sseAlgorithm: "AES256",
            }],
        }],
    }],
    corsRules: [{
        allowedHeaders: ["*"],
        allowedMethods: ["PUT", "POST"],
        allowedOrigins: ["https://s3-website-test.mydomain.com"],
        exposeHeaders: ["ETag"],
        maxAgeSeconds: 3000,
    }],
    lifecycleRules: [
        {
            id: "noncurrent",
            enabled: true,
            expirations: [{ days: 30 }],
            noncurrentVersionExpirations: [{ days: 30 }],
        },
        {
            id: "log",
            enabled: true,
            prefix: "log/",
            tags: {
                rule: "log",
                autoclean: "true",
            },
            transitions: [{
                days: 30,
                storageClass: "STANDARD_IA",
            }],
        },
    ],
    loggings: [{
        targetBucket: loggingBucket.bucket,
        targetPrefix: "/log",
    }],
    websites: [{
        indexDocument: "index.html",
        errorDocument: "error.html",
        routingRules: `[{
          "Condition": {
            "KeyPrefixEquals": "docs"
          },
          "Redirect": {
            "ReplaceKeyPrefixWith": "documents/"
          }
        }]`,
    }],
    versionings: [{ enabled: true }],
    replicationConfigurations: [{
        role: replication.arn,
        rules: [{
            id: "foobar",
            status: "Disabled",
            filters: [{ tags: {} }],
            destinations: [{
                bucket: destinationBucket.arn,
                replicationTimes: [{
                    status: "Disabled",
                    minutes: 15,
                }],
                metrics: [{
                    status: "Disabled",
                    minutes: 15,
                }],
            }],
        }],
    }],
}, { provider: awsProvider });

// IAM Policy for replication
const replicationPolicy = new aws.iam.Policy("replication", {
    policy: {
      Version: "2012-10-17",
      Statement: [
        {
          Action: [
            "s3:GetReplicationConfiguration",
            "s3:ListBucket"
          ],
          Effect: "Allow",
          Resource: [
            pulumi.interpolate`${migrationBucket.arn}`
          ]
        },
        {
          Action: [
            "s3:GetObjectVersionForReplication",
            "s3:GetObjectVersionAcl",
            "s3:GetObjectVersionTagging"
          ],
          Effect: "Allow",
          Resource: [
            pulumi.interpolate`${migrationBucket.arn}/*`
          ]
        },
        {
          Action: [
            "s3:ReplicateObject",
            "s3:ReplicateDelete",
            "s3:ReplicateTags"
          ],
          Effect: "Allow",
          Resource: pulumi.interpolate`${destinationBucket.arn}/*`
        }
      ]
    },
}, { provider: awsProvider });

// Attach policy to role
const replicationRolePolicyAttachment = new aws.iam.RolePolicyAttachment("replication", {
    role: replication.name,
    policyArn: replicationPolicy.arn,
}, { provider: awsProvider });
