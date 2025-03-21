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

/**
 * Amazon ECR lifecycle policies enable you to specify the lifecycle management of images in a repository.
 * A lifecycle policy is a set of one or more rules, where each rule defines an action for Amazon ECR.
 * The actions apply to images that contain tags prefixed with the given strings. This allows the automation
 * of cleaning up unused images, for example expiring images based on age or count. You should expect that
 * after creating a lifecycle policy the affected images are expired within 24 hours.
 *
 * For more details about ECR lifecycle policies, please refer to the AWS documentation online:
 * https://docs.aws.amazon.com/AmazonECR/latest/userguide/LifecyclePolicies.html
 */
export interface LifecyclePolicyDocument {
    rules: PolicyRule[];
}

export interface PolicyRule {
    /**
     * Indicate the Rule Priority - each rule must have a different priority.
     */
    rulePriority: Input<number>;
    /**
     * An optional description for the rule.
     */
    description?: Input<string>;
    /**
     * The selection criteria for the rule.
     */
    selection: Selection;
    /**
     * The action to perform when selection criteria is met.
     */
    action: Action;
}

/**
 * Selection is the selection criteria for the rule and is the mart part of the policy.
 */
export interface Selection {
    /**
     * Indicate whether to select `tagged`, `untagged` or `any` images in the repository.
     */
    tagStatus: Input<"tagged" | "untagged" | "any">;
    /**
     * Specify one or more image tag prefixes for selection.
     */
    tagPrefixList?: Input<string> | Input<string>[];
    /**
     * Specify one or more image tag patterns for selection.
     */
    tagPatternList?: Input<string>[];
    /**
     * Indicate whether to evaluate the rule based on `imageCountMoreThan` or `sinceImagePushed`.
     */
    countType: Input<"imageCountMoreThan" | "sinceImagePushed">;
    /**
     * The unit of time e.g. days for which to apply the selection.
     */
    countUnit?: Input<string>;
    /**
     * The maximum number of images or the max age for which to apply the image selection.
     */
    countNumber: Input<number>;
}

export interface Action {
    /**
     * The specified action type - the only supported value is `expire`.
     */
    type: Input<"expire">;
}