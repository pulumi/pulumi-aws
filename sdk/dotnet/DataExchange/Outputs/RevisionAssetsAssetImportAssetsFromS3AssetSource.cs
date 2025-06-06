// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DataExchange.Outputs
{

    [OutputType]
    public sealed class RevisionAssetsAssetImportAssetsFromS3AssetSource
    {
        /// <summary>
        /// The name of the S3 bucket.
        /// </summary>
        public readonly string Bucket;
        /// <summary>
        /// The key of the object in the S3 bucket.
        /// </summary>
        public readonly string Key;

        [OutputConstructor]
        private RevisionAssetsAssetImportAssetsFromS3AssetSource(
            string bucket,

            string key)
        {
            Bucket = bucket;
            Key = key;
        }
    }
}
