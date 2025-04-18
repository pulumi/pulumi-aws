// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.apigatewayv2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.apigatewayv2.DomainNameArgs;
import com.pulumi.aws.apigatewayv2.inputs.DomainNameState;
import com.pulumi.aws.apigatewayv2.outputs.DomainNameDomainNameConfiguration;
import com.pulumi.aws.apigatewayv2.outputs.DomainNameMutualTlsAuthentication;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages an Amazon API Gateway Version 2 domain name.
 * More information can be found in the [Amazon API Gateway Developer Guide](https://docs.aws.amazon.com/apigateway/latest/developerguide/how-to-custom-domains.html).
 * 
 * &gt; **Note:** This resource establishes ownership of and the TLS settings for
 * a particular domain name. An API stage can be associated with the domain name using the `aws.apigatewayv2.ApiMapping` resource.
 * 
 * ## Example Usage
 * 
 * ### Basic
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.apigatewayv2.DomainName;
 * import com.pulumi.aws.apigatewayv2.DomainNameArgs;
 * import com.pulumi.aws.apigatewayv2.inputs.DomainNameDomainNameConfigurationArgs;
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
 *         var example = new DomainName("example", DomainNameArgs.builder()
 *             .domainName("ws-api.example.com")
 *             .domainNameConfiguration(DomainNameDomainNameConfigurationArgs.builder()
 *                 .certificateArn(exampleAwsAcmCertificate.arn())
 *                 .endpointType("REGIONAL")
 *                 .securityPolicy("TLS_1_2")
 *                 .build())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Associated Route 53 Resource Record
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.apigatewayv2.DomainName;
 * import com.pulumi.aws.apigatewayv2.DomainNameArgs;
 * import com.pulumi.aws.apigatewayv2.inputs.DomainNameDomainNameConfigurationArgs;
 * import com.pulumi.aws.route53.Record;
 * import com.pulumi.aws.route53.RecordArgs;
 * import com.pulumi.aws.route53.inputs.RecordAliasArgs;
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
 *         var example = new DomainName("example", DomainNameArgs.builder()
 *             .domainName("http-api.example.com")
 *             .domainNameConfiguration(DomainNameDomainNameConfigurationArgs.builder()
 *                 .certificateArn(exampleAwsAcmCertificate.arn())
 *                 .endpointType("REGIONAL")
 *                 .securityPolicy("TLS_1_2")
 *                 .build())
 *             .build());
 * 
 *         var exampleRecord = new Record("exampleRecord", RecordArgs.builder()
 *             .name(example.domainName())
 *             .type("A")
 *             .zoneId(exampleAwsRoute53Zone.zoneId())
 *             .aliases(RecordAliasArgs.builder()
 *                 .name(example.domainNameConfiguration().applyValue(_domainNameConfiguration -> _domainNameConfiguration.targetDomainName()))
 *                 .zoneId(example.domainNameConfiguration().applyValue(_domainNameConfiguration -> _domainNameConfiguration.hostedZoneId()))
 *                 .evaluateTargetHealth(false)
 *                 .build())
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
 * Using `pulumi import`, import `aws_apigatewayv2_domain_name` using the domain name. For example:
 * 
 * ```sh
 * $ pulumi import aws:apigatewayv2/domainName:DomainName example ws-api.example.com
 * ```
 * 
 */
@ResourceType(type="aws:apigatewayv2/domainName:DomainName")
public class DomainName extends com.pulumi.resources.CustomResource {
    /**
     * [API mapping selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-mapping-selection-expressions) for the domain name.
     * 
     */
    @Export(name="apiMappingSelectionExpression", refs={String.class}, tree="[0]")
    private Output<String> apiMappingSelectionExpression;

    /**
     * @return [API mapping selection expression](https://docs.aws.amazon.com/apigateway/latest/developerguide/apigateway-websocket-api-selection-expressions.html#apigateway-websocket-api-mapping-selection-expressions) for the domain name.
     * 
     */
    public Output<String> apiMappingSelectionExpression() {
        return this.apiMappingSelectionExpression;
    }
    /**
     * ARN of the domain name.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the domain name.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Domain name. Must be between 1 and 512 characters in length.
     * 
     */
    @Export(name="domainName", refs={String.class}, tree="[0]")
    private Output<String> domainName;

    /**
     * @return Domain name. Must be between 1 and 512 characters in length.
     * 
     */
    public Output<String> domainName() {
        return this.domainName;
    }
    /**
     * Domain name configuration. See below.
     * 
     */
    @Export(name="domainNameConfiguration", refs={DomainNameDomainNameConfiguration.class}, tree="[0]")
    private Output<DomainNameDomainNameConfiguration> domainNameConfiguration;

    /**
     * @return Domain name configuration. See below.
     * 
     */
    public Output<DomainNameDomainNameConfiguration> domainNameConfiguration() {
        return this.domainNameConfiguration;
    }
    /**
     * Mutual TLS authentication configuration for the domain name.
     * 
     */
    @Export(name="mutualTlsAuthentication", refs={DomainNameMutualTlsAuthentication.class}, tree="[0]")
    private Output</* @Nullable */ DomainNameMutualTlsAuthentication> mutualTlsAuthentication;

    /**
     * @return Mutual TLS authentication configuration for the domain name.
     * 
     */
    public Output<Optional<DomainNameMutualTlsAuthentication>> mutualTlsAuthentication() {
        return Codegen.optional(this.mutualTlsAuthentication);
    }
    /**
     * Map of tags to assign to the domain name. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the domain name. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    /**
     * @return Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
     * 
     */
    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public DomainName(java.lang.String name) {
        this(name, DomainNameArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DomainName(java.lang.String name, DomainNameArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DomainName(java.lang.String name, DomainNameArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigatewayv2/domainName:DomainName", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DomainName(java.lang.String name, Output<java.lang.String> id, @Nullable DomainNameState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:apigatewayv2/domainName:DomainName", name, state, makeResourceOptions(options, id), false);
    }

    private static DomainNameArgs makeArgs(DomainNameArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DomainNameArgs.Empty : args;
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
    public static DomainName get(java.lang.String name, Output<java.lang.String> id, @Nullable DomainNameState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DomainName(name, id, state, options);
    }
}
