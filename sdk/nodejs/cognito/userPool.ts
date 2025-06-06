// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Provides a Cognito User Pool resource.
 *
 * ## Example Usage
 *
 * ### Basic configuration
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const pool = new aws.cognito.UserPool("pool", {name: "mypool"});
 * ```
 *
 * ### Enabling SMS and Software Token Multi-Factor Authentication
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = new aws.cognito.UserPool("example", {
 *     mfaConfiguration: "ON",
 *     smsAuthenticationMessage: "Your code is {####}",
 *     smsConfiguration: {
 *         externalId: "example",
 *         snsCallerArn: exampleAwsIamRole.arn,
 *         snsRegion: "us-east-1",
 *     },
 *     softwareTokenMfaConfiguration: {
 *         enabled: true,
 *     },
 * });
 * ```
 *
 * ### Using Account Recovery Setting
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.cognito.UserPool("test", {
 *     name: "mypool",
 *     accountRecoverySetting: {
 *         recoveryMechanisms: [
 *             {
 *                 name: "verified_email",
 *                 priority: 1,
 *             },
 *             {
 *                 name: "verified_phone_number",
 *                 priority: 2,
 *             },
 *         ],
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import Cognito User Pools using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:cognito/userPool:UserPool pool us-west-2_abc123
 * ```
 */
export class UserPool extends pulumi.CustomResource {
    /**
     * Get an existing UserPool resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: UserPoolState, opts?: pulumi.CustomResourceOptions): UserPool {
        return new UserPool(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:cognito/userPool:UserPool';

    /**
     * Returns true if the given object is an instance of UserPool.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is UserPool {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === UserPool.__pulumiType;
    }

    /**
     * Configuration block to define which verified available method a user can use to recover their forgotten password. Detailed below.
     */
    public readonly accountRecoverySetting!: pulumi.Output<outputs.cognito.UserPoolAccountRecoverySetting | undefined>;
    /**
     * Configuration block for creating a new user profile. Detailed below.
     */
    public readonly adminCreateUserConfig!: pulumi.Output<outputs.cognito.UserPoolAdminCreateUserConfig>;
    /**
     * Attributes supported as an alias for this user pool. Valid values: `phoneNumber`, `email`, or `preferredUsername`. Conflicts with `usernameAttributes`.
     */
    public readonly aliasAttributes!: pulumi.Output<string[] | undefined>;
    /**
     * ARN of the user pool.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * Attributes to be auto-verified. Valid values: `email`, `phoneNumber`.
     */
    public readonly autoVerifiedAttributes!: pulumi.Output<string[] | undefined>;
    /**
     * Date the user pool was created.
     */
    public /*out*/ readonly creationDate!: pulumi.Output<string>;
    /**
     * A custom domain name that you provide to Amazon Cognito. This parameter applies only if you use a custom domain to host the sign-up and sign-in pages for your application. For example: `auth.example.com`.
     */
    public /*out*/ readonly customDomain!: pulumi.Output<string>;
    /**
     * When active, DeletionProtection prevents accidental deletion of your user pool. Before you can delete a user pool that you have protected against deletion, you must deactivate this feature. Valid values are `ACTIVE` and `INACTIVE`, Default value is `INACTIVE`.
     */
    public readonly deletionProtection!: pulumi.Output<string | undefined>;
    /**
     * Configuration block for the user pool's device tracking. Detailed below.
     */
    public readonly deviceConfiguration!: pulumi.Output<outputs.cognito.UserPoolDeviceConfiguration | undefined>;
    /**
     * Holds the domain prefix if the user pool has a domain associated with it.
     */
    public /*out*/ readonly domain!: pulumi.Output<string>;
    /**
     * Configuration block for configuring email. Detailed below.
     */
    public readonly emailConfiguration!: pulumi.Output<outputs.cognito.UserPoolEmailConfiguration | undefined>;
    /**
     * Configuration block for configuring email Multi-Factor Authentication (MFA); requires at least 2 `accountRecoverySetting` entries; requires an `emailConfiguration` configuration block. Detailed below.
     */
    public readonly emailMfaConfiguration!: pulumi.Output<outputs.cognito.UserPoolEmailMfaConfiguration | undefined>;
    /**
     * String representing the email verification message. Conflicts with `verificationMessageTemplate` configuration block `emailMessage` argument.
     */
    public readonly emailVerificationMessage!: pulumi.Output<string>;
    /**
     * String representing the email verification subject. Conflicts with `verificationMessageTemplate` configuration block `emailSubject` argument.
     */
    public readonly emailVerificationSubject!: pulumi.Output<string>;
    /**
     * Endpoint name of the user pool. Example format: `cognito-idp.REGION.amazonaws.com/xxxx_yyyyy`
     */
    public /*out*/ readonly endpoint!: pulumi.Output<string>;
    /**
     * A number estimating the size of the user pool.
     */
    public /*out*/ readonly estimatedNumberOfUsers!: pulumi.Output<number>;
    /**
     * Configuration block for the AWS Lambda triggers associated with the user pool. Detailed below.
     */
    public readonly lambdaConfig!: pulumi.Output<outputs.cognito.UserPoolLambdaConfig | undefined>;
    /**
     * Date the user pool was last modified.
     */
    public /*out*/ readonly lastModifiedDate!: pulumi.Output<string>;
    /**
     * Multi-Factor Authentication (MFA) configuration for the User Pool. Defaults of `OFF`. Valid values are `OFF` (MFA Tokens are not required), `ON` (MFA is required for all users to sign in; requires at least one of `smsConfiguration` or `softwareTokenMfaConfiguration` to be configured), or `OPTIONAL` (MFA Will be required only for individual users who have MFA Enabled; requires at least one of `smsConfiguration` or `softwareTokenMfaConfiguration` to be configured).
     */
    public readonly mfaConfiguration!: pulumi.Output<string | undefined>;
    /**
     * Name of the user pool.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Configuration block for information about the user pool password policy. Detailed below.
     */
    public readonly passwordPolicy!: pulumi.Output<outputs.cognito.UserPoolPasswordPolicy>;
    /**
     * Configuration block for the schema attributes of a user pool. Detailed below. Schema attributes from the [standard attribute set](https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-settings-attributes.html#cognito-user-pools-standard-attributes) only need to be specified if they are different from the default configuration. Attributes can be added, but not modified or removed. Maximum of 50 attributes.
     */
    public readonly schemas!: pulumi.Output<outputs.cognito.UserPoolSchema[] | undefined>;
    /**
     * Configuration block for information about the user pool sign in policy. Detailed below.
     */
    public readonly signInPolicy!: pulumi.Output<outputs.cognito.UserPoolSignInPolicy>;
    /**
     * String representing the SMS authentication message. The Message must contain the `{####}` placeholder, which will be replaced with the code.
     */
    public readonly smsAuthenticationMessage!: pulumi.Output<string | undefined>;
    /**
     * Configuration block for Short Message Service (SMS) settings. Detailed below. These settings apply to SMS user verification and SMS Multi-Factor Authentication (MFA). Due to Cognito API restrictions, the SMS configuration cannot be removed without recreating the Cognito User Pool. For user data safety, this resource will ignore the removal of this configuration by disabling drift detection. To force resource recreation after this configuration has been applied, see the `taint` command.
     */
    public readonly smsConfiguration!: pulumi.Output<outputs.cognito.UserPoolSmsConfiguration>;
    /**
     * String representing the SMS verification message. Conflicts with `verificationMessageTemplate` configuration block `smsMessage` argument.
     */
    public readonly smsVerificationMessage!: pulumi.Output<string>;
    /**
     * Configuration block for software token Mult-Factor Authentication (MFA) settings. Detailed below.
     */
    public readonly softwareTokenMfaConfiguration!: pulumi.Output<outputs.cognito.UserPoolSoftwareTokenMfaConfiguration | undefined>;
    /**
     * Map of tags to assign to the User Pool. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Configuration block for user attribute update settings. Detailed below.
     */
    public readonly userAttributeUpdateSettings!: pulumi.Output<outputs.cognito.UserPoolUserAttributeUpdateSettings | undefined>;
    /**
     * Configuration block for user pool add-ons to enable user pool advanced security mode features. Detailed below.
     */
    public readonly userPoolAddOns!: pulumi.Output<outputs.cognito.UserPoolUserPoolAddOns | undefined>;
    /**
     * The user pool [feature plan](https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-sign-in-feature-plans.html), or tier. Valid values: `LITE`, `ESSENTIALS`, `PLUS`.
     */
    public readonly userPoolTier!: pulumi.Output<string>;
    /**
     * Whether email addresses or phone numbers can be specified as usernames when a user signs up. Conflicts with `aliasAttributes`.
     */
    public readonly usernameAttributes!: pulumi.Output<string[] | undefined>;
    /**
     * Configuration block for username configuration. Detailed below.
     */
    public readonly usernameConfiguration!: pulumi.Output<outputs.cognito.UserPoolUsernameConfiguration>;
    /**
     * Configuration block for verification message templates. Detailed below.
     */
    public readonly verificationMessageTemplate!: pulumi.Output<outputs.cognito.UserPoolVerificationMessageTemplate>;
    /**
     * Configuration block for web authn configuration. Detailed below.
     */
    public readonly webAuthnConfiguration!: pulumi.Output<outputs.cognito.UserPoolWebAuthnConfiguration | undefined>;

    /**
     * Create a UserPool resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: UserPoolArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: UserPoolArgs | UserPoolState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as UserPoolState | undefined;
            resourceInputs["accountRecoverySetting"] = state ? state.accountRecoverySetting : undefined;
            resourceInputs["adminCreateUserConfig"] = state ? state.adminCreateUserConfig : undefined;
            resourceInputs["aliasAttributes"] = state ? state.aliasAttributes : undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["autoVerifiedAttributes"] = state ? state.autoVerifiedAttributes : undefined;
            resourceInputs["creationDate"] = state ? state.creationDate : undefined;
            resourceInputs["customDomain"] = state ? state.customDomain : undefined;
            resourceInputs["deletionProtection"] = state ? state.deletionProtection : undefined;
            resourceInputs["deviceConfiguration"] = state ? state.deviceConfiguration : undefined;
            resourceInputs["domain"] = state ? state.domain : undefined;
            resourceInputs["emailConfiguration"] = state ? state.emailConfiguration : undefined;
            resourceInputs["emailMfaConfiguration"] = state ? state.emailMfaConfiguration : undefined;
            resourceInputs["emailVerificationMessage"] = state ? state.emailVerificationMessage : undefined;
            resourceInputs["emailVerificationSubject"] = state ? state.emailVerificationSubject : undefined;
            resourceInputs["endpoint"] = state ? state.endpoint : undefined;
            resourceInputs["estimatedNumberOfUsers"] = state ? state.estimatedNumberOfUsers : undefined;
            resourceInputs["lambdaConfig"] = state ? state.lambdaConfig : undefined;
            resourceInputs["lastModifiedDate"] = state ? state.lastModifiedDate : undefined;
            resourceInputs["mfaConfiguration"] = state ? state.mfaConfiguration : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["passwordPolicy"] = state ? state.passwordPolicy : undefined;
            resourceInputs["schemas"] = state ? state.schemas : undefined;
            resourceInputs["signInPolicy"] = state ? state.signInPolicy : undefined;
            resourceInputs["smsAuthenticationMessage"] = state ? state.smsAuthenticationMessage : undefined;
            resourceInputs["smsConfiguration"] = state ? state.smsConfiguration : undefined;
            resourceInputs["smsVerificationMessage"] = state ? state.smsVerificationMessage : undefined;
            resourceInputs["softwareTokenMfaConfiguration"] = state ? state.softwareTokenMfaConfiguration : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["userAttributeUpdateSettings"] = state ? state.userAttributeUpdateSettings : undefined;
            resourceInputs["userPoolAddOns"] = state ? state.userPoolAddOns : undefined;
            resourceInputs["userPoolTier"] = state ? state.userPoolTier : undefined;
            resourceInputs["usernameAttributes"] = state ? state.usernameAttributes : undefined;
            resourceInputs["usernameConfiguration"] = state ? state.usernameConfiguration : undefined;
            resourceInputs["verificationMessageTemplate"] = state ? state.verificationMessageTemplate : undefined;
            resourceInputs["webAuthnConfiguration"] = state ? state.webAuthnConfiguration : undefined;
        } else {
            const args = argsOrState as UserPoolArgs | undefined;
            resourceInputs["accountRecoverySetting"] = args ? args.accountRecoverySetting : undefined;
            resourceInputs["adminCreateUserConfig"] = args ? args.adminCreateUserConfig : undefined;
            resourceInputs["aliasAttributes"] = args ? args.aliasAttributes : undefined;
            resourceInputs["autoVerifiedAttributes"] = args ? args.autoVerifiedAttributes : undefined;
            resourceInputs["deletionProtection"] = args ? args.deletionProtection : undefined;
            resourceInputs["deviceConfiguration"] = args ? args.deviceConfiguration : undefined;
            resourceInputs["emailConfiguration"] = args ? args.emailConfiguration : undefined;
            resourceInputs["emailMfaConfiguration"] = args ? args.emailMfaConfiguration : undefined;
            resourceInputs["emailVerificationMessage"] = args ? args.emailVerificationMessage : undefined;
            resourceInputs["emailVerificationSubject"] = args ? args.emailVerificationSubject : undefined;
            resourceInputs["lambdaConfig"] = args ? args.lambdaConfig : undefined;
            resourceInputs["mfaConfiguration"] = args ? args.mfaConfiguration : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["passwordPolicy"] = args ? args.passwordPolicy : undefined;
            resourceInputs["schemas"] = args ? args.schemas : undefined;
            resourceInputs["signInPolicy"] = args ? args.signInPolicy : undefined;
            resourceInputs["smsAuthenticationMessage"] = args ? args.smsAuthenticationMessage : undefined;
            resourceInputs["smsConfiguration"] = args ? args.smsConfiguration : undefined;
            resourceInputs["smsVerificationMessage"] = args ? args.smsVerificationMessage : undefined;
            resourceInputs["softwareTokenMfaConfiguration"] = args ? args.softwareTokenMfaConfiguration : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["userAttributeUpdateSettings"] = args ? args.userAttributeUpdateSettings : undefined;
            resourceInputs["userPoolAddOns"] = args ? args.userPoolAddOns : undefined;
            resourceInputs["userPoolTier"] = args ? args.userPoolTier : undefined;
            resourceInputs["usernameAttributes"] = args ? args.usernameAttributes : undefined;
            resourceInputs["usernameConfiguration"] = args ? args.usernameConfiguration : undefined;
            resourceInputs["verificationMessageTemplate"] = args ? args.verificationMessageTemplate : undefined;
            resourceInputs["webAuthnConfiguration"] = args ? args.webAuthnConfiguration : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["creationDate"] = undefined /*out*/;
            resourceInputs["customDomain"] = undefined /*out*/;
            resourceInputs["domain"] = undefined /*out*/;
            resourceInputs["endpoint"] = undefined /*out*/;
            resourceInputs["estimatedNumberOfUsers"] = undefined /*out*/;
            resourceInputs["lastModifiedDate"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(UserPool.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering UserPool resources.
 */
export interface UserPoolState {
    /**
     * Configuration block to define which verified available method a user can use to recover their forgotten password. Detailed below.
     */
    accountRecoverySetting?: pulumi.Input<inputs.cognito.UserPoolAccountRecoverySetting>;
    /**
     * Configuration block for creating a new user profile. Detailed below.
     */
    adminCreateUserConfig?: pulumi.Input<inputs.cognito.UserPoolAdminCreateUserConfig>;
    /**
     * Attributes supported as an alias for this user pool. Valid values: `phoneNumber`, `email`, or `preferredUsername`. Conflicts with `usernameAttributes`.
     */
    aliasAttributes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * ARN of the user pool.
     */
    arn?: pulumi.Input<string>;
    /**
     * Attributes to be auto-verified. Valid values: `email`, `phoneNumber`.
     */
    autoVerifiedAttributes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Date the user pool was created.
     */
    creationDate?: pulumi.Input<string>;
    /**
     * A custom domain name that you provide to Amazon Cognito. This parameter applies only if you use a custom domain to host the sign-up and sign-in pages for your application. For example: `auth.example.com`.
     */
    customDomain?: pulumi.Input<string>;
    /**
     * When active, DeletionProtection prevents accidental deletion of your user pool. Before you can delete a user pool that you have protected against deletion, you must deactivate this feature. Valid values are `ACTIVE` and `INACTIVE`, Default value is `INACTIVE`.
     */
    deletionProtection?: pulumi.Input<string>;
    /**
     * Configuration block for the user pool's device tracking. Detailed below.
     */
    deviceConfiguration?: pulumi.Input<inputs.cognito.UserPoolDeviceConfiguration>;
    /**
     * Holds the domain prefix if the user pool has a domain associated with it.
     */
    domain?: pulumi.Input<string>;
    /**
     * Configuration block for configuring email. Detailed below.
     */
    emailConfiguration?: pulumi.Input<inputs.cognito.UserPoolEmailConfiguration>;
    /**
     * Configuration block for configuring email Multi-Factor Authentication (MFA); requires at least 2 `accountRecoverySetting` entries; requires an `emailConfiguration` configuration block. Detailed below.
     */
    emailMfaConfiguration?: pulumi.Input<inputs.cognito.UserPoolEmailMfaConfiguration>;
    /**
     * String representing the email verification message. Conflicts with `verificationMessageTemplate` configuration block `emailMessage` argument.
     */
    emailVerificationMessage?: pulumi.Input<string>;
    /**
     * String representing the email verification subject. Conflicts with `verificationMessageTemplate` configuration block `emailSubject` argument.
     */
    emailVerificationSubject?: pulumi.Input<string>;
    /**
     * Endpoint name of the user pool. Example format: `cognito-idp.REGION.amazonaws.com/xxxx_yyyyy`
     */
    endpoint?: pulumi.Input<string>;
    /**
     * A number estimating the size of the user pool.
     */
    estimatedNumberOfUsers?: pulumi.Input<number>;
    /**
     * Configuration block for the AWS Lambda triggers associated with the user pool. Detailed below.
     */
    lambdaConfig?: pulumi.Input<inputs.cognito.UserPoolLambdaConfig>;
    /**
     * Date the user pool was last modified.
     */
    lastModifiedDate?: pulumi.Input<string>;
    /**
     * Multi-Factor Authentication (MFA) configuration for the User Pool. Defaults of `OFF`. Valid values are `OFF` (MFA Tokens are not required), `ON` (MFA is required for all users to sign in; requires at least one of `smsConfiguration` or `softwareTokenMfaConfiguration` to be configured), or `OPTIONAL` (MFA Will be required only for individual users who have MFA Enabled; requires at least one of `smsConfiguration` or `softwareTokenMfaConfiguration` to be configured).
     */
    mfaConfiguration?: pulumi.Input<string>;
    /**
     * Name of the user pool.
     */
    name?: pulumi.Input<string>;
    /**
     * Configuration block for information about the user pool password policy. Detailed below.
     */
    passwordPolicy?: pulumi.Input<inputs.cognito.UserPoolPasswordPolicy>;
    /**
     * Configuration block for the schema attributes of a user pool. Detailed below. Schema attributes from the [standard attribute set](https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-settings-attributes.html#cognito-user-pools-standard-attributes) only need to be specified if they are different from the default configuration. Attributes can be added, but not modified or removed. Maximum of 50 attributes.
     */
    schemas?: pulumi.Input<pulumi.Input<inputs.cognito.UserPoolSchema>[]>;
    /**
     * Configuration block for information about the user pool sign in policy. Detailed below.
     */
    signInPolicy?: pulumi.Input<inputs.cognito.UserPoolSignInPolicy>;
    /**
     * String representing the SMS authentication message. The Message must contain the `{####}` placeholder, which will be replaced with the code.
     */
    smsAuthenticationMessage?: pulumi.Input<string>;
    /**
     * Configuration block for Short Message Service (SMS) settings. Detailed below. These settings apply to SMS user verification and SMS Multi-Factor Authentication (MFA). Due to Cognito API restrictions, the SMS configuration cannot be removed without recreating the Cognito User Pool. For user data safety, this resource will ignore the removal of this configuration by disabling drift detection. To force resource recreation after this configuration has been applied, see the `taint` command.
     */
    smsConfiguration?: pulumi.Input<inputs.cognito.UserPoolSmsConfiguration>;
    /**
     * String representing the SMS verification message. Conflicts with `verificationMessageTemplate` configuration block `smsMessage` argument.
     */
    smsVerificationMessage?: pulumi.Input<string>;
    /**
     * Configuration block for software token Mult-Factor Authentication (MFA) settings. Detailed below.
     */
    softwareTokenMfaConfiguration?: pulumi.Input<inputs.cognito.UserPoolSoftwareTokenMfaConfiguration>;
    /**
     * Map of tags to assign to the User Pool. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block for user attribute update settings. Detailed below.
     */
    userAttributeUpdateSettings?: pulumi.Input<inputs.cognito.UserPoolUserAttributeUpdateSettings>;
    /**
     * Configuration block for user pool add-ons to enable user pool advanced security mode features. Detailed below.
     */
    userPoolAddOns?: pulumi.Input<inputs.cognito.UserPoolUserPoolAddOns>;
    /**
     * The user pool [feature plan](https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-sign-in-feature-plans.html), or tier. Valid values: `LITE`, `ESSENTIALS`, `PLUS`.
     */
    userPoolTier?: pulumi.Input<string>;
    /**
     * Whether email addresses or phone numbers can be specified as usernames when a user signs up. Conflicts with `aliasAttributes`.
     */
    usernameAttributes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Configuration block for username configuration. Detailed below.
     */
    usernameConfiguration?: pulumi.Input<inputs.cognito.UserPoolUsernameConfiguration>;
    /**
     * Configuration block for verification message templates. Detailed below.
     */
    verificationMessageTemplate?: pulumi.Input<inputs.cognito.UserPoolVerificationMessageTemplate>;
    /**
     * Configuration block for web authn configuration. Detailed below.
     */
    webAuthnConfiguration?: pulumi.Input<inputs.cognito.UserPoolWebAuthnConfiguration>;
}

/**
 * The set of arguments for constructing a UserPool resource.
 */
export interface UserPoolArgs {
    /**
     * Configuration block to define which verified available method a user can use to recover their forgotten password. Detailed below.
     */
    accountRecoverySetting?: pulumi.Input<inputs.cognito.UserPoolAccountRecoverySetting>;
    /**
     * Configuration block for creating a new user profile. Detailed below.
     */
    adminCreateUserConfig?: pulumi.Input<inputs.cognito.UserPoolAdminCreateUserConfig>;
    /**
     * Attributes supported as an alias for this user pool. Valid values: `phoneNumber`, `email`, or `preferredUsername`. Conflicts with `usernameAttributes`.
     */
    aliasAttributes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Attributes to be auto-verified. Valid values: `email`, `phoneNumber`.
     */
    autoVerifiedAttributes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * When active, DeletionProtection prevents accidental deletion of your user pool. Before you can delete a user pool that you have protected against deletion, you must deactivate this feature. Valid values are `ACTIVE` and `INACTIVE`, Default value is `INACTIVE`.
     */
    deletionProtection?: pulumi.Input<string>;
    /**
     * Configuration block for the user pool's device tracking. Detailed below.
     */
    deviceConfiguration?: pulumi.Input<inputs.cognito.UserPoolDeviceConfiguration>;
    /**
     * Configuration block for configuring email. Detailed below.
     */
    emailConfiguration?: pulumi.Input<inputs.cognito.UserPoolEmailConfiguration>;
    /**
     * Configuration block for configuring email Multi-Factor Authentication (MFA); requires at least 2 `accountRecoverySetting` entries; requires an `emailConfiguration` configuration block. Detailed below.
     */
    emailMfaConfiguration?: pulumi.Input<inputs.cognito.UserPoolEmailMfaConfiguration>;
    /**
     * String representing the email verification message. Conflicts with `verificationMessageTemplate` configuration block `emailMessage` argument.
     */
    emailVerificationMessage?: pulumi.Input<string>;
    /**
     * String representing the email verification subject. Conflicts with `verificationMessageTemplate` configuration block `emailSubject` argument.
     */
    emailVerificationSubject?: pulumi.Input<string>;
    /**
     * Configuration block for the AWS Lambda triggers associated with the user pool. Detailed below.
     */
    lambdaConfig?: pulumi.Input<inputs.cognito.UserPoolLambdaConfig>;
    /**
     * Multi-Factor Authentication (MFA) configuration for the User Pool. Defaults of `OFF`. Valid values are `OFF` (MFA Tokens are not required), `ON` (MFA is required for all users to sign in; requires at least one of `smsConfiguration` or `softwareTokenMfaConfiguration` to be configured), or `OPTIONAL` (MFA Will be required only for individual users who have MFA Enabled; requires at least one of `smsConfiguration` or `softwareTokenMfaConfiguration` to be configured).
     */
    mfaConfiguration?: pulumi.Input<string>;
    /**
     * Name of the user pool.
     */
    name?: pulumi.Input<string>;
    /**
     * Configuration block for information about the user pool password policy. Detailed below.
     */
    passwordPolicy?: pulumi.Input<inputs.cognito.UserPoolPasswordPolicy>;
    /**
     * Configuration block for the schema attributes of a user pool. Detailed below. Schema attributes from the [standard attribute set](https://docs.aws.amazon.com/cognito/latest/developerguide/user-pool-settings-attributes.html#cognito-user-pools-standard-attributes) only need to be specified if they are different from the default configuration. Attributes can be added, but not modified or removed. Maximum of 50 attributes.
     */
    schemas?: pulumi.Input<pulumi.Input<inputs.cognito.UserPoolSchema>[]>;
    /**
     * Configuration block for information about the user pool sign in policy. Detailed below.
     */
    signInPolicy?: pulumi.Input<inputs.cognito.UserPoolSignInPolicy>;
    /**
     * String representing the SMS authentication message. The Message must contain the `{####}` placeholder, which will be replaced with the code.
     */
    smsAuthenticationMessage?: pulumi.Input<string>;
    /**
     * Configuration block for Short Message Service (SMS) settings. Detailed below. These settings apply to SMS user verification and SMS Multi-Factor Authentication (MFA). Due to Cognito API restrictions, the SMS configuration cannot be removed without recreating the Cognito User Pool. For user data safety, this resource will ignore the removal of this configuration by disabling drift detection. To force resource recreation after this configuration has been applied, see the `taint` command.
     */
    smsConfiguration?: pulumi.Input<inputs.cognito.UserPoolSmsConfiguration>;
    /**
     * String representing the SMS verification message. Conflicts with `verificationMessageTemplate` configuration block `smsMessage` argument.
     */
    smsVerificationMessage?: pulumi.Input<string>;
    /**
     * Configuration block for software token Mult-Factor Authentication (MFA) settings. Detailed below.
     */
    softwareTokenMfaConfiguration?: pulumi.Input<inputs.cognito.UserPoolSoftwareTokenMfaConfiguration>;
    /**
     * Map of tags to assign to the User Pool. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Configuration block for user attribute update settings. Detailed below.
     */
    userAttributeUpdateSettings?: pulumi.Input<inputs.cognito.UserPoolUserAttributeUpdateSettings>;
    /**
     * Configuration block for user pool add-ons to enable user pool advanced security mode features. Detailed below.
     */
    userPoolAddOns?: pulumi.Input<inputs.cognito.UserPoolUserPoolAddOns>;
    /**
     * The user pool [feature plan](https://docs.aws.amazon.com/cognito/latest/developerguide/cognito-sign-in-feature-plans.html), or tier. Valid values: `LITE`, `ESSENTIALS`, `PLUS`.
     */
    userPoolTier?: pulumi.Input<string>;
    /**
     * Whether email addresses or phone numbers can be specified as usernames when a user signs up. Conflicts with `aliasAttributes`.
     */
    usernameAttributes?: pulumi.Input<pulumi.Input<string>[]>;
    /**
     * Configuration block for username configuration. Detailed below.
     */
    usernameConfiguration?: pulumi.Input<inputs.cognito.UserPoolUsernameConfiguration>;
    /**
     * Configuration block for verification message templates. Detailed below.
     */
    verificationMessageTemplate?: pulumi.Input<inputs.cognito.UserPoolVerificationMessageTemplate>;
    /**
     * Configuration block for web authn configuration. Detailed below.
     */
    webAuthnConfiguration?: pulumi.Input<inputs.cognito.UserPoolWebAuthnConfiguration>;
}
