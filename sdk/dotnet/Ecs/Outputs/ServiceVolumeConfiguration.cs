// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Outputs
{

    [OutputType]
    public sealed class ServiceVolumeConfiguration
    {
        /// <summary>
        /// Configuration for the Amazon EBS volume that Amazon ECS creates and manages on your behalf. See below.
        /// </summary>
        public readonly Outputs.ServiceVolumeConfigurationManagedEbsVolume ManagedEbsVolume;
        /// <summary>
        /// Name of the volume.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private ServiceVolumeConfiguration(
            Outputs.ServiceVolumeConfigurationManagedEbsVolume managedEbsVolume,

            string name)
        {
            ManagedEbsVolume = managedEbsVolume;
            Name = name;
        }
    }
}
