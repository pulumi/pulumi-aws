// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Outputs
{

    [OutputType]
    public sealed class DomainClusterConfigNodeOptionNodeConfig
    {
        /// <summary>
        /// Number of nodes of a particular node type in the cluster.
        /// </summary>
        public readonly int? Count;
        /// <summary>
        /// Whether a particular node type is enabled.
        /// </summary>
        public readonly bool? Enabled;
        /// <summary>
        /// The instance type of a particular node type in the cluster.
        /// </summary>
        public readonly string? Type;

        [OutputConstructor]
        private DomainClusterConfigNodeOptionNodeConfig(
            int? count,

            bool? enabled,

            string? type)
        {
            Count = count;
            Enabled = enabled;
            Type = type;
        }
    }
}
