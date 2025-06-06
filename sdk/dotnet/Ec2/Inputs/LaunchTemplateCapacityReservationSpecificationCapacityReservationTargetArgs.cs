// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class LaunchTemplateCapacityReservationSpecificationCapacityReservationTargetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the Capacity Reservation in which to run the instance.
        /// </summary>
        [Input("capacityReservationId")]
        public Input<string>? CapacityReservationId { get; set; }

        /// <summary>
        /// The ARN of the Capacity Reservation resource group in which to run the instance.
        /// </summary>
        [Input("capacityReservationResourceGroupArn")]
        public Input<string>? CapacityReservationResourceGroupArn { get; set; }

        public LaunchTemplateCapacityReservationSpecificationCapacityReservationTargetArgs()
        {
        }
        public static new LaunchTemplateCapacityReservationSpecificationCapacityReservationTargetArgs Empty => new LaunchTemplateCapacityReservationSpecificationCapacityReservationTargetArgs();
    }
}
