// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ChimeSDKMediaPipelines.Inputs
{

    public sealed class MediaInsightsPipelineConfigurationRealTimeAlertConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Disables real time alert rules.
        /// </summary>
        [Input("disabled")]
        public Input<bool>? Disabled { get; set; }

        [Input("rules", required: true)]
        private InputList<Inputs.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArgs>? _rules;

        /// <summary>
        /// Collection of real time alert rules
        /// </summary>
        public InputList<Inputs.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArgs> Rules
        {
            get => _rules ?? (_rules = new InputList<Inputs.MediaInsightsPipelineConfigurationRealTimeAlertConfigurationRuleArgs>());
            set => _rules = value;
        }

        public MediaInsightsPipelineConfigurationRealTimeAlertConfigurationArgs()
        {
        }
        public static new MediaInsightsPipelineConfigurationRealTimeAlertConfigurationArgs Empty => new MediaInsightsPipelineConfigurationRealTimeAlertConfigurationArgs();
    }
}
