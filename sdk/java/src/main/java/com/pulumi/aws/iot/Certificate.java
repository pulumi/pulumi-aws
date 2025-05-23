// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.iot.CertificateArgs;
import com.pulumi.aws.iot.inputs.CertificateState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Creates and manages an AWS IoT certificate.
 * 
 * ## Example Usage
 * 
 * ### With CSR
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.iot.Certificate;
 * import com.pulumi.aws.iot.CertificateArgs;
 * import com.pulumi.std.StdFunctions;
 * import com.pulumi.std.inputs.FileArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var cert = new Certificate("cert", CertificateArgs.builder()
 *             .csr(StdFunctions.file(FileArgs.builder()
 *                 .input("/my/csr.pem")
 *                 .build()).result())
 *             .active(true)
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Without CSR
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.iot.Certificate;
 * import com.pulumi.aws.iot.CertificateArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var cert = new Certificate("cert", CertificateArgs.builder()
 *             .active(true)
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### From existing certificate without a CA
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.iot.Certificate;
 * import com.pulumi.aws.iot.CertificateArgs;
 * import com.pulumi.std.StdFunctions;
 * import com.pulumi.std.inputs.FileArgs;
 * import java.util.List;
 * import java.util.ArrayList;
 * import java.util.Map;
 * import java.io.File;
 * import java.nio.file.Files;
 * import java.nio.file.Paths;
 * 
 * public class App {
 *     public static void main(String[] args) {
 *         Pulumi.run(App::stack);
 *     }
 * 
 *     public static void stack(Context ctx) {
 *         var cert = new Certificate("cert", CertificateArgs.builder()
 *             .certificatePem(StdFunctions.file(FileArgs.builder()
 *                 .input("/my/cert.pem")
 *                 .build()).result())
 *             .active(true)
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 */
@ResourceType(type="aws:iot/certificate:Certificate")
public class Certificate extends com.pulumi.resources.CustomResource {
    /**
     * Boolean flag to indicate if the certificate should be active
     * 
     */
    @Export(name="active", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> active;

    /**
     * @return Boolean flag to indicate if the certificate should be active
     * 
     */
    public Output<Boolean> active() {
        return this.active;
    }
    /**
     * The ARN of the created certificate.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the created certificate.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The certificate ID of the CA certificate used to sign the certificate.
     * 
     */
    @Export(name="caCertificateId", refs={String.class}, tree="[0]")
    private Output<String> caCertificateId;

    /**
     * @return The certificate ID of the CA certificate used to sign the certificate.
     * 
     */
    public Output<String> caCertificateId() {
        return this.caCertificateId;
    }
    /**
     * The CA certificate for the certificate to be registered. If this is set, the CA needs to be registered with AWS IoT beforehand.
     * 
     */
    @Export(name="caPem", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> caPem;

    /**
     * @return The CA certificate for the certificate to be registered. If this is set, the CA needs to be registered with AWS IoT beforehand.
     * 
     */
    public Output<Optional<String>> caPem() {
        return Codegen.optional(this.caPem);
    }
    /**
     * The certificate to be registered. If `ca_pem` is unspecified, review
     * [RegisterCertificateWithoutCA](https://docs.aws.amazon.com/iot/latest/apireference/API_RegisterCertificateWithoutCA.html).
     * If `ca_pem` is specified, review
     * [RegisterCertificate](https://docs.aws.amazon.com/iot/latest/apireference/API_RegisterCertificate.html)
     * for more information on registering a certificate.
     * 
     */
    @Export(name="certificatePem", refs={String.class}, tree="[0]")
    private Output<String> certificatePem;

    /**
     * @return The certificate to be registered. If `ca_pem` is unspecified, review
     * [RegisterCertificateWithoutCA](https://docs.aws.amazon.com/iot/latest/apireference/API_RegisterCertificateWithoutCA.html).
     * If `ca_pem` is specified, review
     * [RegisterCertificate](https://docs.aws.amazon.com/iot/latest/apireference/API_RegisterCertificate.html)
     * for more information on registering a certificate.
     * 
     */
    public Output<String> certificatePem() {
        return this.certificatePem;
    }
    /**
     * The certificate signing request. Review
     * [CreateCertificateFromCsr](https://docs.aws.amazon.com/iot/latest/apireference/API_CreateCertificateFromCsr.html)
     * for more information on generating a certificate from a certificate signing request (CSR).
     * If none is specified both the certificate and keys will be generated, review [CreateKeysAndCertificate](https://docs.aws.amazon.com/iot/latest/apireference/API_CreateKeysAndCertificate.html)
     * for more information on generating keys and a certificate.
     * 
     */
    @Export(name="csr", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> csr;

    /**
     * @return The certificate signing request. Review
     * [CreateCertificateFromCsr](https://docs.aws.amazon.com/iot/latest/apireference/API_CreateCertificateFromCsr.html)
     * for more information on generating a certificate from a certificate signing request (CSR).
     * If none is specified both the certificate and keys will be generated, review [CreateKeysAndCertificate](https://docs.aws.amazon.com/iot/latest/apireference/API_CreateKeysAndCertificate.html)
     * for more information on generating keys and a certificate.
     * 
     */
    public Output<Optional<String>> csr() {
        return Codegen.optional(this.csr);
    }
    /**
     * When neither CSR nor certificate is provided, the private key.
     * 
     */
    @Export(name="privateKey", refs={String.class}, tree="[0]")
    private Output<String> privateKey;

    /**
     * @return When neither CSR nor certificate is provided, the private key.
     * 
     */
    public Output<String> privateKey() {
        return this.privateKey;
    }
    /**
     * When neither CSR nor certificate is provided, the public key.
     * 
     */
    @Export(name="publicKey", refs={String.class}, tree="[0]")
    private Output<String> publicKey;

    /**
     * @return When neither CSR nor certificate is provided, the public key.
     * 
     */
    public Output<String> publicKey() {
        return this.publicKey;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Certificate(java.lang.String name) {
        this(name, CertificateArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Certificate(java.lang.String name, CertificateArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Certificate(java.lang.String name, CertificateArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iot/certificate:Certificate", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Certificate(java.lang.String name, Output<java.lang.String> id, @Nullable CertificateState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iot/certificate:Certificate", name, state, makeResourceOptions(options, id), false);
    }

    private static CertificateArgs makeArgs(CertificateArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? CertificateArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .additionalSecretOutputs(List.of(
                "caPem",
                "certificatePem",
                "privateKey",
                "publicKey"
            ))
            .build();
        return com.pulumi.resources.CustomResourceOptions.merge(defaultOptions, options, id);
    }

    /**
     * Get an existing Host resource's state with the given name, ID, and optional extra
     * properties used to qualify the lookup.
     *
     * @param name The _unique_ name of the resulting resource.
     * @param id The _unique_ provider ID of the resource to lookup.
     * @param state
     * @param options Optional settings to control the behavior of the CustomResource.
     */
    public static Certificate get(java.lang.String name, Output<java.lang.String> id, @Nullable CertificateState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Certificate(name, id, state, options);
    }
}
