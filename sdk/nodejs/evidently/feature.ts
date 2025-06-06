// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a CloudWatch Evidently Feature resource.
 *
 * ## Example Usage
 *
 * ### Basic
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Feature("example", {
 *     name: "example",
 *     project: exampleAwsEvidentlyProject.name,
 *     description: "example description",
 *     variations: [{
 *         name: "Variation1",
 *         value: {
 *             stringValue: "example",
 *         },
 *     }],
 *     tags: {
 *         Key1: "example Feature",
 *     },
 * });
 * ```
 *
 * ### With default variation
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Feature("example", {
 *     name: "example",
 *     project: exampleAwsEvidentlyProject.name,
 *     defaultVariation: "Variation2",
 *     variations: [
 *         {
 *             name: "Variation1",
 *             value: {
 *                 stringValue: "exampleval1",
 *             },
 *         },
 *         {
 *             name: "Variation2",
 *             value: {
 *                 stringValue: "exampleval2",
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ### With entity overrides
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Feature("example", {
 *     name: "example",
 *     project: exampleAwsEvidentlyProject.name,
 *     entityOverrides: {
 *         test1: "Variation1",
 *     },
 *     variations: [
 *         {
 *             name: "Variation1",
 *             value: {
 *                 stringValue: "exampleval1",
 *             },
 *         },
 *         {
 *             name: "Variation2",
 *             value: {
 *                 stringValue: "exampleval2",
 *             },
 *         },
 *     ],
 * });
 * ```
 *
 * ### With evaluation strategy
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.evidently.Feature("example", {
 *     name: "example",
 *     project: exampleAwsEvidentlyProject.name,
 *     evaluationStrategy: "ALL_RULES",
 *     entityOverrides: {
 *         test1: "Variation1",
 *     },
 *     variations: [{
 *         name: "Variation1",
 *         value: {
 *             stringValue: "exampleval1",
 *         },
 *     }],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import CloudWatch Evidently Feature using the feature `name` and `name` or `arn` of the hosting CloudWatch Evidently Project separated by a `:`. For example:
 *
 * ```sh
 * $ pulumi import aws:evidently/feature:Feature example exampleFeatureName:arn:aws:evidently:us-east-1:123456789012:project/example
 * ```
 */
export class Feature extends pulumi.CustomResource {
    /**
     * Get an existing Feature resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: FeatureState, opts?: pulumi.CustomResourceOptions): Feature {
        return new Feature(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:evidently/feature:Feature';

    /**
     * Returns true if the given object is an instance of Feature.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Feature {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Feature.__pulumiType;
    }

    /**
     * The ARN of the feature.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * The date and time that the feature is created.
     */
    public /*out*/ readonly createdTime!: pulumi.Output<string>;
    /**
     * The name of the variation to use as the default variation. The default variation is served to users who are not allocated to any ongoing launches or experiments of this feature. This variation must also be listed in the `variations` structure. If you omit `defaultVariation`, the first variation listed in the `variations` structure is used as the default variation.
     */
    public readonly defaultVariation!: pulumi.Output<string>;
    /**
     * Specifies the description of the feature.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Specify users that should always be served a specific variation of a feature. Each user is specified by a key-value pair . For each key, specify a user by entering their user ID, account ID, or some other identifier. For the value, specify the name of the variation that they are to be served.
     */
    public readonly entityOverrides!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * One or more blocks that define the evaluation rules for the feature. Detailed below
     */
    public /*out*/ readonly evaluationRules!: pulumi.Output<outputs.evidently.FeatureEvaluationRule[]>;
    /**
     * Specify `ALL_RULES` to activate the traffic allocation specified by any ongoing launches or experiments. Specify `DEFAULT_VARIATION` to serve the default variation to all users instead.
     */
    public readonly evaluationStrategy!: pulumi.Output<string>;
    /**
     * The date and time that the feature was most recently updated.
     */
    public /*out*/ readonly lastUpdatedTime!: pulumi.Output<string>;
    /**
     * The name for the new feature. Minimum length of `1`. Maximum length of `127`.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The name or ARN of the project that is to contain the new feature.
     */
    public readonly project!: pulumi.Output<string>;
    /**
     * The current state of the feature. Valid values are `AVAILABLE` and `UPDATING`.
     */
    public /*out*/ readonly status!: pulumi.Output<string>;
    /**
     * Tags to apply to the feature. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Defines the type of value used to define the different feature variations. Valid Values: `STRING`, `LONG`, `DOUBLE`, `BOOLEAN`.
     */
    public /*out*/ readonly valueType!: pulumi.Output<string>;
    /**
     * One or more blocks that contain the configuration of the feature's different variations. Detailed below
     */
    public readonly variations!: pulumi.Output<outputs.evidently.FeatureVariation[]>;

    /**
     * Create a Feature resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: FeatureArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: FeatureArgs | FeatureState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as FeatureState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["createdTime"] = state ? state.createdTime : undefined;
            resourceInputs["defaultVariation"] = state ? state.defaultVariation : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["entityOverrides"] = state ? state.entityOverrides : undefined;
            resourceInputs["evaluationRules"] = state ? state.evaluationRules : undefined;
            resourceInputs["evaluationStrategy"] = state ? state.evaluationStrategy : undefined;
            resourceInputs["lastUpdatedTime"] = state ? state.lastUpdatedTime : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["project"] = state ? state.project : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["valueType"] = state ? state.valueType : undefined;
            resourceInputs["variations"] = state ? state.variations : undefined;
        } else {
            const args = argsOrState as FeatureArgs | undefined;
            if ((!args || args.project === undefined) && !opts.urn) {
                throw new Error("Missing required property 'project'");
            }
            if ((!args || args.variations === undefined) && !opts.urn) {
                throw new Error("Missing required property 'variations'");
            }
            resourceInputs["defaultVariation"] = args ? args.defaultVariation : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["entityOverrides"] = args ? args.entityOverrides : undefined;
            resourceInputs["evaluationStrategy"] = args ? args.evaluationStrategy : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["project"] = args ? args.project : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["variations"] = args ? args.variations : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["createdTime"] = undefined /*out*/;
            resourceInputs["evaluationRules"] = undefined /*out*/;
            resourceInputs["lastUpdatedTime"] = undefined /*out*/;
            resourceInputs["status"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
            resourceInputs["valueType"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Feature.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Feature resources.
 */
export interface FeatureState {
    /**
     * The ARN of the feature.
     */
    arn?: pulumi.Input<string>;
    /**
     * The date and time that the feature is created.
     */
    createdTime?: pulumi.Input<string>;
    /**
     * The name of the variation to use as the default variation. The default variation is served to users who are not allocated to any ongoing launches or experiments of this feature. This variation must also be listed in the `variations` structure. If you omit `defaultVariation`, the first variation listed in the `variations` structure is used as the default variation.
     */
    defaultVariation?: pulumi.Input<string>;
    /**
     * Specifies the description of the feature.
     */
    description?: pulumi.Input<string>;
    /**
     * Specify users that should always be served a specific variation of a feature. Each user is specified by a key-value pair . For each key, specify a user by entering their user ID, account ID, or some other identifier. For the value, specify the name of the variation that they are to be served.
     */
    entityOverrides?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * One or more blocks that define the evaluation rules for the feature. Detailed below
     */
    evaluationRules?: pulumi.Input<pulumi.Input<inputs.evidently.FeatureEvaluationRule>[]>;
    /**
     * Specify `ALL_RULES` to activate the traffic allocation specified by any ongoing launches or experiments. Specify `DEFAULT_VARIATION` to serve the default variation to all users instead.
     */
    evaluationStrategy?: pulumi.Input<string>;
    /**
     * The date and time that the feature was most recently updated.
     */
    lastUpdatedTime?: pulumi.Input<string>;
    /**
     * The name for the new feature. Minimum length of `1`. Maximum length of `127`.
     */
    name?: pulumi.Input<string>;
    /**
     * The name or ARN of the project that is to contain the new feature.
     */
    project?: pulumi.Input<string>;
    /**
     * The current state of the feature. Valid values are `AVAILABLE` and `UPDATING`.
     */
    status?: pulumi.Input<string>;
    /**
     * Tags to apply to the feature. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Defines the type of value used to define the different feature variations. Valid Values: `STRING`, `LONG`, `DOUBLE`, `BOOLEAN`.
     */
    valueType?: pulumi.Input<string>;
    /**
     * One or more blocks that contain the configuration of the feature's different variations. Detailed below
     */
    variations?: pulumi.Input<pulumi.Input<inputs.evidently.FeatureVariation>[]>;
}

/**
 * The set of arguments for constructing a Feature resource.
 */
export interface FeatureArgs {
    /**
     * The name of the variation to use as the default variation. The default variation is served to users who are not allocated to any ongoing launches or experiments of this feature. This variation must also be listed in the `variations` structure. If you omit `defaultVariation`, the first variation listed in the `variations` structure is used as the default variation.
     */
    defaultVariation?: pulumi.Input<string>;
    /**
     * Specifies the description of the feature.
     */
    description?: pulumi.Input<string>;
    /**
     * Specify users that should always be served a specific variation of a feature. Each user is specified by a key-value pair . For each key, specify a user by entering their user ID, account ID, or some other identifier. For the value, specify the name of the variation that they are to be served.
     */
    entityOverrides?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Specify `ALL_RULES` to activate the traffic allocation specified by any ongoing launches or experiments. Specify `DEFAULT_VARIATION` to serve the default variation to all users instead.
     */
    evaluationStrategy?: pulumi.Input<string>;
    /**
     * The name for the new feature. Minimum length of `1`. Maximum length of `127`.
     */
    name?: pulumi.Input<string>;
    /**
     * The name or ARN of the project that is to contain the new feature.
     */
    project: pulumi.Input<string>;
    /**
     * Tags to apply to the feature. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * One or more blocks that contain the configuration of the feature's different variations. Detailed below
     */
    variations: pulumi.Input<pulumi.Input<inputs.evidently.FeatureVariation>[]>;
}
