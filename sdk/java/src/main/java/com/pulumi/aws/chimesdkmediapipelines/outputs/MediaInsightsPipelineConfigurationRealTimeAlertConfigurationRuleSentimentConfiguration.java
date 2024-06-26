// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chimesdkmediapipelines.outputs;

import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Integer;
import java.lang.String;
import java.util.Objects;

@CustomType
public final class MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration {
    /**
     * @return Rule name.
     * 
     */
    private String ruleName;
    /**
     * @return Sentiment type to match.
     * 
     */
    private String sentimentType;
    /**
     * @return Analysis interval.
     * 
     */
    private Integer timePeriod;

    private MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration() {}
    /**
     * @return Rule name.
     * 
     */
    public String ruleName() {
        return this.ruleName;
    }
    /**
     * @return Sentiment type to match.
     * 
     */
    public String sentimentType() {
        return this.sentimentType;
    }
    /**
     * @return Analysis interval.
     * 
     */
    public Integer timePeriod() {
        return this.timePeriod;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private String ruleName;
        private String sentimentType;
        private Integer timePeriod;
        public Builder() {}
        public Builder(MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.ruleName = defaults.ruleName;
    	      this.sentimentType = defaults.sentimentType;
    	      this.timePeriod = defaults.timePeriod;
        }

        @CustomType.Setter
        public Builder ruleName(String ruleName) {
            if (ruleName == null) {
              throw new MissingRequiredPropertyException("MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration", "ruleName");
            }
            this.ruleName = ruleName;
            return this;
        }
        @CustomType.Setter
        public Builder sentimentType(String sentimentType) {
            if (sentimentType == null) {
              throw new MissingRequiredPropertyException("MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration", "sentimentType");
            }
            this.sentimentType = sentimentType;
            return this;
        }
        @CustomType.Setter
        public Builder timePeriod(Integer timePeriod) {
            if (timePeriod == null) {
              throw new MissingRequiredPropertyException("MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration", "timePeriod");
            }
            this.timePeriod = timePeriod;
            return this;
        }
        public MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration build() {
            final var _resultValue = new MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration();
            _resultValue.ruleName = ruleName;
            _resultValue.sentimentType = sentimentType;
            _resultValue.timePeriod = timePeriod;
            return _resultValue;
        }
    }
}
