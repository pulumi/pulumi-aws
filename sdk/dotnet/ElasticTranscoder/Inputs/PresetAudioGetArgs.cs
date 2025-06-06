// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElasticTranscoder.Inputs
{

    public sealed class PresetAudioGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The method of organizing audio channels and tracks. Use Audio:Channels to specify the number of channels in your output, and Audio:AudioPackingMode to specify the number of tracks and their relation to the channels. If you do not specify an Audio:AudioPackingMode, Elastic Transcoder uses SingleTrack.
        /// </summary>
        [Input("audioPackingMode")]
        public Input<string>? AudioPackingMode { get; set; }

        /// <summary>
        /// The bit rate of the audio stream in the output file, in kilobits/second. Enter an integer between 64 and 320, inclusive.
        /// </summary>
        [Input("bitRate")]
        public Input<string>? BitRate { get; set; }

        /// <summary>
        /// The number of audio channels in the output file
        /// </summary>
        [Input("channels")]
        public Input<string>? Channels { get; set; }

        /// <summary>
        /// The audio codec for the output file. Valid values are `AAC`, `flac`, `mp2`, `mp3`, `pcm`, and `vorbis`.
        /// </summary>
        [Input("codec")]
        public Input<string>? Codec { get; set; }

        /// <summary>
        /// The sample rate of the audio stream in the output file, in hertz. Valid values are: `auto`, `22050`, `32000`, `44100`, `48000`, `96000`
        /// </summary>
        [Input("sampleRate")]
        public Input<string>? SampleRate { get; set; }

        public PresetAudioGetArgs()
        {
        }
        public static new PresetAudioGetArgs Empty => new PresetAudioGetArgs();
    }
}
