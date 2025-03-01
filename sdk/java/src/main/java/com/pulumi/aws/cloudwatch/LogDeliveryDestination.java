// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudwatch.LogDeliveryDestinationArgs;
import com.pulumi.aws.cloudwatch.inputs.LogDeliveryDestinationState;
import com.pulumi.aws.cloudwatch.outputs.LogDeliveryDestinationDeliveryDestinationConfiguration;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS CloudWatch Logs Delivery Destination.
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
 * import com.pulumi.aws.cloudwatch.LogDeliveryDestination;
 * import com.pulumi.aws.cloudwatch.LogDeliveryDestinationArgs;
 * import com.pulumi.aws.cloudwatch.inputs.LogDeliveryDestinationDeliveryDestinationConfigurationArgs;
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
 *         var example = new LogDeliveryDestination("example", LogDeliveryDestinationArgs.builder()
 *             .name("example")
 *             .deliveryDestinationConfiguration(LogDeliveryDestinationDeliveryDestinationConfigurationArgs.builder()
 *                 .destinationResourceArn(exampleAwsCloudwatchLogGroup.arn())
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
 * Using `pulumi import`, import CloudWatch Logs Delivery Destination using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudwatch/logDeliveryDestination:LogDeliveryDestination example example
 * ```
 * 
 */
@ResourceType(type="aws:cloudwatch/logDeliveryDestination:LogDeliveryDestination")
public class LogDeliveryDestination extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the delivery destination.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the delivery destination.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The AWS resource that will receive the logs.
     * 
     */
    @Export(name="deliveryDestinationConfiguration", refs={LogDeliveryDestinationDeliveryDestinationConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ LogDeliveryDestinationDeliveryDestinationConfiguration> deliveryDestinationConfiguration;

    /**
     * @return The AWS resource that will receive the logs.
     * 
     */
    public Output<Optional<LogDeliveryDestinationDeliveryDestinationConfiguration>> deliveryDestinationConfiguration() {
        return Codegen.optional(this.deliveryDestinationConfiguration);
    }
    /**
     * Whether this delivery destination is CloudWatch Logs, Amazon S3, or Firehose.
     * 
     */
    @Export(name="deliveryDestinationType", refs={String.class}, tree="[0]")
    private Output<String> deliveryDestinationType;

    /**
     * @return Whether this delivery destination is CloudWatch Logs, Amazon S3, or Firehose.
     * 
     */
    public Output<String> deliveryDestinationType() {
        return this.deliveryDestinationType;
    }
    /**
     * The name for this delivery destination.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name for this delivery destination.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The format of the logs that are sent to this delivery destination. Valid values: `json`, `plain`, `w3c`, `raw`, `parquet`.
     * 
     */
    @Export(name="outputFormat", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> outputFormat;

    /**
     * @return The format of the logs that are sent to this delivery destination. Valid values: `json`, `plain`, `w3c`, `raw`, `parquet`.
     * 
     */
    public Output<Optional<String>> outputFormat() {
        return Codegen.optional(this.outputFormat);
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
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public LogDeliveryDestination(java.lang.String name) {
        this(name, LogDeliveryDestinationArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LogDeliveryDestination(java.lang.String name, @Nullable LogDeliveryDestinationArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LogDeliveryDestination(java.lang.String name, @Nullable LogDeliveryDestinationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/logDeliveryDestination:LogDeliveryDestination", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LogDeliveryDestination(java.lang.String name, Output<java.lang.String> id, @Nullable LogDeliveryDestinationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/logDeliveryDestination:LogDeliveryDestination", name, state, makeResourceOptions(options, id), false);
    }

    private static LogDeliveryDestinationArgs makeArgs(@Nullable LogDeliveryDestinationArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LogDeliveryDestinationArgs.Empty : args;
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
    public static LogDeliveryDestination get(java.lang.String name, Output<java.lang.String> id, @Nullable LogDeliveryDestinationState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LogDeliveryDestination(name, id, state, options);
    }
}
