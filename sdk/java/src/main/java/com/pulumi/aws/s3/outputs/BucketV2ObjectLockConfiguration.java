// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.s3.outputs;

import com.pulumi.aws.s3.outputs.BucketV2ObjectLockConfigurationRule;
import com.pulumi.core.annotations.CustomType;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class BucketV2ObjectLockConfiguration {
    /**
     * @return Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
     * 
     * @deprecated
     * object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead.
     * 
     */
    @Deprecated /* object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead. */
    private @Nullable String objectLockEnabled;
    /**
     * @return Object Lock rule in place for this bucket (documented below).
     * 
     * @deprecated
     * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
    private @Nullable List<BucketV2ObjectLockConfigurationRule> rules;

    private BucketV2ObjectLockConfiguration() {}
    /**
     * @return Indicates whether this bucket has an Object Lock configuration enabled. Valid values are `true` or `false`. This argument is not supported in all regions or partitions.
     * 
     * @deprecated
     * object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead.
     * 
     */
    @Deprecated /* object_lock_enabled is deprecated. Use the top-level parameter object_lock_enabled instead. */
    public Optional<String> objectLockEnabled() {
        return Optional.ofNullable(this.objectLockEnabled);
    }
    /**
     * @return Object Lock rule in place for this bucket (documented below).
     * 
     * @deprecated
     * rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead.
     * 
     */
    @Deprecated /* rule is deprecated. Use the aws.s3.BucketObjectLockConfigurationV2 resource instead. */
    public List<BucketV2ObjectLockConfigurationRule> rules() {
        return this.rules == null ? List.of() : this.rules;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(BucketV2ObjectLockConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable String objectLockEnabled;
        private @Nullable List<BucketV2ObjectLockConfigurationRule> rules;
        public Builder() {}
        public Builder(BucketV2ObjectLockConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.objectLockEnabled = defaults.objectLockEnabled;
    	      this.rules = defaults.rules;
        }

        @CustomType.Setter
        public Builder objectLockEnabled(@Nullable String objectLockEnabled) {

            this.objectLockEnabled = objectLockEnabled;
            return this;
        }
        @CustomType.Setter
        public Builder rules(@Nullable List<BucketV2ObjectLockConfigurationRule> rules) {

            this.rules = rules;
            return this;
        }
        public Builder rules(BucketV2ObjectLockConfigurationRule... rules) {
            return rules(List.of(rules));
        }
        public BucketV2ObjectLockConfiguration build() {
            final var _resultValue = new BucketV2ObjectLockConfiguration();
            _resultValue.objectLockEnabled = objectLockEnabled;
            _resultValue.rules = rules;
            return _resultValue;
        }
    }
}
