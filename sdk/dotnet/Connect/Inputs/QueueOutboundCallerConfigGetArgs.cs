// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect.Inputs
{

    public sealed class QueueOutboundCallerConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies the caller ID name.
        /// </summary>
        [Input("outboundCallerIdName")]
        public Input<string>? OutboundCallerIdName { get; set; }

        /// <summary>
        /// Specifies the caller ID number.
        /// </summary>
        [Input("outboundCallerIdNumberId")]
        public Input<string>? OutboundCallerIdNumberId { get; set; }

        /// <summary>
        /// Specifies outbound whisper flow to be used during an outbound call.
        /// </summary>
        [Input("outboundFlowId")]
        public Input<string>? OutboundFlowId { get; set; }

        public QueueOutboundCallerConfigGetArgs()
        {
        }
        public static new QueueOutboundCallerConfigGetArgs Empty => new QueueOutboundCallerConfigGetArgs();
    }
}
