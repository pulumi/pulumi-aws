// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsDestinationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Reference ID for the destination.
        /// </summary>
        [Input("destinationRefId", required: true)]
        public Input<string> DestinationRefId { get; set; } = null!;

        public ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsDestinationArgs()
        {
        }
        public static new ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsDestinationArgs Empty => new ChannelEncoderSettingsOutputGroupOutputGroupSettingsHlsGroupSettingsDestinationArgs();
    }
}
