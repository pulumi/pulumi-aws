// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a Single Sign-On (SSO) Account Assignment resource
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
 * const exampleGetPermissionSet = example.then(example => aws.ssoadmin.getPermissionSet({
 *     instanceArn: example.arns?.[0],
 *     name: "AWSReadOnlyAccess",
 * }));
 * const exampleGetGroup = example.then(example => aws.identitystore.getGroup({
 *     identityStoreId: example.identityStoreIds?.[0],
 *     alternateIdentifier: {
 *         uniqueAttribute: {
 *             attributePath: "DisplayName",
 *             attributeValue: "ExampleGroup",
 *         },
 *     },
 * }));
 * const exampleAccountAssignment = new aws.ssoadmin.AccountAssignment("example", {
 *     instanceArn: example.then(example => example.arns?.[0]),
 *     permissionSetArn: exampleGetPermissionSet.then(exampleGetPermissionSet => exampleGetPermissionSet.arn),
 *     principalId: exampleGetGroup.then(exampleGetGroup => exampleGetGroup.groupId),
 *     principalType: "GROUP",
 *     targetId: "123456789012",
 *     targetType: "AWS_ACCOUNT",
 * });
 * ```
 *
 * ### With Managed Policy Attachment
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
 * const accountAssignment = new aws.ssoadmin.AccountAssignment("account_assignment", {
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
 *     dependsOn: [exampleAwsSsoadminAccountAssignment],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SSO Account Assignments using the `principal_id`, `principal_type`, `target_id`, `target_type`, `permission_set_arn`, `instance_arn` separated by commas (`,`). For example:
 *
 * ```sh
 * $ pulumi import aws:ssoadmin/accountAssignment:AccountAssignment example f81d4fae-7dec-11d0-a765-00a0c91e6bf6,GROUP,1234567890,AWS_ACCOUNT,arn:aws:sso:::permissionSet/ssoins-0123456789abcdef/ps-0123456789abcdef,arn:aws:sso:::instance/ssoins-0123456789abcdef
 * ```
 */
export class AccountAssignment extends pulumi.CustomResource {
    /**
     * Get an existing AccountAssignment resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AccountAssignmentState, opts?: pulumi.CustomResourceOptions): AccountAssignment {
        return new AccountAssignment(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssoadmin/accountAssignment:AccountAssignment';

    /**
     * Returns true if the given object is an instance of AccountAssignment.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is AccountAssignment {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === AccountAssignment.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     */
    public readonly instanceArn!: pulumi.Output<string>;
    /**
     * The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
     */
    public readonly permissionSetArn!: pulumi.Output<string>;
    /**
     * An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
     */
    public readonly principalId!: pulumi.Output<string>;
    /**
     * The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
     */
    public readonly principalType!: pulumi.Output<string>;
    /**
     * An AWS account identifier, typically a 10-12 digit string.
     */
    public readonly targetId!: pulumi.Output<string>;
    /**
     * The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
     */
    public readonly targetType!: pulumi.Output<string | undefined>;

    /**
     * Create a AccountAssignment resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: AccountAssignmentArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AccountAssignmentArgs | AccountAssignmentState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AccountAssignmentState | undefined;
            resourceInputs["instanceArn"] = state ? state.instanceArn : undefined;
            resourceInputs["permissionSetArn"] = state ? state.permissionSetArn : undefined;
            resourceInputs["principalId"] = state ? state.principalId : undefined;
            resourceInputs["principalType"] = state ? state.principalType : undefined;
            resourceInputs["targetId"] = state ? state.targetId : undefined;
            resourceInputs["targetType"] = state ? state.targetType : undefined;
        } else {
            const args = argsOrState as AccountAssignmentArgs | undefined;
            if ((!args || args.instanceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'instanceArn'");
            }
            if ((!args || args.permissionSetArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'permissionSetArn'");
            }
            if ((!args || args.principalId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'principalId'");
            }
            if ((!args || args.principalType === undefined) && !opts.urn) {
                throw new Error("Missing required property 'principalType'");
            }
            if ((!args || args.targetId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'targetId'");
            }
            resourceInputs["instanceArn"] = args ? args.instanceArn : undefined;
            resourceInputs["permissionSetArn"] = args ? args.permissionSetArn : undefined;
            resourceInputs["principalId"] = args ? args.principalId : undefined;
            resourceInputs["principalType"] = args ? args.principalType : undefined;
            resourceInputs["targetId"] = args ? args.targetId : undefined;
            resourceInputs["targetType"] = args ? args.targetType : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(AccountAssignment.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering AccountAssignment resources.
 */
export interface AccountAssignmentState {
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     */
    instanceArn?: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
     */
    permissionSetArn?: pulumi.Input<string>;
    /**
     * An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
     */
    principalId?: pulumi.Input<string>;
    /**
     * The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
     */
    principalType?: pulumi.Input<string>;
    /**
     * An AWS account identifier, typically a 10-12 digit string.
     */
    targetId?: pulumi.Input<string>;
    /**
     * The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
     */
    targetType?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a AccountAssignment resource.
 */
export interface AccountAssignmentArgs {
    /**
     * The Amazon Resource Name (ARN) of the SSO Instance.
     */
    instanceArn: pulumi.Input<string>;
    /**
     * The Amazon Resource Name (ARN) of the Permission Set that the admin wants to grant the principal access to.
     */
    permissionSetArn: pulumi.Input<string>;
    /**
     * An identifier for an object in SSO, such as a user or group. PrincipalIds are GUIDs (For example, `f81d4fae-7dec-11d0-a765-00a0c91e6bf6`).
     */
    principalId: pulumi.Input<string>;
    /**
     * The entity type for which the assignment will be created. Valid values: `USER`, `GROUP`.
     */
    principalType: pulumi.Input<string>;
    /**
     * An AWS account identifier, typically a 10-12 digit string.
     */
    targetId: pulumi.Input<string>;
    /**
     * The entity type for which the assignment will be created. Valid values: `AWS_ACCOUNT`.
     */
    targetType?: pulumi.Input<string>;
}
