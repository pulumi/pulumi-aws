// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a License Manager license configuration resource.
 *
 * > **Note:** Removing the `licenseCount` attribute is not supported by the License Manager API.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.licensemanager.LicenseConfiguration("example", {
 *     name: "Example",
 *     description: "Example",
 *     licenseCount: 10,
 *     licenseCountHardLimit: true,
 *     licenseCountingType: "Socket",
 *     licenseRules: ["#minimumSockets=2"],
 *     tags: {
 *         foo: "barr",
 *     },
 * });
 * ```
 *
 * ## Rules
 *
 * License rules should be in the format of `#RuleType=RuleValue`. Supported rule types:
 *
 * * `minimumVcpus` - Resource must have minimum vCPU count in order to use the license. Default: 1
 * * `maximumVcpus` - Resource must have maximum vCPU count in order to use the license. Default: unbounded, limit: 10000
 * * `minimumCores` - Resource must have minimum core count in order to use the license. Default: 1
 * * `maximumCores` - Resource must have maximum core count in order to use the license. Default: unbounded, limit: 10000
 * * `minimumSockets` - Resource must have minimum socket count in order to use the license. Default: 1
 * * `maximumSockets` - Resource must have maximum socket count in order to use the license. Default: unbounded, limit: 10000
 * * `allowedTenancy` - Defines where the license can be used. If set, restricts license usage to selected tenancies. Specify a comma delimited list of `EC2-Default`, `EC2-DedicatedHost`, `EC2-DedicatedInstance`
 *
 * ## Import
 *
 * Using `pulumi import`, import license configurations using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:licensemanager/licenseConfiguration:LicenseConfiguration example arn:aws:license-manager:eu-west-1:123456789012:license-configuration:lic-0123456789abcdef0123456789abcdef
 * ```
 */
export class LicenseConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing LicenseConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: LicenseConfigurationState, opts?: pulumi.CustomResourceOptions): LicenseConfiguration {
        return new LicenseConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:licensemanager/licenseConfiguration:LicenseConfiguration';

    /**
     * Returns true if the given object is an instance of LicenseConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is LicenseConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === LicenseConfiguration.__pulumiType;
    }

    /**
     * The license configuration ARN.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Description of the license configuration.
     */
    public readonly description!: pulumi.Output<string | undefined>;
    /**
     * Number of licenses managed by the license configuration.
     */
    public readonly licenseCount!: pulumi.Output<number | undefined>;
    /**
     * Sets the number of available licenses as a hard limit.
     */
    public readonly licenseCountHardLimit!: pulumi.Output<boolean | undefined>;
    /**
     * Dimension to use to track license inventory. Specify either `vCPU`, `Instance`, `Core` or `Socket`.
     */
    public readonly licenseCountingType!: pulumi.Output<string>;
    /**
     * Array of configured License Manager rules.
     */
    public readonly licenseRules!: pulumi.Output<string[] | undefined>;
    /**
     * Name of the license configuration.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Account ID of the owner of the license configuration.
     */
    public /*out*/ readonly ownerAccountId!: pulumi.Output<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a LicenseConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: LicenseConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: LicenseConfigurationArgs | LicenseConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as LicenseConfigurationState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["licenseCount"] = state ? state.licenseCount : undefined;
            resourceInputs["licenseCountHardLimit"] = state ? state.licenseCountHardLimit : undefined;
            resourceInputs["licenseCountingType"] = state ? state.licenseCountingType : undefined;
            resourceInputs["licenseRules"] = state ? state.licenseRules : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["ownerAccountId"] = state ? state.ownerAccountId : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as LicenseConfigurationArgs | undefined;
            if ((!args || args.licenseCountingType === undefined) && !opts.urn) {
                throw new Error("Missing required property 'licenseCountingType'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["licenseCount"] = args ? args.licenseCount : undefined;
            resourceInputs["licenseCountHardLimit"] = args ? args.licenseCountHardLimit : undefined;
            resourceInputs["licenseCountingType"] = args ? args.licenseCountingType : undefined;
            resourceInputs["licenseRules"] = args ? args.licenseRules : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["ownerAccountId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(LicenseConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering LicenseConfiguration resources.
 */
export interface LicenseConfigurationState {
    /**
     * The license configuration ARN.
     */
    arn?: pulumi.Input<string>;
    /**
     * Description of the license configuration.
     */
    description?: pulumi.Input<string>;
    /**
     * Number of licenses managed by the license configuration.
     */
    licenseCount?: pulumi.Input<number>;
    /**
     * Sets the number of available licenses as a hard limit.
     */
    licenseCountHardLimit?: pulumi.Input<boolean>;
    /**
     * Dimension to use to track license inventory. Specify either `vCPU`, `Instance`, `Core` or `Socket`.
     */
    licenseCountingType?: pulumi.Input<string>;
    /**
     * Array of configured License Manager rules.
     */
    licenseRules?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Name of the license configuration.
     */
    name?: pulumi.Input<string>;
    /**
     * Account ID of the owner of the license configuration.
     */
    ownerAccountId?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a LicenseConfiguration resource.
 */
export interface LicenseConfigurationArgs {
    /**
     * Description of the license configuration.
     */
    description?: pulumi.Input<string>;
    /**
     * Number of licenses managed by the license configuration.
     */
    licenseCount?: pulumi.Input<number>;
    /**
     * Sets the number of available licenses as a hard limit.
     */
    licenseCountHardLimit?: pulumi.Input<boolean>;
    /**
     * Dimension to use to track license inventory. Specify either `vCPU`, `Instance`, `Core` or `Socket`.
     */
    licenseCountingType: pulumi.Input<string>;
    /**
     * Array of configured License Manager rules.
     */
    licenseRules?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Name of the license configuration.
     */
    name?: pulumi.Input<string>;
    /**
     * A map of tags to assign to the resource. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
