// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.aws.s3.inputs.BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUploadArgs;
import com.pulumi.aws.s3.inputs.BucketLifecycleConfigurationV2RuleExpirationArgs;
import com.pulumi.aws.s3.inputs.BucketLifecycleConfigurationV2RuleFilterArgs;
import com.pulumi.aws.s3.inputs.BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationArgs;
import com.pulumi.aws.s3.inputs.BucketLifecycleConfigurationV2RuleNoncurrentVersionTransitionArgs;
import com.pulumi.aws.s3.inputs.BucketLifecycleConfigurationV2RuleTransitionArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BucketLifecycleConfigurationV2RuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final BucketLifecycleConfigurationV2RuleArgs Empty = new BucketLifecycleConfigurationV2RuleArgs();

    /**
     * Configuration block that specifies the days since the initiation of an incomplete multipart upload that Amazon S3 will wait before permanently removing all parts of the upload. See below.
     * 
     */
    @Import(name="abortIncompleteMultipartUpload")
    private @Nullable Output<BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUploadArgs> abortIncompleteMultipartUpload;

    /**
     * @return Configuration block that specifies the days since the initiation of an incomplete multipart upload that Amazon S3 will wait before permanently removing all parts of the upload. See below.
     * 
     */
    public Optional<Output<BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUploadArgs>> abortIncompleteMultipartUpload() {
        return Optional.ofNullable(this.abortIncompleteMultipartUpload);
    }

    /**
     * Configuration block that specifies the expiration for the lifecycle of the object in the form of date, days and, whether the object has a delete marker. See below.
     * 
     */
    @Import(name="expiration")
    private @Nullable Output<BucketLifecycleConfigurationV2RuleExpirationArgs> expiration;

    /**
     * @return Configuration block that specifies the expiration for the lifecycle of the object in the form of date, days and, whether the object has a delete marker. See below.
     * 
     */
    public Optional<Output<BucketLifecycleConfigurationV2RuleExpirationArgs>> expiration() {
        return Optional.ofNullable(this.expiration);
    }

    /**
     * Configuration block used to identify objects that a Lifecycle Rule applies to.
     * See below.
     * If not specified, the `rule` will default to using `prefix`.
     * One of `filter` or `prefix` should be specified.
     * 
     */
    @Import(name="filter")
    private @Nullable Output<BucketLifecycleConfigurationV2RuleFilterArgs> filter;

    /**
     * @return Configuration block used to identify objects that a Lifecycle Rule applies to.
     * See below.
     * If not specified, the `rule` will default to using `prefix`.
     * One of `filter` or `prefix` should be specified.
     * 
     */
    public Optional<Output<BucketLifecycleConfigurationV2RuleFilterArgs>> filter() {
        return Optional.ofNullable(this.filter);
    }

    /**
     * Unique identifier for the rule. The value cannot be longer than 255 characters.
     * 
     */
    @Import(name="id", required=true)
    private Output<String> id;

    /**
     * @return Unique identifier for the rule. The value cannot be longer than 255 characters.
     * 
     */
    public Output<String> id() {
        return this.id;
    }

    /**
     * Configuration block that specifies when noncurrent object versions expire. See below.
     * 
     */
    @Import(name="noncurrentVersionExpiration")
    private @Nullable Output<BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationArgs> noncurrentVersionExpiration;

    /**
     * @return Configuration block that specifies when noncurrent object versions expire. See below.
     * 
     */
    public Optional<Output<BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationArgs>> noncurrentVersionExpiration() {
        return Optional.ofNullable(this.noncurrentVersionExpiration);
    }

    /**
     * Set of configuration blocks that specify the transition rule for the lifecycle rule that describes when noncurrent objects transition to a specific storage class. See below.
     * 
     */
    @Import(name="noncurrentVersionTransitions")
    private @Nullable Output<List<BucketLifecycleConfigurationV2RuleNoncurrentVersionTransitionArgs>> noncurrentVersionTransitions;

    /**
     * @return Set of configuration blocks that specify the transition rule for the lifecycle rule that describes when noncurrent objects transition to a specific storage class. See below.
     * 
     */
    public Optional<Output<List<BucketLifecycleConfigurationV2RuleNoncurrentVersionTransitionArgs>>> noncurrentVersionTransitions() {
        return Optional.ofNullable(this.noncurrentVersionTransitions);
    }

    /**
     * **DEPRECATED** Use `filter` instead.
     * This has been deprecated by Amazon S3.
     * Prefix identifying one or more objects to which the rule applies.
     * Defaults to an empty string (`&#34;&#34;`) if `filter` is not specified.
     * One of `prefix` or `filter` should be specified.
     * 
     * @deprecated
     * Specify a prefix using &#39;filter&#39; instead
     * 
     */
    @Deprecated /* Specify a prefix using 'filter' instead */
    @Import(name="prefix")
    private @Nullable Output<String> prefix;

    /**
     * @return **DEPRECATED** Use `filter` instead.
     * This has been deprecated by Amazon S3.
     * Prefix identifying one or more objects to which the rule applies.
     * Defaults to an empty string (`&#34;&#34;`) if `filter` is not specified.
     * One of `prefix` or `filter` should be specified.
     * 
     * @deprecated
     * Specify a prefix using &#39;filter&#39; instead
     * 
     */
    @Deprecated /* Specify a prefix using 'filter' instead */
    public Optional<Output<String>> prefix() {
        return Optional.ofNullable(this.prefix);
    }

    /**
     * Whether the rule is currently being applied. Valid values: `Enabled` or `Disabled`.
     * 
     */
    @Import(name="status", required=true)
    private Output<String> status;

    /**
     * @return Whether the rule is currently being applied. Valid values: `Enabled` or `Disabled`.
     * 
     */
    public Output<String> status() {
        return this.status;
    }

    /**
     * Set of configuration blocks that specify when an Amazon S3 object transitions to a specified storage class. See below.
     * 
     */
    @Import(name="transitions")
    private @Nullable Output<List<BucketLifecycleConfigurationV2RuleTransitionArgs>> transitions;

    /**
     * @return Set of configuration blocks that specify when an Amazon S3 object transitions to a specified storage class. See below.
     * 
     */
    public Optional<Output<List<BucketLifecycleConfigurationV2RuleTransitionArgs>>> transitions() {
        return Optional.ofNullable(this.transitions);
    }

    private BucketLifecycleConfigurationV2RuleArgs() {}

    private BucketLifecycleConfigurationV2RuleArgs(BucketLifecycleConfigurationV2RuleArgs $) {
        this.abortIncompleteMultipartUpload = $.abortIncompleteMultipartUpload;
        this.expiration = $.expiration;
        this.filter = $.filter;
        this.id = $.id;
        this.noncurrentVersionExpiration = $.noncurrentVersionExpiration;
        this.noncurrentVersionTransitions = $.noncurrentVersionTransitions;
        this.prefix = $.prefix;
        this.status = $.status;
        this.transitions = $.transitions;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketLifecycleConfigurationV2RuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketLifecycleConfigurationV2RuleArgs $;

        public Builder() {
            $ = new BucketLifecycleConfigurationV2RuleArgs();
        }

        public Builder(BucketLifecycleConfigurationV2RuleArgs defaults) {
            $ = new BucketLifecycleConfigurationV2RuleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param abortIncompleteMultipartUpload Configuration block that specifies the days since the initiation of an incomplete multipart upload that Amazon S3 will wait before permanently removing all parts of the upload. See below.
         * 
         * @return builder
         * 
         */
        public Builder abortIncompleteMultipartUpload(@Nullable Output<BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUploadArgs> abortIncompleteMultipartUpload) {
            $.abortIncompleteMultipartUpload = abortIncompleteMultipartUpload;
            return this;
        }

        /**
         * @param abortIncompleteMultipartUpload Configuration block that specifies the days since the initiation of an incomplete multipart upload that Amazon S3 will wait before permanently removing all parts of the upload. See below.
         * 
         * @return builder
         * 
         */
        public Builder abortIncompleteMultipartUpload(BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUploadArgs abortIncompleteMultipartUpload) {
            return abortIncompleteMultipartUpload(Output.of(abortIncompleteMultipartUpload));
        }

        /**
         * @param expiration Configuration block that specifies the expiration for the lifecycle of the object in the form of date, days and, whether the object has a delete marker. See below.
         * 
         * @return builder
         * 
         */
        public Builder expiration(@Nullable Output<BucketLifecycleConfigurationV2RuleExpirationArgs> expiration) {
            $.expiration = expiration;
            return this;
        }

        /**
         * @param expiration Configuration block that specifies the expiration for the lifecycle of the object in the form of date, days and, whether the object has a delete marker. See below.
         * 
         * @return builder
         * 
         */
        public Builder expiration(BucketLifecycleConfigurationV2RuleExpirationArgs expiration) {
            return expiration(Output.of(expiration));
        }

        /**
         * @param filter Configuration block used to identify objects that a Lifecycle Rule applies to.
         * See below.
         * If not specified, the `rule` will default to using `prefix`.
         * One of `filter` or `prefix` should be specified.
         * 
         * @return builder
         * 
         */
        public Builder filter(@Nullable Output<BucketLifecycleConfigurationV2RuleFilterArgs> filter) {
            $.filter = filter;
            return this;
        }

        /**
         * @param filter Configuration block used to identify objects that a Lifecycle Rule applies to.
         * See below.
         * If not specified, the `rule` will default to using `prefix`.
         * One of `filter` or `prefix` should be specified.
         * 
         * @return builder
         * 
         */
        public Builder filter(BucketLifecycleConfigurationV2RuleFilterArgs filter) {
            return filter(Output.of(filter));
        }

        /**
         * @param id Unique identifier for the rule. The value cannot be longer than 255 characters.
         * 
         * @return builder
         * 
         */
        public Builder id(Output<String> id) {
            $.id = id;
            return this;
        }

        /**
         * @param id Unique identifier for the rule. The value cannot be longer than 255 characters.
         * 
         * @return builder
         * 
         */
        public Builder id(String id) {
            return id(Output.of(id));
        }

        /**
         * @param noncurrentVersionExpiration Configuration block that specifies when noncurrent object versions expire. See below.
         * 
         * @return builder
         * 
         */
        public Builder noncurrentVersionExpiration(@Nullable Output<BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationArgs> noncurrentVersionExpiration) {
            $.noncurrentVersionExpiration = noncurrentVersionExpiration;
            return this;
        }

        /**
         * @param noncurrentVersionExpiration Configuration block that specifies when noncurrent object versions expire. See below.
         * 
         * @return builder
         * 
         */
        public Builder noncurrentVersionExpiration(BucketLifecycleConfigurationV2RuleNoncurrentVersionExpirationArgs noncurrentVersionExpiration) {
            return noncurrentVersionExpiration(Output.of(noncurrentVersionExpiration));
        }

        /**
         * @param noncurrentVersionTransitions Set of configuration blocks that specify the transition rule for the lifecycle rule that describes when noncurrent objects transition to a specific storage class. See below.
         * 
         * @return builder
         * 
         */
        public Builder noncurrentVersionTransitions(@Nullable Output<List<BucketLifecycleConfigurationV2RuleNoncurrentVersionTransitionArgs>> noncurrentVersionTransitions) {
            $.noncurrentVersionTransitions = noncurrentVersionTransitions;
            return this;
        }

        /**
         * @param noncurrentVersionTransitions Set of configuration blocks that specify the transition rule for the lifecycle rule that describes when noncurrent objects transition to a specific storage class. See below.
         * 
         * @return builder
         * 
         */
        public Builder noncurrentVersionTransitions(List<BucketLifecycleConfigurationV2RuleNoncurrentVersionTransitionArgs> noncurrentVersionTransitions) {
            return noncurrentVersionTransitions(Output.of(noncurrentVersionTransitions));
        }

        /**
         * @param noncurrentVersionTransitions Set of configuration blocks that specify the transition rule for the lifecycle rule that describes when noncurrent objects transition to a specific storage class. See below.
         * 
         * @return builder
         * 
         */
        public Builder noncurrentVersionTransitions(BucketLifecycleConfigurationV2RuleNoncurrentVersionTransitionArgs... noncurrentVersionTransitions) {
            return noncurrentVersionTransitions(List.of(noncurrentVersionTransitions));
        }

        /**
         * @param prefix **DEPRECATED** Use `filter` instead.
         * This has been deprecated by Amazon S3.
         * Prefix identifying one or more objects to which the rule applies.
         * Defaults to an empty string (`&#34;&#34;`) if `filter` is not specified.
         * One of `prefix` or `filter` should be specified.
         * 
         * @return builder
         * 
         * @deprecated
         * Specify a prefix using &#39;filter&#39; instead
         * 
         */
        @Deprecated /* Specify a prefix using 'filter' instead */
        public Builder prefix(@Nullable Output<String> prefix) {
            $.prefix = prefix;
            return this;
        }

        /**
         * @param prefix **DEPRECATED** Use `filter` instead.
         * This has been deprecated by Amazon S3.
         * Prefix identifying one or more objects to which the rule applies.
         * Defaults to an empty string (`&#34;&#34;`) if `filter` is not specified.
         * One of `prefix` or `filter` should be specified.
         * 
         * @return builder
         * 
         * @deprecated
         * Specify a prefix using &#39;filter&#39; instead
         * 
         */
        @Deprecated /* Specify a prefix using 'filter' instead */
        public Builder prefix(String prefix) {
            return prefix(Output.of(prefix));
        }

        /**
         * @param status Whether the rule is currently being applied. Valid values: `Enabled` or `Disabled`.
         * 
         * @return builder
         * 
         */
        public Builder status(Output<String> status) {
            $.status = status;
            return this;
        }

        /**
         * @param status Whether the rule is currently being applied. Valid values: `Enabled` or `Disabled`.
         * 
         * @return builder
         * 
         */
        public Builder status(String status) {
            return status(Output.of(status));
        }

        /**
         * @param transitions Set of configuration blocks that specify when an Amazon S3 object transitions to a specified storage class. See below.
         * 
         * @return builder
         * 
         */
        public Builder transitions(@Nullable Output<List<BucketLifecycleConfigurationV2RuleTransitionArgs>> transitions) {
            $.transitions = transitions;
            return this;
        }

        /**
         * @param transitions Set of configuration blocks that specify when an Amazon S3 object transitions to a specified storage class. See below.
         * 
         * @return builder
         * 
         */
        public Builder transitions(List<BucketLifecycleConfigurationV2RuleTransitionArgs> transitions) {
            return transitions(Output.of(transitions));
        }

        /**
         * @param transitions Set of configuration blocks that specify when an Amazon S3 object transitions to a specified storage class. See below.
         * 
         * @return builder
         * 
         */
        public Builder transitions(BucketLifecycleConfigurationV2RuleTransitionArgs... transitions) {
            return transitions(List.of(transitions));
        }

        public BucketLifecycleConfigurationV2RuleArgs build() {
            if ($.id == null) {
                throw new MissingRequiredPropertyException("BucketLifecycleConfigurationV2RuleArgs", "id");
            }
            if ($.status == null) {
                throw new MissingRequiredPropertyException("BucketLifecycleConfigurationV2RuleArgs", "status");
            }
            return $;
        }
    }

}
