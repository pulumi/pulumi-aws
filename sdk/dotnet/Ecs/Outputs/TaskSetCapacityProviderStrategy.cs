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
    public sealed class TaskSetCapacityProviderStrategy
    {
        /// <summary>
        /// The number of tasks, at a minimum, to run on the specified capacity provider. Only one capacity provider in a capacity provider strategy can have a base defined.
        /// </summary>
        public readonly int? Base;
        /// <summary>
        /// The short name or full Amazon Resource Name (ARN) of the capacity provider.
        /// </summary>
        public readonly string CapacityProvider;
        /// <summary>
        /// The relative percentage of the total number of launched tasks that should use the specified capacity provider.
        /// </summary>
        public readonly int Weight;

        [OutputConstructor]
        private TaskSetCapacityProviderStrategy(
            int? @base,

            string capacityProvider,

            int weight)
        {
            Base = @base;
            CapacityProvider = capacityProvider;
            Weight = weight;
        }
    }
}
