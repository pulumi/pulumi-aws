// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedaccess;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.verifiedaccess.EndpointArgs;
import com.pulumi.aws.verifiedaccess.inputs.EndpointState;
import com.pulumi.aws.verifiedaccess.outputs.EndpointCidrOptions;
import com.pulumi.aws.verifiedaccess.outputs.EndpointLoadBalancerOptions;
import com.pulumi.aws.verifiedaccess.outputs.EndpointNetworkInterfaceOptions;
import com.pulumi.aws.verifiedaccess.outputs.EndpointRdsOptions;
import com.pulumi.aws.verifiedaccess.outputs.EndpointSseSpecification;
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
 * Resource for managing an AWS EC2 (Elastic Compute Cloud) Verified Access Endpoint.
 * 
 * ## Example Usage
 * 
 * ### ALB Example
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Network Interface Example
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.verifiedaccess.Endpoint;
 * import com.pulumi.aws.verifiedaccess.EndpointArgs;
 * import com.pulumi.aws.verifiedaccess.inputs.EndpointNetworkInterfaceOptionsArgs;
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
 *         var example = new Endpoint("example", EndpointArgs.builder()
 *             .applicationDomain("example.com")
 *             .attachmentType("vpc")
 *             .description("example")
 *             .domainCertificateArn(exampleAwsAcmCertificate.arn())
 *             .endpointDomainPrefix("example")
 *             .endpointType("network-interface")
 *             .networkInterfaceOptions(EndpointNetworkInterfaceOptionsArgs.builder()
 *                 .networkInterfaceId(exampleAwsNetworkInterface.id())
 *                 .port(443)
 *                 .protocol("https")
 *                 .build())
 *             .securityGroupIds(exampleAwsSecurityGroup.id())
 *             .verifiedAccessGroupId(exampleAwsVerifiedaccessGroup.id())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Cidr Example
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import Verified Access Instances using the  `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:verifiedaccess/endpoint:Endpoint example vae-8012925589
 * ```
 * 
 */
@ResourceType(type="aws:verifiedaccess/endpoint:Endpoint")
public class Endpoint extends com.pulumi.resources.CustomResource {
    /**
     * The DNS name for users to reach your application. This parameter is required if the endpoint type is `load-balancer` or `network-interface`.
     * 
     */
    @Export(name="applicationDomain", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> applicationDomain;

    /**
     * @return The DNS name for users to reach your application. This parameter is required if the endpoint type is `load-balancer` or `network-interface`.
     * 
     */
    public Output<Optional<String>> applicationDomain() {
        return Codegen.optional(this.applicationDomain);
    }
    /**
     * The type of attachment. Currently, only `vpc` is supported.
     * 
     */
    @Export(name="attachmentType", refs={String.class}, tree="[0]")
    private Output<String> attachmentType;

    /**
     * @return The type of attachment. Currently, only `vpc` is supported.
     * 
     */
    public Output<String> attachmentType() {
        return this.attachmentType;
    }
    /**
     * The CIDR block details. This parameter is required if the endpoint type is `cidr`.
     * 
     */
    @Export(name="cidrOptions", refs={EndpointCidrOptions.class}, tree="[0]")
    private Output</* @Nullable */ EndpointCidrOptions> cidrOptions;

    /**
     * @return The CIDR block details. This parameter is required if the endpoint type is `cidr`.
     * 
     */
    public Output<Optional<EndpointCidrOptions>> cidrOptions() {
        return Codegen.optional(this.cidrOptions);
    }
    /**
     * A description for the Verified Access endpoint.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return A description for the Verified Access endpoint.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Returned if endpoint has a device trust provider attached.
     * 
     */
    @Export(name="deviceValidationDomain", refs={String.class}, tree="[0]")
    private Output<String> deviceValidationDomain;

    /**
     * @return Returned if endpoint has a device trust provider attached.
     * 
     */
    public Output<String> deviceValidationDomain() {
        return this.deviceValidationDomain;
    }
    /**
     * The ARN of the public TLS/SSL certificate in AWS Certificate Manager to associate with the endpoint. The CN in the certificate must match the DNS name your end users will use to reach your application. This parameter is required if the endpoint type is `load-balancer` or `network-interface`.
     * 
     */
    @Export(name="domainCertificateArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> domainCertificateArn;

    /**
     * @return The ARN of the public TLS/SSL certificate in AWS Certificate Manager to associate with the endpoint. The CN in the certificate must match the DNS name your end users will use to reach your application. This parameter is required if the endpoint type is `load-balancer` or `network-interface`.
     * 
     */
    public Output<Optional<String>> domainCertificateArn() {
        return Codegen.optional(this.domainCertificateArn);
    }
    /**
     * A DNS name that is generated for the endpoint.
     * 
     */
    @Export(name="endpointDomain", refs={String.class}, tree="[0]")
    private Output<String> endpointDomain;

    /**
     * @return A DNS name that is generated for the endpoint.
     * 
     */
    public Output<String> endpointDomain() {
        return this.endpointDomain;
    }
    /**
     * A custom identifier that is prepended to the DNS name that is generated for the endpoint.
     * 
     */
    @Export(name="endpointDomainPrefix", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> endpointDomainPrefix;

    /**
     * @return A custom identifier that is prepended to the DNS name that is generated for the endpoint.
     * 
     */
    public Output<Optional<String>> endpointDomainPrefix() {
        return Codegen.optional(this.endpointDomainPrefix);
    }
    /**
     * The type of Verified Access endpoint to create. Currently `load-balancer` or `network-interface` are supported.
     * 
     */
    @Export(name="endpointType", refs={String.class}, tree="[0]")
    private Output<String> endpointType;

    /**
     * @return The type of Verified Access endpoint to create. Currently `load-balancer` or `network-interface` are supported.
     * 
     */
    public Output<String> endpointType() {
        return this.endpointType;
    }
    /**
     * The load balancer details. This parameter is required if the endpoint type is `load-balancer`.
     * 
     */
    @Export(name="loadBalancerOptions", refs={EndpointLoadBalancerOptions.class}, tree="[0]")
    private Output</* @Nullable */ EndpointLoadBalancerOptions> loadBalancerOptions;

    /**
     * @return The load balancer details. This parameter is required if the endpoint type is `load-balancer`.
     * 
     */
    public Output<Optional<EndpointLoadBalancerOptions>> loadBalancerOptions() {
        return Codegen.optional(this.loadBalancerOptions);
    }
    /**
     * The network interface details. This parameter is required if the endpoint type is `network-interface`.
     * 
     */
    @Export(name="networkInterfaceOptions", refs={EndpointNetworkInterfaceOptions.class}, tree="[0]")
    private Output</* @Nullable */ EndpointNetworkInterfaceOptions> networkInterfaceOptions;

    /**
     * @return The network interface details. This parameter is required if the endpoint type is `network-interface`.
     * 
     */
    public Output<Optional<EndpointNetworkInterfaceOptions>> networkInterfaceOptions() {
        return Codegen.optional(this.networkInterfaceOptions);
    }
    /**
     * The policy document that is associated with this resource.
     * 
     */
    @Export(name="policyDocument", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> policyDocument;

    /**
     * @return The policy document that is associated with this resource.
     * 
     */
    public Output<Optional<String>> policyDocument() {
        return Codegen.optional(this.policyDocument);
    }
    @Export(name="rdsOptions", refs={EndpointRdsOptions.class}, tree="[0]")
    private Output</* @Nullable */ EndpointRdsOptions> rdsOptions;

    public Output<Optional<EndpointRdsOptions>> rdsOptions() {
        return Codegen.optional(this.rdsOptions);
    }
    /**
     * List of the the security groups IDs to associate with the Verified Access endpoint.
     * 
     */
    @Export(name="securityGroupIds", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> securityGroupIds;

    /**
     * @return List of the the security groups IDs to associate with the Verified Access endpoint.
     * 
     */
    public Output<Optional<List<String>>> securityGroupIds() {
        return Codegen.optional(this.securityGroupIds);
    }
    /**
     * The options in use for server side encryption.
     * 
     */
    @Export(name="sseSpecification", refs={EndpointSseSpecification.class}, tree="[0]")
    private Output<EndpointSseSpecification> sseSpecification;

    /**
     * @return The options in use for server side encryption.
     * 
     */
    public Output<EndpointSseSpecification> sseSpecification() {
        return this.sseSpecification;
    }
    /**
     * Key-value tags for the Verified Access Endpoint. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value tags for the Verified Access Endpoint. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * The ID of the Verified Access group to associate the endpoint with.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="verifiedAccessGroupId", refs={String.class}, tree="[0]")
    private Output<String> verifiedAccessGroupId;

    /**
     * @return The ID of the Verified Access group to associate the endpoint with.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> verifiedAccessGroupId() {
        return this.verifiedAccessGroupId;
    }
    @Export(name="verifiedAccessInstanceId", refs={String.class}, tree="[0]")
    private Output<String> verifiedAccessInstanceId;

    public Output<String> verifiedAccessInstanceId() {
        return this.verifiedAccessInstanceId;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Endpoint(java.lang.String name) {
        this(name, EndpointArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Endpoint(java.lang.String name, EndpointArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Endpoint(java.lang.String name, EndpointArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:verifiedaccess/endpoint:Endpoint", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Endpoint(java.lang.String name, Output<java.lang.String> id, @Nullable EndpointState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:verifiedaccess/endpoint:Endpoint", name, state, makeResourceOptions(options, id), false);
    }

    private static EndpointArgs makeArgs(EndpointArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? EndpointArgs.Empty : args;
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
    public static Endpoint get(java.lang.String name, Output<java.lang.String> id, @Nullable EndpointState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Endpoint(name, id, state, options);
    }
}
