// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MskConnect.Inputs
{

    public sealed class ConnectorCapacityGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Information about the auto scaling parameters for the connector. See `autoscaling` Block for details.
        /// </summary>
        [Input("autoscaling")]
        public Input<Inputs.ConnectorCapacityAutoscalingGetArgs>? Autoscaling { get; set; }

        /// <summary>
        /// Details about a fixed capacity allocated to a connector. See `provisioned_capacity` Block for details.
        /// </summary>
        [Input("provisionedCapacity")]
        public Input<Inputs.ConnectorCapacityProvisionedCapacityGetArgs>? ProvisionedCapacity { get; set; }

        public ConnectorCapacityGetArgs()
        {
        }
        public static new ConnectorCapacityGetArgs Empty => new ConnectorCapacityGetArgs();
    }
}
