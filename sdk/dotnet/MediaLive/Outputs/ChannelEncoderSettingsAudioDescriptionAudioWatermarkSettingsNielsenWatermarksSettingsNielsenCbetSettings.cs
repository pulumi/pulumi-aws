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
    public sealed class ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsNielsenCbetSettings
    {
        public readonly string CbetCheckDigitString;
        /// <summary>
        /// Determines the method of CBET insertion mode when prior encoding is detected on the same layer.
        /// </summary>
        public readonly string CbetStepaside;
        /// <summary>
        /// CBET source ID to use in the watermark.
        /// </summary>
        public readonly string Csid;

        [OutputConstructor]
        private ChannelEncoderSettingsAudioDescriptionAudioWatermarkSettingsNielsenWatermarksSettingsNielsenCbetSettings(
            string cbetCheckDigitString,

            string cbetStepaside,

            string csid)
        {
            CbetCheckDigitString = cbetCheckDigitString;
            CbetStepaside = cbetStepaside;
            Csid = csid;
        }
    }
}
