// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.lex.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.util.Objects;

@CustomType
public final class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification {
    private Integer startTimeoutMs;

    private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification() {}
    public Integer startTimeoutMs() {
        return this.startTimeoutMs;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private Integer startTimeoutMs;
        public Builder() {}
        public Builder(V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.startTimeoutMs = defaults.startTimeoutMs;
        }

        @CustomType.Setter
        public Builder startTimeoutMs(Integer startTimeoutMs) {
            if (startTimeoutMs == null) {
              throw new MissingRequiredPropertyException("V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification", "startTimeoutMs");
            }
            this.startTimeoutMs = startTimeoutMs;
            return this;
        }
        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification build() {
            final var _resultValue = new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecification();
            _resultValue.startTimeoutMs = startTimeoutMs;
            return _resultValue;
        }
    }
}
