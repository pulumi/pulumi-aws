// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MskConnect.Inputs
{

    public sealed class ConnectorKafkaClusterGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Apache Kafka cluster to which the connector is connected. See `apache_kafka_cluster` Block for details.
        /// </summary>
        [Input("apacheKafkaCluster", required: true)]
        public Input<Inputs.ConnectorKafkaClusterApacheKafkaClusterGetArgs> ApacheKafkaCluster { get; set; } = null!;

        public ConnectorKafkaClusterGetArgs()
        {
        }
        public static new ConnectorKafkaClusterGetArgs Empty => new ConnectorKafkaClusterGetArgs();
    }
}
