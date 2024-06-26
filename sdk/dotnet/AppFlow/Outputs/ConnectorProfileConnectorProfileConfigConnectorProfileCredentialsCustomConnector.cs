// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Outputs
{

    [OutputType]
    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnector
    {
        public readonly Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorApiKey? ApiKey;
        public readonly string AuthenticationType;
        public readonly Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorBasic? Basic;
        public readonly Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorCustom? Custom;
        public readonly Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorOauth2? Oauth2;

        [OutputConstructor]
        private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnector(
            Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorApiKey? apiKey,

            string authenticationType,

            Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorBasic? basic,

            Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorCustom? custom,

            Outputs.ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsCustomConnectorOauth2? oauth2)
        {
            ApiKey = apiKey;
            AuthenticationType = authenticationType;
            Basic = basic;
            Custom = custom;
            Oauth2 = oauth2;
        }
    }
}
