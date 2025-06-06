// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.verifiedaccess;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.verifiedaccess.InstanceArgs;
import com.pulumi.aws.verifiedaccess.inputs.InstanceState;
import com.pulumi.aws.verifiedaccess.outputs.InstanceVerifiedAccessTrustProvider;
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
 * Resource for managing a Verified Access Instance.
 * 
 * ## Example Usage
 * 
 * ### Basic
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.verifiedaccess.Instance;
 * import com.pulumi.aws.verifiedaccess.InstanceArgs;
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
 *         var example = new Instance("example", InstanceArgs.builder()
 *             .description("example")
 *             .tags(Map.of("Name", "example"))
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### With `fips_enabled`
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.verifiedaccess.Instance;
 * import com.pulumi.aws.verifiedaccess.InstanceArgs;
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
 *         var example = new Instance("example", InstanceArgs.builder()
 *             .fipsEnabled(true)
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 * ### With `cidr_endpoints_custom_subdomain`
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.verifiedaccess.Instance;
 * import com.pulumi.aws.verifiedaccess.InstanceArgs;
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
 *         var example = new Instance("example", InstanceArgs.builder()
 *             .cidrEndpointsCustomSubdomain("test.example.com")
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
 * Using `pulumi import`, import Verified Access Instances using the  `id`. For example:
 * 
 * ```sh
 * $ pulumi import aws:verifiedaccess/instance:Instance example vai-1234567890abcdef0
 * ```
 * 
 */
@ResourceType(type="aws:verifiedaccess/instance:Instance")
public class Instance extends com.pulumi.resources.CustomResource {
    /**
     * The custom subdomain for the CIDR endpoints.
     * 
     */
    @Export(name="cidrEndpointsCustomSubdomain", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> cidrEndpointsCustomSubdomain;

    /**
     * @return The custom subdomain for the CIDR endpoints.
     * 
     */
    public Output<Optional<String>> cidrEndpointsCustomSubdomain() {
        return Codegen.optional(this.cidrEndpointsCustomSubdomain);
    }
    /**
     * The time that the Verified Access Instance was created.
     * 
     */
    @Export(name="creationTime", refs={String.class}, tree="[0]")
    private Output<String> creationTime;

    /**
     * @return The time that the Verified Access Instance was created.
     * 
     */
    public Output<String> creationTime() {
        return this.creationTime;
    }
    /**
     * A description for the AWS Verified Access Instance.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return A description for the AWS Verified Access Instance.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * Enable or disable support for Federal Information Processing Standards (FIPS) on the AWS Verified Access Instance.
     * 
     */
    @Export(name="fipsEnabled", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> fipsEnabled;

    /**
     * @return Enable or disable support for Federal Information Processing Standards (FIPS) on the AWS Verified Access Instance.
     * 
     */
    public Output<Optional<Boolean>> fipsEnabled() {
        return Codegen.optional(this.fipsEnabled);
    }
    /**
     * The time that the Verified Access Instance was last updated.
     * 
     */
    @Export(name="lastUpdatedTime", refs={String.class}, tree="[0]")
    private Output<String> lastUpdatedTime;

    /**
     * @return The time that the Verified Access Instance was last updated.
     * 
     */
    public Output<String> lastUpdatedTime() {
        return this.lastUpdatedTime;
    }
    @Export(name="nameServers", refs={List.class,String.class}, tree="[0,1]")
    private Output<List<String>> nameServers;

    public Output<List<String>> nameServers() {
        return this.nameServers;
    }
    /**
     * Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
     * One or more blocks of providing information about the AWS Verified Access Trust Providers. See verified_access_trust_providers below for details.One or more blocks
     * 
     */
    @Export(name="verifiedAccessTrustProviders", refs={List.class,InstanceVerifiedAccessTrustProvider.class}, tree="[0,1]")
    private Output<List<InstanceVerifiedAccessTrustProvider>> verifiedAccessTrustProviders;

    /**
     * @return One or more blocks of providing information about the AWS Verified Access Trust Providers. See verified_access_trust_providers below for details.One or more blocks
     * 
     */
    public Output<List<InstanceVerifiedAccessTrustProvider>> verifiedAccessTrustProviders() {
        return this.verifiedAccessTrustProviders;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Instance(java.lang.String name) {
        this(name, InstanceArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Instance(java.lang.String name, @Nullable InstanceArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Instance(java.lang.String name, @Nullable InstanceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:verifiedaccess/instance:Instance", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Instance(java.lang.String name, Output<java.lang.String> id, @Nullable InstanceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:verifiedaccess/instance:Instance", name, state, makeResourceOptions(options, id), false);
    }

    private static InstanceArgs makeArgs(@Nullable InstanceArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? InstanceArgs.Empty : args;
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
    public static Instance get(java.lang.String name, Output<java.lang.String> id, @Nullable InstanceState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Instance(name, id, state, options);
    }
}
