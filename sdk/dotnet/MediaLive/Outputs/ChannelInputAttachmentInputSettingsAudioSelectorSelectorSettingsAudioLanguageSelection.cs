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
    public sealed class ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioLanguageSelection
    {
        /// <summary>
        /// Selects a specific three-letter language code from within an audio source.
        /// </summary>
        public readonly string LanguageCode;
        /// <summary>
        /// When set to “strict”, the transport stream demux strictly identifies audio streams by their language descriptor. If a PMT update occurs such that an audio stream matching the initially selected language is no longer present then mute will be encoded until the language returns. If “loose”, then on a PMT update the demux will choose another audio stream in the program with the same stream type if it can’t find one with the same language.
        /// </summary>
        public readonly string? LanguageSelectionPolicy;

        [OutputConstructor]
        private ChannelInputAttachmentInputSettingsAudioSelectorSelectorSettingsAudioLanguageSelection(
            string languageCode,

            string? languageSelectionPolicy)
        {
            LanguageCode = languageCode;
            LanguageSelectionPolicy = languageSelectionPolicy;
        }
    }
}
