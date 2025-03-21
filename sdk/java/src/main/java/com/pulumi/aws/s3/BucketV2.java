// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3;

import com.pulumi.aws.Utilities;
import com.pulumi.aws.s3.BucketV2Args;
import com.pulumi.aws.s3.inputs.BucketV2State;
import com.pulumi.aws.s3.outputs.BucketV2CorsRule;
import com.pulumi.aws.s3.outputs.BucketV2Grant;
import com.pulumi.aws.s3.outputs.BucketV2LifecycleRule;
import com.pulumi.aws.s3.outputs.BucketV2Logging;
import com.pulumi.aws.s3.outputs.BucketV2ObjectLockConfiguration;
import com.pulumi.aws.s3.outputs.BucketV2ReplicationConfiguration;
import com.pulumi.aws.s3.outputs.BucketV2ServerSideEncryptionConfiguration;
import com.pulumi.aws.s3.outputs.BucketV2Versioning;
import com.pulumi.aws.s3.outputs.BucketV2Website;
import com.pulumi.core.Alias;
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
 * $ pulumi import aws:s3/bucketV2:BucketV2 bucket bucket-name
 * ```
 * 
 */
@ResourceType(type="aws:s3/bucketV2:BucketV2")
public class BucketV2 extends com.pulumi.resources.CustomResource {
    /**
     * Sets the accelerate configuration of an existing bucket. Can be `Enabled` or `Suspended`. Cannot be used in `cn-north-1` or `us-gov-west-1`. This provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketAccelerateConfigurationV2` instead.
     * 
     * @deprecated
     * acceleration_status is deprecated. Use the aws.s3.BucketAccelerateConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* acceleration_status is deprecated. Use the aws.s3.BucketAccelerateConfigurationV2 resource instead. */
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
     * @deprecated
     * acl is deprecated. Use the aws.s3.BucketAclV2 resource instead.
     * 
     */
    @Deprecated /* acl is deprecated. Use the aws.s3.BucketAclV2 resource instead. */
    @Export(name="acl", refs={String.class}, tree="[0]")
    private Output<String> acl;

    /**
     * @return The [canned ACL](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#canned-acl) to apply. Valid values are `private`, `public-read`, `public-read-write`, `aws-exec-read`, `authenticated-read`, and `log-delivery-write`. Defaults to `private`.  Conflicts with `grant`. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketAclV2` instead.
     * 
     */
    public Output<String> acl() {
        return this.acl;
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
    private Output<String> bucketPrefix;

    /**
     * @return Creates a unique bucket name beginning with the specified prefix. Conflicts with `bucket`. Must be lowercase and less than or equal to 37 characters in length. A full list of bucket naming rules [may be found here](https://docs.aws.amazon.com/AmazonS3/latest/userguide/bucketnamingrules.html).
     * 
     */
    public Output<String> bucketPrefix() {
        return this.bucketPrefix;
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
     * @deprecated
     * cors_rule is deprecated. Use the aws.s3.BucketCorsConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* cors_rule is deprecated. Use the aws.s3.BucketCorsConfigurationV2 resource instead. */
    @Export(name="corsRules", refs={List.class,BucketV2CorsRule.class}, tree="[0,1]")
    private Output<List<BucketV2CorsRule>> corsRules;

    /**
     * @return Rule of [Cross-Origin Resource Sharing](https://docs.aws.amazon.com/AmazonS3/latest/dev/cors.html). See CORS rule below for details. This provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketCorsConfigurationV2` instead.
     * 
     */
    public Output<List<BucketV2CorsRule>> corsRules() {
        return this.corsRules;
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
     * @deprecated
     * grant is deprecated. Use the aws.s3.BucketAclV2 resource instead.
     * 
     */
    @Deprecated /* grant is deprecated. Use the aws.s3.BucketAclV2 resource instead. */
    @Export(name="grants", refs={List.class,BucketV2Grant.class}, tree="[0,1]")
    private Output<List<BucketV2Grant>> grants;

    /**
     * @return An [ACL policy grant](https://docs.aws.amazon.com/AmazonS3/latest/dev/acl-overview.html#sample-acl). See Grant below for details. Conflicts with `acl`. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketAclV2` instead.
     * 
     */
    public Output<List<BucketV2Grant>> grants() {
        return this.grants;
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
     * @deprecated
     * lifecycle_rule is deprecated. Use the aws.s3.BucketLifecycleConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* lifecycle_rule is deprecated. Use the aws.s3.BucketLifecycleConfigurationV2 resource instead. */
    @Export(name="lifecycleRules", refs={List.class,BucketV2LifecycleRule.class}, tree="[0,1]")
    private Output<List<BucketV2LifecycleRule>> lifecycleRules;

    /**
     * @return Configuration of [object lifecycle management](http://docs.aws.amazon.com/AmazonS3/latest/dev/object-lifecycle-mgmt.html). See Lifecycle Rule below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLifecycleConfigurationV2` instead.
     * 
     */
    public Output<List<BucketV2LifecycleRule>> lifecycleRules() {
        return this.lifecycleRules;
    }
    /**
     * Configuration of [S3 bucket logging](https://docs.aws.amazon.com/AmazonS3/latest/UG/ManagingBucketLogging.html) parameters. See Logging below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLoggingV2` instead.
     * 
     * @deprecated
     * logging is deprecated. Use the aws.s3.BucketLoggingV2 resource instead.
     * 
     */
    @Deprecated /* logging is deprecated. Use the aws.s3.BucketLoggingV2 resource instead. */
    @Export(name="loggings", refs={List.class,BucketV2Logging.class}, tree="[0,1]")
    private Output<List<BucketV2Logging>> loggings;

    /**
     * @return Configuration of [S3 bucket logging](https://docs.aws.amazon.com/AmazonS3/latest/UG/ManagingBucketLogging.html) parameters. See Logging below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketLoggingV2` instead.
     * 
     */
    public Output<List<BucketV2Logging>> loggings() {
        return this.loggings;
    }
    /**
     * Configuration of [S3 object locking](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html). See Object Lock Configuration below for details.
     * The provider wil only perform drift detection if a configuration value is provided.
     * Use the `object_lock_enabled` parameter and the resource `aws.s3.BucketObjectLockConfigurationV2` instead.
     * 
     * @deprecated
     * object_lock_configuration is deprecated. Use the top-level parameter object_lock_enabled and the aws.s3.BucketObjectLockConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* object_lock_configuration is deprecated. Use the top-level parameter object_lock_enabled and the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
    @Export(name="objectLockConfiguration", refs={BucketV2ObjectLockConfiguration.class}, tree="[0]")
    private Output<BucketV2ObjectLockConfiguration> objectLockConfiguration;

    /**
     * @return Configuration of [S3 object locking](https://docs.aws.amazon.com/AmazonS3/latest/dev/object-lock.html). See Object Lock Configuration below for details.
     * The provider wil only perform drift detection if a configuration value is provided.
     * Use the `object_lock_enabled` parameter and the resource `aws.s3.BucketObjectLockConfigurationV2` instead.
     * 
     */
    public Output<BucketV2ObjectLockConfiguration> objectLockConfiguration() {
        return this.objectLockConfiguration;
    }
    /**
     * Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
     * 
     */
    @Export(name="objectLockEnabled", refs={Boolean.class}, tree="[0]")
    private Output<Boolean> objectLockEnabled;

    /**
     * @return Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
     * 
     */
    public Output<Boolean> objectLockEnabled() {
        return this.objectLockEnabled;
    }
    /**
     * Valid [bucket policy](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-bucket-policies.html) JSON document. Note that if the policy document is not specific enough (but still valid), this provider may view the policy as constantly changing. In this case, please make sure you use the verbose/specific version of the policy. For more information about building AWS IAM policy documents with this provider, see the AWS IAM Policy Document Guide.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketPolicy` instead.
     * 
     * @deprecated
     * policy is deprecated. Use the aws.s3.BucketPolicy resource instead.
     * 
     */
    @Deprecated /* policy is deprecated. Use the aws.s3.BucketPolicy resource instead. */
    @Export(name="policy", refs={String.class}, tree="[0]")
    private Output<String> policy;

    /**
     * @return Valid [bucket policy](https://docs.aws.amazon.com/AmazonS3/latest/dev/example-bucket-policies.html) JSON document. Note that if the policy document is not specific enough (but still valid), this provider may view the policy as constantly changing. In this case, please make sure you use the verbose/specific version of the policy. For more information about building AWS IAM policy documents with this provider, see the AWS IAM Policy Document Guide.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketPolicy` instead.
     * 
     */
    public Output<String> policy() {
        return this.policy;
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
     * @deprecated
     * replication_configuration is deprecated. Use the aws.s3.BucketReplicationConfig resource instead.
     * 
     */
    @Deprecated /* replication_configuration is deprecated. Use the aws.s3.BucketReplicationConfig resource instead. */
    @Export(name="replicationConfigurations", refs={List.class,BucketV2ReplicationConfiguration.class}, tree="[0,1]")
    private Output<List<BucketV2ReplicationConfiguration>> replicationConfigurations;

    /**
     * @return Configuration of [replication configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/crr.html). See Replication Configuration below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketReplicationConfig` instead.
     * 
     */
    public Output<List<BucketV2ReplicationConfiguration>> replicationConfigurations() {
        return this.replicationConfigurations;
    }
    /**
     * Specifies who should bear the cost of Amazon S3 data transfer.
     * Can be either `BucketOwner` or `Requester`. By default, the owner of the S3 bucket would incur the costs of any data transfer.
     * See [Requester Pays Buckets](http://docs.aws.amazon.com/AmazonS3/latest/dev/RequesterPaysBuckets.html) developer guide for more information.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketRequestPaymentConfigurationV2` instead.
     * 
     * @deprecated
     * request_payer is deprecated. Use the aws.s3.BucketRequestPaymentConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* request_payer is deprecated. Use the aws.s3.BucketRequestPaymentConfigurationV2 resource instead. */
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
     * @deprecated
     * server_side_encryption_configuration is deprecated. Use the aws.s3.BucketServerSideEncryptionConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* server_side_encryption_configuration is deprecated. Use the aws.s3.BucketServerSideEncryptionConfigurationV2 resource instead. */
    @Export(name="serverSideEncryptionConfigurations", refs={List.class,BucketV2ServerSideEncryptionConfiguration.class}, tree="[0,1]")
    private Output<List<BucketV2ServerSideEncryptionConfiguration>> serverSideEncryptionConfigurations;

    /**
     * @return Configuration of [server-side encryption configuration](http://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-encryption.html). See Server Side Encryption Configuration below for details.
     * The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketServerSideEncryptionConfigurationV2` instead.
     * 
     */
    public Output<List<BucketV2ServerSideEncryptionConfiguration>> serverSideEncryptionConfigurations() {
        return this.serverSideEncryptionConfigurations;
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
     * @deprecated
     * versioning is deprecated. Use the aws.s3.BucketVersioningV2 resource instead.
     * 
     */
    @Deprecated /* versioning is deprecated. Use the aws.s3.BucketVersioningV2 resource instead. */
    @Export(name="versionings", refs={List.class,BucketV2Versioning.class}, tree="[0,1]")
    private Output<List<BucketV2Versioning>> versionings;

    /**
     * @return Configuration of the [S3 bucket versioning state](https://docs.aws.amazon.com/AmazonS3/latest/dev/Versioning.html). See Versioning below for details. The provider will only perform drift detection if a configuration value is provided. Use the resource `aws.s3.BucketVersioningV2` instead.
     * 
     */
    public Output<List<BucketV2Versioning>> versionings() {
        return this.versionings;
    }
    /**
     * (**Deprecated**) Domain of the website endpoint, if the bucket is configured with a website. If not, this will be an empty string. This is used to create Route 53 alias records. Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     * @deprecated
     * website_domain is deprecated. Use the aws.s3.BucketWebsiteConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* website_domain is deprecated. Use the aws.s3.BucketWebsiteConfigurationV2 resource instead. */
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
     * @deprecated
     * website_endpoint is deprecated. Use the aws.s3.BucketWebsiteConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* website_endpoint is deprecated. Use the aws.s3.BucketWebsiteConfigurationV2 resource instead. */
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
     * Configuration of the [S3 bucket website](https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html). See Website below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     * @deprecated
     * website is deprecated. Use the aws.s3.BucketWebsiteConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* website is deprecated. Use the aws.s3.BucketWebsiteConfigurationV2 resource instead. */
    @Export(name="websites", refs={List.class,BucketV2Website.class}, tree="[0,1]")
    private Output<List<BucketV2Website>> websites;

    /**
     * @return Configuration of the [S3 bucket website](https://docs.aws.amazon.com/AmazonS3/latest/userguide/WebsiteHosting.html). See Website below for details. The provider will only perform drift detection if a configuration value is provided.
     * Use the resource `aws.s3.BucketWebsiteConfigurationV2` instead.
     * 
     */
    public Output<List<BucketV2Website>> websites() {
        return this.websites;
    }

    /**
     *
     * @param name The _unique_ name of the resulting resource.
     */
    public BucketV2(java.lang.String name) {
        this(name, BucketV2Args.Empty);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     */
    public BucketV2(java.lang.String name, @Nullable BucketV2Args args) {
        this(name, args, null);
    }
    /**
     *
     * @param name The _unique_ name of the resulting resource.
     * @param args The arguments to use to populate this resource's properties.
     * @param options A bag of options that control this resource's behavior.
     */
    public BucketV2(java.lang.String name, @Nullable BucketV2Args args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3/bucketV2:BucketV2", name, makeArgs(args, options), makeResourceOptions(options, Codegen.empty()), false);
    }

    private BucketV2(java.lang.String name, Output<java.lang.String> id, @Nullable BucketV2State state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        super("aws:s3/bucketV2:BucketV2", name, state, makeResourceOptions(options, id), false);
    }

    private static BucketV2Args makeArgs(@Nullable BucketV2Args args, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        if (options != null && options.getUrn().isPresent()) {
            return null;
        }
        return args == null ? BucketV2Args.Empty : args;
    }

    private static com.pulumi.resources.CustomResourceOptions makeResourceOptions(@Nullable com.pulumi.resources.CustomResourceOptions options, @Nullable Output<java.lang.String> id) {
        var defaultOptions = com.pulumi.resources.CustomResourceOptions.builder()
            .version(Utilities.getVersion())
            .aliases(List.of(
                Output.of(Alias.builder().type("aws:s3/bucket:Bucket").build())
            ))
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
    public static BucketV2 get(java.lang.String name, Output<java.lang.String> id, @Nullable BucketV2State state, @Nullable com.pulumi.resources.CustomResourceOptions options) {
        return new BucketV2(name, id, state, options);
    }
}
