// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Tables.Outputs
{

    [OutputType]
    public sealed class TableMaintenanceConfigurationIcebergSnapshotManagement
    {
        /// <summary>
        /// Settings object for snapshot management.
        /// See `iceberg_snapshot_management.settings` below.
        /// </summary>
        public readonly Outputs.TableMaintenanceConfigurationIcebergSnapshotManagementSettings Settings;
        /// <summary>
        /// Whether the configuration is enabled.
        /// Valid values are `enabled` and `disabled`.
        /// </summary>
        public readonly string Status;

        [OutputConstructor]
        private TableMaintenanceConfigurationIcebergSnapshotManagement(
            Outputs.TableMaintenanceConfigurationIcebergSnapshotManagementSettings settings,

            string status)
        {
            Settings = settings;
            Status = status;
        }
    }
}
