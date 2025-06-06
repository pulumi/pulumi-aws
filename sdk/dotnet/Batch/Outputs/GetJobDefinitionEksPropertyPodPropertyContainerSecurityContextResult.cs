// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Outputs
{

    [OutputType]
    public sealed class GetJobDefinitionEksPropertyPodPropertyContainerSecurityContextResult
    {
        /// <summary>
        /// When this parameter is true, the container is given elevated permissions on the host container instance (similar to the root user).
        /// </summary>
        public readonly bool Privileged;
        public readonly bool ReadOnlyRootFileSystem;
        /// <summary>
        /// When this parameter is specified, the container is run as the specified group ID (gid). If this parameter isn't specified, the default is the group that's specified in the image metadata.
        /// </summary>
        public readonly int RunAsGroup;
        /// <summary>
        /// When this parameter is specified, the container is run as a user with a uid other than 0. If this parameter isn't specified, so such rule is enforced.
        /// </summary>
        public readonly bool RunAsNonRoot;
        /// <summary>
        /// When this parameter is specified, the container is run as the specified user ID (uid). If this parameter isn't specified, the default is the user that's specified in the image metadata.
        /// </summary>
        public readonly int RunAsUser;

        [OutputConstructor]
        private GetJobDefinitionEksPropertyPodPropertyContainerSecurityContextResult(
            bool privileged,

            bool readOnlyRootFileSystem,

            int runAsGroup,

            bool runAsNonRoot,

            int runAsUser)
        {
            Privileged = privileged;
            ReadOnlyRootFileSystem = readOnlyRootFileSystem;
            RunAsGroup = runAsGroup;
            RunAsNonRoot = runAsNonRoot;
            RunAsUser = runAsUser;
        }
    }
}
