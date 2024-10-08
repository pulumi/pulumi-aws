// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.s3.BucketArgs;
import com.pulumi.aws.s3.inputs.BucketState;
import com.pulumi.aws.s3.outputs.BucketCorsRule;
import com.pulumi.aws.s3.outputs.BucketGrant;
import com.pulumi.aws.s3.outputs.BucketLifecycleRule;
import com.pulumi.aws.s3.outputs.BucketLogging;
import com.pulumi.aws.s3.outputs.BucketObjectLockConfiguration;
import com.pulumi.aws.s3.outputs.BucketReplicationConfiguration;
import com.pulumi.aws.s3.outputs.BucketServerSideEncryptionConfiguration;
import com.pulumi.aws.s3.outputs.BucketVersioning;
import com.pulumi.aws.s3.outputs.BucketWebsite;
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
 * Provides a S3 bucket resource.
 * 
 * &gt; This resource provides functionality for managing S3 general purpose buckets in an AWS Partition. To manage Amazon S3 Express directory buckets, use the `aws_directory_bucket` resource. To manage [S3 on Outposts](https://docs.aws.amazon.com/AmazonS3/latest/dev/S3onOutposts.html), use the `aws.s3control.Bucket` resource.
 * 
 * &gt; Object Lock can be enabled by using the `object_lock_enable` attribute or by using the `aws.s3.BucketObjectLockConfigurationV2` resource. Please note, that by using the resource, Object Lock can be enabled/disabled without destroying and recreating the bucket.
 * 
 * ## Example Usage
 * 
 * ### Private Bucket With Tags
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
 *         var example = new BucketV2("example", BucketV2Args.builder()
 *             .bucket("my-tf-test-bucket")
 *             .tags(Map.ofEntries(
 *                 Map.entry("Name", "My bucket"),
 *                 Map.entry("Environment", "Dev")
 *             ))
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
 * Using `pulumi import`, import S3 bucket using the `bucket`. For example:
 * 
 * ```sh
 * $ pulumi import aws:s3/bucket:Bucket bucket bucket-name
 * ```
 * 
 */
@ResourceType(type="aws:s3/bucket:Bucket")
public class Bucket extends com.pulumi.resources.CustomResource {
    /**
     * Sets the accelerate configuration of an existing bucket. Can be `Enabled` or `Suspended`. Cannot be used in `cn-north-1` or `us-gov-west-1`. This provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketAccelerateConfigurationV2` instead.
     * 
     */
    @Export(name="accelerationStatus", refs={String.class}, tree="[0]")
    private Output<String> accelerationStatus;

    /**
     * @return Sets the accelerate configuration of an existing bucket. Can be `Enabled` or `Suspended`. Cannot be used in `cn-north-1` or `us-gov-west-1`. This provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketAccelerateConfigurationV2` instead.
     * 
     */
    public Output<String> accelerationStatus() {
        return this.accelerationStatus;
    }
    /**
     * The [canned ACL](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl) to apply. Valid values are `private`, `public-read`, `public-read-write`, `aws-exec-read`, `authenticated-read`, and `log-delivery-write`. Defaults to `private`.  Conflicts with `grant`. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketAclV2` instead.
     * 
     */
    @Export(name="acl", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> acl;

    /**
     * @return The [canned ACL](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl) to apply. Valid values are `private`, `public-read`, `public-read-write`, `aws-exec-read`, `authenticated-read`, and `log-delivery-write`. Defaults to `private`.  Conflicts with `grant`. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketAclV2` instead.
     * 
     */
    public Output<Optional<String>> acl() {
        return Codegen.optional(this.acl);
    }
    /**
     * ARN of the bucket. Will be of format `arn:aws:s3:::bucketname`.
     * 
     */
    @Export(name="arn", refs={String.class}, tree="[0]")
    private Output<String> arn;

    /**
     * @return ARN of the bucket. Will be of format `arn:aws:s3:::bucketname`.
     * 
     */
    public Output<String> arn() {
        return this.arn;
    }
    /**
     * Name of the bucket. If omitted, the provider will assign a random, unique name. Must be lowercase and less than or equal to 63 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html). The name must not be in the format `[bucket_name]--[azid]--x-s3`. Use the `aws.s3.DirectoryBucket` resource to manage S3 Express buckets.
     * 
     */
    @Export(name="bucket", refs={String.class}, tree="[0]")
    private Output<String> bucket;

    /**
     * @return Name of the bucket. If omitted, the provider will assign a random, unique name. Must be lowercase and less than or equal to 63 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html). The name must not be in the format `[bucket_name]--[azid]--x-s3`. Use the `aws.s3.DirectoryBucket` resource to manage S3 Express buckets.
     * 
     */
    public Output<String> bucket() {
        return this.bucket;
    }
    /**
     * Bucket domain name. Will be of format `bucketname.s3.amazonaws.com`.
     * 
     */
    @Export(name="bucketDomainName", refs={String.class}, tree="[0]")
    private Output<String> bucketDomainName;

    /**
     * @return Bucket domain name. Will be of format `bucketname.s3.amazonaws.com`.
     * 
     */
    public Output<String> bucketDomainName() {
        return this.bucketDomainName;
    }
    /**
     * Creates a unique bucket name beginning with the specified prefix. Conflicts with `bucket`. Must be lowercase and less than or equal to 37 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html).
     * 
     */
    @Export(name="bucketPrefix", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> bucketPrefix;

    /**
     * @return Creates a unique bucket name beginning with the specified prefix. Conflicts with `bucket`. Must be lowercase and less than or equal to 37 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html).
     * 
     */
    public Output<Optional<String>> bucketPrefix() {
        return Codegen.optional(this.bucketPrefix);
    }
    /**
     * The bucket region-specific domain name. The bucket domain name including the region name. Please refer to the [S3 endpoints reference](https://docs.aws.amazon.com/general/latest/gr/s3.html#s3_region) for format. Note: AWS CloudFront allows specifying an S3 region-specific endpoint when creating an S3 origin. This will prevent redirect issues from CloudFront to the S3 Origin URL. For more information, see the [Virtual Hosted-Style Requests for Other Regions](https://docs.aws.amazon.com/AmazonS3/latest/userguide/VirtualHosting.html#deprecated-global-endpoint) section in the AWS S3 User Guide.
     * 
     */
    @Export(name="bucketRegionalDomainName", refs={String.class}, tree="[0]")
    private Output<String> bucketRegionalDomainName;

    /**
     * @return The bucket region-specific domain name. The bucket domain name including the region name. Please refer to the [S3 endpoints reference](https://docs.aws.amazon.com/general/latest/gr/s3.html#s3_region) for format. Note: AWS CloudFront allows specifying an S3 region-specific endpoint when creating an S3 origin. This will prevent redirect issues from CloudFront to the S3 Origin URL. For more information, see the [Virtual Hosted-Style Requests for Other Regions](https://docs.aws.amazon.com/AmazonS3/latest/userguide/VirtualHosting.html#deprecated-global-endpoint) section in the AWS S3 User Guide.
     * 
     */
    public Output<String> bucketRegionalDomainName() {
        return this.bucketRegionalDomainName;
    }
    /**
     * Rule of [Cross-Origin Resource Sharing](https://docs.aws.amazon.com/AmazonS3/latest/dev/cors.html). See CORS rule below for details. This provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketCorsConfigurationV2` instead.
     * 
     */
    @Export(name="corsRules", refs={List.class,BucketCorsRule.class}, tree="[0,1]")
    private Output</* @Nullable */ List<BucketCorsRule>> corsRules;

    /**
     * @return Rule of [Cross-Origin Resource Sharing](https://docs.aws.amazon.com/AmazonS3/latest/dev/cors.html). See CORS rule below for details. This provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketCorsConfigurationV2` instead.
     * 
     */
    public Output<Optional<List<BucketCorsRule>>> corsRules() {
        return Codegen.optional(this.corsRules);
    }
    /**
     * Boolean that indicates all objects (including any [locked objects](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock-overview.html)) should be deleted from the bucket *when the bucket is destroyed* so that the bucket can be destroyed without error. These objects are *not* recoverable. This only deletes objects when the bucket is destroyed, *not* when setting this parameter to `true`. Once this parameter is set to `true`, there must be a successful `pulumi up` run before a destroy is required to update this value in the resource state. Without a successful `pulumi up` after this parameter is set, this flag will have no effect. If setting this field in the same operation that would require replacing the bucket or destroying the bucket, this flag will not work. Additionally when importing a bucket, a successful `pulumi up` is required to set this value in state before it will take effect on a destroy operation.
     * 
     */
    @Export(name="forceDestroy", refs={Boolean.class}, tree="[0]")
    private Output</* @Nullable */ Boolean> forceDestroy;

    /**
     * @return Boolean that indicates all objects (including any [locked objects](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock-overview.html)) should be deleted from the bucket *when the bucket is destroyed* so that the bucket can be destroyed without error. These objects are *not* recoverable. This only deletes objects when the bucket is destroyed, *not* when setting this parameter to `true`. Once this parameter is set to `true`, there must be a successful `pulumi up` run before a destroy is required to update this value in the resource state. Without a successful `pulumi up` after this parameter is set, this flag will have no effect. If setting this field in the same operation that would require replacing the bucket or destroying the bucket, this flag will not work. Additionally when importing a bucket, a successful `pulumi up` is required to set this value in state before it will take effect on a destroy operation.
     * 
     */
    public Output<Optional<Boolean>> forceDestroy() {
        return Codegen.optional(this.forceDestroy);
    }
    /**
     * An [ACL policy grant](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#sample-acl). See Grant below for details. Conflicts with `acl`. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketAclV2` instead.
     * 
     */
    @Export(name="grants", refs={List.class,BucketGrant.class}, tree="[0,1]")
    private Output</* @Nullable */ List<BucketGrant>> grants;

    /**
     * @return An [ACL policy grant](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#sample-acl). See Grant below for details. Conflicts with `acl`. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketAclV2` instead.
     * 
     */
    public Output<Optional<List<BucketGrant>>> grants() {
        return Codegen.optional(this.grants);
    }
    /**
     * [Route 53 Hosted Zone ID](https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_website_region_endpoints) for this bucket&#39;s region.
     * 
     */
    @Export(name="hostedZoneId", refs={String.class}, tree="[0]")
    private Output<String> hostedZoneId;

    /**
     * @return [Route 53 Hosted Zone ID](https://docs.aws.amazon.com/general/latest/gr/rande.html#s3_website_region_endpoints) for this bucket&#39;s region.
     * 
     */
    public Output<String> hostedZoneId() {
        return this.hostedZoneId;
    }
    /**
     * Configuration of [object lifecycle management](http://docs.aws.amazon.com/AmazonS3/latest/dev/object-lifecycle-mgmt.html). See Lifecycle Rule below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLifecycleConfigurationV2` instead.
     * 
     */
    @Export(name="lifecycleRules", refs={List.class,BucketLifecycleRule.class}, tree="[0,1]")
    private Output</* @Nullable */ List<BucketLifecycleRule>> lifecycleRules;

    /**
     * @return Configuration of [object lifecycle management](http://docs.aws.amazon.com/AmazonS3/latest/dev/object-lifecycle-mgmt.html). See Lifecycle Rule below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLifecycleConfigurationV2` instead.
     * 
     */
    public Output<Optional<List<BucketLifecycleRule>>> lifecycleRules() {
        return Codegen.optional(this.lifecycleRules);
    }
    /**
     * Configuration of [S3 bucket logging](https://docs.aws.amazon.com/AmazonS3/latest/UG/ManagingBucketLogging.html) parameters. See Logging below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLoggingV2` instead.
     * 
     */
    @Export(name="loggings", refs={List.class,BucketLogging.class}, tree="[0,1]")
    private Output</* @Nullable */ List<BucketLogging>> loggings;

    /**
     * @return Configuration of [S3 bucket logging](https://docs.aws.amazon.com/AmazonS3/latest/UG/ManagingBucketLogging.html) parameters. See Logging below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLoggingV2` instead.
     * 
     */
    public Output<Optional<List<BucketLogging>>> loggings() {
        return Codegen.optional(this.loggings);
    }
    /**
     * Configuration of [S3 object locking](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html). See Object Lock Configuration below for details.
     * The provider wil only perform drift detection if a configuration value is provided.
     * Use the `object_lock_enabled` parameter and the resource `aws.s3.BucketObjectLockConfigurationV2` instead.
     * 
     */
    @Export(name="objectLockConfiguration", refs={BucketObjectLockConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ BucketObjectLockConfiguration> objectLockConfiguration;

    /**
     * @return Configuration of [S3 object locking](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html). See Object Lock Configuration below for details.
     * The provider wil only perform drift detection if a configuration value is provided.
     * Use the `object_lock_enabled` parameter and the resource `aws.s3.BucketObjectLockConfigurationV2` instead.
     * 
     */
    public Output<Optional<BucketObjectLockConfiguration>> objectLockConfiguration() {
        return Codegen.optional(this.objectLockConfiguration);
    }
    /**
     * Valid [bucket policy](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-bucket-policies.html) JSON document. Note that if the policy document is not specific enough (but still valid), this provider may view the policy as constantly changing. In this case, please make sure you use the verbose/specific version of the policy. For more information about building AWS IAM policy documents with this provider, see the AWS IAM Policy Document Guide.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketPolicy` instead.
     * 
     */
    @Export(name="policy", refs={String.class}, tree="[0]")
    private Output</* @Nullable */ String> policy;

    /**
     * @return Valid [bucket policy](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-bucket-policies.html) JSON document. Note that if the policy document is not specific enough (but still valid), this provider may view the policy as constantly changing. In this case, please make sure you use the verbose/specific version of the policy. For more information about building AWS IAM policy documents with this provider, see the AWS IAM Policy Document Guide.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketPolicy` instead.
     * 
     */
    public Output<Optional<String>> policy() {
        return Codegen.optional(this.policy);
    }
    /**
     * AWS region this bucket resides in.
     * 
     */
    @Export(name="region", refs={String.class}, tree="[0]")
    private Output<String> region;

    /**
     * @return AWS region this bucket resides in.
     * 
     */
    public Output<String> region() {
        return this.region;
    }
    /**
     * Configuration of [replication configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/crr.html). See Replication Configuration below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketReplicationConfig` instead.
     * 
     */
    @Export(name="replicationConfiguration", refs={BucketReplicationConfiguration.class}, tree="[0]")
    private Output</* @Nullable */ BucketReplicationConfiguration> replicationConfiguration;

    /**
     * @return Configuration of [replication configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/crr.html). See Replication Configuration below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketReplicationConfig` instead.
     * 
     */
    public Output<Optional<BucketReplicationConfiguration>> replicationConfiguration() {
        return Codegen.optional(this.replicationConfiguration);
    }
    /**
     * Specifies who should bear the cost of Amazon S3 data transfer.
     * Can be either `BucketOwner` or `Requester`. By default, the owner of the S3 bucket would incur the costs of any data transfer.
     * See [Requester Pays Buckets](http://docs.aws.amazon.com/AmazonS3/latest/dev/RequesterPaysBuckets.html) developer guide for more information.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketRequestPaymentConfigurationV2` instead.
     * 
     */
    @Export(name="requestPayer", refs={String.class}, tree="[0]")
    private Output<String> requestPayer;

    /**
     * @return Specifies who should bear the cost of Amazon S3 data transfer.
     * Can be either `BucketOwner` or `Requester`. By default, the owner of the S3 bucket would incur the costs of any data transfer.
     * See [Requester Pays Buckets](http://docs.aws.amazon.com/AmazonS3/latest/dev/RequesterPaysBuckets.html) developer guide for more information.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketRequestPaymentConfigurationV2` instead.
     * 
     */
    public Output<String> requestPayer() {
        return this.requestPayer;
    }
    /**
     * Configuration of [server-side encryption configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html). See Server Side Encryption Configuration below for details.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketServerSideEncryptionConfigurationV2` instead.
     * 
     */
    @Export(name="serverSideEncryptionConfiguration", refs={BucketServerSideEncryptionConfiguration.class}, tree="[0]")
    private Output<BucketServerSideEncryptionConfiguration> serverSideEncryptionConfiguration;

    /**
     * @return Configuration of [server-side encryption configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html). See Server Side Encryption Configuration below for details.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketServerSideEncryptionConfigurationV2` instead.
     * 
     */
    public Output<BucketServerSideEncryptionConfiguration> serverSideEncryptionConfiguration() {
        return this.serverSideEncryptionConfiguration;
    }
    /**
     * Map of tags to assign to the bucket. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * The following arguments are deprecated, and will be removed in a future major version:
     * 
     */
    @Export(name="tags", refs={Map.class,String.class}, tree="[0,1,1]")
    private Output</* @Nullable */ Map<String,String>> tags;

    /**
     * @return Map of tags to assign to the bucket. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
     * 
     * The following arguments are deprecated, and will be removed in a future major version:
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
     * Configuration of the [S3 bucket versioning state](https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html). See Versioning below for details. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketVersioningV2` instead.
     * 
     */
    @Export(name="versioning", refs={BucketVersioning.class}, tree="[0]")
    private Output<BucketVersioning> versioning;

    /**
     * @return Configuration of the [S3 bucket versioning state](https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html). See Versioning below for details. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketVersioningV2` instead.
     * 
     */
    public Output<BucketVersioning> versioning() {
        return this.versioning;
    }
    /**
     * Configuration of the [S3 bucket website](https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html). See Website below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    @Export(name="website", refs={BucketWebsite.class}, tree="[0]")
    private Output</* @Nullable */ BucketWebsite> website;

    /**
     * @return Configuration of the [S3 bucket website](https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html). See Website below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    public Output<Optional<BucketWebsite>> website() {
        return Codegen.optional(this.website);
    }
    /**
     * (**Deprecated**) Domain of the website endpoint, if the bucket is configured with a website. If not, this will be an empty string. This is used to create Route 53 alias records. Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    @Export(name="websiteDomain", refs={String.class}, tree="[0]")
    private Output<String> websiteDomain;

    /**
     * @return (**Deprecated**) Domain of the website endpoint, if the bucket is configured with a website. If not, this will be an empty string. This is used to create Route 53 alias records. Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    public Output<String> websiteDomain() {
        return this.websiteDomain;
    }
    /**
     * (**Deprecated**) Website endpoint, if the bucket is configured with a website. If not, this will be an empty string. Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    @Export(name="websiteEndpoint", refs={String.class}, tree="[0]")
    private Output<String> websiteEndpoint;

    /**
     * @return (**Deprecated**) Website endpoint, if the bucket is configured with a website. If not, this will be an empty string. Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    public Output<String> websiteEndpoint() {
        return this.websiteEndpoint;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public Bucket(java.lang.String name) {
        this(name, BucketArgs.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public Bucket(java.lang.String name, @Nullable BucketArgs args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public Bucket(java.lang.String name, @Nullable BucketArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3/bucket:Bucket", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private Bucket(java.lang.String name, Output<java.lang.String> id, @Nullable BucketState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3/bucket:Bucket", name, state, makeResourceOptions(options, id), false);
    }

    private static BucketArgs makeArgs(@Nullable BucketArgs args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? BucketArgs.Empty : args;
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
    public static Bucket get(java.lang.String name, Output<java.lang.String> id, @Nullable BucketState state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new Bucket(name, id, state, options);
    }
}
