// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.codeguruprofiler.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.util.Objects;

@CustomType
public final class ProfilingGroupAgentOrchestrationConfig {
    /**
     * @return (Required) Boolean that specifies whether the profiling agent collects profiling data or
     * 
     */
    private Boolean profilingEnabled;

    private ProfilingGroupAgentOrchestrationConfig() {}
    /**
     * @return (Required) Boolean that specifies whether the profiling agent collects profiling data or
     * 
     */
    public Boolean profilingEnabled() {
        return this.profilingEnabled;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(ProfilingGroupAgentOrchestrationConfig defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Boolean profilingEnabled;
        public Builder() {}
        public Builder(ProfilingGroupAgentOrchestrationConfig defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.profilingEnabled = defaults.profilingEnabled;
        }

        @CustomType.Setter
        public Builder profilingEnabled(Boolean profilingEnabled) {
            if (profilingEnabled == null) {
              throw new MissingRequiredPropertyException("ProfilingGroupAgentOrchestrationConfig", "profilingEnabled");
            }
            this.profilingEnabled = profilingEnabled;
            return this;
        }
        public ProfilingGroupAgentOrchestrationConfig build() {
            final var _resultValue = new ProfilingGroupAgentOrchestrationConfig();
            _resultValue.profilingEnabled = profilingEnabled;
            return _resultValue;
        }
    }
}
