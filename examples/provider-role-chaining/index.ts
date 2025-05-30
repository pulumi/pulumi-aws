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

// Original repro in https://github.com/pulumi/pulumi-aws/issues/2818
// Unfortunately CI cannot currently test aws.organizations.Account due to lack of permissions.
// The trimmed down repro simply tries to pass an unknown into assumeRole.
// It only works through preview.

import * as pulumi from '@pulumi/pulumi'
import * as aws from '@pulumi/aws'
import * as ccapi from '@pulumi/aws-native';


const account = aws.getCallerIdentityOutput({}).accountId;
const accountArn = pulumi.interpolate`arn:aws:iam::${account}:root`
const baseRole = new ccapi.iam.Role('base-role', {
    assumeRolePolicyDocument: {
        Statement: [{
            Action: ['sts:AssumeRole'],
            Effect: 'Allow',
            Principal: {
                AWS: accountArn,
            }
        }]
    },
});


const secondRole = new ccapi.iam.Role('second-role', {
    managedPolicyArns: [
        'arn:aws:iam::aws:policy/AdministratorAccess',
    ],
    assumeRolePolicyDocument: {
        Statement: [{
            Action: ['sts:AssumeRole'],
            Effect: 'Allow',
            Principal: {
                AWS: baseRole.arn,
            }
        }]
    },
});

const rolePolicy = new ccapi.iam.RolePolicy('assume-role', {
    policyDocument: {
        Statement: [{
            Action: ['sts:AssumeRole'],
            Effect: 'Allow',
            Resource: secondRole.arn,
        }]

    },
    roleName: baseRole.roleName.apply(name => name!),
});

const provider = new aws.Provider("provider", {
    // Users role will assume `baseRole` and then `baseRole` will assume `secondRole` which will provision the bucket
    assumeRoles: [
        {roleArn: baseRole.arn},
        {roleArn: secondRole.arn}
    ],
}, { dependsOn: [
    rolePolicy,
]});

new aws.s3.Bucket('bucket', {}, { provider })
