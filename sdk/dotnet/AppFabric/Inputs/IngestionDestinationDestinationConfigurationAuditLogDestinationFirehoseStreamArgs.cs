// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFabric.Inputs
{

    public sealed class IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs : global::Pulumi.ResourceArgs
    {
        [Input("streamName", required: true)]
        public Input<string> StreamName { get; set; } = null!;

        public IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs()
        {
        }
        public static new IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs Empty => new IngestionDestinationDestinationConfigurationAuditLogDestinationFirehoseStreamArgs();
    }
}
