// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Inputs
{

    public sealed class DistributionOrderedCacheBehaviorForwardedValuesArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The forwarded values cookies that specifies how CloudFront handles cookies (maximum one).
        /// </summary>
        [Input("cookies", required: true)]
        public Input<Inputs.DistributionOrderedCacheBehaviorForwardedValuesCookiesArgs> Cookies { get; set; } = null!;

        [Input("headers")]
        private InputList<string>? _headers;

        /// <summary>
        /// Headers, if any, that you want CloudFront to vary upon for this cache behavior. Specify `*` to include all headers.
        /// </summary>
        public InputList<string> Headers
        {
            get => _headers ?? (_headers = new InputList<string>());
            set => _headers = value;
        }

        /// <summary>
        /// Indicates whether you want CloudFront to forward query strings to the origin that is associated with this cache behavior.
        /// </summary>
        [Input("queryString", required: true)]
        public Input<bool> QueryString { get; set; } = null!;

        [Input("queryStringCacheKeys")]
        private InputList<string>? _queryStringCacheKeys;

        /// <summary>
        /// When specified, along with a value of `true` for `query_string`, all query strings are forwarded, however only the query string keys listed in this argument are cached. When omitted with a value of `true` for `query_string`, all query string keys are cached.
        /// </summary>
        public InputList<string> QueryStringCacheKeys
        {
            get => _queryStringCacheKeys ?? (_queryStringCacheKeys = new InputList<string>());
            set => _queryStringCacheKeys = value;
        }

        public DistributionOrderedCacheBehaviorForwardedValuesArgs()
        {
        }
        public static new DistributionOrderedCacheBehaviorForwardedValuesArgs Empty => new DistributionOrderedCacheBehaviorForwardedValuesArgs();
    }
}
