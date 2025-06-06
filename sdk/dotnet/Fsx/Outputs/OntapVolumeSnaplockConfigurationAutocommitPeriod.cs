// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fsx.Outputs
{

    [OutputType]
    public sealed class OntapVolumeSnaplockConfigurationAutocommitPeriod
    {
        /// <summary>
        /// The type of time for the autocommit period of a file in an FSx for ONTAP SnapLock volume. Setting this value to `NONE` disables autocommit. Valid values: `MINUTES`, `HOURS`, `DAYS`, `MONTHS`, `YEARS`, `NONE`.
        /// </summary>
        public readonly string? Type;
        /// <summary>
        /// The amount of time for the autocommit period of a file in an FSx for ONTAP SnapLock volume.
        /// </summary>
        public readonly int? Value;

        [OutputConstructor]
        private OntapVolumeSnaplockConfigurationAutocommitPeriod(
            string? type,

            int? value)
        {
            Type = type;
            Value = value;
        }
    }
}
