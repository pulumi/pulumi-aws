// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Inputs
{

    public sealed class CatalogTableOpenTableFormatInputGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for iceberg table config. See `iceberg_input` below.
        /// </summary>
        [Input("icebergInput", required: true)]
        public Input<Inputs.CatalogTableOpenTableFormatInputIcebergInputGetArgs> IcebergInput { get; set; } = null!;

        public CatalogTableOpenTableFormatInputGetArgs()
        {
        }
        public static new CatalogTableOpenTableFormatInputGetArgs Empty => new CatalogTableOpenTableFormatInputGetArgs();
    }
}
