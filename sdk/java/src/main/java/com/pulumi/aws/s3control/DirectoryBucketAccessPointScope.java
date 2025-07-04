// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3control;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.s3control.DirectoryBucketAccessPointScopeArgs;
import com.pulumi.aws.s3control.inputs.DirectoryBucketAccessPointScopeState;
import com.pulumi.aws.s3control.outputs.DirectoryBucketAccessPointScopeScope;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import java.util.Optional;
import javax.annotation.Nullable;

/**
 * ## Example Usage
 * 
 * ### S3 Access Point Scope for a directory bucket in an AWS Local Zone
 * 
 * &lt;!--Start PulumiCodeChooser --&gt;
 * <pre>
 * {@code
 * package generated_program;
 * 
 * import com.pulumi.Context;
 * import com.pulumi.Pulumi;
 * import com.pulumi.core.Output;
 * import com.pulumi.aws.AwsFunctions;
 * import com.pulumi.aws.inputs.GetAvailabilityZonesArgs;
 * import com.pulumi.aws.s3.DirectoryBucket;
 * import com.pulumi.aws.s3.DirectoryBucketArgs;
 * import com.pulumi.aws.s3.inputs.DirectoryBucketLocationArgs;
 * import com.pulumi.aws.s3.AccessPoint;
 * import com.pulumi.aws.s3.AccessPointArgs;
 * import com.pulumi.aws.s3control.DirectoryBucketAccessPointScope;
 * import com.pulumi.aws.s3control.DirectoryBucketAccessPointScopeArgs;
 * import com.pulumi.aws.s3control.inputs.DirectoryBucketAccessPointScopeScopeArgs;
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
 *         final var available = AwsFunctions.getAvailabilityZones(GetAvailabilityZonesArgs.builder()
 *             .state("available")
 *             .build());
 * 
 *         var example = new DirectoryBucket("example", DirectoryBucketArgs.builder()
 *             .bucket("example--zoneId--x-s3")
 *             .location(DirectoryBucketLocationArgs.builder()
 *                 .name(available.zoneIds()[0])
 *                 .build())
 *             .build());
 * 
 *         var exampleAccessPoint = new AccessPoint("exampleAccessPoint", AccessPointArgs.builder()
 *             .bucket(example.id())
 *             .name("example--zoneId--xa-s3")
 *             .build());
 * 
 *         var exampleDirectoryBucketAccessPointScope = new DirectoryBucketAccessPointScope("exampleDirectoryBucketAccessPointScope", DirectoryBucketAccessPointScopeArgs.builder()
 *             .name("example--zoneId--xa-s3")
 *             .accountId("123456789012")
 *             .scope(DirectoryBucketAccessPointScopeScopeArgs.builder()
 *                 .permissions(                
 *                     "GetObject",
 *                     "ListBucket")
 *                 .prefixes(                
 *                     "myobject1.csv",
 *                     "myobject2*")
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
 * Using `pulumi import`, import Access Point Scope using access point name and AWS account ID separated by a colon (`,`). For example:
 * 
 * ```sh
 * $ pulumi import aws:s3control/directoryBucketAccessPointScope:DirectoryBucketAccessPointScope example example--zoneid--xa-s3,123456789012
 * ```
 * 
 */
@ResourceType(type="aws:s3control/directoryBucketAccessPointScope:DirectoryBucketAccessPointScope")
public class DirectoryBucketAccessPointScope extends com.pulumi.resources.CustomResource {
    /**
     * The AWS account ID that owns the specified access point.
     * 
     */
    @Export(name="accountId", refs={String.class}, tree="[0]")
    private Output<String> accountId;

    /**
     * @return The AWS account ID that owns the specified access point.
     * 
     */
    public Output<String> accountId() {
        return this.accountId;
    }
    /**
     * The name of the access point that you want to apply the scope to.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return The name of the access point that you want to apply the scope to.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * . Scope is used to restrict access to specific prefixes, API operations, or a combination of both. To remove the `scope`, set it to `{permissions=[] prefixes=[]}`. The default scope is `{permissions=[] prefixes=[]}`.
     * 
     */
    @Export(name="scope", refs={DirectoryBucketAccessPointScopeScope.class}, tree="[0]")
    private Output</* @Nullable */ DirectoryBucketAccessPointScopeScope> scope;

    /**
     * @return . Scope is used to restrict access to specific prefixes, API operations, or a combination of both. To remove the `scope`, set it to `{permissions=[] prefixes=[]}`. The default scope is `{permissions=[] prefixes=[]}`.
     * 
     */
    public Output<Optional<DirectoryBucketAccessPointScopeScope>> scope() {
        return Codegen.optional(this.scope);
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public DirectoryBucketAccessPointScope(java.lang.String name) {
        this(name, DirectoryBucketAccessPointScopeArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public DirectoryBucketAccessPointScope(java.lang.String name, DirectoryBucketAccessPointScopeArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public DirectoryBucketAccessPointScope(java.lang.String name, DirectoryBucketAccessPointScopeArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3control/directoryBucketAccessPointScope:DirectoryBucketAccessPointScope", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private DirectoryBucketAccessPointScope(java.lang.String name, Output<java.lang.String> id, @Nullable DirectoryBucketAccessPointScopeState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3control/directoryBucketAccessPointScope:DirectoryBucketAccessPointScope", name, state, makeResourceOptions(options, id), false);
    }

    private static DirectoryBucketAccessPointScopeArgs makeArgs(DirectoryBucketAccessPointScopeArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? DirectoryBucketAccessPointScopeArgs.Empty : args;
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
    public static DirectoryBucketAccessPointScope get(java.lang.String name, Output<java.lang.String> id, @Nullable DirectoryBucketAccessPointScopeState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new DirectoryBucketAccessPointScope(name, id, state, options);
    }
}
