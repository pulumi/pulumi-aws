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
    public sealed class ProjectCache
    {
        /// <summary>
        /// Location where the AWS CodeBuild project stores cached resources. For
        /// type `S3`, the value must be a valid S3 bucket name/prefix.
        /// </summary>
        public readonly string? Location;
        /// <summary>
        /// Specifies settings that AWS CodeBuild uses to store and reuse build
        /// dependencies. Valid values:  `LOCAL_SOURCE_CACHE`, `LOCAL_DOCKER_LAYER_CACHE`, `LOCAL_CUSTOM_CACHE`.
        /// </summary>
        public readonly ImmutableArray<string> Modes;
        /// <summary>
        /// Type of storage that will be used for the AWS CodeBuild project cache. Valid values: `NO_CACHE`,
        /// `LOCAL`, `S3`. Defaults to `NO_CACHE`.
        /// </summary>
        public readonly string? Type;

        [OutputConstructor]
        private ProjectCache(
            string? location,

            ImmutableArray<string> modes,

            string? type)
        {
            Location = location;
            Modes = modes;
            Type = type;
        }
    }
}
