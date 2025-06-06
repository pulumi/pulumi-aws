// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EmrContainers.Outputs
{

    [OutputType]
    public sealed class JobTemplateJobTemplateDataConfigurationOverridesMonitoringConfigurationS3MonitoringConfiguration
    {
        /// <summary>
        /// Amazon S3 destination URI for log publishing.
        /// </summary>
        public readonly string LogUri;

        [OutputConstructor]
        private JobTemplateJobTemplateDataConfigurationOverridesMonitoringConfigurationS3MonitoringConfiguration(string logUri)
        {
            LogUri = logUri;
        }
    }
}
