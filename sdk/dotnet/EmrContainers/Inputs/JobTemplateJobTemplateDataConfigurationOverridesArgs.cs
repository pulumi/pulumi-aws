// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EmrContainers.Inputs
{

    public sealed class JobTemplateJobTemplateDataConfigurationOverridesArgs : global::Pulumi.ResourceArgs
    {
        [Input("applicationConfigurations")]
        private InputList<Inputs.JobTemplateJobTemplateDataConfigurationOverridesApplicationConfigurationArgs>? _applicationConfigurations;

        /// <summary>
        /// The configurations for the application running by the job run.
        /// </summary>
        public InputList<Inputs.JobTemplateJobTemplateDataConfigurationOverridesApplicationConfigurationArgs> ApplicationConfigurations
        {
            get => _applicationConfigurations ?? (_applicationConfigurations = new InputList<Inputs.JobTemplateJobTemplateDataConfigurationOverridesApplicationConfigurationArgs>());
            set => _applicationConfigurations = value;
        }

        /// <summary>
        /// The configurations for monitoring.
        /// </summary>
        [Input("monitoringConfiguration")]
        public Input<Inputs.JobTemplateJobTemplateDataConfigurationOverridesMonitoringConfigurationArgs>? MonitoringConfiguration { get; set; }

        public JobTemplateJobTemplateDataConfigurationOverridesArgs()
        {
        }
        public static new JobTemplateJobTemplateDataConfigurationOverridesArgs Empty => new JobTemplateJobTemplateDataConfigurationOverridesArgs();
    }
}
