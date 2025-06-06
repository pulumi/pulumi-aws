// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Manages a Route 53 Key Signing Key. To manage Domain Name System Security Extensions (DNSSEC) for a Hosted Zone, see the `aws.route53.HostedZoneDnsSec` resource. For more information about managing DNSSEC in Route 53, see the [Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring-dnssec.html).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const current = aws.getCallerIdentity({});
 * const example = new aws.kms.Key("example", {
 *     customerMasterKeySpec: "ECC_NIST_P256",
 *     deletionWindowInDays: 7,
 *     keyUsage: "SIGN_VERIFY",
 *     policy: JSON.stringify({
 *         Statement: [
 *             {
 *                 Action: [
 *                     "kms:DescribeKey",
 *                     "kms:GetPublicKey",
 *                     "kms:Sign",
 *                 ],
 *                 Effect: "Allow",
 *                 Principal: {
 *                     Service: "dnssec-route53.amazonaws.com",
 *                 },
 *                 Sid: "Allow Route 53 DNSSEC Service",
 *                 Resource: "*",
 *                 Condition: {
 *                     StringEquals: {
 *                         "aws:SourceAccount": current.then(current => current.accountId),
 *                     },
 *                     ArnLike: {
 *                         "aws:SourceArn": "arn:aws:route53:::hostedzone/*",
 *                     },
 *                 },
 *             },
 *             {
 *                 Action: "kms:CreateGrant",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     Service: "dnssec-route53.amazonaws.com",
 *                 },
 *                 Sid: "Allow Route 53 DNSSEC Service to CreateGrant",
 *                 Resource: "*",
 *                 Condition: {
 *                     Bool: {
 *                         "kms:GrantIsForAWSResource": "true",
 *                     },
 *                 },
 *             },
 *             {
 *                 Action: "kms:*",
 *                 Effect: "Allow",
 *                 Principal: {
 *                     AWS: current.then(current => `arn:aws:iam::${current.accountId}:root`),
 *                 },
 *                 Resource: "*",
 *                 Sid: "Enable IAM User Permissions",
 *             },
 *         ],
 *         Version: "2012-10-17",
 *     }),
 * });
 * const exampleZone = new aws.route53.Zone("example", {name: "example.com"});
 * const exampleKeySigningKey = new aws.route53.KeySigningKey("example", {
 *     hostedZoneId: test.id,
 *     keyManagementServiceArn: testAwsKmsKey.arn,
 *     name: "example",
 * });
 * const exampleHostedZoneDnsSec = new aws.route53.HostedZoneDnsSec("example", {hostedZoneId: exampleKeySigningKey.hostedZoneId}, {
 *     dependsOn: [exampleKeySigningKey],
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import `aws_route53_key_signing_key` resources using the Route 53 Hosted Zone identifier and KMS Key identifier, separated by a comma (`,`). For example:
 *
 * ```sh
 * $ pulumi import aws:route53/keySigningKey:KeySigningKey example Z1D633PJN98FT9,example
 * ```
 */
export class KeySigningKey extends pulumi.CustomResource {
    /**
     * Get an existing KeySigningKey resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: KeySigningKeyState, opts?: pulumi.CustomResourceOptions): KeySigningKey {
        return new KeySigningKey(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:route53/keySigningKey:KeySigningKey';

    /**
     * Returns true if the given object is an instance of KeySigningKey.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is KeySigningKey {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === KeySigningKey.__pulumiType;
    }

    /**
     * A string used to represent the delegation signer digest algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.3](https://tools.ietf.org/html/rfc8624#section-3.3).
     */
    public /*out*/ readonly digestAlgorithmMnemonic!: pulumi.Output<string>;
    /**
     * An integer used to represent the delegation signer digest algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.3](https://tools.ietf.org/html/rfc8624#section-3.3).
     */
    public /*out*/ readonly digestAlgorithmType!: pulumi.Output<number>;
    /**
     * A cryptographic digest of a DNSKEY resource record (RR). DNSKEY records are used to publish the public key that resolvers can use to verify DNSSEC signatures that are used to secure certain kinds of information provided by the DNS system.
     */
    public /*out*/ readonly digestValue!: pulumi.Output<string>;
    /**
     * A string that represents a DNSKEY record.
     */
    public /*out*/ readonly dnskeyRecord!: pulumi.Output<string>;
    /**
     * A string that represents a delegation signer (DS) record.
     */
    public /*out*/ readonly dsRecord!: pulumi.Output<string>;
    /**
     * An integer that specifies how the key is used. For key-signing key (KSK), this value is always 257.
     */
    public /*out*/ readonly flag!: pulumi.Output<number>;
    /**
     * Identifier of the Route 53 Hosted Zone.
     */
    public readonly hostedZoneId!: pulumi.Output<string>;
    /**
     * Amazon Resource Name (ARN) of the Key Management Service (KMS) Key. This must be unique for each key-signing key (KSK) in a single hosted zone. This key must be in the `us-east-1` Region and meet certain requirements, which are described in the [Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring-dnssec-cmk-requirements.html) and [Route 53 API Reference](https://docs.aws.amazon.com/Route53/latest/APIReference/API_CreateKeySigningKey.html).
     */
    public readonly keyManagementServiceArn!: pulumi.Output<string>;
    /**
     * An integer used to identify the DNSSEC record for the domain name. The process used to calculate the value is described in [RFC-4034 Appendix B](https://tools.ietf.org/rfc/rfc4034.txt).
     */
    public /*out*/ readonly keyTag!: pulumi.Output<number>;
    /**
     * Name of the key-signing key (KSK). Must be unique for each key-signing key in the same hosted zone.
     *
     * The following arguments are optional:
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * The public key, represented as a Base64 encoding, as required by [RFC-4034 Page 5](https://tools.ietf.org/rfc/rfc4034.txt).
     */
    public /*out*/ readonly publicKey!: pulumi.Output<string>;
    /**
     * A string used to represent the signing algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.1](https://tools.ietf.org/html/rfc8624#section-3.1).
     */
    public /*out*/ readonly signingAlgorithmMnemonic!: pulumi.Output<string>;
    /**
     * An integer used to represent the signing algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.1](https://tools.ietf.org/html/rfc8624#section-3.1).
     */
    public /*out*/ readonly signingAlgorithmType!: pulumi.Output<number>;
    /**
     * Status of the key-signing key (KSK). Valid values: `ACTIVE`, `INACTIVE`. Defaults to `ACTIVE`.
     */
    public readonly status!: pulumi.Output<string | undefined>;

    /**
     * Create a KeySigningKey resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: KeySigningKeyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: KeySigningKeyArgs | KeySigningKeyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as KeySigningKeyState | undefined;
            resourceInputs["digestAlgorithmMnemonic"] = state ? state.digestAlgorithmMnemonic : undefined;
            resourceInputs["digestAlgorithmType"] = state ? state.digestAlgorithmType : undefined;
            resourceInputs["digestValue"] = state ? state.digestValue : undefined;
            resourceInputs["dnskeyRecord"] = state ? state.dnskeyRecord : undefined;
            resourceInputs["dsRecord"] = state ? state.dsRecord : undefined;
            resourceInputs["flag"] = state ? state.flag : undefined;
            resourceInputs["hostedZoneId"] = state ? state.hostedZoneId : undefined;
            resourceInputs["keyManagementServiceArn"] = state ? state.keyManagementServiceArn : undefined;
            resourceInputs["keyTag"] = state ? state.keyTag : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["publicKey"] = state ? state.publicKey : undefined;
            resourceInputs["signingAlgorithmMnemonic"] = state ? state.signingAlgorithmMnemonic : undefined;
            resourceInputs["signingAlgorithmType"] = state ? state.signingAlgorithmType : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
        } else {
            const args = argsOrState as KeySigningKeyArgs | undefined;
            if ((!args || args.hostedZoneId === undefined) && !opts.urn) {
                throw new Error("Missing required property 'hostedZoneId'");
            }
            if ((!args || args.keyManagementServiceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'keyManagementServiceArn'");
            }
            resourceInputs["hostedZoneId"] = args ? args.hostedZoneId : undefined;
            resourceInputs["keyManagementServiceArn"] = args ? args.keyManagementServiceArn : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["status"] = args ? args.status : undefined;
            resourceInputs["digestAlgorithmMnemonic"] = undefined /*out*/;
            resourceInputs["digestAlgorithmType"] = undefined /*out*/;
            resourceInputs["digestValue"] = undefined /*out*/;
            resourceInputs["dnskeyRecord"] = undefined /*out*/;
            resourceInputs["dsRecord"] = undefined /*out*/;
            resourceInputs["flag"] = undefined /*out*/;
            resourceInputs["keyTag"] = undefined /*out*/;
            resourceInputs["publicKey"] = undefined /*out*/;
            resourceInputs["signingAlgorithmMnemonic"] = undefined /*out*/;
            resourceInputs["signingAlgorithmType"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(KeySigningKey.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering KeySigningKey resources.
 */
export interface KeySigningKeyState {
    /**
     * A string used to represent the delegation signer digest algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.3](https://tools.ietf.org/html/rfc8624#section-3.3).
     */
    digestAlgorithmMnemonic?: pulumi.Input<string>;
    /**
     * An integer used to represent the delegation signer digest algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.3](https://tools.ietf.org/html/rfc8624#section-3.3).
     */
    digestAlgorithmType?: pulumi.Input<number>;
    /**
     * A cryptographic digest of a DNSKEY resource record (RR). DNSKEY records are used to publish the public key that resolvers can use to verify DNSSEC signatures that are used to secure certain kinds of information provided by the DNS system.
     */
    digestValue?: pulumi.Input<string>;
    /**
     * A string that represents a DNSKEY record.
     */
    dnskeyRecord?: pulumi.Input<string>;
    /**
     * A string that represents a delegation signer (DS) record.
     */
    dsRecord?: pulumi.Input<string>;
    /**
     * An integer that specifies how the key is used. For key-signing key (KSK), this value is always 257.
     */
    flag?: pulumi.Input<number>;
    /**
     * Identifier of the Route 53 Hosted Zone.
     */
    hostedZoneId?: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the Key Management Service (KMS) Key. This must be unique for each key-signing key (KSK) in a single hosted zone. This key must be in the `us-east-1` Region and meet certain requirements, which are described in the [Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring-dnssec-cmk-requirements.html) and [Route 53 API Reference](https://docs.aws.amazon.com/Route53/latest/APIReference/API_CreateKeySigningKey.html).
     */
    keyManagementServiceArn?: pulumi.Input<string>;
    /**
     * An integer used to identify the DNSSEC record for the domain name. The process used to calculate the value is described in [RFC-4034 Appendix B](https://tools.ietf.org/rfc/rfc4034.txt).
     */
    keyTag?: pulumi.Input<number>;
    /**
     * Name of the key-signing key (KSK). Must be unique for each key-signing key in the same hosted zone.
     *
     * The following arguments are optional:
     */
    name?: pulumi.Input<string>;
    /**
     * The public key, represented as a Base64 encoding, as required by [RFC-4034 Page 5](https://tools.ietf.org/rfc/rfc4034.txt).
     */
    publicKey?: pulumi.Input<string>;
    /**
     * A string used to represent the signing algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.1](https://tools.ietf.org/html/rfc8624#section-3.1).
     */
    signingAlgorithmMnemonic?: pulumi.Input<string>;
    /**
     * An integer used to represent the signing algorithm. This value must follow the guidelines provided by [RFC-8624 Section 3.1](https://tools.ietf.org/html/rfc8624#section-3.1).
     */
    signingAlgorithmType?: pulumi.Input<number>;
    /**
     * Status of the key-signing key (KSK). Valid values: `ACTIVE`, `INACTIVE`. Defaults to `ACTIVE`.
     */
    status?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a KeySigningKey resource.
 */
export interface KeySigningKeyArgs {
    /**
     * Identifier of the Route 53 Hosted Zone.
     */
    hostedZoneId: pulumi.Input<string>;
    /**
     * Amazon Resource Name (ARN) of the Key Management Service (KMS) Key. This must be unique for each key-signing key (KSK) in a single hosted zone. This key must be in the `us-east-1` Region and meet certain requirements, which are described in the [Route 53 Developer Guide](https://docs.aws.amazon.com/Route53/latest/DeveloperGuide/dns-configuring-dnssec-cmk-requirements.html) and [Route 53 API Reference](https://docs.aws.amazon.com/Route53/latest/APIReference/API_CreateKeySigningKey.html).
     */
    keyManagementServiceArn: pulumi.Input<string>;
    /**
     * Name of the key-signing key (KSK). Must be unique for each key-signing key in the same hosted zone.
     *
     * The following arguments are optional:
     */
    name?: pulumi.Input<string>;
    /**
     * Status of the key-signing key (KSK). Valid values: `ACTIVE`, `INACTIVE`. Defaults to `ACTIVE`.
     */
    status?: pulumi.Input<string>;
}
