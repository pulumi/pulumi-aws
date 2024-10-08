// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chimesdkmediapipelines.outputs;

import com.pulumi.aws.chimesdkmediapipelines.outputs.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleIssueDetectionConfiguration;
import com.pulumi.aws.chimesdkmediapipelines.outputs.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfiguration;
import com.pulumi.aws.chimesdkmediapipelines.outputs.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration;
import com.pulumi.core.annotations.CustomType;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

@CustomType
public final class MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule {
    /**
     * @return Configuration for an issue detection rule.
     * 
     */
    private @Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleIssueDetectionConfiguration issueDetectionConfiguration;
    /**
     * @return Configuration for a keyword match rule.
     * 
     */
    private @Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfiguration keywordMatchConfiguration;
    /**
     * @return Configuration for a sentiment rule.
     * 
     */
    private @Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration sentimentConfiguration;
    /**
     * @return Rule type.
     * 
     */
    private String type;

    private MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule() {}
    /**
     * @return Configuration for an issue detection rule.
     * 
     */
    public Optional<MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleIssueDetectionConfiguration> issueDetectionConfiguration() {
        return Optional.ofNullable(this.issueDetectionConfiguration);
    }
    /**
     * @return Configuration for a keyword match rule.
     * 
     */
    public Optional<MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfiguration> keywordMatchConfiguration() {
        return Optional.ofNullable(this.keywordMatchConfiguration);
    }
    /**
     * @return Configuration for a sentiment rule.
     * 
     */
    public Optional<MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration> sentimentConfiguration() {
        return Optional.ofNullable(this.sentimentConfiguration);
    }
    /**
     * @return Rule type.
     * 
     */
    public String type() {
        return this.type;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Builder builder(MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule defaults) {
        return new Builder(defaults);
    }
    @CustomType.Builder
    public static final class Builder {
        private @Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleIssueDetectionConfiguration issueDetectionConfiguration;
        private @Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfiguration keywordMatchConfiguration;
        private @Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration sentimentConfiguration;
        private String type;
        public Builder() {}
        public Builder(MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule defaults) {
    	      Objects.requireNonNull(defaults);
    	      this.issueDetectionConfiguration = defaults.issueDetectionConfiguration;
    	      this.keywordMatchConfiguration = defaults.keywordMatchConfiguration;
    	      this.sentimentConfiguration = defaults.sentimentConfiguration;
    	      this.type = defaults.type;
        }

        @CustomType.Setter
        public Builder issueDetectionConfiguration(@Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleIssueDetectionConfiguration issueDetectionConfiguration) {

            this.issueDetectionConfiguration = issueDetectionConfiguration;
            return this;
        }
        @CustomType.Setter
        public Builder keywordMatchConfiguration(@Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfiguration keywordMatchConfiguration) {

            this.keywordMatchConfiguration = keywordMatchConfiguration;
            return this;
        }
        @CustomType.Setter
        public Builder sentimentConfiguration(@Nullable MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleSentimentConfiguration sentimentConfiguration) {

            this.sentimentConfiguration = sentimentConfiguration;
            return this;
        }
        @CustomType.Setter
        public Builder type(String type) {
            if (type == null) {
              throw new MissingRequiredPropertyException("MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule", "type");
            }
            this.type = type;
            return this;
        }
        public MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule build() {
            final var _resultValue = new MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRule();
            _resultValue.issueDetectionConfiguration = issueDetectionConfiguration;
            _resultValue.keywordMatchConfiguration = keywordMatchConfiguration;
            _resultValue.sentimentConfiguration = sentimentConfiguration;
            _resultValue.type = type;
            return _resultValue;
        }
    }
}
