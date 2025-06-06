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
    public sealed class ContainerRecipeInstanceConfiguration
    {
        /// <summary>
        /// Configuration block(s) with block device mappings for the container recipe. Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.ContainerRecipeInstanceConfigurationBlockDeviceMapping> BlockDeviceMappings;
        /// <summary>
        /// The AMI ID to use as the base image for a container build and test instance. If not specified, Image Builder will use the appropriate ECS-optimized AMI as a base image.
        /// </summary>
        public readonly string? Image;

        [OutputConstructor]
        private ContainerRecipeInstanceConfiguration(
            ImmutableArray<Outputs.ContainerRecipeInstanceConfigurationBlockDeviceMapping> blockDeviceMappings,

            string? image)
        {
            BlockDeviceMappings = blockDeviceMappings;
            Image = image;
        }
    }
}
