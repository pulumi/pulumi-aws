// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class DomainDefaultUserSettingsCanvasAppSettingsGenerativeAiSettings
    {
        public readonly string? AmazonBedrockRoleArn;

        [OutputConstructor]
        private DomainDefaultUserSettingsCanvasAppSettingsGenerativeAiSettings(string? amazonBedrockRoleArn)
        {
            AmazonBedrockRoleArn = amazonBedrockRoleArn;
        }
    }
}
