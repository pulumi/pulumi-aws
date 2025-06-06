// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Inputs
{

    public sealed class GroupMixedInstancesPolicyInstancesDistributionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Strategy to use when launching on-demand instances. Valid values: `prioritized`, `lowest-price`. Default: `prioritized`.
        /// </summary>
        [Input("onDemandAllocationStrategy")]
        public Input<string>? OnDemandAllocationStrategy { get; set; }

        /// <summary>
        /// Absolute minimum amount of desired capacity that must be fulfilled by on-demand instances. Default: `0`.
        /// </summary>
        [Input("onDemandBaseCapacity")]
        public Input<int>? OnDemandBaseCapacity { get; set; }

        /// <summary>
        /// Percentage split between on-demand and Spot instances above the base on-demand capacity. Default: `100`.
        /// </summary>
        [Input("onDemandPercentageAboveBaseCapacity")]
        public Input<int>? OnDemandPercentageAboveBaseCapacity { get; set; }

        /// <summary>
        /// How to allocate capacity across the Spot pools. Valid values: `lowest-price`, `capacity-optimized`, `capacity-optimized-prioritized`, and `price-capacity-optimized`. Default: `lowest-price`.
        /// </summary>
        [Input("spotAllocationStrategy")]
        public Input<string>? SpotAllocationStrategy { get; set; }

        /// <summary>
        /// Number of Spot pools per availability zone to allocate capacity. EC2 Auto Scaling selects the cheapest Spot pools and evenly allocates Spot capacity across the number of Spot pools that you specify. Only available with `spot_allocation_strategy` set to `lowest-price`. Otherwise it must be set to `0`, if it has been defined before. Default: `2`.
        /// </summary>
        [Input("spotInstancePools")]
        public Input<int>? SpotInstancePools { get; set; }

        /// <summary>
        /// Maximum price per unit hour that the user is willing to pay for the Spot instances. Default: an empty string which means the on-demand price.
        /// </summary>
        [Input("spotMaxPrice")]
        public Input<string>? SpotMaxPrice { get; set; }

        public GroupMixedInstancesPolicyInstancesDistributionArgs()
        {
        }
        public static new GroupMixedInstancesPolicyInstancesDistributionArgs Empty => new GroupMixedInstancesPolicyInstancesDistributionArgs();
    }
}
