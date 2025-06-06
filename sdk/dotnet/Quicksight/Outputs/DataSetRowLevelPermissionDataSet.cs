// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Outputs
{

    [OutputType]
    public sealed class DataSetRowLevelPermissionDataSet
    {
        /// <summary>
        /// ARN of the dataset that contains permissions for RLS.
        /// </summary>
        public readonly string Arn;
        /// <summary>
        /// User or group rules associated with the dataset that contains permissions for RLS.
        /// </summary>
        public readonly string? FormatVersion;
        /// <summary>
        /// Namespace associated with the dataset that contains permissions for RLS.
        /// </summary>
        public readonly string? Namespace;
        /// <summary>
        /// Type of permissions to use when interpreting the permissions for RLS. Valid values are `GRANT_ACCESS` and `DENY_ACCESS`.
        /// </summary>
        public readonly string PermissionPolicy;
        /// <summary>
        /// Status of the row-level security permission dataset. If enabled, the status is `ENABLED`. If disabled, the status is `DISABLED`.
        /// </summary>
        public readonly string? Status;

        [OutputConstructor]
        private DataSetRowLevelPermissionDataSet(
            string arn,

            string? formatVersion,

            string? @namespace,

            string permissionPolicy,

            string? status)
        {
            Arn = arn;
            FormatVersion = formatVersion;
            Namespace = @namespace;
            PermissionPolicy = permissionPolicy;
            Status = status;
        }
    }
}
