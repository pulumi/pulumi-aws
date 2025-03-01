// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class InferenceProfileModel {
    /**
     * @return The Amazon Resource Name (ARN) of the model.
     * 
     */
    private String modelArn;

    private InferenceProfileModel() {}
    /**
     * @return The Amazon Resource Name (ARN) of the model.
     * 
     */
    public String modelArn() {
        return this.modelArn;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(InferenceProfileModel defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String modelArn;
        public Builder() {}
        public Builder(InferenceProfileModel defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.modelArn = defaults.modelArn;
        }

        @CustomType.Setter
        public Builder modelArn(String modelArn) {
            if (modelArn == null) {
              throw new MissingRequiredPropertyException("InferenceProfileModel", "modelArn");
            }
            this.modelArn = modelArn;
            return this;
        }
        public InferenceProfileModel build() {
            final var _resultValue = new InferenceProfileModel();
            _resultValue.modelArn = modelArn;
            return _resultValue;
        }
    }
}
