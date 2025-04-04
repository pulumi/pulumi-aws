// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class GetJobDefinitionTimeout {
    /**
     * @return The job timeout time (in seconds) that&#39;s measured from the job attempt&#39;s startedAt timestamp.
     * 
     */
    private Integer attemptDurationSeconds;

    private GetJobDefinitionTimeout() {}
    /**
     * @return The job timeout time (in seconds) that&#39;s measured from the job attempt&#39;s startedAt timestamp.
     * 
     */
    public Integer attemptDurationSeconds() {
        return this.attemptDurationSeconds;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetJobDefinitionTimeout defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer attemptDurationSeconds;
        public Builder() {}
        public Builder(GetJobDefinitionTimeout defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.attemptDurationSeconds = defaults.attemptDurationSeconds;
        }

        @CustomType.Setter
        public Builder attemptDurationSeconds(Integer attemptDurationSeconds) {
            if (attemptDurationSeconds == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionTimeout", "attemptDurationSeconds");
            }
            this.attemptDurationSeconds = attemptDurationSeconds;
            return this;
        }
        public GetJobDefinitionTimeout build() {
            final var _resultValue = new GetJobDefinitionTimeout();
            _resultValue.attemptDurationSeconds = attemptDurationSeconds;
            return _resultValue;
        }
    }
}
