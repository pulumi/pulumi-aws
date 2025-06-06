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
    public sealed class ApplicationApplicationConfigurationFlinkApplicationConfigurationMonitoringConfiguration
    {
        /// <summary>
        /// Describes whether to use the default CloudWatch logging configuration for an application. Valid values: `CUSTOM`, `DEFAULT`. Set this attribute to `CUSTOM` in order for any specified `log_level` or `metrics_level` attribute values to be effective.
        /// </summary>
        public readonly string ConfigurationType;
        /// <summary>
        /// Describes the verbosity of the CloudWatch Logs for an application. Valid values: `DEBUG`, `ERROR`, `INFO`, `WARN`.
        /// </summary>
        public readonly string? LogLevel;
        /// <summary>
        /// Describes the granularity of the CloudWatch Logs for an application. Valid values: `APPLICATION`, `OPERATOR`, `PARALLELISM`, `TASK`.
        /// </summary>
        public readonly string? MetricsLevel;

        [OutputConstructor]
        private ApplicationApplicationConfigurationFlinkApplicationConfigurationMonitoringConfiguration(
            string configurationType,

            string? logLevel,

            string? metricsLevel)
        {
            ConfigurationType = configurationType;
            LogLevel = logLevel;
            MetricsLevel = metricsLevel;
        }
    }
}
