// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Outputs
{

    [OutputType]
    public sealed class TopicRuleErrorActionTimestream
    {
        /// <summary>
        /// The name of an Amazon Timestream database.
        /// </summary>
        public readonly string DatabaseName;
        /// <summary>
        /// Configuration blocks with metadata attributes of the time series that are written in each measure record. Nested arguments below.
        /// </summary>
        public readonly ImmutableArray<Outputs.TopicRuleErrorActionTimestreamDimension> Dimensions;
        /// <summary>
        /// The ARN of the role that grants permission to write to the Amazon Timestream database table.
        /// </summary>
        public readonly string RoleArn;
        /// <summary>
        /// The name of the database table into which to write the measure records.
        /// </summary>
        public readonly string TableName;
        /// <summary>
        /// Configuration block specifying an application-defined value to replace the default value assigned to the Timestream record's timestamp in the time column. Nested arguments below.
        /// </summary>
        public readonly Outputs.TopicRuleErrorActionTimestreamTimestamp? Timestamp;

        [OutputConstructor]
        private TopicRuleErrorActionTimestream(
            string databaseName,

            ImmutableArray<Outputs.TopicRuleErrorActionTimestreamDimension> dimensions,

            string roleArn,

            string tableName,

            Outputs.TopicRuleErrorActionTimestreamTimestamp? timestamp)
        {
            DatabaseName = databaseName;
            Dimensions = dimensions;
            RoleArn = roleArn;
            TableName = tableName;
            Timestamp = timestamp;
        }
    }
}
