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
import * as config from "../config";
import * as lambda from "../lambda";
import * as logGroup from "./logGroup";
import * as logSubscriptionFilter from "./logSubscriptionFilter";

/**
 * Arguments to control the event rule subscription.  Currently empty, but still defined in case of
 * future need.
 */
export interface LogGroupEventSubscriptionArgs {
    /**
     * A valid CloudWatch Logs filter pattern for subscribing to a filtered stream of log events.
     * If not provided, the empty-string pattern will be used.
     */
    filterPattern?: string;
}

export interface LogGroupEvent {
    awslogs: {
        // The data attribute in the Lambda record is Base64 encoded and compressed with the gzip
        // format. Unencoded and uncompressed it will have the shape of [DecodedLogGroupEvent]
        data: string;
    };
}

export interface DecodedLogGroupEvent {
    // The AWS Account ID of the originating log data.
    owner: string;

    // The log group name of the originating log data.
    logGroup: string;

    // The log stream name of the originating log data.
    logStream: string;

    // The list of subscription filter names that matched with the originating log data.
    subscriptionFilters: string[];

    // Data messages will use the "DATA_MESSAGE" type. Sometimes CloudWatch Logs may emit Lambda
    // records with a "CONTROL_MESSAGE" type, mainly for checking if the destination is reachable.
    messageType: string;

    // The actual log data, represented as an array of log event records. The "id" property is a
    // unique identifier for every log event.
    logEvents: LogGroupEventRecord[];
}

export interface LogGroupEventRecord {
    id: string;
    timestamp: number;
    message: string;
}

export type LogGroupEventHandler = lambda.EventHandler<LogGroupEvent, void>;

export class LogGroupEventSubscription extends lambda.EventSubscription {
    public readonly logGroup: pulumi.Output<logGroup.LogGroup>;
    public readonly logSubscriptionFilter: logSubscriptionFilter.LogSubscriptionFilter;

    constructor(
        name: string, logGroup: logGroup.LogGroup, handler: LogGroupEventHandler,
        args: LogGroupEventSubscriptionArgs, opts?: pulumi.ResourceOptions) {

        super("aws:cloudwatch:LogGroupEventSubscription", name, { logGroup: logGroup }, opts);

        args = args || {};
        const parentOpts = { parent: this };
        this.func = lambda.createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            action: "lambda:invokeFunction",
            function: this.func,
            principal: `logs.${config.requireRegion()}.amazonaws.com`,
            sourceArn: logGroup.arn,
        }, parentOpts);

        this.logSubscriptionFilter = new logSubscriptionFilter.LogSubscriptionFilter(name, {
            destinationArn: this.func.arn,
            filterPattern: args.filterPattern || "",
            logGroup: logGroup,
        }, parentOpts);
    }
}

declare module "./logGroup" {
    interface LogGroup {
        onEvent(name: string, handler: LogGroupEventHandler,
                args?: LogGroupEventSubscriptionArgs, opts?: pulumi.ResourceOptions): LogGroupEventSubscription;

        onDecodedEvent(name: string, handler: lambda.EntryPoint<DecodedLogGroupEvent, void>,
            args?: LogGroupEventSubscriptionArgs, opts?: pulumi.ResourceOptions): LogGroupEventSubscription;
    }
}

logGroup.LogGroup.prototype.onEvent = function(this: logGroup.LogGroup, name, handler, args, opts) {
    return new LogGroupEventSubscription(name, this, handler, args, opts);
}

logGroup.LogGroup.prototype.onDecodedEvent = function(this: logGroup.LogGroup, name, handler, args, opts) {
    return this.onEvent(name, async (event, context, callback) => {
        const decoded = await decodeLogGroupEvent(event);
        await handler(decoded, context, callback);
    }, args, opts);
}

async function decodeLogGroupEvent(event: LogGroupEvent): Promise<DecodedLogGroupEvent> {
    const zlib = await import("zlib");
    const payload = new Buffer(event.awslogs.data, "base64");

    return new Promise<DecodedLogGroupEvent>((resolve, reject) => {
        zlib.gunzip(payload, function(err, result) {
            if (err) {
                reject(err);
            } else {
                resolve(JSON.parse(result.toString("ascii")));
            }
        });
    });
}