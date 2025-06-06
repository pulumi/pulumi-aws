// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS CloudWatch Logs Delivery Destination Policy.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.cloudwatch.LogDeliveryDestinationPolicy("example", {
 *     deliveryDestinationName: exampleAwsCloudwatchLogDeliveryDestination.name,
 *     deliveryDestinationPolicy: exampleAwsIamPolicyDocument.json,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudWatch Logs Delivery Destination Policy using the `delivery_destination_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:cloudwatch/logDeliveryDestinationPolicy:LogDeliveryDestinationPolicy example example
 * ```
 */
export class LogDeliveryDestinationPolicy extends pulumi.CustomResource {
    /**
     * Get an existing LogDeliveryDestinationPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: LogDeliveryDestinationPolicyState, opts?: pulumi.CustomResourceOptions): LogDeliveryDestinationPolicy {
        return new LogDeliveryDestinationPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:cloudwatch/logDeliveryDestinationPolicy:LogDeliveryDestinationPolicy';

    /**
     * Returns true if the given object is an instance of LogDeliveryDestinationPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is LogDeliveryDestinationPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === LogDeliveryDestinationPolicy.__pulumiType;
    }

    /**
     * The name of the delivery destination to assign this policy to.
     */
    public readonly deliveryDestinationName!: pulumi.Output<string>;
    /**
     * The contents of the policy.
     */
    public readonly deliveryDestinationPolicy!: pulumi.Output<string>;

    /**
     * Create a LogDeliveryDestinationPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: LogDeliveryDestinationPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: LogDeliveryDestinationPolicyArgs | LogDeliveryDestinationPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as LogDeliveryDestinationPolicyState | undefined;
            resourceInputs["deliveryDestinationName"] = state ? state.deliveryDestinationName : undefined;
            resourceInputs["deliveryDestinationPolicy"] = state ? state.deliveryDestinationPolicy : undefined;
        } else {
            const args = argsOrState as LogDeliveryDestinationPolicyArgs | undefined;
            if ((!args || args.deliveryDestinationName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'deliveryDestinationName'");
            }
            if ((!args || args.deliveryDestinationPolicy === undefined) && !opts.urn) {
                throw new Error("Missing required property 'deliveryDestinationPolicy'");
            }
            resourceInputs["deliveryDestinationName"] = args ? args.deliveryDestinationName : undefined;
            resourceInputs["deliveryDestinationPolicy"] = args ? args.deliveryDestinationPolicy : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(LogDeliveryDestinationPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering LogDeliveryDestinationPolicy resources.
 */
export interface LogDeliveryDestinationPolicyState {
    /**
     * The name of the delivery destination to assign this policy to.
     */
    deliveryDestinationName?: pulumi.Input<string>;
    /**
     * The contents of the policy.
     */
    deliveryDestinationPolicy?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a LogDeliveryDestinationPolicy resource.
 */
export interface LogDeliveryDestinationPolicyArgs {
    /**
     * The name of the delivery destination to assign this policy to.
     */
    deliveryDestinationName: pulumi.Input<string>;
    /**
     * The contents of the policy.
     */
    deliveryDestinationPolicy: pulumi.Input<string>;
}
