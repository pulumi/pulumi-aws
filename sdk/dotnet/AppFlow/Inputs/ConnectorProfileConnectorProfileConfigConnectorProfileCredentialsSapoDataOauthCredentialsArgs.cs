// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsSapoDataOauthCredentialsArgs : global::Pulumi.ResourceArgs
    {
        [Input("accessToken")]
        private Input<string>? _accessToken;
        public Input<string>? AccessToken
        {
            get => _accessToken;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _accessToken = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        [Input("clientId", required: true)]
        public Input<string> ClientId { get; set; } = null!;

        [Input("clientSecret", required: true)]
        public Input<string> ClientSecret { get; set; } = null!;

        [Input("oauthRequest")]
        public Input<Inputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsSapoDataOauthCredentialsOauthRequestArgs>? OauthRequest { get; set; }

        [Input("refreshToken")]
        public Input<string>? RefreshToken { get; set; }

        public ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsSapoDataOauthCredentialsArgs()
        {
        }
        public static new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsSapoDataOauthCredentialsArgs Empty => new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsSapoDataOauthCredentialsArgs();
    }
}
