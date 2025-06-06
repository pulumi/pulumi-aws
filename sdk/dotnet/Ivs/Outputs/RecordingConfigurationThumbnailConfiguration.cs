// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ivs.Outputs
{

    [OutputType]
    public sealed class RecordingConfigurationThumbnailConfiguration
    {
        /// <summary>
        /// Thumbnail recording mode. Valid values: `DISABLED`, `INTERVAL`.
        /// </summary>
        public readonly string? RecordingMode;
        /// <summary>
        /// The targeted thumbnail-generation interval in seconds.
        /// </summary>
        public readonly int? TargetIntervalSeconds;

        [OutputConstructor]
        private RecordingConfigurationThumbnailConfiguration(
            string? recordingMode,

            int? targetIntervalSeconds)
        {
            RecordingMode = recordingMode;
            TargetIntervalSeconds = targetIntervalSeconds;
        }
    }
}
