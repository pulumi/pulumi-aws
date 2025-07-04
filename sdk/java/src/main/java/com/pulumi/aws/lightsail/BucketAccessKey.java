// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.lightsail.BucketAccessKeyArgs;
import com.pulumi.aws.lightsail.inputs.BucketAccessKeyState;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Export;
import com.pulumi.core.annotations.ResourceType;
import com.pulumi.core.internal.Codegen;
import java.lang.String;
import javax.annotation.Nullable;

/**
 * Manages a Lightsail bucket access key. Use this resource to create credentials that allow programmatic access to your Lightsail bucket via API requests.
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
 * import com.pulumi.aws.lightsail.Bucket;
 * import com.pulumi.aws.lightsail.BucketArgs;
 * import com.pulumi.aws.lightsail.BucketAccessKey;
 * import com.pulumi.aws.lightsail.BucketAccessKeyArgs;
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
 *         var example = new Bucket("example", BucketArgs.builder()
 *             .name("example-bucket")
 *             .bundleId("small_1_0")
 *             .build());
 * 
 *         var exampleBucketAccessKey = new BucketAccessKey("exampleBucketAccessKey", BucketAccessKeyArgs.builder()
 *             .bucketName(example.id())
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
 * Using `pulumi import`, import `aws_lightsail_bucket_access_key` using the `id` attribute. For example:
 * 
 * ```sh
 * $ pulumi import aws:lightsail/bucketAccessKey:BucketAccessKey example example-bucket,AKIAIOSFODNN7EXAMPLE
 * ```
 * 
 */
@ResourceType(type="aws:lightsail/bucketAccessKey:BucketAccessKey")
public class BucketAccessKey extends com.pulumi.resources.CustomResource {
    /**
     * Access key ID.
     * 
     */
    @Export(name="accessKeyId", refs={String.class}, tree="[0]")
    private Output<String> accessKeyId;

    /**
     * @return Access key ID.
     * 
     */
    public Output<String> accessKeyId() {
        return this.accessKeyId;
    }
    /**
     * Name of the bucket that the access key will belong to and grant access to.
     * 
     */
    @Export(name="bucketName", refs={String.class}, tree="[0]")
    private Output<String> bucketName;

    /**
     * @return Name of the bucket that the access key will belong to and grant access to.
     * 
     */
    public Output<String> bucketName() {
        return this.bucketName;
    }
    /**
     * Date and time when the access key was created.
     * 
     */
    @Export(name="createdAt", refs={String.class}, tree="[0]")
    private Output<String> createdAt;

    /**
     * @return Date and time when the access key was created.
     * 
     */
    public Output<String> createdAt() {
        return this.createdAt;
    }
    /**
     * Secret access key used to sign requests. This attribute is not available for imported resources. Note that this will be written to the state file.
     * 
     */
    @Export(name="secretAccessKey", refs={String.class}, tree="[0]")
    private Output<String> secretAccessKey;

    /**
     * @return Secret access key used to sign requests. This attribute is not available for imported resources. Note that this will be written to the state file.
     * 
     */
    public Output<String> secretAccessKey() {
        return this.secretAccessKey;
    }
    /**
     * Status of the access key.
     * 
     */
    @Export(name="status", refs={String.class}, tree="[0]")
    private Output<String> status;

    /**
     * @return Status of the access key.
     * 
     */
    public Output<String> status() {
        return this.status;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public BucketAccessKey(java.lang.String name) {
        this(name, BucketAccessKeyArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public BucketAccessKey(java.lang.String name, BucketAccessKeyArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public BucketAccessKey(java.lang.String name, BucketAccessKeyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lightsail/bucketAccessKey:BucketAccessKey", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private BucketAccessKey(java.lang.String name, Output<java.lang.String> id, @Nullable BucketAccessKeyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:lightsail/bucketAccessKey:BucketAccessKey", name, state, makeResourceOptions(options, id), false);
    }

    private static BucketAccessKeyArgs makeArgs(BucketAccessKeyArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? BucketAccessKeyArgs.Empty : args;
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
    public static BucketAccessKey get(java.lang.String name, Output<java.lang.String> id, @Nullable BucketAccessKeyState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new BucketAccessKey(name, id, state, options);
    }
}
