// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.cloudfront.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig {
    /**
     * @return The amount of time in seconds after which sessions will cease if no requests are received. Valid values are `300` – `3600` (5–60 minutes). The value must be less than or equal to `maximum_ttl`.
     * 
     */
    private Integer idleTtl;
    /**
     * @return The maximum amount of time in seconds to consider requests from the viewer as being part of the same session. Valid values are `300` – `3600` (5–60 minutes). The value must be greater than or equal to `idle_ttl`.
     * 
     */
    private Integer maximumTtl;

    private ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig() {}
    /**
     * @return The amount of time in seconds after which sessions will cease if no requests are received. Valid values are `300` – `3600` (5–60 minutes). The value must be less than or equal to `maximum_ttl`.
     * 
     */
    public Integer idleTtl() {
        return this.idleTtl;
    }
    /**
     * @return The maximum amount of time in seconds to consider requests from the viewer as being part of the same session. Valid values are `300` – `3600` (5–60 minutes). The value must be greater than or equal to `idle_ttl`.
     * 
     */
    public Integer maximumTtl() {
        return this.maximumTtl;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer idleTtl;
        private Integer maximumTtl;
        public Builder() {}
        public Builder(ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.idleTtl = defaults.idleTtl;
    	      this.maximumTtl = defaults.maximumTtl;
        }

        @CustomType.Setter
        public Builder idleTtl(Integer idleTtl) {
            if (idleTtl == null) {
              throw new MissingRequiredPropertyException("ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig", "idleTtl");
            }
            this.idleTtl = idleTtl;
            return this;
        }
        @CustomType.Setter
        public Builder maximumTtl(Integer maximumTtl) {
            if (maximumTtl == null) {
              throw new MissingRequiredPropertyException("ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig", "maximumTtl");
            }
            this.maximumTtl = maximumTtl;
            return this;
        }
        public ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig build() {
            final var _resultValue = new ContinuousDeploymentPolicyTrafficConfigSingleWeightConfigSessionStickinessConfig();
            _resultValue.idleTtl = idleTtl;
            _resultValue.maximumTtl = maximumTtl;
            return _resultValue;
        }
    }
}
