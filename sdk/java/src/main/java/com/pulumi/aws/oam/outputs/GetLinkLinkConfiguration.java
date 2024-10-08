// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.oam.outputs;

import com.pulumi.aws.oam.outputs.GetLinkLinkConfigurationLogGroupConfiguration;
import com.pulumi.aws.oam.outputs.GetLinkLinkConfigurationMetricConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.util.List;
import java.util.Objects;

@CustomType
public final class GetLinkLinkConfiguration {
    /**
     * @return Configuration for filtering which log groups are to send log events from the source account to the monitoring account. See `log_group_configuration` Block for details.
     * 
     */
    private List<GetLinkLinkConfigurationLogGroupConfiguration> logGroupConfigurations;
    /**
     * @return Configuration for filtering which metric namespaces are to be shared from the source account to the monitoring account. See `metric_configuration` Block for details.
     * 
     */
    private List<GetLinkLinkConfigurationMetricConfiguration> metricConfigurations;

    private GetLinkLinkConfiguration() {}
    /**
     * @return Configuration for filtering which log groups are to send log events from the source account to the monitoring account. See `log_group_configuration` Block for details.
     * 
     */
    public List<GetLinkLinkConfigurationLogGroupConfiguration> logGroupConfigurations() {
        return this.logGroupConfigurations;
    }
    /**
     * @return Configuration for filtering which metric namespaces are to be shared from the source account to the monitoring account. See `metric_configuration` Block for details.
     * 
     */
    public List<GetLinkLinkConfigurationMetricConfiguration> metricConfigurations() {
        return this.metricConfigurations;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(GetLinkLinkConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private List<GetLinkLinkConfigurationLogGroupConfiguration> logGroupConfigurations;
        private List<GetLinkLinkConfigurationMetricConfiguration> metricConfigurations;
        public Builder() {}
        public Builder(GetLinkLinkConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.logGroupConfigurations = defaults.logGroupConfigurations;
    	      this.metricConfigurations = defaults.metricConfigurations;
        }

        @CustomType.Setter
        public Builder logGroupConfigurations(List<GetLinkLinkConfigurationLogGroupConfiguration> logGroupConfigurations) {
            if (logGroupConfigurations == null) {
              throw new MissingRequiredPropertyException("GetLinkLinkConfiguration", "logGroupConfigurations");
            }
            this.logGroupConfigurations = logGroupConfigurations;
            return this;
        }
        public Builder logGroupConfigurations(GetLinkLinkConfigurationLogGroupConfiguration... logGroupConfigurations) {
            return logGroupConfigurations(List.of(logGroupConfigurations));
        }
        @CustomType.Setter
        public Builder metricConfigurations(List<GetLinkLinkConfigurationMetricConfiguration> metricConfigurations) {
            if (metricConfigurations == null) {
              throw new MissingRequiredPropertyException("GetLinkLinkConfiguration", "metricConfigurations");
            }
            this.metricConfigurations = metricConfigurations;
            return this;
        }
        public Builder metricConfigurations(GetLinkLinkConfigurationMetricConfiguration... metricConfigurations) {
            return metricConfigurations(List.of(metricConfigurations));
        }
        public GetLinkLinkConfiguration build() {
            final var _resultValue = new GetLinkLinkConfiguration();
            _resultValue.logGroupConfigurations = logGroupConfigurations;
            _resultValue.metricConfigurations = metricConfigurations;
            return _resultValue;
        }
    }
}
