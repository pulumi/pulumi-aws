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
    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsHoneycode
    {
        public readonly string? AccessToken;
        public readonly Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsHoneycodeOauthRequest? OauthRequest;
        public readonly string? RefreshToken;

        [OutputConstructor]
        private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsHoneycode(
            string? accessToken,

            Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsHoneycodeOauthRequest? oauthRequest,

            string? refreshToken)
        {
            AccessToken = accessToken;
            OauthRequest = oauthRequest;
            RefreshToken = refreshToken;
        }
    }
}
