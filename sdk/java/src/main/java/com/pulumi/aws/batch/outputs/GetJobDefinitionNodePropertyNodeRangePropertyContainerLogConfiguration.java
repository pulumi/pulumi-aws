// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.batch.outputs;

import com.pulumi.aws.batch.outputs.GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfigurationSecretOption;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@CustomType
public final class GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration {
    /**
     * @return The log driver to use for the container.
     * 
     */
    private String logDriver;
    /**
     * @return The configuration options to send to the log driver.
     * 
     */
    private Map<String,String> options;
    /**
     * @return The secrets to pass to the log configuration.
     * 
     */
    private List<GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfigurationSecretOption> secretOptions;

    private GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration() {}
    /**
     * @return The log driver to use for the container.
     * 
     */
    public String logDriver() {
        return this.logDriver;
    }
    /**
     * @return The configuration options to send to the log driver.
     * 
     */
    public Map<String,String> options() {
        return this.options;
    }
    /**
     * @return The secrets to pass to the log configuration.
     * 
     */
    public List<GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfigurationSecretOption> secretOptions() {
        return this.secretOptions;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String logDriver;
        private Map<String,String> options;
        private List<GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfigurationSecretOption> secretOptions;
        public Builder() {}
        public Builder(GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.logDriver = defaults.logDriver;
    	      this.options = defaults.options;
    	      this.secretOptions = defaults.secretOptions;
        }

        @CustomType.Setter
        public Builder logDriver(String logDriver) {
            if (logDriver == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration", "logDriver");
            }
            this.logDriver = logDriver;
            return this;
        }
        @CustomType.Setter
        public Builder options(Map<String,String> options) {
            if (options == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration", "options");
            }
            this.options = options;
            return this;
        }
        @CustomType.Setter
        public Builder secretOptions(List<GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfigurationSecretOption> secretOptions) {
            if (secretOptions == null) {
              throw new MissingRequiredPropertyException("GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration", "secretOptions");
            }
            this.secretOptions = secretOptions;
            return this;
        }
        public Builder secretOptions(GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfigurationSecretOption... secretOptions) {
            return secretOptions(List.of(secretOptions));
        }
        public GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration build() {
            final var _resultValue = new GetJobDefinitionNodePropertyNodeRangePropertyContainerLogConfiguration();
            _resultValue.logDriver = logDriver;
            _resultValue.options = options;
            _resultValue.secretOptions = secretOptions;
            return _resultValue;
        }
    }
}
