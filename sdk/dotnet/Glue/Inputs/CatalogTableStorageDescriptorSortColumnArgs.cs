// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Inputs
{

    public sealed class CatalogTableStorageDescriptorSortColumnArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the column.
        /// </summary>
        [Input("column", required: true)]
        public Input<string> Column { get; set; } = null!;

        /// <summary>
        /// Whether the column is sorted in ascending (`1`) or descending order (`0`).
        /// </summary>
        [Input("sortOrder", required: true)]
        public Input<int> SortOrder { get; set; } = null!;

        public CatalogTableStorageDescriptorSortColumnArgs()
        {
        }
        public static new CatalogTableStorageDescriptorSortColumnArgs Empty => new CatalogTableStorageDescriptorSortColumnArgs();
    }
}
