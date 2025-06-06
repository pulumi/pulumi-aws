// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeBuild.Outputs
{

    [OutputType]
    public sealed class ProjectSecondaryArtifact
    {
        /// <summary>
        /// Artifact identifier. Must be the same specified inside the AWS CodeBuild build
        /// specification.
        /// </summary>
        public readonly string ArtifactIdentifier;
        /// <summary>
        /// Specifies the bucket owner's access for objects that another account uploads to
        /// their Amazon S3 bucket. By default, only the account that uploads the objects to the bucket has access to these
        /// objects. This property allows you to give the bucket owner access to these objects. Valid values are `NONE`,
        /// `READ_ONLY`, and `FULL`. The CodeBuild service role must have the `s3:PutBucketAcl` permission. This permission allows
        /// CodeBuild to modify the access control list for the bucket.
        /// </summary>
        public readonly string? BucketOwnerAccess;
        /// <summary>
        /// Whether to disable encrypting output artifacts. If `type` is set to `NO_ARTIFACTS`,
        /// this value is ignored. Defaults to `false`.
        /// </summary>
        public readonly bool? EncryptionDisabled;
        /// <summary>
        /// Information about the build output artifact location. If `type` is set to `CODEPIPELINE` or
        /// `NO_ARTIFACTS`, this value is ignored if specified. If `type` is set to `S3`, this is the name of the output bucket.
        /// If `path` is not specified, `location` can specify the path of the output artifact in the output bucket.
        /// </summary>
        public readonly string? Location;
        /// <summary>
        /// Name of the project. If `type` is set to `CODEPIPELINE` or `NO_ARTIFACTS`, this value is ignored
        /// if specified. If `type` is set to `S3`, this is the name of the output artifact object.
        /// </summary>
        public readonly string? Name;
        /// <summary>
        /// Namespace to use in storing build artifacts. If `type` is set to `CODEPIPELINE` or
        /// `NO_ARTIFACTS`, this value is ignored if specified. If `type` is set to `S3`, valid values are `BUILD_ID` or `NONE`.
        /// </summary>
        public readonly string? NamespaceType;
        /// <summary>
        /// Whether a name specified in the build specification overrides the artifact name.
        /// </summary>
        public readonly bool? OverrideArtifactName;
        /// <summary>
        /// Type of build output artifact to create. If `type` is set to `CODEPIPELINE` or
        /// `NO_ARTIFACTS`, this value is ignored if specified. If `type` is set to `S3`, valid values are `NONE` or `ZIP`.
        /// </summary>
        public readonly string? Packaging;
        /// <summary>
        /// Along with `namespace_type` and `name`, the pattern that AWS CodeBuild uses to name and store the
        /// output artifact. If `type` is set to `CODEPIPELINE` or `NO_ARTIFACTS`, this value is ignored if specified. If `type`
        /// is set to `S3`, this is the path to the output artifact.
        /// </summary>
        public readonly string? Path;
        /// <summary>
        /// Build output artifact's type. Valid values `CODEPIPELINE`, `NO_ARTIFACTS`, and `S3`.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private ProjectSecondaryArtifact(
            string artifactIdentifier,

            string? bucketOwnerAccess,

            bool? encryptionDisabled,

            string? location,

            string? name,

            string? namespaceType,

            bool? overrideArtifactName,

            string? packaging,

            string? path,

            string type)
        {
            ArtifactIdentifier = artifactIdentifier;
            BucketOwnerAccess = bucketOwnerAccess;
            EncryptionDisabled = encryptionDisabled;
            Location = location;
            Name = name;
            NamespaceType = namespaceType;
            OverrideArtifactName = overrideArtifactName;
            Packaging = packaging;
            Path = path;
            Type = type;
        }
    }
}
