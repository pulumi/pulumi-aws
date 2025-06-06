// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Backup.Outputs
{

    [OutputType]
    public sealed class PlanAdvancedBackupSetting
    {
        /// <summary>
        /// Specifies the backup option for a selected resource. This option is only available for Windows VSS backup jobs. Set to `{ WindowsVSS = "enabled" }` to enable Windows VSS backup option and create a VSS Windows backup.
        /// </summary>
        public readonly ImmutableDictionary<string, string> BackupOptions;
        /// <summary>
        /// The type of AWS resource to be backed up. For VSS Windows backups, the only supported resource type is Amazon EC2. Valid values: `EC2`.
        /// </summary>
        public readonly string ResourceType;

        [OutputConstructor]
        private PlanAdvancedBackupSetting(
            ImmutableDictionary<string, string> backupOptions,

            string resourceType)
        {
            BackupOptions = backupOptions;
            ResourceType = resourceType;
        }
    }
}
