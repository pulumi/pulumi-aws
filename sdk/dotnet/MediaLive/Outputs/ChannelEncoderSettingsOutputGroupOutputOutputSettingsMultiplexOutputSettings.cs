// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Outputs
{

    [OutputType]
    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsMultiplexOutputSettings
    {
        /// <summary>
        /// Destination is a multiplex. See Destination for more details.
        /// </summary>
        public readonly Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsMultiplexOutputSettingsDestination Destination;

        [OutputConstructor]
        private ChannelEncoderSettingsOutputGroupOutputOutputSettingsMultiplexOutputSettings(Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsMultiplexOutputSettingsDestination destination)
        {
            Destination = destination;
        }
    }
}
