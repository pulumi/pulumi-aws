// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Outputs
{

    [OutputType]
    public sealed class ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettings
    {
        /// <summary>
        /// UDP output buffering in milliseconds.
        /// </summary>
        public readonly int? BufferMsec;
        /// <summary>
        /// UDP container settings. See Container Settings for more details.
        /// </summary>
        public readonly Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsContainerSettings ContainerSettings;
        /// <summary>
        /// Destination address and port number for RTP or UDP packets. See Destination for more details.
        /// </summary>
        public readonly Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsDestination Destination;
        public readonly Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsFecOutputSettings? FecOutputSettings;

        [OutputConstructor]
        private ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettings(
            int? bufferMsec,

            Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsContainerSettings containerSettings,

            Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsDestination destination,

            Outputs.ChannelEncoderSettingsOutputGroupOutputOutputSettingsUdpOutputSettingsFecOutputSettings? fecOutputSettings)
        {
            BufferMsec = bufferMsec;
            ContainerSettings = containerSettings;
            Destination = destination;
            FecOutputSettings = fecOutputSettings;
        }
    }
}
