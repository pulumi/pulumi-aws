// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamWrite.Outputs
{

    [OutputType]
    public sealed class GetTableRetentionPropertyResult
    {
        /// <summary>
        /// Duration in days in which the data must be stored in magnetic store.
        /// </summary>
        public readonly int MagneticStoreRetentionPeriodInDays;
        /// <summary>
        /// Duration in hours in which the data must be stored in memory store.
        /// </summary>
        public readonly int MemoryStoreRetentionPeriodInHours;

        [OutputConstructor]
        private GetTableRetentionPropertyResult(
            int magneticStoreRetentionPeriodInDays,

            int memoryStoreRetentionPeriodInHours)
        {
            MagneticStoreRetentionPeriodInDays = magneticStoreRetentionPeriodInDays;
            MemoryStoreRetentionPeriodInHours = memoryStoreRetentionPeriodInHours;
        }
    }
}
