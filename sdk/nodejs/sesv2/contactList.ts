// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS SESv2 (Simple Email V2) Contact List.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sesv2.ContactList("example", {contactListName: "example"});
 * ```
 *
 * ### Extended Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.sesv2.ContactList("example", {
 *     contactListName: "example",
 *     description: "description",
 *     topics: [{
 *         defaultSubscriptionStatus: "OPT_IN",
 *         description: "topic description",
 *         displayName: "Example Topic",
 *         topicName: "example-topic",
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SESv2 (Simple Email V2) Contact List using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:sesv2/contactList:ContactList example example
 * ```
 */
export class ContactList extends pulumi.CustomResource {
    /**
     * Get an existing ContactList resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ContactListState, opts?: pulumi.CustomResourceOptions): ContactList {
        return new ContactList(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:sesv2/contactList:ContactList';

    /**
     * Returns true if the given object is an instance of ContactList.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ContactList {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ContactList.__pulumiType;
    }

    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Name of the contact list.
     *
     * The following arguments are optional:
     */
    public readonly contactListName!: pulumi.Output<string>;
    /**
     * Timestamp noting when the contact list was created in ISO 8601 format.
     */
    public /*out*/ readonly createdTimestamp!: pulumi.Output<string>;
    /**
     * Description of what the contact list is about.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Timestamp noting the last time the contact list was updated in ISO 8601 format.
     */
    public /*out*/ readonly lastUpdatedTimestamp!: pulumi.Output<string>;
    /**
     * Key-value map of resource tags for the contact list. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Configuration block(s) with topic for the contact list. Detailed below.
     */
    public readonly topics!: pulumi.Output<outputs.sesv2.ContactListTopic[] | undefined>;

    /**
     * Create a ContactList resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ContactListArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ContactListArgs | ContactListState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ContactListState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["contactListName"] = state ? state.contactListName : undefined;
            resourceInputs["createdTimestamp"] = state ? state.createdTimestamp : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["lastUpdatedTimestamp"] = state ? state.lastUpdatedTimestamp : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["topics"] = state ? state.topics : undefined;
        } else {
            const args = argsOrState as ContactListArgs | undefined;
            if ((!args || args.contactListName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'contactListName'");
            }
            resourceInputs["contactListName"] = args ? args.contactListName : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["topics"] = args ? args.topics : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["createdTimestamp"] = undefined /*out*/;
            resourceInputs["lastUpdatedTimestamp"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ContactList.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ContactList resources.
 */
export interface ContactListState {
    arn?: pulumi.Input<string>;
    /**
     * Name of the contact list.
     *
     * The following arguments are optional:
     */
    contactListName?: pulumi.Input<string>;
    /**
     * Timestamp noting when the contact list was created in ISO 8601 format.
     */
    createdTimestamp?: pulumi.Input<string>;
    /**
     * Description of what the contact list is about.
     */
    description?: pulumi.Input<string>;
    /**
     * Timestamp noting the last time the contact list was updated in ISO 8601 format.
     */
    lastUpdatedTimestamp?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags for the contact list. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block(s) with topic for the contact list. Detailed below.
     */
    topics?: pulumi.Input<pulumi.Input<inputs.sesv2.ContactListTopic>[]>;
}

/**
 * The set of arguments for constructing a ContactList resource.
 */
export interface ContactListArgs {
    /**
     * Name of the contact list.
     *
     * The following arguments are optional:
     */
    contactListName: pulumi.Input<string>;
    /**
     * Description of what the contact list is about.
     */
    description?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags for the contact list. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block(s) with topic for the contact list. Detailed below.
     */
    topics?: pulumi.Input<pulumi.Input<inputs.sesv2.ContactListTopic>[]>;
}
