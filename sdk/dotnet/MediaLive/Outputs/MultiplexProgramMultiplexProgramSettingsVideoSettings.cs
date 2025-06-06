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
    public sealed class MultiplexProgramMultiplexProgramSettingsVideoSettings
    {
        /// <summary>
        /// Constant bitrate value.
        /// </summary>
        public readonly int? ConstantBitrate;
        /// <summary>
        /// Statmux settings. See Statmux Settings for more details.
        /// </summary>
        public readonly Outputs.MultiplexProgramMultiplexProgramSettingsVideoSettingsStatmuxSettings? StatmuxSettings;

        [OutputConstructor]
        private MultiplexProgramMultiplexProgramSettingsVideoSettings(
            int? constantBitrate,

            Outputs.MultiplexProgramMultiplexProgramSettingsVideoSettingsStatmuxSettings? statmuxSettings)
        {
            ConstantBitrate = constantBitrate;
            StatmuxSettings = statmuxSettings;
        }
    }
}
