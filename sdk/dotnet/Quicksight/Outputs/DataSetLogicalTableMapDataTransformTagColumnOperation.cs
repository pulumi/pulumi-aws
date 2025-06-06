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
    public sealed class DataSetLogicalTableMapDataTransformTagColumnOperation
    {
        /// <summary>
        /// Column name.
        /// </summary>
        public readonly string ColumnName;
        /// <summary>
        /// The dataset column tag, currently only used for geospatial type tagging. See tags.
        /// </summary>
        public readonly ImmutableArray<Outputs.DataSetLogicalTableMapDataTransformTagColumnOperationTag> Tags;

        [OutputConstructor]
        private DataSetLogicalTableMapDataTransformTagColumnOperation(
            string columnName,

            ImmutableArray<Outputs.DataSetLogicalTableMapDataTransformTagColumnOperationTag> tags)
        {
            ColumnName = columnName;
            Tags = tags;
        }
    }
}
