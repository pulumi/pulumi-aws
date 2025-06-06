// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LB.Inputs
{

    public sealed class GetListenerRuleActionRedirectInputArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The hostname.
        /// </summary>
        [Input("host", required: true)]
        public Input<string> Host { get; set; } = null!;

        /// <summary>
        /// The absolute path, starting with `/`.
        /// </summary>
        [Input("path", required: true)]
        public Input<string> Path { get; set; } = null!;

        /// <summary>
        /// The port.
        /// </summary>
        [Input("port", required: true)]
        public Input<string> Port { get; set; } = null!;

        /// <summary>
        /// The protocol.
        /// </summary>
        [Input("protocol", required: true)]
        public Input<string> Protocol { get; set; } = null!;

        /// <summary>
        /// The query parameters.
        /// </summary>
        [Input("query", required: true)]
        public Input<string> Query { get; set; } = null!;

        /// <summary>
        /// The HTTP redirect code.
        /// </summary>
        [Input("statusCode", required: true)]
        public Input<string> StatusCode { get; set; } = null!;

        public GetListenerRuleActionRedirectInputArgs()
        {
        }
        public static new GetListenerRuleActionRedirectInputArgs Empty => new GetListenerRuleActionRedirectInputArgs();
    }
}
