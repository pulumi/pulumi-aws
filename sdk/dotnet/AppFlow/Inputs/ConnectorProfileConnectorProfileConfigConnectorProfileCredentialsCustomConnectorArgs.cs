// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorArgs : global::Pulumi.ResourceArgs
    {
        [Input("apiKey")]
        public Input<Inputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorApiKeyArgs>? ApiKey { get; set; }

        /// <summary>
        /// The authentication type that the custom connector uses for authenticating while creating a connector profile. One of: `APIKEY`, `BASIC`, `CUSTOM`, `OAUTH2`.
        /// </summary>
        [Input("authenticationType", required: true)]
        public Input<string> AuthenticationType { get; set; } = null!;

        /// <summary>
        /// Basic credentials that are required for the authentication of the user.
        /// </summary>
        [Input("basic")]
        public Input<Inputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorBasicArgs>? Basic { get; set; }

        /// <summary>
        /// If the connector uses the custom authentication mechanism, this holds the required credentials.
        /// </summary>
        [Input("custom")]
        public Input<Inputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorCustomArgs>? Custom { get; set; }

        /// <summary>
        /// OAuth 2.0 credentials required for the authentication of the user.
        /// </summary>
        [Input("oauth2")]
        public Input<Inputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorOauth2Args>? Oauth2 { get; set; }

        public ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorArgs()
        {
        }
        public static new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorArgs Empty => new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorArgs();
    }
}
