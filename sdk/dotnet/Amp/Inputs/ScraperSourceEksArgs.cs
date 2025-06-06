// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Amp.Inputs
{

    public sealed class ScraperSourceEksArgs : global::Pulumi.ResourceArgs
    {
        [Input("clusterArn", required: true)]
        public Input<string> ClusterArn { get; set; } = null!;

        [Input("securityGroupIds")]
        private InputList<string>? _securityGroupIds;

        /// <summary>
        /// List of the security group IDs for the Amazon EKS cluster VPC configuration.
        /// </summary>
        public InputList<string> SecurityGroupIds
        {
            get => _securityGroupIds ?? (_securityGroupIds = new InputList<string>());
            set => _securityGroupIds = value;
        }

        [Input("subnetIds", required: true)]
        private InputList<string>? _subnetIds;

        /// <summary>
        /// List of subnet IDs. Must be in at least two different availability zones.
        /// </summary>
        public InputList<string> SubnetIds
        {
            get => _subnetIds ?? (_subnetIds = new InputList<string>());
            set => _subnetIds = value;
        }

        public ScraperSourceEksArgs()
        {
        }
        public static new ScraperSourceEksArgs Empty => new ScraperSourceEksArgs();
    }
}
