// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito.Inputs
{

    public sealed class UserPoolLambdaConfigPreTokenGenerationConfigGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("lambdaArn", required: true)]
        public Input<string> LambdaArn { get; set; } = null!;

        [Input("lambdaVersion", required: true)]
        public Input<string> LambdaVersion { get; set; } = null!;

        public UserPoolLambdaConfigPreTokenGenerationConfigGetArgs()
        {
        }
        public static new UserPoolLambdaConfigPreTokenGenerationConfigGetArgs Empty => new UserPoolLambdaConfigPreTokenGenerationConfigGetArgs();
    }
}
