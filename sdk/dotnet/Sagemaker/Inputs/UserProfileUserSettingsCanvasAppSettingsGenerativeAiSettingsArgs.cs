// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class UserProfileUserSettingsCanvasAppSettingsGenerativeAiSettingsArgs : global::Pulumi.ResourceArgs
    {
        [Input("amazonBedrockRoleArn")]
        public Input<string>? AmazonBedrockRoleArn { get; set; }

        public UserProfileUserSettingsCanvasAppSettingsGenerativeAiSettingsArgs()
        {
        }
        public static new UserProfileUserSettingsCanvasAppSettingsGenerativeAiSettingsArgs Empty => new UserProfileUserSettingsCanvasAppSettingsGenerativeAiSettingsArgs();
    }
}
