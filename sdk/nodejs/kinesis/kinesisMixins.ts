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
import * as iam from "../iam";
import * as stream from "./stream";
import * as lambda from "../lambda";
import * as types from "../types";

import * as utils from "../utils";

export interface StreamEventSubscriptionArgs {
    /**
     * The largest number of records that Lambda will retrieve from your event source at the time of
     * invocation. Defaults to `100` for Kinesis.
     */
    readonly batchSize?: number;

    /**
     * If the function returns an error, split the batch in two and retry. Defaults to `false`.
     */
    readonly bisectBatchOnFunctionError?: boolean;

    /**
     * An Amazon SQS queue or Amazon SNS topic destination for failed records.
     */
    readonly destinationConfig?: pulumi.Input<types.input.lambda.EventSourceMappingDestinationConfig>;

    /**
     * The maximum amount of time to gather records before invoking the function, in seconds. Records will continue to buffer
     * until either maximum_batching_window_in_seconds expires or batch_size has been met. Defaults to as soon as records
     * are available in the stream. If the batch it reads from the stream only has one record in it, Lambda only sends one record to the function.
     */
    readonly maximumBatchingWindowInSeconds?: number;

    /**
     * The maximum age of a record that Lambda sends to a function for processing. Minimum of `60`, maximum and default of `604800`
     */
    readonly maximumRecordAgeInSeconds?: number;

    /**
     * The maximum number of times to retry when the function returns an error. Minimum of `0`, maximum and default of `10000`.
     */
    readonly maximumRetryAttempts?: number;

    /**
     * The number of batches to process from each shard concurrently. Minimum and default of `1`, maximum of `10`
     */
    readonly parallelizationFactor?: number;

    /**
     * The position in the stream where AWS Lambda should start reading. Must be one of either
     * `TRIM_HORIZON`, `LATEST` or `AT_TIMESTAMP`.  If `AT_TIMESTAMP` is provided,
     * [startingPositionTimestamp] must be provided as well.
     */
    readonly startingPosition: "TRIM_HORIZON" | "LATEST" | "AT_TIMESTAMP";

    /**
     * A timestamp in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) of the
     * data record which to start reading when using `starting_position` set to `AT_TIMESTAMP`.
     * If a record with this exact timestamp does not exist, the next later record is chosen.
     * If the timestamp is older than the current trim horizon, the oldest available record is
     * chosen.
     */
    readonly startingPositionTimestamp?: string;
}

export interface StreamEvent {
    Records: StreamEventRecord[];
}

export interface StreamEventRecord {
    kinesis: {
        partitionKey: string;
        kinesisSchemaVersion: string;
        data: string;
        sequenceNumber: string;
    },
    eventSource: "aws:kinesis";
    eventID: string;
    invokeIdentityArn: string;
    eventVersion: string;
    eventName: "aws:kinesis:record";
    eventSourceARN: string;
    awsRegion: string;
}

export type StreamEventHandler = lambda.EventHandler<StreamEvent, void>;

export class StreamEventSubscription extends lambda.EventSubscription {
    public readonly stream: stream.Stream;
    public readonly eventSourceMapping: lambda.EventSourceMapping;

    constructor(
        name: string, stream: stream.Stream, handler: StreamEventHandler,
        args: StreamEventSubscriptionArgs, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the stream. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        super("aws:kinesis:StreamEventSubscription", name, {
            parent: stream,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        const parentOpts = { parent: this };
        this.func = createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            function: this.func,
            action: "lambda:InvokeFunction",
            principal: "kinesis.amazonaws.com",
            sourceArn: stream.arn,
        }, parentOpts);

        const mappingArgs = {
            batchSize: args.batchSize,
            bisectBatchOnFunctionError: args.bisectBatchOnFunctionError,
            destinationConfig: args.destinationConfig,
            enabled: true,
            eventSourceArn: stream.arn,
            functionName: this.func.name,
            maximumBatchingWindowInSeconds: args.maximumBatchingWindowInSeconds,
            maximumRecordAgeInSeconds: args.maximumRecordAgeInSeconds,
            maximumRetryAttempts: args.maximumRetryAttempts,
            parallelizationFactor: args.parallelizationFactor,
            startingPosition: args.startingPosition,
            startingPositionTimestamp: args.startingPositionTimestamp,
        };
        this.eventSourceMapping = new lambda.EventSourceMapping(name, mappingArgs, parentOpts);

        this.stream = stream;

        this.registerOutputs();
    }
}

function createFunctionFromEventHandler(
    name: string, handler: StreamEventHandler, opts?: pulumi.CustomResourceOptions): lambda.Function {

    if (handler instanceof Function) {
        return new lambda.CallbackFunction(name, {
            callback: handler,
            policies: [iam.ManagedPolicy.AWSLambdaFullAccess, iam.ManagedPolicy.AWSLambdaKinesisExecutionRole]
        } , opts);
    }
    else {
        return handler;
    }
}

declare module "./stream" {
    interface Stream {
        /**
         * Creates a new subscription to events fired from this Stream to the handler provided, along
         * with options to control the behavior of the subscription.
         */
        onEvent(name: string, handler: StreamEventHandler,
                args: StreamEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): StreamEventSubscription;
    }
}

stream.Stream.prototype.onEvent = function(this: stream.Stream, name, handler, args, opts) {
    return new StreamEventSubscription(name, this, handler, args, opts);
};
