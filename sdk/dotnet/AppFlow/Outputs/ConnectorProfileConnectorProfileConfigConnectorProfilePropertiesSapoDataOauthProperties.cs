// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Outputs
{

    [OutputType]
    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthProperties
    {
        /// <summary>
        /// The authorization code url required to redirect to SAP Login Page to fetch authorization code for OAuth type authentication.
        /// </summary>
        public readonly string AuthCodeUrl;
        /// <summary>
        /// The OAuth scopes required for OAuth type authentication.
        /// </summary>
        public readonly ImmutableArray<string> OauthScopes;
        public readonly string TokenUrl;

        [OutputConstructor]
        private ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesSapoDataOauthProperties(
            string authCodeUrl,

            ImmutableArray<string> oauthScopes,

            string tokenUrl)
        {
            AuthCodeUrl = authCodeUrl;
            OauthScopes = oauthScopes;
            TokenUrl = tokenUrl;
        }
    }
}
