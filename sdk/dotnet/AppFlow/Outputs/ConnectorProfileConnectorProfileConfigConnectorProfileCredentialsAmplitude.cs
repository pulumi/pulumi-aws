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
    public sealed class ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitude
    {
        public readonly string ApiKey;
        /// <summary>
        /// The Secret Access Key portion of the credentials.
        /// </summary>
        public readonly string SecretKey;

        [OutputConstructor]
        private ConnectorProfileConnectorProfileConfigConnectorProfileCredentialsAmplitude(
            string apiKey,

            string secretKey)
        {
            ApiKey = apiKey;
            SecretKey = secretKey;
        }
    }
}
