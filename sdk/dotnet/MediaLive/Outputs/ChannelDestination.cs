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
    public sealed class ChannelDestination
    {
        /// <summary>
        /// User-specified id. Ths is used in an output group or an output.
        /// </summary>
        public readonly string Id;
        /// <summary>
        /// Destination settings for a MediaPackage output; one destination for both encoders. See Media Package Settings for more details.
        /// </summary>
        public readonly ImmutableArray<Outputs.ChannelDestinationMediaPackageSetting> MediaPackageSettings;
        /// <summary>
        /// Destination settings for a Multiplex output; one destination for both encoders. See Multiplex Settings for more details.
        /// </summary>
        public readonly Outputs.ChannelDestinationMultiplexSettings? MultiplexSettings;
        /// <summary>
        /// Destination settings for a standard output; one destination for each redundant encoder. See Settings for more details.
        /// </summary>
        public readonly ImmutableArray<Outputs.ChannelDestinationSetting> Settings;

        [OutputConstructor]
        private ChannelDestination(
            string id,

            ImmutableArray<Outputs.ChannelDestinationMediaPackageSetting> mediaPackageSettings,

            Outputs.ChannelDestinationMultiplexSettings? multiplexSettings,

            ImmutableArray<Outputs.ChannelDestinationSetting> settings)
        {
            Id = id;
            MediaPackageSettings = mediaPackageSettings;
            MultiplexSettings = multiplexSettings;
            Settings = settings;
        }
    }
}
