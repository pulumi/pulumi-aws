// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GlobalAccelerator.Inputs
{

    public sealed class EndpointGroupEndpointConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An ARN of an exposed cross-account attachment. See the [AWS documentation](https://docs.aws.amazon.com/global-accelerator/latest/dg/cross-account-resources.html) for more details.
        /// </summary>
        [Input("attachmentArn")]
        public Input<string>? AttachmentArn { get; set; }

        /// <summary>
        /// Indicates whether client IP address preservation is enabled for an Application Load Balancer endpoint. See the [AWS documentation](https://docs.aws.amazon.com/global-accelerator/latest/dg/preserve-client-ip-address.html) for more details. The default value is `false`.
        /// **Note:** When client IP address preservation is enabled, the Global Accelerator service creates an EC2 Security Group in the VPC named `GlobalAccelerator` that must be deleted (potentially outside of the provider) before the VPC will successfully delete. If this EC2 Security Group is not deleted, the provider will retry the VPC deletion for a few minutes before reporting a `DependencyViolation` error. This cannot be resolved by re-running the provider.
        /// </summary>
        [Input("clientIpPreservationEnabled")]
        public Input<bool>? ClientIpPreservationEnabled { get; set; }

        /// <summary>
        /// An ID for the endpoint. If the endpoint is a Network Load Balancer or Application Load Balancer, this is the Amazon Resource Name (ARN) of the resource. If the endpoint is an Elastic IP address, this is the Elastic IP address allocation ID.
        /// </summary>
        [Input("endpointId")]
        public Input<string>? EndpointId { get; set; }

        /// <summary>
        /// The weight associated with the endpoint. When you add weights to endpoints, you configure AWS Global Accelerator to route traffic based on proportions that you specify.
        /// </summary>
        [Input("weight")]
        public Input<int>? Weight { get; set; }

        public EndpointGroupEndpointConfigurationArgs()
        {
        }
        public static new EndpointGroupEndpointConfigurationArgs Empty => new EndpointGroupEndpointConfigurationArgs();
    }
}
