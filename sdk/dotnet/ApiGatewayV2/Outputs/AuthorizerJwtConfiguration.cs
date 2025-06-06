// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ApiGatewayV2.Outputs
{

    [OutputType]
    public sealed class AuthorizerJwtConfiguration
    {
        /// <summary>
        /// List of the intended recipients of the JWT. A valid JWT must provide an aud that matches at least one entry in this list.
        /// </summary>
        public readonly ImmutableArray<string> Audiences;
        /// <summary>
        /// Base domain of the identity provider that issues JSON Web Tokens, such as the `endpoint` attribute of the `aws.cognito.UserPool` resource.
        /// </summary>
        public readonly string? Issuer;

        [OutputConstructor]
        private AuthorizerJwtConfiguration(
            ImmutableArray<string> audiences,

            string? issuer)
        {
            Audiences = audiences;
            Issuer = issuer;
        }
    }
}
