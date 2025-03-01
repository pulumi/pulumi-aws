// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Double;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload {
    /**
     * @return Number of days after which Amazon S3 aborts an incomplete multipart upload.
     * 
     */
    private @Nullable Double daysAfterInitiation;

    private BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload() {}
    /**
     * @return Number of days after which Amazon S3 aborts an incomplete multipart upload.
     * 
     */
    public Optional<Double> daysAfterInitiation() {
        return Optional.ofNullable(this.daysAfterInitiation);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Double daysAfterInitiation;
        public Builder() {}
        public Builder(BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.daysAfterInitiation = defaults.daysAfterInitiation;
        }

        @CustomType.Setter
        public Builder daysAfterInitiation(@Nullable Double daysAfterInitiation) {

            this.daysAfterInitiation = daysAfterInitiation;
            return this;
        }
        public BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload build() {
            final var _resultValue = new BucketLifecycleConfigurationV2RuleAbortIncompleteMultipartUpload();
            _resultValue.daysAfterInitiation = daysAfterInitiation;
            return _resultValue;
        }
    }
}
