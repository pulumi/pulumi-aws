// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Inputs
{

    public sealed class ListenerRuleActionForwardTargetGroupGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the target group.
        /// </summary>
        [Input("arn", required: true)]
        public Input<string> Arn { get; set; } = null!;

        /// <summary>
        /// The weight. The range is 0 to 999.
        /// </summary>
        [Input("weight")]
        public Input<int>? Weight { get; set; }

        public ListenerRuleActionForwardTargetGroupGetArgs()
        {
        }
        public static new ListenerRuleActionForwardTargetGroupGetArgs Empty => new ListenerRuleActionForwardTargetGroupGetArgs();
    }
}
