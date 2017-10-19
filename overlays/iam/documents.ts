// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

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

export type Principal = AWSPrincipal | ServicePrincipal | FederatedPrincipal;

export interface AWSPrincipal {
    AWS: string | string[];
}

export interface ServicePrincipal {
    Service: string | string[];
}

export interface FederatedPrincipal {
    Federated: string | string[];
}

