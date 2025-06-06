// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class RouteSpecHttpRouteGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Action to take if a match is determined.
        /// </summary>
        [Input("action", required: true)]
        public Input<Inputs.RouteSpecHttpRouteActionGetArgs> Action { get; set; } = null!;

        /// <summary>
        /// Criteria for determining an HTTP request match.
        /// </summary>
        [Input("match", required: true)]
        public Input<Inputs.RouteSpecHttpRouteMatchGetArgs> Match { get; set; } = null!;

        /// <summary>
        /// Retry policy.
        /// </summary>
        [Input("retryPolicy")]
        public Input<Inputs.RouteSpecHttpRouteRetryPolicyGetArgs>? RetryPolicy { get; set; }

        /// <summary>
        /// Types of timeouts.
        /// </summary>
        [Input("timeout")]
        public Input<Inputs.RouteSpecHttpRouteTimeoutGetArgs>? Timeout { get; set; }

        public RouteSpecHttpRouteGetArgs()
        {
        }
        public static new RouteSpecHttpRouteGetArgs Empty => new RouteSpecHttpRouteGetArgs();
    }
}
