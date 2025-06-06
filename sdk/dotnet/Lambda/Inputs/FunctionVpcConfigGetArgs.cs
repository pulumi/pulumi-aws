// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lambda.Inputs
{

    public sealed class FunctionVpcConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Allows outbound IPv6 traffic on VPC functions that are connected to dual-stack subnets. Default is `false`.
        /// </summary>
        [Input("ipv6AllowedForDualStack")]
        public Input<bool>? Ipv6AllowedForDualStack { get; set; }

        [Input("securityGroupIds", required: true)]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// List of security group IDs associated with the Lambda function.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnetIds", required: true)]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// List of subnet IDs associated with the Lambda function.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        /// <summary>
        /// ID of the VPC.
        /// </summary>
        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public FunctionVpcConfigGetArgs()
        {
        }
        public static new FunctionVpcConfigGetArgs Empty => new FunctionVpcConfigGetArgs();
    }
}
