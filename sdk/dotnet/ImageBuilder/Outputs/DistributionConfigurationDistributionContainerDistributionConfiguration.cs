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
    public sealed class DistributionConfigurationDistributionContainerDistributionConfiguration
    {
        /// <summary>
        /// Set of tags that are attached to the container distribution configuration.
        /// </summary>
        public readonly ImmutableArray<string> ContainerTags;
        /// <summary>
        /// Description of the container distribution configuration.
        /// </summary>
        public readonly string? Description;
        /// <summary>
        /// Configuration block with the destination repository for the container distribution configuration.
        /// </summary>
        public readonly Outputs.DistributionConfigurationDistributionContainerDistributionConfigurationTargetRepository TargetRepository;

        [OutputConstructor]
        private DistributionConfigurationDistributionContainerDistributionConfiguration(
            ImmutableArray<string> containerTags,

            string? description,

            Outputs.DistributionConfigurationDistributionContainerDistributionConfigurationTargetRepository targetRepository)
        {
            ContainerTags = containerTags;
            Description = description;
            TargetRepository = targetRepository;
        }
    }
}
