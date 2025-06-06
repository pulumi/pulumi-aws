// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GameLift.Outputs
{

    [OutputType]
    public sealed class ScriptStorageLocation
    {
        /// <summary>
        /// Name of your S3 bucket.
        /// </summary>
        public readonly string Bucket;
        /// <summary>
        /// Name of the zip file containing your script files.
        /// </summary>
        public readonly string Key;
        /// <summary>
        /// A specific version of the file. If not set, the latest version of the file is retrieved.
        /// </summary>
        public readonly string? ObjectVersion;
        /// <summary>
        /// ARN of the access role that allows Amazon GameLift to access your S3 bucket.
        /// </summary>
        public readonly string RoleArn;

        [OutputConstructor]
        private ScriptStorageLocation(
            string bucket,

            string key,

            string? objectVersion,

            string roleArn)
        {
            Bucket = bucket;
            Key = key;
            ObjectVersion = objectVersion;
            RoleArn = roleArn;
        }
    }
}
