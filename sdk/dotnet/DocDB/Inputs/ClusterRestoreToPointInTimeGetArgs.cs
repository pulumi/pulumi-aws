// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DocDB.Inputs
{

    public sealed class ClusterRestoreToPointInTimeGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The date and time to restore from. Value must be a time in Universal Coordinated Time (UTC) format and must be before the latest restorable time for the DB instance. Cannot be specified with `use_latest_restorable_time`.
        /// </summary>
        [Input("restoreToTime")]
        public Input<string>? RestoreToTime { get; set; }

        /// <summary>
        /// The type of restore to be performed. Valid values are `full-copy`, `copy-on-write`.
        /// </summary>
        [Input("restoreType")]
        public Input<string>? RestoreType { get; set; }

        /// <summary>
        /// The identifier of the source DB cluster from which to restore. Must match the identifier of an existing DB cluster.
        /// </summary>
        [Input("sourceClusterIdentifier", required: true)]
        public Input<string> SourceClusterIdentifier { get; set; } = null!;

        /// <summary>
        /// A boolean value that indicates whether the DB cluster is restored from the latest backup time. Defaults to `false`. Cannot be specified with `restore_to_time`.
        /// </summary>
        [Input("useLatestRestorableTime")]
        public Input<bool>? UseLatestRestorableTime { get; set; }

        public ClusterRestoreToPointInTimeGetArgs()
        {
        }
        public static new ClusterRestoreToPointInTimeGetArgs Empty => new ClusterRestoreToPointInTimeGetArgs();
    }
}
