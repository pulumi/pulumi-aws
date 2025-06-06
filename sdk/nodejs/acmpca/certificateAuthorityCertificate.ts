// *** WARNING: this file was generated by pulumi-language-nodejs. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

import * as pulumi from "@pulumi/pulumi";
import * as utilities from "../utilities";

/**
 * Associates a certificate with an AWS Certificate Manager Private Certificate Authority (ACM PCA Certificate Authority). An ACM PCA Certificate Authority is unable to issue certificates until it has a certificate associated with it. A root level ACM PCA Certificate Authority is able to self-sign its own root certificate.
 *
 * ## Example Usage
 *
 * ### Self-Signed Root Certificate Authority Certificate
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const exampleCertificateAuthority = new aws.acmpca.CertificateAuthority("example", {
 *     type: "ROOT",
 *     certificateAuthorityConfiguration: {
 *         keyAlgorithm: "RSA_4096",
 *         signingAlgorithm: "SHA512WITHRSA",
 *         subject: {
 *             commonName: "example.com",
 *         },
 *     },
 * });
 * const current = aws.getPartition({});
 * const exampleCertificate = new aws.acmpca.Certificate("example", {
 *     certificateAuthorityArn: exampleCertificateAuthority.arn,
 *     certificateSigningRequest: exampleCertificateAuthority.certificateSigningRequest,
 *     signingAlgorithm: "SHA512WITHRSA",
 *     templateArn: current.then(current => `arn:${current.partition}:acm-pca:::template/RootCACertificate/V1`),
 *     validity: {
 *         type: "YEARS",
 *         value: "1",
 *     },
 * });
 * const example = new aws.acmpca.CertificateAuthorityCertificate("example", {
 *     certificateAuthorityArn: exampleCertificateAuthority.arn,
 *     certificate: exampleCertificate.certificate,
 *     certificateChain: exampleCertificate.certificateChain,
 * });
 * ```
 *
 * ### Certificate for Subordinate Certificate Authority
 *
 * Note that the certificate for the subordinate certificate authority must be issued by the root certificate authority using a signing request from the subordinate certificate authority.
 *
 * ```typescript
 * import * as pulumi from "@pulumi/pulumi";
 * import * as aws from "@pulumi/aws";
 *
 * const subordinateCertificateAuthority = new aws.acmpca.CertificateAuthority("subordinate", {
 *     type: "SUBORDINATE",
 *     certificateAuthorityConfiguration: {
 *         keyAlgorithm: "RSA_2048",
 *         signingAlgorithm: "SHA512WITHRSA",
 *         subject: {
 *             commonName: "sub.example.com",
 *         },
 *     },
 * });
 * const root = new aws.acmpca.CertificateAuthority("root", {});
 * const current = aws.getPartition({});
 * const subordinateCertificate = new aws.acmpca.Certificate("subordinate", {
 *     certificateAuthorityArn: root.arn,
 *     certificateSigningRequest: subordinateCertificateAuthority.certificateSigningRequest,
 *     signingAlgorithm: "SHA512WITHRSA",
 *     templateArn: current.then(current => `arn:${current.partition}:acm-pca:::template/SubordinateCACertificate_PathLen0/V1`),
 *     validity: {
 *         type: "YEARS",
 *         value: "1",
 *     },
 * });
 * const subordinate = new aws.acmpca.CertificateAuthorityCertificate("subordinate", {
 *     certificateAuthorityArn: subordinateCertificateAuthority.arn,
 *     certificate: subordinateCertificate.certificate,
 *     certificateChain: subordinateCertificate.certificateChain,
 * });
 * const rootCertificateAuthorityCertificate = new aws.acmpca.CertificateAuthorityCertificate("root", {});
 * const rootCertificate = new aws.acmpca.Certificate("root", {});
 * ```
 */
export class CertificateAuthorityCertificate extends pulumi.CustomResource {
    /**
     * Get an existing CertificateAuthorityCertificate resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state Any extra arguments used during the lookup.
     * @param opts Optional settings to control the behavior of the CustomResource.
     */
    public static get(name: string, id: pulumi.Input<pulumi.ID>, state?: CertificateAuthorityCertificateState, opts?: pulumi.CustomResourceOptions): CertificateAuthorityCertificate {
        return new CertificateAuthorityCertificate(name, <any>state, { ...opts, id: id });
    }

    /** @internal */
    public static readonly __pulumiType = 'aws:acmpca/certificateAuthorityCertificate:CertificateAuthorityCertificate';

    /**
     * Returns true if the given object is an instance of CertificateAuthorityCertificate.  This is designed to work even
     * when multiple copies of the Pulumi SDK have been loaded into the same process.
     */
    public static isInstance(obj: any): obj is CertificateAuthorityCertificate {
        if (obj === undefined || obj === null) {
            return false;
        }
        return obj['__pulumiType'] === CertificateAuthorityCertificate.__pulumiType;
    }

    /**
     * PEM-encoded certificate for the Certificate Authority.
     */
    public readonly certificate!: pulumi.Output<string>;
    /**
     * ARN of the Certificate Authority.
     */
    public readonly certificateAuthorityArn!: pulumi.Output<string>;
    /**
     * PEM-encoded certificate chain that includes any intermediate certificates and chains up to root CA. Required for subordinate Certificate Authorities. Not allowed for root Certificate Authorities.
     */
    public readonly certificateChain!: pulumi.Output<string | undefined>;

    /**
     * Create a CertificateAuthorityCertificate resource with the given unique name, arguments, and options.
     *
     * @param name The _unique_ name of the resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param opts A bag of options that control this resource's behavior.
     */
    constructor(name: string, args: CertificateAuthorityCertificateArgs, opts?: pulumi.CustomResourceOptions)
    constructor(name: string, argsOrState?: CertificateAuthorityCertificateArgs | CertificateAuthorityCertificateState, opts?: pulumi.CustomResourceOptions) {
        let resourceInputs: pulumi.Inputs = {};
        opts = opts || {};
        if (opts.id) {
            const state = argsOrState as CertificateAuthorityCertificateState | undefined;
            resourceInputs["certificate"] = state ? state.certificate : undefined;
            resourceInputs["certificateAuthorityArn"] = state ? state.certificateAuthorityArn : undefined;
            resourceInputs["certificateChain"] = state ? state.certificateChain : undefined;
        } else {
            const args = argsOrState as CertificateAuthorityCertificateArgs | undefined;
            if ((!args || args.certificate === undefined) && !opts.urn) {
                throw new Error("Missing required property 'certificate'");
            }
            if ((!args || args.certificateAuthorityArn === undefined) && !opts.urn) {
                throw new Error("Missing required property 'certificateAuthorityArn'");
            }
            resourceInputs["certificate"] = args ? args.certificate : undefined;
            resourceInputs["certificateAuthorityArn"] = args ? args.certificateAuthorityArn : undefined;
            resourceInputs["certificateChain"] = args ? args.certificateChain : undefined;
        }
        opts = pulumi.mergeOptions(utilities.resourceOptsDefaults(), opts);
        super(CertificateAuthorityCertificate.__pulumiType, name, resourceInputs, opts);
    }
}

/**
 * Input properties used for looking up and filtering CertificateAuthorityCertificate resources.
 */
export interface CertificateAuthorityCertificateState {
    /**
     * PEM-encoded certificate for the Certificate Authority.
     */
    certificate?: pulumi.Input<string>;
    /**
     * ARN of the Certificate Authority.
     */
    certificateAuthorityArn?: pulumi.Input<string>;
    /**
     * PEM-encoded certificate chain that includes any intermediate certificates and chains up to root CA. Required for subordinate Certificate Authorities. Not allowed for root Certificate Authorities.
     */
    certificateChain?: pulumi.Input<string>;
}

/**
 * The set of arguments for constructing a CertificateAuthorityCertificate resource.
 */
export interface CertificateAuthorityCertificateArgs {
    /**
     * PEM-encoded certificate for the Certificate Authority.
     */
    certificate: pulumi.Input<string>;
    /**
     * ARN of the Certificate Authority.
     */
    certificateAuthorityArn: pulumi.Input<string>;
    /**
     * PEM-encoded certificate chain that includes any intermediate certificates and chains up to root CA. Required for subordinate Certificate Authorities. Not allowed for root Certificate Authorities.
     */
    certificateChain?: pulumi.Input<string>;
}
