// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Evidently.Inputs
{

    public sealed class LaunchMetricMonitorArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A block that defines the metric. Detailed below.
        /// </summary>
        [Input("metricDefinition", required: true)]
        public Input<Inputs.LaunchMetricMonitorMetricDefinitionArgs> MetricDefinition { get; set; } = null!;

        public LaunchMetricMonitorArgs()
        {
        }
        public static new LaunchMetricMonitorArgs Empty => new LaunchMetricMonitorArgs();
    }
}
