import * as pulumi from "@pulumi/pulumi";

pulumi.runtime.setConfig("aws:region", "us-east-2");

import * as assert from "assert";
import * as semver from "semver";
// import { asyncTest } from "../util";

import * as aws from "../..";

import { Metric } from "../../cloudwatch/metric";
import { Widget } from "../../cloudwatch/widgets";
import { ColumnWidget, RowWidget } from "../../cloudwatch/widgets_flow";
import { ExpressionWidgetMetric, TextWidget } from "../../cloudwatch/widgets_simple";
import { AlarmAnnotation, HorizontalAnnotation, VerticalAnnotation } from "../../cloudwatch/widgets_annotations";
import { LineGraphMetricWidget, SingleNumberMetricWidget, StackedAreaGraphMetricWidget } from "../../cloudwatch/widgets_graph";
import { DashboardDescription } from "../../cloudwatch/dashboardDescription";

function createBody(...widgets: Widget[]) {
    return new DashboardDescription({
        widgets: widgets,
    });
}

async function bodyJson(...widgets: Widget[]) {
    const body = createBody(...widgets);
    return await toJson(body);
}

async function toJson(body: DashboardDescription) {
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
        const json = await toJson(new DashboardDescription({ periodOverride: "auto" }));
        assert.equal(json, `{
    "periodOverride": "auto",
    "widgets": []
}`);
    });

    describe("annotations", () => {
        describe("alarms", () => {
            if (semver.gte(process.version, "10.0.0")) {
                it("multiple alarms", async() => {
                    await assert.rejects(async() => {
                        await bodyJson(new SingleNumberMetricWidget({
                            annotations: [new AlarmAnnotation("some_arn"), new AlarmAnnotation("some_arn")],
                        }));
                    });
                });
            }

            it("single", async () => {
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
        });

        describe("horizontal", () => {
            if (semver.gte(process.version, "10.0.0")) {
                it("fill and band", async() => {
                    await assert.rejects(async() => {
                        await bodyJson(new SingleNumberMetricWidget({
                            annotations: [new HorizontalAnnotation({
                                fill: "above",
                                aboveEdge: { value: 10 },
                                belowEdge: { value: 5 },
                            })],
                        }));
                    });
                });
            }

            it("single", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    annotations: [new HorizontalAnnotation({
                        aboveEdge: { value: 10 },
                    })],
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
                    "horizontal": [
                        {
                            "value": 10
                        }
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
            it("band", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    annotations: [new HorizontalAnnotation({
                        aboveEdge: { value: 10 },
                        belowEdge: { value: 5 },
                    })],
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
                    "horizontal": [
                        {
                            "value": 10
                        },
                        {
                            "value": 5
                        }
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

        describe("vertical", () => {
            if (semver.gte(process.version, "10.0.0")) {
                it("fill and band", async() => {
                    await assert.rejects(async() => {
                        await bodyJson(new SingleNumberMetricWidget({
                            annotations: [new VerticalAnnotation({
                                fill: "after",
                                beforeEdge: { value: "10" },
                                afterEdge: { value: "5" },
                            })],
                        }));
                    });
                });
            }

            it("single", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    annotations: [new VerticalAnnotation({
                        beforeEdge: { value: "10" },
                    })],
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
                    "vertical": [
                        {
                            "value": "10"
                        }
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
            it("band", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    annotations: [new VerticalAnnotation({
                        beforeEdge: { value: "10" },
                        afterEdge: { value: "5" },
                    })],
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
                    "vertical": [
                        {
                            "value": "10"
                        },
                        {
                            "value": "5"
                        }
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
    });

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

            it("stat", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                        statistic: "SampleCount",
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
                            "stat": "SampleCount",
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

            it("extended stat", async () => {
                const json = await bodyJson(new SingleNumberMetricWidget({
                    metrics: [new Metric({
                        namespace: "AWS/Lambda",
                        name: "Invocations",
                        extendedStatistic: 99,
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
                            "stat": "p99",
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

    describe("realworld", () => {
        it("realword 1", async () => {
            const json = await toJson(new DashboardDescription({
                start: "-PT6H",
                periodOverride: "inherit",
                widgets: [
                    new LineGraphMetricWidget({
                        width: 12, height: 6,
                        period: 300,
                        statistic: "Average",
                        title: "EC2 Instance CPU",
                        metrics: [
                            new Metric({
                                namespace: "AWS/EC2",
                                name: "DiskReadBytes",
                                dimensions: {
                                    InstanceId: "i-123"
                                }
                            }),
                            new ExpressionWidgetMetric("SUM(METRICS())", "Sum of DiskReadbytes", "e3"),
                        ],
                    }),
                    new LineGraphMetricWidget({
                        width: 18, height: 9,
                        period: 300,
                        statistic: "Average",
                        title: "EC2 Instance CPU",
                        metrics: [
                            new ExpressionWidgetMetric("SEARCH('{AWS/EC2,InstanceId} MetricName=\"CPUUtilization\"', 'Average', 300)", undefined, "e1"),
                        ],
                    })
                ],
            }));

            assert.equal(json, `{
    "start": "-PT6H",
    "periodOverride": "inherit",
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 12,
            "height": 6,
            "type": "metric",
            "properties": {
                "stat": "Average",
                "metrics": [
                    [
                        "AWS/EC2",
                        "DiskReadBytes",
                        "InstanceId",
                        "i-123",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ],
                    [
                        {
                            "expression": "SUM(METRICS())",
                            "label": "Sum of DiskReadbytes",
                            "id": "e3"
                        }
                    ]
                ],
                "title": "EC2 Instance CPU",
                "period": 300,
                "region": "us-east-2",
                "view": "timeSeries",
                "stacked": false
            }
        },
        {
            "x": 0,
            "y": 6,
            "width": 18,
            "height": 9,
            "type": "metric",
            "properties": {
                "stat": "Average",
                "metrics": [
                    [
                        {
                            "expression": "SEARCH('{AWS/EC2,InstanceId} MetricName=\\"CPUUtilization\\"', 'Average', 300)",
                            "id": "e1"
                        }
                    ]
                ],
                "title": "EC2 Instance CPU",
                "period": 300,
                "region": "us-east-2",
                "view": "timeSeries",
                "stacked": false
            }
        }
    ]
}`);
        });

        it("realword 2", async () => {
            const json = await bodyJson(new StackedAreaGraphMetricWidget({
                width: 12, height: 6,
                period: 300,
                statistic: "Average",
                title: "EC2 Instance CPU",
                yAxis: { left: { min:0, max :100 }, right: { min: 50  } },
                annotations: [new HorizontalAnnotation({
                    aboveEdge: {
                        "label": "Critical range",
                        "value": 20,
                    },
                    "visible":true,
                    "color":"#9467bd",
                    "fill": "above",
                    "yAxis": "right"
                })],
                metrics: [
                    new Metric({
                        namespace: "AWS/EC2",
                        name: "CPUUtilization",
                        dimensions: {
                            InstanceId: "i-012345",
                        },
                    }),
                    new Metric({
                        namespace: "AWS/EC2",
                        name: "NetworkIn",
                        dimensions: {
                            InstanceId: "i-012345",
                        },
                        yAxis: "right",
                        label: "NetworkIn",
                        period: 3600,
                        statistic: "Maximum",
                    }),
                ],
            }));

            assert.equal(json, `{
    "widgets": [
        {
            "x": 0,
            "y": 0,
            "width": 12,
            "height": 6,
            "type": "metric",
            "properties": {
                "stat": "Average",
                "metrics": [
                    [
                        "AWS/EC2",
                        "CPUUtilization",
                        "InstanceId",
                        "i-012345",
                        {
                            "stat": "Average",
                            "period": 300,
                            "visible": true,
                            "yAxis": "left"
                        }
                    ],
                    [
                        "AWS/EC2",
                        "NetworkIn",
                        "InstanceId",
                        "i-012345",
                        {
                            "stat": "Maximum",
                            "label": "NetworkIn",
                            "period": 3600,
                            "visible": true,
                            "yAxis": "right"
                        }
                    ]
                ],
                "annotations": {
                    "horizontal": [
                        {
                            "fill": "above",
                            "color": "#9467bd",
                            "label": "Critical range",
                            "value": 20,
                            "visible": true,
                            "yAxis": "right"
                        }
                    ]
                },
                "title": "EC2 Instance CPU",
                "period": 300,
                "region": "us-east-2",
                "view": "timeSeries",
                "stacked": true,
                "yAxis": {
                    "left": {
                        "min": 0,
                        "max": 100
                    },
                    "right": {
                        "min": 50
                    }
                }
            }
        }
    ]
}`);
        });
    });
});