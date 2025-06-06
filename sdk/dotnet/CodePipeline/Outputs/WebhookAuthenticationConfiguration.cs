// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Outputs
{

    [OutputType]
    public sealed class WebhookAuthenticationConfiguration
    {
        /// <summary>
        /// A valid CIDR block for `IP` filtering. Required for `IP`.
        /// </summary>
        public readonly string? AllowedIpRange;
        /// <summary>
        /// The shared secret for the GitHub repository webhook. Set this as `secret` in your `github_repository_webhook`'s `configuration` block. Required for `GITHUB_HMAC`.
        /// </summary>
        public readonly string? SecretToken;

        [OutputConstructor]
        private WebhookAuthenticationConfiguration(
            string? allowedIpRange,

            string? secretToken)
        {
            AllowedIpRange = allowedIpRange;
            SecretToken = secretToken;
        }
    }
}
