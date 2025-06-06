// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.KinesisAnalyticsV2.Inputs
{

    public sealed class ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Describes the interval in milliseconds between checkpoint operations.
        /// </summary>
        [Input("checkpointInterval")]
        public Input<int>? CheckpointInterval { get; set; }

        /// <summary>
        /// Describes whether checkpointing is enabled for a Flink-based Kinesis Data Analytics application.
        /// </summary>
        [Input("checkpointingEnabled")]
        public Input<bool>? CheckpointingEnabled { get; set; }

        /// <summary>
        /// Describes whether the application uses Kinesis Data Analytics' default checkpointing behavior. Valid values: `CUSTOM`, `DEFAULT`. Set this attribute to `CUSTOM` in order for any specified `checkpointing_enabled`, `checkpoint_interval`, or `min_pause_between_checkpoints` attribute values to be effective. If this attribute is set to `DEFAULT`, the application will always use the following values:
        /// * `checkpointing_enabled = true`
        /// * `checkpoint_interval = 60000`
        /// * `min_pause_between_checkpoints = 5000`
        /// </summary>
        [Input("configurationType", required: true)]
        public Input<string> ConfigurationType { get; set; } = null!;

        /// <summary>
        /// Describes the minimum time in milliseconds after a checkpoint operation completes that a new checkpoint operation can start.
        /// </summary>
        [Input("minPauseBetweenCheckpoints")]
        public Input<int>? MinPauseBetweenCheckpoints { get; set; }

        public ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfigurationArgs()
        {
        }
        public static new ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfigurationArgs Empty => new ApplicationApplicationConfigurationFlinkApplicationConfigurationCheckpointConfigurationArgs();
    }
}
