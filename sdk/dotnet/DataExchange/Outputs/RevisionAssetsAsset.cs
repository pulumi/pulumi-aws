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
    public sealed class RevisionAssetsAsset
    {
        /// <summary>
        /// The ARN of the Data Exchange Revision Assets.
        /// </summary>
        public readonly string? Arn;
        /// <summary>
        /// A block to create S3 data access from an S3 bucket. See Create S3 Data Access from S3 Bucket for more details.
        /// </summary>
        public readonly Outputs.RevisionAssetsAssetCreateS3DataAccessFromS3Bucket? CreateS3DataAccessFromS3Bucket;
        /// <summary>
        /// The timestamp when the revision was created, in RFC3339 format.
        /// </summary>
        public readonly string? CreatedAt;
        /// <summary>
        /// The unique identifier for the revision.
        /// </summary>
        public readonly string? Id;
        /// <summary>
        /// A block to import assets from S3. See Import Assets from S3 for more details.
        /// </summary>
        public readonly Outputs.RevisionAssetsAssetImportAssetsFromS3? ImportAssetsFromS3;
        /// <summary>
        /// A block to import assets from a signed URL. See Import Assets from Signed URL for more details.
        /// </summary>
        public readonly Outputs.RevisionAssetsAssetImportAssetsFromSignedUrl? ImportAssetsFromSignedUrl;
        public readonly string? Name;
        /// <summary>
        /// The timestamp when the revision was last updated, in RFC3339 format.
        /// </summary>
        public readonly string? UpdatedAt;

        [OutputConstructor]
        private RevisionAssetsAsset(
            string? arn,

            Outputs.RevisionAssetsAssetCreateS3DataAccessFromS3Bucket? createS3DataAccessFromS3Bucket,

            string? createdAt,

            string? id,

            Outputs.RevisionAssetsAssetImportAssetsFromS3? importAssetsFromS3,

            Outputs.RevisionAssetsAssetImportAssetsFromSignedUrl? importAssetsFromSignedUrl,

            string? name,

            string? updatedAt)
        {
            Arn = arn;
            CreateS3DataAccessFromS3Bucket = createS3DataAccessFromS3Bucket;
            CreatedAt = createdAt;
            Id = id;
            ImportAssetsFromS3 = importAssetsFromS3;
            ImportAssetsFromSignedUrl = importAssetsFromSignedUrl;
            Name = name;
            UpdatedAt = updatedAt;
        }
    }
}
