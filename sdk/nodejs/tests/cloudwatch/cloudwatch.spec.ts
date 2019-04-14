import * as pulumi from "@pulumi/pulumi";

pulumi.runtime.setConfig("aws:region", "us-east-2");

import * as assert from "assert";
// import { asyncTest } from "../util";

import * as aws from "../..";

import { Widget } from "../../cloudwatch/widgets";
import { TextWidget } from "../../cloudwatch/simpleWidgets";
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

    describe("simple widgets", () => {
        describe("text widgets", () => {
            it("string constructor", async () => {
                const json = await bodyJson(new TextWidget("text"));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "text"
            }
        }
    ]
}`);
            });

            it("custom constructor", async () => {
                const json = await bodyJson(new TextWidget({ markdown: "text", width: 2, height: 1 }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 2,
            "height": 1,
            "type": "text",
            "properties": {
                "markdown": "text"
            }
        }
    ]
}`);
            });
        });
    });

    describe("flow", () => {
        describe("horizontal", () => {
            it("two widgets", async () => {
                const json = await bodyJson(new TextWidget("hello"), new TextWidget("world"));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "hello"
            }
        },
        {
            "x": 6,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "world"
            }
        }
    ]
}`);
            });
            it("multiple widgets with wrapping", async () => {
                const json = await bodyJson(
                    new TextWidget("hello"),
                    new TextWidget("world"),
                    new TextWidget({ markdown: "goodnight", height: 1, width: 18 }),
                    new TextWidget({ markdown: "moon", height: 3, width: 6 }),
                    new TextWidget({ markdown: "!", height: 5, width: 1 }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "hello"
            }
        },
        {
            "x": 6,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "world"
            }
        },
        {
            "x": 0,
            "y": 6,
            "width": 18,
            "height": 1,
            "type": "text",
            "properties": {
                "markdown": "goodnight"
            }
        },
        {
            "x": 18,
            "y": 6,
            "width": 6,
            "height": 3,
            "type": "text",
            "properties": {
                "markdown": "moon"
            }
        },
        {
            "x": 0,
            "y": 9,
            "width": 1,
            "height": 5,
            "type": "text",
            "properties": {
                "markdown": "!"
            }
        }
    ]
}`);
            });
        });
    });
});