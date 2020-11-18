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

import {Input} from "@pulumi/pulumi";

// Implementation note: The definitions of `PolicyDocument` and its associated types below are based
// on the grammar for IAM Policy Documents defined at
// https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_grammar.html.

/**
 * You manage access in AWS by creating policies and attaching them to IAM identities or AWS resources. A policy is an
 * object in AWS that, when associated with an entity or resource, defines their permissions. AWS evaluates these
 * policies when a principal, such as a user, makes a request. Permissions in the policies determine whether the
 * request is allowed or denied.
 *
 * IAM policies define permissions for an action regardless of the method that you use to perform the operation. For
 * example, if a policy allows the `GetUser` action, then a user with that policy can get user information from the
 * AWS Management Console, the AWS CLI, or the AWS API. When you create an IAM user, you can set up the user to
 * allow console or programmatic access. The IAM user can sign in to the console using a user name and password.
 * Or they can use access keys to work with the CLI or API.
 *
 * Most policies are stored in AWS as JSON documents. Identity-based policies, policies used to set boundaries, or AWS
 * STS boundary policies are JSON policy documents that you attach to a user or role. Resource-based policies are JSON
 * policy documents that you attach to a resource. SCPs are JSON policy documents with restricted syntax that you
 * attach to an AWS Organizations organizational unit (OU). ACLs are also attached to a resource, but you must use a
 * different syntax.
 *
 * A JSON policy document includes these elements:
 *
 *     - Optional policywide information at the top of the document
 *     - One or more individual statements
 *
 * Each statement includes information about a single permission. If a policy includes multiple statements, AWS applies
 * a logical OR across the statements when evaluating them. If multiple policies apply to a request, AWS applies a
 * logical OR across all of those policies when evaluating them.
 *
 * For more details about IAM policies, please refer to the AWS documentation online:
 * https://docs.aws.amazon.com/IAM/latest/UserGuide/access_policies.html
 */
export interface PolicyDocument {
    /**
     * The version of the policy language that you want to use. As a best practice, use the latest `2012-10-17` version.
     */
    Version: Input<"2008-10-17" | "2012-10-17">;
    /**
     * An optional document ID.
     */
    Id?: Input<string>;
    /**
     * One or more policy statements, describing the effect, principal, action, resource, and condition.
     */
    Statement: Input<Input<PolicyStatement>[]>;
}

/**
 * The Statement element is the main element for a policy. This element is required. It can include multiple elements
 * (see the subsequent sections in this page). The Statement element contains an array of individual statements.
 */
export interface PolicyStatement {
    /**
     * An optional statement ID to differentiate between your statements.
     */
    Sid?: Input<string>;
    /**
     * Indicate whether the policy allows or denies access.
     */
    Effect: Input<"Allow" | "Deny">;
    /**
     * Indicate the account, user, role, or federated user to which you would like to allow or deny access. If you are
     * creating a policy to attach to a user or role, you cannot include this element. The principal is implied as that
     * user or role.
     */
    Principal?: Input<Principal>;
    /**
     * Indicate the account, user, role, or federated user to which this policy does not apply.
     */
    NotPrincipal?: Input<Principal>;
    /**
     * Include a list of actions that the policy allows or denies. Required (either Action or NotAction)
     * Reference: https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_action.html
     */
    Action?: Input<string> | Input<Input<string>[]>;
    /**
     * Include a list of actions that are not covered by this policy. Required (either Action or NotAction)
     * Reference: https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_notaction.html
     */
    NotAction?: Input<string> | Input<Input<string>[]>;
    /**
     * A list of resources to which the actions apply.
     */
    Resource?: Input<string> | Input<Input<string>[]>;
    /**
     * A list of resources that are specifically excluded by this policy.
     */
    NotResource?: Input<string> | Input<Input<string>[]>;
    /**
     * Specify the circumstances under which the policy grants permission.
     */
    Condition?: Input<Conditions>;
}

/**
 * The Condition element (or Condition block) lets you specify conditions for when a policy is in effect. The Condition
 * element is optional. In the Condition element, you build expressions in which you use condition operators (equal,
 * less than, etc.) to match the condition in the policy against values in the request. Condition values can include
 * date, time, the IP address of the requester, the ARN of the request source, the user name, user ID, and the user
 * agent of the requester. Some services let you specify additional values in conditions; for example, Amazon S3
 * lets you write a condition using the s3:VersionId key, which is unique to that service.
 */
export interface Conditions {
    /**
     *
     * A map of condition operators and their arguments. Condition operators are the "verbs" of conditions and specify
     * the type of comparison that IAM performs. The condition operators are grouped into the following categorties:
     *
     *     - String
     *     - Numeric
     *     - Date and time
     *     - Boolean
     *     - Binary
     *     - IP address
     *     - Amazon Resource (ARN) (available for some services)
     *     - ...IfExists (checks if the key value exists as part of another check)
     *     - Null check (checks if the key value exists as a standalone check)
     *
     * For details on all of the available operators and their arguments, please refer to the AWS documentation:
     * https://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_elements_condition_operators.html.
     */
    [operator: string]: ConditionArguments;
}

export interface ConditionArguments {
    /**
     * Examples:
     *  - `{ "aws:MultiFactorAuthPresent": "true" }`
     *  - `{ "aws:SourceIp": [ "203.0.113.0/24", "2001:DB8:1234:5678::/64" ]}`
     */
    [value: string]: Input<string> | Input<Input<string>[]>;
}

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
export type Principal = "*" | AWSPrincipal | ServicePrincipal | FederatedPrincipal;

/**
 * When you use an AWS account identifier as the principal in a policy, the permissions in the policy statement can be
 * granted to all identities contained in that account. This includes IAM users and roles in that account. When you
 * specify an AWS account, you can use the account ARN (arn:aws:iam::AWS-account-ID:root), or a shortened form that
 * consists of the AWS: prefix followed by the account ID.
 */
export interface AWSPrincipal {
    AWS: Input<string> | Input<Input<string>[]>;
}

/**
 * IAM roles that can be assumed by an AWS service are called service roles. Service roles must include a trust policy.
 * Trust policies are resource-based policies that are attached to a role that define which principals can assume the
 * role. Some service role have predefined trust policies. However, in some cases, you must specify the service
 * principal in the trust policy. A service principal is an identifier that is used to grant permissions to a service.
 * The identifier includes the long version of a service name, e.g. `long_service_name.amazonaws.com`. The service
 * principal is defined by the service. To learn the service principal for a service, see the documentation for that
 * service.
 */
export interface ServicePrincipal {
    Service: Input<string> | Input<Input<string>[]>;
}

export interface FederatedPrincipal {
    Federated: Input<string> | Input<Input<string>[]>;
}

/**
 * assumeRolePolicyForPrincipal returns a well-formed policy document which can be
 * used to control which principals may assume an IAM Role, by granting the `sts:AssumeRole`
 * action to those principals.
 *
 * @param {Principal} principal The principals for whom assuming the role is allowed
 * @returns {PolicyDocument} A policy document allowing principals to invoke `sts:AssumeRole`
 */
export function assumeRolePolicyForPrincipal(principal: Principal): PolicyDocument {
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
