// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DataQualityJobDefinitionJobResourcesGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The configuration for the cluster resources used to run the processing job. Fields are documented below.
        /// </summary>
        [Input("clusterConfig", required: true)]
        public Input<Inputs.DataQualityJobDefinitionJobResourcesClusterConfigGetArgs> ClusterConfig { get; set; } = null!;

        public DataQualityJobDefinitionJobResourcesGetArgs()
        {
        }
        public static new DataQualityJobDefinitionJobResourcesGetArgs Empty => new DataQualityJobDefinitionJobResourcesGetArgs();
    }
}
