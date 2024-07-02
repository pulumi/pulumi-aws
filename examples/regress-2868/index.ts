// Copyright 2016-2024, Pulumi Corporation.
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

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

export const AppUsersPool = new aws.cognito.UserPool("test-user-pool", {
    accountRecoverySetting: {
        recoveryMechanisms: [{
            name: "verified_email",
            priority: 1,
        }],
    },
    autoVerifiedAttributes: ["email"],
    mfaConfiguration: "OPTIONAL",
    name: "test-user-pool",
    passwordPolicy: {
        minimumLength: 8,
        requireLowercase: true,
        requireNumbers: true,
        requireSymbols: true,
        requireUppercase: true,
        temporaryPasswordValidityDays: 300,
    },
    schemas: [{
        attributeDataType: "String",
        mutable: true,
        name: "name",
        required: true,
        stringAttributeConstraints: {
            maxLength: "2048",
            minLength: "0",
        },
    },{
        attributeDataType: "String",
        mutable: true,
        name: "birthdate",
        required: false,
        stringAttributeConstraints: {
            maxLength: "2048",
            minLength: "0",
        },
    }],
    softwareTokenMfaConfiguration: {
        enabled: true,
    },
    usernameAttributes: ["email"],
    usernameConfiguration: {
        caseSensitive: false,
    },
});

export const testuserpoolclient = new aws.cognito.UserPoolClient("test-userpool-client", {
    analyticsConfiguration: undefined,
    accessTokenValidity: 60,
    enableTokenRevocation: true,
    explicitAuthFlows: [
        "ALLOW_USER_SRP_AUTH",
        "ALLOW_USER_PASSWORD_AUTH",
        "ALLOW_REFRESH_TOKEN_AUTH",
    ],
    idTokenValidity: 60,
    name: "test-userpool-client",
    preventUserExistenceErrors: "ENABLED",
    readAttributes: [
        "given_name",
        "email_verified",
        "zoneinfo",
        "website",
        "preferred_username",
        "name",
        "locale",
        "phone_number",
        "family_name",
        "birthdate",
        "middle_name",
        "phone_number_verified",
        "profile",
        "picture",
        "address",
        "gender",
        "updated_at",
        "nickname",
        "email",
    ],
    tokenValidityUnits: {
        accessToken: "minutes",
        idToken: "minutes",
    },
    userPoolId: AppUsersPool.id,
    writeAttributes: [
        "given_name",
        "zoneinfo",
        "website",
        "preferred_username",
        "name",
        "locale",
        "phone_number",
        "family_name",
        "birthdate",
        "middle_name",
        "profile",
        "picture",
        "address",
        "gender",
        "updated_at",
        "nickname",
        "email",
    ],
});
