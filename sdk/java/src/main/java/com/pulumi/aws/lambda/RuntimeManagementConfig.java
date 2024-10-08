// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lambda;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lambda.RuntimeManagementConfigArgs;
import com.pulumi.aws.lambda.inputs.RuntimeManagementConfigState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS Lambda Runtime Management Config.
 * 
 * Refer to the [AWS Lambda documentation](https://docs.aws.amazon.com/lambda/latest/dg/lambda-runtimes.html) for supported runtimes.
 * 
 * &gt; Deletion of this resource returns the runtime update mode to `Auto` (the default behavior).
 * To leave the configured runtime management options in-place, use a `removed` block with the destroy lifecycle set to `false`.
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
 * import com.pulumi.aws.lambda.RuntimeManagementConfig;
 * import com.pulumi.aws.lambda.RuntimeManagementConfigArgs;
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
 *         var example = new RuntimeManagementConfig("example", RuntimeManagementConfigArgs.builder()
 *             .functionName(test.functionName())
 *             .updateRuntimeOn("FunctionUpdate")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### `Manual` Update
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.lambda.RuntimeManagementConfig;
 * import com.pulumi.aws.lambda.RuntimeManagementConfigArgs;
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
 *         var example = new RuntimeManagementConfig("example", RuntimeManagementConfigArgs.builder()
 *             .functionName(test.functionName())
 *             .updateRuntimeOn("Manual")
 *             .runtimeVersionArn("arn:aws:lambda:us-east-1::runtime:abcd1234")
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * &gt; Once the runtime update mode is set to `Manual`, the `aws.lambda.Function` `runtime` cannot be updated. To upgrade a runtime, the `update_runtime_on` argument must be set to `Auto` or `FunctionUpdate` prior to changing the function&#39;s `runtime` argument.
 * 
 * ## Import
 * 
 * Using `pulumi import`, import Lambda Runtime Management Config using a comma-delimited string combining `function_name` and `qualifier`. For example:
 * 
 * ```sh
 * $ pulumi import aws:lambda/runtimeManagementConfig:RuntimeManagementConfig example my-function,$LATEST
 * ```
 * 
 */
@ResourceType(type="aws:lambda/runtimeManagementConfig:RuntimeManagementConfig")
public class RuntimeManagementConfig extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the function.
     * 
     */
    @Export(name="functionArn", refs={String.class}, tree="[0]")
    private Output<String> functionArn;

    /**
     * @return ARN of the function.
     * 
     */
    public Output<String> functionArn() {
        return this.functionArn;
    }
    /**
     * Name or ARN of the Lambda function.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="functionName", refs={String.class}, tree="[0]")
    private Output<String> functionName;

    /**
     * @return Name or ARN of the Lambda function.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> functionName() {
        return this.functionName;
    }
    /**
     * Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
     * 
     */
    @Export(name="qualifier", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> qualifier;

    /**
     * @return Version of the function. This can be `$LATEST` or a published version number. If omitted, this resource will manage the runtime configuration for `$LATEST`.
     * 
     */
    public Output<Optional<String>> qualifier() {
        return Codegen.optional(this.qualifier);
    }
    /**
     * ARN of the runtime version. Only required when `update_runtime_on` is `Manual`.
     * 
     */
    @Export(name="runtimeVersionArn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> runtimeVersionArn;

    /**
     * @return ARN of the runtime version. Only required when `update_runtime_on` is `Manual`.
     * 
     */
    public Output<Optional<String>> runtimeVersionArn() {
        return Codegen.optional(this.runtimeVersionArn);
    }
    /**
     * Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
     * 
     */
    @Export(name="updateRuntimeOn", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> updateRuntimeOn;

    /**
     * @return Runtime update mode. Valid values are `Auto`, `FunctionUpdate`, and `Manual`. When a function is created, the default mode is `Auto`.
     * 
     */
    public Output<Optional<String>> updateRuntimeOn() {
        return Codegen.optional(this.updateRuntimeOn);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public RuntimeManagementConfig(java.lang.String name) {
        this(name, RuntimeManagementConfigArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RuntimeManagementConfig(java.lang.String name, RuntimeManagementConfigArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RuntimeManagementConfig(java.lang.String name, RuntimeManagementConfigArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lambda/runtimeManagementConfig:RuntimeManagementConfig", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RuntimeManagementConfig(java.lang.String name, Output<java.lang.String> id, @Nullable RuntimeManagementConfigState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lambda/runtimeManagementConfig:RuntimeManagementConfig", name, state, makeResourceOptions(options, id), false);
    }

    private static RuntimeManagementConfigArgs makeArgs(RuntimeManagementConfigArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RuntimeManagementConfigArgs.Empty : args;
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
    public static RuntimeManagementConfig get(java.lang.String name, Output<java.lang.String> id, @Nullable RuntimeManagementConfigState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RuntimeManagementConfig(name, id, state, options);
    }
}
