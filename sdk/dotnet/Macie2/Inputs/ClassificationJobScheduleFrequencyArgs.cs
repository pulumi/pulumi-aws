// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Macie2.Inputs
{

    public sealed class ClassificationJobScheduleFrequencyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies a daily recurrence pattern for running the job.
        /// </summary>
        [Input("dailySchedule")]
        public Input<bool>? DailySchedule { get; set; }

        /// <summary>
        /// Specifies a monthly recurrence pattern for running the job.
        /// </summary>
        [Input("monthlySchedule")]
        public Input<int>? MonthlySchedule { get; set; }

        /// <summary>
        /// Specifies a weekly recurrence pattern for running the job.
        /// </summary>
        [Input("weeklySchedule")]
        public Input<string>? WeeklySchedule { get; set; }

        public ClassificationJobScheduleFrequencyArgs()
        {
        }
        public static new ClassificationJobScheduleFrequencyArgs Empty => new ClassificationJobScheduleFrequencyArgs();
    }
}
