// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerRuleActionForwardArgs : global::Pulumi.ResourceArgs
    {
        [Input("targetGroups", required: true)]
        private InputList<Inputs.ListenerRuleActionForwardTargetGroupArgs>? _targetGroups;

        /// <summary>
        /// The target groups. Traffic matching the rule is forwarded to the specified target groups. With forward actions, you can assign a weight that controls the prioritization and selection of each target group. This means that requests are distributed to individual target groups based on their weights. For example, if two target groups have the same weight, each target group receives half of the traffic.
        /// 
        /// The default value is 1 with maximum number of 2. If only one target group is provided, there is no need to set the weight; 100% of traffic will go to that target group.
        /// </summary>
        public InputList<Inputs.ListenerRuleActionForwardTargetGroupArgs> TargetGroups
        {
            get => _targetGroups ?? (_targetGroups = new InputList<Inputs.ListenerRuleActionForwardTargetGroupArgs>());
            set => _targetGroups = value;
        }

        public ListenerRuleActionForwardArgs()
        {
        }
        public static new ListenerRuleActionForwardArgs Empty => new ListenerRuleActionForwardArgs();
    }
}
