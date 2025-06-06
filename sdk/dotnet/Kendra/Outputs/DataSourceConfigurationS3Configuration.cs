// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kendra.Outputs
{

    [OutputType]
    public sealed class DataSourceConfigurationS3Configuration
    {
        /// <summary>
        /// A block that provides the path to the S3 bucket that contains the user context filtering files for the data source. For the format of the file, see [Access control for S3 data sources](https://docs.aws.amazon.com/kendra/latest/dg/s3-acl.html). Detailed below.
        /// </summary>
        public readonly Outputs.DataSourceConfigurationS3ConfigurationAccessControlListConfiguration? AccessControlListConfiguration;
        /// <summary>
        /// The name of the bucket that contains the documents.
        /// </summary>
        public readonly string BucketName;
        /// <summary>
        /// A block that defines the Document metadata files that contain information such as the document access control information, source URI, document author, and custom attributes. Each metadata file contains metadata about a single document. Detailed below.
        /// </summary>
        public readonly Outputs.DataSourceConfigurationS3ConfigurationDocumentsMetadataConfiguration? DocumentsMetadataConfiguration;
        /// <summary>
        /// A list of glob patterns for documents that should not be indexed. If a document that matches an inclusion prefix or inclusion pattern also matches an exclusion pattern, the document is not indexed. Refer to [Exclusion Patterns for more examples](https://docs.aws.amazon.com/kendra/latest/dg/API_S3DataSourceConfiguration.html#Kendra-Type-S3DataSourceConfiguration-ExclusionPatterns).
        /// </summary>
        public readonly ImmutableArray<string> ExclusionPatterns;
        /// <summary>
        /// A list of glob patterns for documents that should be indexed. If a document that matches an inclusion pattern also matches an exclusion pattern, the document is not indexed. Refer to [Inclusion Patterns for more examples](https://docs.aws.amazon.com/kendra/latest/dg/API_S3DataSourceConfiguration.html#Kendra-Type-S3DataSourceConfiguration-InclusionPatterns).
        /// </summary>
        public readonly ImmutableArray<string> InclusionPatterns;
        /// <summary>
        /// A list of S3 prefixes for the documents that should be included in the index.
        /// </summary>
        public readonly ImmutableArray<string> InclusionPrefixes;

        [OutputConstructor]
        private DataSourceConfigurationS3Configuration(
            Outputs.DataSourceConfigurationS3ConfigurationAccessControlListConfiguration? accessControlListConfiguration,

            string bucketName,

            Outputs.DataSourceConfigurationS3ConfigurationDocumentsMetadataConfiguration? documentsMetadataConfiguration,

            ImmutableArray<string> exclusionPatterns,

            ImmutableArray<string> inclusionPatterns,

            ImmutableArray<string> inclusionPrefixes)
        {
            AccessControlListConfiguration = accessControlListConfiguration;
            BucketName = bucketName;
            DocumentsMetadataConfiguration = documentsMetadataConfiguration;
            ExclusionPatterns = exclusionPatterns;
            InclusionPatterns = inclusionPatterns;
            InclusionPrefixes = inclusionPrefixes;
        }
    }
}
