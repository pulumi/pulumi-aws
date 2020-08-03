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

import * as utils from "../utils";

/**
 * Arguments to control the event rule subscription.  Currently empty, but still defined in case of
 * future need.
 */
export interface LogGroupEventSubscriptionArgs {
    /**
     * A valid CloudWatch Logs filter pattern for subscribing to a filtered stream of log events. If
     * not provided, the empty-string pattern will be used.
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
    public readonly logGroup: logGroup.LogGroup;
    public readonly logSubscriptionFilter: logSubscriptionFilter.LogSubscriptionFilter;

    constructor(
        name: string, logGroup: logGroup.LogGroup, handler: LogGroupEventHandler,
        args: LogGroupEventSubscriptionArgs = {}, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the logGroup. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        super("aws:cloudwatch:LogGroupEventSubscription", name, {
            parent: logGroup,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        const parentOpts = { parent: this };
        this.func = lambda.createFunctionFromEventHandler(name, handler, parentOpts);

        const provider: any = this.getProvider("aws::");
        let region = provider ? provider.region : undefined;
        region = region || config.region;

        this.permission = new lambda.Permission(name, {
            action: "lambda:invokeFunction",
            function: this.func,
            principal: pulumi.interpolate`logs.${region}.amazonaws.com`,
            sourceArn: pulumi.interpolate`${logGroup.arn}:*`,
        }, parentOpts);

        this.logSubscriptionFilter = new logSubscriptionFilter.LogSubscriptionFilter(name, {
            destinationArn: this.func.arn,
            filterPattern: args.filterPattern || "",
            logGroup: logGroup,
        }, parentOpts);

        this.logGroup = logGroup;

        this.registerOutputs();
    }
}

declare module "./logGroup" {
    interface LogGroup {
        /**
         * Creates a new subscription to events fired from this LogGroup to the handler provided,
         * along with options to control the behavior of the subscription.
         *
         * The events will be produced in raw (gzipped + base64 encoded) form.
         */
        onEvent(name: string, handler: LogGroupEventHandler,
                args?: LogGroupEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): LogGroupEventSubscription;

        /**
         * Creates a new subscription to events fired from this LogGroup to the callback provided,
         * along with options to control the behavior of the subscription.
         *
         * The events will be provided in their decoded form.  Because this event hookup needs to
         * execute code to convert the raw messages, it can only be passed an [EntryPoint] callback,
         * not a [lambda.Function] instance.
         */
        onDecodedEvent(name: string, callback: lambda.Callback<DecodedLogGroupEvent, void>,
            args?: LogGroupEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): LogGroupEventSubscription;
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
    const payload = Buffer.from(event.awslogs.data, "base64");

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
