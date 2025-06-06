// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamWrite.Inputs
{

    public sealed class TableMagneticStoreWritePropertiesMagneticStoreRejectedDataLocationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration of an S3 location to write error reports for records rejected, asynchronously, during magnetic store writes. See S3 Configuration below for more details.
        /// </summary>
        [Input("s3Configuration")]
        public Input<Inputs.TableMagneticStoreWritePropertiesMagneticStoreRejectedDataLocationS3ConfigurationArgs>? S3Configuration { get; set; }

        public TableMagneticStoreWritePropertiesMagneticStoreRejectedDataLocationArgs()
        {
        }
        public static new TableMagneticStoreWritePropertiesMagneticStoreRejectedDataLocationArgs Empty => new TableMagneticStoreWritePropertiesMagneticStoreRejectedDataLocationArgs();
    }
}
