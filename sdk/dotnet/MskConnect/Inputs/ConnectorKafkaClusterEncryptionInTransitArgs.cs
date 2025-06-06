// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MskConnect.Inputs
{

    public sealed class ConnectorKafkaClusterEncryptionInTransitArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The type of encryption in transit to the Apache Kafka cluster. Valid values: `PLAINTEXT`, `TLS`. The default values is `PLAINTEXT`.
        /// </summary>
        [Input("encryptionType")]
        public Input<string>? EncryptionType { get; set; }

        public ConnectorKafkaClusterEncryptionInTransitArgs()
        {
        }
        public static new ConnectorKafkaClusterEncryptionInTransitArgs Empty => new ConnectorKafkaClusterEncryptionInTransitArgs();
    }
}
