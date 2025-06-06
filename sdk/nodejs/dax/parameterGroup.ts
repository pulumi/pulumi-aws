// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a DAX Parameter Group resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.dax.ParameterGroup("example", {
 *     name: "example",
 *     parameters: [
 *         {
 *             name: "query-ttl-millis",
 *             value: "100000",
 *         },
 *         {
 *             name: "record-ttl-millis",
 *             value: "100000",
 *         },
 *     ],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import DAX Parameter Group using the `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:dax/parameterGroup:ParameterGroup example my_dax_pg
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
    public static readonly __pulumiType = 'aws:dax/parameterGroup:ParameterGroup';

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
     * A description of the parameter group.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The name of the parameter group.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The parameters of the parameter group.
     */
    public readonly parameters!: pulumi.Output<outputs.dax.ParameterGroupParameter[]>;

    /**
     * Create a ParameterGroup resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: ParameterGroupArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ParameterGroupArgs | ParameterGroupState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ParameterGroupState | undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["parameters"] = state ? state.parameters : undefined;
        } else {
            const args = argsOrState as ParameterGroupArgs | undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["parameters"] = args ? args.parameters : undefined;
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
     * A description of the parameter group.
     */
    description?: pulumi.Input<string>;
    /**
     * The name of the parameter group.
     */
    name?: pulumi.Input<string>;
    /**
     * The parameters of the parameter group.
     */
    parameters?: pulumi.Input<pulumi.Input<inputs.dax.ParameterGroupParameter>[]>;
}

/**
 * The set of arguments for constructing a ParameterGroup resource.
 */
export interface ParameterGroupArgs {
    /**
     * A description of the parameter group.
     */
    description?: pulumi.Input<string>;
    /**
     * The name of the parameter group.
     */
    name?: pulumi.Input<string>;
    /**
     * The parameters of the parameter group.
     */
    parameters?: pulumi.Input<pulumi.Input<inputs.dax.ParameterGroupParameter>[]>;
}
