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

// This file defines interfaces that match the structure of IAM policy documents.
// See http://docs.aws.amazon.com/IAM/latest/UserGuide/reference_policies_grammar.html

export interface PolicyDocument {
    Version: "2008-10-17" | "2012-10-17";
    Id?: string;
    Statement: PolicyStatement[];
}

export interface PolicyStatement {
    Sid?: string;
    Effect: "Allow" | "Deny";

    Principal?: Principal;
    NotPrincipal?: Principal;

    Action?: string | string[];
    NotAction?: string | string[];

    Resource?: string | string[];
    NotResource?: string | string[];

    Condition?: Conditions;
}

export interface Conditions {
    // e.g. { "BoolIfExists": <condition> }
    [operator: string]: ConditionArguments;
}

export interface ConditionArguments {
    // e.g. { "aws:MultiFactorAuthPresent": "true" }
    [value: string]: string;
}

export type Principal = "*" | AWSPrincipal | ServicePrincipal | FederatedPrincipal;

export interface AWSPrincipal {
    AWS: string | string[];
}

export interface ServicePrincipal {
    Service: string | string[];
}

export interface FederatedPrincipal {
    Federated: string | string[];
}

