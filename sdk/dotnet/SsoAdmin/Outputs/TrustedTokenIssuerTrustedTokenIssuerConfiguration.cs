// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SsoAdmin.Outputs
{

    [OutputType]
    public sealed class TrustedTokenIssuerTrustedTokenIssuerConfiguration
    {
        /// <summary>
        /// A block that describes the settings for a trusted token issuer that works with OpenID Connect (OIDC) by using JSON Web Tokens (JWT). See Documented below below.
        /// </summary>
        public readonly Outputs.TrustedTokenIssuerTrustedTokenIssuerConfigurationOidcJwtConfiguration? OidcJwtConfiguration;

        [OutputConstructor]
        private TrustedTokenIssuerTrustedTokenIssuerConfiguration(Outputs.TrustedTokenIssuerTrustedTokenIssuerConfigurationOidcJwtConfiguration? oidcJwtConfiguration)
        {
            OidcJwtConfiguration = oidcJwtConfiguration;
        }
    }
}
