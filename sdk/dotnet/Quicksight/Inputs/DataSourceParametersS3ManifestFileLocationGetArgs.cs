// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DataSourceParametersS3ManifestFileLocationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the bucket that contains the manifest file.
        /// </summary>
        [Input("bucket", required: true)]
        public Input<string> Bucket { get; set; } = null!;

        /// <summary>
        /// The key of the manifest file within the bucket.
        /// </summary>
        [Input("key", required: true)]
        public Input<string> Key { get; set; } = null!;

        public DataSourceParametersS3ManifestFileLocationGetArgs()
        {
        }
        public static new DataSourceParametersS3ManifestFileLocationGetArgs Empty => new DataSourceParametersS3ManifestFileLocationGetArgs();
    }
}
