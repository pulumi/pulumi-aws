// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Scheduler.Outputs
{

    [OutputType]
    public sealed class ScheduleTargetKinesisParameters
    {
        /// <summary>
        /// Specifies the shard to which EventBridge Scheduler sends the event. Up to 256 characters.
        /// </summary>
        public readonly string PartitionKey;

        [OutputConstructor]
        private ScheduleTargetKinesisParameters(string partitionKey)
        {
            PartitionKey = partitionKey;
        }
    }
}
