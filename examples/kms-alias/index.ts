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

import * as pulumi from "@pulumi/pulumi";
import * as aws from "@pulumi/aws";

const config = new pulumi.Config("aws");
const providerOpts = { provider: new aws.Provider("prov", { region: <aws.Region>config.require("envRegion") }) };

const key = new aws.kms.Key("key", {}, providerOpts);
const aliasAutoPrefixedWithAlias = new aws.kms.Alias("should-be-prefixed", {targetKeyId: key.keyId}, providerOpts);

const aliasWithDedicatedName = new aws.kms.Alias("wont-be-autonamed", {
    targetKeyId: key.keyId,
    namePrefix: "alias/my-decicated-name-"
}, providerOpts);

export const autonamedAlias = aliasAutoPrefixedWithAlias.name;
export const decidatedAlias = aliasWithDedicatedName.name;
