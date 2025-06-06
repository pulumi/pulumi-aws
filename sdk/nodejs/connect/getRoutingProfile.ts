// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides details about a specific Amazon Connect Routing Profile.
 *
 * ## Example Usage
 *
 * By `name`
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.connect.getRoutingProfile({
 *     instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
 *     name: "Example",
 * });
 * ```
 *
 * By `routingProfileId`
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.connect.getRoutingProfile({
 *     instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
 *     routingProfileId: "cccccccc-bbbb-cccc-dddd-111111111111",
 * });
 * ```
 */
export function getRoutingProfile(args: GetRoutingProfileArgs, opts?: pulumi.InvokeOptions): Promise<GetRoutingProfileResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:connect/getRoutingProfile:getRoutingProfile", {
        "instanceId": args.instanceId,
        "name": args.name,
        "routingProfileId": args.routingProfileId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getRoutingProfile.
 */
export interface GetRoutingProfileArgs {
    /**
     * Reference to the hosting Amazon Connect Instance
     */
    instanceId: string;
    /**
     * Returns information on a specific Routing Profile by name
     */
    name?: string;
    /**
     * Returns information on a specific Routing Profile by Routing Profile id
     *
     * > **NOTE:** `instanceId` and one of either `name` or `routingProfileId` is required.
     */
    routingProfileId?: string;
    /**
     * Map of tags to assign to the Routing Profile.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getRoutingProfile.
 */
export interface GetRoutingProfileResult {
    /**
     * ARN of the Routing Profile.
     */
    readonly arn: string;
    /**
     * Specifies the default outbound queue for the Routing Profile.
     */
    readonly defaultOutboundQueueId: string;
    /**
     * Description of the Routing Profile.
     */
    readonly description: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly instanceId: string;
    /**
     * One or more `mediaConcurrencies` blocks that specify the channels that agents can handle in the Contact Control Panel (CCP) for this Routing Profile. The `mediaConcurrencies` block is documented below.
     */
    readonly mediaConcurrencies: outputs.connect.GetRoutingProfileMediaConcurrency[];
    readonly name: string;
    /**
     * One or more `queueConfigs` blocks that specify the inbound queues associated with the routing profile. If no queue is added, the agent only can make outbound calls. The `queueConfigs` block is documented below.
     */
    readonly queueConfigs: outputs.connect.GetRoutingProfileQueueConfig[];
    readonly routingProfileId: string;
    /**
     * Map of tags to assign to the Routing Profile.
     */
    readonly tags: {[key: string]: string};
}
/**
 * Provides details about a specific Amazon Connect Routing Profile.
 *
 * ## Example Usage
 *
 * By `name`
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.connect.getRoutingProfile({
 *     instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
 *     name: "Example",
 * });
 * ```
 *
 * By `routingProfileId`
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.connect.getRoutingProfile({
 *     instanceId: "aaaaaaaa-bbbb-cccc-dddd-111111111111",
 *     routingProfileId: "cccccccc-bbbb-cccc-dddd-111111111111",
 * });
 * ```
 */
export function getRoutingProfileOutput(args: GetRoutingProfileOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetRoutingProfileResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:connect/getRoutingProfile:getRoutingProfile", {
        "instanceId": args.instanceId,
        "name": args.name,
        "routingProfileId": args.routingProfileId,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getRoutingProfile.
 */
export interface GetRoutingProfileOutputArgs {
    /**
     * Reference to the hosting Amazon Connect Instance
     */
    instanceId: pulumi.Input<string>;
    /**
     * Returns information on a specific Routing Profile by name
     */
    name?: pulumi.Input<string>;
    /**
     * Returns information on a specific Routing Profile by Routing Profile id
     *
     * > **NOTE:** `instanceId` and one of either `name` or `routingProfileId` is required.
     */
    routingProfileId?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the Routing Profile.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
