// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Signer.Inputs
{

    public sealed class SigningJobDestinationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A configuration block describing the S3 Destination object: See S3 Destination below for details.
        /// </summary>
        [Input("s3", required: true)]
        public Input<Inputs.SigningJobDestinationS3GetArgs> S3 { get; set; } = null!;

        public SigningJobDestinationGetArgs()
        {
        }
        public static new SigningJobDestinationGetArgs Empty => new SigningJobDestinationGetArgs();
    }
}
