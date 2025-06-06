// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Inputs
{

    public sealed class TargetGroupTargetFailoverArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates how the GWLB handles existing flows when a target is deregistered. Possible values are `rebalance` and `no_rebalance`. Must match the attribute value set for `on_unhealthy`. Default: `no_rebalance`.
        /// </summary>
        [Input("onDeregistration", required: true)]
        public Input<string> OnDeregistration { get; set; } = null!;

        /// <summary>
        /// Indicates how the GWLB handles existing flows when a target is unhealthy. Possible values are `rebalance` and `no_rebalance`. Must match the attribute value set for `on_deregistration`. Default: `no_rebalance`.
        /// </summary>
        [Input("onUnhealthy", required: true)]
        public Input<string> OnUnhealthy { get; set; } = null!;

        public TargetGroupTargetFailoverArgs()
        {
        }
        public static new TargetGroupTargetFailoverArgs Empty => new TargetGroupTargetFailoverArgs();
    }
}
