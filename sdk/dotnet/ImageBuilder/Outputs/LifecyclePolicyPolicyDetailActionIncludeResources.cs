// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Outputs
{

    [OutputType]
    public sealed class LifecyclePolicyPolicyDetailActionIncludeResources
    {
        /// <summary>
        /// Specifies whether the lifecycle action should apply to distributed AMIs.
        /// </summary>
        public readonly bool? Amis;
        /// <summary>
        /// Specifies whether the lifecycle action should apply to distributed containers.
        /// </summary>
        public readonly bool? Containers;
        /// <summary>
        /// Specifies whether the lifecycle action should apply to snapshots associated with distributed AMIs.
        /// </summary>
        public readonly bool? Snapshots;

        [OutputConstructor]
        private LifecyclePolicyPolicyDetailActionIncludeResources(
            bool? amis,

            bool? containers,

            bool? snapshots)
        {
            Amis = amis;
            Containers = containers;
            Snapshots = snapshots;
        }
    }
}
