// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr.Inputs
{

    public sealed class ClusterMasterInstanceFleetInstanceTypeConfigConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Classification within a configuration.
        /// </summary>
        [Input("classification")]
        public Input<string>? Classification { get; set; }

        [Input("properties")]
        private InputMap<string>? _properties;

        /// <summary>
        /// Map of properties specified within a configuration classification.
        /// </summary>
        public InputMap<string> Properties
        {
            get => _properties ?? (_properties = new InputMap<string>());
            set => _properties = value;
        }

        public ClusterMasterInstanceFleetInstanceTypeConfigConfigurationGetArgs()
        {
        }
        public static new ClusterMasterInstanceFleetInstanceTypeConfigConfigurationGetArgs Empty => new ClusterMasterInstanceFleetInstanceTypeConfigConfigurationGetArgs();
    }
}
