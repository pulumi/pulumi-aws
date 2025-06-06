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
    public sealed class ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings
    {
        /// <summary>
        /// If you will configure a WebVTT caption description that references this caption selector, use this field to provide the language to consider when translating the image-based source to text.
        /// </summary>
        public readonly string? OcrLanguage;
        /// <summary>
        /// When using DVB-Sub with Burn-In or SMPTE-TT, use this PID for the source content. Unused for DVB-Sub passthrough. All DVB-Sub content is passed through, regardless of selectors.
        /// </summary>
        public readonly int? Pid;

        [OutputConstructor]
        private ChannelInputAttachmentInputSettingsCaptionSelectorSelectorSettingsDvbSubSourceSettings(
            string? ocrLanguage,

            int? pid)
        {
            OcrLanguage = ocrLanguage;
            Pid = pid;
        }
    }
}
