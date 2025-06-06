// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Outputs
{

    [OutputType]
    public sealed class GetGroupInstanceMaintenancePolicyResult
    {
        /// <summary>
        /// Specifies the upper limit on the number of instances that are in the InService or Pending state with a healthy status during an instance replacement activity.
        /// </summary>
        public readonly int MaxHealthyPercentage;
        /// <summary>
        /// Specifies the lower limit on the number of instances that must be in the InService state with a healthy status during an instance replacement activity.
        /// </summary>
        public readonly int MinHealthyPercentage;

        [OutputConstructor]
        private GetGroupInstanceMaintenancePolicyResult(
            int maxHealthyPercentage,

            int minHealthyPercentage)
        {
            MaxHealthyPercentage = maxHealthyPercentage;
            MinHealthyPercentage = minHealthyPercentage;
        }
    }
}
