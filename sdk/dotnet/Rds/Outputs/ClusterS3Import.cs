// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Rds.Outputs
{

    [OutputType]
    public sealed class ClusterS3Import
    {
        /// <summary>
        /// Bucket name where your backup is stored
        /// </summary>
        public readonly string BucketName;
        /// <summary>
        /// Can be blank, but is the path to your backup
        /// </summary>
        public readonly string? BucketPrefix;
        /// <summary>
        /// Role applied to load the data.
        /// </summary>
        public readonly string IngestionRole;
        /// <summary>
        /// Source engine for the backup
        /// </summary>
        public readonly string SourceEngine;
        /// <summary>
        /// Version of the source engine used to make the backup
        /// 
        /// This will not recreate the resource if the S3 object changes in some way. It's only used to initialize the database. This only works currently with the aurora engine. See AWS for currently supported engines and options. See [Aurora S3 Migration Docs](https://docs.aws.amazon.com/AmazonRDS/latest/AuroraUserGuide/AuroraMySQL.Migrating.ExtMySQL.html#AuroraMySQL.Migrating.ExtMySQL.S3).
        /// </summary>
        public readonly string SourceEngineVersion;

        [OutputConstructor]
        private ClusterS3Import(
            string bucketName,

            string? bucketPrefix,

            string ingestionRole,

            string sourceEngine,

            string sourceEngineVersion)
        {
            BucketName = bucketName;
            BucketPrefix = bucketPrefix;
            IngestionRole = ingestionRole;
            SourceEngine = sourceEngine;
            SourceEngineVersion = sourceEngineVersion;
        }
    }
}
