// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lambda.Inputs
{

    public sealed class EventSourceMappingSelfManagedEventSourceArgs : global::Pulumi.ResourceArgs
    {
        [Input("endpoints", required: true)]
        private InputMap<string>? _endpoints;

        /// <summary>
        /// A map of endpoints for the self managed source.  For Kafka self-managed sources, the key should be `KAFKA_BOOTSTRAP_SERVERS` and the value should be a string with a comma separated list of broker endpoints.
        /// </summary>
        public InputMap<string> Endpoints
        {
            get => _endpoints ?? (_endpoints = new InputMap<string>());
            set => _endpoints = value;
        }

        public EventSourceMappingSelfManagedEventSourceArgs()
        {
        }
        public static new EventSourceMappingSelfManagedEventSourceArgs Empty => new EventSourceMappingSelfManagedEventSourceArgs();
    }
}
