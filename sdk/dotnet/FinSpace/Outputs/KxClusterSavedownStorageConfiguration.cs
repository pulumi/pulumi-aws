// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace.Outputs
{

    [OutputType]
    public sealed class KxClusterSavedownStorageConfiguration
    {
        /// <summary>
        /// Size of temporary storage in gigabytes. Must be between 10 and 16000.
        /// </summary>
        public readonly int? Size;
        /// <summary>
        /// Type of writeable storage space for temporarily storing your savedown data. The valid values are:
        /// * SDS01 - This type represents 3000 IOPS and io2 ebs volume type.
        /// </summary>
        public readonly string? Type;
        /// <summary>
        /// The name of the kdb volume that you want to use as writeable save-down storage for clusters.
        /// </summary>
        public readonly string? VolumeName;

        [OutputConstructor]
        private KxClusterSavedownStorageConfiguration(
            int? size,

            string? type,

            string? volumeName)
        {
            Size = size;
            Type = type;
            VolumeName = volumeName;
        }
    }
}
