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
    public sealed class DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshLookbackWindow
    {
        /// <summary>
        /// The name of the lookback window column.
        /// </summary>
        public readonly string ColumnName;
        /// <summary>
        /// The lookback window column size.
        /// </summary>
        public readonly int Size;
        /// <summary>
        /// The size unit that is used for the lookback window column. Valid values for this structure are `HOUR`, `DAY`, and `WEEK`.
        /// </summary>
        public readonly string SizeUnit;

        [OutputConstructor]
        private DataSetRefreshPropertiesRefreshConfigurationIncrementalRefreshLookbackWindow(
            string columnName,

            int size,

            string sizeUnit)
        {
            ColumnName = columnName;
            Size = size;
            SizeUnit = sizeUnit;
        }
    }
}
