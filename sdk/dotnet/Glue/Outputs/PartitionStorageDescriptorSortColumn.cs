// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Glue.Outputs
{

    [OutputType]
    public sealed class PartitionStorageDescriptorSortColumn
    {
        /// <summary>
        /// The name of the column.
        /// </summary>
        public readonly string Column;
        /// <summary>
        /// Indicates that the column is sorted in ascending order (== 1), or in descending order (==0).
        /// </summary>
        public readonly int SortOrder;

        [OutputConstructor]
        private PartitionStorageDescriptorSortColumn(
            string column,

            int sortOrder)
        {
            Column = column;
            SortOrder = sortOrder;
        }
    }
}
