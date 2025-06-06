// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppFlow.Inputs
{

    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs : global::Pulumi.ResourceArgs
    {
        [Input("apiKey", required: true)]
        public Input<string> ApiKey { get; set; } = null!;

        [Input("secretKey", required: true)]
        private Input<string>? _secretKey;

        /// <summary>
        /// The Secret Access Key portion of the credentials.
        /// </summary>
        public Input<string>? SecretKey
        {
            get => _secretKey;
            set
            {
                var emptySecret = Output.CreateSecret(0);
                _secretKey = Output.Tuple<Input<string>?, int>(value, emptySecret).Apply(t => t.Item1);
            }
        }

        public ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs()
        {
        }
        public static new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs Empty => new ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitudeArgs();
    }
}
