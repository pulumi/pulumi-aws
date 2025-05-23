// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.iot;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.iot.DomainConfigurationArgs;
import com.pulumi.aws.iot.inputs.DomainConfigurationState;
import com.pulumi.aws.iot.outputs.DomainConfigurationAuthorizerConfig;
import com.pulumi.aws.iot.outputs.DomainConfigurationTlsConfig;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Creates and manages an AWS IoT domain configuration.
 * 
 * ## Example Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.iot.DomainConfiguration;
 * import com.pulumi.aws.iot.DomainConfigurationArgs;
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
 *         var iot = new DomainConfiguration("iot", DomainConfigurationArgs.builder()
 *             .name("iot-")
 *             .domainName("iot.example.com")
 *             .serviceType("DATA")
 *             .serverCertificateArns(cert.arn())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import domain configurations using the name. For example:
 * 
 * ```sh
 * $ pulumi import aws:iot/domainConfiguration:DomainConfiguration example example
 * ```
 * 
 */
@ResourceType(type="aws:iot/domainConfiguration:DomainConfiguration")
public class DomainConfiguration extends com.pulumi.resources.CustomResource {
    /**
     * An enumerated string that speciﬁes the application-layer protocol. Valid values are `SECURE_MQTT`, `MQTT_WSS`, `HTTPS` or `DEFAULT`.
     * 
     */
    @Export(name="applicationProtocol", refs={String.class}, tree="[0]")
    private Output<String> applicationProtocol;

    /**
     * @return An enumerated string that speciﬁes the application-layer protocol. Valid values are `SECURE_MQTT`, `MQTT_WSS`, `HTTPS` or `DEFAULT`.
     * 
     */
    public Output<String> applicationProtocol() {
        return this.applicationProtocol;
    }
    /**
     * The ARN of the domain configuration.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the domain configuration.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * An enumerated string that speciﬁes the authentication type. Valid values are `CUSTOM_AUTH_X509`, `CUSTOM_AUTH`, `AWS_X509`, `AWS_SIGV4` or `DEFAULT`.
     * 
     */
    @Export(name="authenticationType", refs={String.class}, tree="[0]")
    private Output<String> authenticationType;

    /**
     * @return An enumerated string that speciﬁes the authentication type. Valid values are `CUSTOM_AUTH_X509`, `CUSTOM_AUTH`, `AWS_X509`, `AWS_SIGV4` or `DEFAULT`.
     * 
     */
    public Output<String> authenticationType() {
        return this.authenticationType;
    }
    /**
     * An object that specifies the authorization service for a domain. See the `authorizer_config` Block below for details.
     * 
     */
    @Export(name="authorizerConfig", refs={DomainConfigurationAuthorizerConfig.class}, tree="[0]")
    private Output</* @Nullable */ DomainConfigurationAuthorizerConfig> authorizerConfig;

    /**
     * @return An object that specifies the authorization service for a domain. See the `authorizer_config` Block below for details.
     * 
     */
    public Output<Optional<DomainConfigurationAuthorizerConfig>> authorizerConfig() {
        return Codegen.optional(this.authorizerConfig);
    }
    /**
     * Fully-qualified domain name.
     * 
     */
    @Export(name="domainName", refs={String.class}, tree="[0]")
    private Output<String> domainName;

    /**
     * @return Fully-qualified domain name.
     * 
     */
    public Output<String> domainName() {
        return this.domainName;
    }
    /**
     * The type of the domain.
     * 
     */
    @Export(name="domainType", refs={String.class}, tree="[0]")
    private Output<String> domainType;

    /**
     * @return The type of the domain.
     * 
     */
    public Output<String> domainType() {
        return this.domainType;
    }
    /**
     * The name of the domain configuration. This value must be unique to a region.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the domain configuration. This value must be unique to a region.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The ARNs of the certificates that IoT passes to the device during the TLS handshake. Currently you can specify only one certificate ARN. This value is not required for Amazon Web Services-managed domains. When using a custom `domain_name`, the cert must include it.
     * 
     */
    @Export(name="serverCertificateArns", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> serverCertificateArns;

    /**
     * @return The ARNs of the certificates that IoT passes to the device during the TLS handshake. Currently you can specify only one certificate ARN. This value is not required for Amazon Web Services-managed domains. When using a custom `domain_name`, the cert must include it.
     * 
     */
    public Output<Optional<List<String>>> serverCertificateArns() {
        return Codegen.optional(this.serverCertificateArns);
    }
    /**
     * The type of service delivered by the endpoint. Note: Amazon Web Services IoT Core currently supports only the `DATA` service type.
     * 
     */
    @Export(name="serviceType", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> serviceType;

    /**
     * @return The type of service delivered by the endpoint. Note: Amazon Web Services IoT Core currently supports only the `DATA` service type.
     * 
     */
    public Output<Optional<String>> serviceType() {
        return Codegen.optional(this.serviceType);
    }
    /**
     * The status to which the domain configuration should be set. Valid values are `ENABLED` and `DISABLED`.
     * 
     */
    @Export(name="status", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> status;

    /**
     * @return The status to which the domain configuration should be set. Valid values are `ENABLED` and `DISABLED`.
     * 
     */
    public Output<Optional<String>> status() {
        return Codegen.optional(this.status);
    }
    /**
     * Map of tags to assign to this resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to this resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return A map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * An object that specifies the TLS configuration for a domain. See the `tls_config` Block below for details.
     * 
     */
    @Export(name="tlsConfig", refs={DomainConfigurationTlsConfig.class}, tree="[0]")
    private Output<DomainConfigurationTlsConfig> tlsConfig;

    /**
     * @return An object that specifies the TLS configuration for a domain. See the `tls_config` Block below for details.
     * 
     */
    public Output<DomainConfigurationTlsConfig> tlsConfig() {
        return this.tlsConfig;
    }
    /**
     * The certificate used to validate the server certificate and prove domain name ownership. This certificate must be signed by a public certificate authority. This value is not required for Amazon Web Services-managed domains.
     * 
     */
    @Export(name="validationCertificateArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> validationCertificateArn;

    /**
     * @return The certificate used to validate the server certificate and prove domain name ownership. This certificate must be signed by a public certificate authority. This value is not required for Amazon Web Services-managed domains.
     * 
     */
    public Output<Optional<String>> validationCertificateArn() {
        return Codegen.optional(this.validationCertificateArn);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public DomainConfiguration(java.lang.String name) {
        this(name, DomainConfigurationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DomainConfiguration(java.lang.String name, @Nullable DomainConfigurationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DomainConfiguration(java.lang.String name, @Nullable DomainConfigurationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iot/domainConfiguration:DomainConfiguration", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DomainConfiguration(java.lang.String name, Output<java.lang.String> id, @Nullable DomainConfigurationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:iot/domainConfiguration:DomainConfiguration", name, state, makeResourceOptions(options, id), false);
    }

    private static DomainConfigurationArgs makeArgs(@Nullable DomainConfigurationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DomainConfigurationArgs.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
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
    public static DomainConfiguration get(java.lang.String name, Output<java.lang.String> id, @Nullable DomainConfigurationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DomainConfiguration(name, id, state, options);
    }
}
