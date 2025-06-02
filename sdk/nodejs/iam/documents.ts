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

import * as inputs from '../types/input';

/**
 * Use the Principal element to specify the user (IAM user, federated user, or assumed-role user), AWS account, AWS
 * service, or other principal entity that is allowed or denied access to a resource. You use the Principal element in
 * the trust policies for IAM roles and in resource-based policies—that is, in policies that you embed directly in a
 * resource. For example, you can embed such policies in an Amazon S3 bucket, an Amazon Glacier vault, an Amazon SNS
 * topic, an Amazon SQS queue, or an AWS KMS customer master key (CMK).
 *
 * Use the Principal element in these ways:
 *
 *     - In IAM roles, use the Principal element in the role's trust policy to specify who can assume the role. For
 *       cross-account access, you must specify the 12-digit identifier of the trusted account.
 *
 *       Note: After you create the role, you can change the account to "*" to allow everyone to assume the role. If
 *       you do this, we strongly recommend that you limit who can access the role through other means, such as a
 *       Condition element that limits access to only certain IP addresses. Do not leave your role accessible to
 *       everyone!
 *
 *     - In resource-based policies, use the Principal element to specify the accounts or users who are allowed to
 *       access the resource.
 *
 * Do not use the Principal element in policies that you attach to IAM users and groups. Similarly, you do not specify
 * a principal in the permission policy for an IAM role. In those cases, the principal is implicitly the user that the
 * policy is attached to (for IAM users) or the user who assumes the role (for role access policies). When the policy
 * is attached to an IAM group, the principal is the IAM user in that group who is making the request.
 */
export type Principal = "*" | inputs.iam.AWSPrincipal | inputs.iam.ServicePrincipal | inputs.iam.FederatedPrincipal;


/**
 * assumeRolePolicyForPrincipal returns a well-formed policy document which can be
 * used to control which principals may assume an IAM Role, by granting the `sts:AssumeRole`
 * action to those principals.
 *
 * @param {Principal} principal The principals for whom assuming the role is allowed
 * @returns {PolicyDocument} A policy document allowing principals to invoke `sts:AssumeRole`
 */
export function assumeRolePolicyForPrincipal(principal: Principal): inputs.iam.PolicyDocument {
    return {
        Version: "2012-10-17",
        Statement: [
            {
                Sid: "AllowAssumeRole",
                Effect: "Allow",
                Principal: principal,
                Action: "sts:AssumeRole"
            }
        ]
    };
}
