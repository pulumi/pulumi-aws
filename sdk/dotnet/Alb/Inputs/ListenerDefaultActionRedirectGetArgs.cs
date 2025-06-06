// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Alb.Inputs
{

    public sealed class ListenerDefaultActionRedirectGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Hostname. This component is not percent-encoded. The hostname can contain `#{host}`. Defaults to `#{host}`.
        /// </summary>
        [Input("host")]
        public Input<string>? Host { get; set; }

        /// <summary>
        /// Absolute path, starting with the leading "/". This component is not percent-encoded. The path can contain #{host}, #{path}, and #{port}. Defaults to `/#{path}`.
        /// </summary>
        [Input("path")]
        public Input<string>? Path { get; set; }

        /// <summary>
        /// Port. Specify a value from `1` to `65535` or `#{port}`. Defaults to `#{port}`.
        /// </summary>
        [Input("port")]
        public Input<string>? Port { get; set; }

        /// <summary>
        /// Protocol. Valid values are `HTTP`, `HTTPS`, or `#{protocol}`. Defaults to `#{protocol}`.
        /// </summary>
        [Input("protocol")]
        public Input<string>? Protocol { get; set; }

        /// <summary>
        /// Query parameters, URL-encoded when necessary, but not percent-encoded. Do not include the leading "?". Defaults to `#{query}`.
        /// </summary>
        [Input("query")]
        public Input<string>? Query { get; set; }

        /// <summary>
        /// HTTP redirect code. The redirect is either permanent (`HTTP_301`) or temporary (`HTTP_302`).
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("statusCode", required: true)]
        public Input<string> StatusCode { get; set; } = null!;

        public ListenerDefaultActionRedirectGetArgs()
        {
        }
        public static new ListenerDefaultActionRedirectGetArgs Empty => new ListenerDefaultActionRedirectGetArgs();
    }
}
