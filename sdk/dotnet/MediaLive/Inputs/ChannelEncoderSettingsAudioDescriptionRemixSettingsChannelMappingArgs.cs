// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingArgs : global::Pulumi.ResourceArgs
    {
        [Input("inputChannelLevels", required: true)]
        private InputList<Inputs.ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingInputChannelLevelArgs>? _inputChannelLevels;
        public InputList<Inputs.ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingInputChannelLevelArgs> InputChannelLevels
        {
            get => _inputChannelLevels ?? (_inputChannelLevels = new InputList<Inputs.ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingInputChannelLevelArgs>());
            set => _inputChannelLevels = value;
        }

        [Input("outputChannel", required: true)]
        public Input<int> OutputChannel { get; set; } = null!;

        public ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingArgs()
        {
        }
        public static new ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingArgs Empty => new ChannelEncoderSettingsAudioDescriptionRemixSettingsChannelMappingArgs();
    }
}
