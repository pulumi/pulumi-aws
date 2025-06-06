// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Outputs
{

    [OutputType]
    public sealed class LifecyclePolicyPolicyDetailFilter
    {
        /// <summary>
        /// For age-based filters, this is the number of resources to keep on hand after the lifecycle DELETE action is applied. Impacted resources are only deleted if you have more than this number of resources. If you have fewer resources than this number, the impacted resource is not deleted.
        /// </summary>
        public readonly int? RetainAtLeast;
        /// <summary>
        /// Filter resources based on either age or count. Valid values: `AGE` or `COUNT`.
        /// </summary>
        public readonly string Type;
        /// <summary>
        /// Defines the unit of time that the lifecycle policy uses to determine impacted resources. This is required for age-based rules. Valid values: `DAYS`, `WEEKS`, `MONTHS` or `YEARS`.
        /// </summary>
        public readonly string? Unit;
        /// <summary>
        /// The number of units for the time period or for the count. For example, a value of 6 might refer to six months or six AMIs.
        /// 
        /// The following arguments are optional:
        /// </summary>
        public readonly int Value;

        [OutputConstructor]
        private LifecyclePolicyPolicyDetailFilter(
            int? retainAtLeast,

            string type,

            string? unit,

            int value)
        {
            RetainAtLeast = retainAtLeast;
            Type = type;
            Unit = unit;
            Value = value;
        }
    }
}
