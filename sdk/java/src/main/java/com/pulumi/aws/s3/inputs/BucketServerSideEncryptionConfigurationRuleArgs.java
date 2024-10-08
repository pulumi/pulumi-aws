// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.inputs;

import com.pulumi.aws.s3.inputs.BucketServerSideEncryptionConfigurationRuleApplyServerSideEncryptionByDefaultArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class BucketServerSideEncryptionConfigurationRuleArgs extends com.pulumi.resources.ResourceArgs {

    public static final BucketServerSideEncryptionConfigurationRuleArgs Empty = new BucketServerSideEncryptionConfigurationRuleArgs();

    /**
     * Single object for setting server-side encryption by default. (documented below)
     * 
     */
    @Import(name="applyServerSideEncryptionByDefault", required=true)
    private Output<BucketServerSideEncryptionConfigurationRuleApplyServerSideEncryptionByDefaultArgs> applyServerSideEncryptionByDefault;

    /**
     * @return Single object for setting server-side encryption by default. (documented below)
     * 
     */
    public Output<BucketServerSideEncryptionConfigurationRuleApplyServerSideEncryptionByDefaultArgs> applyServerSideEncryptionByDefault() {
        return this.applyServerSideEncryptionByDefault;
    }

    /**
     * Whether or not to use [Amazon S3 Bucket Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html) for SSE-KMS.
     * 
     */
    @Import(name="bucketKeyEnabled")
    private @Nullable Output<Boolean> bucketKeyEnabled;

    /**
     * @return Whether or not to use [Amazon S3 Bucket Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html) for SSE-KMS.
     * 
     */
    public Optional<Output<Boolean>> bucketKeyEnabled() {
        return Optional.ofNullable(this.bucketKeyEnabled);
    }

    private BucketServerSideEncryptionConfigurationRuleArgs() {}

    private BucketServerSideEncryptionConfigurationRuleArgs(BucketServerSideEncryptionConfigurationRuleArgs $) {
        this.applyServerSideEncryptionByDefault = $.applyServerSideEncryptionByDefault;
        this.bucketKeyEnabled = $.bucketKeyEnabled;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(BucketServerSideEncryptionConfigurationRuleArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private BucketServerSideEncryptionConfigurationRuleArgs $;

        public Builder() {
            $ = new BucketServerSideEncryptionConfigurationRuleArgs();
        }

        public Builder(BucketServerSideEncryptionConfigurationRuleArgs defaults) {
            $ = new BucketServerSideEncryptionConfigurationRuleArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param applyServerSideEncryptionByDefault Single object for setting server-side encryption by default. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder applyServerSideEncryptionByDefault(Output<BucketServerSideEncryptionConfigurationRuleApplyServerSideEncryptionByDefaultArgs> applyServerSideEncryptionByDefault) {
            $.applyServerSideEncryptionByDefault = applyServerSideEncryptionByDefault;
            return this;
        }

        /**
         * @param applyServerSideEncryptionByDefault Single object for setting server-side encryption by default. (documented below)
         * 
         * @return builder
         * 
         */
        public Builder applyServerSideEncryptionByDefault(BucketServerSideEncryptionConfigurationRuleApplyServerSideEncryptionByDefaultArgs applyServerSideEncryptionByDefault) {
            return applyServerSideEncryptionByDefault(Output.of(applyServerSideEncryptionByDefault));
        }

        /**
         * @param bucketKeyEnabled Whether or not to use [Amazon S3 Bucket Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html) for SSE-KMS.
         * 
         * @return builder
         * 
         */
        public Builder bucketKeyEnabled(@Nullable Output<Boolean> bucketKeyEnabled) {
            $.bucketKeyEnabled = bucketKeyEnabled;
            return this;
        }

        /**
         * @param bucketKeyEnabled Whether or not to use [Amazon S3 Bucket Keys](https://docs.aws.amazon.com/AmazonS3/latest/dev/bucket-key.html) for SSE-KMS.
         * 
         * @return builder
         * 
         */
        public Builder bucketKeyEnabled(Boolean bucketKeyEnabled) {
            return bucketKeyEnabled(Output.of(bucketKeyEnabled));
        }

        public BucketServerSideEncryptionConfigurationRuleArgs build() {
            if ($.applyServerSideEncryptionByDefault == null) {
                throw new MissingRequiredPropertyException("BucketServerSideEncryptionConfigurationRuleArgs", "applyServerSideEncryptionByDefault");
            }
            return $;
        }
    }

}
