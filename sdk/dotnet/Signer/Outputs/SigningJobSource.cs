// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Signer.Outputs
{

    [OutputType]
    public sealed class SigningJobSource
    {
        /// <summary>
        /// A configuration block describing the S3 Source object: See S3 Source below for details.
        /// </summary>
        public readonly Outputs.SigningJobSourceS3 S3;

        [OutputConstructor]
        private SigningJobSource(Outputs.SigningJobSourceS3 s3)
        {
            S3 = s3;
        }
    }
}
