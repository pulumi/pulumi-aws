// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFormation.Outputs
{

    [OutputType]
    public sealed class StackInstancesOperationPreferences
    {
        /// <summary>
        /// How the concurrency level behaves during the operation execution. Valid values are `STRICT_FAILURE_TOLERANCE` and `SOFT_FAILURE_TOLERANCE`.
        /// </summary>
        public readonly string? ConcurrencyMode;
        /// <summary>
        /// Number of accounts, per region, for which this operation can fail before CloudFormation stops the operation in that region.
        /// </summary>
        public readonly int? FailureToleranceCount;
        /// <summary>
        /// Percentage of accounts, per region, for which this stack operation can fail before CloudFormation stops the operation in that region.
        /// </summary>
        public readonly int? FailureTolerancePercentage;
        /// <summary>
        /// Maximum number of accounts in which to perform this operation at one time.
        /// </summary>
        public readonly int? MaxConcurrentCount;
        /// <summary>
        /// Maximum percentage of accounts in which to perform this operation at one time.
        /// </summary>
        public readonly int? MaxConcurrentPercentage;
        /// <summary>
        /// Concurrency type of deploying stack sets operations in regions, could be in parallel or one region at a time. Valid values are `SEQUENTIAL` and `PARALLEL`.
        /// </summary>
        public readonly string? RegionConcurrencyType;
        /// <summary>
        /// Order of the regions where you want to perform the stack operation.
        /// </summary>
        public readonly ImmutableArray<string> RegionOrders;

        [OutputConstructor]
        private StackInstancesOperationPreferences(
            string? concurrencyMode,

            int? failureToleranceCount,

            int? failureTolerancePercentage,

            int? maxConcurrentCount,

            int? maxConcurrentPercentage,

            string? regionConcurrencyType,

            ImmutableArray<string> regionOrders)
        {
            ConcurrencyMode = concurrencyMode;
            FailureToleranceCount = failureToleranceCount;
            FailureTolerancePercentage = failureTolerancePercentage;
            MaxConcurrentCount = maxConcurrentCount;
            MaxConcurrentPercentage = maxConcurrentPercentage;
            RegionConcurrencyType = regionConcurrencyType;
            RegionOrders = regionOrders;
        }
    }
}
