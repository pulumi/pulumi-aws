// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fsx.Inputs
{

    public sealed class DataRepositoryAssociationS3Args : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the type of updated objects that will be automatically exported from your file system to the linked S3 bucket. See the `events` configuration block.
        /// </summary>
        [Input("autoExportPolicy")]
        public Input<Inputs.DataRepositoryAssociationS3AutoExportPolicyArgs>? AutoExportPolicy { get; set; }

        /// <summary>
        /// Specifies the type of updated objects that will be automatically imported from the linked S3 bucket to your file system. See the `events` configuration block.
        /// </summary>
        [Input("autoImportPolicy")]
        public Input<Inputs.DataRepositoryAssociationS3AutoImportPolicyArgs>? AutoImportPolicy { get; set; }

        public DataRepositoryAssociationS3Args()
        {
        }
        public static new DataRepositoryAssociationS3Args Empty => new DataRepositoryAssociationS3Args();
    }
}
