// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.oam;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.oam.LinkArgs;
import com.pulumi.aws.oam.inputs.LinkState;
import com.pulumi.aws.oam.outputs.LinkLinkConfiguration;
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
 * Resource for managing an AWS CloudWatch Observability Access Manager Link.
 * 
 * &gt; **NOTE:** Creating an `aws.oam.Link` may sometimes fail if the `aws.oam.SinkPolicy` for the attached `aws.oam.Sink` is not created before the `aws.oam.Link`. To prevent this, declare an explicit dependency using a `depends_on` meta-argument.
 * 
 * ## Example Usage
 * 
 * ### Basic Usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.oam.Sink;
 * import com.pulumi.aws.oam.SinkPolicy;
 * import com.pulumi.aws.oam.SinkPolicyArgs;
 * import com.pulumi.aws.oam.Link;
 * import com.pulumi.aws.oam.LinkArgs;
 * import com.pulumi.resources.CustomResourceOptions;
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
 *         var exampleSink = new Sink("exampleSink");
 * 
 *         var exampleSinkPolicy = new SinkPolicy("exampleSinkPolicy", SinkPolicyArgs.builder()
 *             .sinkIdentifier(exampleSink.arn())
 *             .build());
 * 
 *         var example = new Link("example", LinkArgs.builder()
 *             .labelTemplate("$AccountName")
 *             .resourceTypes("AWS::CloudWatch::Metric")
 *             .sinkIdentifier(exampleSink.arn())
 *             .tags(Map.of("Env", "prod"))
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleSinkPolicy)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Log Group Filtering
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.oam.Link;
 * import com.pulumi.aws.oam.LinkArgs;
 * import com.pulumi.aws.oam.inputs.LinkLinkConfigurationArgs;
 * import com.pulumi.aws.oam.inputs.LinkLinkConfigurationLogGroupConfigurationArgs;
 * import com.pulumi.resources.CustomResourceOptions;
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
 *         var example = new Link("example", LinkArgs.builder()
 *             .labelTemplate("$AccountName")
 *             .linkConfiguration(LinkLinkConfigurationArgs.builder()
 *                 .logGroupConfiguration(LinkLinkConfigurationLogGroupConfigurationArgs.builder()
 *                     .filter("LogGroupName LIKE 'aws/lambda/%' OR LogGroupName LIKE 'AWSLogs%'")
 *                     .build())
 *                 .build())
 *             .resourceTypes("AWS::Logs::LogGroup")
 *             .sinkIdentifier(exampleAwsOamSink.arn())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAwsOamSinkPolicy)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Metric Filtering
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.oam.Link;
 * import com.pulumi.aws.oam.LinkArgs;
 * import com.pulumi.aws.oam.inputs.LinkLinkConfigurationArgs;
 * import com.pulumi.aws.oam.inputs.LinkLinkConfigurationMetricConfigurationArgs;
 * import com.pulumi.resources.CustomResourceOptions;
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
 *         var example = new Link("example", LinkArgs.builder()
 *             .labelTemplate("$AccountName")
 *             .linkConfiguration(LinkLinkConfigurationArgs.builder()
 *                 .metricConfiguration(LinkLinkConfigurationMetricConfigurationArgs.builder()
 *                     .filter("Namespace IN ('AWS/EC2', 'AWS/ELB', 'AWS/S3')")
 *                     .build())
 *                 .build())
 *             .resourceTypes("AWS::CloudWatch::Metric")
 *             .sinkIdentifier(exampleAwsOamSink.arn())
 *             .build(), CustomResourceOptions.builder()
 *                 .dependsOn(exampleAwsOamSinkPolicy)
 *                 .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ## Import
 * 
 * Using `pulumi import`, import CloudWatch Observability Access Manager Link using the `arn`. For example:
 * 
 * ```sh
 * $ pulumi import aws:oam/link:Link example arn:aws:oam:us-west-2:123456789012:link/link-id
 * ```
 * 
 */
@ResourceType(type="aws:oam/link:Link")
public class Link extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the link.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the link.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Label that is assigned to this link.
     * 
     */
    @Export(name="label", refs={String.class}, tree="[0]")
    private Output<String> label;

    /**
     * @return Label that is assigned to this link.
     * 
     */
    public Output<String> label() {
        return this.label;
    }
    /**
     * Human-readable name to use to identify this source account when you are viewing data from it in the monitoring account.
     * 
     */
    @Export(name="labelTemplate", refs={String.class}, tree="[0]")
    private Output<String> labelTemplate;

    /**
     * @return Human-readable name to use to identify this source account when you are viewing data from it in the monitoring account.
     * 
     */
    public Output<String> labelTemplate() {
        return this.labelTemplate;
    }
    /**
     * Configuration for creating filters that specify that only some metric namespaces or log groups are to be shared from the source account to the monitoring account. See `link_configuration` Block for details.
     * 
     */
    @Export(name="linkConfiguration", refs={LinkLinkConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ LinkLinkConfiguration> linkConfiguration;

    /**
     * @return Configuration for creating filters that specify that only some metric namespaces or log groups are to be shared from the source account to the monitoring account. See `link_configuration` Block for details.
     * 
     */
    public Output<Optional<LinkLinkConfiguration>> linkConfiguration() {
        return Codegen.optional(this.linkConfiguration);
    }
    /**
     * ID string that AWS generated as part of the link ARN.
     * 
     */
    @Export(name="linkId", refs={String.class}, tree="[0]")
    private Output<String> linkId;

    /**
     * @return ID string that AWS generated as part of the link ARN.
     * 
     */
    public Output<String> linkId() {
        return this.linkId;
    }
    /**
     * Types of data that the source account shares with the monitoring account.
     * 
     */
    @Export(name="resourceTypes", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> resourceTypes;

    /**
     * @return Types of data that the source account shares with the monitoring account.
     * 
     */
    public Output<List<String>> resourceTypes() {
        return this.resourceTypes;
    }
    /**
     * ARN of the sink that is used for this link.
     * 
     */
    @Export(name="sinkArn", refs={String.class}, tree="[0]")
    private Output<String> sinkArn;

    /**
     * @return ARN of the sink that is used for this link.
     * 
     */
    public Output<String> sinkArn() {
        return this.sinkArn;
    }
    /**
     * Identifier of the sink to use to create this link.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="sinkIdentifier", refs={String.class}, tree="[0]")
    private Output<String> sinkIdentifier;

    /**
     * @return Identifier of the sink to use to create this link.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> sinkIdentifier() {
        return this.sinkIdentifier;
    }
    /**
     * A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Link(java.lang.String name) {
        this(name, LinkArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Link(java.lang.String name, LinkArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Link(java.lang.String name, LinkArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:oam/link:Link", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Link(java.lang.String name, Output<java.lang.String> id, @Nullable LinkState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:oam/link:Link", name, state, makeResourceOptions(options, id), false);
    }

    private static LinkArgs makeArgs(LinkArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LinkArgs.Empty : args;
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
    public static Link get(java.lang.String name, Output<java.lang.String> id, @Nullable LinkState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Link(name, id, state, options);
    }
}
