// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS SESv2 (Simple Email V2) Configuration Set.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sesv2.ConfigurationSet("example", {
 *     configurationSetName: "example",
 *     deliveryOptions: {
 *         maxDeliverySeconds: 300,
 *         tlsPolicy: "REQUIRE",
 *     },
 *     reputationOptions: {
 *         reputationMetricsEnabled: false,
 *     },
 *     sendingOptions: {
 *         sendingEnabled: true,
 *     },
 *     suppressionOptions: {
 *         suppressedReasons: [
 *             "BOUNCE",
 *             "COMPLAINT",
 *         ],
 *     },
 *     trackingOptions: {
 *         customRedirectDomain: "example.com",
 *         httpsPolicy: "REQUIRE",
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SESv2 (Simple Email V2) Configuration Set using the `configuration_set_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:sesv2/configurationSet:ConfigurationSet example example
 * ```
 */
export class ConfigurationSet extends pulumi.CustomResource {
    /**
     * Get an existing ConfigurationSet resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ConfigurationSetState, opts?: pulumi.CustomResourceOptions): ConfigurationSet {
        return new ConfigurationSet(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:sesv2/configurationSet:ConfigurationSet';

    /**
     * Returns true if the given object is an instance of ConfigurationSet.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ConfigurationSet {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ConfigurationSet.__pulumiType;
    }

    /**
     * ARN of the Configuration Set.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The name of the configuration set.
     */
    public readonly configurationSetName!: pulumi.Output<string>;
    /**
     * An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
     */
    public readonly deliveryOptions!: pulumi.Output<outputs.sesv2.ConfigurationSetDeliveryOptions | undefined>;
    /**
     * An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
     */
    public readonly reputationOptions!: pulumi.Output<outputs.sesv2.ConfigurationSetReputationOptions>;
    /**
     * An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
     */
    public readonly sendingOptions!: pulumi.Output<outputs.sesv2.ConfigurationSetSendingOptions>;
    /**
     * An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
     */
    public readonly suppressionOptions!: pulumi.Output<outputs.sesv2.ConfigurationSetSuppressionOptions | undefined>;
    /**
     * A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
     */
    public readonly trackingOptions!: pulumi.Output<outputs.sesv2.ConfigurationSetTrackingOptions | undefined>;
    /**
     * An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
     */
    public readonly vdmOptions!: pulumi.Output<outputs.sesv2.ConfigurationSetVdmOptions | undefined>;

    /**
     * Create a ConfigurationSet resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ConfigurationSetArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ConfigurationSetArgs | ConfigurationSetState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ConfigurationSetState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["configurationSetName"] = state ? state.configurationSetName : undefined;
            resourceInputs["deliveryOptions"] = state ? state.deliveryOptions : undefined;
            resourceInputs["reputationOptions"] = state ? state.reputationOptions : undefined;
            resourceInputs["sendingOptions"] = state ? state.sendingOptions : undefined;
            resourceInputs["suppressionOptions"] = state ? state.suppressionOptions : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["trackingOptions"] = state ? state.trackingOptions : undefined;
            resourceInputs["vdmOptions"] = state ? state.vdmOptions : undefined;
        } else {
            const args = argsOrState as ConfigurationSetArgs | undefined;
            if ((!args || args.configurationSetName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'configurationSetName'");
            }
            resourceInputs["configurationSetName"] = args ? args.configurationSetName : undefined;
            resourceInputs["deliveryOptions"] = args ? args.deliveryOptions : undefined;
            resourceInputs["reputationOptions"] = args ? args.reputationOptions : undefined;
            resourceInputs["sendingOptions"] = args ? args.sendingOptions : undefined;
            resourceInputs["suppressionOptions"] = args ? args.suppressionOptions : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["trackingOptions"] = args ? args.trackingOptions : undefined;
            resourceInputs["vdmOptions"] = args ? args.vdmOptions : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ConfigurationSet.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ConfigurationSet resources.
 */
export interface ConfigurationSetState {
    /**
     * ARN of the Configuration Set.
     */
    arn?: pulumi.Input<string>;
    /**
     * The name of the configuration set.
     */
    configurationSetName?: pulumi.Input<string>;
    /**
     * An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
     */
    deliveryOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetDeliveryOptions>;
    /**
     * An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
     */
    reputationOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetReputationOptions>;
    /**
     * An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
     */
    sendingOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetSendingOptions>;
    /**
     * An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
     */
    suppressionOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetSuppressionOptions>;
    /**
     * A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
     */
    trackingOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetTrackingOptions>;
    /**
     * An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
     */
    vdmOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetVdmOptions>;
}

/**
 * The set of arguments for constructing a ConfigurationSet resource.
 */
export interface ConfigurationSetArgs {
    /**
     * The name of the configuration set.
     */
    configurationSetName: pulumi.Input<string>;
    /**
     * An object that defines the dedicated IP pool that is used to send emails that you send using the configuration set. See `deliveryOptions` Block for details.
     */
    deliveryOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetDeliveryOptions>;
    /**
     * An object that defines whether or not Amazon SES collects reputation metrics for the emails that you send that use the configuration set. See `reputationOptions` Block for details.
     */
    reputationOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetReputationOptions>;
    /**
     * An object that defines whether or not Amazon SES can send email that you send using the configuration set. See `sendingOptions` Block for details.
     */
    sendingOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetSendingOptions>;
    /**
     * An object that contains information about the suppression list preferences for your account. See `suppressionOptions` Block for details.
     */
    suppressionOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetSuppressionOptions>;
    /**
     * A map of tags to assign to the service. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * An object that defines the open and click tracking options for emails that you send using the configuration set. See `trackingOptions` Block for details.
     */
    trackingOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetTrackingOptions>;
    /**
     * An object that defines the VDM settings that apply to emails that you send using the configuration set. See `vdmOptions` Block for details.
     */
    vdmOptions?: pulumi.Input<inputs.sesv2.ConfigurationSetVdmOptions>;
}
