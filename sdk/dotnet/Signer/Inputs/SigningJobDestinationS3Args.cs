// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Signer.Inputs
{

    public sealed class SigningJobDestinationS3Args : global::Pulumi.ResourceArgs
    {
        [Input("bucket", required: true)]
        public Input<string> Bucket { get; set; } = null!;

        /// <summary>
        /// An Amazon S3 object key prefix that you can use to limit signed objects keys to begin with the specified prefix.
        /// </summary>
        [Input("prefix")]
        public Input<string>? Prefix { get; set; }

        public SigningJobDestinationS3Args()
        {
        }
        public static new SigningJobDestinationS3Args Empty => new SigningJobDestinationS3Args();
    }
}
