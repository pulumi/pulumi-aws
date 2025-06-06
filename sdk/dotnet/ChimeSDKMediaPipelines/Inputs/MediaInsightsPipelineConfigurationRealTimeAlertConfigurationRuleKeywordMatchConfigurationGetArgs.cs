// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ChimeSDKMediaPipelines.Inputs
{

    public sealed class MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("keywords", required: true)]
        private InputList<string>? _keywords;

        /// <summary>
        /// Collection of keywords to match.
        /// </summary>
        public InputList<string> Keywords
        {
            get => _keywords ?? (_keywords = new InputList<string>());
            set => _keywords = value;
        }

        /// <summary>
        /// Negate the rule.
        /// </summary>
        [Input("negate")]
        public Input<bool>? Negate { get; set; }

        /// <summary>
        /// Rule name.
        /// </summary>
        [Input("ruleName", required: true)]
        public Input<string> RuleName { get; set; } = null!;

        public MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfigurationGetArgs()
        {
        }
        public static new MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfigurationGetArgs Empty => new MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleKeywordMatchConfigurationGetArgs();
    }
}
