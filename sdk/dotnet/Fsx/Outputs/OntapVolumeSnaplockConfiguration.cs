// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fsx.Outputs
{

    [OutputType]
    public sealed class OntapVolumeSnaplockConfiguration
    {
        /// <summary>
        /// Enables or disables the audit log volume for an FSx for ONTAP SnapLock volume. The default value is `false`.
        /// </summary>
        public readonly bool? AuditLogVolume;
        /// <summary>
        /// The configuration object for setting the autocommit period of files in an FSx for ONTAP SnapLock volume. See `autocommit_period` Block for details.
        /// </summary>
        public readonly Outputs.OntapVolumeSnaplockConfigurationAutocommitPeriod? AutocommitPeriod;
        /// <summary>
        /// Enables, disables, or permanently disables privileged delete on an FSx for ONTAP SnapLock Enterprise volume. Valid values: `DISABLED`, `ENABLED`, `PERMANENTLY_DISABLED`. The default value is `DISABLED`.
        /// </summary>
        public readonly string? PrivilegedDelete;
        /// <summary>
        /// The retention period of an FSx for ONTAP SnapLock volume. See `retention_period` Block for details.
        /// </summary>
        public readonly Outputs.OntapVolumeSnaplockConfigurationRetentionPeriod? RetentionPeriod;
        /// <summary>
        /// Specifies the retention mode of an FSx for ONTAP SnapLock volume. After it is set, it can't be changed. Valid values: `COMPLIANCE`, `ENTERPRISE`.
        /// </summary>
        public readonly string SnaplockType;
        /// <summary>
        /// Enables or disables volume-append mode on an FSx for ONTAP SnapLock volume. The default value is `false`.
        /// </summary>
        public readonly bool? VolumeAppendModeEnabled;

        [OutputConstructor]
        private OntapVolumeSnaplockConfiguration(
            bool? auditLogVolume,

            Outputs.OntapVolumeSnaplockConfigurationAutocommitPeriod? autocommitPeriod,

            string? privilegedDelete,

            Outputs.OntapVolumeSnaplockConfigurationRetentionPeriod? retentionPeriod,

            string snaplockType,

            bool? volumeAppendModeEnabled)
        {
            AuditLogVolume = auditLogVolume;
            AutocommitPeriod = autocommitPeriod;
            PrivilegedDelete = privilegedDelete;
            RetentionPeriod = retentionPeriod;
            SnaplockType = snaplockType;
            VolumeAppendModeEnabled = volumeAppendModeEnabled;
        }
    }
}
