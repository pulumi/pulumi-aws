// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * ## Import
 *
 * Using `pulumi import`, import DB Parameter groups using the `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:rds/parameterGroup:ParameterGroup rds_pg rds-pg
 * ```
 */
export class ParameterGroup extends pulumi.CustomResource {
    /**
     * Get an existing ParameterGroup resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ParameterGroupState, opts?: pulumi.CustomResourceOptions): ParameterGroup {
        return new ParameterGroup(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:rds/parameterGroup:ParameterGroup';

    /**
     * Returns true if the given object is an instance of ParameterGroup.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ParameterGroup {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ParameterGroup.__pulumiType;
    }

    /**
     * The ARN of the db parameter group.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The description of the DB parameter group. Defaults to "Managed by Pulumi".
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * The family of the DB parameter group.
     */
    public readonly family!: pulumi.Output<string>;
    /**
     * The name of the DB parameter group. If omitted, this provider will assign a random, unique name.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    public readonly namePrefix!: pulumi.Output<string>;
    /**
     * The DB parameters to apply. See `parameter` Block below for more details. Note that parameters may differ from a family to an other. Full list of all parameters can be discovered via [`aws rds describe-db-parameters`](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-parameters.html) after initial creation of the group.
     */
    public readonly parameters!: pulumi.Output<outputs.rds.ParameterGroupParameter[] | undefined>;
    public readonly skipDestroy!: pulumi.Output<boolean | undefined>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a ParameterGroup resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ParameterGroupArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ParameterGroupArgs | ParameterGroupState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ParameterGroupState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["family"] = state ? state.family : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["namePrefix"] = state ? state.namePrefix : undefined;
            resourceInputs["parameters"] = state ? state.parameters : undefined;
            resourceInputs["skipDestroy"] = state ? state.skipDestroy : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as ParameterGroupArgs | undefined;
            if ((!args || args.family === undefined) && !opts.urn) {
                throw new Error("Missing required property 'family'");
            }
            resourceInputs["description"] = (args ? args.description : undefined) ?? "Managed by Pulumi";
            resourceInputs["family"] = args ? args.family : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["namePrefix"] = args ? args.namePrefix : undefined;
            resourceInputs["parameters"] = args ? args.parameters : undefined;
            resourceInputs["skipDestroy"] = args ? args.skipDestroy : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ParameterGroup.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ParameterGroup resources.
 */
export interface ParameterGroupState {
    /**
     * The ARN of the db parameter group.
     */
    arn?: pulumi.Input<string>;
    /**
     * The description of the DB parameter group. Defaults to "Managed by Pulumi".
     */
    description?: pulumi.Input<string>;
    /**
     * The family of the DB parameter group.
     */
    family?: pulumi.Input<string>;
    /**
     * The name of the DB parameter group. If omitted, this provider will assign a random, unique name.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * The DB parameters to apply. See `parameter` Block below for more details. Note that parameters may differ from a family to an other. Full list of all parameters can be discovered via [`aws rds describe-db-parameters`](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-parameters.html) after initial creation of the group.
     */
    parameters?: pulumi.Input<pulumi.Input<inputs.rds.ParameterGroupParameter>[]>;
    skipDestroy?: pulumi.Input<boolean>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a ParameterGroup resource.
 */
export interface ParameterGroupArgs {
    /**
     * The description of the DB parameter group. Defaults to "Managed by Pulumi".
     */
    description?: pulumi.Input<string>;
    /**
     * The family of the DB parameter group.
     */
    family: pulumi.Input<string>;
    /**
     * The name of the DB parameter group. If omitted, this provider will assign a random, unique name.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * The DB parameters to apply. See `parameter` Block below for more details. Note that parameters may differ from a family to an other. Full list of all parameters can be discovered via [`aws rds describe-db-parameters`](https://docs.aws.amazon.com/cli/latest/reference/rds/describe-db-parameters.html) after initial creation of the group.
     */
    parameters?: pulumi.Input<pulumi.Input<inputs.rds.ParameterGroupParameter>[]>;
    skipDestroy?: pulumi.Input<boolean>;
    /**
     * A map of tags to assign to the resource. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
