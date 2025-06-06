// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DataSync.Outputs
{

    [OutputType]
    public sealed class TaskTaskReportConfig
    {
        /// <summary>
        /// Specifies the type of task report you'd like. Valid values: `SUMMARY_ONLY` and `STANDARD`.
        /// </summary>
        public readonly string? OutputType;
        /// <summary>
        /// Specifies whether you want your task report to include only what went wrong with your transfer or a list of what succeeded and didn't. Valid values: `ERRORS_ONLY` and `SUCCESSES_AND_ERRORS`.
        /// </summary>
        public readonly string? ReportLevel;
        /// <summary>
        /// Configuration block containing the configuration of the reporting level for aspects of your task report. See `report_overrides` below.
        /// </summary>
        public readonly Outputs.TaskTaskReportConfigReportOverrides? ReportOverrides;
        /// <summary>
        /// Configuration block containing the configuration for the Amazon S3 bucket where DataSync uploads your task report. See `s3_destination` below.
        /// </summary>
        public readonly Outputs.TaskTaskReportConfigS3Destination S3Destination;
        /// <summary>
        /// Specifies whether your task report includes the new version of each object transferred into an S3 bucket. This only applies if you enable versioning on your bucket. Keep in mind that setting this to INCLUDE can increase the duration of your task execution. Valid values: `INCLUDE` and `NONE`.
        /// </summary>
        public readonly string? S3ObjectVersioning;

        [OutputConstructor]
        private TaskTaskReportConfig(
            string? outputType,

            string? reportLevel,

            Outputs.TaskTaskReportConfigReportOverrides? reportOverrides,

            Outputs.TaskTaskReportConfigS3Destination s3Destination,

            string? s3ObjectVersioning)
        {
            OutputType = outputType;
            ReportLevel = reportLevel;
            ReportOverrides = reportOverrides;
            S3Destination = s3Destination;
            S3ObjectVersioning = s3ObjectVersioning;
        }
    }
}
