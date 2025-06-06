// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.FinSpace.Outputs
{

    [OutputType]
    public sealed class KxDataviewSegmentConfiguration
    {
        /// <summary>
        /// The database path of the data that you want to place on each selected volume. Each segment must have a unique database path for each volume.
        /// </summary>
        public readonly ImmutableArray<string> DbPaths;
        /// <summary>
        /// Enables on-demand caching on the selected database path when a particular file or a column of the database is accessed. When on demand caching is **True**, dataviews perform minimal loading of files on the filesystem as needed. When it is set to **False**, everything is cached. The default value is **False**.
        /// </summary>
        public readonly bool? OnDemand;
        /// <summary>
        /// The name of the volume that you want to attach to a dataview. This volume must be in the same availability zone as the dataview that you are attaching to.
        /// </summary>
        public readonly string VolumeName;

        [OutputConstructor]
        private KxDataviewSegmentConfiguration(
            ImmutableArray<string> dbPaths,

            bool? onDemand,

            string volumeName)
        {
            DbPaths = dbPaths;
            OnDemand = onDemand;
            VolumeName = volumeName;
        }
    }
}
