// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class AgentPromptVariantMetadata {
    /**
     * @return Key of a metadata tag for a prompt variant.
     * 
     */
    private String key;
    /**
     * @return Value of a metadata tag for a prompt variant.
     * 
     */
    private String value;

    private AgentPromptVariantMetadata() {}
    /**
     * @return Key of a metadata tag for a prompt variant.
     * 
     */
    public String key() {
        return this.key;
    }
    /**
     * @return Value of a metadata tag for a prompt variant.
     * 
     */
    public String value() {
        return this.value;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentPromptVariantMetadata defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String key;
        private String value;
        public Builder() {}
        public Builder(AgentPromptVariantMetadata defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.key = defaults.key;
    	      this.value = defaults.value;
        }

        @CustomType.Setter
        public Builder key(String key) {
            if (key == null) {
              throw new MissingRequiredPropertyException("AgentPromptVariantMetadata", "key");
            }
            this.key = key;
            return this;
        }
        @CustomType.Setter
        public Builder value(String value) {
            if (value == null) {
              throw new MissingRequiredPropertyException("AgentPromptVariantMetadata", "value");
            }
            this.value = value;
            return this;
        }
        public AgentPromptVariantMetadata build() {
            final var _resultValue = new AgentPromptVariantMetadata();
            _resultValue.key = key;
            _resultValue.value = value;
            return _resultValue;
        }
    }
}
