// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Alb.Inputs
{

    public sealed class ListenerDefaultActionForwardStickinessGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Time period, in seconds, during which requests from a client should be routed to the same target group. The range is 1-604800 seconds (7 days).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("duration", required: true)]
        public Input<int> Duration { get; set; } = null!;

        /// <summary>
        /// Whether target group stickiness is enabled. Default is `false`.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        public ListenerDefaultActionForwardStickinessGetArgs()
        {
        }
        public static new ListenerDefaultActionForwardStickinessGetArgs Empty => new ListenerDefaultActionForwardStickinessGetArgs();
    }
}
