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
    public sealed class GetListenerDefaultActionRedirectResult
    {
        public readonly string Host;
        public readonly string Path;
        /// <summary>
        /// Port of the listener. Required if `arn` is not set.
        /// </summary>
        public readonly string Port;
        public readonly string Protocol;
        public readonly string Query;
        public readonly string StatusCode;

        [OutputConstructor]
        private GetListenerDefaultActionRedirectResult(
            string host,

            string path,

            string port,

            string protocol,

            string query,

            string statusCode)
        {
            Host = host;
            Path = path;
            Port = port;
            Protocol = protocol;
            Query = query;
            StatusCode = statusCode;
        }
    }
}
