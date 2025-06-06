// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Outputs
{

    [OutputType]
    public sealed class DataSetLogicalTableMapDataTransformRenameColumnOperation
    {
        /// <summary>
        /// Column to be renamed.
        /// </summary>
        public readonly string ColumnName;
        /// <summary>
        /// New name for the column.
        /// </summary>
        public readonly string NewColumnName;

        [OutputConstructor]
        private DataSetLogicalTableMapDataTransformRenameColumnOperation(
            string columnName,

            string newColumnName)
        {
            ColumnName = columnName;
            NewColumnName = newColumnName;
        }
    }
}
