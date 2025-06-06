// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Msk.Inputs
{

    public sealed class ClusterOpenMonitoringPrometheusNodeExporterGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates whether you want to enable or disable the Node Exporter.
        /// </summary>
        [Input("enabledInBroker", required: true)]
        public Input<bool> EnabledInBroker { get; set; } = null!;

        public ClusterOpenMonitoringPrometheusNodeExporterGetArgs()
        {
        }
        public static new ClusterOpenMonitoringPrometheusNodeExporterGetArgs Empty => new ClusterOpenMonitoringPrometheusNodeExporterGetArgs();
    }
}
