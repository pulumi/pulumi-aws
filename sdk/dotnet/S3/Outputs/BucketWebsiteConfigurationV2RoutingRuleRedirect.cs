// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3.Outputs
{

    [OutputType]
    public sealed class BucketWebsiteConfigurationV2RoutingRuleRedirect
    {
        /// <summary>
        /// Host name to use in the redirect request.
        /// </summary>
        public readonly string? HostName;
        /// <summary>
        /// HTTP redirect code to use on the response.
        /// </summary>
        public readonly string? HttpRedirectCode;
        /// <summary>
        /// Protocol to use when redirecting requests. The default is the protocol that is used in the original request. Valid values: `http`, `https`.
        /// </summary>
        public readonly string? Protocol;
        /// <summary>
        /// Object key prefix to use in the redirect request. For example, to redirect requests for all pages with prefix `docs/` (objects in the `docs/` folder) to `documents/`, you can set a `condition` block with `key_prefix_equals` set to `docs/` and in the `redirect` set `replace_key_prefix_with` to `/documents`.
        /// </summary>
        public readonly string? ReplaceKeyPrefixWith;
        /// <summary>
        /// Specific object key to use in the redirect request. For example, redirect request to `error.html`.
        /// </summary>
        public readonly string? ReplaceKeyWith;

        [OutputConstructor]
        private BucketWebsiteConfigurationV2RoutingRuleRedirect(
            string? hostName,

            string? httpRedirectCode,

            string? protocol,

            string? replaceKeyPrefixWith,

            string? replaceKeyWith)
        {
            HostName = hostName;
            HttpRedirectCode = httpRedirectCode;
            Protocol = protocol;
            ReplaceKeyPrefixWith = replaceKeyPrefixWith;
            ReplaceKeyWith = replaceKeyWith;
        }
    }
}
