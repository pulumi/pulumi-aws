// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerRuleActionForwardTargetGroupGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("targetGroupIdentifier", required: true)]
        public Input<string> TargetGroupIdentifier { get; set; } = null!;

        [Input("weight")]
        public Input<int>? Weight { get; set; }

        public ListenerRuleActionForwardTargetGroupGetArgs()
        {
        }
        public static new ListenerRuleActionForwardTargetGroupGetArgs Empty => new ListenerRuleActionForwardTargetGroupGetArgs();
    }
}