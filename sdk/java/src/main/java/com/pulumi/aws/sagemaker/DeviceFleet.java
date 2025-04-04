// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.sagemaker;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.sagemaker.DeviceFleetArgs;
import com.pulumi.aws.sagemaker.inputs.DeviceFleetState;
import com.pulumi.aws.sagemaker.outputs.DeviceFleetOutputConfig;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Boolean;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides a SageMaker AI Device Fleet resource.
 * 
 * ## Example Usage
 * 
 * ### Basic usage
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.sagemaker.DeviceFleet;
 * import com.pulumi.aws.sagemaker.DeviceFleetArgs;
 * import com.pulumi.aws.sagemaker.inputs.DeviceFleetOutputConfigArgs;
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
 *         var example = new DeviceFleet("example", DeviceFleetArgs.builder()
 *             .deviceFleetName("example")
 *             .roleArn(test.arn())
 *             .outputConfig(DeviceFleetOutputConfigArgs.builder()
 *                 .s3OutputLocation(String.format("s3://%s/prefix/", exampleAwsS3Bucket.bucket()))
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
 * Using `pulumi import`, import SageMaker AI Device Fleets using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:sagemaker/deviceFleet:DeviceFleet example my-fleet
 * ```
 * 
 */
@ResourceType(type="aws:sagemaker/deviceFleet:DeviceFleet")
public class DeviceFleet extends com.pulumi.resources.CustomResource {
    /**
     * The Amazon Resource Name (ARN) assigned by AWS to this Device Fleet.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return The Amazon Resource Name (ARN) assigned by AWS to this Device Fleet.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * A description of the fleet.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return A description of the fleet.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * The name of the Device Fleet (must be unique).
     * 
     */
    @Export(name="deviceFleetName", refs={String.class}, tree="[0]")
    private Output<String> deviceFleetName;

    /**
     * @return The name of the Device Fleet (must be unique).
     * 
     */
    public Output<String> deviceFleetName() {
        return this.deviceFleetName;
    }
    /**
     * Whether to create an AWS IoT Role Alias during device fleet creation. The name of the role alias generated will match this pattern: &#34;SageMakerEdge-{DeviceFleetName}&#34;.
     * 
     */
    @Export(name="enableIotRoleAlias", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> enableIotRoleAlias;

    /**
     * @return Whether to create an AWS IoT Role Alias during device fleet creation. The name of the role alias generated will match this pattern: &#34;SageMakerEdge-{DeviceFleetName}&#34;.
     * 
     */
    public Output<Optional<Boolean>> enableIotRoleAlias() {
        return Codegen.optional(this.enableIotRoleAlias);
    }
    @Export(name="iotRoleAlias", refs={String.class}, tree="[0]")
    private Output<String> iotRoleAlias;

    public Output<String> iotRoleAlias() {
        return this.iotRoleAlias;
    }
    /**
     * Specifies details about the repository. see Output Config details below.
     * 
     */
    @Export(name="outputConfig", refs={DeviceFleetOutputConfig.class}, tree="[0]")
    private Output<DeviceFleetOutputConfig> outputConfig;

    /**
     * @return Specifies details about the repository. see Output Config details below.
     * 
     */
    public Output<DeviceFleetOutputConfig> outputConfig() {
        return this.outputConfig;
    }
    /**
     * The Amazon Resource Name (ARN) that has access to AWS Internet of Things (IoT).
     * 
     */
    @Export(name="roleArn", refs={String.class}, tree="[0]")
    private Output<String> roleArn;

    /**
     * @return The Amazon Resource Name (ARN) that has access to AWS Internet of Things (IoT).
     * 
     */
    public Output<String> roleArn() {
        return this.roleArn;
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
    public DeviceFleet(java.lang.String name) {
        this(name, DeviceFleetArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DeviceFleet(java.lang.String name, DeviceFleetArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DeviceFleet(java.lang.String name, DeviceFleetArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:sagemaker/deviceFleet:DeviceFleet", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DeviceFleet(java.lang.String name, Output<java.lang.String> id, @Nullable DeviceFleetState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:sagemaker/deviceFleet:DeviceFleet", name, state, makeResourceOptions(options, id), false);
    }

    private static DeviceFleetArgs makeArgs(DeviceFleetArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DeviceFleetArgs.Empty : args;
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
    public static DeviceFleet get(java.lang.String name, Output<java.lang.String> id, @Nullable DeviceFleetState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DeviceFleet(name, id, state, options);
    }
}
