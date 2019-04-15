import * as pulumi from "@pulumi/pulumi";

pulumi.runtime.setConfig("aws:region", "us-east-2");

import * as assert from "assert";
import * as semver from "semver";
// import { asyncTest } from "../util";

import * as aws from "../..";

import { Metric } from "../../cloudwatch/metric";
import { Widget } from "../../cloudwatch/widgets";
import { ColumnWidget, RowWidget } from "../../cloudwatch/flowWidgets";
import {
    AlarmAnnotation,
    LineGraphMetricWidget,
    SingleNumberMetricWidget,
    StackedAreaGraphMetricWidget,
    TextWidget,
} from "../../cloudwatch/simpleWidgets";
import { DashboardBody } from "../../cloudwatch/dashboardBody";

function createBody(...widgets: Widget[]) {
    return new DashboardBody({
        widgets: widgets,
    });
}

async function bodyJson(...widgets: Widget[]) {
    const body = createBody(...widgets);
    return await toJson(body);
}

async function toJson(body: DashboardBody) {
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

    it("period override", async () => {
        const json = await toJson(new DashboardBody({ periodOverride: "auto" }));
        assert.equal(json, `{
    "periodOverride": "auto",
    "widgets": []
}`);
    });

    it("alarm annotation", async () => {
        const json = await bodyJson(new SingleNumberMetricWidget({
            annotations: [new AlarmAnnotation("some_arn")],
        }));
        assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "annotations": {
                    "alarms": [
                        "some_arn"
                    ]
                },
                "period": 300,
                "region": "us-east-2",
                "view": "singleValue",
                "stacked": false
            }
        }
    ]
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

    describe("flow widgets", () => {
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
            it("multiple rows with wrapping", async () => {
                const json = await bodyJson(
                    new RowWidget(
                        new TextWidget({ markdown: "hello", height: 4 }),
                        new TextWidget({ markdown: "world", height: 3 }),
                    new RowWidget(
                        new TextWidget({ markdown: "goodnight", height: 1, width: 10 }),
                        new TextWidget({ markdown: "moon", height: 3, width: 10 }),
                        new TextWidget({ markdown: "!", height: 5, width: 10 })),
                    new RowWidget(new TextWidget("byebye"))));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 4,
            "type": "text",
            "properties": {
                "markdown": "hello"
            }
        },
        {
            "x": 6,
            "y": 0,
            "width": 6,
            "height": 3,
            "type": "text",
            "properties": {
                "markdown": "world"
            }
        },
        {
            "x": 0,
            "y": 4,
            "width": 10,
            "height": 1,
            "type": "text",
            "properties": {
                "markdown": "goodnight"
            }
        },
        {
            "x": 10,
            "y": 4,
            "width": 10,
            "height": 3,
            "type": "text",
            "properties": {
                "markdown": "moon"
            }
        },
        {
            "x": 0,
            "y": 7,
            "width": 10,
            "height": 5,
            "type": "text",
            "properties": {
                "markdown": "!"
            }
        },
        {
            "x": 0,
            "y": 12,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "byebye"
            }
        }
    ]
}`);
            });
        });

        describe("vertical", () => {
            it("two widgets", async () => {
                const json = await bodyJson(
                    new ColumnWidget(new TextWidget("hello"), new TextWidget("world")));
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
            "x": 0,
            "y": 6,
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
            it("multiple widgets without wrapping", async () => {
                const json = await bodyJson(new ColumnWidget(
                    new TextWidget("hello"),
                    new TextWidget("world"),
                    new TextWidget({ markdown: "goodnight", height: 1, width: 18 }),
                    new TextWidget({ markdown: "moon", height: 3, width: 6 }),
                    new TextWidget({ markdown: "!", height: 5, width: 1 })));
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
            "x": 0,
            "y": 6,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "world"
            }
        },
        {
            "x": 0,
            "y": 12,
            "width": 18,
            "height": 1,
            "type": "text",
            "properties": {
                "markdown": "goodnight"
            }
        },
        {
            "x": 0,
            "y": 13,
            "width": 6,
            "height": 3,
            "type": "text",
            "properties": {
                "markdown": "moon"
            }
        },
        {
            "x": 0,
            "y": 16,
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
            it("multiple columns without wrapping", async () => {
                const json = await bodyJson(
                    new ColumnWidget(
                        new TextWidget({ markdown: "hello", height: 4 }),
                        new TextWidget({ markdown: "world", height: 3 })),
                    new ColumnWidget(
                        new TextWidget({ markdown: "goodnight", height: 1, width: 10 }),
                        new TextWidget({ markdown: "moon", height: 3, width: 10 }),
                        new TextWidget({ markdown: "!", height: 5, width: 10 })),
                    new ColumnWidget(new TextWidget("byebye")),
                    new ColumnWidget(new TextWidget("byebye2")));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 4,
            "type": "text",
            "properties": {
                "markdown": "hello"
            }
        },
        {
            "x": 0,
            "y": 4,
            "width": 6,
            "height": 3,
            "type": "text",
            "properties": {
                "markdown": "world"
            }
        },
        {
            "x": 6,
            "y": 0,
            "width": 10,
            "height": 1,
            "type": "text",
            "properties": {
                "markdown": "goodnight"
            }
        },
        {
            "x": 6,
            "y": 1,
            "width": 10,
            "height": 3,
            "type": "text",
            "properties": {
                "markdown": "moon"
            }
        },
        {
            "x": 6,
            "y": 4,
            "width": 10,
            "height": 5,
            "type": "text",
            "properties": {
                "markdown": "!"
            }
        },
        {
            "x": 16,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "byebye"
            }
        },
        {
            "x": 0,
            "y": 9,
            "width": 6,
            "height": 6,
            "type": "text",
            "properties": {
                "markdown": "byebye2"
            }
        }
    ]
}`);
            });
        })
    });

    describe("metric widgets", () => {
        describe("single number", () => {
            if (semver.gte(process.version, "10.0.0")) {
                it("empty metrics", async () => {
                    await assert.rejects(async () => {
                        const json = await bodyJson(new SingleNumberMetricWidget({}));
                    });
                });

                it("invalid period", async() => {
                    await assert.rejects(async () => {
                        const json = await bodyJson(new SingleNumberMetricWidget({
                            metrics: [new Metric({ namespace: "AWS/EC2", name: "NetworkIn", period: 5 })]
                        }));
                    });
                });
            }

            it("single metric", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                    })]
                }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "metrics": [
                    [
                        "AWS/Lambda",
                        "Invocations",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ]
                ],
                "period": 300,
                "region": "us-east-2",
                "view": "singleValue",
                "stacked": false
            }
        }
    ]
}`);
            });

            it("multiple metrics", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    metrics: [
                        new Metric({ namespace: "AWS/Lambda", name: "Invocations", yAxis: "right" }),
                        new Metric({ namespace: "AWS/EC2", name: "NetworkIn", period: 60 })
                    ],
                }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "metrics": [
                    [
                        "AWS/Lambda",
                        "Invocations",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "right"
                        }
                    ],
                    [
                        "AWS/EC2",
                        "NetworkIn",
                        {
                            "stat": "Average",
                            "period": 60,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ]
                ],
                "period": 300,
                "region": "us-east-2",
                "view": "singleValue",
                "stacked": false
            }
        }
    ]
}`);
            });

            it("with dimension", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                        dimensions: {
                            FunctionName: "MyFunc",
                            Hello: "world",
                        }
                    })]
                }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "metrics": [
                    [
                        "AWS/Lambda",
                        "Invocations",
                        "FunctionName",
                        "MyFunc",
                        "Hello",
                        "world",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ]
                ],
                "period": 300,
                "region": "us-east-2",
                "view": "singleValue",
                "stacked": false
            }
        }
    ]
}`);
            });

            it("alarm annotation", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                    })],
                    annotations: [new AlarmAnnotation("some_arn")],
                }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "metrics": [
                    [
                        "AWS/Lambda",
                        "Invocations",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ]
                ],
                "annotations": {
                    "alarms": [
                        "some_arn"
                    ]
                },
                "period": 300,
                "region": "us-east-2",
                "view": "singleValue",
                "stacked": false
            }
        }
    ]
}`);
            });
        });

        describe("stacked area graph", () => {
            it("single metric", async () => {
                const json = await bodyJson(new StackedAreaGraphMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                    })]
                }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "metrics": [
                    [
                        "AWS/Lambda",
                        "Invocations",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ]
                ],
                "period": 300,
                "region": "us-east-2",
                "view": "timeSeries",
                "stacked": true
            }
        }
    ]
}`);
            });
        })

        describe("line graph", () => {
            it("single metric", async () => {
                const json = await bodyJson(new LineGraphMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                    })]
                }));
                assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 6,
            "height": 6,
            "type": "metric",
            "properties": {
                "metrics": [
                    [
                        "AWS/Lambda",
                        "Invocations",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ]
                ],
                "period": 300,
                "region": "us-east-2",
                "view": "timeSeries",
                "stacked": false
            }
        }
    ]
}`);
            });
        })
    });
});