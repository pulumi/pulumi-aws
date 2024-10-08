// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class DataSourceParametersS3Args : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An object containing the S3 location of the S3 manifest file.
        /// </summary>
        [Input("manifestFileLocation", required: true)]
        public Input<Inputs.DataSourceParametersS3ManifestFileLocationArgs> ManifestFileLocation { get; set; } = null!;

        public DataSourceParametersS3Args()
        {
        }
        public static new DataSourceParametersS3Args Empty => new DataSourceParametersS3Args();
    }
}
