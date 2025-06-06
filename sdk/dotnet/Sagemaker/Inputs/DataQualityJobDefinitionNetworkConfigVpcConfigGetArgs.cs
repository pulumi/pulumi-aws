// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DataQualityJobDefinitionNetworkConfigVpcConfigGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("securityGroupIds", required: true)]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// The VPC security group IDs, in the form sg-xxxxxxxx. Specify the security groups for the VPC that is specified in the `subnets` field.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnets", required: true)]
        private InputList<string>? _subnets;

        /// <summary>
        /// The ID of the subnets in the VPC to which you want to connect your training job or model.
        /// </summary>
        public InputList<string> Subnets
        {
            get => _subnets ?? (_subnets = new InputList<string>());
            set => _subnets = value;
        }

        public DataQualityJobDefinitionNetworkConfigVpcConfigGetArgs()
        {
        }
        public static new DataQualityJobDefinitionNetworkConfigVpcConfigGetArgs Empty => new DataQualityJobDefinitionNetworkConfigVpcConfigGetArgs();
    }
}
