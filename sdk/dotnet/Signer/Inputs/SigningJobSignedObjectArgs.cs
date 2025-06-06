// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Signer.Inputs
{

    public sealed class SigningJobSignedObjectArgs : global::Pulumi.ResourceArgs
    {
        [Input("s3s")]
        private InputList<Inputs.SigningJobSignedObjectS3Args>? _s3s;
        public InputList<Inputs.SigningJobSignedObjectS3Args> S3s
        {
            get => _s3s ?? (_s3s = new InputList<Inputs.SigningJobSignedObjectS3Args>());
            set => _s3s = value;
        }

        public SigningJobSignedObjectArgs()
        {
        }
        public static new SigningJobSignedObjectArgs Empty => new SigningJobSignedObjectArgs();
    }
}
