// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class EndpointConfigurationAsyncInferenceConfigClientConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The maximum number of concurrent requests sent by the SageMaker AI client to the model container. If no value is provided, Amazon SageMaker AI will choose an optimal value for you.
        /// </summary>
        [Input("maxConcurrentInvocationsPerInstance")]
        public Input<int>? MaxConcurrentInvocationsPerInstance { get; set; }

        public EndpointConfigurationAsyncInferenceConfigClientConfigGetArgs()
        {
        }
        public static new EndpointConfigurationAsyncInferenceConfigClientConfigGetArgs Empty => new EndpointConfigurationAsyncInferenceConfigClientConfigGetArgs();
    }
}
