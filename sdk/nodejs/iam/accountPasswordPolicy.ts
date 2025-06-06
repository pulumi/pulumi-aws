// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * > **Note:** There is only a single policy allowed per AWS account. An existing policy will be lost when using this resource as an effect of this limitation.
 *
 * Manages Password Policy for the AWS Account.
 * See more about [Account Password Policy](http://docs.aws.amazon.com/IAM/latest/UserGuide/id_credentials_passwords_account-policy.html)
 * in the official AWS docs.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const strict = new aws.iam.AccountPasswordPolicy("strict", {
 *     minimumPasswordLength: 8,
 *     requireLowercaseCharacters: true,
 *     requireNumbers: true,
 *     requireUppercaseCharacters: true,
 *     requireSymbols: true,
 *     allowUsersToChangePassword: true,
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IAM Account Password Policy using the word `iam-account-password-policy`. For example:
 *
 * ```sh
 * $ pulumi import aws:iam/accountPasswordPolicy:AccountPasswordPolicy strict iam-account-password-policy
 * ```
 */
export class AccountPasswordPolicy extends pulumi.CustomResource {
    /**
     * Get an existing AccountPasswordPolicy resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AccountPasswordPolicyState, opts?: pulumi.CustomResourceOptions): AccountPasswordPolicy {
        return new AccountPasswordPolicy(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iam/accountPasswordPolicy:AccountPasswordPolicy';

    /**
     * Returns true if the given object is an instance of AccountPasswordPolicy.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is AccountPasswordPolicy {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === AccountPasswordPolicy.__pulumiType;
    }

    /**
     * Whether to allow users to change their own password
     */
    public readonly allowUsersToChangePassword!: pulumi.Output<boolean | undefined>;
    /**
     * Indicates whether passwords in the account expire. Returns `true` if `maxPasswordAge` contains a value greater than `0`. Returns `false` if it is `0` or _not present_.
     */
    public /*out*/ readonly expirePasswords!: pulumi.Output<boolean>;
    /**
     * Whether users are prevented from setting a new password after their password has expired (i.e., require administrator reset)
     */
    public readonly hardExpiry!: pulumi.Output<boolean>;
    /**
     * The number of days that an user password is valid.
     */
    public readonly maxPasswordAge!: pulumi.Output<number>;
    /**
     * Minimum length to require for user passwords.
     */
    public readonly minimumPasswordLength!: pulumi.Output<number | undefined>;
    /**
     * The number of previous passwords that users are prevented from reusing.
     */
    public readonly passwordReusePrevention!: pulumi.Output<number>;
    /**
     * Whether to require lowercase characters for user passwords.
     */
    public readonly requireLowercaseCharacters!: pulumi.Output<boolean>;
    /**
     * Whether to require numbers for user passwords.
     */
    public readonly requireNumbers!: pulumi.Output<boolean>;
    /**
     * Whether to require symbols for user passwords.
     */
    public readonly requireSymbols!: pulumi.Output<boolean>;
    /**
     * Whether to require uppercase characters for user passwords.
     */
    public readonly requireUppercaseCharacters!: pulumi.Output<boolean>;

    /**
     * Create a AccountPasswordPolicy resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: AccountPasswordPolicyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AccountPasswordPolicyArgs | AccountPasswordPolicyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AccountPasswordPolicyState | undefined;
            resourceInputs["allowUsersToChangePassword"] = state ? state.allowUsersToChangePassword : undefined;
            resourceInputs["expirePasswords"] = state ? state.expirePasswords : undefined;
            resourceInputs["hardExpiry"] = state ? state.hardExpiry : undefined;
            resourceInputs["maxPasswordAge"] = state ? state.maxPasswordAge : undefined;
            resourceInputs["minimumPasswordLength"] = state ? state.minimumPasswordLength : undefined;
            resourceInputs["passwordReusePrevention"] = state ? state.passwordReusePrevention : undefined;
            resourceInputs["requireLowercaseCharacters"] = state ? state.requireLowercaseCharacters : undefined;
            resourceInputs["requireNumbers"] = state ? state.requireNumbers : undefined;
            resourceInputs["requireSymbols"] = state ? state.requireSymbols : undefined;
            resourceInputs["requireUppercaseCharacters"] = state ? state.requireUppercaseCharacters : undefined;
        } else {
            const args = argsOrState as AccountPasswordPolicyArgs | undefined;
            resourceInputs["allowUsersToChangePassword"] = args ? args.allowUsersToChangePassword : undefined;
            resourceInputs["hardExpiry"] = args ? args.hardExpiry : undefined;
            resourceInputs["maxPasswordAge"] = args ? args.maxPasswordAge : undefined;
            resourceInputs["minimumPasswordLength"] = args ? args.minimumPasswordLength : undefined;
            resourceInputs["passwordReusePrevention"] = args ? args.passwordReusePrevention : undefined;
            resourceInputs["requireLowercaseCharacters"] = args ? args.requireLowercaseCharacters : undefined;
            resourceInputs["requireNumbers"] = args ? args.requireNumbers : undefined;
            resourceInputs["requireSymbols"] = args ? args.requireSymbols : undefined;
            resourceInputs["requireUppercaseCharacters"] = args ? args.requireUppercaseCharacters : undefined;
            resourceInputs["expirePasswords"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(AccountPasswordPolicy.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering AccountPasswordPolicy resources.
 */
export interface AccountPasswordPolicyState {
    /**
     * Whether to allow users to change their own password
     */
    allowUsersToChangePassword?: pulumi.Input<boolean>;
    /**
     * Indicates whether passwords in the account expire. Returns `true` if `maxPasswordAge` contains a value greater than `0`. Returns `false` if it is `0` or _not present_.
     */
    expirePasswords?: pulumi.Input<boolean>;
    /**
     * Whether users are prevented from setting a new password after their password has expired (i.e., require administrator reset)
     */
    hardExpiry?: pulumi.Input<boolean>;
    /**
     * The number of days that an user password is valid.
     */
    maxPasswordAge?: pulumi.Input<number>;
    /**
     * Minimum length to require for user passwords.
     */
    minimumPasswordLength?: pulumi.Input<number>;
    /**
     * The number of previous passwords that users are prevented from reusing.
     */
    passwordReusePrevention?: pulumi.Input<number>;
    /**
     * Whether to require lowercase characters for user passwords.
     */
    requireLowercaseCharacters?: pulumi.Input<boolean>;
    /**
     * Whether to require numbers for user passwords.
     */
    requireNumbers?: pulumi.Input<boolean>;
    /**
     * Whether to require symbols for user passwords.
     */
    requireSymbols?: pulumi.Input<boolean>;
    /**
     * Whether to require uppercase characters for user passwords.
     */
    requireUppercaseCharacters?: pulumi.Input<boolean>;
}

/**
 * The set of arguments for constructing a AccountPasswordPolicy resource.
 */
export interface AccountPasswordPolicyArgs {
    /**
     * Whether to allow users to change their own password
     */
    allowUsersToChangePassword?: pulumi.Input<boolean>;
    /**
     * Whether users are prevented from setting a new password after their password has expired (i.e., require administrator reset)
     */
    hardExpiry?: pulumi.Input<boolean>;
    /**
     * The number of days that an user password is valid.
     */
    maxPasswordAge?: pulumi.Input<number>;
    /**
     * Minimum length to require for user passwords.
     */
    minimumPasswordLength?: pulumi.Input<number>;
    /**
     * The number of previous passwords that users are prevented from reusing.
     */
    passwordReusePrevention?: pulumi.Input<number>;
    /**
     * Whether to require lowercase characters for user passwords.
     */
    requireLowercaseCharacters?: pulumi.Input<boolean>;
    /**
     * Whether to require numbers for user passwords.
     */
    requireNumbers?: pulumi.Input<boolean>;
    /**
     * Whether to require symbols for user passwords.
     */
    requireSymbols?: pulumi.Input<boolean>;
    /**
     * Whether to require uppercase characters for user passwords.
     */
    requireUppercaseCharacters?: pulumi.Input<boolean>;
}
