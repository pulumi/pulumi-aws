// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * TODO resource for managing an AWS SSM Contact.
 *
 * ## Example Usage
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ssmcontacts.Contact("example", {
 *     alias: "alias",
 *     type: "PERSONAL",
 * }, {
 *     dependsOn: [aws_ssmincidents_replication_set.example],
 * });
 * ```
 * ### Usage With All Fields
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.ssmcontacts.Contact("example", {
 *     alias: "alias",
 *     displayName: "displayName",
 *     type: "ESCALATION",
 *     tags: {
 *         key: "value",
 *     },
 * }, {
 *     dependsOn: [aws_ssmincidents_replication_set.example],
 * });
 * ```
 *
 * ## Import
 *
 * Import SSM Contact using the `ARN`. For example
 *
 * ```sh
 *  $ pulumi import aws:ssmcontacts/contact:Contact example {ARNValue}
 * ```
 */
export class Contact extends pulumi.CustomResource {
    /**
     * Get an existing Contact resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ContactState, opts?: pulumi.CustomResourceOptions): Contact {
        return new Contact(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssmcontacts/contact:Contact';

    /**
     * Returns true if the given object is an instance of Contact.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Contact {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Contact.__pulumiType;
    }

    /**
     * A unique and identifiable alias for the contact or escalation plan.
     */
    public readonly alias!: pulumi.Output<string>;
    /**
     * The Amazon Resource Name (ARN) of the contact or escalation plan.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Full friendly name of the contact or escalation plan.
     */
    public readonly displayName!: pulumi.Output<string | undefined>;
    /**
     * Map of tags to assign to the resource.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     */
    public readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * The type of contact engaged. A single contact is type PERSONAL and an escalation
     * plan is type ESCALATION.
     */
    public readonly type!: pulumi.Output<string>;

    /**
     * Create a Contact resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ContactArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ContactArgs | ContactState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ContactState | undefined;
            resourceInputs["alias"] = state ? state.alias : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["displayName"] = state ? state.displayName : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as ContactArgs | undefined;
            if ((!args || args.alias === undefined) && !opts.urn) {
                throw new Error("Missing required property 'alias'");
            }
            if ((!args || args.type === undefined) && !opts.urn) {
                throw new Error("Missing required property 'type'");
            }
            resourceInputs["alias"] = args ? args.alias : undefined;
            resourceInputs["displayName"] = args ? args.displayName : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["tagsAll"] = args ? args.tagsAll : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["arn"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Contact.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Contact resources.
 */
export interface ContactState {
    /**
     * A unique and identifiable alias for the contact or escalation plan.
     */
    alias?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the contact or escalation plan.
     */
    arn?: pulumi.Input<string>;
    /**
     * Full friendly name of the contact or escalation plan.
     */
    displayName?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of contact engaged. A single contact is type PERSONAL and an escalation
     * plan is type ESCALATION.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Contact resource.
 */
export interface ContactArgs {
    /**
     * A unique and identifiable alias for the contact or escalation plan.
     */
    alias: pulumi.Input<string>;
    /**
     * Full friendly name of the contact or escalation plan.
     */
    displayName?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the resource.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * The type of contact engaged. A single contact is type PERSONAL and an escalation
     * plan is type ESCALATION.
     */
    type: pulumi.Input<string>;
}