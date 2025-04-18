// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.autoscalingplans;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.autoscalingplans.ScalingPlanArgs;
import com.pulumi.aws.autoscalingplans.inputs.ScalingPlanState;
import com.pulumi.aws.autoscalingplans.outputs.ScalingPlanApplicationSource;
import com.pulumi.aws.autoscalingplans.outputs.ScalingPlanScalingInstruction;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.List;
import javax.annotation.Nullable;

/**
 * Manages an AWS Auto Scaling scaling plan.
 * More information can be found in the [AWS Auto Scaling User Guide](https://docs.aws.amazon.com/autoscaling/plans/userguide/what-is-aws-auto-scaling.html).
 * 
 * &gt; **NOTE:** The AWS Auto Scaling service uses an AWS IAM service-linked role to manage predictive scaling of Amazon EC2 Auto Scaling groups. The service attempts to automatically create this role the first time a scaling plan with predictive scaling enabled is created.
 * An `aws.iam.ServiceLinkedRole` resource can be used to manually manage this role.
 * See the [AWS documentation](https://docs.aws.amazon.com/autoscaling/plans/userguide/aws-auto-scaling-service-linked-roles.html#create-service-linked-role-manual) for more details.
 * 
 * ## Example Usage
 * 
 * ## Import
 * 
 * Using `pulumi import`, import Auto Scaling scaling plans using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:autoscalingplans/scalingPlan:ScalingPlan example MyScale1
 * ```
 * 
 */
@ResourceType(type="aws:autoscalingplans/scalingPlan:ScalingPlan")
public class ScalingPlan extends com.pulumi.resources.CustomResource {
    /**
     * CloudFormation stack or set of tags. You can create one scaling plan per application source.
     * 
     */
    @Export(name="applicationSource", refs={ScalingPlanApplicationSource.class}, tree="[0]")
    private Output<ScalingPlanApplicationSource> applicationSource;

    /**
     * @return CloudFormation stack or set of tags. You can create one scaling plan per application source.
     * 
     */
    public Output<ScalingPlanApplicationSource> applicationSource() {
        return this.applicationSource;
    }
    /**
     * Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the scaling plan. Names cannot contain vertical bars, colons, or forward slashes.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
     * 
     */
    @Export(name="scalingInstructions", refs={List.class,ScalingPlanScalingInstruction.class}, tree="[0,1]")
    private Output<List<ScalingPlanScalingInstruction>> scalingInstructions;

    /**
     * @return Scaling instructions. More details can be found in the [AWS Auto Scaling API Reference](https://docs.aws.amazon.com/autoscaling/plans/APIReference/API_ScalingInstruction.html).
     * 
     */
    public Output<List<ScalingPlanScalingInstruction>> scalingInstructions() {
        return this.scalingInstructions;
    }
    /**
     * The version number of the scaling plan. This value is always 1.
     * 
     */
    @Export(name="scalingPlanVersion", refs={Integer.class}, tree="[0]")
    private Output<Integer> scalingPlanVersion;

    /**
     * @return The version number of the scaling plan. This value is always 1.
     * 
     */
    public Output<Integer> scalingPlanVersion() {
        return this.scalingPlanVersion;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public ScalingPlan(java.lang.String name) {
        this(name, ScalingPlanArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ScalingPlan(java.lang.String name, ScalingPlanArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ScalingPlan(java.lang.String name, ScalingPlanArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:autoscalingplans/scalingPlan:ScalingPlan", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ScalingPlan(java.lang.String name, Output<java.lang.String> id, @Nullable ScalingPlanState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:autoscalingplans/scalingPlan:ScalingPlan", name, state, makeResourceOptions(options, id), false);
    }

    private static ScalingPlanArgs makeArgs(ScalingPlanArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ScalingPlanArgs.Empty : args;
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
    public static ScalingPlan get(java.lang.String name, Output<java.lang.String> id, @Nullable ScalingPlanState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ScalingPlan(name, id, state, options);
    }
}
