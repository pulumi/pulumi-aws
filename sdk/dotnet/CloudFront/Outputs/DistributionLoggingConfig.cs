// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Outputs
{

    [OutputType]
    public sealed class DistributionLoggingConfig
    {
        /// <summary>
        /// Amazon S3 bucket to store the access logs in, for example, `myawslogbucket.s3.amazonaws.com`. The bucket must have correct ACL attached with "FULL_CONTROL" permission for "awslogsdelivery" account (Canonical ID: "c4c1ede66af53448b93c283ce9448c4ba468c9432aa01d700d3878632f77d2d0") for log transfer to work.
        /// </summary>
        public readonly string Bucket;
        /// <summary>
        /// Whether to include cookies in access logs (default: `false`).
        /// </summary>
        public readonly bool? IncludeCookies;
        /// <summary>
        /// Prefix to the access log filenames for this distribution, for example, `myprefix/`.
        /// </summary>
        public readonly string? Prefix;

        [OutputConstructor]
        private DistributionLoggingConfig(
            string bucket,

            bool? includeCookies,

            string? prefix)
        {
            Bucket = bucket;
            IncludeCookies = includeCookies;
            Prefix = prefix;
        }
    }
}
