// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Outputs
{

    [OutputType]
    public sealed class EventEndpointRoutingConfigFailoverConfigPrimary
    {
        /// <summary>
        /// The ARN of the health check used by the endpoint to determine whether failover is triggered.
        /// </summary>
        public readonly string? HealthCheck;

        [OutputConstructor]
        private EventEndpointRoutingConfigFailoverConfigPrimary(string? healthCheck)
        {
            HealthCheck = healthCheck;
        }
    }
}
