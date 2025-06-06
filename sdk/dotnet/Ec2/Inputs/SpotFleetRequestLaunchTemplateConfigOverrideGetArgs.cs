// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class SpotFleetRequestLaunchTemplateConfigOverrideGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The availability zone in which to place the request.
        /// </summary>
        [Input("availabilityZone")]
        public Input<string>? AvailabilityZone { get; set; }

        /// <summary>
        /// The instance requirements. See below.
        /// </summary>
        [Input("instanceRequirements")]
        public Input<Inputs.SpotFleetRequestLaunchTemplateConfigOverrideInstanceRequirementsGetArgs>? InstanceRequirements { get; set; }

        /// <summary>
        /// The type of instance to request.
        /// </summary>
        [Input("instanceType")]
        public Input<string>? InstanceType { get; set; }

        /// <summary>
        /// The priority for the launch template override. The lower the number, the higher the priority. If no number is set, the launch template override has the lowest priority.
        /// </summary>
        [Input("priority")]
        public Input<double>? Priority { get; set; }

        /// <summary>
        /// The maximum spot bid for this override request.
        /// </summary>
        [Input("spotPrice")]
        public Input<string>? SpotPrice { get; set; }

        /// <summary>
        /// The subnet in which to launch the requested instance.
        /// </summary>
        [Input("subnetId")]
        public Input<string>? SubnetId { get; set; }

        /// <summary>
        /// The capacity added to the fleet by a fulfilled request.
        /// </summary>
        [Input("weightedCapacity")]
        public Input<double>? WeightedCapacity { get; set; }

        public SpotFleetRequestLaunchTemplateConfigOverrideGetArgs()
        {
        }
        public static new SpotFleetRequestLaunchTemplateConfigOverrideGetArgs Empty => new SpotFleetRequestLaunchTemplateConfigOverrideGetArgs();
    }
}
