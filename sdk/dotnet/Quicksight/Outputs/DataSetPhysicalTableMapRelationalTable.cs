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
    public sealed class DataSetPhysicalTableMapRelationalTable
    {
        /// <summary>
        /// Catalog associated with the table.
        /// </summary>
        public readonly string? Catalog;
        /// <summary>
        /// ARN of the data source.
        /// </summary>
        public readonly string DataSourceArn;
        /// <summary>
        /// Column schema of the table. See input_columns.
        /// </summary>
        public readonly ImmutableArray<Outputs.DataSetPhysicalTableMapRelationalTableInputColumn> InputColumns;
        /// <summary>
        /// Name of the relational table.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Schema name. This name applies to certain relational database engines.
        /// </summary>
        public readonly string? Schema;

        [OutputConstructor]
        private DataSetPhysicalTableMapRelationalTable(
            string? catalog,

            string dataSourceArn,

            ImmutableArray<Outputs.DataSetPhysicalTableMapRelationalTableInputColumn> inputColumns,

            string name,

            string? schema)
        {
            Catalog = catalog;
            DataSourceArn = dataSourceArn;
            InputColumns = inputColumns;
            Name = name;
            Schema = schema;
        }
    }
}
