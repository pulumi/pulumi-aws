// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS Audit Manager Control.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.auditmanager.Control("example", {
 *     name: "example",
 *     controlMappingSources: [{
 *         sourceName: "example",
 *         sourceSetUpOption: "Procedural_Controls_Mapping",
 *         sourceType: "MANUAL",
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import an Audit Manager Control using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:auditmanager/control:Control example abc123-de45
 * ```
 */
export class Control extends pulumi.CustomResource {
    /**
     * Get an existing Control resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ControlState, opts?: pulumi.CustomResourceOptions): Control {
        return new Control(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:auditmanager/control:Control';

    /**
     * Returns true if the given object is an instance of Control.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Control {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Control.__pulumiType;
    }

    /**
     * Recommended actions to carry out if the control isn't fulfilled.
     */
    public readonly actionPlanInstructions!: pulumi.Output<string | undefined>;
    /**
     * Title of the action plan for remediating the control.
     */
    public readonly actionPlanTitle!: pulumi.Output<string | undefined>;
    /**
     * Amazon Resource Name (ARN) of the control.
     * * `control_mapping_sources.*.source_id` - Unique identifier for the source.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Data mapping sources. See `controlMappingSources` below.
     *
     * The following arguments are optional:
     */
    public readonly controlMappingSources!: pulumi.Output<outputs.auditmanager.ControlControlMappingSource[] | undefined>;
    /**
     * Description of the control.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Name of the control.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the control. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Steps to follow to determine if the control is satisfied.
     */
    public readonly testingInformation!: pulumi.Output<string | undefined>;
    /**
     * Type of control, such as a custom control or a standard control.
     */
    public /*out*/ readonly type!: pulumi.Output<string>;

    /**
     * Create a Control resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: ControlArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ControlArgs | ControlState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ControlState | undefined;
            resourceInputs["actionPlanInstructions"] = state ? state.actionPlanInstructions : undefined;
            resourceInputs["actionPlanTitle"] = state ? state.actionPlanTitle : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["controlMappingSources"] = state ? state.controlMappingSources : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["testingInformation"] = state ? state.testingInformation : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as ControlArgs | undefined;
            resourceInputs["actionPlanInstructions"] = args ? args.actionPlanInstructions : undefined;
            resourceInputs["actionPlanTitle"] = args ? args.actionPlanTitle : undefined;
            resourceInputs["controlMappingSources"] = args ? args.controlMappingSources : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["testingInformation"] = args ? args.testingInformation : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["type"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Control.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Control resources.
 */
export interface ControlState {
    /**
     * Recommended actions to carry out if the control isn't fulfilled.
     */
    actionPlanInstructions?: pulumi.Input<string>;
    /**
     * Title of the action plan for remediating the control.
     */
    actionPlanTitle?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the control.
     * * `control_mapping_sources.*.source_id` - Unique identifier for the source.
     */
    arn?: pulumi.Input<string>;
    /**
     * Data mapping sources. See `controlMappingSources` below.
     *
     * The following arguments are optional:
     */
    controlMappingSources?: pulumi.Input<pulumi.Input<inputs.auditmanager.ControlControlMappingSource>[]>;
    /**
     * Description of the control.
     */
    description?: pulumi.Input<string>;
    /**
     * Name of the control.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the control. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Steps to follow to determine if the control is satisfied.
     */
    testingInformation?: pulumi.Input<string>;
    /**
     * Type of control, such as a custom control or a standard control.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Control resource.
 */
export interface ControlArgs {
    /**
     * Recommended actions to carry out if the control isn't fulfilled.
     */
    actionPlanInstructions?: pulumi.Input<string>;
    /**
     * Title of the action plan for remediating the control.
     */
    actionPlanTitle?: pulumi.Input<string>;
    /**
     * Data mapping sources. See `controlMappingSources` below.
     *
     * The following arguments are optional:
     */
    controlMappingSources?: pulumi.Input<pulumi.Input<inputs.auditmanager.ControlControlMappingSource>[]>;
    /**
     * Description of the control.
     */
    description?: pulumi.Input<string>;
    /**
     * Name of the control.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the control. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Steps to follow to determine if the control is satisfied.
     */
    testingInformation?: pulumi.Input<string>;
}
