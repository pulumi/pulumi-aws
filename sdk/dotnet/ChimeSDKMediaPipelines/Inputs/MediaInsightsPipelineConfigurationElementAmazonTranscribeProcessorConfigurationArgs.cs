// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ChimeSDKMediaPipelines.Inputs
{

    public sealed class MediaInsightsPipelineConfigurationElementAmazonTranscribeProcessorConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Labels all personally identifiable information (PII) identified in Transcript events.
        /// </summary>
        [Input("contentIdentificationType")]
        public Input<string>? ContentIdentificationType { get; set; }

        /// <summary>
        /// Redacts all personally identifiable information (PII) identified in Transcript events.
        /// </summary>
        [Input("contentRedactionType")]
        public Input<string>? ContentRedactionType { get; set; }

        /// <summary>
        /// Enables partial result stabilization in Transcript events.
        /// </summary>
        [Input("enablePartialResultsStabilization")]
        public Input<bool>? EnablePartialResultsStabilization { get; set; }

        /// <summary>
        /// Filters partial Utterance events from delivery to the insights target.
        /// </summary>
        [Input("filterPartialResults")]
        public Input<bool>? FilterPartialResults { get; set; }

        /// <summary>
        /// Language code for the transcription model.
        /// </summary>
        [Input("languageCode", required: true)]
        public Input<string> LanguageCode { get; set; } = null!;

        /// <summary>
        /// Name of custom language model for transcription.
        /// </summary>
        [Input("languageModelName")]
        public Input<string>? LanguageModelName { get; set; }

        /// <summary>
        /// Level of stability to use when partial results stabilization is enabled.
        /// </summary>
        [Input("partialResultsStability")]
        public Input<string>? PartialResultsStability { get; set; }

        /// <summary>
        /// Types of personally identifiable information (PII) to redact from a Transcript event.
        /// </summary>
        [Input("piiEntityTypes")]
        public Input<string>? PiiEntityTypes { get; set; }

        /// <summary>
        /// Enables speaker partitioning (diarization) in your Transcript events.
        /// </summary>
        [Input("showSpeakerLabel")]
        public Input<bool>? ShowSpeakerLabel { get; set; }

        /// <summary>
        /// Method for applying a vocabulary filter to Transcript events.
        /// </summary>
        [Input("vocabularyFilterMethod")]
        public Input<string>? VocabularyFilterMethod { get; set; }

        /// <summary>
        /// Name of the custom vocabulary filter to use when processing Transcript events.
        /// </summary>
        [Input("vocabularyFilterName")]
        public Input<string>? VocabularyFilterName { get; set; }

        /// <summary>
        /// Name of the custom vocabulary to use when processing Transcript events.
        /// </summary>
        [Input("vocabularyName")]
        public Input<string>? VocabularyName { get; set; }

        public MediaInsightsPipelineConfigurationElementAmazonTranscribeProcessorConfigurationArgs()
        {
        }
        public static new MediaInsightsPipelineConfigurationElementAmazonTranscribeProcessorConfigurationArgs Empty => new MediaInsightsPipelineConfigurationElementAmazonTranscribeProcessorConfigurationArgs();
    }
}
