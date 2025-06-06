// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Inputs
{

    public sealed class BucketWebsiteConfigurationV2RoutingRuleRedirectGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Host name to use in the redirect request.
        /// </summary>
        [Input("hostName")]
        public Input<string>? HostName { get; set; }

        /// <summary>
        /// HTTP redirect code to use on the response.
        /// </summary>
        [Input("httpRedirectCode")]
        public Input<string>? HttpRedirectCode { get; set; }

        /// <summary>
        /// Protocol to use when redirecting requests. The default is the protocol that is used in the original request. Valid values: `http`, `https`.
        /// </summary>
        [Input("protocol")]
        public Input<string>? Protocol { get; set; }

        /// <summary>
        /// Object key prefix to use in the redirect request. For example, to redirect requests for all pages with prefix `docs/` (objects in the `docs/` folder) to `documents/`, you can set a `condition` block with `key_prefix_equals` set to `docs/` and in the `redirect` set `replace_key_prefix_with` to `/documents`.
        /// </summary>
        [Input("replaceKeyPrefixWith")]
        public Input<string>? ReplaceKeyPrefixWith { get; set; }

        /// <summary>
        /// Specific object key to use in the redirect request. For example, redirect request to `error.html`.
        /// </summary>
        [Input("replaceKeyWith")]
        public Input<string>? ReplaceKeyWith { get; set; }

        public BucketWebsiteConfigurationV2RoutingRuleRedirectGetArgs()
        {
        }
        public static new BucketWebsiteConfigurationV2RoutingRuleRedirectGetArgs Empty => new BucketWebsiteConfigurationV2RoutingRuleRedirectGetArgs();
    }
}
