// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Inputs
{

    public sealed class SchedulingPolicyFairSharePolicyShareDistributionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A fair share identifier or fair share identifier prefix. For more information, see [ShareAttributes](https://docs.aws.amazon.com/batch/latest/APIReference/API_ShareAttributes.html).
        /// </summary>
        [Input("shareIdentifier", required: true)]
        public Input<string> ShareIdentifier { get; set; } = null!;

        /// <summary>
        /// The weight factor for the fair share identifier. For more information, see [ShareAttributes](https://docs.aws.amazon.com/batch/latest/APIReference/API_ShareAttributes.html).
        /// </summary>
        [Input("weightFactor")]
        public Input<double>? WeightFactor { get; set; }

        public SchedulingPolicyFairSharePolicyShareDistributionArgs()
        {
        }
        public static new SchedulingPolicyFairSharePolicyShareDistributionArgs Empty => new SchedulingPolicyFairSharePolicyShareDistributionArgs();
    }
}
