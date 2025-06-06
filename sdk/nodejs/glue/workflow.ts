// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a Glue Workflow resource.
 * The workflow graph (DAG) can be build using the `aws.glue.Trigger` resource.
 * See the example below for creating a graph with four nodes (two triggers and two jobs).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.glue.Workflow("example", {name: "example"});
 * const example_start = new aws.glue.Trigger("example-start", {
 *     name: "trigger-start",
 *     type: "ON_DEMAND",
 *     workflowName: example.name,
 *     actions: [{
 *         jobName: "example-job",
 *     }],
 * });
 * const example_inner = new aws.glue.Trigger("example-inner", {
 *     name: "trigger-inner",
 *     type: "CONDITIONAL",
 *     workflowName: example.name,
 *     predicate: {
 *         conditions: [{
 *             jobName: "example-job",
 *             state: "SUCCEEDED",
 *         }],
 *     },
 *     actions: [{
 *         jobName: "another-example-job",
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Glue Workflows using `name`. For example:
 *
 * ```sh
 * $ pulumi import aws:glue/workflow:Workflow MyWorkflow MyWorkflow
 * ```
 */
export class Workflow extends pulumi.CustomResource {
    /**
     * Get an existing Workflow resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: WorkflowState, opts?: pulumi.CustomResourceOptions): Workflow {
        return new Workflow(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:glue/workflow:Workflow';

    /**
     * Returns true if the given object is an instance of Workflow.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Workflow {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Workflow.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) of Glue Workflow
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A map of default run properties for this workflow. These properties are passed to all jobs associated to the workflow.
     */
    public readonly defaultRunProperties!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Description of the workflow.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Prevents exceeding the maximum number of concurrent runs of any of the component jobs. If you leave this parameter blank, there is no limit to the number of concurrent workflow runs.
     */
    public readonly maxConcurrentRuns!: pulumi.Output<number | undefined>;
    /**
     * The name you assign to this workflow.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a Workflow resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: WorkflowArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: WorkflowArgs | WorkflowState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as WorkflowState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["defaultRunProperties"] = state ? state.defaultRunProperties : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["maxConcurrentRuns"] = state ? state.maxConcurrentRuns : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as WorkflowArgs | undefined;
            resourceInputs["defaultRunProperties"] = args ? args.defaultRunProperties : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["maxConcurrentRuns"] = args ? args.maxConcurrentRuns : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Workflow.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Workflow resources.
 */
export interface WorkflowState {
    /**
     * Amazon Resource Name (ARN) of Glue Workflow
     */
    arn?: pulumi.Input<string>;
    /**
     * A map of default run properties for this workflow. These properties are passed to all jobs associated to the workflow.
     */
    defaultRunProperties?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Description of the workflow.
     */
    description?: pulumi.Input<string>;
    /**
     * Prevents exceeding the maximum number of concurrent runs of any of the component jobs. If you leave this parameter blank, there is no limit to the number of concurrent workflow runs.
     */
    maxConcurrentRuns?: pulumi.Input<number>;
    /**
     * The name you assign to this workflow.
     */
    name?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a Workflow resource.
 */
export interface WorkflowArgs {
    /**
     * A map of default run properties for this workflow. These properties are passed to all jobs associated to the workflow.
     */
    defaultRunProperties?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Description of the workflow.
     */
    description?: pulumi.Input<string>;
    /**
     * Prevents exceeding the maximum number of concurrent runs of any of the component jobs. If you leave this parameter blank, there is no limit to the number of concurrent workflow runs.
     */
    maxConcurrentRuns?: pulumi.Input<number>;
    /**
     * The name you assign to this workflow.
     */
    name?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. .If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
