// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudwatch;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.cloudwatch.CompositeAlarmArgs;
import com.pulumi.aws.cloudwatch.inputs.CompositeAlarmState;
import com.pulumi.aws.cloudwatch.outputs.CompositeAlarmActionsSuppressor;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a CloudWatch Composite Alarm resource.
 * 
 * &gt; **NOTE:** An alarm (composite or metric) cannot be destroyed when there are other composite alarms depending on it. This can lead to a cyclical dependency on update, as the provider will unsuccessfully attempt to destroy alarms before updating the rule. Consider using `depends_on`, references to alarm names, and two-stage updates.
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
 * import com.pulumi.aws.cloudwatch.CompositeAlarm;
 * import com.pulumi.aws.cloudwatch.CompositeAlarmArgs;
 * import com.pulumi.aws.cloudwatch.inputs.CompositeAlarmActionsSuppressorArgs;
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
 *         var example = new CompositeAlarm("example", CompositeAlarmArgs.builder()
 *             .alarmDescription("This is a composite alarm!")
 *             .alarmName("example-composite-alarm")
 *             .alarmActions(exampleAwsSnsTopic.arn())
 *             .okActions(exampleAwsSnsTopic.arn())
 *             .alarmRule("""
 * ALARM(%s) OR
 * ALARM(%s)
 * ", alpha.alarmName(),bravo.alarmName()))
 *             .actionsSuppressor(CompositeAlarmActionsSuppressorArgs.builder()
 *                 .alarm("suppressor-alarm")
 *                 .extensionPeriod(10)
 *                 .waitPeriod(20)
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
 * Using `pulumi import`, import a CloudWatch Composite Alarm using the `alarm_name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:cloudwatch/compositeAlarm:CompositeAlarm test my-alarm
 * ```
 * 
 */
@ResourceType(type="aws:cloudwatch/compositeAlarm:CompositeAlarm")
public class CompositeAlarm extends com.pulumi.resources.CustomResource {
    /**
     * Indicates whether actions should be executed during any changes to the alarm state of the composite alarm. Defaults to `true`.
     * 
     */
    @Export(name="actionsEnabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> actionsEnabled;

    /**
     * @return Indicates whether actions should be executed during any changes to the alarm state of the composite alarm. Defaults to `true`.
     * 
     */
    public Output<Optional<Boolean>> actionsEnabled() {
        return Codegen.optional(this.actionsEnabled);
    }
    /**
     * Actions will be suppressed if the suppressor alarm is in the ALARM state.
     * 
     */
    @Export(name="actionsSuppressor", refs={CompositeAlarmActionsSuppressor.class}, tree="[0]")
    private Output</* @Nullable */ CompositeAlarmActionsSuppressor> actionsSuppressor;

    /**
     * @return Actions will be suppressed if the suppressor alarm is in the ALARM state.
     * 
     */
    public Output<Optional<CompositeAlarmActionsSuppressor>> actionsSuppressor() {
        return Codegen.optional(this.actionsSuppressor);
    }
    /**
     * The set of actions to execute when this alarm transitions to the `ALARM` state from any other state. Each action is specified as an ARN. Up to 5 actions are allowed.
     * 
     */
    @Export(name="alarmActions", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> alarmActions;

    /**
     * @return The set of actions to execute when this alarm transitions to the `ALARM` state from any other state. Each action is specified as an ARN. Up to 5 actions are allowed.
     * 
     */
    public Output<Optional<List<String>>> alarmActions() {
        return Codegen.optional(this.alarmActions);
    }
    /**
     * The description for the composite alarm.
     * 
     */
    @Export(name="alarmDescription", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> alarmDescription;

    /**
     * @return The description for the composite alarm.
     * 
     */
    public Output<Optional<String>> alarmDescription() {
        return Codegen.optional(this.alarmDescription);
    }
    /**
     * The name for the composite alarm. This name must be unique within the region.
     * 
     */
    @Export(name="alarmName", refs={String.class}, tree="[0]")
    private Output<String> alarmName;

    /**
     * @return The name for the composite alarm. This name must be unique within the region.
     * 
     */
    public Output<String> alarmName() {
        return this.alarmName;
    }
    /**
     * An expression that specifies which other alarms are to be evaluated to determine this composite alarm&#39;s state. For syntax, see [Creating a Composite Alarm](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Create_Composite_Alarm.html). The maximum length is 10240 characters.
     * 
     */
    @Export(name="alarmRule", refs={String.class}, tree="[0]")
    private Output<String> alarmRule;

    /**
     * @return An expression that specifies which other alarms are to be evaluated to determine this composite alarm&#39;s state. For syntax, see [Creating a Composite Alarm](https://docs.aws.amazon.com/AmazonCloudWatch/latest/monitoring/Create_Composite_Alarm.html). The maximum length is 10240 characters.
     * 
     */
    public Output<String> alarmRule() {
        return this.alarmRule;
    }
    /**
     * The ARN of the composite alarm.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The ARN of the composite alarm.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The set of actions to execute when this alarm transitions to the `INSUFFICIENT_DATA` state from any other state. Each action is specified as an ARN. Up to 5 actions are allowed.
     * 
     */
    @Export(name="insufficientDataActions", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> insufficientDataActions;

    /**
     * @return The set of actions to execute when this alarm transitions to the `INSUFFICIENT_DATA` state from any other state. Each action is specified as an ARN. Up to 5 actions are allowed.
     * 
     */
    public Output<Optional<List<String>>> insufficientDataActions() {
        return Codegen.optional(this.insufficientDataActions);
    }
    /**
     * The set of actions to execute when this alarm transitions to an `OK` state from any other state. Each action is specified as an ARN. Up to 5 actions are allowed.
     * 
     */
    @Export(name="okActions", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> okActions;

    /**
     * @return The set of actions to execute when this alarm transitions to an `OK` state from any other state. Each action is specified as an ARN. Up to 5 actions are allowed.
     * 
     */
    public Output<Optional<List<String>>> okActions() {
        return Codegen.optional(this.okActions);
    }
    /**
     * A map of tags to associate with the alarm. Up to 50 tags are allowed. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to associate with the alarm. Up to 50 tags are allowed. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public CompositeAlarm(java.lang.String name) {
        this(name, CompositeAlarmArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public CompositeAlarm(java.lang.String name, CompositeAlarmArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public CompositeAlarm(java.lang.String name, CompositeAlarmArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/compositeAlarm:CompositeAlarm", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private CompositeAlarm(java.lang.String name, Output<java.lang.String> id, @Nullable CompositeAlarmState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:cloudwatch/compositeAlarm:CompositeAlarm", name, state, makeResourceOptions(options, id), false);
    }

    private static CompositeAlarmArgs makeArgs(CompositeAlarmArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? CompositeAlarmArgs.Empty : args;
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
    public static CompositeAlarm get(java.lang.String name, Output<java.lang.String> id, @Nullable CompositeAlarmState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new CompositeAlarm(name, id, state, options);
    }
}
