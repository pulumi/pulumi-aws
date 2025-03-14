// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformationTransformationFunction;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation {
    /**
     * @return When the service applies the transformation. Currently only `POST_CHUNKING` is supported.
     * 
     */
    private String stepToApply;
    /**
     * @return The lambda function that processes documents.
     * 
     */
    private @Nullable AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformationTransformationFunction transformationFunction;

    private AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation() {}
    /**
     * @return When the service applies the transformation. Currently only `POST_CHUNKING` is supported.
     * 
     */
    public String stepToApply() {
        return this.stepToApply;
    }
    /**
     * @return The lambda function that processes documents.
     * 
     */
    public Optional<AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformationTransformationFunction> transformationFunction() {
        return Optional.ofNullable(this.transformationFunction);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String stepToApply;
        private @Nullable AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformationTransformationFunction transformationFunction;
        public Builder() {}
        public Builder(AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.stepToApply = defaults.stepToApply;
    	      this.transformationFunction = defaults.transformationFunction;
        }

        @CustomType.Setter
        public Builder stepToApply(String stepToApply) {
            if (stepToApply == null) {
              throw new MissingRequiredPropertyException("AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation", "stepToApply");
            }
            this.stepToApply = stepToApply;
            return this;
        }
        @CustomType.Setter
        public Builder transformationFunction(@Nullable AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformationTransformationFunction transformationFunction) {

            this.transformationFunction = transformationFunction;
            return this;
        }
        public AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation build() {
            final var _resultValue = new AgentDataSourceVectorIngestionConfigurationCustomTransformationConfigurationTransformation();
            _resultValue.stepToApply = stepToApply;
            _resultValue.transformationFunction = transformationFunction;
            return _resultValue;
        }
    }
}
