// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamQuery.Outputs
{

    [OutputType]
    public sealed class ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxis
    {
        /// <summary>
        /// Partition key used for partitioning, which can be a default measure_name or a customer defined partition key.
        /// </summary>
        public readonly ImmutableArray<string> PartitionKeys;
        /// <summary>
        /// ARN of the table which is queried with the largest time range.
        /// </summary>
        public readonly string? TableArn;
        /// <summary>
        /// Maximum duration in nanoseconds between the start and end of the query.
        /// </summary>
        public readonly double? Value;

        [OutputConstructor]
        private ScheduledQueryLastRunSummaryQueryInsightsResponseQuerySpatialCoverageMaxis(
            ImmutableArray<string> partitionKeys,

            string? tableArn,

            double? value)
        {
            PartitionKeys = partitionKeys;
            TableArn = tableArn;
            Value = value;
        }
    }
}
