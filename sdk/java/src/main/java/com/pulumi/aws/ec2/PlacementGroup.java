// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ec2;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ec2.PlacementGroupArgs;
import com.pulumi.aws.ec2.inputs.PlacementGroupState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.Integer;
import java.lang.String;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * Provides an EC2 placement group. Read more about placement groups
 * in [AWS Docs](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/placement-groups.html).
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
 * import com.pulumi.aws.ec2.PlacementGroup;
 * import com.pulumi.aws.ec2.PlacementGroupArgs;
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
 *         var web = new PlacementGroup("web", PlacementGroupArgs.builder()
 *             .name("hunky-dory-pg")
 *             .strategy("cluster")
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
 * Using `pulumi import`, import placement groups using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:ec2/placementGroup:PlacementGroup prod_pg production-placement-group
 * ```
 * 
 */
@ResourceType(type="aws:ec2/placementGroup:PlacementGroup")
public class PlacementGroup extends com.pulumi.resources.CustomResource {
    /**
     * Amazon Resource Name (ARN) of the placement group.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Amazon Resource Name (ARN) of the placement group.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * The name of the placement group.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the placement group.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The number of partitions to create in the
     * placement group.  Can only be specified when the `strategy` is set to
     * `partition`.  Valid values are 1 - 7 (default is `2`).
     * 
     */
    @Export(name="partitionCount", refs={Integer.class}, tree="[0]")
    private Output<Integer> partitionCount;

    /**
     * @return The number of partitions to create in the
     * placement group.  Can only be specified when the `strategy` is set to
     * `partition`.  Valid values are 1 - 7 (default is `2`).
     * 
     */
    public Output<Integer> partitionCount() {
        return this.partitionCount;
    }
    /**
     * The ID of the placement group.
     * 
     */
    @Export(name="placementGroupId", refs={String.class}, tree="[0]")
    private Output<String> placementGroupId;

    /**
     * @return The ID of the placement group.
     * 
     */
    public Output<String> placementGroupId() {
        return this.placementGroupId;
    }
    /**
     * Determines how placement groups spread instances. Can only be used
     * when the `strategy` is set to `spread`. Can be `host` or `rack`. `host` can only be used for Outpost placement groups. Defaults to `rack`.
     * 
     */
    @Export(name="spreadLevel", refs={String.class}, tree="[0]")
    private Output<String> spreadLevel;

    /**
     * @return Determines how placement groups spread instances. Can only be used
     * when the `strategy` is set to `spread`. Can be `host` or `rack`. `host` can only be used for Outpost placement groups. Defaults to `rack`.
     * 
     */
    public Output<String> spreadLevel() {
        return this.spreadLevel;
    }
    /**
     * The placement strategy. Can be `cluster`, `partition` or `spread`.
     * 
     */
    @Export(name="strategy", refs={String.class}, tree="[0]")
    private Output<String> strategy;

    /**
     * @return The placement strategy. Can be `cluster`, `partition` or `spread`.
     * 
     */
    public Output<String> strategy() {
        return this.strategy;
    }
    /**
     * Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of resource tags. .If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public PlacementGroup(java.lang.String name) {
        this(name, PlacementGroupArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public PlacementGroup(java.lang.String name, PlacementGroupArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public PlacementGroup(java.lang.String name, PlacementGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/placementGroup:PlacementGroup", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private PlacementGroup(java.lang.String name, Output<java.lang.String> id, @Nullable PlacementGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ec2/placementGroup:PlacementGroup", name, state, makeResourceOptions(options, id), false);
    }

    private static PlacementGroupArgs makeArgs(PlacementGroupArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? PlacementGroupArgs.Empty : args;
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
    public static PlacementGroup get(java.lang.String name, Output<java.lang.String> id, @Nullable PlacementGroupState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new PlacementGroup(name, id, state, options);
    }
}
