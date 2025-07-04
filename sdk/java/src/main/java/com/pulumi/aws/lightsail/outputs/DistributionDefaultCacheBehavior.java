// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lightsail.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class DistributionDefaultCacheBehavior {
    /**
     * @return Cache behavior of the distribution. Valid values: `cache`, `dont-cache`.
     * 
     */
    private String behavior;

    private DistributionDefaultCacheBehavior() {}
    /**
     * @return Cache behavior of the distribution. Valid values: `cache`, `dont-cache`.
     * 
     */
    public String behavior() {
        return this.behavior;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(DistributionDefaultCacheBehavior defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String behavior;
        public Builder() {}
        public Builder(DistributionDefaultCacheBehavior defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.behavior = defaults.behavior;
        }

        @CustomType.Setter
        public Builder behavior(String behavior) {
            if (behavior == null) {
              throw new MissingRequiredPropertyException("DistributionDefaultCacheBehavior", "behavior");
            }
            this.behavior = behavior;
            return this;
        }
        public DistributionDefaultCacheBehavior build() {
            final var _resultValue = new DistributionDefaultCacheBehavior();
            _resultValue.behavior = behavior;
            return _resultValue;
        }
    }
}
