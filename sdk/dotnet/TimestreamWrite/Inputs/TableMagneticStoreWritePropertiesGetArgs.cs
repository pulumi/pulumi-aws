// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.TimestreamWrite.Inputs
{

    public sealed class TableMagneticStoreWritePropertiesGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A flag to enable magnetic store writes.
        /// </summary>
        [Input("enableMagneticStoreWrites")]
        public Input<bool>? EnableMagneticStoreWrites { get; set; }

        /// <summary>
        /// The location to write error reports for records rejected asynchronously during magnetic store writes. See Magnetic Store Rejected Data Location below for more details.
        /// </summary>
        [Input("magneticStoreRejectedDataLocation")]
        public Input<Inputs.TableMagneticStoreWritePropertiesMagneticStoreRejectedDataLocationGetArgs>? MagneticStoreRejectedDataLocation { get; set; }

        public TableMagneticStoreWritePropertiesGetArgs()
        {
        }
        public static new TableMagneticStoreWritePropertiesGetArgs Empty => new TableMagneticStoreWritePropertiesGetArgs();
    }
}
