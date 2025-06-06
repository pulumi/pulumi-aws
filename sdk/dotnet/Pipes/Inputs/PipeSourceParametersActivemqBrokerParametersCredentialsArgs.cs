// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeSourceParametersActivemqBrokerParametersCredentialsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ARN of the Secrets Manager secret containing the credentials.
        /// </summary>
        [Input("basicAuth", required: true)]
        public Input<string> BasicAuth { get; set; } = null!;

        public PipeSourceParametersActivemqBrokerParametersCredentialsArgs()
        {
        }
        public static new PipeSourceParametersActivemqBrokerParametersCredentialsArgs Empty => new PipeSourceParametersActivemqBrokerParametersCredentialsArgs();
    }
}
