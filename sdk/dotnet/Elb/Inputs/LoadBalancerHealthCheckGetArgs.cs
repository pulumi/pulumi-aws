// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Elb.Inputs
{

    public sealed class LoadBalancerHealthCheckGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The number of checks before the instance is declared healthy.
        /// </summary>
        [Input("healthyThreshold", required: true)]
        public Input<int> HealthyThreshold { get; set; } = null!;

        /// <summary>
        /// The interval between checks.
        /// </summary>
        [Input("interval", required: true)]
        public Input<int> Interval { get; set; } = null!;

        /// <summary>
        /// The target of the check. Valid pattern is "${PROTOCOL}:${PORT}${PATH}", where PROTOCOL
        /// values are:
        /// * `HTTP`, `HTTPS` - PORT and PATH are required
        /// * `TCP`, `SSL` - PORT is required, PATH is not supported
        /// </summary>
        [Input("target", required: true)]
        public Input<string> Target { get; set; } = null!;

        /// <summary>
        /// The length of time before the check times out.
        /// </summary>
        [Input("timeout", required: true)]
        public Input<int> Timeout { get; set; } = null!;

        /// <summary>
        /// The number of checks before the instance is declared unhealthy.
        /// </summary>
        [Input("unhealthyThreshold", required: true)]
        public Input<int> UnhealthyThreshold { get; set; } = null!;

        public LoadBalancerHealthCheckGetArgs()
        {
        }
        public static new LoadBalancerHealthCheckGetArgs Empty => new LoadBalancerHealthCheckGetArgs();
    }
}
