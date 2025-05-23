// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.ecr;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.ecr.RepositoryArgs;
import com.pulumi.aws.ecr.inputs.RepositoryState;
import com.pulumi.aws.ecr.outputs.RepositoryEncryptionConfiguration;
import com.pulumi.aws.ecr.outputs.RepositoryImageScanningConfiguration;
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
 * Provides an Elastic Container Registry Repository.
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
 * import com.pulumi.aws.ecr.Repository;
 * import com.pulumi.aws.ecr.RepositoryArgs;
 * import com.pulumi.aws.ecr.inputs.RepositoryImageScanningConfigurationArgs;
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
 *         var foo = new Repository("foo", RepositoryArgs.builder()
 *             .name("bar")
 *             .imageTagMutability("MUTABLE")
 *             .imageScanningConfiguration(RepositoryImageScanningConfigurationArgs.builder()
 *                 .scanOnPush(true)
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
 * Using `pulumi import`, import ECR Repositories using the `name`. For example:
 * 
 * ```sh
 * $ pulumi import aws:ecr/repository:Repository service test-service
 * ```
 * 
 */
@ResourceType(type="aws:ecr/repository:Repository")
public class Repository extends com.pulumi.resources.CustomResource {
    /**
     * Full ARN of the repository.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return Full ARN of the repository.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Encryption configuration for the repository. See below for schema.
     * 
     */
    @Export(name="encryptionConfigurations", refs={List.class,RepositoryEncryptionConfiguration.class}, tree="[0,1]")
    private Output</* @Nullable */ List<RepositoryEncryptionConfiguration>> encryptionConfigurations;

    /**
     * @return Encryption configuration for the repository. See below for schema.
     * 
     */
    public Output<Optional<List<RepositoryEncryptionConfiguration>>> encryptionConfigurations() {
        return Codegen.optional(this.encryptionConfigurations);
    }
    /**
     * If `true`, will delete the repository even if it contains images.
     * Defaults to `false`.
     * 
     */
    @Export(name="forceDelete", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> forceDelete;

    /**
     * @return If `true`, will delete the repository even if it contains images.
     * Defaults to `false`.
     * 
     */
    public Output<Optional<Boolean>> forceDelete() {
        return Codegen.optional(this.forceDelete);
    }
    /**
     * Configuration block that defines image scanning configuration for the repository. By default, image scanning must be manually triggered. See the [ECR User Guide](https://docs.aws.amazon.com/AmazonECR/latest/userguide/image-scanning.html) for more information about image scanning.
     * 
     */
    @Export(name="imageScanningConfiguration", refs={RepositoryImageScanningConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ RepositoryImageScanningConfiguration> imageScanningConfiguration;

    /**
     * @return Configuration block that defines image scanning configuration for the repository. By default, image scanning must be manually triggered. See the [ECR User Guide](https://docs.aws.amazon.com/AmazonECR/latest/userguide/image-scanning.html) for more information about image scanning.
     * 
     */
    public Output<Optional<RepositoryImageScanningConfiguration>> imageScanningConfiguration() {
        return Codegen.optional(this.imageScanningConfiguration);
    }
    /**
     * The tag mutability setting for the repository. Must be one of: `MUTABLE` or `IMMUTABLE`. Defaults to `MUTABLE`.
     * 
     */
    @Export(name="imageTagMutability", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> imageTagMutability;

    /**
     * @return The tag mutability setting for the repository. Must be one of: `MUTABLE` or `IMMUTABLE`. Defaults to `MUTABLE`.
     * 
     */
    public Output<Optional<String>> imageTagMutability() {
        return Codegen.optional(this.imageTagMutability);
    }
    /**
     * Name of the repository.
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Name of the repository.
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * The registry ID where the repository was created.
     * 
     */
    @Export(name="registryId", refs={String.class}, tree="[0]")
    private Output<String> registryId;

    /**
     * @return The registry ID where the repository was created.
     * 
     */
    public Output<String> registryId() {
        return this.registryId;
    }
    /**
     * The URL of the repository (in the form `aws_account_id.dkr.ecr.region.amazonaws.com/repositoryName`).
     * 
     */
    @Export(name="repositoryUrl", refs={String.class}, tree="[0]")
    private Output<String> repositoryUrl;

    /**
     * @return The URL of the repository (in the form `aws_account_id.dkr.ecr.region.amazonaws.com/repositoryName`).
     * 
     */
    public Output<String> repositoryUrl() {
        return this.repositoryUrl;
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
    public Repository(java.lang.String name) {
        this(name, RepositoryArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Repository(java.lang.String name, @Nullable RepositoryArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Repository(java.lang.String name, @Nullable RepositoryArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ecr/repository:Repository", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Repository(java.lang.String name, Output<java.lang.String> id, @Nullable RepositoryState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:ecr/repository:Repository", name, state, makeResourceOptions(options, id), false);
    }

    private static RepositoryArgs makeArgs(@Nullable RepositoryArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? RepositoryArgs.Empty : args;
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
    public static Repository get(java.lang.String name, Output<java.lang.String> id, @Nullable RepositoryState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Repository(name, id, state, options);
    }
}
