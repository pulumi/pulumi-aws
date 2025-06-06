// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class CustomModelValidationDataConfigValidator
    {
        /// <summary>
        /// The S3 URI where the validation data is stored.
        /// </summary>
        public readonly string S3Uri;

        [OutputConstructor]
        private CustomModelValidationDataConfigValidator(string s3Uri)
        {
            S3Uri = s3Uri;
        }
    }
}
