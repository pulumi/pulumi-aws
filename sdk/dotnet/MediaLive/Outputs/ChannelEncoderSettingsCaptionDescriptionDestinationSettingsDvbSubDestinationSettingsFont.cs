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
    public sealed class ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFont
    {
        /// <summary>
        /// Key used to extract the password from EC2 Parameter store.
        /// </summary>
        public readonly string? PasswordParam;
        /// <summary>
        /// Path to a file accessible to the live stream.
        /// </summary>
        public readonly string Uri;
        /// <summary>
        /// Username to be used.
        /// </summary>
        public readonly string? Username;

        [OutputConstructor]
        private ChannelEncoderSettingsCaptionDescriptionDestinationSettingsDvbSubDestinationSettingsFont(
            string? passwordParam,

            string uri,

            string? username)
        {
            PasswordParam = passwordParam;
            Uri = uri;
            Username = username;
        }
    }
}
