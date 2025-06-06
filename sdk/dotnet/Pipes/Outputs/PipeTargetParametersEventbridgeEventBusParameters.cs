// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Outputs
{

    [OutputType]
    public sealed class PipeTargetParametersEventbridgeEventBusParameters
    {
        /// <summary>
        /// A free-form string, with a maximum of 128 characters, used to decide what fields to expect in the event detail.
        /// </summary>
        public readonly string? DetailType;
        /// <summary>
        /// The URL subdomain of the endpoint. For example, if the URL for Endpoint is https://abcde.veo.endpoints.event.amazonaws.com, then the EndpointId is abcde.veo.
        /// </summary>
        public readonly string? EndpointId;
        /// <summary>
        /// List of AWS resources, identified by Amazon Resource Name (ARN), which the event primarily concerns. Any number, including zero, may be present.
        /// </summary>
        public readonly ImmutableArray<string> Resources;
        /// <summary>
        /// Source resource of the pipe. This field typically requires an ARN (Amazon Resource Name). However, when using a self-managed Kafka cluster, you should use a different format. Instead of an ARN, use 'smk://' followed by the bootstrap server's address.
        /// </summary>
        public readonly string? Source;
        /// <summary>
        /// The time stamp of the event, per RFC3339. If no time stamp is provided, the time stamp of the PutEvents call is used. This is the JSON path to the field in the event e.g. $.detail.timestamp
        /// </summary>
        public readonly string? Time;

        [OutputConstructor]
        private PipeTargetParametersEventbridgeEventBusParameters(
            string? detailType,

            string? endpointId,

            ImmutableArray<string> resources,

            string? source,

            string? time)
        {
            DetailType = detailType;
            EndpointId = endpointId;
            Resources = resources;
            Source = source;
            Time = time;
        }
    }
}
