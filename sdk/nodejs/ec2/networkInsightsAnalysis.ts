// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Network Insights Analysis resource. Part of the "Reachability Analyzer" service in the AWS VPC console.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const path = new aws.ec2.NetworkInsightsPath("path", {
 *     source: source.id,
 *     destination: destination.id,
 *     protocol: "tcp",
 * });
 * const analysis = new aws.ec2.NetworkInsightsAnalysis("analysis", {networkInsightsPathId: path.id});
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Network Insights Analyzes using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ec2/networkInsightsAnalysis:NetworkInsightsAnalysis test nia-0462085c957f11a55
 * ```
 */
export class NetworkInsightsAnalysis extends pulumi.CustomResource {
    /**
     * Get an existing NetworkInsightsAnalysis resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: NetworkInsightsAnalysisState, opts?: pulumi.CustomResourceOptions): NetworkInsightsAnalysis {
        return new NetworkInsightsAnalysis(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ec2/networkInsightsAnalysis:NetworkInsightsAnalysis';

    /**
     * Returns true if the given object is an instance of NetworkInsightsAnalysis.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is NetworkInsightsAnalysis {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === NetworkInsightsAnalysis.__pulumiType;
    }

    /**
     * Potential intermediate components of a feasible path. Described below.
     */
    public /*out*/ readonly alternatePathHints!: pulumi.Output<outputs.ec2.NetworkInsightsAnalysisAlternatePathHint[]>;
    /**
     * ARN of the Network Insights Analysis.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Explanation codes for an unreachable path. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_Explanation.html) for details.
     */
    public /*out*/ readonly explanations!: pulumi.Output<outputs.ec2.NetworkInsightsAnalysisExplanation[]>;
    /**
     * A list of ARNs for resources the path must traverse.
     */
    public readonly filterInArns!: pulumi.Output<string[] | undefined>;
    /**
     * The components in the path from source to destination. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_PathComponent.html) for details.
     */
    public /*out*/ readonly forwardPathComponents!: pulumi.Output<outputs.ec2.NetworkInsightsAnalysisForwardPathComponent[]>;
    /**
     * ID of the Network Insights Path to run an analysis on.
     *
     * The following arguments are optional:
     */
    public readonly networkInsightsPathId!: pulumi.Output<string>;
    /**
     * Set to `true` if the destination was reachable.
     */
    public /*out*/ readonly pathFound!: pulumi.Output<boolean>;
    /**
     * The components in the path from destination to source. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_PathComponent.html) for details.
     */
    public /*out*/ readonly returnPathComponents!: pulumi.Output<outputs.ec2.NetworkInsightsAnalysisReturnPathComponent[]>;
    /**
     * The date/time the analysis was started.
     */
    public /*out*/ readonly startDate!: pulumi.Output<string>;
    /**
     * The status of the analysis. `succeeded` means the analysis was completed, not that a path was found, for that see `pathFound`.
     */
    public /*out*/ readonly status!: pulumi.Output<string>;
    /**
     * A message to provide more context when the `status` is `failed`.
     */
    public /*out*/ readonly statusMessage!: pulumi.Output<string>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * If enabled, the resource will wait for the Network Insights Analysis status to change to `succeeded` or `failed`. Setting this to `false` will skip the process. Default: `true`.
     */
    public readonly waitForCompletion!: pulumi.Output<boolean | undefined>;
    /**
     * The warning message.
     */
    public /*out*/ readonly warningMessage!: pulumi.Output<string>;

    /**
     * Create a NetworkInsightsAnalysis resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: NetworkInsightsAnalysisArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: NetworkInsightsAnalysisArgs | NetworkInsightsAnalysisState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as NetworkInsightsAnalysisState | undefined;
            resourceInputs["alternatePathHints"] = state ? state.alternatePathHints : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["explanations"] = state ? state.explanations : undefined;
            resourceInputs["filterInArns"] = state ? state.filterInArns : undefined;
            resourceInputs["forwardPathComponents"] = state ? state.forwardPathComponents : undefined;
            resourceInputs["networkInsightsPathId"] = state ? state.networkInsightsPathId : undefined;
            resourceInputs["pathFound"] = state ? state.pathFound : undefined;
            resourceInputs["returnPathComponents"] = state ? state.returnPathComponents : undefined;
            resourceInputs["startDate"] = state ? state.startDate : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["statusMessage"] = state ? state.statusMessage : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["waitForCompletion"] = state ? state.waitForCompletion : undefined;
            resourceInputs["warningMessage"] = state ? state.warningMessage : undefined;
        } else {
            const args = argsOrState as NetworkInsightsAnalysisArgs | undefined;
            if ((!args || args.networkInsightsPathId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'networkInsightsPathId'");
            }
            resourceInputs["filterInArns"] = args ? args.filterInArns : undefined;
            resourceInputs["networkInsightsPathId"] = args ? args.networkInsightsPathId : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["waitForCompletion"] = args ? args.waitForCompletion : undefined;
            resourceInputs["alternatePathHints"] = undefined /*out*/;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["explanations"] = undefined /*out*/;
            resourceInputs["forwardPathComponents"] = undefined /*out*/;
            resourceInputs["pathFound"] = undefined /*out*/;
            resourceInputs["returnPathComponents"] = undefined /*out*/;
            resourceInputs["startDate"] = undefined /*out*/;
            resourceInputs["status"] = undefined /*out*/;
            resourceInputs["statusMessage"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["warningMessage"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(NetworkInsightsAnalysis.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering NetworkInsightsAnalysis resources.
 */
export interface NetworkInsightsAnalysisState {
    /**
     * Potential intermediate components of a feasible path. Described below.
     */
    alternatePathHints?: pulumi.Input<pulumi.Input<inputs.ec2.NetworkInsightsAnalysisAlternatePathHint>[]>;
    /**
     * ARN of the Network Insights Analysis.
     */
    arn?: pulumi.Input<string>;
    /**
     * Explanation codes for an unreachable path. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_Explanation.html) for details.
     */
    explanations?: pulumi.Input<pulumi.Input<inputs.ec2.NetworkInsightsAnalysisExplanation>[]>;
    /**
     * A list of ARNs for resources the path must traverse.
     */
    filterInArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * The components in the path from source to destination. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_PathComponent.html) for details.
     */
    forwardPathComponents?: pulumi.Input<pulumi.Input<inputs.ec2.NetworkInsightsAnalysisForwardPathComponent>[]>;
    /**
     * ID of the Network Insights Path to run an analysis on.
     *
     * The following arguments are optional:
     */
    networkInsightsPathId?: pulumi.Input<string>;
    /**
     * Set to `true` if the destination was reachable.
     */
    pathFound?: pulumi.Input<boolean>;
    /**
     * The components in the path from destination to source. See the [AWS documentation](https://docs.aws.amazon.com/AWSEC2/latest/APIReference/API_PathComponent.html) for details.
     */
    returnPathComponents?: pulumi.Input<pulumi.Input<inputs.ec2.NetworkInsightsAnalysisReturnPathComponent>[]>;
    /**
     * The date/time the analysis was started.
     */
    startDate?: pulumi.Input<string>;
    /**
     * The status of the analysis. `succeeded` means the analysis was completed, not that a path was found, for that see `pathFound`.
     */
    status?: pulumi.Input<string>;
    /**
     * A message to provide more context when the `status` is `failed`.
     */
    statusMessage?: pulumi.Input<string>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * If enabled, the resource will wait for the Network Insights Analysis status to change to `succeeded` or `failed`. Setting this to `false` will skip the process. Default: `true`.
     */
    waitForCompletion?: pulumi.Input<boolean>;
    /**
     * The warning message.
     */
    warningMessage?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a NetworkInsightsAnalysis resource.
 */
export interface NetworkInsightsAnalysisArgs {
    /**
     * A list of ARNs for resources the path must traverse.
     */
    filterInArns?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ID of the Network Insights Path to run an analysis on.
     *
     * The following arguments are optional:
     */
    networkInsightsPathId: pulumi.Input<string>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * If enabled, the resource will wait for the Network Insights Analysis status to change to `succeeded` or `failed`. Setting this to `false` will skip the process. Default: `true`.
     */
    waitForCompletion?: pulumi.Input<boolean>;
}
