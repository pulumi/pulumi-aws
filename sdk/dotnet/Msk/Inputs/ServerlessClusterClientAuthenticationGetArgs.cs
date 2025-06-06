// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Msk.Inputs
{

    public sealed class ServerlessClusterClientAuthenticationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Details for client authentication using SASL. See below.
        /// </summary>
        [Input("sasl", required: true)]
        public Input<Inputs.ServerlessClusterClientAuthenticationSaslGetArgs> Sasl { get; set; } = null!;

        public ServerlessClusterClientAuthenticationGetArgs()
        {
        }
        public static new ServerlessClusterClientAuthenticationGetArgs Empty => new ServerlessClusterClientAuthenticationGetArgs();
    }
}
