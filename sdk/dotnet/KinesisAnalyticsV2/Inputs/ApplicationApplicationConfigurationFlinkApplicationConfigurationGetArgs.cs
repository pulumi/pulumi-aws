// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Inputs
{

    public sealed class ApplicationApplicationConfigurationFlinkApplicationConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Describes an application's checkpointing configuration.
        /// </summary>
        [Input("checkpointConfiguration")]
        public Input<Inputs.ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfigurationGetArgs>? CheckpointConfiguration { get; set; }

        /// <summary>
        /// Describes configuration parameters for CloudWatch logging for an application.
        /// </summary>
        [Input("monitoringConfiguration")]
        public Input<Inputs.ApplicationApplicationConfigurationFlinkApplicationConfigurationMonitoringConfigurationGetArgs>? MonitoringConfiguration { get; set; }

        /// <summary>
        /// Describes parameters for how an application executes multiple tasks simultaneously.
        /// </summary>
        [Input("parallelismConfiguration")]
        public Input<Inputs.ApplicationApplicationConfigurationFlinkApplicationConfigurationParallelismConfigurationGetArgs>? ParallelismConfiguration { get; set; }

        public ApplicationApplicationConfigurationFlinkApplicationConfigurationGetArgs()
        {
        }
        public static new ApplicationApplicationConfigurationFlinkApplicationConfigurationGetArgs Empty => new ApplicationApplicationConfigurationFlinkApplicationConfigurationGetArgs();
    }
}
