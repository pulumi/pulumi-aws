// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an Traffic mirror session.\
 * Read [limits and considerations](https://docs.aws.amazon.com/vpc/latest/mirroring/traffic-mirroring-considerations.html) for traffic mirroring
 *
 * ## Example Usage
 *
 * To create a basic traffic mirror session
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const filter = new aws.ec2.TrafficMirrorFilter("filter", {
 *     description: "traffic mirror filter - example",
 *     networkServices: ["amazon-dns"],
 * });
 * const target = new aws.ec2.TrafficMirrorTarget("target", {networkLoadBalancerArn: lb.arn});
 * const session = new aws.ec2.TrafficMirrorSession("session", {
 *     description: "traffic mirror session - example",
 *     networkInterfaceId: test.primaryNetworkInterfaceId,
 *     sessionNumber: 1,
 *     trafficMirrorFilterId: filter.id,
 *     trafficMirrorTargetId: target.id,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import traffic mirror sessions using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/trafficMirrorSession:TrafficMirrorSession session tms-0d8aa3ca35897b82e
 * ```
 */
export class TrafficMirrorSession extends pulumi.CustomResource {
    /**
     * Get an existing TrafficMirrorSession resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: TrafficMirrorSessionState, opts?: pulumi.CustomResourceOptions): TrafficMirrorSession {
        return new TrafficMirrorSession(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/trafficMirrorSession:TrafficMirrorSession';

    /**
     * Returns true if the given object is an instance of TrafficMirrorSession.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is TrafficMirrorSession {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === TrafficMirrorSession.__pulumiType;
    }

    /**
     * The ARN of the traffic mirror session.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A description of the traffic mirror session.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * ID of the source network interface. Not all network interfaces are eligible as mirror sources. On EC2 instances only nitro based instances support mirroring.
     */
    public readonly networkInterfaceId!: pulumi.Output<string>;
    /**
     * The AWS account ID of the session owner.
     */
    public /*out*/ readonly ownerId!: pulumi.Output<string>;
    /**
     * The number of bytes in each packet to mirror. These are bytes after the VXLAN header. Do not specify this parameter when you want to mirror the entire packet. To mirror a subset of the packet, set this to the length (in bytes) that you want to mirror.
     */
    public readonly packetLength!: pulumi.Output<number>;
    /**
     * The session number determines the order in which sessions are evaluated when an interface is used by multiple sessions. The first session with a matching filter is the one that mirrors the packets.
     */
    public readonly sessionNumber!: pulumi.Output<number>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * ID of the traffic mirror filter to be used
     */
    public readonly trafficMirrorFilterId!: pulumi.Output<string>;
    /**
     * ID of the traffic mirror target to be used
     */
    public readonly trafficMirrorTargetId!: pulumi.Output<string>;
    /**
     * The VXLAN ID for the Traffic Mirror session. For more information about the VXLAN protocol, see RFC 7348. If you do not specify a VirtualNetworkId, an account-wide unique id is chosen at random.
     */
    public readonly virtualNetworkId!: pulumi.Output<number>;

    /**
     * Create a TrafficMirrorSession resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: TrafficMirrorSessionArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: TrafficMirrorSessionArgs | TrafficMirrorSessionState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as TrafficMirrorSessionState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["networkInterfaceId"] = state ? state.networkInterfaceId : undefined;
            resourceInputs["ownerId"] = state ? state.ownerId : undefined;
            resourceInputs["packetLength"] = state ? state.packetLength : undefined;
            resourceInputs["sessionNumber"] = state ? state.sessionNumber : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["trafficMirrorFilterId"] = state ? state.trafficMirrorFilterId : undefined;
            resourceInputs["trafficMirrorTargetId"] = state ? state.trafficMirrorTargetId : undefined;
            resourceInputs["virtualNetworkId"] = state ? state.virtualNetworkId : undefined;
        } else {
            const args = argsOrState as TrafficMirrorSessionArgs | undefined;
            if ((!args || args.networkInterfaceId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'networkInterfaceId'");
            }
            if ((!args || args.sessionNumber === undefined) && !opts.urn) {
                throw new Error("Missing required property 'sessionNumber'");
            }
            if ((!args || args.trafficMirrorFilterId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'trafficMirrorFilterId'");
            }
            if ((!args || args.trafficMirrorTargetId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'trafficMirrorTargetId'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["networkInterfaceId"] = args ? args.networkInterfaceId : undefined;
            resourceInputs["packetLength"] = args ? args.packetLength : undefined;
            resourceInputs["sessionNumber"] = args ? args.sessionNumber : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["trafficMirrorFilterId"] = args ? args.trafficMirrorFilterId : undefined;
            resourceInputs["trafficMirrorTargetId"] = args ? args.trafficMirrorTargetId : undefined;
            resourceInputs["virtualNetworkId"] = args ? args.virtualNetworkId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ownerId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(TrafficMirrorSession.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering TrafficMirrorSession resources.
 */
export interface TrafficMirrorSessionState {
    /**
     * The ARN of the traffic mirror session.
     */
    arn?: pulumi.Input<string>;
    /**
     * A description of the traffic mirror session.
     */
    description?: pulumi.Input<string>;
    /**
     * ID of the source network interface. Not all network interfaces are eligible as mirror sources. On EC2 instances only nitro based instances support mirroring.
     */
    networkInterfaceId?: pulumi.Input<string>;
    /**
     * The AWS account ID of the session owner.
     */
    ownerId?: pulumi.Input<string>;
    /**
     * The number of bytes in each packet to mirror. These are bytes after the VXLAN header. Do not specify this parameter when you want to mirror the entire packet. To mirror a subset of the packet, set this to the length (in bytes) that you want to mirror.
     */
    packetLength?: pulumi.Input<number>;
    /**
     * The session number determines the order in which sessions are evaluated when an interface is used by multiple sessions. The first session with a matching filter is the one that mirrors the packets.
     */
    sessionNumber?: pulumi.Input<number>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * ID of the traffic mirror filter to be used
     */
    trafficMirrorFilterId?: pulumi.Input<string>;
    /**
     * ID of the traffic mirror target to be used
     */
    trafficMirrorTargetId?: pulumi.Input<string>;
    /**
     * The VXLAN ID for the Traffic Mirror session. For more information about the VXLAN protocol, see RFC 7348. If you do not specify a VirtualNetworkId, an account-wide unique id is chosen at random.
     */
    virtualNetworkId?: pulumi.Input<number>;
}

/**
 * The set of arguments for constructing a TrafficMirrorSession resource.
 */
export interface TrafficMirrorSessionArgs {
    /**
     * A description of the traffic mirror session.
     */
    description?: pulumi.Input<string>;
    /**
     * ID of the source network interface. Not all network interfaces are eligible as mirror sources. On EC2 instances only nitro based instances support mirroring.
     */
    networkInterfaceId: pulumi.Input<string>;
    /**
     * The number of bytes in each packet to mirror. These are bytes after the VXLAN header. Do not specify this parameter when you want to mirror the entire packet. To mirror a subset of the packet, set this to the length (in bytes) that you want to mirror.
     */
    packetLength?: pulumi.Input<number>;
    /**
     * The session number determines the order in which sessions are evaluated when an interface is used by multiple sessions. The first session with a matching filter is the one that mirrors the packets.
     */
    sessionNumber: pulumi.Input<number>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * ID of the traffic mirror filter to be used
     */
    trafficMirrorFilterId: pulumi.Input<string>;
    /**
     * ID of the traffic mirror target to be used
     */
    trafficMirrorTargetId: pulumi.Input<string>;
    /**
     * The VXLAN ID for the Traffic Mirror session. For more information about the VXLAN protocol, see RFC 7348. If you do not specify a VirtualNetworkId, an account-wide unique id is chosen at random.
     */
    virtualNetworkId?: pulumi.Input<number>;
}
