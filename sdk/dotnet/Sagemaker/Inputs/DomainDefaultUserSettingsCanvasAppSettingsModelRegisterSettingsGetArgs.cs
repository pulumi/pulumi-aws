// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DomainDefaultUserSettingsCanvasAppSettingsModelRegisterSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the SageMaker AI model registry account. Required only to register model versions created by a different SageMaker AI Canvas AWS account than the AWS account in which SageMaker AI model registry is set up.
        /// </summary>
        [Input("crossAccountModelRegisterRoleArn")]
        public Input<string>? CrossAccountModelRegisterRoleArn { get; set; }

        /// <summary>
        /// Describes whether the integration to the model registry is enabled or disabled in the Canvas application. Valid values are `ENABLED` and `DISABLED`.
        /// </summary>
        [Input("status")]
        public Input<string>? Status { get; set; }

        public DomainDefaultUserSettingsCanvasAppSettingsModelRegisterSettingsGetArgs()
        {
        }
        public static new DomainDefaultUserSettingsCanvasAppSettingsModelRegisterSettingsGetArgs Empty => new DomainDefaultUserSettingsCanvasAppSettingsModelRegisterSettingsGetArgs();
    }
}
