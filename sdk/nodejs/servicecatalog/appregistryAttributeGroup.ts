// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Service Catalog AppRegistry Attribute Group.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.servicecatalog.AppregistryAttributeGroup("example", {
 *     name: "example",
 *     description: "example description",
 *     attributes: JSON.stringify({
 *         app: "exampleapp",
 *         group: "examplegroup",
 *     }),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Service Catalog AppRegistry Attribute Group using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:servicecatalog/appregistryAttributeGroup:AppregistryAttributeGroup example 1234567890abcfedhijk09876s
 * ```
 */
export class AppregistryAttributeGroup extends pulumi.CustomResource {
    /**
     * Get an existing AppregistryAttributeGroup resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AppregistryAttributeGroupState, opts?: pulumi.CustomResourceOptions): AppregistryAttributeGroup {
        return new AppregistryAttributeGroup(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:servicecatalog/appregistryAttributeGroup:AppregistryAttributeGroup';

    /**
     * Returns true if the given object is an instance of AppregistryAttributeGroup.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is AppregistryAttributeGroup {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === AppregistryAttributeGroup.__pulumiType;
    }

    /**
     * ARN of the Attribute Group.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A JSON string of nested key-value pairs that represents the attributes of the group.
     *
     * The following arguments are optional:
     */
    public readonly attributes!: pulumi.Output<string>;
    /**
     * Description of the Attribute Group.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Name of the Attribute Group.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A map of tags assigned to the Attribute Group. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a AppregistryAttributeGroup resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: AppregistryAttributeGroupArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AppregistryAttributeGroupArgs | AppregistryAttributeGroupState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AppregistryAttributeGroupState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["attributes"] = state ? state.attributes : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as AppregistryAttributeGroupArgs | undefined;
            if ((!args || args.attributes === undefined) && !opts.urn) {
                throw new Error("Missing required property 'attributes'");
            }
            resourceInputs["attributes"] = args ? args.attributes : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(AppregistryAttributeGroup.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering AppregistryAttributeGroup resources.
 */
export interface AppregistryAttributeGroupState {
    /**
     * ARN of the Attribute Group.
     */
    arn?: pulumi.Input<string>;
    /**
     * A JSON string of nested key-value pairs that represents the attributes of the group.
     *
     * The following arguments are optional:
     */
    attributes?: pulumi.Input<string>;
    /**
     * Description of the Attribute Group.
     */
    description?: pulumi.Input<string>;
    /**
     * Name of the Attribute Group.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags assigned to the Attribute Group. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}

/**
 * The set of arguments for constructing a AppregistryAttributeGroup resource.
 */
export interface AppregistryAttributeGroupArgs {
    /**
     * A JSON string of nested key-value pairs that represents the attributes of the group.
     *
     * The following arguments are optional:
     */
    attributes: pulumi.Input<string>;
    /**
     * Description of the Attribute Group.
     */
    description?: pulumi.Input<string>;
    /**
     * Name of the Attribute Group.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags assigned to the Attribute Group. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
