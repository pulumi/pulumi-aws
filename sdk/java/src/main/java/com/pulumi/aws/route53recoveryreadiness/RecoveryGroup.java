// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.route53recoveryreadiness;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.route53recoveryreadiness.RecoveryGroupArgs;
import com.pulumi.aws.route53recoveryreadiness.inputs.RecoveryGroupState;
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
 * Provides an AWS Route 53 Recovery Readiness Recovery Group.
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
 * import com.pulumi.aws.route53recoveryreadiness.RecoveryGroup;
 * import com.pulumi.aws.route53recoveryreadiness.RecoveryGroupArgs;
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
 *         var example = new RecoveryGroup("example", RecoveryGroupArgs.builder()
 *             .recoveryGroupName("my-high-availability-app")
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
 * Using `pulumi import`, import Route53 Recovery Readiness recovery groups using the recovery group name. For example:
 * 
 * ```sh
 * $ pulumi import aws:route53recoveryreadiness/recoveryGroup:RecoveryGroup my-high-availability-app my-high-availability-app
 * ```
 * 
 */
@ResourceType(type="aws:route53recoveryreadiness/recoveryGroup:RecoveryGroup")
public class RecoveryGroup extends com.pulumi.resources.CustomResource {
    /**
     * ARN of the recovery group
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the recovery group
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * List of cell arns to add as nested fault domains within this recovery group
     * 
     */
    @Export(name="cells", refs={List.class,String.class}, tree="[0,1]")
    private Output</* @Nullable */ List<String>> cells;

    /**
     * @return List of cell arns to add as nested fault domains within this recovery group
     * 
     */
    public Output<Optional<List<String>>> cells() {
        return Codegen.optional(this.cells);
    }
    /**
     * A unique name describing the recovery group.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="recoveryGroupName", refs={String.class}, tree="[0]")
    private Output<String> recoveryGroupName;

    /**
     * @return A unique name describing the recovery group.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> recoveryGroupName() {
        return this.recoveryGroupName;
    }
    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level
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
    public RecoveryGroup(java.lang.String name) {
        this(name, RecoveryGroupArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public RecoveryGroup(java.lang.String name, RecoveryGroupArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public RecoveryGroup(java.lang.String name, RecoveryGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:route53recoveryreadiness/recoveryGroup:RecoveryGroup", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private RecoveryGroup(java.lang.String name, Output<java.lang.String> id, @Nullable RecoveryGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:route53recoveryreadiness/recoveryGroup:RecoveryGroup", name, state, makeResourceOptions(options, id), false);
    }

    private static RecoveryGroupArgs makeArgs(RecoveryGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RecoveryGroupArgs.Empty : args;
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
    public static RecoveryGroup get(java.lang.String name, Output<java.lang.String> id, @Nullable RecoveryGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new RecoveryGroup(name, id, state, options);
    }
}
