// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS SSM Contacts Contact Channel.
 *
 * > **NOTE:** The contact channel needs to be activated in the AWS Systems Manager console, otherwise it can't be used to engage the contact. See the [Contacts section of the Incident Manager User Guide](https://docs.aws.amazon.com/incident-manager/latest/userguide/contacts.html) for more information.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ssmcontacts.ContactChannel("example", {
 *     contactId: "arn:aws:ssm-contacts:us-west-2:123456789012:contact/contactalias",
 *     deliveryAddress: {
 *         simpleAddress: "email@example.com",
 *     },
 *     name: "Example contact channel",
 *     type: "EMAIL",
 * });
 * ```
 *
 * ### Usage with SSM Contact
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleContact = new aws.ssmcontacts.Contact("example_contact", {
 *     alias: "example_contact",
 *     type: "PERSONAL",
 * });
 * const example = new aws.ssmcontacts.ContactChannel("example", {
 *     contactId: exampleContact.arn,
 *     deliveryAddress: {
 *         simpleAddress: "email@example.com",
 *     },
 *     name: "Example contact channel",
 *     type: "EMAIL",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SSM Contact Channel using the `ARN`. For example:
 *
 * ```sh
 * $ pulumi import aws:ssmcontacts/contactChannel:ContactChannel example arn:aws:ssm-contacts:us-west-2:123456789012:contact-channel/example
 * ```
 */
export class ContactChannel extends pulumi.CustomResource {
    /**
     * Get an existing ContactChannel resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ContactChannelState, opts?: pulumi.CustomResourceOptions): ContactChannel {
        return new ContactChannel(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssmcontacts/contactChannel:ContactChannel';

    /**
     * Returns true if the given object is an instance of ContactChannel.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ContactChannel {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ContactChannel.__pulumiType;
    }

    /**
     * Whether the contact channel is activated. The contact channel must be activated to use it to engage the contact. One of `ACTIVATED` or `NOT_ACTIVATED`.
     */
    public /*out*/ readonly activationStatus!: pulumi.Output<string>;
    /**
     * Amazon Resource Name (ARN) of the contact channel.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Amazon Resource Name (ARN) of the AWS SSM Contact that the contact channel belongs to.
     */
    public readonly contactId!: pulumi.Output<string>;
    /**
     * Block that contains contact engagement details. See details below.
     */
    public readonly deliveryAddress!: pulumi.Output<outputs.ssmcontacts.ContactChannelDeliveryAddress>;
    /**
     * Name of the contact channel. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Type of the contact channel. One of `SMS`, `VOICE` or `EMAIL`.
     */
    public readonly type!: pulumi.Output<string>;

    /**
     * Create a ContactChannel resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ContactChannelArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ContactChannelArgs | ContactChannelState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ContactChannelState | undefined;
            resourceInputs["activationStatus"] = state ? state.activationStatus : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["contactId"] = state ? state.contactId : undefined;
            resourceInputs["deliveryAddress"] = state ? state.deliveryAddress : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as ContactChannelArgs | undefined;
            if ((!args || args.contactId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'contactId'");
            }
            if ((!args || args.deliveryAddress === undefined) && !opts.urn) {
                throw new Error("Missing required property 'deliveryAddress'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            resourceInputs["contactId"] = args ? args.contactId : undefined;
            resourceInputs["deliveryAddress"] = args ? args.deliveryAddress : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["activationStatus"] = undefined /*out*/;
            resourceInputs["arn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ContactChannel.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ContactChannel resources.
 */
export interface ContactChannelState {
    /**
     * Whether the contact channel is activated. The contact channel must be activated to use it to engage the contact. One of `ACTIVATED` or `NOT_ACTIVATED`.
     */
    activationStatus?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the contact channel.
     */
    arn?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the AWS SSM Contact that the contact channel belongs to.
     */
    contactId?: pulumi.Input<string>;
    /**
     * Block that contains contact engagement details. See details below.
     */
    deliveryAddress?: pulumi.Input<inputs.ssmcontacts.ContactChannelDeliveryAddress>;
    /**
     * Name of the contact channel. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
     */
    name?: pulumi.Input<string>;
    /**
     * Type of the contact channel. One of `SMS`, `VOICE` or `EMAIL`.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ContactChannel resource.
 */
export interface ContactChannelArgs {
    /**
     * Amazon Resource Name (ARN) of the AWS SSM Contact that the contact channel belongs to.
     */
    contactId: pulumi.Input<string>;
    /**
     * Block that contains contact engagement details. See details below.
     */
    deliveryAddress: pulumi.Input<inputs.ssmcontacts.ContactChannelDeliveryAddress>;
    /**
     * Name of the contact channel. Must be between 1 and 255 characters, and may contain alphanumerics, underscores (`_`), hyphens (`-`), periods (`.`), and spaces.
     */
    name?: pulumi.Input<string>;
    /**
     * Type of the contact channel. One of `SMS`, `VOICE` or `EMAIL`.
     */
    type: pulumi.Input<string>;
}
