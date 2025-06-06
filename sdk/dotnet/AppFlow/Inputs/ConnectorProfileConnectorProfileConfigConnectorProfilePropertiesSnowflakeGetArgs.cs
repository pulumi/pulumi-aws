// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSnowflakeGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The name of the account.
        /// </summary>
        [Input("accountName")]
        public Input<string>? AccountName { get; set; }

        [Input("bucketName", required: true)]
        public Input<string> BucketName { get; set; } = null!;

        [Input("bucketPrefix")]
        public Input<string>? BucketPrefix { get; set; }

        [Input("privateLinkServiceName")]
        public Input<string>? PrivateLinkServiceName { get; set; }

        /// <summary>
        /// AWS Region of the Snowflake account.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        /// <summary>
        /// Name of the Amazon S3 stage that was created while setting up an Amazon S3 stage in the Snowflake account. This is written in the following format: `&lt;Database&gt;.&lt;Schema&gt;.&lt;Stage Name&gt;`.
        /// </summary>
        [Input("stage", required: true)]
        public Input<string> Stage { get; set; } = null!;

        /// <summary>
        /// The name of the Snowflake warehouse.
        /// </summary>
        [Input("warehouse", required: true)]
        public Input<string> Warehouse { get; set; } = null!;

        public ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSnowflakeGetArgs()
        {
        }
        public static new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSnowflakeGetArgs Empty => new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSnowflakeGetArgs();
    }
}
