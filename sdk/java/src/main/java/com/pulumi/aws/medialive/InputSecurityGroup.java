// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.medialive;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.medialive.InputSecurityGroupArgs;
import com.pulumi.aws.medialive.inputs.InputSecurityGroupState;
import com.pulumi.aws.medialive.outputs.InputSecurityGroupWhitelistRule;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Resource for managing an AWS MediaLive InputSecurityGroup.
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
 * import com.pulumi.aws.medialive.InputSecurityGroup;
 * import com.pulumi.aws.medialive.InputSecurityGroupArgs;
 * import com.pulumi.aws.medialive.inputs.InputSecurityGroupWhitelistRuleArgs;
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
 *         var example = new InputSecurityGroup("example", InputSecurityGroupArgs.builder()
 *             .whitelistRules(InputSecurityGroupWhitelistRuleArgs.builder()
 *                 .cidr("10.0.0.8/32")
 *                 .build())
 *             .tags(Map.of("ENVIRONMENT", "prod"))
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
 * Using `pulumi import`, import MediaLive InputSecurityGroup using the `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:medialive/inputSecurityGroup:InputSecurityGroup example 123456
 * ```
 * 
 */
@ResourceType(type="aws:medialive/inputSecurityGroup:InputSecurityGroup")
public class InputSecurityGroup extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the InputSecurityGroup.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the InputSecurityGroup.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The list of inputs currently using this InputSecurityGroup.
     * 
     */
    @Export(name="inputs", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> inputs;

    /**
     * @return The list of inputs currently using this InputSecurityGroup.
     * 
     */
    public Output<List<String>> inputs() {
        return this.inputs;
    }
    /**
     * A map of tags to assign to the InputSecurityGroup. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return A map of tags to assign to the InputSecurityGroup. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    public Output<Optional<Map<String,String>>> tags() {
        return Codegen.optional(this.tags);
    }
    /**
     * @deprecated
     * Please use `tags` instead.
     * 
     */
    @Deprecated /* Please use `tags` instead. */
    @Export(name="tagsAll", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output<Map<String,String>> tagsAll;

    public Output<Map<String,String>> tagsAll() {
        return this.tagsAll;
    }
    /**
     * Whitelist rules. See Whitelist Rules for more details.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="whitelistRules", refs={List.class,InputSecurityGroupWhitelistRule.class}, tree="[0,1]")
    private Output<List<InputSecurityGroupWhitelistRule>> whitelistRules;

    /**
     * @return Whitelist rules. See Whitelist Rules for more details.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<List<InputSecurityGroupWhitelistRule>> whitelistRules() {
        return this.whitelistRules;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public InputSecurityGroup(java.lang.String name) {
        this(name, InputSecurityGroupArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public InputSecurityGroup(java.lang.String name, InputSecurityGroupArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public InputSecurityGroup(java.lang.String name, InputSecurityGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:medialive/inputSecurityGroup:InputSecurityGroup", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private InputSecurityGroup(java.lang.String name, Output<java.lang.String> id, @Nullable InputSecurityGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:medialive/inputSecurityGroup:InputSecurityGroup", name, state, makeResourceOptions(options, id), false);
    }

    private static InputSecurityGroupArgs makeArgs(InputSecurityGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? InputSecurityGroupArgs.Empty : args;
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
    public static InputSecurityGroup get(java.lang.String name, Output<java.lang.String> id, @Nullable InputSecurityGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new InputSecurityGroup(name, id, state, options);
    }
}
