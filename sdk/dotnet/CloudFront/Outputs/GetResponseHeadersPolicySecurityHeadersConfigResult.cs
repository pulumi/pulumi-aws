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
    public sealed class GetResponseHeadersPolicySecurityHeadersConfigResult
    {
        /// <summary>
        /// The policy directives and their values that CloudFront includes as values for the Content-Security-Policy HTTP response header.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigContentSecurityPolicyResult> ContentSecurityPolicies;
        /// <summary>
        /// A setting that determines whether CloudFront includes the X-Content-Type-Options HTTP response header with its value set to nosniff. See Content Type Options for more information.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigContentTypeOptionResult> ContentTypeOptions;
        /// <summary>
        /// Setting that determines whether CloudFront includes the X-Frame-Options HTTP response header and the header’s value. See Frame Options for more information.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigFrameOptionResult> FrameOptions;
        /// <summary>
        /// Value of the Referrer-Policy HTTP response header. Valid Values: `no-referrer` | `no-referrer-when-downgrade` | `origin` | `origin-when-cross-origin` | `same-origin` | `strict-origin` | `strict-origin-when-cross-origin` | `unsafe-url`
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigReferrerPolicyResult> ReferrerPolicies;
        /// <summary>
        /// Settings that determine whether CloudFront includes the Strict-Transport-Security HTTP response header and the header’s value. See Strict Transport Security for more information.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigStrictTransportSecurityResult> StrictTransportSecurities;
        /// <summary>
        /// Settings that determine whether CloudFront includes the X-XSS-Protection HTTP response header and the header’s value. See XSS Protection for more information.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigXssProtectionResult> XssProtections;

        [OutputConstructor]
        private GetResponseHeadersPolicySecurityHeadersConfigResult(
            ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigContentSecurityPolicyResult> contentSecurityPolicies,

            ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigContentTypeOptionResult> contentTypeOptions,

            ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigFrameOptionResult> frameOptions,

            ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigReferrerPolicyResult> referrerPolicies,

            ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigStrictTransportSecurityResult> strictTransportSecurities,

            ImmutableArray<Outputs.GetResponseHeadersPolicySecurityHeadersConfigXssProtectionResult> xssProtections)
        {
            ContentSecurityPolicies = contentSecurityPolicies;
            ContentTypeOptions = contentTypeOptions;
            FrameOptions = frameOptions;
            ReferrerPolicies = referrerPolicies;
            StrictTransportSecurities = strictTransportSecurities;
            XssProtections = xssProtections;
        }
    }
}
