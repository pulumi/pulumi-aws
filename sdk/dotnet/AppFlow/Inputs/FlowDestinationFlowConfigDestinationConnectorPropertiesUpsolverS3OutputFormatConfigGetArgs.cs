// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Aggregation settings that you can use to customize the output format of your flow data. See Aggregation Config for more details.
        /// </summary>
        [Input("aggregationConfig")]
        public Input<Inputs.FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigAggregationConfigGetArgs>? AggregationConfig { get; set; }

        /// <summary>
        /// File type that Amazon AppFlow places in the Amazon S3 bucket. Valid values are `CSV`, `JSON`, and `PARQUET`.
        /// </summary>
        [Input("fileType")]
        public Input<string>? FileType { get; set; }

        /// <summary>
        /// Determines the prefix that Amazon AppFlow applies to the folder name in the Amazon S3 bucket. You can name folders according to the flow frequency and date. See Prefix Config for more details.
        /// </summary>
        [Input("prefixConfig", required: true)]
        public Input<Inputs.FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigPrefixConfigGetArgs> PrefixConfig { get; set; } = null!;

        public FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigGetArgs()
        {
        }
        public static new FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigGetArgs Empty => new FlowDestinationFlowConfigDestinationConnectorPropertiesUpsolverS3OutputFormatConfigGetArgs();
    }
}
