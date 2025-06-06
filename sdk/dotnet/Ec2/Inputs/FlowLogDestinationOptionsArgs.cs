// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class FlowLogDestinationOptionsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The format for the flow log. Default value: `plain-text`. Valid values: `plain-text`, `parquet`.
        /// </summary>
        [Input("fileFormat")]
        public Input<string>? FileFormat { get; set; }

        /// <summary>
        /// Indicates whether to use Hive-compatible prefixes for flow logs stored in Amazon S3. Default value: `false`.
        /// </summary>
        [Input("hiveCompatiblePartitions")]
        public Input<bool>? HiveCompatiblePartitions { get; set; }

        /// <summary>
        /// Indicates whether to partition the flow log per hour. This reduces the cost and response time for queries. Default value: `false`.
        /// </summary>
        [Input("perHourPartition")]
        public Input<bool>? PerHourPartition { get; set; }

        public FlowLogDestinationOptionsArgs()
        {
        }
        public static new FlowLogDestinationOptionsArgs Empty => new FlowLogDestinationOptionsArgs();
    }
}
