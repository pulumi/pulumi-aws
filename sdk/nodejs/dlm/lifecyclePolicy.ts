// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a [Data Lifecycle Manager (DLM) lifecycle policy](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/snapshot-lifecycle.html) for managing snapshots.
 *
 * ## Example Usage
 *
 * ### Basic
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const assumeRole = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         principals: [{
 *             type: "Service",
 *             identifiers: ["dlm.amazonaws.com"],
 *         }],
 *         actions: ["sts:AssumeRole"],
 *     }],
 * });
 * const dlmLifecycleRole = new aws.iam.Role("dlm_lifecycle_role", {
 *     name: "dlm-lifecycle-role",
 *     assumeRolePolicy: assumeRole.then(assumeRole => assumeRole.json),
 * });
 * const dlmLifecycle = aws.iam.getPolicyDocument({
 *     statements: [
 *         {
 *             effect: "Allow",
 *             actions: [
 *                 "ec2:CreateSnapshot",
 *                 "ec2:CreateSnapshots",
 *                 "ec2:DeleteSnapshot",
 *                 "ec2:DescribeInstances",
 *                 "ec2:DescribeVolumes",
 *                 "ec2:DescribeSnapshots",
 *             ],
 *             resources: ["*"],
 *         },
 *         {
 *             effect: "Allow",
 *             actions: ["ec2:CreateTags"],
 *             resources: ["arn:aws:ec2:*::snapshot/*"],
 *         },
 *     ],
 * });
 * const dlmLifecycleRolePolicy = new aws.iam.RolePolicy("dlm_lifecycle", {
 *     name: "dlm-lifecycle-policy",
 *     role: dlmLifecycleRole.id,
 *     policy: dlmLifecycle.then(dlmLifecycle => dlmLifecycle.json),
 * });
 * const example = new aws.dlm.LifecyclePolicy("example", {
 *     description: "example DLM lifecycle policy",
 *     executionRoleArn: dlmLifecycleRole.arn,
 *     state: "ENABLED",
 *     policyDetails: {
 *         resourceTypes: "VOLUME",
 *         schedules: [{
 *             name: "2 weeks of daily snapshots",
 *             createRule: {
 *                 interval: 24,
 *                 intervalUnit: "HOURS",
 *                 times: "23:45",
 *             },
 *             retainRule: {
 *                 count: 14,
 *             },
 *             tagsToAdd: {
 *                 SnapshotCreator: "DLM",
 *             },
 *             copyTags: false,
 *         }],
 *         targetTags: {
 *             Snapshot: "true",
 *         },
 *     },
 * });
 * ```
 *
 * ### Example Cross-Region Snapshot Copy Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * // ...other configuration...
 * const current = aws.getCallerIdentity({});
 * const key = current.then(current => aws.iam.getPolicyDocument({
 *     statements: [{
 *         sid: "Enable IAM User Permissions",
 *         effect: "Allow",
 *         principals: [{
 *             type: "AWS",
 *             identifiers: [`arn:aws:iam::${current.accountId}:root`],
 *         }],
 *         actions: ["kms:*"],
 *         resources: ["*"],
 *     }],
 * }));
 * const dlmCrossRegionCopyCmk = new aws.kms.Key("dlm_cross_region_copy_cmk", {
 *     description: "Example Alternate Region KMS Key",
 *     policy: key.then(key => key.json),
 * });
 * const example = new aws.dlm.LifecyclePolicy("example", {
 *     description: "example DLM lifecycle policy",
 *     executionRoleArn: dlmLifecycleRole.arn,
 *     state: "ENABLED",
 *     policyDetails: {
 *         resourceTypes: "VOLUME",
 *         schedules: [{
 *             name: "2 weeks of daily snapshots",
 *             createRule: {
 *                 interval: 24,
 *                 intervalUnit: "HOURS",
 *                 times: "23:45",
 *             },
 *             retainRule: {
 *                 count: 14,
 *             },
 *             tagsToAdd: {
 *                 SnapshotCreator: "DLM",
 *             },
 *             copyTags: false,
 *             crossRegionCopyRules: [{
 *                 target: "us-west-2",
 *                 encrypted: true,
 *                 cmkArn: dlmCrossRegionCopyCmk.arn,
 *                 copyTags: true,
 *                 retainRule: {
 *                     interval: 30,
 *                     intervalUnit: "DAYS",
 *                 },
 *             }],
 *         }],
 *         targetTags: {
 *             Snapshot: "true",
 *         },
 *     },
 * });
 * ```
 *
 * ### Example Event Based Policy Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const exampleLifecyclePolicy = new aws.dlm.LifecyclePolicy("example", {
 *     description: "tf-acc-basic",
 *     executionRoleArn: exampleAwsIamRole.arn,
 *     policyDetails: {
 *         policyType: "EVENT_BASED_POLICY",
 *         action: {
 *             name: "tf-acc-basic",
 *             crossRegionCopies: [{
 *                 encryptionConfiguration: {},
 *                 retainRule: {
 *                     interval: 15,
 *                     intervalUnit: "MONTHS",
 *                 },
 *                 target: "us-east-1",
 *             }],
 *         },
 *         eventSource: {
 *             type: "MANAGED_CWE",
 *             parameters: {
 *                 descriptionRegex: "^.*Created for policy: policy-1234567890abcdef0.*$",
 *                 eventType: "shareSnapshot",
 *                 snapshotOwners: [current.then(current => current.accountId)],
 *             },
 *         },
 *     },
 * });
 * const example = aws.iam.getPolicy({
 *     name: "AWSDataLifecycleManagerServiceRole",
 * });
 * const exampleRolePolicyAttachment = new aws.iam.RolePolicyAttachment("example", {
 *     role: exampleAwsIamRole.id,
 *     policyArn: example.then(example => example.arn),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import DLM lifecycle policies using their policy ID. For example:
 *
 * ```sh
 * $ pulumi import aws:dlm/lifecyclePolicy:LifecyclePolicy example policy-abcdef12345678901
 * ```
 */
export class LifecyclePolicy extends pulumi.CustomResource {
    /**
     * Get an existing LifecyclePolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: LifecyclePolicyState, opts?: pulumi.CustomResourceOptions): LifecyclePolicy {
        return new LifecyclePolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:dlm/lifecyclePolicy:LifecyclePolicy';

    /**
     * Returns true if the given object is an instance of LifecyclePolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is LifecyclePolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === LifecyclePolicy.__pulumiType;
    }

    /**
     * Amazon Resource Name (ARN) of the DLM Lifecycle Policy.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A description for the DLM lifecycle policy.
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * The ARN of an IAM role that is able to be assumed by the DLM service.
     */
    public readonly executionRoleArn!: pulumi.Output<string>;
    /**
     * See the `policyDetails` configuration block. Max of 1.
     */
    public readonly policyDetails!: pulumi.Output<outputs.dlm.LifecyclePolicyPolicyDetails>;
    /**
     * Whether the lifecycle policy should be enabled or disabled. `ENABLED` or `DISABLED` are valid values. Defaults to `ENABLED`.
     */
    public readonly state!: pulumi.Output<string | undefined>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;

    /**
     * Create a LifecyclePolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: LifecyclePolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: LifecyclePolicyArgs | LifecyclePolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as LifecyclePolicyState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["executionRoleArn"] = state ? state.executionRoleArn : undefined;
            resourceInputs["policyDetails"] = state ? state.policyDetails : undefined;
            resourceInputs["state"] = state ? state.state : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
        } else {
            const args = argsOrState as LifecyclePolicyArgs | undefined;
            if ((!args || args.description === undefined) && !opts.urn) {
                throw new Error("Missing required property 'description'");
            }
            if ((!args || args.executionRoleArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'executionRoleArn'");
            }
            if ((!args || args.policyDetails === undefined) && !opts.urn) {
                throw new Error("Missing required property 'policyDetails'");
            }
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["executionRoleArn"] = args ? args.executionRoleArn : undefined;
            resourceInputs["policyDetails"] = args ? args.policyDetails : undefined;
            resourceInputs["state"] = args ? args.state : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(LifecyclePolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering LifecyclePolicy resources.
 */
export interface LifecyclePolicyState {
    /**
     * Amazon Resource Name (ARN) of the DLM Lifecycle Policy.
     */
    arn?: pulumi.Input<string>;
    /**
     * A description for the DLM lifecycle policy.
     */
    description?: pulumi.Input<string>;
    /**
     * The ARN of an IAM role that is able to be assumed by the DLM service.
     */
    executionRoleArn?: pulumi.Input<string>;
    /**
     * See the `policyDetails` configuration block. Max of 1.
     */
    policyDetails?: pulumi.Input<inputs.dlm.LifecyclePolicyPolicyDetails>;
    /**
     * Whether the lifecycle policy should be enabled or disabled. `ENABLED` or `DISABLED` are valid values. Defaults to `ENABLED`.
     */
    state?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
 * The set of arguments for constructing a LifecyclePolicy resource.
 */
export interface LifecyclePolicyArgs {
    /**
     * A description for the DLM lifecycle policy.
     */
    description: pulumi.Input<string>;
    /**
     * The ARN of an IAM role that is able to be assumed by the DLM service.
     */
    executionRoleArn: pulumi.Input<string>;
    /**
     * See the `policyDetails` configuration block. Max of 1.
     */
    policyDetails: pulumi.Input<inputs.dlm.LifecyclePolicyPolicyDetails>;
    /**
     * Whether the lifecycle policy should be enabled or disabled. `ENABLED` or `DISABLED` are valid values. Defaults to `ENABLED`.
     */
    state?: pulumi.Input<string>;
    /**
     * Key-value map of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
