// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFabric.Outputs
{

    [OutputType]
    public sealed class IngestionDestinationDestinationConfigurationAuditLog
    {
        /// <summary>
        /// Contains information about an audit log destination. Only one destination (Firehose Stream) or (S3 Bucket) can be specified.
        /// </summary>
        public readonly Outputs.IngestionDestinationDestinationConfigurationAuditLogDestination? Destination;

        [OutputConstructor]
        private IngestionDestinationDestinationConfigurationAuditLog(Outputs.IngestionDestinationDestinationConfigurationAuditLogDestination? destination)
        {
            Destination = destination;
        }
    }
}
