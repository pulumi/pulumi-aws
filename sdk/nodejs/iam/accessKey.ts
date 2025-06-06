// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Provides an IAM access key. This is a set of credentials that allow API requests to be made as an IAM user.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const lbUser = new aws.iam.User("lb", {
 *     name: "loadbalancer",
 *     path: "/system/",
 * });
 * const lb = new aws.iam.AccessKey("lb", {
 *     user: lbUser.name,
 *     pgpKey: "keybase:some_person_that_exists",
 * });
 * const lbRo = aws.iam.getPolicyDocument({
 *     statements: [{
 *         effect: "Allow",
 *         actions: ["ec2:Describe*"],
 *         resources: ["*"],
 *     }],
 * });
 * const lbRoUserPolicy = new aws.iam.UserPolicy("lb_ro", {
 *     name: "test",
 *     user: lbUser.name,
 *     policy: lbRo.then(lbRo => lbRo.json),
 * });
 * export const secret = lb.encryptedSecret;
 * ```
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const test = new aws.iam.User("test", {
 *     name: "test",
 *     path: "/test/",
 * });
 * const testAccessKey = new aws.iam.AccessKey("test", {user: test.name});
 * export const awsIamSmtpPasswordV4 = testAccessKey.sesSmtpPasswordV4;
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import IAM Access Keys using the identifier. For example:
 *
 * ```sh
 * $ pulumi import aws:iam/accessKey:AccessKey example AKIA1234567890
 * ```
 * Resource attributes such as `encrypted_secret`, `key_fingerprint`, `pgp_key`, `secret`, `ses_smtp_password_v4`, and `encrypted_ses_smtp_password_v4` are not available for imported resources as this information cannot be read from the IAM API.
 */
export class AccessKey extends pulumi.CustomResource {
    /**
     * Get an existing AccessKey resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: AccessKeyState, opts?: pulumi.CustomResourceOptions): AccessKey {
        return new AccessKey(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:iam/accessKey:AccessKey';

    /**
     * Returns true if the given object is an instance of AccessKey.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is AccessKey {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === AccessKey.__pulumiType;
    }

    /**
     * Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the access key was created.
     */
    public /*out*/ readonly createDate!: pulumi.Output<string>;
    /**
     * Encrypted secret, base64 encoded, if `pgpKey` was specified. This attribute is not available for imported resources. The encrypted secret may be decrypted using the command line.
     */
    public /*out*/ readonly encryptedSecret!: pulumi.Output<string>;
    /**
     * Encrypted SES SMTP password, base64 encoded, if `pgpKey` was specified. This attribute is not available for imported resources. The encrypted password may be decrypted using the command line.
     */
    public /*out*/ readonly encryptedSesSmtpPasswordV4!: pulumi.Output<string>;
    /**
     * Fingerprint of the PGP key used to encrypt the secret. This attribute is not available for imported resources.
     */
    public /*out*/ readonly keyFingerprint!: pulumi.Output<string>;
    /**
     * Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encryptedSecret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the "raw" version and not the "armored" one (e.g. avoid passing the `-a` option to `gpg --export`).
     */
    public readonly pgpKey!: pulumi.Output<string | undefined>;
    /**
     * Secret access key. This attribute is not available for imported resources. Note that this will be written to the state file. If you use this, please protect your backend state file judiciously. Alternatively, you may supply a `pgpKey` instead, which will prevent the secret from being stored in plaintext, at the cost of preventing the use of the secret key in automation.
     */
    public /*out*/ readonly secret!: pulumi.Output<string>;
    /**
     * Secret access key converted into an SES SMTP password by applying [AWS's documented Sigv4 conversion algorithm](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/smtp-credentials.html#smtp-credentials-convert). This attribute is not available for imported resources. As SigV4 is region specific, valid Provider regions are `ap-south-1`, `ap-southeast-2`, `eu-central-1`, `eu-west-1`, `us-east-1` and `us-west-2`. See current [AWS SES regions](https://docs.aws.amazon.com/general/latest/gr/rande.html#ses_region).
     */
    public /*out*/ readonly sesSmtpPasswordV4!: pulumi.Output<string>;
    /**
     * Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
     */
    public readonly status!: pulumi.Output<string | undefined>;
    /**
     * IAM user to associate with this access key.
     */
    public readonly user!: pulumi.Output<string>;

    /**
     * Create a AccessKey resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: AccessKeyArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: AccessKeyArgs | AccessKeyState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as AccessKeyState | undefined;
            resourceInputs["createDate"] = state ? state.createDate : undefined;
            resourceInputs["encryptedSecret"] = state ? state.encryptedSecret : undefined;
            resourceInputs["encryptedSesSmtpPasswordV4"] = state ? state.encryptedSesSmtpPasswordV4 : undefined;
            resourceInputs["keyFingerprint"] = state ? state.keyFingerprint : undefined;
            resourceInputs["pgpKey"] = state ? state.pgpKey : undefined;
            resourceInputs["secret"] = state ? state.secret : undefined;
            resourceInputs["sesSmtpPasswordV4"] = state ? state.sesSmtpPasswordV4 : undefined;
            resourceInputs["status"] = state ? state.status : undefined;
            resourceInputs["user"] = state ? state.user : undefined;
        } else {
            const args = argsOrState as AccessKeyArgs | undefined;
            if ((!args || args.user === undefined) && !opts.urn) {
                throw new Error("Missing required property 'user'");
            }
            resourceInputs["pgpKey"] = args ? args.pgpKey : undefined;
            resourceInputs["status"] = args ? args.status : undefined;
            resourceInputs["user"] = args ? args.user : undefined;
            resourceInputs["createDate"] = undefined /*out*/;
            resourceInputs["encryptedSecret"] = undefined /*out*/;
            resourceInputs["encryptedSesSmtpPasswordV4"] = undefined /*out*/;
            resourceInputs["keyFingerprint"] = undefined /*out*/;
            resourceInputs["secret"] = undefined /*out*/;
            resourceInputs["sesSmtpPasswordV4"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        const secretOpts = { additionalSecretOutputs: ["secret", "sesSmtpPasswordV4"] };
        opts = pulumi.mergeOptions(opts, secretOpts);
        super(AccessKey.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering AccessKey resources.
 */
export interface AccessKeyState {
    /**
     * Date and time in [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) that the access key was created.
     */
    createDate?: pulumi.Input<string>;
    /**
     * Encrypted secret, base64 encoded, if `pgpKey` was specified. This attribute is not available for imported resources. The encrypted secret may be decrypted using the command line.
     */
    encryptedSecret?: pulumi.Input<string>;
    /**
     * Encrypted SES SMTP password, base64 encoded, if `pgpKey` was specified. This attribute is not available for imported resources. The encrypted password may be decrypted using the command line.
     */
    encryptedSesSmtpPasswordV4?: pulumi.Input<string>;
    /**
     * Fingerprint of the PGP key used to encrypt the secret. This attribute is not available for imported resources.
     */
    keyFingerprint?: pulumi.Input<string>;
    /**
     * Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encryptedSecret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the "raw" version and not the "armored" one (e.g. avoid passing the `-a` option to `gpg --export`).
     */
    pgpKey?: pulumi.Input<string>;
    /**
     * Secret access key. This attribute is not available for imported resources. Note that this will be written to the state file. If you use this, please protect your backend state file judiciously. Alternatively, you may supply a `pgpKey` instead, which will prevent the secret from being stored in plaintext, at the cost of preventing the use of the secret key in automation.
     */
    secret?: pulumi.Input<string>;
    /**
     * Secret access key converted into an SES SMTP password by applying [AWS's documented Sigv4 conversion algorithm](https://docs.aws.amazon.com/ses/latest/DeveloperGuide/smtp-credentials.html#smtp-credentials-convert). This attribute is not available for imported resources. As SigV4 is region specific, valid Provider regions are `ap-south-1`, `ap-southeast-2`, `eu-central-1`, `eu-west-1`, `us-east-1` and `us-west-2`. See current [AWS SES regions](https://docs.aws.amazon.com/general/latest/gr/rande.html#ses_region).
     */
    sesSmtpPasswordV4?: pulumi.Input<string>;
    /**
     * Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
     */
    status?: pulumi.Input<string>;
    /**
     * IAM user to associate with this access key.
     */
    user?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a AccessKey resource.
 */
export interface AccessKeyArgs {
    /**
     * Either a base-64 encoded PGP public key, or a keybase username in the form `keybase:some_person_that_exists`, for use in the `encryptedSecret` output attribute. If providing a base-64 encoded PGP public key, make sure to provide the "raw" version and not the "armored" one (e.g. avoid passing the `-a` option to `gpg --export`).
     */
    pgpKey?: pulumi.Input<string>;
    /**
     * Access key status to apply. Defaults to `Active`. Valid values are `Active` and `Inactive`.
     */
    status?: pulumi.Input<string>;
    /**
     * IAM user to associate with this access key.
     */
    user: pulumi.Input<string>;
}
