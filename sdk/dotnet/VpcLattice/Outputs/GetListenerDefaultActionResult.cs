// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Outputs
{

    [OutputType]
    public sealed class GetListenerDefaultActionResult
    {
        public readonly ImmutableArray<Outputs.GetListenerDefaultActionFixedResponseResult> FixedResponses;
        public readonly ImmutableArray<Outputs.GetListenerDefaultActionForwardResult> Forwards;

        [OutputConstructor]
        private GetListenerDefaultActionResult(
            ImmutableArray<Outputs.GetListenerDefaultActionFixedResponseResult> fixedResponses,

            ImmutableArray<Outputs.GetListenerDefaultActionForwardResult> forwards)
        {
            FixedResponses = fixedResponses;
            Forwards = forwards;
        }
    }
}