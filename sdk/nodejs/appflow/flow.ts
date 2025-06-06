// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides an AppFlow flow resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleSourceBucketV2 = new aws.s3.BucketV2("example_source", {bucket: "example-source"});
 * const exampleSource = aws.iam.getPolicyDocument({
 *     statements: [{
 *         sid: "AllowAppFlowSourceActions",
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["appflow.amazonaws.com"],
 *         }],
 *         actions: [
 *             "s3:ListBucket",
 *             "s3:GetObject",
 *         ],
 *         resources: [
 *             "arn:aws:s3:::example-source",
 *             "arn:aws:s3:::example-source/*",
 *         ],
 *     }],
 * });
 * const exampleSourceBucketPolicy = new aws.s3.BucketPolicy("example_source", {
 *     bucket: exampleSourceBucketV2.id,
 *     policy: exampleSource.then(exampleSource => exampleSource.json),
 * });
 * const example = new aws.s3.BucketObjectv2("example", {
 *     bucket: exampleSourceBucketV2.id,
 *     key: "example_source.csv",
 *     source: new pulumi.asset.FileAsset("example_source.csv"),
 * });
 * const exampleDestinationBucketV2 = new aws.s3.BucketV2("example_destination", {bucket: "example-destination"});
 * const exampleDestination = aws.iam.getPolicyDocument({
 *     statements: [{
 *         sid: "AllowAppFlowDestinationActions",
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["appflow.amazonaws.com"],
 *         }],
 *         actions: [
 *             "s3:PutObject",
 *             "s3:AbortMultipartUpload",
 *             "s3:ListMultipartUploadParts",
 *             "s3:ListBucketMultipartUploads",
 *             "s3:GetBucketAcl",
 *             "s3:PutObjectAcl",
 *         ],
 *         resources: [
 *             "arn:aws:s3:::example-destination",
 *             "arn:aws:s3:::example-destination/*",
 *         ],
 *     }],
 * });
 * const exampleDestinationBucketPolicy = new aws.s3.BucketPolicy("example_destination", {
 *     bucket: exampleDestinationBucketV2.id,
 *     policy: exampleDestination.then(exampleDestination => exampleDestination.json),
 * });
 * const exampleFlow = new aws.appflow.Flow("example", {
 *     name: "example",
 *     sourceFlowConfig: {
 *         connectorType: "S3",
 *         sourceConnectorProperties: {
 *             s3: {
 *                 bucketName: exampleSourceBucketPolicy.bucket,
 *                 bucketPrefix: "example",
 *             },
 *         },
 *     },
 *     destinationFlowConfigs: [{
 *         connectorType: "S3",
 *         destinationConnectorProperties: {
 *             s3: {
 *                 bucketName: exampleDestinationBucketPolicy.bucket,
 *                 s3OutputFormatConfig: {
 *                     prefixConfig: {
 *                         prefixType: "PATH",
 *                     },
 *                 },
 *             },
 *         },
 *     }],
 *     tasks: [{
 *         sourceFields: ["exampleField"],
 *         destinationField: "exampleField",
 *         taskType: "Map",
 *         connectorOperators: [{
 *             s3: "NO_OP",
 *         }],
 *     }],
 *     triggerConfig: {
 *         triggerType: "OnDemand",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import AppFlow flows using the `arn`. For example:
 *
 * ```sh
 * $ pulumi import aws:appflow/flow:Flow example arn:aws:appflow:us-west-2:123456789012:flow/example-flow
 * ```
 */
export class Flow extends pulumi.CustomResource {
    /**
     * Get an existing Flow resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: FlowState, opts?: pulumi.CustomResourceOptions): Flow {
        return new Flow(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:appflow/flow:Flow';

    /**
     * Returns true if the given object is an instance of Flow.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Flow {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Flow.__pulumiType;
    }

    /**
     * Flow's ARN.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Description of the flow you want to create.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * A Destination Flow Config that controls how Amazon AppFlow places data in the destination connector.
     */
    public readonly destinationFlowConfigs!: pulumi.Output<outputs.appflow.FlowDestinationFlowConfig[]>;
    /**
     * The current status of the flow.
     */
    public /*out*/ readonly flowStatus!: pulumi.Output<string>;
    /**
     * ARN (Amazon Resource Name) of the Key Management Service (KMS) key you provide for encryption. This is required if you do not want to use the Amazon AppFlow-managed KMS key. If you don't provide anything here, Amazon AppFlow uses the Amazon AppFlow-managed KMS key.
     */
    public readonly kmsArn!: pulumi.Output<string>;
    /**
     * A Catalog that determines the configuration that Amazon AppFlow uses when it catalogs the data that’s transferred by the associated flow. When Amazon AppFlow catalogs the data from a flow, it stores metadata in a data catalog.
     */
    public readonly metadataCatalogConfig!: pulumi.Output<outputs.appflow.FlowMetadataCatalogConfig>;
    /**
     * Name of the flow.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The Source Flow Config that controls how Amazon AppFlow retrieves data from the source connector.
     */
    public readonly sourceFlowConfig!: pulumi.Output<outputs.appflow.FlowSourceFlowConfig>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * A Task that Amazon AppFlow performs while transferring the data in the flow run.
     */
    public readonly tasks!: pulumi.Output<outputs.appflow.FlowTask[]>;
    /**
     * A Trigger that determine how and when the flow runs.
     */
    public readonly triggerConfig!: pulumi.Output<outputs.appflow.FlowTriggerConfig>;

    /**
     * Create a Flow resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: FlowArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: FlowArgs | FlowState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as FlowState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["destinationFlowConfigs"] = state ? state.destinationFlowConfigs : undefined;
            resourceInputs["flowStatus"] = state ? state.flowStatus : undefined;
            resourceInputs["kmsArn"] = state ? state.kmsArn : undefined;
            resourceInputs["metadataCatalogConfig"] = state ? state.metadataCatalogConfig : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["sourceFlowConfig"] = state ? state.sourceFlowConfig : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["tasks"] = state ? state.tasks : undefined;
            resourceInputs["triggerConfig"] = state ? state.triggerConfig : undefined;
        } else {
            const args = argsOrState as FlowArgs | undefined;
            if ((!args || args.destinationFlowConfigs === undefined) && !opts.urn) {
                throw new Error("Missing required property 'destinationFlowConfigs'");
            }
            if ((!args || args.sourceFlowConfig === undefined) && !opts.urn) {
                throw new Error("Missing required property 'sourceFlowConfig'");
            }
            if ((!args || args.tasks === undefined) && !opts.urn) {
                throw new Error("Missing required property 'tasks'");
            }
            if ((!args || args.triggerConfig === undefined) && !opts.urn) {
                throw new Error("Missing required property 'triggerConfig'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["destinationFlowConfigs"] = args ? args.destinationFlowConfigs : undefined;
            resourceInputs["kmsArn"] = args ? args.kmsArn : undefined;
            resourceInputs["metadataCatalogConfig"] = args ? args.metadataCatalogConfig : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["sourceFlowConfig"] = args ? args.sourceFlowConfig : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["tasks"] = args ? args.tasks : undefined;
            resourceInputs["triggerConfig"] = args ? args.triggerConfig : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["flowStatus"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Flow.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Flow resources.
 */
export interface FlowState {
    /**
     * Flow's ARN.
     */
    arn?: pulumi.Input<string>;
    /**
     * Description of the flow you want to create.
     */
    description?: pulumi.Input<string>;
    /**
     * A Destination Flow Config that controls how Amazon AppFlow places data in the destination connector.
     */
    destinationFlowConfigs?: pulumi.Input<pulumi.Input<inputs.appflow.FlowDestinationFlowConfig>[]>;
    /**
     * The current status of the flow.
     */
    flowStatus?: pulumi.Input<string>;
    /**
     * ARN (Amazon Resource Name) of the Key Management Service (KMS) key you provide for encryption. This is required if you do not want to use the Amazon AppFlow-managed KMS key. If you don't provide anything here, Amazon AppFlow uses the Amazon AppFlow-managed KMS key.
     */
    kmsArn?: pulumi.Input<string>;
    /**
     * A Catalog that determines the configuration that Amazon AppFlow uses when it catalogs the data that’s transferred by the associated flow. When Amazon AppFlow catalogs the data from a flow, it stores metadata in a data catalog.
     */
    metadataCatalogConfig?: pulumi.Input<inputs.appflow.FlowMetadataCatalogConfig>;
    /**
     * Name of the flow.
     */
    name?: pulumi.Input<string>;
    /**
     * The Source Flow Config that controls how Amazon AppFlow retrieves data from the source connector.
     */
    sourceFlowConfig?: pulumi.Input<inputs.appflow.FlowSourceFlowConfig>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A Task that Amazon AppFlow performs while transferring the data in the flow run.
     */
    tasks?: pulumi.Input<pulumi.Input<inputs.appflow.FlowTask>[]>;
    /**
     * A Trigger that determine how and when the flow runs.
     */
    triggerConfig?: pulumi.Input<inputs.appflow.FlowTriggerConfig>;
}

/**
 * The set of arguments for constructing a Flow resource.
 */
export interface FlowArgs {
    /**
     * Description of the flow you want to create.
     */
    description?: pulumi.Input<string>;
    /**
     * A Destination Flow Config that controls how Amazon AppFlow places data in the destination connector.
     */
    destinationFlowConfigs: pulumi.Input<pulumi.Input<inputs.appflow.FlowDestinationFlowConfig>[]>;
    /**
     * ARN (Amazon Resource Name) of the Key Management Service (KMS) key you provide for encryption. This is required if you do not want to use the Amazon AppFlow-managed KMS key. If you don't provide anything here, Amazon AppFlow uses the Amazon AppFlow-managed KMS key.
     */
    kmsArn?: pulumi.Input<string>;
    /**
     * A Catalog that determines the configuration that Amazon AppFlow uses when it catalogs the data that’s transferred by the associated flow. When Amazon AppFlow catalogs the data from a flow, it stores metadata in a data catalog.
     */
    metadataCatalogConfig?: pulumi.Input<inputs.appflow.FlowMetadataCatalogConfig>;
    /**
     * Name of the flow.
     */
    name?: pulumi.Input<string>;
    /**
     * The Source Flow Config that controls how Amazon AppFlow retrieves data from the source connector.
     */
    sourceFlowConfig: pulumi.Input<inputs.appflow.FlowSourceFlowConfig>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A Task that Amazon AppFlow performs while transferring the data in the flow run.
     */
    tasks: pulumi.Input<pulumi.Input<inputs.appflow.FlowTask>[]>;
    /**
     * A Trigger that determine how and when the flow runs.
     */
    triggerConfig: pulumi.Input<inputs.appflow.FlowTriggerConfig>;
}
