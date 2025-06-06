// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Outputs
{

    [OutputType]
    public sealed class GetClusterAccessConfigResult
    {
        /// <summary>
        /// Values returned are `CONFIG_MAP`, `API` or `API_AND_CONFIG_MAP`
        /// </summary>
        public readonly string AuthenticationMode;
        /// <summary>
        /// Default to `true`.
        /// </summary>
        public readonly bool BootstrapClusterCreatorAdminPermissions;

        [OutputConstructor]
        private GetClusterAccessConfigResult(
            string authenticationMode,

            bool bootstrapClusterCreatorAdminPermissions)
        {
            AuthenticationMode = authenticationMode;
            BootstrapClusterCreatorAdminPermissions = bootstrapClusterCreatorAdminPermissions;
        }
    }
}
