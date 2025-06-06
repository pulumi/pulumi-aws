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
    public sealed class GetDataSetLogicalTableMapDataTransformUntagColumnOperationResult
    {
        public readonly string ColumnName;
        public readonly ImmutableArray<string> TagNames;

        [OutputConstructor]
        private GetDataSetLogicalTableMapDataTransformUntagColumnOperationResult(
            string columnName,

            ImmutableArray<string> tagNames)
        {
            ColumnName = columnName;
            TagNames = tagNames;
        }
    }
}
