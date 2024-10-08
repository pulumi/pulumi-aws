// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentDataSourceDataSourceConfigurationS3Configuration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class AgentDataSourceDataSourceConfiguration {
    /**
     * @return Details about the configuration of the S3 object containing the data source. See `s3_data_source_configuration` block for details.
     * 
     */
    private @Nullable AgentDataSourceDataSourceConfigurationS3Configuration s3Configuration;
    /**
     * @return Type of storage for the data source. Valid values: `S3`.
     * 
     */
    private String type;

    private AgentDataSourceDataSourceConfiguration() {}
    /**
     * @return Details about the configuration of the S3 object containing the data source. See `s3_data_source_configuration` block for details.
     * 
     */
    public Optional<AgentDataSourceDataSourceConfigurationS3Configuration> s3Configuration() {
        return Optional.ofNullable(this.s3Configuration);
    }
    /**
     * @return Type of storage for the data source. Valid values: `S3`.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentDataSourceDataSourceConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable AgentDataSourceDataSourceConfigurationS3Configuration s3Configuration;
        private String type;
        public Builder() {}
        public Builder(AgentDataSourceDataSourceConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.s3Configuration = defaults.s3Configuration;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder s3Configuration(@Nullable AgentDataSourceDataSourceConfigurationS3Configuration s3Configuration) {

            this.s3Configuration = s3Configuration;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("AgentDataSourceDataSourceConfiguration", "type");
            }
            this.type = type;
            return this;
        }
        public AgentDataSourceDataSourceConfiguration build() {
            final var _resultValue = new AgentDataSourceDataSourceConfiguration();
            _resultValue.s3Configuration = s3Configuration;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
