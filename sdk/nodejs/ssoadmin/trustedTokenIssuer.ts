// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Resource for managing an AWS SSO Admin Trusted Token Issuer.
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
 * const exampleTrustedTokenIssuer = new aws.ssoadmin.TrustedTokenIssuer("example", {
 *     name: "example",
 *     instanceArn: example.then(example => example.arns?.[0]),
 *     trustedTokenIssuerType: "OIDC_JWT",
 *     trustedTokenIssuerConfiguration: {
 *         oidcJwtConfiguration: {
 *             claimAttributePath: "email",
 *             identityStoreAttributePath: "emails.value",
 *             issuerUrl: "https://example.com",
 *             jwksRetrievalOption: "OPEN_ID_DISCOVERY",
 *         },
 *     },
 * });
 * ```
 *
 * ## Import
 *
 * Using `pulumi import`, import SSO Admin Trusted Token Issuer using the `id`. For example:
 *
 * ```sh
 * $ pulumi import aws:ssoadmin/trustedTokenIssuer:TrustedTokenIssuer example arn:aws:sso::123456789012:trustedTokenIssuer/ssoins-lu1ye3gew4mbc7ju/tti-2657c556-9707-11ee-b9d1-0242ac120002
 * ```
 */
export class TrustedTokenIssuer extends pulumi.CustomResource {
    /**
     * Get an existing TrustedTokenIssuer resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: TrustedTokenIssuerState, opts?: pulumi.CustomResourceOptions): TrustedTokenIssuer {
        return new TrustedTokenIssuer(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:ssoadmin/trustedTokenIssuer:TrustedTokenIssuer';

    /**
     * Returns true if the given object is an instance of TrustedTokenIssuer.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is TrustedTokenIssuer {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === TrustedTokenIssuer.__pulumiType;
    }

    /**
     * ARN of the trusted token issuer.
     */
    public /*out*/ readonly arn!: pulumi.Output<string>;
    /**
     * A unique, case-sensitive ID that you provide to ensure the idempotency of the request. AWS generates a random value when not provided.
     */
    public readonly clientToken!: pulumi.Output<string | undefined>;
    /**
     * ARN of the instance of IAM Identity Center.
     */
    public readonly instanceArn!: pulumi.Output<string>;
    /**
     * Name of the trusted token issuer.
     */
    public readonly name!: pulumi.Output<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    public readonly tags!: pulumi.Output<{[key: string]: string} | undefined>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    public /*out*/ readonly tagsAll!: pulumi.Output<{[key: string]: string}>;
    /**
     * A block that specifies settings that apply to the trusted token issuer, these change depending on the type you specify in `trustedTokenIssuerType`. Documented below.
     */
    public readonly trustedTokenIssuerConfiguration!: pulumi.Output<outputs.ssoadmin.TrustedTokenIssuerTrustedTokenIssuerConfiguration | undefined>;
    /**
     * Specifies the type of the trusted token issuer. Valid values are `OIDC_JWT`
     *
     * The following arguments are optional:
     */
    public readonly trustedTokenIssuerType!: pulumi.Output<string>;

    /**
     * Create a TrustedTokenIssuer resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: TrustedTokenIssuerArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: TrustedTokenIssuerArgs | TrustedTokenIssuerState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as TrustedTokenIssuerState | undefined;
            resourceInputs["arn"] = state ? state.arn : undefined;
            resourceInputs["clientToken"] = state ? state.clientToken : undefined;
            resourceInputs["instanceArn"] = state ? state.instanceArn : undefined;
            resourceInputs["name"] = state ? state.name : undefined;
            resourceInputs["tags"] = state ? state.tags : undefined;
            resourceInputs["tagsAll"] = state ? state.tagsAll : undefined;
            resourceInputs["trustedTokenIssuerConfiguration"] = state ? state.trustedTokenIssuerConfiguration : undefined;
            resourceInputs["trustedTokenIssuerType"] = state ? state.trustedTokenIssuerType : undefined;
        } else {
            const args = argsOrState as TrustedTokenIssuerArgs | undefined;
            if ((!args || args.instanceArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'instanceArn'");
            }
            if ((!args || args.trustedTokenIssuerType === undefined) && !opts.urn) {
                throw new Error("Missing required property 'trustedTokenIssuerType'");
            }
            resourceInputs["clientToken"] = args ? args.clientToken : undefined;
            resourceInputs["instanceArn"] = args ? args.instanceArn : undefined;
            resourceInputs["name"] = args ? args.name : undefined;
            resourceInputs["tags"] = args ? args.tags : undefined;
            resourceInputs["trustedTokenIssuerConfiguration"] = args ? args.trustedTokenIssuerConfiguration : undefined;
            resourceInputs["trustedTokenIssuerType"] = args ? args.trustedTokenIssuerType : undefined;
            resourceInputs["arn"] = undefined /*out*/;
            resourceInputs["tagsAll"] = undefined /*out*/;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(TrustedTokenIssuer.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering TrustedTokenIssuer resources.
 */
export interface TrustedTokenIssuerState {
    /**
     * ARN of the trusted token issuer.
     */
    arn?: pulumi.Input<string>;
    /**
     * A unique, case-sensitive ID that you provide to ensure the idempotency of the request. AWS generates a random value when not provided.
     */
    clientToken?: pulumi.Input<string>;
    /**
     * ARN of the instance of IAM Identity Center.
     */
    instanceArn?: pulumi.Input<string>;
    /**
     * Name of the trusted token issuer.
     */
    name?: pulumi.Input<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `defaultTags` configuration block.
     *
     * @deprecated Please use `tags` instead.
     */
    tagsAll?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A block that specifies settings that apply to the trusted token issuer, these change depending on the type you specify in `trustedTokenIssuerType`. Documented below.
     */
    trustedTokenIssuerConfiguration?: pulumi.Input<inputs.ssoadmin.TrustedTokenIssuerTrustedTokenIssuerConfiguration>;
    /**
     * Specifies the type of the trusted token issuer. Valid values are `OIDC_JWT`
     *
     * The following arguments are optional:
     */
    trustedTokenIssuerType?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a TrustedTokenIssuer resource.
 */
export interface TrustedTokenIssuerArgs {
    /**
     * A unique, case-sensitive ID that you provide to ensure the idempotency of the request. AWS generates a random value when not provided.
     */
    clientToken?: pulumi.Input<string>;
    /**
     * ARN of the instance of IAM Identity Center.
     */
    instanceArn: pulumi.Input<string>;
    /**
     * Name of the trusted token issuer.
     */
    name?: pulumi.Input<string>;
    /**
     * Key-value mapping of resource tags. If configured with a provider `defaultTags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
    /**
     * A block that specifies settings that apply to the trusted token issuer, these change depending on the type you specify in `trustedTokenIssuerType`. Documented below.
     */
    trustedTokenIssuerConfiguration?: pulumi.Input<inputs.ssoadmin.TrustedTokenIssuerTrustedTokenIssuerConfiguration>;
    /**
     * Specifies the type of the trusted token issuer. Valid values are `OIDC_JWT`
     *
     * The following arguments are optional:
     */
    trustedTokenIssuerType: pulumi.Input<string>;
}
