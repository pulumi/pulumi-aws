// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Outputs
{

    [OutputType]
    public sealed class GetContainerRecipeInstanceConfigurationBlockDeviceMappingEbResult
    {
        /// <summary>
        /// Whether to delete the volume on termination. Defaults to unset, which is the value inherited from the parent image.
        /// </summary>
        public readonly bool DeleteOnTermination;
        /// <summary>
        /// Whether to encrypt the volume. Defaults to unset, which is the value inherited from the parent image.
        /// </summary>
        public readonly bool Encrypted;
        /// <summary>
        /// Number of Input/Output (I/O) operations per second to provision for an `io1` or `io2` volume.
        /// </summary>
        public readonly int Iops;
        /// <summary>
        /// KMS key used to encrypt the container image.
        /// </summary>
        public readonly string KmsKeyId;
        /// <summary>
        /// Identifier of the EC2 Volume Snapshot.
        /// </summary>
        public readonly string SnapshotId;
        /// <summary>
        /// For GP3 volumes only. The throughput in MiB/s that the volume supports.
        /// </summary>
        public readonly int Throughput;
        /// <summary>
        /// Size of the volume, in GiB.
        /// </summary>
        public readonly int VolumeSize;
        /// <summary>
        /// Type of the volume. For example, `gp2` or `io2`.
        /// </summary>
        public readonly string VolumeType;

        [OutputConstructor]
        private GetContainerRecipeInstanceConfigurationBlockDeviceMappingEbResult(
            bool deleteOnTermination,

            bool encrypted,

            int iops,

            string kmsKeyId,

            string snapshotId,

            int throughput,

            int volumeSize,

            string volumeType)
        {
            DeleteOnTermination = deleteOnTermination;
            Encrypted = encrypted;
            Iops = iops;
            KmsKeyId = kmsKeyId;
            SnapshotId = snapshotId;
            Throughput = throughput;
            VolumeSize = volumeSize;
            VolumeType = volumeType;
        }
    }
}
