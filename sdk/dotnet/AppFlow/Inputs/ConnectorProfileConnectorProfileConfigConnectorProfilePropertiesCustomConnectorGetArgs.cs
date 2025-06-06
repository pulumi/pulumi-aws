// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesCustomConnectorGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The OAuth 2.0 properties required for OAuth 2.0 authentication.
        /// </summary>
        [Input("oauth2Properties")]
        public Input<Inputs.ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesCustomConnectorOauth2PropertiesGetArgs>? Oauth2Properties { get; set; }

        [Input("profileProperties")]
        private InputMap<string>? _profileProperties;

        /// <summary>
        /// A map of properties that are required to create a profile for the custom connector.
        /// </summary>
        public InputMap<string> ProfileProperties
        {
            get => _profileProperties ?? (_profileProperties = new InputMap<string>());
            set => _profileProperties = value;
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesCustomConnectorGetArgs()
        {
        }
        public static new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesCustomConnectorGetArgs Empty => new ConnectorProfileConnectorProfileConfigConnectorProfilePropertiesCustomConnectorGetArgs();
    }
}
