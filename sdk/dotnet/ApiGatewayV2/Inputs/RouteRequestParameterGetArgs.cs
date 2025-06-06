// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ApiGatewayV2.Inputs
{

    public sealed class RouteRequestParameterGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Request parameter key. This is a [request data mapping parameter](https://docs.aws.amazon.com/apigateway/latest/developerguide/websocket-api-data-mapping.html#websocket-mapping-request-parameters).
        /// </summary>
        [Input("requestParameterKey", required: true)]
        public Input<string> RequestParameterKey { get; set; } = null!;

        /// <summary>
        /// Boolean whether or not the parameter is required.
        /// </summary>
        [Input("required", required: true)]
        public Input<bool> Required { get; set; } = null!;

        public RouteRequestParameterGetArgs()
        {
        }
        public static new RouteRequestParameterGetArgs Empty => new RouteRequestParameterGetArgs();
    }
}
