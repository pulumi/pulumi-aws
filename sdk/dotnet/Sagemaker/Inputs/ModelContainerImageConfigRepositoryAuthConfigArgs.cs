// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class ModelContainerImageConfigRepositoryAuthConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of an AWS Lambda function that provides credentials to authenticate to the private Docker registry where your model image is hosted. For information about how to create an AWS Lambda function, see [Create a Lambda function with the console](https://docs.aws.amazon.com/lambda/latest/dg/getting-started-create-function.html) in the _AWS Lambda Developer Guide_.
        /// </summary>
        [Input("repositoryCredentialsProviderArn", required: true)]
        public Input<string> RepositoryCredentialsProviderArn { get; set; } = null!;

        public ModelContainerImageConfigRepositoryAuthConfigArgs()
        {
        }
        public static new ModelContainerImageConfigRepositoryAuthConfigArgs Empty => new ModelContainerImageConfigRepositoryAuthConfigArgs();
    }
}
