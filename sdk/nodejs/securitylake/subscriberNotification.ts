// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Security Lake Subscriber Notification.
 *
 * ## Example Usage
 *
 * ### SQS Notification
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.securitylake.SubscriberNotification("example", {
 *     subscriberId: exampleAwsSecuritylakeSubscriber.id,
 *     configuration: {
 *         sqsNotificationConfiguration: {},
 *     },
 * });
 * ```
 *
 * ### HTTPS Notification
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.securitylake.SubscriberNotification("example", {
 *     subscriberId: exampleAwsSecuritylakeSubscriber.id,
 *     configuration: {
 *         httpsNotificationConfiguration: {
 *             endpoint: test.apiEndpoint,
 *             targetRoleArn: eventBridge.arn,
 *         },
 *     },
 * });
 * ```
 */
export class SubscriberNotification extends pulumi.CustomResource {
    /**
     * Get an existing SubscriberNotification resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: SubscriberNotificationState, opts?: pulumi.CustomResourceOptions): SubscriberNotification {
        return new SubscriberNotification(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:securitylake/subscriberNotification:SubscriberNotification';

    /**
     * Returns true if the given object is an instance of SubscriberNotification.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is SubscriberNotification {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === SubscriberNotification.__pulumiType;
    }

    /**
     * Specify the configuration using which you want to create the subscriber notification..
     */
    public readonly configuration!: pulumi.Output<outputs.securitylake.SubscriberNotificationConfiguration | undefined>;
    /**
     * (**Deprecated**) The subscriber endpoint to which exception messages are posted.
     *
     * @deprecated Use subscriberEndpoint instead
     */
    public /*out*/ readonly endpointId!: pulumi.Output<string>;
    /**
     * The subscriber endpoint to which exception messages are posted.
     */
    public /*out*/ readonly subscriberEndpoint!: pulumi.Output<string>;
    /**
     * The subscriber ID for the notification subscription.
     */
    public readonly subscriberId!: pulumi.Output<string>;

    /**
     * Create a SubscriberNotification resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: SubscriberNotificationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: SubscriberNotificationArgs | SubscriberNotificationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as SubscriberNotificationState | undefined;
            resourceInputs["configuration"] = state ? state.configuration : undefined;
            resourceInputs["endpointId"] = state ? state.endpointId : undefined;
            resourceInputs["subscriberEndpoint"] = state ? state.subscriberEndpoint : undefined;
            resourceInputs["subscriberId"] = state ? state.subscriberId : undefined;
        } else {
            const args = argsOrState as SubscriberNotificationArgs | undefined;
            if ((!args || args.subscriberId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'subscriberId'");
            }
            resourceInputs["configuration"] = args ? args.configuration : undefined;
            resourceInputs["subscriberId"] = args ? args.subscriberId : undefined;
            resourceInputs["endpointId"] = undefined /*out*/;
            resourceInputs["subscriberEndpoint"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(SubscriberNotification.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering SubscriberNotification resources.
 */
export interface SubscriberNotificationState {
    /**
     * Specify the configuration using which you want to create the subscriber notification..
     */
    configuration?: pulumi.Input<inputs.securitylake.SubscriberNotificationConfiguration>;
    /**
     * (**Deprecated**) The subscriber endpoint to which exception messages are posted.
     *
     * @deprecated Use subscriberEndpoint instead
     */
    endpointId?: pulumi.Input<string>;
    /**
     * The subscriber endpoint to which exception messages are posted.
     */
    subscriberEndpoint?: pulumi.Input<string>;
    /**
     * The subscriber ID for the notification subscription.
     */
    subscriberId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a SubscriberNotification resource.
 */
export interface SubscriberNotificationArgs {
    /**
     * Specify the configuration using which you want to create the subscriber notification..
     */
    configuration?: pulumi.Input<inputs.securitylake.SubscriberNotificationConfiguration>;
    /**
     * The subscriber ID for the notification subscription.
     */
    subscriberId: pulumi.Input<string>;
}
