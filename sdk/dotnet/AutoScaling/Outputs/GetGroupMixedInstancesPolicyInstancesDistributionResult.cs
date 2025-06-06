// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Outputs
{

    [OutputType]
    public sealed class GetGroupMixedInstancesPolicyInstancesDistributionResult
    {
        /// <summary>
        /// Strategy used when launching on-demand instances.
        /// </summary>
        public readonly string OnDemandAllocationStrategy;
        /// <summary>
        /// Absolute minimum amount of desired capacity that must be fulfilled by on-demand instances.
        /// </summary>
        public readonly int OnDemandBaseCapacity;
        public readonly int OnDemandPercentageAboveBaseCapacity;
        /// <summary>
        /// Strategy used when launching Spot instances.
        /// </summary>
        public readonly string SpotAllocationStrategy;
        /// <summary>
        /// Number of Spot pools per availability zone to allocate capacity.
        /// </summary>
        public readonly int SpotInstancePools;
        /// <summary>
        /// Maximum price per unit hour that the user is willing to pay for the Spot instances.
        /// </summary>
        public readonly string SpotMaxPrice;

        [OutputConstructor]
        private GetGroupMixedInstancesPolicyInstancesDistributionResult(
            string onDemandAllocationStrategy,

            int onDemandBaseCapacity,

            int onDemandPercentageAboveBaseCapacity,

            string spotAllocationStrategy,

            int spotInstancePools,

            string spotMaxPrice)
        {
            OnDemandAllocationStrategy = onDemandAllocationStrategy;
            OnDemandBaseCapacity = onDemandBaseCapacity;
            OnDemandPercentageAboveBaseCapacity = onDemandPercentageAboveBaseCapacity;
            SpotAllocationStrategy = spotAllocationStrategy;
            SpotInstancePools = spotInstancePools;
            SpotMaxPrice = spotMaxPrice;
        }
    }
}
