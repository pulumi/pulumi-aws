// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Manages a single-Region or multi-Region primary KMS key.
 *
 * > **NOTE on KMS Key Policy:** KMS Key Policy can be configured in either the standalone resource `aws.kms.KeyPolicy`
 * or with the parameter `policy` in this resource.
 * Configuring with both will cause inconsistencies and may overwrite configuration.
 *
 * ## Example Usage
 *
 * ### Symmetric Encryption KMS Key
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const example = new aws.kms.Key("example", {
 *     description: "An example symmetric encryption KMS key",
 *     enableKeyRotation: true,
 *     deletionWindowInDays: 20,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Id: "key-default-1",
 *         Statement: [
 *             {
 *                 Sid: "Enable IAM User Permissions",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:root`),
 *                 },
 *                 Action: "kms:*",
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow administration of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:user/Alice`),
 *                 },
 *                 Action: [
 *                     "kms:ReplicateKey",
 *                     "kms:Create*",
 *                     "kms:Describe*",
 *                     "kms:Enable*",
 *                     "kms:List*",
 *                     "kms:Put*",
 *                     "kms:Update*",
 *                     "kms:Revoke*",
 *                     "kms:Disable*",
 *                     "kms:Get*",
 *                     "kms:Delete*",
 *                     "kms:ScheduleKeyDeletion",
 *                     "kms:CancelKeyDeletion",
 *                 ],
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow use of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:user/Bob`),
 *                 },
 *                 Action: [
 *                     "kms:DescribeKey",
 *                     "kms:Encrypt",
 *                     "kms:Decrypt",
 *                     "kms:ReEncrypt*",
 *                     "kms:GenerateDataKey",
 *                     "kms:GenerateDataKeyWithoutPlaintext",
 *                 ],
 *                 Resource: "*",
 *             },
 *         ],
 *     }),
 * });
 * ```
 *
 * ### Symmetric Encryption KMS Key With Standalone Policy Resource
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const example = new aws.kms.Key("example", {
 *     description: "An example symmetric encryption KMS key",
 *     enableKeyRotation: true,
 *     deletionWindowInDays: 20,
 * });
 * const exampleKeyPolicy = new aws.kms.KeyPolicy("example", {
 *     keyId: example.id,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Id: "key-default-1",
 *         Statement: [{
 *             Sid: "Enable IAM User Permissions",
 *             Effect: "Allow",
 *             Principal: {
 *                 AWS: current.then(current => `arn:aws:iam::${current.accountId}:root`),
 *             },
 *             Action: "kms:*",
 *             Resource: "*",
 *         }],
 *     }),
 * });
 * ```
 *
 * ### Asymmetric KMS Key
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const example = new aws.kms.Key("example", {
 *     description: "RSA-3072 asymmetric KMS key for signing and verification",
 *     customerMasterKeySpec: "RSA_3072",
 *     keyUsage: "SIGN_VERIFY",
 *     enableKeyRotation: false,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Id: "key-default-1",
 *         Statement: [
 *             {
 *                 Sid: "Enable IAM User Permissions",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:root`),
 *                 },
 *                 Action: "kms:*",
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow administration of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:role/Admin`),
 *                 },
 *                 Action: [
 *                     "kms:Create*",
 *                     "kms:Describe*",
 *                     "kms:Enable*",
 *                     "kms:List*",
 *                     "kms:Put*",
 *                     "kms:Update*",
 *                     "kms:Revoke*",
 *                     "kms:Disable*",
 *                     "kms:Get*",
 *                     "kms:Delete*",
 *                     "kms:ScheduleKeyDeletion",
 *                     "kms:CancelKeyDeletion",
 *                 ],
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow use of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:role/Developer`),
 *                 },
 *                 Action: [
 *                     "kms:Sign",
 *                     "kms:Verify",
 *                     "kms:DescribeKey",
 *                 ],
 *                 Resource: "*",
 *             },
 *         ],
 *     }),
 * });
 * ```
 *
 * ### HMAC KMS key
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const example = new aws.kms.Key("example", {
 *     description: "HMAC_384 key for tokens",
 *     customerMasterKeySpec: "HMAC_384",
 *     keyUsage: "GENERATE_VERIFY_MAC",
 *     enableKeyRotation: false,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Id: "key-default-1",
 *         Statement: [
 *             {
 *                 Sid: "Enable IAM User Permissions",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:root`),
 *                 },
 *                 Action: "kms:*",
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow administration of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:role/Admin`),
 *                 },
 *                 Action: [
 *                     "kms:Create*",
 *                     "kms:Describe*",
 *                     "kms:Enable*",
 *                     "kms:List*",
 *                     "kms:Put*",
 *                     "kms:Update*",
 *                     "kms:Revoke*",
 *                     "kms:Disable*",
 *                     "kms:Get*",
 *                     "kms:Delete*",
 *                     "kms:ScheduleKeyDeletion",
 *                     "kms:CancelKeyDeletion",
 *                 ],
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow use of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:role/Developer`),
 *                 },
 *                 Action: [
 *                     "kms:GenerateMac",
 *                     "kms:VerifyMac",
 *                     "kms:DescribeKey",
 *                 ],
 *                 Resource: "*",
 *             },
 *         ],
 *     }),
 * });
 * ```
 *
 * ### Multi-Region Primary Key
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const example = new aws.kms.Key("example", {
 *     description: "An example multi-Region primary key",
 *     multiRegion: true,
 *     enableKeyRotation: true,
 *     deletionWindowInDays: 10,
 *     policy: JSON.stringify({
 *         Version: "2012-10-17",
 *         Id: "key-default-1",
 *         Statement: [
 *             {
 *                 Sid: "Enable IAM User Permissions",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:root`),
 *                 },
 *                 Action: "kms:*",
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow administration of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:user/Alice`),
 *                 },
 *                 Action: [
 *                     "kms:ReplicateKey",
 *                     "kms:Create*",
 *                     "kms:Describe*",
 *                     "kms:Enable*",
 *                     "kms:List*",
 *                     "kms:Put*",
 *                     "kms:Update*",
 *                     "kms:Revoke*",
 *                     "kms:Disable*",
 *                     "kms:Get*",
 *                     "kms:Delete*",
 *                     "kms:ScheduleKeyDeletion",
 *                     "kms:CancelKeyDeletion",
 *                 ],
 *                 Resource: "*",
 *             },
 *             {
 *                 Sid: "Allow use of the key",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:user/Bob`),
 *                 },
 *                 Action: [
 *                     "kms:DescribeKey",
 *                     "kms:Encrypt",
 *                     "kms:Decrypt",
 *                     "kms:ReEncrypt*",
 *                     "kms:GenerateDataKey",
 *                     "kms:GenerateDataKeyWithoutPlaintext",
 *                 ],
 *                 Resource: "*",
 *             },
 *         ],
 *     }),
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import KMS Keys using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:kms/key:Key a 1234abcd-12ab-34cd-56ef-1234567890ab
 * ```
 */
export class Key extends pulumi.CustomResource {
    /**
     * Get an existing Key resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: KeyState, opts?: pulumi.CustomResourceOptions): Key {
        return new Key(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:kms/key:Key';

    /**
     * Returns true if the given object is an instance of Key.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is Key {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === Key.__pulumiType;
    }

    /**
     * The Amazon Resource Name (ARN) of the key.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A flag to indicate whether to bypass the key policy lockout safety check.
     * Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to true indiscriminately.
     * For more information, refer to the scenario in the [Default Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-root-enable-iam) section in the _AWS Key Management Service Developer Guide_.
     * The default value is `false`.
     */
    public readonly bypassPolicyLockoutSafetyCheck!: pulumi.Output<boolean | undefined>;
    /**
     * ID of the KMS [Custom Key Store](https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html) where the key will be stored instead of KMS (eg CloudHSM).
     */
    public readonly customKeyStoreId!: pulumi.Output<string | undefined>;
    /**
     * Specifies whether the key contains a symmetric key or an asymmetric key pair and the encryption algorithms or signing algorithms that the key supports.
     * Valid values: `SYMMETRIC_DEFAULT`,  `RSA_2048`, `RSA_3072`, `RSA_4096`, `HMAC_256`, `ECC_NIST_P256`, `ECC_NIST_P384`, `ECC_NIST_P521`, or `ECC_SECG_P256K1`. Defaults to `SYMMETRIC_DEFAULT`. For help with choosing a key spec, see the [AWS KMS Developer Guide](https://docs.aws.amazon.com/kms/latest/developerguide/symm-asymm-choose.html).
     */
    public readonly customerMasterKeySpec!: pulumi.Output<string | undefined>;
    /**
     * The waiting period, specified in number of days. After the waiting period ends, AWS KMS deletes the KMS key.
     * If you specify a value, it must be between `7` and `30`, inclusive. If you do not specify a value, it defaults to `30`.
     * If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of its replica keys is deleted. Otherwise, the waiting period begins immediately.
     */
    public readonly deletionWindowInDays!: pulumi.Output<number | undefined>;
    /**
     * The description of the key as viewed in AWS console.
     */
    public readonly description!: pulumi.Output<string>;
    /**
     * Specifies whether [key rotation](http://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html) is enabled. Defaults to `false`.
     */
    public readonly enableKeyRotation!: pulumi.Output<boolean | undefined>;
    /**
     * Specifies whether the key is enabled. Defaults to `true`.
     */
    public readonly isEnabled!: pulumi.Output<boolean | undefined>;
    /**
     * The globally unique identifier for the key.
     */
    public /*out*/ readonly keyId!: pulumi.Output<string>;
    /**
     * Specifies the intended use of the key. Valid values: `ENCRYPT_DECRYPT`, `SIGN_VERIFY`, or `GENERATE_VERIFY_MAC`.
     * Defaults to `ENCRYPT_DECRYPT`.
     */
    public readonly keyUsage!: pulumi.Output<string | undefined>;
    /**
     * Indicates whether the KMS key is a multi-Region (`true`) or regional (`false`) key. Defaults to `false`.
     */
    public readonly multiRegion!: pulumi.Output<boolean>;
    /**
     * A valid policy JSON document. Although this is a key policy, not an IAM policy, an `aws.iam.getPolicyDocument`, in the form that designates a principal, can be used.
     *
     * > **NOTE:** Note: All KMS keys must have a key policy. If a key policy is not specified, AWS gives the KMS key a [default key policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default) that gives all principals in the owning account unlimited access to all KMS operations for the key. This default key policy effectively delegates all access control to IAM policies and KMS grants.
     */
    public readonly policy!: pulumi.Output<string>;
    /**
     * Custom period of time between each rotation date. Must be a number between 90 and 2560 (inclusive).
     */
    public readonly rotationPeriodInDays!: pulumi.Output<number>;
    /**
     * A map of tags to assign to the object. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * Identifies the external key that serves as key material for the KMS key in an external key store.
     */
    public readonly xksKeyId!: pulumi.Output<string | undefined>;

    /**
     * Create a Key resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args?: KeyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: KeyArgs | KeyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as KeyState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["bypassPolicyLockoutSafetyCheck"] = state ? state.bypassPolicyLockoutSafetyCheck : undefined;
            resourceInputs["customKeyStoreId"] = state ? state.customKeyStoreId : undefined;
            resourceInputs["customerMasterKeySpec"] = state ? state.customerMasterKeySpec : undefined;
            resourceInputs["deletionWindowInDays"] = state ? state.deletionWindowInDays : undefined;
            resourceInputs["description"] = state ? state.description : undefined;
            resourceInputs["enableKeyRotation"] = state ? state.enableKeyRotation : undefined;
            resourceInputs["isEnabled"] = state ? state.isEnabled : undefined;
            resourceInputs["keyId"] = state ? state.keyId : undefined;
            resourceInputs["keyUsage"] = state ? state.keyUsage : undefined;
            resourceInputs["multiRegion"] = state ? state.multiRegion : undefined;
            resourceInputs["policy"] = state ? state.policy : undefined;
            resourceInputs["rotationPeriodInDays"] = state ? state.rotationPeriodInDays : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["xksKeyId"] = state ? state.xksKeyId : undefined;
        } else {
            const args = argsOrState as KeyArgs | undefined;
            resourceInputs["bypassPolicyLockoutSafetyCheck"] = args ? args.bypassPolicyLockoutSafetyCheck : undefined;
            resourceInputs["customKeyStoreId"] = args ? args.customKeyStoreId : undefined;
            resourceInputs["customerMasterKeySpec"] = args ? args.customerMasterKeySpec : undefined;
            resourceInputs["deletionWindowInDays"] = args ? args.deletionWindowInDays : undefined;
            resourceInputs["description"] = args ? args.description : undefined;
            resourceInputs["enableKeyRotation"] = args ? args.enableKeyRotation : undefined;
            resourceInputs["isEnabled"] = args ? args.isEnabled : undefined;
            resourceInputs["keyUsage"] = args ? args.keyUsage : undefined;
            resourceInputs["multiRegion"] = args ? args.multiRegion : undefined;
            resourceInputs["policy"] = args ? args.policy : undefined;
            resourceInputs["rotationPeriodInDays"] = args ? args.rotationPeriodInDays : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["xksKeyId"] = args ? args.xksKeyId : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["keyId"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(Key.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering Key resources.
 */
export interface KeyState {
    /**
     * The Amazon Resource Name (ARN) of the key.
     */
    arn?: pulumi.Input<string>;
    /**
     * A flag to indicate whether to bypass the key policy lockout safety check.
     * Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to true indiscriminately.
     * For more information, refer to the scenario in the [Default Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-root-enable-iam) section in the _AWS Key Management Service Developer Guide_.
     * The default value is `false`.
     */
    bypassPolicyLockoutSafetyCheck?: pulumi.Input<boolean>;
    /**
     * ID of the KMS [Custom Key Store](https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html) where the key will be stored instead of KMS (eg CloudHSM).
     */
    customKeyStoreId?: pulumi.Input<string>;
    /**
     * Specifies whether the key contains a symmetric key or an asymmetric key pair and the encryption algorithms or signing algorithms that the key supports.
     * Valid values: `SYMMETRIC_DEFAULT`,  `RSA_2048`, `RSA_3072`, `RSA_4096`, `HMAC_256`, `ECC_NIST_P256`, `ECC_NIST_P384`, `ECC_NIST_P521`, or `ECC_SECG_P256K1`. Defaults to `SYMMETRIC_DEFAULT`. For help with choosing a key spec, see the [AWS KMS Developer Guide](https://docs.aws.amazon.com/kms/latest/developerguide/symm-asymm-choose.html).
     */
    customerMasterKeySpec?: pulumi.Input<string>;
    /**
     * The waiting period, specified in number of days. After the waiting period ends, AWS KMS deletes the KMS key.
     * If you specify a value, it must be between `7` and `30`, inclusive. If you do not specify a value, it defaults to `30`.
     * If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of its replica keys is deleted. Otherwise, the waiting period begins immediately.
     */
    deletionWindowInDays?: pulumi.Input<number>;
    /**
     * The description of the key as viewed in AWS console.
     */
    description?: pulumi.Input<string>;
    /**
     * Specifies whether [key rotation](http://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html) is enabled. Defaults to `false`.
     */
    enableKeyRotation?: pulumi.Input<boolean>;
    /**
     * Specifies whether the key is enabled. Defaults to `true`.
     */
    isEnabled?: pulumi.Input<boolean>;
    /**
     * The globally unique identifier for the key.
     */
    keyId?: pulumi.Input<string>;
    /**
     * Specifies the intended use of the key. Valid values: `ENCRYPT_DECRYPT`, `SIGN_VERIFY`, or `GENERATE_VERIFY_MAC`.
     * Defaults to `ENCRYPT_DECRYPT`.
     */
    keyUsage?: pulumi.Input<string>;
    /**
     * Indicates whether the KMS key is a multi-Region (`true`) or regional (`false`) key. Defaults to `false`.
     */
    multiRegion?: pulumi.Input<boolean>;
    /**
     * A valid policy JSON document. Although this is a key policy, not an IAM policy, an `aws.iam.getPolicyDocument`, in the form that designates a principal, can be used.
     *
     * > **NOTE:** Note: All KMS keys must have a key policy. If a key policy is not specified, AWS gives the KMS key a [default key policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default) that gives all principals in the owning account unlimited access to all KMS operations for the key. This default key policy effectively delegates all access control to IAM policies and KMS grants.
     */
    policy?: pulumi.Input<string>;
    /**
     * Custom period of time between each rotation date. Must be a number between 90 and 2560 (inclusive).
     */
    rotationPeriodInDays?: pulumi.Input<number>;
    /**
     * A map of tags to assign to the object. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Identifies the external key that serves as key material for the KMS key in an external key store.
     */
    xksKeyId?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a Key resource.
 */
export interface KeyArgs {
    /**
     * A flag to indicate whether to bypass the key policy lockout safety check.
     * Setting this value to true increases the risk that the KMS key becomes unmanageable. Do not set this value to true indiscriminately.
     * For more information, refer to the scenario in the [Default Key Policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default-allow-root-enable-iam) section in the _AWS Key Management Service Developer Guide_.
     * The default value is `false`.
     */
    bypassPolicyLockoutSafetyCheck?: pulumi.Input<boolean>;
    /**
     * ID of the KMS [Custom Key Store](https://docs.aws.amazon.com/kms/latest/developerguide/create-cmk-keystore.html) where the key will be stored instead of KMS (eg CloudHSM).
     */
    customKeyStoreId?: pulumi.Input<string>;
    /**
     * Specifies whether the key contains a symmetric key or an asymmetric key pair and the encryption algorithms or signing algorithms that the key supports.
     * Valid values: `SYMMETRIC_DEFAULT`,  `RSA_2048`, `RSA_3072`, `RSA_4096`, `HMAC_256`, `ECC_NIST_P256`, `ECC_NIST_P384`, `ECC_NIST_P521`, or `ECC_SECG_P256K1`. Defaults to `SYMMETRIC_DEFAULT`. For help with choosing a key spec, see the [AWS KMS Developer Guide](https://docs.aws.amazon.com/kms/latest/developerguide/symm-asymm-choose.html).
     */
    customerMasterKeySpec?: pulumi.Input<string>;
    /**
     * The waiting period, specified in number of days. After the waiting period ends, AWS KMS deletes the KMS key.
     * If you specify a value, it must be between `7` and `30`, inclusive. If you do not specify a value, it defaults to `30`.
     * If the KMS key is a multi-Region primary key with replicas, the waiting period begins when the last of its replica keys is deleted. Otherwise, the waiting period begins immediately.
     */
    deletionWindowInDays?: pulumi.Input<number>;
    /**
     * The description of the key as viewed in AWS console.
     */
    description?: pulumi.Input<string>;
    /**
     * Specifies whether [key rotation](http://docs.aws.amazon.com/kms/latest/developerguide/rotate-keys.html) is enabled. Defaults to `false`.
     */
    enableKeyRotation?: pulumi.Input<boolean>;
    /**
     * Specifies whether the key is enabled. Defaults to `true`.
     */
    isEnabled?: pulumi.Input<boolean>;
    /**
     * Specifies the intended use of the key. Valid values: `ENCRYPT_DECRYPT`, `SIGN_VERIFY`, or `GENERATE_VERIFY_MAC`.
     * Defaults to `ENCRYPT_DECRYPT`.
     */
    keyUsage?: pulumi.Input<string>;
    /**
     * Indicates whether the KMS key is a multi-Region (`true`) or regional (`false`) key. Defaults to `false`.
     */
    multiRegion?: pulumi.Input<boolean>;
    /**
     * A valid policy JSON document. Although this is a key policy, not an IAM policy, an `aws.iam.getPolicyDocument`, in the form that designates a principal, can be used.
     *
     * > **NOTE:** Note: All KMS keys must have a key policy. If a key policy is not specified, AWS gives the KMS key a [default key policy](https://docs.aws.amazon.com/kms/latest/developerguide/key-policies.html#key-policy-default) that gives all principals in the owning account unlimited access to all KMS operations for the key. This default key policy effectively delegates all access control to IAM policies and KMS grants.
     */
    policy?: pulumi.Input<string>;
    /**
     * Custom period of time between each rotation date. Must be a number between 90 and 2560 (inclusive).
     */
    rotationPeriodInDays?: pulumi.Input<number>;
    /**
     * A map of tags to assign to the object. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Identifies the external key that serves as key material for the KMS key in an external key store.
     */
    xksKeyId?: pulumi.Input<string>;
}
