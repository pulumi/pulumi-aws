// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Alb.Outputs
{

    [OutputType]
    public sealed class ListenerDefaultActionFixedResponse
    {
        /// <summary>
        /// Content type. Valid values are `text/plain`, `text/css`, `text/html`, `application/javascript` and `application/json`.
        /// 
        /// The following arguments are optional:
        /// </summary>
        public readonly string ContentType;
        /// <summary>
        /// Message body.
        /// </summary>
        public readonly string? MessageBody;
        /// <summary>
        /// HTTP response code. Valid values are `2XX`, `4XX`, or `5XX`.
        /// </summary>
        public readonly string? StatusCode;

        [OutputConstructor]
        private ListenerDefaultActionFixedResponse(
            string contentType,

            string? messageBody,

            string? statusCode)
        {
            ContentType = contentType;
            MessageBody = messageBody;
            StatusCode = statusCode;
        }
    }
}
