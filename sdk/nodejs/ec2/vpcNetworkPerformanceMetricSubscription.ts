// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage an Infrastructure Performance subscription.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ec2.VpcNetworkPerformanceMetricSubscription("example", {
 *     source: "us-east-1",
 *     destination: "us-west-1",
 * });
 * ```
 */
export class VpcNetworkPerformanceMetricSubscription extends pulumi.CustomResource {
    /**
     * Get an existing VpcNetworkPerformanceMetricSubscription resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: VpcNetworkPerformanceMetricSubscriptionState, opts?: pulumi.CustomResourceOptions): VpcNetworkPerformanceMetricSubscription {
        return new VpcNetworkPerformanceMetricSubscription(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/vpcNetworkPerformanceMetricSubscription:VpcNetworkPerformanceMetricSubscription';

    /**
     * Returns true if the given object is an instance of VpcNetworkPerformanceMetricSubscription.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is VpcNetworkPerformanceMetricSubscription {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === VpcNetworkPerformanceMetricSubscription.__pulumiType;
    }

    /**
     * The target Region or Availability Zone that the metric subscription is enabled for. For example, `eu-west-1`.
     */
    public readonly destination!: pulumi.Output<string>;
    /**
     * The metric used for the enabled subscription. Valid values: `aggregate-latency`. Default: `aggregate-latency`.
     */
    public readonly metric!: pulumi.Output<string | undefined>;
    /**
     * The data aggregation time for the subscription.
     */
    public /*out*/ readonly period!: pulumi.Output<string>;
    /**
     * The source Region or Availability Zone that the metric subscription is enabled for. For example, `us-east-1`.
     */
    public readonly source!: pulumi.Output<string>;
    /**
     * The statistic used for the enabled subscription. Valid values: `p50`. Default: `p50`.
     */
    public readonly statistic!: pulumi.Output<string | undefined>;

    /**
     * Create a VpcNetworkPerformanceMetricSubscription resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: VpcNetworkPerformanceMetricSubscriptionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: VpcNetworkPerformanceMetricSubscriptionArgs | VpcNetworkPerformanceMetricSubscriptionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as VpcNetworkPerformanceMetricSubscriptionState | undefined;
            resourceInputs["destination"] = state ? state.destination : undefined;
            resourceInputs["metric"] = state ? state.metric : undefined;
            resourceInputs["period"] = state ? state.period : undefined;
            resourceInputs["source"] = state ? state.source : undefined;
            resourceInputs["statistic"] = state ? state.statistic : undefined;
        } else {
            const args = argsOrState as VpcNetworkPerformanceMetricSubscriptionArgs | undefined;
            if ((!args || args.destination === undefined) && !opts.urn) {
                throw new Error("Missing required property 'destination'");
            }
            if ((!args || args.source === undefined) && !opts.urn) {
                throw new Error("Missing required property 'source'");
            }
            resourceInputs["destination"] = args ? args.destination : undefined;
            resourceInputs["metric"] = args ? args.metric : undefined;
            resourceInputs["source"] = args ? args.source : undefined;
            resourceInputs["statistic"] = args ? args.statistic : undefined;
            resourceInputs["period"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(VpcNetworkPerformanceMetricSubscription.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering VpcNetworkPerformanceMetricSubscription resources.
 */
export interface VpcNetworkPerformanceMetricSubscriptionState {
    /**
     * The target Region or Availability Zone that the metric subscription is enabled for. For example, `eu-west-1`.
     */
    destination?: pulumi.Input<string>;
    /**
     * The metric used for the enabled subscription. Valid values: `aggregate-latency`. Default: `aggregate-latency`.
     */
    metric?: pulumi.Input<string>;
    /**
     * The data aggregation time for the subscription.
     */
    period?: pulumi.Input<string>;
    /**
     * The source Region or Availability Zone that the metric subscription is enabled for. For example, `us-east-1`.
     */
    source?: pulumi.Input<string>;
    /**
     * The statistic used for the enabled subscription. Valid values: `p50`. Default: `p50`.
     */
    statistic?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a VpcNetworkPerformanceMetricSubscription resource.
 */
export interface VpcNetworkPerformanceMetricSubscriptionArgs {
    /**
     * The target Region or Availability Zone that the metric subscription is enabled for. For example, `eu-west-1`.
     */
    destination: pulumi.Input<string>;
    /**
     * The metric used for the enabled subscription. Valid values: `aggregate-latency`. Default: `aggregate-latency`.
     */
    metric?: pulumi.Input<string>;
    /**
     * The source Region or Availability Zone that the metric subscription is enabled for. For example, `us-east-1`.
     */
    source: pulumi.Input<string>;
    /**
     * The statistic used for the enabled subscription. Valid values: `p50`. Default: `p50`.
     */
    statistic?: pulumi.Input<string>;
}
