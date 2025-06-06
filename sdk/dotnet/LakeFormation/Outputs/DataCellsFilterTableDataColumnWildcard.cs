// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LakeFormation.Outputs
{

    [OutputType]
    public sealed class DataCellsFilterTableDataColumnWildcard
    {
        /// <summary>
        /// (Optional) Excludes column names. Any column with this name will be excluded.
        /// </summary>
        public readonly ImmutableArray<string> ExcludedColumnNames;

        [OutputConstructor]
        private DataCellsFilterTableDataColumnWildcard(ImmutableArray<string> excludedColumnNames)
        {
            ExcludedColumnNames = excludedColumnNames;
        }
    }
}
