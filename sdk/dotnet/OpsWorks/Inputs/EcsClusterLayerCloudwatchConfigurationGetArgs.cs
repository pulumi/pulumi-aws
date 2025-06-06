// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Inputs
{

    public sealed class EcsClusterLayerCloudwatchConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        [Input("logStreams")]
        private InputList<Inputs.EcsClusterLayerCloudwatchConfigurationLogStreamGetArgs>? _logStreams;
        public InputList<Inputs.EcsClusterLayerCloudwatchConfigurationLogStreamGetArgs> LogStreams
        {
            get => _logStreams ?? (_logStreams = new InputList<Inputs.EcsClusterLayerCloudwatchConfigurationLogStreamGetArgs>());
            set => _logStreams = value;
        }

        public EcsClusterLayerCloudwatchConfigurationGetArgs()
        {
        }
        public static new EcsClusterLayerCloudwatchConfigurationGetArgs Empty => new EcsClusterLayerCloudwatchConfigurationGetArgs();
    }
}
