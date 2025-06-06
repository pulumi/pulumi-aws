// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppSync.Inputs
{

    public sealed class DataSourceDynamodbConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The DeltaSyncConfig for a versioned data source. See `delta_sync_config` Block for details.
        /// </summary>
        [Input("deltaSyncConfig")]
        public Input<Inputs.DataSourceDynamodbConfigDeltaSyncConfigGetArgs>? DeltaSyncConfig { get; set; }

        /// <summary>
        /// AWS region of the DynamoDB table. Defaults to current region.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        /// <summary>
        /// Name of the DynamoDB table.
        /// </summary>
        [Input("tableName", required: true)]
        public Input<string> TableName { get; set; } = null!;

        /// <summary>
        /// Set to `true` to use Amazon Cognito credentials with this data source.
        /// </summary>
        [Input("useCallerCredentials")]
        public Input<bool>? UseCallerCredentials { get; set; }

        /// <summary>
        /// Detects Conflict Detection and Resolution with this data source.
        /// </summary>
        [Input("versioned")]
        public Input<bool>? Versioned { get; set; }

        public DataSourceDynamodbConfigGetArgs()
        {
        }
        public static new DataSourceDynamodbConfigGetArgs Empty => new DataSourceDynamodbConfigGetArgs();
    }
}
