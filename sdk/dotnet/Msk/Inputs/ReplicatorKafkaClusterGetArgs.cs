// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Msk.Inputs
{

    public sealed class ReplicatorKafkaClusterGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Details of an Amazon MSK cluster.
        /// </summary>
        [Input("amazonMskCluster", required: true)]
        public Input<Inputs.ReplicatorKafkaClusterAmazonMskClusterGetArgs> AmazonMskCluster { get; set; } = null!;

        /// <summary>
        /// Details of an Amazon VPC which has network connectivity to the Apache Kafka cluster.
        /// </summary>
        [Input("vpcConfig", required: true)]
        public Input<Inputs.ReplicatorKafkaClusterVpcConfigGetArgs> VpcConfig { get; set; } = null!;

        public ReplicatorKafkaClusterGetArgs()
        {
        }
        public static new ReplicatorKafkaClusterGetArgs Empty => new ReplicatorKafkaClusterGetArgs();
    }
}
