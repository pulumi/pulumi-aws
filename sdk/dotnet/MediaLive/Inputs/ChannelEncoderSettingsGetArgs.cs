// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("audioDescriptions")]
        private InputList<Inputs.ChannelEncoderSettingsAudioDescriptionGetArgs>? _audioDescriptions;

        /// <summary>
        /// Audio descriptions for the channel. See Audio Descriptions for more details.
        /// </summary>
        public InputList<Inputs.ChannelEncoderSettingsAudioDescriptionGetArgs> AudioDescriptions
        {
            get => _audioDescriptions ?? (_audioDescriptions = new InputList<Inputs.ChannelEncoderSettingsAudioDescriptionGetArgs>());
            set => _audioDescriptions = value;
        }

        /// <summary>
        /// Settings for ad avail blanking. See Avail Blanking for more details.
        /// </summary>
        [Input("availBlanking")]
        public Input<Inputs.ChannelEncoderSettingsAvailBlankingGetArgs>? AvailBlanking { get; set; }

        [Input("captionDescriptions")]
        private InputList<Inputs.ChannelEncoderSettingsCaptionDescriptionGetArgs>? _captionDescriptions;

        /// <summary>
        /// Caption Descriptions. See Caption Descriptions for more details.
        /// </summary>
        public InputList<Inputs.ChannelEncoderSettingsCaptionDescriptionGetArgs> CaptionDescriptions
        {
            get => _captionDescriptions ?? (_captionDescriptions = new InputList<Inputs.ChannelEncoderSettingsCaptionDescriptionGetArgs>());
            set => _captionDescriptions = value;
        }

        /// <summary>
        /// Configuration settings that apply to the event as a whole. See Global Configuration for more details.
        /// </summary>
        [Input("globalConfiguration")]
        public Input<Inputs.ChannelEncoderSettingsGlobalConfigurationGetArgs>? GlobalConfiguration { get; set; }

        /// <summary>
        /// Settings for motion graphics. See Motion Graphics Configuration for more details.
        /// </summary>
        [Input("motionGraphicsConfiguration")]
        public Input<Inputs.ChannelEncoderSettingsMotionGraphicsConfigurationGetArgs>? MotionGraphicsConfiguration { get; set; }

        /// <summary>
        /// Nielsen configuration settings. See Nielsen Configuration for more details.
        /// </summary>
        [Input("nielsenConfiguration")]
        public Input<Inputs.ChannelEncoderSettingsNielsenConfigurationGetArgs>? NielsenConfiguration { get; set; }

        [Input("outputGroups", required: true)]
        private InputList<Inputs.ChannelEncoderSettingsOutputGroupGetArgs>? _outputGroups;

        /// <summary>
        /// Output groups for the channel. See Output Groups for more details.
        /// </summary>
        public InputList<Inputs.ChannelEncoderSettingsOutputGroupGetArgs> OutputGroups
        {
            get => _outputGroups ?? (_outputGroups = new InputList<Inputs.ChannelEncoderSettingsOutputGroupGetArgs>());
            set => _outputGroups = value;
        }

        /// <summary>
        /// Contains settings used to acquire and adjust timecode information from inputs. See Timecode Config for more details.
        /// </summary>
        [Input("timecodeConfig", required: true)]
        public Input<Inputs.ChannelEncoderSettingsTimecodeConfigGetArgs> TimecodeConfig { get; set; } = null!;

        [Input("videoDescriptions")]
        private InputList<Inputs.ChannelEncoderSettingsVideoDescriptionGetArgs>? _videoDescriptions;

        /// <summary>
        /// Video Descriptions. See Video Descriptions for more details.
        /// </summary>
        public InputList<Inputs.ChannelEncoderSettingsVideoDescriptionGetArgs> VideoDescriptions
        {
            get => _videoDescriptions ?? (_videoDescriptions = new InputList<Inputs.ChannelEncoderSettingsVideoDescriptionGetArgs>());
            set => _videoDescriptions = value;
        }

        public ChannelEncoderSettingsGetArgs()
        {
        }
        public static new ChannelEncoderSettingsGetArgs Empty => new ChannelEncoderSettingsGetArgs();
    }
}
