// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.appconfig;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.appconfig.DeploymentStrategyArgs;
import com.pulumi.aws.appconfig.inputs.DeploymentStrategyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Double;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides an AppConfig Deployment Strategy resource.
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
 * import com.pulumi.aws.appconfig.DeploymentStrategy;
 * import com.pulumi.aws.appconfig.DeploymentStrategyArgs;
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
 *         var example = new DeploymentStrategy("example", DeploymentStrategyArgs.builder()
 *             .name("example-deployment-strategy-tf")
 *             .description("Example Deployment Strategy")
 *             .deploymentDurationInMinutes(3)
 *             .finalBakeTimeInMinutes(4)
 *             .growthFactor(10.0)
 *             .growthType("LINEAR")
 *             .replicateTo("NONE")
 *             .tags(Map.of("Type", "AppConfig Deployment Strategy"))
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
 * Using `pulumi import`, import AppConfig Deployment Strategies using their deployment strategy ID. For example:
 * 
 * ```sh
 * $ pulumi import aws:appconfig/deploymentStrategy:DeploymentStrategy example 11xxxxx
 * ```
 * 
 */
@ResourceType(type="aws:appconfig/deploymentStrategy:DeploymentStrategy")
public class DeploymentStrategy extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the AppConfig Deployment Strategy.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the AppConfig Deployment Strategy.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Total amount of time for a deployment to last. Minimum value of 0, maximum value of 1440.
     * 
     */
    @Export(name="deploymentDurationInMinutes", refs={Integer.class}, tree="[0]")
    private Output<Integer> deploymentDurationInMinutes;

    /**
     * @return Total amount of time for a deployment to last. Minimum value of 0, maximum value of 1440.
     * 
     */
    public Output<Integer> deploymentDurationInMinutes() {
        return this.deploymentDurationInMinutes;
    }
    /**
     * Description of the deployment strategy. Can be at most 1024 characters.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Description of the deployment strategy. Can be at most 1024 characters.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Amount of time AWS AppConfig monitors for alarms before considering the deployment to be complete and no longer eligible for automatic roll back. Minimum value of 0, maximum value of 1440.
     * 
     */
    @Export(name="finalBakeTimeInMinutes", refs={Integer.class}, tree="[0]")
    private Output</* @Nullable */ Integer> finalBakeTimeInMinutes;

    /**
     * @return Amount of time AWS AppConfig monitors for alarms before considering the deployment to be complete and no longer eligible for automatic roll back. Minimum value of 0, maximum value of 1440.
     * 
     */
    public Output<Optional<Integer>> finalBakeTimeInMinutes() {
        return Codegen.optional(this.finalBakeTimeInMinutes);
    }
    /**
     * Percentage of targets to receive a deployed configuration during each interval. Minimum value of 1.0, maximum value of 100.0.
     * 
     */
    @Export(name="growthFactor", refs={Double.class}, tree="[0]")
    private Output<Double> growthFactor;

    /**
     * @return Percentage of targets to receive a deployed configuration during each interval. Minimum value of 1.0, maximum value of 100.0.
     * 
     */
    public Output<Double> growthFactor() {
        return this.growthFactor;
    }
    /**
     * Algorithm used to define how percentage grows over time. Valid value: `LINEAR` and `EXPONENTIAL`. Defaults to `LINEAR`.
     * 
     */
    @Export(name="growthType", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> growthType;

    /**
     * @return Algorithm used to define how percentage grows over time. Valid value: `LINEAR` and `EXPONENTIAL`. Defaults to `LINEAR`.
     * 
     */
    public Output<Optional<String>> growthType() {
        return Codegen.optional(this.growthType);
    }
    /**
     * Name for the deployment strategy. Must be between 1 and 64 characters in length.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name for the deployment strategy. Must be between 1 and 64 characters in length.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Where to save the deployment strategy. Valid values: `NONE` and `SSM_DOCUMENT`.
     * 
     */
    @Export(name="replicateTo", refs={String.class}, tree="[0]")
    private Output<String> replicateTo;

    /**
     * @return Where to save the deployment strategy. Valid values: `NONE` and `SSM_DOCUMENT`.
     * 
     */
    public Output<String> replicateTo() {
        return this.replicateTo;
    }
    /**
     * Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the resource. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public DeploymentStrategy(java.lang.String name) {
        this(name, DeploymentStrategyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DeploymentStrategy(java.lang.String name, DeploymentStrategyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DeploymentStrategy(java.lang.String name, DeploymentStrategyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:appconfig/deploymentStrategy:DeploymentStrategy", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DeploymentStrategy(java.lang.String name, Output<java.lang.String> id, @Nullable DeploymentStrategyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:appconfig/deploymentStrategy:DeploymentStrategy", name, state, makeResourceOptions(options, id), false);
    }

    private static DeploymentStrategyArgs makeArgs(DeploymentStrategyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DeploymentStrategyArgs.Empty : args;
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
    public static DeploymentStrategy get(java.lang.String name, Output<java.lang.String> id, @Nullable DeploymentStrategyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DeploymentStrategy(name, id, state, options);
    }
}
