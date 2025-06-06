// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Timestream Query Scheduled Query.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * Before creating a scheduled query, you must have a source database and table with ingested data. Below is a multi-step example, providing an opportunity for data ingestion.
 *
 * If your infrastructure is already set up—including the source database and table with data, results database and table, error report S3 bucket, SNS topic, and IAM role—you can create a scheduled query as follows:
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.timestreamquery.ScheduledQuery("example", {
 *     executionRoleArn: exampleAwsIamRole.arn,
 *     name: exampleAwsTimestreamwriteTable.tableName,
 *     queryString: `SELECT region, az, hostname, BIN(time, 15s) AS binned_timestamp,
 * \x09ROUND(AVG(cpu_utilization), 2) AS avg_cpu_utilization,
 * \x09ROUND(APPROX_PERCENTILE(cpu_utilization, 0.9), 2) AS p90_cpu_utilization,
 * \x09ROUND(APPROX_PERCENTILE(cpu_utilization, 0.95), 2) AS p95_cpu_utilization,
 * \x09ROUND(APPROX_PERCENTILE(cpu_utilization, 0.99), 2) AS p99_cpu_utilization
 * FROM exampledatabase.exampletable
 * WHERE measure_name = 'metrics' AND time > ago(2h)
 * GROUP BY region, hostname, az, BIN(time, 15s)
 * ORDER BY binned_timestamp ASC
 * LIMIT 5
 * `,
 *     errorReportConfiguration: {
 *         s3Configuration: {
 *             bucketName: exampleAwsS3Bucket.bucket,
 *         },
 *     },
 *     notificationConfiguration: {
 *         snsConfiguration: {
 *             topicArn: exampleAwsSnsTopic.arn,
 *         },
 *     },
 *     scheduleConfiguration: {
 *         scheduleExpression: "rate(1 hour)",
 *     },
 *     targetConfiguration: {
 *         timestreamConfiguration: {
 *             databaseName: results.databaseName,
 *             tableName: resultsAwsTimestreamwriteTable.tableName,
 *             timeColumn: "binned_timestamp",
 *             dimensionMappings: [
 *                 {
 *                     dimensionValueType: "VARCHAR",
 *                     name: "az",
 *                 },
 *                 {
 *                     dimensionValueType: "VARCHAR",
 *                     name: "region",
 *                 },
 *                 {
 *                     dimensionValueType: "VARCHAR",
 *                     name: "hostname",
 *                 },
 *             ],
 *             multiMeasureMappings: {
 *                 targetMultiMeasureName: "multi-metrics",
 *                 multiMeasureAttributeMappings: [
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "avg_cpu_utilization",
 *                     },
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "p90_cpu_utilization",
 *                     },
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "p95_cpu_utilization",
 *                     },
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "p99_cpu_utilization",
 *                     },
 *                 ],
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ### Multi-step Example
 *
 * To ingest data before creating a scheduled query, this example provides multiple steps:
 *
 * 1. Create the prerequisite infrastructure
 * 2. Ingest data
 * 3. Create the scheduled query
 *
 * ### Step 1. Create the prerequisite infrastructure
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.s3.BucketV2("test", {
 *     bucket: "example",
 *     forceDestroy: true,
 * });
 * const testTopic = new aws.sns.Topic("test", {name: "example"});
 * const testQueue = new aws.sqs.Queue("test", {
 *     name: "example",
 *     sqsManagedSseEnabled: true,
 * });
 * const testTopicSubscription = new aws.sns.TopicSubscription("test", {
 *     topic: testTopic.arn,
 *     protocol: "sqs",
 *     endpoint: testQueue.arn,
 * });
 * const testQueuePolicy = new aws.sqs.QueuePolicy("test", {
 *     queueUrl: testQueue.id,
 *     policy: pulumi.jsonStringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Effect: "Allow",
 *             Principal: {
 *                 AWS: "*",
 *             },
 *             Action: ["sqs:SendMessage"],
 *             Resource: testQueue.arn,
 *             Condition: {
 *                 ArnEquals: {
 *                     "aws:SourceArn": testTopic.arn,
 *                 },
 *             },
 *         }],
 *     }),
 * });
 * const testRole = new aws.iam.Role("test", {
 *     name: "example",
 *     assumeRolePolicy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Effect: "Allow",
 *             Principal: {
 *                 Service: "timestream.amazonaws.com",
 *             },
 *             Action: "sts:AssumeRole",
 *         }],
 *     }),
 *     tags: {
 *         Name: "example",
 *     },
 * });
 * const testRolePolicy = new aws.iam.RolePolicy("test", {
 *     name: "example",
 *     role: testRole.id,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Action: [
 *                 "kms:Decrypt",
 *                 "sns:Publish",
 *                 "timestream:describeEndpoints",
 *                 "timestream:Select",
 *                 "timestream:SelectValues",
 *                 "timestream:WriteRecords",
 *                 "s3:PutObject",
 *             ],
 *             Resource: "*",
 *             Effect: "Allow",
 *         }],
 *     }),
 * });
 * const testDatabase = new aws.timestreamwrite.Database("test", {databaseName: "exampledatabase"});
 * const testTable = new aws.timestreamwrite.Table("test", {
 *     databaseName: testDatabase.databaseName,
 *     tableName: "exampletable",
 *     magneticStoreWriteProperties: {
 *         enableMagneticStoreWrites: true,
 *     },
 *     retentionProperties: {
 *         magneticStoreRetentionPeriodInDays: 1,
 *         memoryStoreRetentionPeriodInHours: 1,
 *     },
 * });
 * const results = new aws.timestreamwrite.Database("results", {databaseName: "exampledatabase-results"});
 * const resultsTable = new aws.timestreamwrite.Table("results", {
 *     databaseName: results.databaseName,
 *     tableName: "exampletable-results",
 *     magneticStoreWriteProperties: {
 *         enableMagneticStoreWrites: true,
 *     },
 *     retentionProperties: {
 *         magneticStoreRetentionPeriodInDays: 1,
 *         memoryStoreRetentionPeriodInHours: 1,
 *     },
 * });
 * ```
 *
 * #### Step 2. Ingest data
 *
 * This is done with Amazon Timestream Write [WriteRecords](https://docs.aws.amazon.com/timestream/latest/developerguide/API_WriteRecords.html).
 *
 * ### Step 3. Create the scheduled query
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.timestreamquery.ScheduledQuery("example", {
 *     executionRoleArn: exampleAwsIamRole.arn,
 *     name: exampleAwsTimestreamwriteTable.tableName,
 *     queryString: `SELECT region, az, hostname, BIN(time, 15s) AS binned_timestamp,
 * \x09ROUND(AVG(cpu_utilization), 2) AS avg_cpu_utilization,
 * \x09ROUND(APPROX_PERCENTILE(cpu_utilization, 0.9), 2) AS p90_cpu_utilization,
 * \x09ROUND(APPROX_PERCENTILE(cpu_utilization, 0.95), 2) AS p95_cpu_utilization,
 * \x09ROUND(APPROX_PERCENTILE(cpu_utilization, 0.99), 2) AS p99_cpu_utilization
 * FROM exampledatabase.exampletable
 * WHERE measure_name = 'metrics' AND time > ago(2h)
 * GROUP BY region, hostname, az, BIN(time, 15s)
 * ORDER BY binned_timestamp ASC
 * LIMIT 5
 * `,
 *     errorReportConfiguration: {
 *         s3Configuration: {
 *             bucketName: exampleAwsS3Bucket.bucket,
 *         },
 *     },
 *     notificationConfiguration: {
 *         snsConfiguration: {
 *             topicArn: exampleAwsSnsTopic.arn,
 *         },
 *     },
 *     scheduleConfiguration: {
 *         scheduleExpression: "rate(1 hour)",
 *     },
 *     targetConfiguration: {
 *         timestreamConfiguration: {
 *             databaseName: results.databaseName,
 *             tableName: resultsAwsTimestreamwriteTable.tableName,
 *             timeColumn: "binned_timestamp",
 *             dimensionMappings: [
 *                 {
 *                     dimensionValueType: "VARCHAR",
 *                     name: "az",
 *                 },
 *                 {
 *                     dimensionValueType: "VARCHAR",
 *                     name: "region",
 *                 },
 *                 {
 *                     dimensionValueType: "VARCHAR",
 *                     name: "hostname",
 *                 },
 *             ],
 *             multiMeasureMappings: {
 *                 targetMultiMeasureName: "multi-metrics",
 *                 multiMeasureAttributeMappings: [
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "avg_cpu_utilization",
 *                     },
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "p90_cpu_utilization",
 *                     },
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "p95_cpu_utilization",
 *                     },
 *                     {
 *                         measureValueType: "DOUBLE",
 *                         sourceColumn: "p99_cpu_utilization",
 *                     },
 *                 ],
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Timestream Query Scheduled Query using the `arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:timestreamquery/scheduledQuery:ScheduledQuery example arn:aws:timestream:us-west-2:012345678901:scheduled-query/tf-acc-test-7774188528604787105-e13659544fe66c8d
 * ```
 */
export class ScheduledQuery extends pulumi.CustomResource {
    /**
     * Get an existing ScheduledQuery resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ScheduledQueryState, opts?: pulumi.CustomResourceOptions): ScheduledQuery {
        return new ScheduledQuery(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:timestreamquery/scheduledQuery:ScheduledQuery';

    /**
     * Returns true if the given object is an instance of ScheduledQuery.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ScheduledQuery {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ScheduledQuery.__pulumiType;
    }

    /**
     * ARN of the Scheduled Query.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Creation time for the scheduled query.
     */
    public /*out*/ readonly creationTime!: pulumi.Output<string>;
    /**
     * Configuration block for error reporting configuration. See below.
     */
    public readonly errorReportConfiguration!: pulumi.Output<outputs.timestreamquery.ScheduledQueryErrorReportConfiguration>;
    /**
     * ARN for the IAM role that Timestream will assume when running the scheduled query.
     */
    public readonly executionRoleArn!: pulumi.Output<string>;
    /**
     * Amazon KMS key used to encrypt the scheduled query resource, at-rest. If not specified, the scheduled query resource will be encrypted with a Timestream owned Amazon KMS key. To specify a KMS key, use the key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix the name with "alias/". If `errorReportConfiguration` uses `SSE_KMS` as the encryption type, the same `kmsKeyId` is used to encrypt the error report at rest.
     */
    public readonly kmsKeyId!: pulumi.Output<string | undefined>;
    /**
     * Runtime summary for the last scheduled query run.
     */
    public readonly lastRunSummaries!: pulumi.Output<outputs.timestreamquery.ScheduledQueryLastRunSummary[] | undefined>;
    /**
     * Name of the scheduled query.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Next time the scheduled query is scheduled to run.
     */
    public /*out*/ readonly nextInvocationTime!: pulumi.Output<string>;
    /**
     * Configuration block for notification configuration for a scheduled query. A notification is sent by Timestream when a scheduled query is created, its state is updated, or when it is deleted. See below.
     */
    public readonly notificationConfiguration!: pulumi.Output<outputs.timestreamquery.ScheduledQueryNotificationConfiguration>;
    /**
     * Last time the scheduled query was run.
     */
    public /*out*/ readonly previousInvocationTime!: pulumi.Output<string>;
    /**
     * Query string to run. Parameter names can be specified in the query string using the `@` character followed by an identifier. The named parameter `@scheduled_runtime` is reserved and can be used in the query to get the time at which the query is scheduled to run. The timestamp calculated according to the `scheduleConfiguration` parameter, will be the value of `@scheduled_runtime` paramater for each query run. For example, consider an instance of a scheduled query executing on 2021-12-01 00:00:00. For this instance, the `@scheduled_runtime` parameter is initialized to the timestamp 2021-12-01 00:00:00 when invoking the query.
     */
    public readonly queryString!: pulumi.Output<string>;
    /**
     * Runtime summary for the last five failed scheduled query runs.
     */
    public readonly recentlyFailedRuns!: pulumi.Output<outputs.timestreamquery.ScheduledQueryRecentlyFailedRun[] | undefined>;
    /**
     * Configuration block for schedule configuration for the query. See below.
     */
    public readonly scheduleConfiguration!: pulumi.Output<outputs.timestreamquery.ScheduledQueryScheduleConfiguration>;
    /**
     * State of the scheduled query, either `ENABLED` or `DISABLED`.
     */
    public /*out*/ readonly state!: pulumi.Output<string>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Configuration block for writing the result of a query. See below.
     *
     * The following arguments are optional:
     */
    public readonly targetConfiguration!: pulumi.Output<outputs.timestreamquery.ScheduledQueryTargetConfiguration>;
    public readonly timeouts!: pulumi.Output<outputs.timestreamquery.ScheduledQueryTimeouts | undefined>;

    /**
     * Create a ScheduledQuery resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ScheduledQueryArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ScheduledQueryArgs | ScheduledQueryState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ScheduledQueryState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["creationTime"] = state ? state.creationTime : undefined;
            resourceInputs["errorReportConfiguration"] = state ? state.errorReportConfiguration : undefined;
            resourceInputs["executionRoleArn"] = state ? state.executionRoleArn : undefined;
            resourceInputs["kmsKeyId"] = state ? state.kmsKeyId : undefined;
            resourceInputs["lastRunSummaries"] = state ? state.lastRunSummaries : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["nextInvocationTime"] = state ? state.nextInvocationTime : undefined;
            resourceInputs["notificationConfiguration"] = state ? state.notificationConfiguration : undefined;
            resourceInputs["previousInvocationTime"] = state ? state.previousInvocationTime : undefined;
            resourceInputs["queryString"] = state ? state.queryString : undefined;
            resourceInputs["recentlyFailedRuns"] = state ? state.recentlyFailedRuns : undefined;
            resourceInputs["scheduleConfiguration"] = state ? state.scheduleConfiguration : undefined;
            resourceInputs["state"] = state ? state.state : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["targetConfiguration"] = state ? state.targetConfiguration : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
        } else {
            const args = argsOrState as ScheduledQueryArgs | undefined;
            if ((!args || args.errorReportConfiguration === undefined) && !opts.urn) {
                throw new Error("Missing required property 'errorReportConfiguration'");
            }
            if ((!args || args.executionRoleArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'executionRoleArn'");
            }
            if ((!args || args.notificationConfiguration === undefined) && !opts.urn) {
                throw new Error("Missing required property 'notificationConfiguration'");
            }
            if ((!args || args.queryString === undefined) && !opts.urn) {
                throw new Error("Missing required property 'queryString'");
            }
            if ((!args || args.scheduleConfiguration === undefined) && !opts.urn) {
                throw new Error("Missing required property 'scheduleConfiguration'");
            }
            if ((!args || args.targetConfiguration === undefined) && !opts.urn) {
                throw new Error("Missing required property 'targetConfiguration'");
            }
            resourceInputs["errorReportConfiguration"] = args ? args.errorReportConfiguration : undefined;
            resourceInputs["executionRoleArn"] = args ? args.executionRoleArn : undefined;
            resourceInputs["kmsKeyId"] = args ? args.kmsKeyId : undefined;
            resourceInputs["lastRunSummaries"] = args ? args.lastRunSummaries : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["notificationConfiguration"] = args ? args.notificationConfiguration : undefined;
            resourceInputs["queryString"] = args ? args.queryString : undefined;
            resourceInputs["recentlyFailedRuns"] = args ? args.recentlyFailedRuns : undefined;
            resourceInputs["scheduleConfiguration"] = args ? args.scheduleConfiguration : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["targetConfiguration"] = args ? args.targetConfiguration : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["creationTime"] = undefined /*out*/;
            resourceInputs["nextInvocationTime"] = undefined /*out*/;
            resourceInputs["previousInvocationTime"] = undefined /*out*/;
            resourceInputs["state"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ScheduledQuery.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ScheduledQuery resources.
 */
export interface ScheduledQueryState {
    /**
     * ARN of the Scheduled Query.
     */
    arn?: pulumi.Input<string>;
    /**
     * Creation time for the scheduled query.
     */
    creationTime?: pulumi.Input<string>;
    /**
     * Configuration block for error reporting configuration. See below.
     */
    errorReportConfiguration?: pulumi.Input<inputs.timestreamquery.ScheduledQueryErrorReportConfiguration>;
    /**
     * ARN for the IAM role that Timestream will assume when running the scheduled query.
     */
    executionRoleArn?: pulumi.Input<string>;
    /**
     * Amazon KMS key used to encrypt the scheduled query resource, at-rest. If not specified, the scheduled query resource will be encrypted with a Timestream owned Amazon KMS key. To specify a KMS key, use the key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix the name with "alias/". If `errorReportConfiguration` uses `SSE_KMS` as the encryption type, the same `kmsKeyId` is used to encrypt the error report at rest.
     */
    kmsKeyId?: pulumi.Input<string>;
    /**
     * Runtime summary for the last scheduled query run.
     */
    lastRunSummaries?: pulumi.Input<pulumi.Input<inputs.timestreamquery.ScheduledQueryLastRunSummary>[]>;
    /**
     * Name of the scheduled query.
     */
    name?: pulumi.Input<string>;
    /**
     * Next time the scheduled query is scheduled to run.
     */
    nextInvocationTime?: pulumi.Input<string>;
    /**
     * Configuration block for notification configuration for a scheduled query. A notification is sent by Timestream when a scheduled query is created, its state is updated, or when it is deleted. See below.
     */
    notificationConfiguration?: pulumi.Input<inputs.timestreamquery.ScheduledQueryNotificationConfiguration>;
    /**
     * Last time the scheduled query was run.
     */
    previousInvocationTime?: pulumi.Input<string>;
    /**
     * Query string to run. Parameter names can be specified in the query string using the `@` character followed by an identifier. The named parameter `@scheduled_runtime` is reserved and can be used in the query to get the time at which the query is scheduled to run. The timestamp calculated according to the `scheduleConfiguration` parameter, will be the value of `@scheduled_runtime` paramater for each query run. For example, consider an instance of a scheduled query executing on 2021-12-01 00:00:00. For this instance, the `@scheduled_runtime` parameter is initialized to the timestamp 2021-12-01 00:00:00 when invoking the query.
     */
    queryString?: pulumi.Input<string>;
    /**
     * Runtime summary for the last five failed scheduled query runs.
     */
    recentlyFailedRuns?: pulumi.Input<pulumi.Input<inputs.timestreamquery.ScheduledQueryRecentlyFailedRun>[]>;
    /**
     * Configuration block for schedule configuration for the query. See below.
     */
    scheduleConfiguration?: pulumi.Input<inputs.timestreamquery.ScheduledQueryScheduleConfiguration>;
    /**
     * State of the scheduled query, either `ENABLED` or `DISABLED`.
     */
    state?: pulumi.Input<string>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block for writing the result of a query. See below.
     *
     * The following arguments are optional:
     */
    targetConfiguration?: pulumi.Input<inputs.timestreamquery.ScheduledQueryTargetConfiguration>;
    timeouts?: pulumi.Input<inputs.timestreamquery.ScheduledQueryTimeouts>;
}

/**
 * The set of arguments for constructing a ScheduledQuery resource.
 */
export interface ScheduledQueryArgs {
    /**
     * Configuration block for error reporting configuration. See below.
     */
    errorReportConfiguration: pulumi.Input<inputs.timestreamquery.ScheduledQueryErrorReportConfiguration>;
    /**
     * ARN for the IAM role that Timestream will assume when running the scheduled query.
     */
    executionRoleArn: pulumi.Input<string>;
    /**
     * Amazon KMS key used to encrypt the scheduled query resource, at-rest. If not specified, the scheduled query resource will be encrypted with a Timestream owned Amazon KMS key. To specify a KMS key, use the key ID, key ARN, alias name, or alias ARN. When using an alias name, prefix the name with "alias/". If `errorReportConfiguration` uses `SSE_KMS` as the encryption type, the same `kmsKeyId` is used to encrypt the error report at rest.
     */
    kmsKeyId?: pulumi.Input<string>;
    /**
     * Runtime summary for the last scheduled query run.
     */
    lastRunSummaries?: pulumi.Input<pulumi.Input<inputs.timestreamquery.ScheduledQueryLastRunSummary>[]>;
    /**
     * Name of the scheduled query.
     */
    name?: pulumi.Input<string>;
    /**
     * Configuration block for notification configuration for a scheduled query. A notification is sent by Timestream when a scheduled query is created, its state is updated, or when it is deleted. See below.
     */
    notificationConfiguration: pulumi.Input<inputs.timestreamquery.ScheduledQueryNotificationConfiguration>;
    /**
     * Query string to run. Parameter names can be specified in the query string using the `@` character followed by an identifier. The named parameter `@scheduled_runtime` is reserved and can be used in the query to get the time at which the query is scheduled to run. The timestamp calculated according to the `scheduleConfiguration` parameter, will be the value of `@scheduled_runtime` paramater for each query run. For example, consider an instance of a scheduled query executing on 2021-12-01 00:00:00. For this instance, the `@scheduled_runtime` parameter is initialized to the timestamp 2021-12-01 00:00:00 when invoking the query.
     */
    queryString: pulumi.Input<string>;
    /**
     * Runtime summary for the last five failed scheduled query runs.
     */
    recentlyFailedRuns?: pulumi.Input<pulumi.Input<inputs.timestreamquery.ScheduledQueryRecentlyFailedRun>[]>;
    /**
     * Configuration block for schedule configuration for the query. See below.
     */
    scheduleConfiguration: pulumi.Input<inputs.timestreamquery.ScheduledQueryScheduleConfiguration>;
    /**
     * Map of tags assigned to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block for writing the result of a query. See below.
     *
     * The following arguments are optional:
     */
    targetConfiguration: pulumi.Input<inputs.timestreamquery.ScheduledQueryTargetConfiguration>;
    timeouts?: pulumi.Input<inputs.timestreamquery.ScheduledQueryTimeouts>;
}
