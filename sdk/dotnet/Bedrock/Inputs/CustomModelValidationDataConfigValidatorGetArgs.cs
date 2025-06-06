// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class CustomModelValidationDataConfigValidatorGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The S3 URI where the validation data is stored.
        /// </summary>
        [Input("s3Uri", required: true)]
        public Input<string> S3Uri { get; set; } = null!;

        public CustomModelValidationDataConfigValidatorGetArgs()
        {
        }
        public static new CustomModelValidationDataConfigValidatorGetArgs Empty => new CustomModelValidationDataConfigValidatorGetArgs();
    }
}
