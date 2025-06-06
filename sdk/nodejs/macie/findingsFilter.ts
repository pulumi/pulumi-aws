// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage an [Amazon Macie Findings Filter](https://docs.aws.amazon.com/macie/latest/APIReference/findingsfilters-id.html).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.macie2.Account("example", {});
 * const test = new aws.macie.FindingsFilter("test", {
 *     name: "NAME OF THE FINDINGS FILTER",
 *     description: "DESCRIPTION",
 *     position: 1,
 *     action: "ARCHIVE",
 *     findingCriteria: {
 *         criterions: [{
 *             field: "region",
 *             eqs: [current.name],
 *         }],
 *     },
 * }, {
 *     dependsOn: [testAwsMacie2Account],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_macie2_findings_filter` using the id. For example:
 *
 * ```sh
 * $ pulumi import aws:macie/findingsFilter:FindingsFilter example abcd1
 * ```
 */
export class FindingsFilter extends pulumi.CustomResource {
    /**
     * Get an existing FindingsFilter resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: FindingsFilterState, opts?: pulumi.CustomResourceOptions): FindingsFilter {
        return new FindingsFilter(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:macie/findingsFilter:FindingsFilter';

    /**
     * Returns true if the given object is an instance of FindingsFilter.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is FindingsFilter {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === FindingsFilter.__pulumiType;
    }

    /**
     * The action to perform on findings that meet the filter criteria (`findingCriteria`). Valid values are: `ARCHIVE`, suppress (automatically archive) the findings; and, `NOOP`, don't perform any action on the findings.
     */
    public readonly action!: pulumi.Output<string>;
    /**
     * The Amazon Resource Name (ARN) of the Findings Filter.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A custom description of the filter. The description can contain as many as 512 characters.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * The criteria to use to filter findings.
     */
    public readonly findingCriteria!: pulumi.Output<outputs.macie.FindingsFilterFindingCriteria>;
    /**
     * A custom name for the filter. The name must contain at least 3 characters and can contain as many as 64 characters. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    public readonly namePrefix!: pulumi.Output<string>;
    /**
     * The position of the filter in the list of saved filters on the Amazon Macie console. This value also determines the order in which the filter is applied to findings, relative to other filters that are also applied to the findings.
     */
    public readonly position!: pulumi.Output<number>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a FindingsFilter resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: FindingsFilterArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: FindingsFilterArgs | FindingsFilterState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as FindingsFilterState | undefined;
            resourceInputs["action"] = state ? state.action : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["findingCriteria"] = state ? state.findingCriteria : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["namePrefix"] = state ? state.namePrefix : undefined;
            resourceInputs["position"] = state ? state.position : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as FindingsFilterArgs | undefined;
            if ((!args || args.action === undefined) && !opts.urn) {
                throw new Error("Missing required property 'action'");
            }
            if ((!args || args.findingCriteria === undefined) && !opts.urn) {
                throw new Error("Missing required property 'findingCriteria'");
            }
            resourceInputs["action"] = args ? args.action : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["findingCriteria"] = args ? args.findingCriteria : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["namePrefix"] = args ? args.namePrefix : undefined;
            resourceInputs["position"] = args ? args.position : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(FindingsFilter.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering FindingsFilter resources.
 */
export interface FindingsFilterState {
    /**
     * The action to perform on findings that meet the filter criteria (`findingCriteria`). Valid values are: `ARCHIVE`, suppress (automatically archive) the findings; and, `NOOP`, don't perform any action on the findings.
     */
    action?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Findings Filter.
     */
    arn?: pulumi.Input<string>;
    /**
     * A custom description of the filter. The description can contain as many as 512 characters.
     */
    description?: pulumi.Input<string>;
    /**
     * The criteria to use to filter findings.
     */
    findingCriteria?: pulumi.Input<inputs.macie.FindingsFilterFindingCriteria>;
    /**
     * A custom name for the filter. The name must contain at least 3 characters and can contain as many as 64 characters. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * The position of the filter in the list of saved filters on the Amazon Macie console. This value also determines the order in which the filter is applied to findings, relative to other filters that are also applied to the findings.
     */
    position?: pulumi.Input<number>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a FindingsFilter resource.
 */
export interface FindingsFilterArgs {
    /**
     * The action to perform on findings that meet the filter criteria (`findingCriteria`). Valid values are: `ARCHIVE`, suppress (automatically archive) the findings; and, `NOOP`, don't perform any action on the findings.
     */
    action: pulumi.Input<string>;
    /**
     * A custom description of the filter. The description can contain as many as 512 characters.
     */
    description?: pulumi.Input<string>;
    /**
     * The criteria to use to filter findings.
     */
    findingCriteria: pulumi.Input<inputs.macie.FindingsFilterFindingCriteria>;
    /**
     * A custom name for the filter. The name must contain at least 3 characters and can contain as many as 64 characters. If omitted, the provider will assign a random, unique name. Conflicts with `namePrefix`.
     */
    name?: pulumi.Input<string>;
    /**
     * Creates a unique name beginning with the specified prefix. Conflicts with `name`.
     */
    namePrefix?: pulumi.Input<string>;
    /**
     * The position of the filter in the list of saved filters on the Amazon Macie console. This value also determines the order in which the filter is applied to findings, relative to other filters that are also applied to the findings.
     */
    position?: pulumi.Input<number>;
    /**
     * Map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
