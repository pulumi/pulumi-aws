// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito.Outputs
{

    [OutputType]
    public sealed class ManagedUserPoolClientTokenValidityUnits
    {
        /// <summary>
        /// Time unit for the value in `access_token_validity` and defaults to `hours`.
        /// </summary>
        public readonly string? AccessToken;
        /// <summary>
        /// Time unit for the value in `id_token_validity`, and it defaults to `hours`.
        /// </summary>
        public readonly string? IdToken;
        /// <summary>
        /// Time unit for the value in `refresh_token_validity` and defaults to `days`.
        /// </summary>
        public readonly string? RefreshToken;

        [OutputConstructor]
        private ManagedUserPoolClientTokenValidityUnits(
            string? accessToken,

            string? idToken,

            string? refreshToken)
        {
            AccessToken = accessToken;
            IdToken = idToken;
            RefreshToken = refreshToken;
        }
    }
}
