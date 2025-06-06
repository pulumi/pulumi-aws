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
    public sealed class ProjectSourceBuildStatusConfig
    {
        /// <summary>
        /// Specifies the context of the build status CodeBuild sends to the source provider. The usage of
        /// this parameter depends on the source provider.
        /// </summary>
        public readonly string? Context;
        /// <summary>
        /// Specifies the target url of the build status CodeBuild sends to the source provider. The
        /// usage of this parameter depends on the source provider.
        /// </summary>
        public readonly string? TargetUrl;

        [OutputConstructor]
        private ProjectSourceBuildStatusConfig(
            string? context,

            string? targetUrl)
        {
            Context = context;
            TargetUrl = targetUrl;
        }
    }
}
