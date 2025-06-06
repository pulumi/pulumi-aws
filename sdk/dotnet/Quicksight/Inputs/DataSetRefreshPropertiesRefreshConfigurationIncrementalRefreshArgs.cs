// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The lookback window setup for an incremental refresh configuration. See lookback_window.
        /// </summary>
        [Input("lookbackWindow", required: true)]
        public Input<Inputs.DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshLookbackWindowArgs> LookbackWindow { get; set; } = null!;

        public DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshArgs()
        {
        }
        public static new DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshArgs Empty => new DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshArgs();
    }
}
