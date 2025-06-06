// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppSync.Inputs
{

    public sealed class DataSourceLambdaConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// ARN for the Lambda function.
        /// </summary>
        [Input("functionArn", required: true)]
        public Input<string> FunctionArn { get; set; } = null!;

        public DataSourceLambdaConfigArgs()
        {
        }
        public static new DataSourceLambdaConfigArgs Empty => new DataSourceLambdaConfigArgs();
    }
}
