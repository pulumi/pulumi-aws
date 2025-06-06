// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Resource for registering an AWS Systems Manager Default Patch Baseline.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const examplePatchBaseline = new aws.ssm.PatchBaseline("example", {
 *     name: "example",
 *     approvedPatches: ["KB123456"],
 * });
 * const example = new aws.ssm.DefaultPatchBaseline("example", {
 *     baselineId: examplePatchBaseline.id,
 *     operatingSystem: examplePatchBaseline.operatingSystem,
 * });
 * ```
 *
 * ## Import
 *
 * Using the patch baseline ARN:
 *
 * Using the operating system value:
 *
 * __Using `pulumi import` to import__ the Systems Manager Default Patch Baseline using the patch baseline ID, patch baseline ARN, or the operating system value. For example:
 *
 * Using the patch baseline ID:
 *
 * ```sh
 * $ pulumi import aws:ssm/defaultPatchBaseline:DefaultPatchBaseline example pb-1234567890abcdef1
 * ```
 * Using the patch baseline ARN:
 *
 * ```sh
 * $ pulumi import aws:ssm/defaultPatchBaseline:DefaultPatchBaseline example arn:aws:ssm:us-west-2:123456789012:patchbaseline/pb-1234567890abcdef1
 * ```
 * Using the operating system value:
 *
 * ```sh
 * $ pulumi import aws:ssm/defaultPatchBaseline:DefaultPatchBaseline example CENTOS
 * ```
 */
export class DefaultPatchBaseline extends pulumi.CustomResource {
    /**
     * Get an existing DefaultPatchBaseline resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: DefaultPatchBaselineState, opts?: pulumi.CustomResourceOptions): DefaultPatchBaseline {
        return new DefaultPatchBaseline(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssm/defaultPatchBaseline:DefaultPatchBaseline';

    /**
     * Returns true if the given object is an instance of DefaultPatchBaseline.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is DefaultPatchBaseline {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === DefaultPatchBaseline.__pulumiType;
    }

    /**
     * ID of the patch baseline.
     * Can be an ID or an ARN.
     * When specifying an AWS-provided patch baseline, must be the ARN.
     */
    public readonly baselineId!: pulumi.Output<string>;
    /**
     * The operating system the patch baseline applies to.
     * Valid values are
     * `AMAZON_LINUX`,
     * `AMAZON_LINUX_2`,
     * `AMAZON_LINUX_2022`,
     * `CENTOS`,
     * `DEBIAN`,
     * `MACOS`,
     * `ORACLE_LINUX`,
     * `RASPBIAN`,
     * `REDHAT_ENTERPRISE_LINUX`,
     * `ROCKY_LINUX`,
     * `SUSE`,
     * `UBUNTU`, and
     * `WINDOWS`.
     */
    public readonly operatingSystem!: pulumi.Output<string>;

    /**
     * Create a DefaultPatchBaseline resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: DefaultPatchBaselineArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: DefaultPatchBaselineArgs | DefaultPatchBaselineState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as DefaultPatchBaselineState | undefined;
            resourceInputs["baselineId"] = state ? state.baselineId : undefined;
            resourceInputs["operatingSystem"] = state ? state.operatingSystem : undefined;
        } else {
            const args = argsOrState as DefaultPatchBaselineArgs | undefined;
            if ((!args || args.baselineId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'baselineId'");
            }
            if ((!args || args.operatingSystem === undefined) && !opts.urn) {
                throw new Error("Missing required property 'operatingSystem'");
            }
            resourceInputs["baselineId"] = args ? args.baselineId : undefined;
            resourceInputs["operatingSystem"] = args ? args.operatingSystem : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(DefaultPatchBaseline.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering DefaultPatchBaseline resources.
 */
export interface DefaultPatchBaselineState {
    /**
     * ID of the patch baseline.
     * Can be an ID or an ARN.
     * When specifying an AWS-provided patch baseline, must be the ARN.
     */
    baselineId?: pulumi.Input<string>;
    /**
     * The operating system the patch baseline applies to.
     * Valid values are
     * `AMAZON_LINUX`,
     * `AMAZON_LINUX_2`,
     * `AMAZON_LINUX_2022`,
     * `CENTOS`,
     * `DEBIAN`,
     * `MACOS`,
     * `ORACLE_LINUX`,
     * `RASPBIAN`,
     * `REDHAT_ENTERPRISE_LINUX`,
     * `ROCKY_LINUX`,
     * `SUSE`,
     * `UBUNTU`, and
     * `WINDOWS`.
     */
    operatingSystem?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a DefaultPatchBaseline resource.
 */
export interface DefaultPatchBaselineArgs {
    /**
     * ID of the patch baseline.
     * Can be an ID or an ARN.
     * When specifying an AWS-provided patch baseline, must be the ARN.
     */
    baselineId: pulumi.Input<string>;
    /**
     * The operating system the patch baseline applies to.
     * Valid values are
     * `AMAZON_LINUX`,
     * `AMAZON_LINUX_2`,
     * `AMAZON_LINUX_2022`,
     * `CENTOS`,
     * `DEBIAN`,
     * `MACOS`,
     * `ORACLE_LINUX`,
     * `RASPBIAN`,
     * `REDHAT_ENTERPRISE_LINUX`,
     * `ROCKY_LINUX`,
     * `SUSE`,
     * `UBUNTU`, and
     * `WINDOWS`.
     */
    operatingSystem: pulumi.Input<string>;
}
