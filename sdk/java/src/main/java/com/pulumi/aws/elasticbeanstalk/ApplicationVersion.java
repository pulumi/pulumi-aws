// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.elasticbeanstalk;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.elasticbeanstalk.ApplicationVersionArgs;
import com.pulumi.aws.elasticbeanstalk.inputs.ApplicationVersionState;
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
 * Provides an Elastic Beanstalk Application Version Resource. Elastic Beanstalk allows
 * you to deploy and manage applications in the AWS cloud without worrying about
 * the infrastructure that runs those applications.
 * 
 * This resource creates a Beanstalk Application Version that can be deployed to a Beanstalk
 * Environment.
 * 
 * &gt; **NOTE on Application Version Resource:**  When using the Application Version resource with multiple
 * Elastic Beanstalk Environments it is possible that an error may be returned
 * when attempting to delete an Application Version while it is still in use by a different environment.
 * To work around this you can either create each environment in a separate AWS account or create your `aws.elasticbeanstalk.ApplicationVersion` resources with a unique names in your Elastic Beanstalk Application. For example &amp;lt;revision&amp;gt;-&amp;lt;environment&amp;gt;.
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
 * import com.pulumi.aws.s3.BucketV2;
 * import com.pulumi.aws.s3.BucketV2Args;
 * import com.pulumi.aws.s3.BucketObjectv2;
 * import com.pulumi.aws.s3.BucketObjectv2Args;
 * import com.pulumi.aws.elasticbeanstalk.Application;
 * import com.pulumi.aws.elasticbeanstalk.ApplicationArgs;
 * import com.pulumi.aws.elasticbeanstalk.ApplicationVersion;
 * import com.pulumi.aws.elasticbeanstalk.ApplicationVersionArgs;
 * import com.pulumi.asset.FileAsset;
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
 *         var default_ = new BucketV2("default", BucketV2Args.builder()
 *             .bucket("tftest.applicationversion.bucket")
 *             .build());
 * 
 *         var defaultBucketObjectv2 = new BucketObjectv2("defaultBucketObjectv2", BucketObjectv2Args.builder()
 *             .bucket(default_.id())
 *             .key("beanstalk/go-v1.zip")
 *             .source(new FileAsset("go-v1.zip"))
 *             .build());
 * 
 *         var defaultApplication = new Application("defaultApplication", ApplicationArgs.builder()
 *             .name("tf-test-name")
 *             .description("tf-test-desc")
 *             .build());
 * 
 *         var defaultApplicationVersion = new ApplicationVersion("defaultApplicationVersion", ApplicationVersionArgs.builder()
 *             .name("tf-test-version-label")
 *             .application("tf-test-name")
 *             .description("application version")
 *             .bucket(default_.id())
 *             .key(defaultBucketObjectv2.id())
 *             .build());
 * 
 *     }
 * }
 * }
 * </pre>
 * &lt;!--End PulumiCodeChooser --&gt;
 * 
 */
@ResourceType(type="aws:elasticbeanstalk/applicationVersion:ApplicationVersion")
public class ApplicationVersion extends com.pulumi.resources.CustomResource {
    /**
     * Name of the Beanstalk Application the version is associated with.
     * 
     */
    @Export(name="application", refs={String.class}, tree="[0]")
    private Output<String> application;

    /**
     * @return Name of the Beanstalk Application the version is associated with.
     * 
     */
    public Output<String> application() {
        return this.application;
    }
    /**
     * ARN assigned by AWS for this Elastic Beanstalk Application.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN assigned by AWS for this Elastic Beanstalk Application.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * S3 bucket that contains the Application Version source bundle.
     * 
     */
    @Export(name="bucket", refs={String.class}, tree="[0]")
    private Output<String> bucket;

    /**
     * @return S3 bucket that contains the Application Version source bundle.
     * 
     */
    public Output<String> bucket() {
        return this.bucket;
    }
    /**
     * Short description of the Application Version.
     * 
     */
    @Export(name="description", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> description;

    /**
     * @return Short description of the Application Version.
     * 
     */
    public Output<Optional<String>> description() {
        return Codegen.optional(this.description);
    }
    /**
     * On delete, force an Application Version to be deleted when it may be in use by multiple Elastic Beanstalk Environments.
     * 
     */
    @Export(name="forceDelete", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> forceDelete;

    /**
     * @return On delete, force an Application Version to be deleted when it may be in use by multiple Elastic Beanstalk Environments.
     * 
     */
    public Output<Optional<Boolean>> forceDelete() {
        return Codegen.optional(this.forceDelete);
    }
    /**
     * S3 object that is the Application Version source bundle.
     * 
     */
    @Export(name="key", refs={String.class}, tree="[0]")
    private Output<String> key;

    /**
     * @return S3 object that is the Application Version source bundle.
     * 
     */
    public Output<String> key() {
        return this.key;
    }
    /**
     * Unique name for the this Application Version.
     * 
     * The following arguments are optional:
     * 
     */
    @Export(name="name", refs={String.class}, tree="[0]")
    private Output<String> name;

    /**
     * @return Unique name for the this Application Version.
     * 
     * The following arguments are optional:
     * 
     */
    public Output<String> name() {
        return this.name;
    }
    /**
     * Pre-processes and validates the environment manifest (env.yaml ) and configuration files (*.config files in the .ebextensions folder) in the source bundle. Validating configuration files can identify issues prior to deploying the application version to an environment. You must turn processing on for application versions that you create using AWS CodeBuild or AWS CodeCommit. For application versions built from a source bundle in Amazon S3, processing is optional. It validates Elastic Beanstalk configuration files. It doesn’t validate your application’s configuration files, like proxy server or Docker configuration.
     * 
     */
    @Export(name="process", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> process;

    /**
     * @return Pre-processes and validates the environment manifest (env.yaml ) and configuration files (*.config files in the .ebextensions folder) in the source bundle. Validating configuration files can identify issues prior to deploying the application version to an environment. You must turn processing on for application versions that you create using AWS CodeBuild or AWS CodeCommit. For application versions built from a source bundle in Amazon S3, processing is optional. It validates Elastic Beanstalk configuration files. It doesn’t validate your application’s configuration files, like proxy server or Docker configuration.
     * 
     */
    public Output<Optional<Boolean>> process() {
        return Codegen.optional(this.process);
    }
    /**
     * Key-value map of tags for the Elastic Beanstalk Application Version. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Key-value map of tags for the Elastic Beanstalk Application Version. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
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
    public ApplicationVersion(java.lang.String name) {
        this(name, ApplicationVersionArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public ApplicationVersion(java.lang.String name, ApplicationVersionArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public ApplicationVersion(java.lang.String name, ApplicationVersionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:elasticbeanstalk/applicationVersion:ApplicationVersion", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private ApplicationVersion(java.lang.String name, Output<java.lang.String> id, @Nullable ApplicationVersionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:elasticbeanstalk/applicationVersion:ApplicationVersion", name, state, makeResourceOptions(options, id), false);
    }

    private static ApplicationVersionArgs makeArgs(ApplicationVersionArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? ApplicationVersionArgs.Empty : args;
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
    public static ApplicationVersion get(java.lang.String name, Output<java.lang.String> id, @Nullable ApplicationVersionState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new ApplicationVersion(name, id, state, options);
    }
}
