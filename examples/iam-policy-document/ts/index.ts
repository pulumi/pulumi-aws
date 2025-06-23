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

// Comprehensive PolicyDocument test program
// Tests all possible combinations of fields for backwards compatibility testing

import * as pulumi from '@pulumi/pulumi'
import * as aws from '@pulumi/aws'

const account = aws.getCallerIdentityOutput().accountId;
const bucket = new aws.s3.Bucket('test-bucket');

const assumeRolePolicyDoc: aws.iam.PolicyDocument = {
    Version: '2012-10-17',
    Id: 'comprehensive-policy-id',
    Statement: [
        {
            Sid: 'AllowAWSPrincipal',
            Effect: 'Allow',
            Action: 'sts:AssumeRole',
            Principal: {
                AWS: [
                    pulumi.interpolate`arn:aws:iam::${account}:root`,
                ]
            }
        },
    ]
};

const baseRole = new aws.iam.Role('base-role', {
    assumeRolePolicy: assumeRolePolicyDoc,
});

const statement1: aws.iam.PolicyStatement = {
    Sid: 'AllowAWSPrincipal',
    Effect: 'Allow',
    Action: 'sts:AssumeRole',
    Principal: {
        AWS: [
            pulumi.interpolate`arn:aws:iam::${account}:root`,
            baseRole.arn,
        ]
    }
};

// Test 1: Complete PolicyDocument with all optional fields
const comprehensiveRole = new aws.iam.Role('comprehensive-role', {
    assumeRolePolicy: {
        Version: '2012-10-17',
        Id: 'comprehensive-policy-id',
        Statement: [
            // Test all Principal types
            statement1,
            {
                Sid: 'AllowServicePrincipal',
                Effect: 'Allow',
                Action: 'sts:AssumeRole',
                Principal: {
                    Service: ['lambda.amazonaws.com', 'ec2.amazonaws.com']
                }
            },
            {
                Sid: 'AllowFederatedPrincipal',
                Effect: 'Allow',
                Action: 'sts:AssumeRole',
                Principal: {
                    Federated: 'arn:aws:iam::123456789012:saml-provider/ExampleProvider'
                }
            },
        ]
    }
});

// Test 2: Policy with all statement field combinations
new aws.iam.RolePolicy('comprehensive-policy', {
    role: comprehensiveRole.name,
    policy: {
        Version: '2012-10-17',
        Id: 'test-policy-document-id',
        Statement: [
            // Test 2a: Action vs NotAction
            {
                Sid: 'ActionArrayTest',
                Effect: 'Allow',
                Action: [
                    's3:GetObject',
                    's3:PutObject',
                    's3:DeleteObject'
                ],
                Resource: pulumi.interpolate`${bucket.arn}/*`
            },
            {
                Sid: 'ActionStringTest',
                Effect: 'Allow',
                Action: 's3:ListBucket',
                Resource: bucket.arn
            },
            {
                Sid: 'NotActionTest',
                Effect: 'Deny',
                NotAction: [
                    's3:GetObject',
                    's3:PutObject'
                ],
                Resource: bucket.arn
            },
            // Test 2b: Resource vs NotResource
            {
                Sid: 'ResourceArrayTest',
                Effect: 'Allow',
                Action: 's3:GetObject',
                Resource: [
                    pulumi.interpolate`${bucket.arn}/*`,
                    pulumi.interpolate`${bucket.arn}/public/*`
                ]
            },
            {
                Sid: 'ResourceStringTest',
                Effect: 'Allow',
                Action: 's3:GetBucketLocation',
                Resource: bucket.arn
            },
            {
                Sid: 'NotResourceTest',
                Effect: 'Deny',
                Action: 's3:DeleteObject',
                NotResource: pulumi.interpolate`${bucket.arn}/protected/*`
            },
            // Test 2d: Complex Conditions with various operators
            {
                Sid: 'ComplexConditionsTest',
                Effect: 'Allow',
                Action: 's3:GetObject',
                Resource: pulumi.interpolate`${bucket.arn}/*`,
                Condition: {
                    // String conditions
                    StringEquals: {
                        'aws:RequestTag/environment': 'production',
                        's3:ExistingObjectTag/classification': ['public', 'internal']
                    },
                    StringLike: {
                        's3:prefix': ['${aws:username}/*', 'public/*']
                    },
                    StringNotEquals: {
                        'aws:RequestTag/team': 'external'
                    },
                    // Numeric conditions
                    NumericGreaterThan: {
                        's3:max-keys': '100'
                    },
                    NumericLessThanEquals: {
                        's3:object-size': '1048576'
                    },
                    // Date conditions
                    DateGreaterThan: {
                        'aws:RequestTime': '2023-01-01T00:00:00Z'
                    },
                    DateLessThan: {
                        'aws:RequestTime': '2025-01-01T00:00:00Z'
                    },
                    // Boolean conditions
                    Bool: {
                        'aws:MultiFactorAuthPresent': 'true',
                        'aws:SecureTransport': 'true'
                    },
                    // IP address conditions
                    IpAddress: {
                        'aws:SourceIp': ['203.0.113.0/24', '2001:DB8:1234:5678::/64']
                    },
                    IpAddressIfExists: {
                        'aws:SourceIp': '203.0.113.0/24'
                    },
                    // ARN conditions
                    ArnEquals: {
                        'aws:SourceArn': pulumi.interpolate`arn:aws:s3:::${bucket.id}`
                    },
                    ArnLike: {
                        'aws:SourceArn': 'arn:aws:s3:::example-*'
                    },
                    // Null conditions
                    Null: {
                        'aws:RequestTag/environment': 'false'
                    },
                    // ForAllValues and ForAnyValue conditions
                    'ForAllValues:StringEquals': {
                        'aws:RequestTag/team': ['dev', 'ops']
                    },
                    'ForAnyValue:StringLike': {
                        's3:object-tag-keys': ['environment', 'team']
                    }
                }
            },
        ]
    }
});

new aws.s3.BucketPolicy('bucket-policy', {
    bucket: bucket.id,
    policy: {
        Version: '2012-10-17',
        Statement: [
            {
                Sid: 'PrincipalTest',
                Effect: 'Allow',
                Action: 's3:GetObject',
                Principal: {
                    AWS: pulumi.interpolate`arn:aws:iam::${account}:root`
                },
                Resource: pulumi.interpolate`${bucket.arn}/*`,
            },
            {
                Sid: 'NotPrincipalTest',
                Effect: 'Deny',
                Action: 's3:ListBucket',
                NotPrincipal: {
                    AWS: [
                        baseRole.arn,
                        pulumi.interpolate`arn:aws:iam::${account}:root`
                    ],
                },
                Resource: bucket.arn
            },
            // Single vs array consistency tests
            {
                Effect: 'Allow',
                Action: 's3:ListBucket', // Single string
                Resource: bucket.arn,   // Single string
                Principal: {
                    Service: 'lambda.amazonaws.com' // Single string
                }
            },
            {
                Effect: 'Allow',
                Action: ['s3:ListBucket'], // Array with single element
                Resource: [bucket.arn],   // Array with single element
                Principal: {
                    Service: ['lambda.amazonaws.com'] // Array with single element
                }
            },
            // Test 2f: Deny effect with all fields
            {
                Sid: 'ComprehensiveDenyTest',
                Effect: 'Deny',
                Action: 's3:GetObject',
                NotPrincipal: {
                    AWS: [
                        baseRole.arn,
                        pulumi.interpolate`arn:aws:iam::${account}:root`
                    ],
                },
                NotResource: pulumi.interpolate`${bucket.arn}/logs/*`,
            }
        ]
    }
});

// Test 3: Edge cases and boundary conditions
new aws.iam.RolePolicy('edge-cases-policy', {
    role: comprehensiveRole.name,
    policy: {
        Version: '2008-10-17', // Test older version
        Statement: [
            // Single vs array consistency tests
            {
                Effect: 'Allow',
                Action: ['s3:GetObject'], // Array with single element
                Resource: [bucket.arn],   // Array with single element
            },
            // Test 2f: Deny effect with all fields
            {
                Sid: 'ComprehensiveDenyTest',
                Effect: 'Deny',
                NotAction: 's3:GetBucketLocation',
                NotResource: pulumi.interpolate`${bucket.arn}/logs/*`,
                Condition: {
                    StringNotEquals: {
                        'aws:RequestTag/approved': 'true'
                    }
                }
            }
        ]
    }
});

// Test 4: Policy with dynamic values and interpolations
const dynamicBucket = new aws.s3.Bucket('dynamic-bucket');
new aws.iam.RolePolicy('dynamic-policy', {
    role: comprehensiveRole.name,
    policy: {
        Version: '2012-10-17',
        Statement: [
            {
                Effect: 'Allow',
                Action: 's3:*',
                Resource: [
                    dynamicBucket.arn,
                    pulumi.interpolate`${dynamicBucket.arn}/*`
                ],
                Condition: {
                    StringEquals: {
                        's3:ExistingBucketName': dynamicBucket.id
                    }
                }
            }
        ]
    }
});

const repo = new aws.ecr.Repository('ecr');
new aws.ecr.RepositoryPolicy('ecr-policy', {
    repository: repo.name,
    policy: {
        Id: 'RepoPolicy',
        Version: '2012-10-17',
        Statement: [{
            Sid: 'AllowStatement',
            Effect: 'Allow',
            Principal: {
                AWS: pulumi.interpolate`arn:aws:iam::${account}:root`,
            },
            Action: [
                "ecr:GetDownloadUrlForLayer",
                "ecr:BatchGetImage",
                "ecr:BatchCheckLayerAvailability"
            ]
        }]
    }
});

const topic = new aws.sns.Topic('topic');
new aws.sns.TopicPolicy('policy', {
    arn: topic.arn,
    policy: {
        Version: '2012-10-17',
        Statement: [{
            Action: 'sns:Publish',
            Effect: 'Allow',
            Resource: topic.arn,
            Principal: {
                AWS: baseRole.arn,
            },
        }],
    }
});

const queue = new aws.sqs.Queue('queue');
new aws.sqs.QueuePolicy('q-policy', {
    queueUrl: queue.url,
    policy: {
        Version: '2012-10-17',
        Statement: [{
            Effect: 'Allow',
            Action: 'sqs:SendMessage',
            Principal: { AWS: baseRole.arn },
            Resource: queue.arn,

        }],
    }
});

// Export resources for testing
export const testRole = comprehensiveRole.arn;
export const testBucket = bucket.arn;
export const dynamicBucketArn = dynamicBucket.arn;
