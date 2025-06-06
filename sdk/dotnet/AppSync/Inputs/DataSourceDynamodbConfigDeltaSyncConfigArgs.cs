// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppSync.Inputs
{

    public sealed class DataSourceDynamodbConfigDeltaSyncConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The number of minutes that an Item is stored in the data source.
        /// </summary>
        [Input("baseTableTtl")]
        public Input<int>? BaseTableTtl { get; set; }

        /// <summary>
        /// The table name.
        /// </summary>
        [Input("deltaSyncTableName", required: true)]
        public Input<string> DeltaSyncTableName { get; set; } = null!;

        /// <summary>
        /// The number of minutes that a Delta Sync log entry is stored in the Delta Sync table.
        /// </summary>
        [Input("deltaSyncTableTtl")]
        public Input<int>? DeltaSyncTableTtl { get; set; }

        public DataSourceDynamodbConfigDeltaSyncConfigArgs()
        {
        }
        public static new DataSourceDynamodbConfigDeltaSyncConfigArgs Empty => new DataSourceDynamodbConfigDeltaSyncConfigArgs();
    }
}
