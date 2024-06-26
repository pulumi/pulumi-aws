// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Inputs
{

    public sealed class SchedulingPolicyFairSharePolicyArgs : global::Pulumi.ResourceArgs
    {
        [Input("computeReservation")]
        public Input<int>? ComputeReservation { get; set; }

        [Input("shareDecaySeconds")]
        public Input<int>? ShareDecaySeconds { get; set; }

        [Input("shareDistributions")]
        private InputList<Inputs.SchedulingPolicyFairSharePolicyShareDistributionArgs>? _shareDistributions;
        public InputList<Inputs.SchedulingPolicyFairSharePolicyShareDistributionArgs> ShareDistributions
        {
            get => _shareDistributions ?? (_shareDistributions = new InputList<Inputs.SchedulingPolicyFairSharePolicyShareDistributionArgs>());
            set => _shareDistributions = value;
        }

        public SchedulingPolicyFairSharePolicyArgs()
        {
        }
        public static new SchedulingPolicyFairSharePolicyArgs Empty => new SchedulingPolicyFairSharePolicyArgs();
    }
}
