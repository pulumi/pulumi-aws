// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class SpotFleetRequestLaunchSpecificationRootBlockDevice
    {
        public readonly bool? DeleteOnTermination;
        public readonly bool? Encrypted;
        public readonly int? Iops;
        public readonly string? KmsKeyId;
        public readonly int? Throughput;
        public readonly int? VolumeSize;
        public readonly string? VolumeType;

        [OutputConstructor]
        private SpotFleetRequestLaunchSpecificationRootBlockDevice(
            bool? deleteOnTermination,

            bool? encrypted,

            int? iops,

            string? kmsKeyId,

            int? throughput,

            int? volumeSize,

            string? volumeType)
        {
            DeleteOnTermination = deleteOnTermination;
            Encrypted = encrypted;
            Iops = iops;
            KmsKeyId = kmsKeyId;
            Throughput = throughput;
            VolumeSize = volumeSize;
            VolumeType = volumeType;
        }
    }
}
