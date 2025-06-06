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
    public sealed class ProjectBuildBatchConfig
    {
        /// <summary>
        /// Specifies if the build artifacts for the batch build should be combined into a single
        /// artifact location.
        /// </summary>
        public readonly bool? CombineArtifacts;
        /// <summary>
        /// Configuration block specifying the restrictions for the batch build. Detailed below.
        /// </summary>
        public readonly Outputs.ProjectBuildBatchConfigRestrictions? Restrictions;
        /// <summary>
        /// Specifies the service role ARN for the batch build project.
        /// </summary>
        public readonly string ServiceRole;
        /// <summary>
        /// Specifies the maximum amount of time, in minutes, that the batch build must be
        /// completed in.
        /// </summary>
        public readonly int? TimeoutInMins;

        [OutputConstructor]
        private ProjectBuildBatchConfig(
            bool? combineArtifacts,

            Outputs.ProjectBuildBatchConfigRestrictions? restrictions,

            string serviceRole,

            int? timeoutInMins)
        {
            CombineArtifacts = combineArtifacts;
            Restrictions = restrictions;
            ServiceRole = serviceRole;
            TimeoutInMins = timeoutInMins;
        }
    }
}
