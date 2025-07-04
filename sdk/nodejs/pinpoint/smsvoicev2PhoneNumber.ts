// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Manages an AWS End User Messaging SMS phone number.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.pinpoint.Smsvoicev2PhoneNumber("example", {
 *     isoCountryCode: "US",
 *     messageType: "TRANSACTIONAL",
 *     numberType: "TOLL_FREE",
 *     numberCapabilities: ["SMS"],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import phone numbers using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:pinpoint/smsvoicev2PhoneNumber:Smsvoicev2PhoneNumber example phone-abcdef0123456789abcdef0123456789
 * ```
 */
export class Smsvoicev2PhoneNumber extends pulumi.CustomResource {
    /**
     * Get an existing Smsvoicev2PhoneNumber resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: Smsvoicev2PhoneNumberState, opts?: pulumi.CustomResourceOptions): Smsvoicev2PhoneNumber {
        return new Smsvoicev2PhoneNumber(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:pinpoint/smsvoicev2PhoneNumber:Smsvoicev2PhoneNumber';

    /**
     * Returns true if the given object is an instance of Smsvoicev2PhoneNumber.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Smsvoicev2PhoneNumber {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Smsvoicev2PhoneNumber.__pulumiType;
    }

    /**
     * ARN of the phone number.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * By default this is set to `false`. When set to true the phone number can’t be deleted.
     */
    public readonly deletionProtectionEnabled!: pulumi.Output<boolean>;
    /**
     * The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
     */
    public readonly isoCountryCode!: pulumi.Output<string>;
    /**
     * The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
     */
    public readonly messageType!: pulumi.Output<string>;
    /**
     * The monthly price, in US dollars, to lease the phone number.
     */
    public /*out*/ readonly monthlyLeasingPrice!: pulumi.Output<string>;
    /**
     * Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
     */
    public readonly numberCapabilities!: pulumi.Output<string[]>;
    /**
     * The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
     */
    public readonly numberType!: pulumi.Output<string>;
    /**
     * The name of the opt-out list to associate with the phone number.
     */
    public readonly optOutListName!: pulumi.Output<string>;
    /**
     * The new phone number that was requested.
     */
    public /*out*/ readonly phoneNumber!: pulumi.Output<string>;
    /**
     * Use this field to attach your phone number for an external registration process.
     */
    public readonly registrationId!: pulumi.Output<string | undefined>;
    /**
     * When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
     */
    public readonly selfManagedOptOutsEnabled!: pulumi.Output<boolean>;
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    public readonly timeouts!: pulumi.Output<outputs.pinpoint.Smsvoicev2PhoneNumberTimeouts | undefined>;
    /**
     * The Amazon Resource Name (ARN) of the two way channel.
     */
    public readonly twoWayChannelArn!: pulumi.Output<string | undefined>;
    /**
     * By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
     */
    public readonly twoWayChannelEnabled!: pulumi.Output<boolean>;
    /**
     * IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
     */
    public readonly twoWayChannelRole!: pulumi.Output<string | undefined>;

    /**
     * Create a Smsvoicev2PhoneNumber resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: Smsvoicev2PhoneNumberArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: Smsvoicev2PhoneNumberArgs | Smsvoicev2PhoneNumberState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as Smsvoicev2PhoneNumberState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["deletionProtectionEnabled"] = state ? state.deletionProtectionEnabled : undefined;
            resourceInputs["isoCountryCode"] = state ? state.isoCountryCode : undefined;
            resourceInputs["messageType"] = state ? state.messageType : undefined;
            resourceInputs["monthlyLeasingPrice"] = state ? state.monthlyLeasingPrice : undefined;
            resourceInputs["numberCapabilities"] = state ? state.numberCapabilities : undefined;
            resourceInputs["numberType"] = state ? state.numberType : undefined;
            resourceInputs["optOutListName"] = state ? state.optOutListName : undefined;
            resourceInputs["phoneNumber"] = state ? state.phoneNumber : undefined;
            resourceInputs["registrationId"] = state ? state.registrationId : undefined;
            resourceInputs["selfManagedOptOutsEnabled"] = state ? state.selfManagedOptOutsEnabled : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["timeouts"] = state ? state.timeouts : undefined;
            resourceInputs["twoWayChannelArn"] = state ? state.twoWayChannelArn : undefined;
            resourceInputs["twoWayChannelEnabled"] = state ? state.twoWayChannelEnabled : undefined;
            resourceInputs["twoWayChannelRole"] = state ? state.twoWayChannelRole : undefined;
        } else {
            const args = argsOrState as Smsvoicev2PhoneNumberArgs | undefined;
            if ((!args || args.isoCountryCode === undefined) && !opts.urn) {
                throw new Error("Missing required property 'isoCountryCode'");
            }
            if ((!args || args.messageType === undefined) && !opts.urn) {
                throw new Error("Missing required property 'messageType'");
            }
            if ((!args || args.numberCapabilities === undefined) && !opts.urn) {
                throw new Error("Missing required property 'numberCapabilities'");
            }
            if ((!args || args.numberType === undefined) && !opts.urn) {
                throw new Error("Missing required property 'numberType'");
            }
            resourceInputs["deletionProtectionEnabled"] = args ? args.deletionProtectionEnabled : undefined;
            resourceInputs["isoCountryCode"] = args ? args.isoCountryCode : undefined;
            resourceInputs["messageType"] = args ? args.messageType : undefined;
            resourceInputs["numberCapabilities"] = args ? args.numberCapabilities : undefined;
            resourceInputs["numberType"] = args ? args.numberType : undefined;
            resourceInputs["optOutListName"] = args ? args.optOutListName : undefined;
            resourceInputs["registrationId"] = args ? args.registrationId : undefined;
            resourceInputs["selfManagedOptOutsEnabled"] = args ? args.selfManagedOptOutsEnabled : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["timeouts"] = args ? args.timeouts : undefined;
            resourceInputs["twoWayChannelArn"] = args ? args.twoWayChannelArn : undefined;
            resourceInputs["twoWayChannelEnabled"] = args ? args.twoWayChannelEnabled : undefined;
            resourceInputs["twoWayChannelRole"] = args ? args.twoWayChannelRole : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["monthlyLeasingPrice"] = undefined /*out*/;
            resourceInputs["phoneNumber"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Smsvoicev2PhoneNumber.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Smsvoicev2PhoneNumber resources.
 */
export interface Smsvoicev2PhoneNumberState {
    /**
     * ARN of the phone number.
     */
    arn?: pulumi.Input<string>;
    /**
     * By default this is set to `false`. When set to true the phone number can’t be deleted.
     */
    deletionProtectionEnabled?: pulumi.Input<boolean>;
    /**
     * The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
     */
    isoCountryCode?: pulumi.Input<string>;
    /**
     * The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
     */
    messageType?: pulumi.Input<string>;
    /**
     * The monthly price, in US dollars, to lease the phone number.
     */
    monthlyLeasingPrice?: pulumi.Input<string>;
    /**
     * Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
     */
    numberCapabilities?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
     */
    numberType?: pulumi.Input<string>;
    /**
     * The name of the opt-out list to associate with the phone number.
     */
    optOutListName?: pulumi.Input<string>;
    /**
     * The new phone number that was requested.
     */
    phoneNumber?: pulumi.Input<string>;
    /**
     * Use this field to attach your phone number for an external registration process.
     */
    registrationId?: pulumi.Input<string>;
    /**
     * When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
     */
    selfManagedOptOutsEnabled?: pulumi.Input<boolean>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.pinpoint.Smsvoicev2PhoneNumberTimeouts>;
    /**
     * The Amazon Resource Name (ARN) of the two way channel.
     */
    twoWayChannelArn?: pulumi.Input<string>;
    /**
     * By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
     */
    twoWayChannelEnabled?: pulumi.Input<boolean>;
    /**
     * IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
     */
    twoWayChannelRole?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Smsvoicev2PhoneNumber resource.
 */
export interface Smsvoicev2PhoneNumberArgs {
    /**
     * By default this is set to `false`. When set to true the phone number can’t be deleted.
     */
    deletionProtectionEnabled?: pulumi.Input<boolean>;
    /**
     * The two-character code, in ISO 3166-1 alpha-2 format, for the country or region.
     */
    isoCountryCode: pulumi.Input<string>;
    /**
     * The type of message. Valid values are `TRANSACTIONAL` for messages that are critical or time-sensitive and `PROMOTIONAL` for messages that aren’t critical or time-sensitive.
     */
    messageType: pulumi.Input<string>;
    /**
     * Describes if the origination identity can be used for text messages, voice calls or both. valid values are `SMS` and `VOICE`.
     */
    numberCapabilities: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The type of phone number to request. Possible values are `LONG_CODE`, `TOLL_FREE`, `TEN_DLC`, or `SIMULATOR`.
     */
    numberType: pulumi.Input<string>;
    /**
     * The name of the opt-out list to associate with the phone number.
     */
    optOutListName?: pulumi.Input<string>;
    /**
     * Use this field to attach your phone number for an external registration process.
     */
    registrationId?: pulumi.Input<string>;
    /**
     * When set to `false` an end recipient sends a message that begins with HELP or STOP to one of your dedicated numbers, AWS End User Messaging SMS and Voice automatically replies with a customizable message and adds the end recipient to the opt-out list. When set to true you’re responsible for responding to HELP and STOP requests. You’re also responsible for tracking and honoring opt-out request.
     */
    selfManagedOptOutsEnabled?: pulumi.Input<boolean>;
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    timeouts?: pulumi.Input<inputs.pinpoint.Smsvoicev2PhoneNumberTimeouts>;
    /**
     * The Amazon Resource Name (ARN) of the two way channel.
     */
    twoWayChannelArn?: pulumi.Input<string>;
    /**
     * By default this is set to `false`. When set to `true` you can receive incoming text messages from your end recipients.
     */
    twoWayChannelEnabled?: pulumi.Input<boolean>;
    /**
     * IAM Role ARN for a service to assume, to be able to post inbound SMS messages.
     */
    twoWayChannelRole?: pulumi.Input<string>;
}
