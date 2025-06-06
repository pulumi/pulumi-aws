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
    public sealed class GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimitResult
    {
        /// <summary>
        /// The hard limit for the ulimit type.
        /// </summary>
        public readonly int HardLimit;
        /// <summary>
        /// The name of the job definition to register. It can be up to 128 letters long. It can contain uppercase and lowercase letters, numbers, hyphens (-), and underscores (_).
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// The soft limit for the ulimit type.
        /// </summary>
        public readonly int SoftLimit;

        [OutputConstructor]
        private GetJobDefinitionNodePropertyNodeRangePropertyContainerUlimitResult(
            int hardLimit,

            string name,

            int softLimit)
        {
            HardLimit = hardLimit;
            Name = name;
            SoftLimit = softLimit;
        }
    }
}
