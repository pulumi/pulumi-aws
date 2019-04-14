import * as pulumi from "@pulumi/pulumi";

pulumi.runtime.setConfig("aws:region", "us-east-2");

import * as assert from "assert";
// import { asyncTest } from "../util";

import * as aws from "../..";

import { Widget } from "../../cloudwatch/widgets";
import { DashboardBody } from "../../cloudwatch/dashboardBody";

function createBody(...widgets: Widget[]) {
    return new DashboardBody({
        widgets: widgets,
    });
}

async function bodyJson(...widgets: Widget[]) {
    const body = createBody(...widgets);
    const json = await (<any>body.toDashboardJson()).promise();
    return JSON.stringify(json, null, 4);
}

describe("dashboard", () => {
    it("empty", async () => {
        const json = await bodyJson();
        assert.equal(json, `{
    "widgets": []
}`);
    });
});