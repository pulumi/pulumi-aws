// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides a resource to manage a GuardDuty member. To accept invitations in member accounts, see the `aws.guardduty.InviteAccepter` resource.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const primary = new aws.guardduty.Detector("primary", {enable: true});
 * const member = new aws.guardduty.Detector("member", {enable: true});
 * const memberMember = new aws.guardduty.Member("member", {
 *     accountId: member.accountId,
 *     detectorId: primary.id,
 *     email: "required@example.com",
 *     invite: true,
 *     invitationMessage: "please accept guardduty invitation",
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import GuardDuty members using the primary GuardDuty detector ID and member AWS account ID. For example:
 *
 * ```sh
 * $ pulumi import aws:guardduty/member:Member MyMember 00b00fd5aecc0ab60a708659477e9617:123456789012
 * ```
 */
export class Member extends pulumi.CustomResource {
    /**
     * Get an existing Member resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: MemberState, opts?: pulumi.CustomResourceOptions): Member {
        return new Member(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:guardduty/member:Member';

    /**
     * Returns true if the given object is an instance of Member.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Member {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Member.__pulumiType;
    }

    /**
     * AWS account ID for member account.
     */
    public readonly accountId!: pulumi.Output<string>;
    /**
     * The detector ID of the GuardDuty account where you want to create member accounts.
     */
    public readonly detectorId!: pulumi.Output<string>;
    /**
     * Boolean whether an email notification is sent to the accounts. Defaults to `false`.
     */
    public readonly disableEmailNotification!: pulumi.Output<boolean | undefined>;
    /**
     * Email address for member account.
     */
    public readonly email!: pulumi.Output<string>;
    /**
     * Message for invitation.
     */
    public readonly invitationMessage!: pulumi.Output<string | undefined>;
    /**
     * Boolean whether to invite the account to GuardDuty as a member. Defaults to `false`. To detect if an invitation needs to be (re-)sent, the this provider state value is `true` based on a `relationshipStatus` of `Disabled`, `Enabled`, `Invited`, or `EmailVerificationInProgress`.
     */
    public readonly invite!: pulumi.Output<boolean | undefined>;
    /**
     * The status of the relationship between the member account and its primary account. More information can be found in [Amazon GuardDuty API Reference](https://docs.aws.amazon.com/guardduty/latest/ug/get-members.html).
     */
    public /*out*/ readonly relationshipStatus!: pulumi.Output<string>;

    /**
     * Create a Member resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: MemberArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: MemberArgs | MemberState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as MemberState | undefined;
            resourceInputs["accountId"] = state ? state.accountId : undefined;
            resourceInputs["detectorId"] = state ? state.detectorId : undefined;
            resourceInputs["disableEmailNotification"] = state ? state.disableEmailNotification : undefined;
            resourceInputs["email"] = state ? state.email : undefined;
            resourceInputs["invitationMessage"] = state ? state.invitationMessage : undefined;
            resourceInputs["invite"] = state ? state.invite : undefined;
            resourceInputs["relationshipStatus"] = state ? state.relationshipStatus : undefined;
        } else {
            const args = argsOrState as MemberArgs | undefined;
            if ((!args || args.accountId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'accountId'");
            }
            if ((!args || args.detectorId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'detectorId'");
            }
            if ((!args || args.email === undefined) && !opts.urn) {
                throw new Error("Missing required property 'email'");
            }
            resourceInputs["accountId"] = args ? args.accountId : undefined;
            resourceInputs["detectorId"] = args ? args.detectorId : undefined;
            resourceInputs["disableEmailNotification"] = args ? args.disableEmailNotification : undefined;
            resourceInputs["email"] = args ? args.email : undefined;
            resourceInputs["invitationMessage"] = args ? args.invitationMessage : undefined;
            resourceInputs["invite"] = args ? args.invite : undefined;
            resourceInputs["relationshipStatus"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Member.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Member resources.
 */
export interface MemberState {
    /**
     * AWS account ID for member account.
     */
    accountId?: pulumi.Input<string>;
    /**
     * The detector ID of the GuardDuty account where you want to create member accounts.
     */
    detectorId?: pulumi.Input<string>;
    /**
     * Boolean whether an email notification is sent to the accounts. Defaults to `false`.
     */
    disableEmailNotification?: pulumi.Input<boolean>;
    /**
     * Email address for member account.
     */
    email?: pulumi.Input<string>;
    /**
     * Message for invitation.
     */
    invitationMessage?: pulumi.Input<string>;
    /**
     * Boolean whether to invite the account to GuardDuty as a member. Defaults to `false`. To detect if an invitation needs to be (re-)sent, the this provider state value is `true` based on a `relationshipStatus` of `Disabled`, `Enabled`, `Invited`, or `EmailVerificationInProgress`.
     */
    invite?: pulumi.Input<boolean>;
    /**
     * The status of the relationship between the member account and its primary account. More information can be found in [Amazon GuardDuty API Reference](https://docs.aws.amazon.com/guardduty/latest/ug/get-members.html).
     */
    relationshipStatus?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Member resource.
 */
export interface MemberArgs {
    /**
     * AWS account ID for member account.
     */
    accountId: pulumi.Input<string>;
    /**
     * The detector ID of the GuardDuty account where you want to create member accounts.
     */
    detectorId: pulumi.Input<string>;
    /**
     * Boolean whether an email notification is sent to the accounts. Defaults to `false`.
     */
    disableEmailNotification?: pulumi.Input<boolean>;
    /**
     * Email address for member account.
     */
    email: pulumi.Input<string>;
    /**
     * Message for invitation.
     */
    invitationMessage?: pulumi.Input<string>;
    /**
     * Boolean whether to invite the account to GuardDuty as a member. Defaults to `false`. To detect if an invitation needs to be (re-)sent, the this provider state value is `true` based on a `relationshipStatus` of `Disabled`, `Enabled`, `Invited`, or `EmailVerificationInProgress`.
     */
    invite?: pulumi.Input<boolean>;
}
