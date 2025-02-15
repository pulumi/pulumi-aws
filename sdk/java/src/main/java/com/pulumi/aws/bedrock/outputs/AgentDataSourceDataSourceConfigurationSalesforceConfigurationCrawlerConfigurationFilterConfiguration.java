// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.bedrock.outputs;

import com.pulumi.aws.bedrock.outputs.AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;

@CustomType
public final class AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration {
    /**
     * @return The configuration of filtering certain objects or content types of the data source. See `pattern_object_filter` block for details.
     * 
     */
    private @Nullable List<AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter> patternObjectFilters;
    /**
     * @return The type of filtering that you want to apply to certain objects or content of the data source. For example, the PATTERN type is regular expression patterns you can apply to filter your content.
     * 
     */
    private String type;

    private AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration() {}
    /**
     * @return The configuration of filtering certain objects or content types of the data source. See `pattern_object_filter` block for details.
     * 
     */
    public List<AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter> patternObjectFilters() {
        return this.patternObjectFilters == null ? List.of() : this.patternObjectFilters;
    }
    /**
     * @return The type of filtering that you want to apply to certain objects or content of the data source. For example, the PATTERN type is regular expression patterns you can apply to filter your content.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable List<AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter> patternObjectFilters;
        private String type;
        public Builder() {}
        public Builder(AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.patternObjectFilters = defaults.patternObjectFilters;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder patternObjectFilters(@Nullable List<AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter> patternObjectFilters) {

            this.patternObjectFilters = patternObjectFilters;
            return this;
        }
        public Builder patternObjectFilters(AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfigurationPatternObjectFilter... patternObjectFilters) {
            return patternObjectFilters(List.of(patternObjectFilters));
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration", "type");
            }
            this.type = type;
            return this;
        }
        public AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration build() {
            final var _resultValue = new AgentDataSourceDataSourceConfigurationSalesforceConfigurationCrawlerConfigurationFilterConfiguration();
            _resultValue.patternObjectFilters = patternObjectFilters;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
