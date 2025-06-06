// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Inputs
{

    public sealed class ApplicationApplicationConfigurationVpcConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("securityGroupIds", required: true)]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// The Security Group IDs used by the VPC configuration.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnetIds", required: true)]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// The Subnet IDs used by the VPC configuration.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        [Input("vpcConfigurationId")]
        public Input<string>? VpcConfigurationId { get; set; }

        [Input("vpcId")]
        public Input<string>? VpcId { get; set; }

        public ApplicationApplicationConfigurationVpcConfigurationGetArgs()
        {
        }
        public static new ApplicationApplicationConfigurationVpcConfigurationGetArgs Empty => new ApplicationApplicationConfigurationVpcConfigurationGetArgs();
    }
}
