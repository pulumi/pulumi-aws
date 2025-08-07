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
import * as pulumi from '@pulumi/pulumi'
import * as aws from '@pulumi/aws'

const account = aws.getCallerIdentityOutput({}).accountId;
const accountArn = pulumi.interpolate`arn:aws:iam::${account}:root`
const assumableRole = new aws.iam.Role('assumable', {
    assumeRolePolicy: aws.iam.assumeRolePolicyForPrincipal({ AWS: accountArn }),
    managedPolicyArns: [aws.iam.ManagedPolicy.AdministratorAccess],
});

export const roleArn = assumableRole.arn;
