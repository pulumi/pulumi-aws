// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.datapipeline.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class PipelineDefinitionParameterObjectAttribute {
    /**
     * @return Field identifier.
     * 
     */
    private String key;
    /**
     * @return Field value, expressed as a String.
     * 
     */
    private String stringValue;

    private PipelineDefinitionParameterObjectAttribute() {}
    /**
     * @return Field identifier.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return Field value, expressed as a String.
     * 
     */
    public String stringValue() {
        return this.stringValue;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(PipelineDefinitionParameterObjectAttribute defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String key;
        private String stringValue;
        public Builder() {}
        public Builder(PipelineDefinitionParameterObjectAttribute defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.key = defaults.key;
    	      this.stringValue = defaults.stringValue;
        }

        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("PipelineDefinitionParameterObjectAttribute", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder stringValue(String stringValue) {
            if (stringValue == null) {
              throw new MissingRequiredPropertyException("PipelineDefinitionParameterObjectAttribute", "stringValue");
            }
            this.stringValue = stringValue;
            return this;
        }
        public PipelineDefinitionParameterObjectAttribute build() {
            final var _resultValue = new PipelineDefinitionParameterObjectAttribute();
            _resultValue.key = key;
            _resultValue.stringValue = stringValue;
            return _resultValue;
        }
    }
}
