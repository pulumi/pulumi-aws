// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Chime.Inputs
{

    public sealed class SdkvoiceSipMediaApplicationEndpointsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Valid Amazon Resource Name (ARN) of the Lambda function, version, or alias. The function must be created in the same AWS Region as the SIP media application.
        /// </summary>
        [Input("lambdaArn", required: true)]
        public Input<string> LambdaArn { get; set; } = null!;

        public SdkvoiceSipMediaApplicationEndpointsGetArgs()
        {
        }
        public static new SdkvoiceSipMediaApplicationEndpointsGetArgs Empty => new SdkvoiceSipMediaApplicationEndpointsGetArgs();
    }
}
