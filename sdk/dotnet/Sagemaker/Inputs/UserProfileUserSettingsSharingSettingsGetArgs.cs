// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class UserProfileUserSettingsSharingSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether to include the notebook cell output when sharing the notebook. The default is `Disabled`. Valid values are `Allowed` and `Disabled`.
        /// </summary>
        [Input("notebookOutputOption")]
        public Input<string>? NotebookOutputOption { get; set; }

        /// <summary>
        /// When `notebook_output_option` is Allowed, the AWS Key Management Service (KMS) encryption key ID used to encrypt the notebook cell output in the Amazon S3 bucket.
        /// </summary>
        [Input("s3KmsKeyId")]
        public Input<string>? S3KmsKeyId { get; set; }

        /// <summary>
        /// When `notebook_output_option` is Allowed, the Amazon S3 bucket used to save the notebook cell output.
        /// </summary>
        [Input("s3OutputPath")]
        public Input<string>? S3OutputPath { get; set; }

        public UserProfileUserSettingsSharingSettingsGetArgs()
        {
        }
        public static new UserProfileUserSettingsSharingSettingsGetArgs Empty => new UserProfileUserSettingsSharingSettingsGetArgs();
    }
}
