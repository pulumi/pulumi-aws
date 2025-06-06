// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Outputs
{

    [OutputType]
    public sealed class FlowTriggerConfigTriggerPropertiesScheduled
    {
        /// <summary>
        /// Whether a scheduled flow has an incremental data transfer or a complete data transfer for each flow run. Valid values are `Incremental` and `Complete`.
        /// </summary>
        public readonly string? DataPullMode;
        /// <summary>
        /// Date range for the records to import from the connector in the first flow run. Must be a valid RFC3339 timestamp.
        /// </summary>
        public readonly string? FirstExecutionFrom;
        /// <summary>
        /// Scheduled end time for a schedule-triggered flow. Must be a valid RFC3339 timestamp.
        /// </summary>
        public readonly string? ScheduleEndTime;
        /// <summary>
        /// Scheduling expression that determines the rate at which the schedule will run, for example `rate(5minutes)`.
        /// </summary>
        public readonly string ScheduleExpression;
        /// <summary>
        /// Optional offset that is added to the time interval for a schedule-triggered flow. Maximum value of 36000.
        /// </summary>
        public readonly int? ScheduleOffset;
        /// <summary>
        /// Scheduled start time for a schedule-triggered flow. Must be a valid RFC3339 timestamp.
        /// </summary>
        public readonly string? ScheduleStartTime;
        /// <summary>
        /// Time zone used when referring to the date and time of a scheduled-triggered flow, such as `America/New_York`.
        /// </summary>
        public readonly string? Timezone;

        [OutputConstructor]
        private FlowTriggerConfigTriggerPropertiesScheduled(
            string? dataPullMode,

            string? firstExecutionFrom,

            string? scheduleEndTime,

            string scheduleExpression,

            int? scheduleOffset,

            string? scheduleStartTime,

            string? timezone)
        {
            DataPullMode = dataPullMode;
            FirstExecutionFrom = firstExecutionFrom;
            ScheduleEndTime = scheduleEndTime;
            ScheduleExpression = scheduleExpression;
            ScheduleOffset = scheduleOffset;
            ScheduleStartTime = scheduleStartTime;
            Timezone = timezone;
        }
    }
}
