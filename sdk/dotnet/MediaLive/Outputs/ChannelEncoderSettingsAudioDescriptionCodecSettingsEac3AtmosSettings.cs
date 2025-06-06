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
    public sealed class ChannelEncoderSettingsAudioDescriptionCodecSettingsEac3AtmosSettings
    {
        /// <summary>
        /// Average bitrate in bits/second.
        /// </summary>
        public readonly double? Bitrate;
        /// <summary>
        /// Dolby Digital Plus with Dolby Atmos coding mode.
        /// </summary>
        public readonly string? CodingMode;
        /// <summary>
        /// Sets the dialnorm for the output.
        /// </summary>
        public readonly double? Dialnorm;
        /// <summary>
        /// Sets the Dolby dynamic range compression profile.
        /// </summary>
        public readonly string? DrcLine;
        /// <summary>
        /// Sets the profile for heavy Dolby dynamic range compression.
        /// </summary>
        public readonly string? DrcRf;
        /// <summary>
        /// Height dimensional trim.
        /// </summary>
        public readonly double? HeightTrim;
        /// <summary>
        /// Surround dimensional trim.
        /// </summary>
        public readonly double? SurroundTrim;

        [OutputConstructor]
        private ChannelEncoderSettingsAudioDescriptionCodecSettingsEac3AtmosSettings(
            double? bitrate,

            string? codingMode,

            double? dialnorm,

            string? drcLine,

            string? drcRf,

            double? heightTrim,

            double? surroundTrim)
        {
            Bitrate = bitrate;
            CodingMode = codingMode;
            Dialnorm = dialnorm;
            DrcLine = drcLine;
            DrcRf = drcRf;
            HeightTrim = heightTrim;
            SurroundTrim = surroundTrim;
        }
    }
}
