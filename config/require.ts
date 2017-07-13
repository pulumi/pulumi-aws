// Copyright 2016-2017, Pulumi Corporation.  All rights reserved.

import {region} from "./config";
import {Region} from "../region";

// requireRegion fetches the AWS region, requiring that it exists; if it has not been configured, an error is thrown.
export function requireRegion(): Region {
    if (region === undefined) {
        throw new Error("No AWS region has been configured");
    }
    return region;
}

