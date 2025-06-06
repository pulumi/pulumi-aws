// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Inputs
{

    public sealed class ResponseHeadersPolicyServerTimingHeadersConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A Whether CloudFront adds the `Server-Timing` header to HTTP responses that it sends in response to requests that match a cache behavior that's associated with this response headers policy.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        /// <summary>
        /// A number 0–100 (inclusive) that specifies the percentage of responses that you want CloudFront to add the Server-Timing header to. Valid range: Minimum value of 0.0. Maximum value of 100.0.
        /// </summary>
        [Input("samplingRate", required: true)]
        public Input<double> SamplingRate { get; set; } = null!;

        public ResponseHeadersPolicyServerTimingHeadersConfigArgs()
        {
        }
        public static new ResponseHeadersPolicyServerTimingHeadersConfigArgs Empty => new ResponseHeadersPolicyServerTimingHeadersConfigArgs();
    }
}
