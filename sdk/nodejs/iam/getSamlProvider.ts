// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * This data source can be used to fetch information about a specific
 * IAM SAML provider. This will allow you to easily retrieve the metadata
 * document of an existing SAML provider.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getSamlProvider({
 *     arn: "arn:aws:iam::123456789:saml-provider/myprovider",
 * });
 * ```
 */
export function getSamlProvider(args: GetSamlProviderArgs, opts?: pulumi.InvokeOptions): Promise<GetSamlProviderResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:iam/getSamlProvider:getSamlProvider", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSamlProvider.
 */
export interface GetSamlProviderArgs {
    /**
     * ARN assigned by AWS for the provider.
     */
    arn: string;
    /**
     * Tags attached to the SAML provider.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getSamlProvider.
 */
export interface GetSamlProviderResult {
    readonly arn: string;
    /**
     * Creation date of the SAML provider in RFC1123 format, e.g. `Mon, 02 Jan 2006 15:04:05 MST`.
     */
    readonly createDate: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    /**
     * Name of the provider.
     */
    readonly name: string;
    /**
     * The XML document generated by an identity provider that supports SAML 2.0.
     */
    readonly samlMetadataDocument: string;
    /**
     * Tags attached to the SAML provider.
     */
    readonly tags: {[key: string]: string};
    /**
     * Expiration date and time for the SAML provider in RFC1123 format, e.g. `Mon, 02 Jan 2007 15:04:05 MST`.
     */
    readonly validUntil: string;
}
/**
 * This data source can be used to fetch information about a specific
 * IAM SAML provider. This will allow you to easily retrieve the metadata
 * document of an existing SAML provider.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.iam.getSamlProvider({
 *     arn: "arn:aws:iam::123456789:saml-provider/myprovider",
 * });
 * ```
 */
export function getSamlProviderOutput(args: GetSamlProviderOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetSamlProviderResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:iam/getSamlProvider:getSamlProvider", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getSamlProvider.
 */
export interface GetSamlProviderOutputArgs {
    /**
     * ARN assigned by AWS for the provider.
     */
    arn: pulumi.Input<string>;
    /**
     * Tags attached to the SAML provider.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
