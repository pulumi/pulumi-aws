// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Manages the GuardDuty Organization Configuration in the current AWS Region. The AWS account utilizing this resource must have been assigned as a delegated Organization administrator account, e.g., via the `aws.guardduty.OrganizationAdminAccount` resource. More information about Organizations support in GuardDuty can be found in the [GuardDuty User Guide](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty_organizations.html).
 *
 * > **NOTE:** This is an advanced resource. The provider will automatically assume management of the GuardDuty Organization Configuration without import and perform no actions on removal from the resource configuration.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.guardduty.Detector("example", {enable: true});
 * const exampleOrganizationConfiguration = new aws.guardduty.OrganizationConfiguration("example", {
 *     autoEnableOrganizationMembers: "ALL",
 *     detectorId: example.id,
 *     datasources: {
 *         s3Logs: {
 *             autoEnable: true,
 *         },
 *         kubernetes: {
 *             auditLogs: {
 *                 enable: true,
 *             },
 *         },
 *         malwareProtection: {
 *             scanEc2InstanceWithFindings: {
 *                 ebsVolumes: {
 *                     autoEnable: true,
 *                 },
 *             },
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import GuardDuty Organization Configurations using the GuardDuty Detector ID. For example:
 *
 * ```sh
 * $ pulumi import aws:guardduty/organizationConfiguration:OrganizationConfiguration example 00b00fd5aecc0ab60a708659477e9617
 * ```
 */
export class OrganizationConfiguration extends pulumi.CustomResource {
    /**
     * Get an existing OrganizationConfiguration resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: OrganizationConfigurationState, opts?: pulumi.CustomResourceOptions): OrganizationConfiguration {
        return new OrganizationConfiguration(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:guardduty/organizationConfiguration:OrganizationConfiguration';

    /**
     * Returns true if the given object is an instance of OrganizationConfiguration.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is OrganizationConfiguration {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === OrganizationConfiguration.__pulumiType;
    }

    /**
     * *Deprecated:* Use `autoEnableOrganizationMembers` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
     *
     * @deprecated auto_enable is deprecated. Use autoEnableOrganizationMembers instead.
     */
    public readonly autoEnable!: pulumi.Output<boolean>;
    /**
     * Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
     */
    public readonly autoEnableOrganizationMembers!: pulumi.Output<string>;
    /**
     * Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
     *
     * > **NOTE:** One of `autoEnable` or `autoEnableOrganizationMembers` must be specified.
     */
    public readonly datasources!: pulumi.Output<outputs.guardduty.OrganizationConfigurationDatasources>;
    /**
     * The detector ID of the GuardDuty account.
     */
    public readonly detectorId!: pulumi.Output<string>;

    /**
     * Create a OrganizationConfiguration resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: OrganizationConfigurationArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: OrganizationConfigurationArgs | OrganizationConfigurationState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as OrganizationConfigurationState | undefined;
            resourceInputs["autoEnable"] = state ? state.autoEnable : undefined;
            resourceInputs["autoEnableOrganizationMembers"] = state ? state.autoEnableOrganizationMembers : undefined;
            resourceInputs["datasources"] = state ? state.datasources : undefined;
            resourceInputs["detectorId"] = state ? state.detectorId : undefined;
        } else {
            const args = argsOrState as OrganizationConfigurationArgs | undefined;
            if ((!args || args.detectorId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'detectorId'");
            }
            resourceInputs["autoEnable"] = args ? args.autoEnable : undefined;
            resourceInputs["autoEnableOrganizationMembers"] = args ? args.autoEnableOrganizationMembers : undefined;
            resourceInputs["datasources"] = args ? args.datasources : undefined;
            resourceInputs["detectorId"] = args ? args.detectorId : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(OrganizationConfiguration.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering OrganizationConfiguration resources.
 */
export interface OrganizationConfigurationState {
    /**
     * *Deprecated:* Use `autoEnableOrganizationMembers` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
     *
     * @deprecated auto_enable is deprecated. Use autoEnableOrganizationMembers instead.
     */
    autoEnable?: pulumi.Input<boolean>;
    /**
     * Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
     */
    autoEnableOrganizationMembers?: pulumi.Input<string>;
    /**
     * Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
     *
     * > **NOTE:** One of `autoEnable` or `autoEnableOrganizationMembers` must be specified.
     */
    datasources?: pulumi.Input<inputs.guardduty.OrganizationConfigurationDatasources>;
    /**
     * The detector ID of the GuardDuty account.
     */
    detectorId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a OrganizationConfiguration resource.
 */
export interface OrganizationConfigurationArgs {
    /**
     * *Deprecated:* Use `autoEnableOrganizationMembers` instead. When this setting is enabled, all new accounts that are created in, or added to, the organization are added as a member accounts of the organization’s GuardDuty delegated administrator and GuardDuty is enabled in that AWS Region.
     *
     * @deprecated auto_enable is deprecated. Use autoEnableOrganizationMembers instead.
     */
    autoEnable?: pulumi.Input<boolean>;
    /**
     * Indicates the auto-enablement configuration of GuardDuty for the member accounts in the organization. Valid values are `ALL`, `NEW`, `NONE`.
     */
    autoEnableOrganizationMembers?: pulumi.Input<string>;
    /**
     * Configuration for the collected datasources. [Deprecated](https://docs.aws.amazon.com/guardduty/latest/ug/guardduty-feature-object-api-changes-march2023.html) in favor of `aws.guardduty.OrganizationConfigurationFeature` resources.
     *
     * > **NOTE:** One of `autoEnable` or `autoEnableOrganizationMembers` must be specified.
     */
    datasources?: pulumi.Input<inputs.guardduty.OrganizationConfigurationDatasources>;
    /**
     * The detector ID of the GuardDuty account.
     */
    detectorId: pulumi.Input<string>;
}
