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

import * as utils from "../utils";

import { Dashboard } from "./dashboard";
import { DashboardBody } from "./dashboardBody";

declare module "./dashboard" {
    module Dashboard {
        /**
         * Creates a new dashboard from the body description provided.
         */
        export function fromBody(name: string, body: DashboardBody, opts?: pulumi.CustomResourceOptions): Dashboard
    }
}

Dashboard.fromBody = function(name: string, body: DashboardBody, opts?: pulumi.CustomResourceOptions): Dashboard {
    const argsCopy = {
        dashboardName: utils.ifUndefined(body.name, name),
        dashboardBody: body.toDashboardJson().apply(j => {
            const result = JSON.stringify(j, null, 2);
            console.log(result);
            return result;
        }),
    };

    return new Dashboard(name, argsCopy, opts);
};

/** @internal */
export const __dashboardUnused = 0;