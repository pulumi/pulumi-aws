// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class WorkforceWorkforceVpcConfigArgs : global::Pulumi.ResourceArgs
    {
        [Input("securityGroupIds")]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// The VPC security group IDs. The security groups must be for the same VPC as specified in the subnet.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnets")]
        private InputList<string>? _subnets;

        /// <summary>
        /// The ID of the subnets in the VPC that you want to connect.
        /// </summary>
        public InputList<string> Subnets
        {
            get => _subnets ?? (_subnets = new InputList<string>());
            set => _subnets = value;
        }

        /// <summary>
        /// The IDs for the VPC service endpoints of your VPC workforce.
        /// </summary>
        [Input("vpcEndpointId")]
        public Input<string>? VpcEndpointId { get; set; }

        /// <summary>
        /// The ID of the VPC that the workforce uses for communication.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public WorkforceWorkforceVpcConfigArgs()
        {
        }
        public static new WorkforceWorkforceVpcConfigArgs Empty => new WorkforceWorkforceVpcConfigArgs();
    }
}
