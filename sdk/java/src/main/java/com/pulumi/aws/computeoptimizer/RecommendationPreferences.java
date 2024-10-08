// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.computeoptimizer;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.computeoptimizer.RecommendationPreferencesArgs;
import com.pulumi.aws.computeoptimizer.inputs.RecommendationPreferencesState;
import com.pulumi.aws.computeoptimizer.outputs.RecommendationPreferencesExternalMetricsPreference;
import com.pulumi.aws.computeoptimizer.outputs.RecommendationPreferencesPreferredResource;
import com.pulumi.aws.computeoptimizer.outputs.RecommendationPreferencesScope;
import com.pulumi.aws.computeoptimizer.outputs.RecommendationPreferencesUtilizationPreference;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Manages AWS Compute Optimizer recommendation preferences.
 * 
 * ## Example Usage
 * 
 * ### Lookback Period Preference
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.computeoptimizer.RecommendationPreferences;
 * import com.pulumi.aws.computeoptimizer.RecommendationPreferencesArgs;
 * import com.pulumi.aws.computeoptimizer.inputs.RecommendationPreferencesScopeArgs;
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
 *         var example = new RecommendationPreferences("example", RecommendationPreferencesArgs.builder()
 *             .resourceType("Ec2Instance")
 *             .scope(RecommendationPreferencesScopeArgs.builder()
 *                 .name("AccountId")
 *                 .value("123456789012")
 *                 .build())
 *             .lookBackPeriod("DAYS_32")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### Multiple Preferences
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.computeoptimizer.RecommendationPreferences;
 * import com.pulumi.aws.computeoptimizer.RecommendationPreferencesArgs;
 * import com.pulumi.aws.computeoptimizer.inputs.RecommendationPreferencesScopeArgs;
 * import com.pulumi.aws.computeoptimizer.inputs.RecommendationPreferencesExternalMetricsPreferenceArgs;
 * import com.pulumi.aws.computeoptimizer.inputs.RecommendationPreferencesPreferredResourceArgs;
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
 *         var example = new RecommendationPreferences("example", RecommendationPreferencesArgs.builder()
 *             .resourceType("Ec2Instance")
 *             .scope(RecommendationPreferencesScopeArgs.builder()
 *                 .name("AccountId")
 *                 .value("123456789012")
 *                 .build())
 *             .enhancedInfrastructureMetrics("Active")
 *             .externalMetricsPreference(RecommendationPreferencesExternalMetricsPreferenceArgs.builder()
 *                 .source("Datadog")
 *                 .build())
 *             .preferredResources(RecommendationPreferencesPreferredResourceArgs.builder()
 *                 .includeLists(                
 *                     "m5.xlarge",
 *                     "r5")
 *                 .name("Ec2InstanceTypes")
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
 * Using `pulumi import`, import recommendation preferences using the resource type, scope name and scope value. For example:
 * 
 * ```sh
 * $ pulumi import aws:computeoptimizer/recommendationPreferences:RecommendationPreferences example Ec2Instance,AccountId,123456789012
 * ```
 * 
 */
@ResourceType(type="aws:computeoptimizer/recommendationPreferences:RecommendationPreferences")
public class RecommendationPreferences extends com.pulumi.resources.CustomResource {
    /**
     * The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
     * 
     */
    @Export(name="enhancedInfrastructureMetrics", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> enhancedInfrastructureMetrics;

    /**
     * @return The status of the enhanced infrastructure metrics recommendation preference. Valid values: `Active`, `Inactive`.
     * 
     */
    public Output<Optional<String>> enhancedInfrastructureMetrics() {
        return Codegen.optional(this.enhancedInfrastructureMetrics);
    }
    /**
     * The provider of the external metrics recommendation preference. See External Metrics Preference below.
     * 
     */
    @Export(name="externalMetricsPreference", refs={RecommendationPreferencesExternalMetricsPreference.class}, tree="[0]")
    private Output</* @Nullable */ RecommendationPreferencesExternalMetricsPreference> externalMetricsPreference;

    /**
     * @return The provider of the external metrics recommendation preference. See External Metrics Preference below.
     * 
     */
    public Output<Optional<RecommendationPreferencesExternalMetricsPreference>> externalMetricsPreference() {
        return Codegen.optional(this.externalMetricsPreference);
    }
    /**
     * The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
     * 
     */
    @Export(name="inferredWorkloadTypes", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> inferredWorkloadTypes;

    /**
     * @return The status of the inferred workload types recommendation preference. Valid values: `Active`, `Inactive`.
     * 
     */
    public Output<Optional<String>> inferredWorkloadTypes() {
        return Codegen.optional(this.inferredWorkloadTypes);
    }
    /**
     * The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
     * 
     */
    @Export(name="lookBackPeriod", refs={String.class}, tree="[0]")
    private Output<String> lookBackPeriod;

    /**
     * @return The preference to control the number of days the utilization metrics of the AWS resource are analyzed. Valid values: `DAYS_14`, `DAYS_32`, `DAYS_93`.
     * 
     */
    public Output<String> lookBackPeriod() {
        return this.lookBackPeriod;
    }
    /**
     * The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
     * 
     */
    @Export(name="preferredResources", refs={List.class,RecommendationPreferencesPreferredResource.class}, tree="[0,1]")
    private Output</* @Nullable */ List<RecommendationPreferencesPreferredResource>> preferredResources;

    /**
     * @return The preference to control which resource type values are considered when generating rightsizing recommendations. See Preferred Resources below.
     * 
     */
    public Output<Optional<List<RecommendationPreferencesPreferredResource>>> preferredResources() {
        return Codegen.optional(this.preferredResources);
    }
    /**
     * The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
     * 
     */
    @Export(name="resourceType", refs={String.class}, tree="[0]")
    private Output<String> resourceType;

    /**
     * @return The target resource type of the recommendation preferences. Valid values: `Ec2Instance`, `AutoScalingGroup`, `RdsDBInstance`.
     * 
     */
    public Output<String> resourceType() {
        return this.resourceType;
    }
    /**
     * The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
     * 
     */
    @Export(name="savingsEstimationMode", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> savingsEstimationMode;

    /**
     * @return The status of the savings estimation mode preference. Valid values: `AfterDiscounts`, `BeforeDiscounts`.
     * 
     */
    public Output<Optional<String>> savingsEstimationMode() {
        return Codegen.optional(this.savingsEstimationMode);
    }
    /**
     * The scope of the recommendation preferences. See Scope below.
     * 
     */
    @Export(name="scope", refs={RecommendationPreferencesScope.class}, tree="[0]")
    private Output</* @Nullable */ RecommendationPreferencesScope> scope;

    /**
     * @return The scope of the recommendation preferences. See Scope below.
     * 
     */
    public Output<Optional<RecommendationPreferencesScope>> scope() {
        return Codegen.optional(this.scope);
    }
    /**
     * The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
     * 
     */
    @Export(name="utilizationPreferences", refs={List.class,RecommendationPreferencesUtilizationPreference.class}, tree="[0,1]")
    private Output</* @Nullable */ List<RecommendationPreferencesUtilizationPreference>> utilizationPreferences;

    /**
     * @return The preference to control the resource’s CPU utilization threshold, CPU utilization headroom, and memory utilization headroom. See Utilization Preferences below.
     * 
     */
    public Output<Optional<List<RecommendationPreferencesUtilizationPreference>>> utilizationPreferences() {
        return Codegen.optional(this.utilizationPreferences);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public RecommendationPreferences(java.lang.String name) {
        this(name, RecommendationPreferencesArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RecommendationPreferences(java.lang.String name, RecommendationPreferencesArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RecommendationPreferences(java.lang.String name, RecommendationPreferencesArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:computeoptimizer/recommendationPreferences:RecommendationPreferences", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RecommendationPreferences(java.lang.String name, Output<java.lang.String> id, @Nullable RecommendationPreferencesState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:computeoptimizer/recommendationPreferences:RecommendationPreferences", name, state, makeResourceOptions(options, id), false);
    }

    private static RecommendationPreferencesArgs makeArgs(RecommendationPreferencesArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RecommendationPreferencesArgs.Empty : args;
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
    public static RecommendationPreferences get(java.lang.String name, Output<java.lang.String> id, @Nullable RecommendationPreferencesState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RecommendationPreferences(name, id, state, options);
    }
}
