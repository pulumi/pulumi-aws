// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Outputs
{

    [OutputType]
    public sealed class ListenerDefaultActionForward
    {
        /// <summary>
        /// One or more target group blocks.
        /// </summary>
        public readonly ImmutableArray<Outputs.ListenerDefaultActionForwardTargetGroup> TargetGroups;

        [OutputConstructor]
        private ListenerDefaultActionForward(ImmutableArray<Outputs.ListenerDefaultActionForwardTargetGroup> targetGroups)
        {
            TargetGroups = targetGroups;
        }
    }
}
