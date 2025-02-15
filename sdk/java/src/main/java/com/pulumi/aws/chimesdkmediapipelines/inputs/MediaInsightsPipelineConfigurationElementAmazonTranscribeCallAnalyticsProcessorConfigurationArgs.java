// *** WARNING: this file was generated by pulumi-java-gen. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

package com.pulumi.aws.chimesdkmediapipelines.inputs;

import com.pulumi.aws.chimesdkmediapipelines.inputs.MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationPostCallAnalyticsSettingsArgs;
import com.pulumi.core.Output;
import com.pulumi.core.annotations.Import;
import com.pulumi.exceptions.MissingRequiredPropertyException;
import java.lang.Boolean;
import java.lang.String;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;


public final class MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs extends com.pulumi.resources.ResourceArgs {

    public static final MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs Empty = new MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs();

    /**
     * Filter for category events to be delivered to insights target.
     * 
     */
    @Import(name="callAnalyticsStreamCategories")
    private @Nullable Output<List<String>> callAnalyticsStreamCategories;

    /**
     * @return Filter for category events to be delivered to insights target.
     * 
     */
    public Optional<Output<List<String>>> callAnalyticsStreamCategories() {
        return Optional.ofNullable(this.callAnalyticsStreamCategories);
    }

    /**
     * Labels all personally identifiable information (PII) identified in Utterance events.
     * 
     */
    @Import(name="contentIdentificationType")
    private @Nullable Output<String> contentIdentificationType;

    /**
     * @return Labels all personally identifiable information (PII) identified in Utterance events.
     * 
     */
    public Optional<Output<String>> contentIdentificationType() {
        return Optional.ofNullable(this.contentIdentificationType);
    }

    /**
     * Redacts all personally identifiable information (PII) identified in Utterance events.
     * 
     */
    @Import(name="contentRedactionType")
    private @Nullable Output<String> contentRedactionType;

    /**
     * @return Redacts all personally identifiable information (PII) identified in Utterance events.
     * 
     */
    public Optional<Output<String>> contentRedactionType() {
        return Optional.ofNullable(this.contentRedactionType);
    }

    /**
     * Enables partial result stabilization in Utterance events.
     * 
     */
    @Import(name="enablePartialResultsStabilization")
    private @Nullable Output<Boolean> enablePartialResultsStabilization;

    /**
     * @return Enables partial result stabilization in Utterance events.
     * 
     */
    public Optional<Output<Boolean>> enablePartialResultsStabilization() {
        return Optional.ofNullable(this.enablePartialResultsStabilization);
    }

    /**
     * Filters partial Utterance events from delivery to the insights target.
     * 
     */
    @Import(name="filterPartialResults")
    private @Nullable Output<Boolean> filterPartialResults;

    /**
     * @return Filters partial Utterance events from delivery to the insights target.
     * 
     */
    public Optional<Output<Boolean>> filterPartialResults() {
        return Optional.ofNullable(this.filterPartialResults);
    }

    /**
     * Language code for the transcription model.
     * 
     */
    @Import(name="languageCode", required=true)
    private Output<String> languageCode;

    /**
     * @return Language code for the transcription model.
     * 
     */
    public Output<String> languageCode() {
        return this.languageCode;
    }

    /**
     * Name of custom language model for transcription.
     * 
     */
    @Import(name="languageModelName")
    private @Nullable Output<String> languageModelName;

    /**
     * @return Name of custom language model for transcription.
     * 
     */
    public Optional<Output<String>> languageModelName() {
        return Optional.ofNullable(this.languageModelName);
    }

    /**
     * Level of stability to use when partial results stabilization is enabled.
     * 
     */
    @Import(name="partialResultsStability")
    private @Nullable Output<String> partialResultsStability;

    /**
     * @return Level of stability to use when partial results stabilization is enabled.
     * 
     */
    public Optional<Output<String>> partialResultsStability() {
        return Optional.ofNullable(this.partialResultsStability);
    }

    /**
     * Types of personally identifiable information (PII) to redact from an Utterance event.
     * 
     */
    @Import(name="piiEntityTypes")
    private @Nullable Output<String> piiEntityTypes;

    /**
     * @return Types of personally identifiable information (PII) to redact from an Utterance event.
     * 
     */
    public Optional<Output<String>> piiEntityTypes() {
        return Optional.ofNullable(this.piiEntityTypes);
    }

    /**
     * Settings for post call analytics.
     * 
     */
    @Import(name="postCallAnalyticsSettings")
    private @Nullable Output<MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationPostCallAnalyticsSettingsArgs> postCallAnalyticsSettings;

    /**
     * @return Settings for post call analytics.
     * 
     */
    public Optional<Output<MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationPostCallAnalyticsSettingsArgs>> postCallAnalyticsSettings() {
        return Optional.ofNullable(this.postCallAnalyticsSettings);
    }

    /**
     * Method for applying a vocabulary filter to Utterance events.
     * 
     */
    @Import(name="vocabularyFilterMethod")
    private @Nullable Output<String> vocabularyFilterMethod;

    /**
     * @return Method for applying a vocabulary filter to Utterance events.
     * 
     */
    public Optional<Output<String>> vocabularyFilterMethod() {
        return Optional.ofNullable(this.vocabularyFilterMethod);
    }

    /**
     * Name of the custom vocabulary filter to use when processing Utterance events.
     * 
     */
    @Import(name="vocabularyFilterName")
    private @Nullable Output<String> vocabularyFilterName;

    /**
     * @return Name of the custom vocabulary filter to use when processing Utterance events.
     * 
     */
    public Optional<Output<String>> vocabularyFilterName() {
        return Optional.ofNullable(this.vocabularyFilterName);
    }

    /**
     * Name of the custom vocabulary to use when processing Utterance events.
     * 
     */
    @Import(name="vocabularyName")
    private @Nullable Output<String> vocabularyName;

    /**
     * @return Name of the custom vocabulary to use when processing Utterance events.
     * 
     */
    public Optional<Output<String>> vocabularyName() {
        return Optional.ofNullable(this.vocabularyName);
    }

    private MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs() {}

    private MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs(MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs $) {
        this.callAnalyticsStreamCategories = $.callAnalyticsStreamCategories;
        this.contentIdentificationType = $.contentIdentificationType;
        this.contentRedactionType = $.contentRedactionType;
        this.enablePartialResultsStabilization = $.enablePartialResultsStabilization;
        this.filterPartialResults = $.filterPartialResults;
        this.languageCode = $.languageCode;
        this.languageModelName = $.languageModelName;
        this.partialResultsStability = $.partialResultsStability;
        this.piiEntityTypes = $.piiEntityTypes;
        this.postCallAnalyticsSettings = $.postCallAnalyticsSettings;
        this.vocabularyFilterMethod = $.vocabularyFilterMethod;
        this.vocabularyFilterName = $.vocabularyFilterName;
        this.vocabularyName = $.vocabularyName;
    }

    public static Builder builder() {
        return new Builder();
    }
    public static Builder builder(MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs defaults) {
        return new Builder(defaults);
    }

    public static final class Builder {
        private MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs $;

        public Builder() {
            $ = new MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs();
        }

        public Builder(MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs defaults) {
            $ = new MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs(Objects.requireNonNull(defaults));
        }

        /**
         * @param callAnalyticsStreamCategories Filter for category events to be delivered to insights target.
         * 
         * @return builder
         * 
         */
        public Builder callAnalyticsStreamCategories(@Nullable Output<List<String>> callAnalyticsStreamCategories) {
            $.callAnalyticsStreamCategories = callAnalyticsStreamCategories;
            return this;
        }

        /**
         * @param callAnalyticsStreamCategories Filter for category events to be delivered to insights target.
         * 
         * @return builder
         * 
         */
        public Builder callAnalyticsStreamCategories(List<String> callAnalyticsStreamCategories) {
            return callAnalyticsStreamCategories(Output.of(callAnalyticsStreamCategories));
        }

        /**
         * @param callAnalyticsStreamCategories Filter for category events to be delivered to insights target.
         * 
         * @return builder
         * 
         */
        public Builder callAnalyticsStreamCategories(String... callAnalyticsStreamCategories) {
            return callAnalyticsStreamCategories(List.of(callAnalyticsStreamCategories));
        }

        /**
         * @param contentIdentificationType Labels all personally identifiable information (PII) identified in Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder contentIdentificationType(@Nullable Output<String> contentIdentificationType) {
            $.contentIdentificationType = contentIdentificationType;
            return this;
        }

        /**
         * @param contentIdentificationType Labels all personally identifiable information (PII) identified in Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder contentIdentificationType(String contentIdentificationType) {
            return contentIdentificationType(Output.of(contentIdentificationType));
        }

        /**
         * @param contentRedactionType Redacts all personally identifiable information (PII) identified in Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder contentRedactionType(@Nullable Output<String> contentRedactionType) {
            $.contentRedactionType = contentRedactionType;
            return this;
        }

        /**
         * @param contentRedactionType Redacts all personally identifiable information (PII) identified in Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder contentRedactionType(String contentRedactionType) {
            return contentRedactionType(Output.of(contentRedactionType));
        }

        /**
         * @param enablePartialResultsStabilization Enables partial result stabilization in Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder enablePartialResultsStabilization(@Nullable Output<Boolean> enablePartialResultsStabilization) {
            $.enablePartialResultsStabilization = enablePartialResultsStabilization;
            return this;
        }

        /**
         * @param enablePartialResultsStabilization Enables partial result stabilization in Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder enablePartialResultsStabilization(Boolean enablePartialResultsStabilization) {
            return enablePartialResultsStabilization(Output.of(enablePartialResultsStabilization));
        }

        /**
         * @param filterPartialResults Filters partial Utterance events from delivery to the insights target.
         * 
         * @return builder
         * 
         */
        public Builder filterPartialResults(@Nullable Output<Boolean> filterPartialResults) {
            $.filterPartialResults = filterPartialResults;
            return this;
        }

        /**
         * @param filterPartialResults Filters partial Utterance events from delivery to the insights target.
         * 
         * @return builder
         * 
         */
        public Builder filterPartialResults(Boolean filterPartialResults) {
            return filterPartialResults(Output.of(filterPartialResults));
        }

        /**
         * @param languageCode Language code for the transcription model.
         * 
         * @return builder
         * 
         */
        public Builder languageCode(Output<String> languageCode) {
            $.languageCode = languageCode;
            return this;
        }

        /**
         * @param languageCode Language code for the transcription model.
         * 
         * @return builder
         * 
         */
        public Builder languageCode(String languageCode) {
            return languageCode(Output.of(languageCode));
        }

        /**
         * @param languageModelName Name of custom language model for transcription.
         * 
         * @return builder
         * 
         */
        public Builder languageModelName(@Nullable Output<String> languageModelName) {
            $.languageModelName = languageModelName;
            return this;
        }

        /**
         * @param languageModelName Name of custom language model for transcription.
         * 
         * @return builder
         * 
         */
        public Builder languageModelName(String languageModelName) {
            return languageModelName(Output.of(languageModelName));
        }

        /**
         * @param partialResultsStability Level of stability to use when partial results stabilization is enabled.
         * 
         * @return builder
         * 
         */
        public Builder partialResultsStability(@Nullable Output<String> partialResultsStability) {
            $.partialResultsStability = partialResultsStability;
            return this;
        }

        /**
         * @param partialResultsStability Level of stability to use when partial results stabilization is enabled.
         * 
         * @return builder
         * 
         */
        public Builder partialResultsStability(String partialResultsStability) {
            return partialResultsStability(Output.of(partialResultsStability));
        }

        /**
         * @param piiEntityTypes Types of personally identifiable information (PII) to redact from an Utterance event.
         * 
         * @return builder
         * 
         */
        public Builder piiEntityTypes(@Nullable Output<String> piiEntityTypes) {
            $.piiEntityTypes = piiEntityTypes;
            return this;
        }

        /**
         * @param piiEntityTypes Types of personally identifiable information (PII) to redact from an Utterance event.
         * 
         * @return builder
         * 
         */
        public Builder piiEntityTypes(String piiEntityTypes) {
            return piiEntityTypes(Output.of(piiEntityTypes));
        }

        /**
         * @param postCallAnalyticsSettings Settings for post call analytics.
         * 
         * @return builder
         * 
         */
        public Builder postCallAnalyticsSettings(@Nullable Output<MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationPostCallAnalyticsSettingsArgs> postCallAnalyticsSettings) {
            $.postCallAnalyticsSettings = postCallAnalyticsSettings;
            return this;
        }

        /**
         * @param postCallAnalyticsSettings Settings for post call analytics.
         * 
         * @return builder
         * 
         */
        public Builder postCallAnalyticsSettings(MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationPostCallAnalyticsSettingsArgs postCallAnalyticsSettings) {
            return postCallAnalyticsSettings(Output.of(postCallAnalyticsSettings));
        }

        /**
         * @param vocabularyFilterMethod Method for applying a vocabulary filter to Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder vocabularyFilterMethod(@Nullable Output<String> vocabularyFilterMethod) {
            $.vocabularyFilterMethod = vocabularyFilterMethod;
            return this;
        }

        /**
         * @param vocabularyFilterMethod Method for applying a vocabulary filter to Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder vocabularyFilterMethod(String vocabularyFilterMethod) {
            return vocabularyFilterMethod(Output.of(vocabularyFilterMethod));
        }

        /**
         * @param vocabularyFilterName Name of the custom vocabulary filter to use when processing Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder vocabularyFilterName(@Nullable Output<String> vocabularyFilterName) {
            $.vocabularyFilterName = vocabularyFilterName;
            return this;
        }

        /**
         * @param vocabularyFilterName Name of the custom vocabulary filter to use when processing Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder vocabularyFilterName(String vocabularyFilterName) {
            return vocabularyFilterName(Output.of(vocabularyFilterName));
        }

        /**
         * @param vocabularyName Name of the custom vocabulary to use when processing Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder vocabularyName(@Nullable Output<String> vocabularyName) {
            $.vocabularyName = vocabularyName;
            return this;
        }

        /**
         * @param vocabularyName Name of the custom vocabulary to use when processing Utterance events.
         * 
         * @return builder
         * 
         */
        public Builder vocabularyName(String vocabularyName) {
            return vocabularyName(Output.of(vocabularyName));
        }

        public MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs build() {
            if ($.languageCode == null) {
                throw new MissingRequiredPropertyException("MediaInsightsPipelineConfigurationElementAmazonTranscribeCallAnalyticsProcessorConfigurationArgs", "languageCode");
            }
            return $;
        }
    }

}
