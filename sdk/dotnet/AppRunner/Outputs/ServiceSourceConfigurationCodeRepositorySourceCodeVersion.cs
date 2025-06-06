// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppRunner.Outputs
{

    [OutputType]
    public sealed class ServiceSourceConfigurationCodeRepositorySourceCodeVersion
    {
        /// <summary>
        /// Type of version identifier. For a git-based repository, branches represent versions. Valid values: `BRANCH`.
        /// </summary>
        public readonly string Type;
        /// <summary>
        /// Source code version. For a git-based repository, a branch name maps to a specific version. App Runner uses the most recent commit to the branch.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private ServiceSourceConfigurationCodeRepositorySourceCodeVersion(
            string type,

            string value)
        {
            Type = type;
            Value = value;
        }
    }
}
