// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Outputs
{

    [OutputType]
    public sealed class RouteSpecHttpRoute
    {
        /// <summary>
        /// Action to take if a match is determined.
        /// </summary>
        public readonly Outputs.RouteSpecHttpRouteAction Action;
        /// <summary>
        /// Criteria for determining an HTTP request match.
        /// </summary>
        public readonly Outputs.RouteSpecHttpRouteMatch Match;
        /// <summary>
        /// Retry policy.
        /// </summary>
        public readonly Outputs.RouteSpecHttpRouteRetryPolicy? RetryPolicy;
        /// <summary>
        /// Types of timeouts.
        /// </summary>
        public readonly Outputs.RouteSpecHttpRouteTimeout? Timeout;

        [OutputConstructor]
        private RouteSpecHttpRoute(
            Outputs.RouteSpecHttpRouteAction action,

            Outputs.RouteSpecHttpRouteMatch match,

            Outputs.RouteSpecHttpRouteRetryPolicy? retryPolicy,

            Outputs.RouteSpecHttpRouteTimeout? timeout)
        {
            Action = action;
            Match = match;
            RetryPolicy = retryPolicy;
            Timeout = timeout;
        }
    }
}
