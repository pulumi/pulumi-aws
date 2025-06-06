// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudfront.outputs;

import com.pulumi.core.annotations.CustomType;
import java.lang.Boolean;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class DistributionOrderedCacheBehaviorGrpcConfig {
    /**
     * @return Whether the distribution is enabled to accept end user requests for content.
     * 
     */
    private @Nullable Boolean enabled;

    private DistributionOrderedCacheBehaviorGrpcConfig() {}
    /**
     * @return Whether the distribution is enabled to accept end user requests for content.
     * 
     */
    public Optional<Boolean> enabled() {
        return Optional.ofNullable(this.enabled);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DistributionOrderedCacheBehaviorGrpcConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable Boolean enabled;
        public Builder() {}
        public Builder(DistributionOrderedCacheBehaviorGrpcConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.enabled = defaults.enabled;
        }

        @CustomType.Setter
        public Builder enabled(@Nullable Boolean enabled) {

            this.enabled = enabled;
            return this;
        }
        public DistributionOrderedCacheBehaviorGrpcConfig build() {
            final var _resultValue = new DistributionOrderedCacheBehaviorGrpcConfig();
            _resultValue.enabled = enabled;
            return _resultValue;
        }
    }
}
