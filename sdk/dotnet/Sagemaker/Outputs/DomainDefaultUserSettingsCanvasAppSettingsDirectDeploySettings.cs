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
    public sealed class DomainDefaultUserSettingsCanvasAppSettingsDirectDeploySettings
    {
        /// <summary>
        /// Describes whether model deployment permissions are enabled or disabled in the Canvas application. Valid values are `ENABLED` and `DISABLED`.
        /// </summary>
        public readonly string? Status;

        [OutputConstructor]
        private DomainDefaultUserSettingsCanvasAppSettingsDirectDeploySettings(string? status)
        {
            Status = status;
        }
    }
}
