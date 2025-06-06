// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GlobalAccelerator.Inputs
{

    public sealed class CustomRoutingAcceleratorAttributesArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Indicates whether flow logs are enabled. Defaults to `false`. Valid values: `true`, `false`.
        /// </summary>
        [Input("flowLogsEnabled")]
        public Input<bool>? FlowLogsEnabled { get; set; }

        /// <summary>
        /// The name of the Amazon S3 bucket for the flow logs. Required if `flow_logs_enabled` is `true`.
        /// </summary>
        [Input("flowLogsS3Bucket")]
        public Input<string>? FlowLogsS3Bucket { get; set; }

        /// <summary>
        /// The prefix for the location in the Amazon S3 bucket for the flow logs. Required if `flow_logs_enabled` is `true`.
        /// </summary>
        [Input("flowLogsS3Prefix")]
        public Input<string>? FlowLogsS3Prefix { get; set; }

        public CustomRoutingAcceleratorAttributesArgs()
        {
        }
        public static new CustomRoutingAcceleratorAttributesArgs Empty => new CustomRoutingAcceleratorAttributesArgs();
    }
}
