// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Chime.Outputs
{

    [OutputType]
    public sealed class VoiceConnectorStreamingMediaInsightsConfiguration
    {
        /// <summary>
        /// The media insights configuration that will be invoked by the Voice Connector.
        /// </summary>
        public readonly string? ConfigurationArn;
        /// <summary>
        /// When `true`, the media insights configuration is not enabled. Defaults to `false`.
        /// </summary>
        public readonly bool? Disabled;

        [OutputConstructor]
        private VoiceConnectorStreamingMediaInsightsConfiguration(
            string? configurationArn,

            bool? disabled)
        {
            ConfigurationArn = configurationArn;
            Disabled = disabled;
        }
    }
}