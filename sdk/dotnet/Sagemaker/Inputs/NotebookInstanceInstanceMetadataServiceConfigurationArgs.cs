// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class NotebookInstanceInstanceMetadataServiceConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates the minimum IMDS version that the notebook instance supports. When passed "1" is passed. This means that both IMDSv1 and IMDSv2 are supported. Valid values are `1` and `2`.
        /// </summary>
        [Input("minimumInstanceMetadataServiceVersion")]
        public Input<string>? MinimumInstanceMetadataServiceVersion { get; set; }

        public NotebookInstanceInstanceMetadataServiceConfigurationArgs()
        {
        }
        public static new NotebookInstanceInstanceMetadataServiceConfigurationArgs Empty => new NotebookInstanceInstanceMetadataServiceConfigurationArgs();
    }
}
