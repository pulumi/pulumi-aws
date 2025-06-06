// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Outputs
{

    [OutputType]
    public sealed class ListenerDefaultActionForward
    {
        /// <summary>
        /// Configuration block for target group stickiness for the rule. See below.
        /// </summary>
        public readonly Outputs.ListenerDefaultActionForwardStickiness? Stickiness;
        /// <summary>
        /// Set of 1-5 target group blocks. See below.
        /// 
        /// The following arguments are optional:
        /// </summary>
        public readonly ImmutableArray<Outputs.ListenerDefaultActionForwardTargetGroup> TargetGroups;

        [OutputConstructor]
        private ListenerDefaultActionForward(
            Outputs.ListenerDefaultActionForwardStickiness? stickiness,

            ImmutableArray<Outputs.ListenerDefaultActionForwardTargetGroup> targetGroups)
        {
            Stickiness = stickiness;
            TargetGroups = targetGroups;
        }
    }
}
