// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS RDS (Relational Database) Export Task.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.rds.ExportTask("example", {
 *     exportTaskIdentifier: "example",
 *     sourceArn: exampleAwsDbSnapshot.dbSnapshotArn,
 *     s3BucketName: exampleAwsS3Bucket.id,
 *     iamRoleArn: exampleAwsIamRole.arn,
 *     kmsKeyId: exampleAwsKmsKey.arn,
 * });
 * ```
 *
 * ### Complete Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleBucketV2 = new aws.s3.BucketV2("example", {
 *     bucket: "example",
 *     forceDestroy: true,
 * });
 * const exampleBucketAclV2 = new aws.s3.BucketAclV2("example", {
 *     bucket: exampleBucketV2.id,
 *     acl: "private",
 * });
 * const exampleRole = new aws.iam.Role("example", {
 *     name: "example",
 *     assumeRolePolicy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Statement: [{
 *             Action: "sts:AssumeRole",
 *             Effect: "Allow",
 *             Sid: "",
 *             Principal: {
 *                 Service: "export.rds.amazonaws.com",
 *             },
 *         }],
 *     }),
 * });
 * const example = aws.iam.getPolicyDocumentOutput({
 *     statements: [
 *         {
 *             actions: ["s3:ListAllMyBuckets"],
 *             resources: ["*"],
 *         },
 *         {
 *             actions: [
 *                 "s3:GetBucketLocation",
 *                 "s3:ListBucket",
 *             ],
 *             resources: [exampleBucketV2.arn],
 *         },
 *         {
 *             actions: [
 *                 "s3:GetObject",
 *                 "s3:PutObject",
 *                 "s3:DeleteObject",
 *             ],
 *             resources: [pulumi.interpolate`${exampleBucketV2.arn}/*`],
 *         },
 *     ],
 * });
 * const examplePolicy = new aws.iam.Policy("example", {
 *     name: "example",
 *     policy: example.apply(example => example.json),
 * });
 * const exampleRolePolicyAttachment = new aws.iam.RolePolicyAttachment("example", {
 *     role: exampleRole.name,
 *     policyArn: examplePolicy.arn,
 * });
 * const exampleKey = new aws.kms.Key("example", {deletionWindowInDays: 10});
 * const exampleInstance = new aws.rds.Instance("example", {
 *     identifier: "example",
 *     allocatedStorage: 10,
 *     dbName: "test",
 *     engine: "mysql",
 *     engineVersion: "5.7",
 *     instanceClass: aws.rds.InstanceType.T3_Micro,
 *     username: "foo",
 *     password: "foobarbaz",
 *     parameterGroupName: "default.mysql5.7",
 *     skipFinalSnapshot: true,
 * });
 * const exampleSnapshot = new aws.rds.Snapshot("example", {
 *     dbInstanceIdentifier: exampleInstance.identifier,
 *     dbSnapshotIdentifier: "example",
 * });
 * const exampleExportTask = new aws.rds.ExportTask("example", {
 *     exportTaskIdentifier: "example",
 *     sourceArn: exampleSnapshot.dbSnapshotArn,
 *     s3BucketName: exampleBucketV2.id,
 *     iamRoleArn: exampleRole.arn,
 *     kmsKeyId: exampleKey.arn,
 *     exportOnlies: ["database"],
 *     s3Prefix: "my_prefix/example",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import a RDS (Relational Database) Export Task using the `export_task_identifier`. For example:
 *
 * ```sh
 * $ pulumi import aws:rds/exportTask:ExportTask example example
 * ```
 */
export class ExportTask extends pulumi.CustomResource {
    /**
     * Get an existing ExportTask resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ExportTaskState, opts?: pulumi.CustomResourceOptions): ExportTask {
        return new ExportTask(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:rds/exportTask:ExportTask';

    /**
     * Returns true if the given object is an instance of ExportTask.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ExportTask {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ExportTask.__pulumiType;
    }

    /**
     * Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
     */
    public readonly exportOnlies!: pulumi.Output<string[] | undefined>;
    /**
     * Unique identifier for the snapshot export task.
     */
    public readonly exportTaskIdentifier!: pulumi.Output<string>;
    /**
     * Reason the export failed, if it failed.
     */
    public /*out*/ readonly failureCause!: pulumi.Output<string>;
    /**
     * ARN of the IAM role to use for writing to the Amazon S3 bucket.
     */
    public readonly iamRoleArn!: pulumi.Output<string>;
    /**
     * ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
     */
    public readonly kmsKeyId!: pulumi.Output<string>;
    /**
     * Progress of the snapshot export task as a percentage.
     */
    public /*out*/ readonly percentProgress!: pulumi.Output<number>;
    /**
     * Name of the Amazon S3 bucket to export the snapshot to.
     */
    public readonly s3BucketName!: pulumi.Output<string>;
    /**
     * Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
     */
    public readonly s3Prefix!: pulumi.Output<string>;
    /**
     * Time that the snapshot was created.
     */
    public /*out*/ readonly snapshotTime!: pulumi.Output<string>;
    /**
     * Amazon Resource Name (ARN) of the snapshot to export.
     *
     * The following arguments are optional:
     */
    public readonly sourceArn!: pulumi.Output<string>;
    /**
     * Type of source for the export.
     */
    public /*out*/ readonly sourceType!: pulumi.Output<string>;
    /**
     * Status of the export task.
     */
    public /*out*/ readonly status!: pulumi.Output<string>;
    /**
     * Time that the snapshot export task completed.
     */
    public /*out*/ readonly taskEndTime!: pulumi.Output<string>;
    /**
     * Time that the snapshot export task started.
     */
    public /*out*/ readonly taskStartTime!: pulumi.Output<string>;
    public readonly timeouts!: pulumi.Output<outputs.rds.ExportTaskTimeouts | undefined>;
    /**
     * Warning about the snapshot export task, if any.
     */
    public /*out*/ readonly warningMessage!: pulumi.Output<string>;

    /**
     * Create a ExportTask resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ExportTaskArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ExportTaskArgs | ExportTaskState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ExportTaskState | undefined;
            resourceInputs["exportOnlies"] = state ? state.exportOnlies : undefined;
            resourceInputs["exportTaskIdentifier"] = state ? state.exportTaskIdentifier : undefined;
            resourceInputs["failureCause"] = state ? state.failureCause : undefined;
            resourceInputs["iamRoleArn"] = state ? state.iamRoleArn : undefined;
            resourceInputs["kmsKeyId"] = state ? state.kmsKeyId : undefined;
            resourceInputs["percentProgress"] = state ? state.percentProgress : undefined;
            resourceInputs["s3BucketName"] = state ? state.s3BucketName : undefined;
            resourceInputs["s3Prefix"] = state ? state.s3Prefix : undefined;
            resourceInputs["snapshotTime"] = state ? state.snapshotTime : undefined;
            resourceInputs["sourceArn"] = state ? state.sourceArn : undefined;
            resourceInputs["sourceType"] = state ? state.sourceType : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["taskEndTime"] = state ? state.taskEndTime : undefined;
            resourceInputs["taskStartTime"] = state ? state.taskStartTime : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
            resourceInputs["warningMessage"] = state ? state.warningMessage : undefined;
        } else {
            const args = argsOrState as ExportTaskArgs | undefined;
            if ((!args || args.exportTaskIdentifier === undefined) && !opts.urn) {
                throw new Error("Missing required property 'exportTaskIdentifier'");
            }
            if ((!args || args.iamRoleArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'iamRoleArn'");
            }
            if ((!args || args.kmsKeyId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'kmsKeyId'");
            }
            if ((!args || args.s3BucketName === undefined) && !opts.urn) {
                throw new Error("Missing required property 's3BucketName'");
            }
            if ((!args || args.sourceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'sourceArn'");
            }
            resourceInputs["exportOnlies"] = args ? args.exportOnlies : undefined;
            resourceInputs["exportTaskIdentifier"] = args ? args.exportTaskIdentifier : undefined;
            resourceInputs["iamRoleArn"] = args ? args.iamRoleArn : undefined;
            resourceInputs["kmsKeyId"] = args ? args.kmsKeyId : undefined;
            resourceInputs["s3BucketName"] = args ? args.s3BucketName : undefined;
            resourceInputs["s3Prefix"] = args ? args.s3Prefix : undefined;
            resourceInputs["sourceArn"] = args ? args.sourceArn : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
            resourceInputs["failureCause"] = undefined /*out*/;
            resourceInputs["percentProgress"] = undefined /*out*/;
            resourceInputs["snapshotTime"] = undefined /*out*/;
            resourceInputs["sourceType"] = undefined /*out*/;
            resourceInputs["status"] = undefined /*out*/;
            resourceInputs["taskEndTime"] = undefined /*out*/;
            resourceInputs["taskStartTime"] = undefined /*out*/;
            resourceInputs["warningMessage"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ExportTask.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ExportTask resources.
 */
export interface ExportTaskState {
    /**
     * Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
     */
    exportOnlies?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Unique identifier for the snapshot export task.
     */
    exportTaskIdentifier?: pulumi.Input<string>;
    /**
     * Reason the export failed, if it failed.
     */
    failureCause?: pulumi.Input<string>;
    /**
     * ARN of the IAM role to use for writing to the Amazon S3 bucket.
     */
    iamRoleArn?: pulumi.Input<string>;
    /**
     * ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
     */
    kmsKeyId?: pulumi.Input<string>;
    /**
     * Progress of the snapshot export task as a percentage.
     */
    percentProgress?: pulumi.Input<number>;
    /**
     * Name of the Amazon S3 bucket to export the snapshot to.
     */
    s3BucketName?: pulumi.Input<string>;
    /**
     * Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
     */
    s3Prefix?: pulumi.Input<string>;
    /**
     * Time that the snapshot was created.
     */
    snapshotTime?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the snapshot to export.
     *
     * The following arguments are optional:
     */
    sourceArn?: pulumi.Input<string>;
    /**
     * Type of source for the export.
     */
    sourceType?: pulumi.Input<string>;
    /**
     * Status of the export task.
     */
    status?: pulumi.Input<string>;
    /**
     * Time that the snapshot export task completed.
     */
    taskEndTime?: pulumi.Input<string>;
    /**
     * Time that the snapshot export task started.
     */
    taskStartTime?: pulumi.Input<string>;
    timeouts?: pulumi.Input<inputs.rds.ExportTaskTimeouts>;
    /**
     * Warning about the snapshot export task, if any.
     */
    warningMessage?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ExportTask resource.
 */
export interface ExportTaskArgs {
    /**
     * Data to be exported from the snapshot. If this parameter is not provided, all the snapshot data is exported. Valid values are documented in the [AWS StartExportTask API documentation](https://docs.aws.amazon.com/AmazonRDS/latest/APIReference/API_StartExportTask.html#API_StartExportTask_RequestParameters).
     */
    exportOnlies?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Unique identifier for the snapshot export task.
     */
    exportTaskIdentifier: pulumi.Input<string>;
    /**
     * ARN of the IAM role to use for writing to the Amazon S3 bucket.
     */
    iamRoleArn: pulumi.Input<string>;
    /**
     * ID of the Amazon Web Services KMS key to use to encrypt the snapshot.
     */
    kmsKeyId: pulumi.Input<string>;
    /**
     * Name of the Amazon S3 bucket to export the snapshot to.
     */
    s3BucketName: pulumi.Input<string>;
    /**
     * Amazon S3 bucket prefix to use as the file name and path of the exported snapshot.
     */
    s3Prefix?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the snapshot to export.
     *
     * The following arguments are optional:
     */
    sourceArn: pulumi.Input<string>;
    timeouts?: pulumi.Input<inputs.rds.ExportTaskTimeouts>;
}
