// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an IAM managed policy for a Single Sign-On (SSO) Permission Set resource
 *
 * > **NOTE:** Creating this resource will automatically [Provision the Permission Set](https://docs.aws.amazon.com/singlesignon/latest/APIReference/API_ProvisionPermissionSet.html) to apply the corresponding updates to all assigned accounts.
 *
 * ## Example Usage
 *
 * ### Basic Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.ssoadmin.getInstances({});
 * const examplePermissionSet = new aws.ssoadmin.PermissionSet("example", {
 *     name: "Example",
 *     instanceArn: example.then(example => example.arns?.[0]),
 * });
 * const exampleManagedPolicyAttachment = new aws.ssoadmin.ManagedPolicyAttachment("example", {
 *     instanceArn: example.then(example => example.arns?.[0]),
 *     managedPolicyArn: "arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup",
 *     permissionSetArn: examplePermissionSet.arn,
 * });
 * ```
 *
 * ### With Account Assignment
 *
 * > Because destruction of a managed policy attachment resource also re-provisions the associated permission set to all accounts, explicitly indicating the dependency with the account assignment resource via the `dependsOn` meta argument is necessary to ensure proper deletion order when these resources are used together.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.ssoadmin.getInstances({});
 * const examplePermissionSet = new aws.ssoadmin.PermissionSet("example", {
 *     name: "Example",
 *     instanceArn: example.then(example => example.arns?.[0]),
 * });
 * const exampleGroup = new aws.identitystore.Group("example", {
 *     identityStoreId: example.then(example => example.identityStoreIds?.[0]),
 *     displayName: "Admin",
 *     description: "Admin Group",
 * });
 * const exampleAccountAssignment = new aws.ssoadmin.AccountAssignment("example", {
 *     instanceArn: example.then(example => example.arns?.[0]),
 *     permissionSetArn: examplePermissionSet.arn,
 *     principalId: exampleGroup.groupId,
 *     principalType: "GROUP",
 *     targetId: "123456789012",
 *     targetType: "AWS_ACCOUNT",
 * });
 * const exampleManagedPolicyAttachment = new aws.ssoadmin.ManagedPolicyAttachment("example", {
 *     instanceArn: example.then(example => example.arns?.[0]),
 *     managedPolicyArn: "arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup",
 *     permissionSetArn: examplePermissionSet.arn,
 * }, {
 *     dependsOn: [exampleAccountAssignment],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SSO Managed Policy Attachments using the `managed_policy_arn`, `permission_set_arn`, and `instance_arn` separated by a comma (`,`). For example:
 *
 * ```sh
 * $ pulumi import aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment example arn:aws:iam::aws:policy/AlexaForBusinessDeviceSetup,arn:aws:sso:::permissionSet/ssoins-2938j0x8920sbj72/ps-80383020jr9302rk,arn:aws:sso:::instance/ssoins-2938j0x8920sbj72
 * ```
 */
export class ManagedPolicyAttachment extends pulumi.CustomResource {
    /**
     * Get an existing ManagedPolicyAttachment resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: ManagedPolicyAttachmentState, opts?: pulumi.CustomResourceOptions): ManagedPolicyAttachment {
        return new ManagedPolicyAttachment(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssoadmin/managedPolicyAttachment:ManagedPolicyAttachment';

    /**
     * Returns true if the given object is an instance of ManagedPolicyAttachment.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is ManagedPolicyAttachment {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === ManagedPolicyAttachment.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     */
    public readonly instanceArn!: pulumi.Output<string>;
    /**
     * The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
     */
    public readonly managedPolicyArn!: pulumi.Output<string>;
    /**
     * The name of the IAM Managed Policy.
     */
    public /*out*/ readonly managedPolicyName!: pulumi.Output<string>;
    /**
     * The Amazon Resource Name (ARN) of the Permission Set.
     */
    public readonly permissionSetArn!: pulumi.Output<string>;

    /**
     * Create a ManagedPolicyAttachment resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: ManagedPolicyAttachmentArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: ManagedPolicyAttachmentArgs | ManagedPolicyAttachmentState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as ManagedPolicyAttachmentState | undefined;
            resourceInputs["instanceArn"] = state ? state.instanceArn : undefined;
            resourceInputs["managedPolicyArn"] = state ? state.managedPolicyArn : undefined;
            resourceInputs["managedPolicyName"] = state ? state.managedPolicyName : undefined;
            resourceInputs["permissionSetArn"] = state ? state.permissionSetArn : undefined;
        } else {
            const args = argsOrState as ManagedPolicyAttachmentArgs | undefined;
            if ((!args || args.instanceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'instanceArn'");
            }
            if ((!args || args.managedPolicyArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'managedPolicyArn'");
            }
            if ((!args || args.permissionSetArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'permissionSetArn'");
            }
            resourceInputs["instanceArn"] = args ? args.instanceArn : undefined;
            resourceInputs["managedPolicyArn"] = args ? args.managedPolicyArn : undefined;
            resourceInputs["permissionSetArn"] = args ? args.permissionSetArn : undefined;
            resourceInputs["managedPolicyName"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(ManagedPolicyAttachment.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering ManagedPolicyAttachment resources.
 */
export interface ManagedPolicyAttachmentState {
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     */
    instanceArn?: pulumi.Input<string>;
    /**
     * The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
     */
    managedPolicyArn?: pulumi.Input<string>;
    /**
     * The name of the IAM Managed Policy.
     */
    managedPolicyName?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Permission Set.
     */
    permissionSetArn?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a ManagedPolicyAttachment resource.
 */
export interface ManagedPolicyAttachmentArgs {
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance under which the operation will be executed.
     */
    instanceArn: pulumi.Input<string>;
    /**
     * The IAM managed policy Amazon Resource Name (ARN) to be attached to the Permission Set.
     */
    managedPolicyArn: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Permission Set.
     */
    permissionSetArn: pulumi.Input<string>;
}
