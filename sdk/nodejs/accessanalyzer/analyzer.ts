// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Manages an Access Analyzer Analyzer. More information can be found in the [Access Analyzer User Guide](https://docs.aws.amazon.com/IAM/latest/UserGuide/what-is-access-analyzer.html).
 *
 * ## Example Usage
 *
 * ### Account Analyzer
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.accessanalyzer.Analyzer("example", {analyzerName: "example"});
 * ```
 *
 * ### Organization Analyzer
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.organizations.Organization("example", {awsServiceAccessPrincipals: ["access-analyzer.amazonaws.com"]});
 * const exampleAnalyzer = new aws.accessanalyzer.Analyzer("example", {
 *     analyzerName: "example",
 *     type: "ORGANIZATION",
 * }, {
 *     dependsOn: [example],
 * });
 * ```
 *
 * ### Organization Unused Access Analyzer with analysis rule
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.accessanalyzer.Analyzer("example", {
 *     analyzerName: "example",
 *     type: "ORGANIZATION_UNUSED_ACCESS",
 *     configuration: {
 *         unusedAccess: {
 *             unusedAccessAge: 180,
 *             analysisRule: {
 *                 exclusions: [
 *                     {
 *                         accountIds: [
 *                             "123456789012",
 *                             "234567890123",
 *                         ],
 *                     },
 *                     {
 *                         resourceTags: [
 *                             {
 *                                 key1: "value1",
 *                             },
 *                             {
 *                                 key2: "value2",
 *                             },
 *                         ],
 *                     },
 *                 ],
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Access Analyzer Analyzers using the `analyzer_name`. For example:
 *
 * ```sh
 * $ pulumi import aws:accessanalyzer/analyzer:Analyzer example example
 * ```
 */
export class Analyzer extends pulumi.CustomResource {
    /**
     * Get an existing Analyzer resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AnalyzerState, opts?: pulumi.CustomResourceOptions): Analyzer {
        return new Analyzer(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:accessanalyzer/analyzer:Analyzer';

    /**
     * Returns true if the given object is an instance of Analyzer.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Analyzer {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Analyzer.__pulumiType;
    }

    /**
     * Name of the Analyzer.
     *
     * The following arguments are optional:
     */
    public readonly analyzerName!: pulumi.Output<string>;
    /**
     * ARN of the Analyzer.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A block that specifies the configuration of the analyzer. Documented below
     */
    public readonly configuration!: pulumi.Output<outputs.accessanalyzer.AnalyzerConfiguration | undefined>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Type of Analyzer. Valid values are `ACCOUNT`, `ORGANIZATION`, `ACCOUNT_UNUSED_ACCESS `, `ORGANIZATION_UNUSED_ACCESS`. Defaults to `ACCOUNT`.
     */
    public readonly type!: pulumi.Output<string | undefined>;

    /**
     * Create a Analyzer resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: AnalyzerArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AnalyzerArgs | AnalyzerState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AnalyzerState | undefined;
            resourceInputs["analyzerName"] = state ? state.analyzerName : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["configuration"] = state ? state.configuration : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["type"] = state ? state.type : undefined;
        } else {
            const args = argsOrState as AnalyzerArgs | undefined;
            if ((!args || args.analyzerName === undefined) && !opts.urn) {
                throw new Error("Missing required property 'analyzerName'");
            }
            resourceInputs["analyzerName"] = args ? args.analyzerName : undefined;
            resourceInputs["configuration"] = args ? args.configuration : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["type"] = args ? args.type : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Analyzer.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Analyzer resources.
 */
export interface AnalyzerState {
    /**
     * Name of the Analyzer.
     *
     * The following arguments are optional:
     */
    analyzerName?: pulumi.Input<string>;
    /**
     * ARN of the Analyzer.
     */
    arn?: pulumi.Input<string>;
    /**
     * A block that specifies the configuration of the analyzer. Documented below
     */
    configuration?: pulumi.Input<inputs.accessanalyzer.AnalyzerConfiguration>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Type of Analyzer. Valid values are `ACCOUNT`, `ORGANIZATION`, `ACCOUNT_UNUSED_ACCESS `, `ORGANIZATION_UNUSED_ACCESS`. Defaults to `ACCOUNT`.
     */
    type?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Analyzer resource.
 */
export interface AnalyzerArgs {
    /**
     * Name of the Analyzer.
     *
     * The following arguments are optional:
     */
    analyzerName: pulumi.Input<string>;
    /**
     * A block that specifies the configuration of the analyzer. Documented below
     */
    configuration?: pulumi.Input<inputs.accessanalyzer.AnalyzerConfiguration>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Type of Analyzer. Valid values are `ACCOUNT`, `ORGANIZATION`, `ACCOUNT_UNUSED_ACCESS `, `ORGANIZATION_UNUSED_ACCESS`. Defaults to `ACCOUNT`.
     */
    type?: pulumi.Input<string>;
}
