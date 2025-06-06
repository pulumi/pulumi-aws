// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Outputs
{

    [OutputType]
    public sealed class GetResponseHeadersPolicyCustomHeadersConfigItemResult
    {
        /// <summary>
        /// The HTTP header name.
        /// </summary>
        public readonly string Header;
        /// <summary>
        /// Whether CloudFront overrides the X-XSS-Protection HTTP response header received from the origin with the one specified in this response headers policy.
        /// </summary>
        public readonly bool Override;
        /// <summary>
        /// Value for the HTTP response header.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private GetResponseHeadersPolicyCustomHeadersConfigItemResult(
            string header,

            bool @override,

            string value)
        {
            Header = header;
            Override = @override;
            Value = value;
        }
    }
}
