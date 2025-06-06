// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclLoggingConfigurationRedactedField
    {
        /// <summary>
        /// HTTP method to be redacted. It must be specified as an empty configuration block `{}`. The method indicates the type of operation that the request is asking the origin to perform.
        /// </summary>
        public readonly Outputs.WebAclLoggingConfigurationRedactedFieldMethod? Method;
        /// <summary>
        /// Whether to redact the query string. It must be specified as an empty configuration block `{}`. The query string is the part of a URL that appears after a `?` character, if any.
        /// </summary>
        public readonly Outputs.WebAclLoggingConfigurationRedactedFieldQueryString? QueryString;
        /// <summary>
        /// "single_header" refers to the redaction of a single header. For more information, please see the details below under Single Header.
        /// </summary>
        public readonly Outputs.WebAclLoggingConfigurationRedactedFieldSingleHeader? SingleHeader;
        /// <summary>
        /// Configuration block that redacts the request URI path. It should be specified as an empty configuration block `{}`. The URI path is the part of a web request that identifies a resource, such as `/images/daily-ad.jpg`.
        /// </summary>
        public readonly Outputs.WebAclLoggingConfigurationRedactedFieldUriPath? UriPath;

        [OutputConstructor]
        private WebAclLoggingConfigurationRedactedField(
            Outputs.WebAclLoggingConfigurationRedactedFieldMethod? method,

            Outputs.WebAclLoggingConfigurationRedactedFieldQueryString? queryString,

            Outputs.WebAclLoggingConfigurationRedactedFieldSingleHeader? singleHeader,

            Outputs.WebAclLoggingConfigurationRedactedFieldUriPath? uriPath)
        {
            Method = method;
            QueryString = queryString;
            SingleHeader = singleHeader;
            UriPath = uriPath;
        }
    }
}
