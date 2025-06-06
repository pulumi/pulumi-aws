// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Inputs
{

    public sealed class TopicRuleErrorActionTimestreamTimestampArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The precision of the timestamp value that results from the expression described in value. Valid values: `SECONDS`, `MILLISECONDS`, `MICROSECONDS`, `NANOSECONDS`.
        /// </summary>
        [Input("unit", required: true)]
        public Input<string> Unit { get; set; } = null!;

        /// <summary>
        /// An expression that returns a long epoch time value.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public TopicRuleErrorActionTimestreamTimestampArgs()
        {
        }
        public static new TopicRuleErrorActionTimestreamTimestampArgs Empty => new TopicRuleErrorActionTimestreamTimestampArgs();
    }
}
