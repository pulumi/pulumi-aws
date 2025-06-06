// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Inputs
{

    public sealed class CachePolicyParametersInCacheKeyAndForwardedToOriginArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether any cookies in viewer requests are included in the cache key and automatically included in requests that CloudFront sends to the origin. See Cookies Config for more information.
        /// </summary>
        [Input("cookiesConfig", required: true)]
        public Input<Inputs.CachePolicyParametersInCacheKeyAndForwardedToOriginCookiesConfigArgs> CookiesConfig { get; set; } = null!;

        /// <summary>
        /// Flag determines whether the Accept-Encoding HTTP header is included in the cache key and in requests that CloudFront sends to the origin.
        /// </summary>
        [Input("enableAcceptEncodingBrotli")]
        public Input<bool>? EnableAcceptEncodingBrotli { get; set; }

        /// <summary>
        /// Whether the Accept-Encoding HTTP header is included in the cache key and in requests sent to the origin by CloudFront.
        /// </summary>
        [Input("enableAcceptEncodingGzip")]
        public Input<bool>? EnableAcceptEncodingGzip { get; set; }

        /// <summary>
        /// Whether any HTTP headers are included in the cache key and automatically included in requests that CloudFront sends to the origin. See Headers Config for more information.
        /// </summary>
        [Input("headersConfig", required: true)]
        public Input<Inputs.CachePolicyParametersInCacheKeyAndForwardedToOriginHeadersConfigArgs> HeadersConfig { get; set; } = null!;

        /// <summary>
        /// Whether any URL query strings in viewer requests are included in the cache key. It also automatically includes these query strings in requests that CloudFront sends to the origin. Please refer to the Query String Config for more information.
        /// </summary>
        [Input("queryStringsConfig", required: true)]
        public Input<Inputs.CachePolicyParametersInCacheKeyAndForwardedToOriginQueryStringsConfigArgs> QueryStringsConfig { get; set; } = null!;

        public CachePolicyParametersInCacheKeyAndForwardedToOriginArgs()
        {
        }
        public static new CachePolicyParametersInCacheKeyAndForwardedToOriginArgs Empty => new CachePolicyParametersInCacheKeyAndForwardedToOriginArgs();
    }
}
