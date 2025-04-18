// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.autoscaling;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.autoscaling.LifecycleHookArgs;
import com.pulumi.aws.autoscaling.inputs.LifecycleHookState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides an AutoScaling Lifecycle Hook resource.
 * 
 * &gt; **NOTE:** This provider has two types of ways you can add lifecycle hooks - via
 * the `initial_lifecycle_hook` attribute from the
 * `aws.autoscaling.Group`
 * resource, or via this one. Hooks added via this resource will not be added
 * until the autoscaling group has been created, and depending on your
 * capacity
 * settings, after the initial instances have been launched, creating unintended
 * behavior. If you need hooks to run on all instances, add them with
 * `initial_lifecycle_hook` in
 * `aws.autoscaling.Group`,
 * but take care to not duplicate those hooks with this resource.
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
 * import com.pulumi.aws.autoscaling.Group;
 * import com.pulumi.aws.autoscaling.GroupArgs;
 * import com.pulumi.aws.autoscaling.inputs.GroupTagArgs;
 * import com.pulumi.aws.autoscaling.LifecycleHook;
 * import com.pulumi.aws.autoscaling.LifecycleHookArgs;
 * import static com.pulumi.codegen.internal.Serialization.*;
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
 *         var foobar = new Group("foobar", GroupArgs.builder()
 *             .availabilityZones("us-west-2a")
 *             .name("test-foobar5")
 *             .healthCheckType("EC2")
 *             .terminationPolicies("OldestInstance")
 *             .tags(GroupTagArgs.builder()
 *                 .key("Foo")
 *                 .value("foo-bar")
 *                 .propagateAtLaunch(true)
 *                 .build())
 *             .build());
 * 
 *         var foobarLifecycleHook = new LifecycleHook("foobarLifecycleHook", LifecycleHookArgs.builder()
 *             .name("foobar")
 *             .autoscalingGroupName(foobar.name())
 *             .defaultResult("CONTINUE")
 *             .heartbeatTimeout(2000)
 *             .lifecycleTransition("autoscaling:EC2_INSTANCE_LAUNCHING")
 *             .notificationMetadata(serializeJson(
 *                 jsonObject(
 *                     jsonProperty("foo", "bar")
 *                 )))
 *             .notificationTargetArn("arn:aws:sqs:us-east-1:444455556666:queue1*")
 *             .roleArn("arn:aws:iam::123456789012:role/S3Access")
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
 * Using `pulumi import`, import AutoScaling Lifecycle Hooks using the role autoscaling_group_name and name separated by `/`. For example:
 * 
 * ```sh
 * $ pulumi import aws:autoscaling/lifecycleHook:LifecycleHook test-lifecycle-hook asg-name/lifecycle-hook-name
 * ```
 * 
 */
@ResourceType(type="aws:autoscaling/lifecycleHook:LifecycleHook")
public class LifecycleHook extends com.pulumi.resources.CustomResource {
    /**
     * Name of the Auto Scaling group to which you want to assign the lifecycle hook
     * 
     */
    @Export(name="autoscalingGroupName", refs={String.class}, tree="[0]")
    private Output<String> autoscalingGroupName;

    /**
     * @return Name of the Auto Scaling group to which you want to assign the lifecycle hook
     * 
     */
    public Output<String> autoscalingGroupName() {
        return this.autoscalingGroupName;
    }
    /**
     * Defines the action the Auto Scaling group should take when the lifecycle hook timeout elapses or if an unexpected failure occurs. The value for this parameter can be either CONTINUE or ABANDON. The default value for this parameter is ABANDON.
     * 
     */
    @Export(name="defaultResult", refs={String.class}, tree="[0]")
    private Output<String> defaultResult;

    /**
     * @return Defines the action the Auto Scaling group should take when the lifecycle hook timeout elapses or if an unexpected failure occurs. The value for this parameter can be either CONTINUE or ABANDON. The default value for this parameter is ABANDON.
     * 
     */
    public Output<String> defaultResult() {
        return this.defaultResult;
    }
    /**
     * Defines the amount of time, in seconds, that can elapse before the lifecycle hook times out. When the lifecycle hook times out, Auto Scaling performs the action defined in the DefaultResult parameter
     * 
     */
    @Export(name="heartbeatTimeout", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> heartbeatTimeout;

    /**
     * @return Defines the amount of time, in seconds, that can elapse before the lifecycle hook times out. When the lifecycle hook times out, Auto Scaling performs the action defined in the DefaultResult parameter
     * 
     */
    public Output<Optional<Integer>> heartbeatTimeout() {
        return Codegen.optional(this.heartbeatTimeout);
    }
    /**
     * Instance state to which you want to attach the lifecycle hook. For a list of lifecycle hook types, see [describe-lifecycle-hook-types](https://docs.aws.amazon.com/cli/latest/reference/autoscaling/describe-lifecycle-hook-types.html#examples)
     * 
     */
    @Export(name="lifecycleTransition", refs={String.class}, tree="[0]")
    private Output<String> lifecycleTransition;

    /**
     * @return Instance state to which you want to attach the lifecycle hook. For a list of lifecycle hook types, see [describe-lifecycle-hook-types](https://docs.aws.amazon.com/cli/latest/reference/autoscaling/describe-lifecycle-hook-types.html#examples)
     * 
     */
    public Output<String> lifecycleTransition() {
        return this.lifecycleTransition;
    }
    /**
     * Name of the lifecycle hook.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the lifecycle hook.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Contains additional information that you want to include any time Auto Scaling sends a message to the notification target.
     * 
     */
    @Export(name="notificationMetadata", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> notificationMetadata;

    /**
     * @return Contains additional information that you want to include any time Auto Scaling sends a message to the notification target.
     * 
     */
    public Output<Optional<String>> notificationMetadata() {
        return Codegen.optional(this.notificationMetadata);
    }
    /**
     * ARN of the notification target that Auto Scaling will use to notify you when an instance is in the transition state for the lifecycle hook. This ARN target can be either an SQS queue or an SNS topic.
     * 
     */
    @Export(name="notificationTargetArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> notificationTargetArn;

    /**
     * @return ARN of the notification target that Auto Scaling will use to notify you when an instance is in the transition state for the lifecycle hook. This ARN target can be either an SQS queue or an SNS topic.
     * 
     */
    public Output<Optional<String>> notificationTargetArn() {
        return Codegen.optional(this.notificationTargetArn);
    }
    /**
     * ARN of the IAM role that allows the Auto Scaling group to publish to the specified notification target.
     * 
     */
    @Export(name="roleArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> roleArn;

    /**
     * @return ARN of the IAM role that allows the Auto Scaling group to publish to the specified notification target.
     * 
     */
    public Output<Optional<String>> roleArn() {
        return Codegen.optional(this.roleArn);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public LifecycleHook(java.lang.String name) {
        this(name, LifecycleHookArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public LifecycleHook(java.lang.String name, LifecycleHookArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public LifecycleHook(java.lang.String name, LifecycleHookArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:autoscaling/lifecycleHook:LifecycleHook", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private LifecycleHook(java.lang.String name, Output<java.lang.String> id, @Nullable LifecycleHookState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:autoscaling/lifecycleHook:LifecycleHook", name, state, makeResourceOptions(options, id), false);
    }

    private static LifecycleHookArgs makeArgs(LifecycleHookArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? LifecycleHookArgs.Empty : args;
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
    public static LifecycleHook get(java.lang.String name, Output<java.lang.String> id, @Nullable LifecycleHookState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new LifecycleHook(name, id, state, options);
    }
}
