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
import * as table from "./table";
import * as lambda from "../lambda";

import * as utils from "../utils";

/**
 * Arguments to control the event rule subscription.  Currently empty, but still defined in case of
 * future need.
 */
export interface TableEventSubscriptionArgs {
    /**
     * The largest number of records that Lambda will retrieve from your event source at the time of invocation. Defaults to `100` for DynamoDB.
     */
    readonly batchSize?: number;

    /**
     * The position in the stream where AWS Lambda should start reading. Must be one of either `TRIM_HORIZON` or `LATEST`.
     */
    readonly startingPosition: "TRIM_HORIZON" | "LATEST";
}

export interface TableEvent {
    Records: TableEventRecord[];
}

export interface TableEventRecord {
    awsRegion: string;
    dynamodb: {
       ApproximateCreationDateTime: number;
       Keys: Record<string, any>;
       NewImage?: Record<string, any>;
       OldImage?: Record<string, any>;
       SequenceNumber: string;
       SizeBytes: number;
       StreamViewType: string;
    };
    eventID: string;
    eventName: "INSERT" | "MODIFY" | "REMOVE";
    eventSource: string;
    eventVersion: string;
    userIdentity: {
       PrincipalId: string;
       Type: string;
    };
}

export type TableEventHandler = lambda.EventHandler<TableEvent, void>;

export class TableEventSubscription extends lambda.EventSubscription {
    public readonly table: table.Table;
    public readonly eventSourceMapping: lambda.EventSourceMapping;

    constructor(
        name: string, table: table.Table, handler: TableEventHandler,
        args: TableEventSubscriptionArgs, opts: pulumi.ComponentResourceOptions = {}) {

        // We previously did not parent the subscription to the table. We now do. Provide an alias
        // so this doesn't cause resources to be destroyed/recreated for existing stacks.
        super("aws:dynamodb:TableEventSubscription", name, {
            parent: table,
            ...utils.withAlias(opts, { parent: opts.parent }),
        });

        const streamArn = pulumi.all([table.streamEnabled, table.streamArn])
                                .apply(([streamEnabled, streamArn]) => {
            if (!streamEnabled) {
                throw new pulumi.ResourceError("Table must be created with `streamEnabled: true` to support listening for events.", this)
            }

            return streamArn;
        });

        const parentOpts = { parent: this };
        this.func = lambda.createFunctionFromEventHandler(name, handler, parentOpts);

        this.permission = new lambda.Permission(name, {
            function: this.func,
            action: "lambda:InvokeFunction",
            principal: "dynamodb.amazonaws.com",
            sourceArn: streamArn,
        }, parentOpts);

        this.eventSourceMapping = new lambda.EventSourceMapping(name, {
            batchSize: args.batchSize,
            enabled: true,
            eventSourceArn: streamArn,
            functionName: this.func.name,
            startingPosition: args.startingPosition,
        }, parentOpts);

        this.table = table;

        this.registerOutputs();
    }
}

declare module "./table" {
    interface Table {
        /**
         * Creates a new subscription to events fired from this Table to the handler provided,
         * along with options to control the behavior of the subscription.
         *
         * In order to receive events the [Table] must have been created with the `streamEnabled: true`
         * value as well as an appropriate `streamViewType`.
         */
        onEvent(name: string, handler: TableEventHandler,
                args: TableEventSubscriptionArgs, opts?: pulumi.ComponentResourceOptions): TableEventSubscription;
    }
}

table.Table.prototype.onEvent = function(this: table.Table, name, handler, args, opts) {
    return new TableEventSubscription(name, this, handler, args, opts);
}
