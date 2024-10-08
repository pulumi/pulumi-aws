// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentDataSourceVectorIngestionConfigurationParsingConfigurationBedrockFoundationModelConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class AgentDataSourceVectorIngestionConfigurationParsingConfiguration {
    /**
     * @return Settings for a foundation model used to parse documents in a data source. See `bedrock_foundation_model_configuration` block for details.
     * 
     */
    private @Nullable AgentDataSourceVectorIngestionConfigurationParsingConfigurationBedrockFoundationModelConfiguration bedrockFoundationModelConfiguration;
    /**
     * @return Currently only `BEDROCK_FOUNDATION_MODEL` is supported
     * 
     */
    private String parsingStrategy;

    private AgentDataSourceVectorIngestionConfigurationParsingConfiguration() {}
    /**
     * @return Settings for a foundation model used to parse documents in a data source. See `bedrock_foundation_model_configuration` block for details.
     * 
     */
    public Optional<AgentDataSourceVectorIngestionConfigurationParsingConfigurationBedrockFoundationModelConfiguration> bedrockFoundationModelConfiguration() {
        return Optional.ofNullable(this.bedrockFoundationModelConfiguration);
    }
    /**
     * @return Currently only `BEDROCK_FOUNDATION_MODEL` is supported
     * 
     */
    public String parsingStrategy() {
        return this.parsingStrategy;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentDataSourceVectorIngestionConfigurationParsingConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable AgentDataSourceVectorIngestionConfigurationParsingConfigurationBedrockFoundationModelConfiguration bedrockFoundationModelConfiguration;
        private String parsingStrategy;
        public Builder() {}
        public Builder(AgentDataSourceVectorIngestionConfigurationParsingConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.bedrockFoundationModelConfiguration = defaults.bedrockFoundationModelConfiguration;
    	      this.parsingStrategy = defaults.parsingStrategy;
        }

        @CustomType.Setter
        public Builder bedrockFoundationModelConfiguration(@Nullable AgentDataSourceVectorIngestionConfigurationParsingConfigurationBedrockFoundationModelConfiguration bedrockFoundationModelConfiguration) {

            this.bedrockFoundationModelConfiguration = bedrockFoundationModelConfiguration;
            return this;
        }
        @CustomType.Setter
        public Builder parsingStrategy(String parsingStrategy) {
            if (parsingStrategy == null) {
              throw new MissingRequiredPropertyException("AgentDataSourceVectorIngestionConfigurationParsingConfiguration", "parsingStrategy");
            }
            this.parsingStrategy = parsingStrategy;
            return this;
        }
        public AgentDataSourceVectorIngestionConfigurationParsingConfiguration build() {
            final var _resultValue = new AgentDataSourceVectorIngestionConfigurationParsingConfiguration();
            _resultValue.bedrockFoundationModelConfiguration = bedrockFoundationModelConfiguration;
            _resultValue.parsingStrategy = parsingStrategy;
            return _resultValue;
        }
    }
}
