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
    public sealed class DomainDefaultUserSettingsRStudioServerProAppSettings
    {
        /// <summary>
        /// Indicates whether the current user has access to the RStudioServerPro app. Valid values are `ENABLED` and `DISABLED`.
        /// </summary>
        public readonly string? AccessStatus;
        /// <summary>
        /// The level of permissions that the user has within the RStudioServerPro app. This value defaults to `R_STUDIO_USER`. The `R_STUDIO_ADMIN` value allows the user access to the RStudio Administrative Dashboard. Valid values are `R_STUDIO_USER` and `R_STUDIO_ADMIN`.
        /// </summary>
        public readonly string? UserGroup;

        [OutputConstructor]
        private DomainDefaultUserSettingsRStudioServerProAppSettings(
            string? accessStatus,

            string? userGroup)
        {
            AccessStatus = accessStatus;
            UserGroup = userGroup;
        }
    }
}
