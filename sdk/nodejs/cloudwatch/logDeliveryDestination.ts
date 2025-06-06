// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS CloudWatch Logs Delivery Destination.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.cloudwatch.LogDeliveryDestination("example", {
 *     name: "example",
 *     deliveryDestinationConfiguration: {
 *         destinationResourceArn: exampleAwsCloudwatchLogGroup.arn,
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudWatch Logs Delivery Destination using the `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:cloudwatch/logDeliveryDestination:LogDeliveryDestination example example
 * ```
 */
export class LogDeliveryDestination extends pulumi.CustomResource {
    /**
     * Get an existing LogDeliveryDestination resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: LogDeliveryDestinationState, opts?: pulumi.CustomResourceOptions): LogDeliveryDestination {
        return new LogDeliveryDestination(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:cloudwatch/logDeliveryDestination:LogDeliveryDestination';

    /**
     * Returns true if the given object is an instance of LogDeliveryDestination.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is LogDeliveryDestination {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === LogDeliveryDestination.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the delivery destination.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The AWS resource that will receive the logs.
     */
    public readonly deliveryDestinationConfiguration!: pulumi.Output<outputs.cloudwatch.LogDeliveryDestinationDeliveryDestinationConfiguration | undefined>;
    /**
     * Whether this delivery destination is CloudWatch Logs, Amazon S3, or Firehose.
     */
    public /*out*/ readonly deliveryDestinationType!: pulumi.Output<string>;
    /**
     * The name for this delivery destination.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The format of the logs that are sent to this delivery destination. Valid values: `json`, `plain`, `w3c`, `raw`, `parquet`.
     */
    public readonly outputFormat!: pulumi.Output<string | undefined>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a LogDeliveryDestination resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: LogDeliveryDestinationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: LogDeliveryDestinationArgs | LogDeliveryDestinationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as LogDeliveryDestinationState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["deliveryDestinationConfiguration"] = state ? state.deliveryDestinationConfiguration : undefined;
            resourceInputs["deliveryDestinationType"] = state ? state.deliveryDestinationType : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["outputFormat"] = state ? state.outputFormat : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as LogDeliveryDestinationArgs | undefined;
            resourceInputs["deliveryDestinationConfiguration"] = args ? args.deliveryDestinationConfiguration : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["outputFormat"] = args ? args.outputFormat : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["deliveryDestinationType"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(LogDeliveryDestination.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering LogDeliveryDestination resources.
 */
export interface LogDeliveryDestinationState {
    /**
     * The Amazon Resource Name (ARN) of the delivery destination.
     */
    arn?: pulumi.Input<string>;
    /**
     * The AWS resource that will receive the logs.
     */
    deliveryDestinationConfiguration?: pulumi.Input<inputs.cloudwatch.LogDeliveryDestinationDeliveryDestinationConfiguration>;
    /**
     * Whether this delivery destination is CloudWatch Logs, Amazon S3, or Firehose.
     */
    deliveryDestinationType?: pulumi.Input<string>;
    /**
     * The name for this delivery destination.
     */
    name?: pulumi.Input<string>;
    /**
     * The format of the logs that are sent to this delivery destination. Valid values: `json`, `plain`, `w3c`, `raw`, `parquet`.
     */
    outputFormat?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a LogDeliveryDestination resource.
 */
export interface LogDeliveryDestinationArgs {
    /**
     * The AWS resource that will receive the logs.
     */
    deliveryDestinationConfiguration?: pulumi.Input<inputs.cloudwatch.LogDeliveryDestinationDeliveryDestinationConfiguration>;
    /**
     * The name for this delivery destination.
     */
    name?: pulumi.Input<string>;
    /**
     * The format of the logs that are sent to this delivery destination. Valid values: `json`, `plain`, `w3c`, `raw`, `parquet`.
     */
    outputFormat?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
