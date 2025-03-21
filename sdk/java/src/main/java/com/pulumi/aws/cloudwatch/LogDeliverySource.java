// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudwatch.LogDeliverySourceArgs;
import com.pulumi.aws.cloudwatch.inputs.LogDeliverySourceState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS CloudWatch Logs Delivery Source.
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
 * import com.pulumi.aws.cloudwatch.LogDeliverySource;
 * import com.pulumi.aws.cloudwatch.LogDeliverySourceArgs;
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
 *         var example = new LogDeliverySource("example", LogDeliverySourceArgs.builder()
 *             .name("example")
 *             .logType("APPLICATION_LOGS")
 *             .resourceArn(exampleAwsBedrockagentKnowledgeBase.arn())
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
 * Using `pulumi import`, import CloudWatch Logs Delivery Source using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudwatch/logDeliverySource:LogDeliverySource example example
 * ```
 * 
 */
@ResourceType(type="aws:cloudwatch/logDeliverySource:LogDeliverySource")
public class LogDeliverySource extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) of the delivery source.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) of the delivery source.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The type of log that the source is sending. For Amazon Bedrock, the valid value is `APPLICATION_LOGS`. For Amazon CodeWhisperer, the valid value is `EVENT_LOGS`. For IAM Identity Center, the valid value is `ERROR_LOGS`. For Amazon WorkMail, the valid values are `ACCESS_CONTROL_LOGS`, `AUTHENTICATION_LOGS`, `WORKMAIL_AVAILABILITY_PROVIDER_LOGS`, and `WORKMAIL_MAILBOX_ACCESS_LOGS`.
     * 
     */
    @Export(name="logType", refs={String.class}, tree="[0]")
    private Output<String> logType;

    /**
     * @return The type of log that the source is sending. For Amazon Bedrock, the valid value is `APPLICATION_LOGS`. For Amazon CodeWhisperer, the valid value is `EVENT_LOGS`. For IAM Identity Center, the valid value is `ERROR_LOGS`. For Amazon WorkMail, the valid values are `ACCESS_CONTROL_LOGS`, `AUTHENTICATION_LOGS`, `WORKMAIL_AVAILABILITY_PROVIDER_LOGS`, and `WORKMAIL_MAILBOX_ACCESS_LOGS`.
     * 
     */
    public Output<String> logType() {
        return this.logType;
    }
    /**
     * The name for this delivery source.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name for this delivery source.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The ARN of the AWS resource that is generating and sending logs.
     * 
     */
    @Export(name="resourceArn", refs={String.class}, tree="[0]")
    private Output<String> resourceArn;

    /**
     * @return The ARN of the AWS resource that is generating and sending logs.
     * 
     */
    public Output<String> resourceArn() {
        return this.resourceArn;
    }
    /**
     * The AWS service that is sending logs.
     * 
     */
    @Export(name="service", refs={String.class}, tree="[0]")
    private Output<String> service;

    /**
     * @return The AWS service that is sending logs.
     * 
     */
    public Output<String> service() {
        return this.service;
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
    public LogDeliverySource(java.lang.String name) {
        this(name, LogDeliverySourceArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LogDeliverySource(java.lang.String name, LogDeliverySourceArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LogDeliverySource(java.lang.String name, LogDeliverySourceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/logDeliverySource:LogDeliverySource", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LogDeliverySource(java.lang.String name, Output<java.lang.String> id, @Nullable LogDeliverySourceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/logDeliverySource:LogDeliverySource", name, state, makeResourceOptions(options, id), false);
    }

    private static LogDeliverySourceArgs makeArgs(LogDeliverySourceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LogDeliverySourceArgs.Empty : args;
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
    public static LogDeliverySource get(java.lang.String name, Output<java.lang.String> id, @Nullable LogDeliverySourceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LogDeliverySource(name, id, state, options);
    }
}
