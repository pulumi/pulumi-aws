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
    public sealed class ChannelEncoderSettingsOutputGroupOutputGroupSettingsRtmpGroupSettings
    {
        /// <summary>
        /// The ad marker type for this output group.
        /// </summary>
        public readonly ImmutableArray<string> AdMarkers;
        /// <summary>
        /// Authentication scheme to use when connecting with CDN.
        /// </summary>
        public readonly string? AuthenticationScheme;
        /// <summary>
        /// Controls behavior when content cache fills up.
        /// </summary>
        public readonly string? CacheFullBehavior;
        /// <summary>
        /// Cache length in seconds, is used to calculate buffer size.
        /// </summary>
        public readonly int? CacheLength;
        /// <summary>
        /// Controls the types of data that passes to onCaptionInfo outputs.
        /// </summary>
        public readonly string? CaptionData;
        /// <summary>
        /// Controls the behavior of the RTMP group if input becomes unavailable.
        /// </summary>
        public readonly string? InputLossAction;
        /// <summary>
        /// Number of seconds to wait until a restart is initiated.
        /// </summary>
        public readonly int? RestartDelay;

        [OutputConstructor]
        private ChannelEncoderSettingsOutputGroupOutputGroupSettingsRtmpGroupSettings(
            ImmutableArray<string> adMarkers,

            string? authenticationScheme,

            string? cacheFullBehavior,

            int? cacheLength,

            string? captionData,

            string? inputLossAction,

            int? restartDelay)
        {
            AdMarkers = adMarkers;
            AuthenticationScheme = authenticationScheme;
            CacheFullBehavior = cacheFullBehavior;
            CacheLength = cacheLength;
            CaptionData = captionData;
            InputLossAction = inputLossAction;
            RestartDelay = restartDelay;
        }
    }
}
