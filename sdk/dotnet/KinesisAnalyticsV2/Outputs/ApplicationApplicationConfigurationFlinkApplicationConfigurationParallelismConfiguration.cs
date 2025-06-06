// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Outputs
{

    [OutputType]
    public sealed class ApplicationApplicationConfigurationFlinkApplicationConfigurationParallelismConfiguration
    {
        /// <summary>
        /// Describes whether the Kinesis Data Analytics service can increase the parallelism of the application in response to increased throughput.
        /// </summary>
        public readonly bool? AutoScalingEnabled;
        /// <summary>
        /// Describes whether the application uses the default parallelism for the Kinesis Data Analytics service. Valid values: `CUSTOM`, `DEFAULT`. Set this attribute to `CUSTOM` in order for any specified `auto_scaling_enabled`, `parallelism`, or `parallelism_per_kpu` attribute values to be effective.
        /// </summary>
        public readonly string ConfigurationType;
        /// <summary>
        /// Describes the initial number of parallel tasks that a Flink-based Kinesis Data Analytics application can perform.
        /// </summary>
        public readonly int? Parallelism;
        /// <summary>
        /// Describes the number of parallel tasks that a Flink-based Kinesis Data Analytics application can perform per Kinesis Processing Unit (KPU) used by the application.
        /// </summary>
        public readonly int? ParallelismPerKpu;

        [OutputConstructor]
        private ApplicationApplicationConfigurationFlinkApplicationConfigurationParallelismConfiguration(
            bool? autoScalingEnabled,

            string configurationType,

            int? parallelism,

            int? parallelismPerKpu)
        {
            AutoScalingEnabled = autoScalingEnabled;
            ConfigurationType = configurationType;
            Parallelism = parallelism;
            ParallelismPerKpu = parallelismPerKpu;
        }
    }
}
