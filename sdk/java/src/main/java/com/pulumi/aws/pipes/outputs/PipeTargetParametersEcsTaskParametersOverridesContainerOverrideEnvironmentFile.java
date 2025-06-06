// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.pipes.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile {
    /**
     * @return The type of placement strategy. The random placement strategy randomly places tasks on available candidates. The spread placement strategy spreads placement across available candidates evenly based on the field parameter. The binpack strategy places tasks on available candidates that have the least available amount of the resource that is specified with the field parameter. For example, if you binpack on memory, a task is placed on the instance with the least amount of remaining memory (but still enough to run the task). Valid Values: random, spread, binpack.
     * 
     */
    private String type;
    /**
     * @return Value of parameter to start execution of a SageMaker AI Model Building Pipeline. Maximum length of 1024.
     * 
     */
    private String value;

    private PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile() {}
    /**
     * @return The type of placement strategy. The random placement strategy randomly places tasks on available candidates. The spread placement strategy spreads placement across available candidates evenly based on the field parameter. The binpack strategy places tasks on available candidates that have the least available amount of the resource that is specified with the field parameter. For example, if you binpack on memory, a task is placed on the instance with the least amount of remaining memory (but still enough to run the task). Valid Values: random, spread, binpack.
     * 
     */
    public String type() {
        return this.type;
    }
    /**
     * @return Value of parameter to start execution of a SageMaker AI Model Building Pipeline. Maximum length of 1024.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String type;
        private String value;
        public Builder() {}
        public Builder(PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.type = defaults.type;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile", "type");
            }
            this.type = type;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile", "value");
            }
            this.value = value;
            return this;
        }
        public PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile build() {
            final var _resultValue = new PipeTargetParametersEcsTaskParametersOverridesContainerOverrideEnvironmentFile();
            _resultValue.type = type;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
