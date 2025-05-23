// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudwatch.EventBusArgs;
import com.pulumi.aws.cloudwatch.inputs.EventBusState;
import com.pulumi.aws.cloudwatch.outputs.EventBusDeadLetterConfig;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides an EventBridge event bus resource.
 * 
 * &gt; **Note:** EventBridge was formerly known as CloudWatch Events. The functionality is identical.
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
 * import com.pulumi.aws.cloudwatch.EventBus;
 * import com.pulumi.aws.cloudwatch.EventBusArgs;
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
 *         var messenger = new EventBus("messenger", EventBusArgs.builder()
 *             .name("chat-messages")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.cloudwatch.CloudwatchFunctions;
 * import com.pulumi.aws.cloudwatch.inputs.GetEventSourceArgs;
 * import com.pulumi.aws.cloudwatch.EventBus;
 * import com.pulumi.aws.cloudwatch.EventBusArgs;
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
 *         final var examplepartner = CloudwatchFunctions.getEventSource(GetEventSourceArgs.builder()
 *             .namePrefix("aws.partner/examplepartner.com")
 *             .build());
 * 
 *         var examplepartnerEventBus = new EventBus("examplepartnerEventBus", EventBusArgs.builder()
 *             .name(examplepartner.name())
 *             .description("Event bus for example partner events")
 *             .eventSourceName(examplepartner.name())
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
 * Using `pulumi import`, import EventBridge event buses using the name of the event bus (which can also be a partner event source name). For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudwatch/eventBus:EventBus messenger chat-messages
 * ```
 * 
 */
@ResourceType(type="aws:cloudwatch/eventBus:EventBus")
public class EventBus extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the event bus.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the event bus.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Configuration details of the Amazon SQS queue for EventBridge to use as a dead-letter queue (DLQ). This block supports the following arguments:
     * 
     */
    @Export(name="deadLetterConfig", refs={EventBusDeadLetterConfig.class}, tree="[0]")
    private Output</* @Nullable */ EventBusDeadLetterConfig> deadLetterConfig;

    /**
     * @return Configuration details of the Amazon SQS queue for EventBridge to use as a dead-letter queue (DLQ). This block supports the following arguments:
     * 
     */
    public Output<Optional<EventBusDeadLetterConfig>> deadLetterConfig() {
        return Codegen.optional(this.deadLetterConfig);
    }
    /**
     * Event bus description.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Event bus description.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Partner event source that the new event bus will be matched with. Must match `name`.
     * 
     */
    @Export(name="eventSourceName", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> eventSourceName;

    /**
     * @return Partner event source that the new event bus will be matched with. Must match `name`.
     * 
     */
    public Output<Optional<String>> eventSourceName() {
        return Codegen.optional(this.eventSourceName);
    }
    /**
     * Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt events on this event bus. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN.
     * 
     */
    @Export(name="kmsKeyIdentifier", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> kmsKeyIdentifier;

    /**
     * @return Identifier of the AWS KMS customer managed key for EventBridge to use, if you choose to use a customer managed key to encrypt events on this event bus. The identifier can be the key Amazon Resource Name (ARN), KeyId, key alias, or key alias ARN.
     * 
     */
    public Output<Optional<String>> kmsKeyIdentifier() {
        return Codegen.optional(this.kmsKeyIdentifier);
    }
    /**
     * Name of the new event bus. The names of custom event buses can&#39;t contain the / character. To create a partner event bus, ensure that the `name` matches the `event_source_name`.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the new event bus. The names of custom event buses can&#39;t contain the / character. To create a partner event bus, ensure that the `name` matches the `event_source_name`.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags assigned to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public EventBus(java.lang.String name) {
        this(name, EventBusArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public EventBus(java.lang.String name, @Nullable EventBusArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public EventBus(java.lang.String name, @Nullable EventBusArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/eventBus:EventBus", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private EventBus(java.lang.String name, Output<java.lang.String> id, @Nullable EventBusState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/eventBus:EventBus", name, state, makeResourceOptions(options, id), false);
    }

    private static EventBusArgs makeArgs(@Nullable EventBusArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? EventBusArgs.Empty : args;
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
    public static EventBus get(java.lang.String name, Output<java.lang.String> id, @Nullable EventBusState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new EventBus(name, id, state, options);
    }
}
