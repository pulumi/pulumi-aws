// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as inputs from "../types/input";
import * as outputs from "../types/output";
import * as enums from "../types/enums";
import * as utilities from "../utilities";

/**
 * Get information on a AWS Certificate Manager Private Certificate Authority (ACM PCA Certificate Authority).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.acmpca.getCertificateAuthority({
 *     arn: "arn:aws:acm-pca:us-east-1:123456789012:certificate-authority/12345678-1234-1234-1234-123456789012",
 * });
 * ```
 */
export function getCertificateAuthority(args: GetCertificateAuthorityArgs, opts?: pulumi.InvokeOptions): Promise<GetCertificateAuthorityResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:acmpca/getCertificateAuthority:getCertificateAuthority", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getCertificateAuthority.
 */
export interface GetCertificateAuthorityArgs {
    /**
     * ARN of the certificate authority.
     */
    arn: string;
    /**
     * Key-value map of user-defined tags that are attached to the certificate authority.
     */
    tags?: {[key: string]: string};
}

/**
 * A collection of values returned by getCertificateAuthority.
 */
export interface GetCertificateAuthorityResult {
    readonly arn: string;
    /**
     * Base64-encoded certificate authority (CA) certificate. Only available after the certificate authority certificate has been imported.
     */
    readonly certificate: string;
    /**
     * Base64-encoded certificate chain that includes any intermediate certificates and chains up to root on-premises certificate that you used to sign your private CA certificate. The chain does not include your private CA certificate. Only available after the certificate authority certificate has been imported.
     */
    readonly certificateChain: string;
    /**
     * The base64 PEM-encoded certificate signing request (CSR) for your private CA certificate.
     */
    readonly certificateSigningRequest: string;
    /**
     * The provider-assigned unique ID for this managed resource.
     */
    readonly id: string;
    readonly keyStorageSecurityStandard: string;
    /**
     * Date and time after which the certificate authority is not valid. Only available after the certificate authority certificate has been imported.
     */
    readonly notAfter: string;
    /**
     * Date and time before which the certificate authority is not valid. Only available after the certificate authority certificate has been imported.
     */
    readonly notBefore: string;
    /**
     * Nested attribute containing revocation configuration.
     */
    readonly revocationConfigurations: outputs.acmpca.GetCertificateAuthorityRevocationConfiguration[];
    /**
     * Serial number of the certificate authority. Only available after the certificate authority certificate has been imported.
     */
    readonly serial: string;
    /**
     * Status of the certificate authority.
     */
    readonly status: string;
    /**
     * Key-value map of user-defined tags that are attached to the certificate authority.
     */
    readonly tags: {[key: string]: string};
    /**
     * Type of the certificate authority.
     */
    readonly type: string;
    /**
     * Specifies whether the CA issues general-purpose certificates that typically require a revocation mechanism, or short-lived certificates that may optionally omit revocation because they expire quickly.
     */
    readonly usageMode: string;
}
/**
 * Get information on a AWS Certificate Manager Private Certificate Authority (ACM PCA Certificate Authority).
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.acmpca.getCertificateAuthority({
 *     arn: "arn:aws:acm-pca:us-east-1:123456789012:certificate-authority/12345678-1234-1234-1234-123456789012",
 * });
 * ```
 */
export function getCertificateAuthorityOutput(args: GetCertificateAuthorityOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetCertificateAuthorityResult> {
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:acmpca/getCertificateAuthority:getCertificateAuthority", {
        "arn": args.arn,
        "tags": args.tags,
    }, opts);
}

/**
 * A collection of arguments for invoking getCertificateAuthority.
 */
export interface GetCertificateAuthorityOutputArgs {
    /**
     * ARN of the certificate authority.
     */
    arn: pulumi.Input<string>;
    /**
     * Key-value map of user-defined tags that are attached to the certificate authority.
     */
    tags?: pulumi.Input<{[key: string]: pulumi.Input<string>}>;
}
