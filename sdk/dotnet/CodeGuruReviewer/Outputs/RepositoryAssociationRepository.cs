// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeGuruReviewer.Outputs
{

    [OutputType]
    public sealed class RepositoryAssociationRepository
    {
        public readonly Outputs.RepositoryAssociationRepositoryBitbucket? Bitbucket;
        public readonly Outputs.RepositoryAssociationRepositoryCodecommit? Codecommit;
        public readonly Outputs.RepositoryAssociationRepositoryGithubEnterpriseServer? GithubEnterpriseServer;
        public readonly Outputs.RepositoryAssociationRepositoryS3Bucket? S3Bucket;

        [OutputConstructor]
        private RepositoryAssociationRepository(
            Outputs.RepositoryAssociationRepositoryBitbucket? bitbucket,

            Outputs.RepositoryAssociationRepositoryCodecommit? codecommit,

            Outputs.RepositoryAssociationRepositoryGithubEnterpriseServer? githubEnterpriseServer,

            Outputs.RepositoryAssociationRepositoryS3Bucket? s3Bucket)
        {
            Bitbucket = bitbucket;
            Codecommit = codecommit;
            GithubEnterpriseServer = githubEnterpriseServer;
            S3Bucket = s3Bucket;
        }
    }
}
