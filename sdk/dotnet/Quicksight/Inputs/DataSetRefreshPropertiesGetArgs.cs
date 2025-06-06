// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DataSetRefreshPropertiesGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The refresh configuration for the data set. See refresh_configuration.
        /// </summary>
        [Input("refreshConfiguration", required: true)]
        public Input<Inputs.DataSetRefreshPropertiesRefreshConfigurationGetArgs> RefreshConfiguration { get; set; } = null!;

        public DataSetRefreshPropertiesGetArgs()
        {
        }
        public static new DataSetRefreshPropertiesGetArgs Empty => new DataSetRefreshPropertiesGetArgs();
    }
}
