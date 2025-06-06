// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Information about an RDS Certificate.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.rds.getCertificate({
 *     latestValidTill: true,
 * });
 * ```
 */
export function getCertificate(args?: GetCertificateArgs, opts?: pulumi.InvokeOptions): Promise<GetCertificateResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invoke("aws:rds/getCertificate:getCertificate", {
        "defaultForNewLaunches": args.defaultForNewLaunches,
        "id": args.id,
        "latestValidTill": args.latestValidTill,
    }, opts);
}

/**
 * A collection of arguments for invoking getCertificate.
 */
export interface GetCertificateArgs {
    /**
     * When enabled, returns the default certificate for new RDS instances.
     */
    defaultForNewLaunches?: boolean;
    /**
     * Certificate identifier. For example, `rds-ca-2019`.
     */
    id?: string;
    /**
     * When enabled, returns the certificate with the latest `ValidTill`.
     */
    latestValidTill?: boolean;
}

/**
 * A collection of values returned by getCertificate.
 */
export interface GetCertificateResult {
    /**
     * ARN of the certificate.
     */
    readonly arn: string;
    /**
     * Type of certificate. For example, `CA`.
     */
    readonly certificateType: string;
    /**
     * Boolean whether there is an override for the default certificate identifier.
     */
    readonly customerOverride: boolean;
    /**
     * If there is an override for the default certificate identifier, when the override expires.
     */
    readonly customerOverrideValidTill: string;
    readonly defaultForNewLaunches?: boolean;
    readonly id: string;
    readonly latestValidTill?: boolean;
    /**
     * Thumbprint of the certificate.
     */
    readonly thumbprint: string;
    /**
     * [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) of certificate starting validity date.
     */
    readonly validFrom: string;
    /**
     * [RFC3339 format](https://tools.ietf.org/html/rfc3339#section-5.8) of certificate ending validity date.
     */
    readonly validTill: string;
}
/**
 * Information about an RDS Certificate.
 *
 * ## Example Usage
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const example = aws.rds.getCertificate({
 *     latestValidTill: true,
 * });
 * ```
 */
export function getCertificateOutput(args?: GetCertificateOutputArgs, opts?: pulumi.InvokeOutputOptions): pulumi.Output<GetCertificateResult> {
    args = args || {};
    opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts || {});
    return pulumi.runtime.invokeOutput("aws:rds/getCertificate:getCertificate", {
        "defaultForNewLaunches": args.defaultForNewLaunches,
        "id": args.id,
        "latestValidTill": args.latestValidTill,
    }, opts);
}

/**
 * A collection of arguments for invoking getCertificate.
 */
export interface GetCertificateOutputArgs {
    /**
     * When enabled, returns the default certificate for new RDS instances.
     */
    defaultForNewLaunches?: pulumi.Input<boolean>;
    /**
     * Certificate identifier. For example, `rds-ca-2019`.
     */
    id?: pulumi.Input<string>;
    /**
     * When enabled, returns the certificate with the latest `ValidTill`.
     */
    latestValidTill?: pulumi.Input<boolean>;
}
