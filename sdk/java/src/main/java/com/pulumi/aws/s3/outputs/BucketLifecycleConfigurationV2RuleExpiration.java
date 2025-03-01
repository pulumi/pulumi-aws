// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.lang.Double;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class BucketLifecycleConfigurationV2RuleExpiration {
    /**
     * @return Date the object is to be moved or deleted. The date value must be in [RFC3339 full-date format](https://datatracker.ietf.org/doc/html/rfc3339#section-5.6) e.g. `2023-08-22`.
     * 
     */
    private @Nullable String date;
    /**
     * @return Lifetime, in days, of the objects that are subject to the rule. The value must be a non-zero positive integer.
     * 
     */
    private @Nullable Double days;
    /**
     * @return Indicates whether Amazon S3 will remove a delete marker with no noncurrent versions. If set to `true`, the delete marker will be expired; if set to `false` the policy takes no action.
     * 
     */
    private @Nullable Boolean expiredObjectDeleteMarker;

    private BucketLifecycleConfigurationV2RuleExpiration() {}
    /**
     * @return Date the object is to be moved or deleted. The date value must be in [RFC3339 full-date format](https://datatracker.ietf.org/doc/html/rfc3339#section-5.6) e.g. `2023-08-22`.
     * 
     */
    public Optional<String> date() {
        return Optional.ofNullable(this.date);
    }
    /**
     * @return Lifetime, in days, of the objects that are subject to the rule. The value must be a non-zero positive integer.
     * 
     */
    public Optional<Double> days() {
        return Optional.ofNullable(this.days);
    }
    /**
     * @return Indicates whether Amazon S3 will remove a delete marker with no noncurrent versions. If set to `true`, the delete marker will be expired; if set to `false` the policy takes no action.
     * 
     */
    public Optional<Boolean> expiredObjectDeleteMarker() {
        return Optional.ofNullable(this.expiredObjectDeleteMarker);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(BucketLifecycleConfigurationV2RuleExpiration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String date;
        private @Nullable Double days;
        private @Nullable Boolean expiredObjectDeleteMarker;
        public Builder() {}
        public Builder(BucketLifecycleConfigurationV2RuleExpiration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.date = defaults.date;
    	      this.days = defaults.days;
    	      this.expiredObjectDeleteMarker = defaults.expiredObjectDeleteMarker;
        }

        @CustomType.Setter
        public Builder date(@Nullable String date) {

            this.date = date;
            return this;
        }
        @CustomType.Setter
        public Builder days(@Nullable Double days) {

            this.days = days;
            return this;
        }
        @CustomType.Setter
        public Builder expiredObjectDeleteMarker(@Nullable Boolean expiredObjectDeleteMarker) {

            this.expiredObjectDeleteMarker = expiredObjectDeleteMarker;
            return this;
        }
        public BucketLifecycleConfigurationV2RuleExpiration build() {
            final var _resultValue = new BucketLifecycleConfigurationV2RuleExpiration();
            _resultValue.date = date;
            _resultValue.days = days;
            _resultValue.expiredObjectDeleteMarker = expiredObjectDeleteMarker;
            return _resultValue;
        }
    }
}
