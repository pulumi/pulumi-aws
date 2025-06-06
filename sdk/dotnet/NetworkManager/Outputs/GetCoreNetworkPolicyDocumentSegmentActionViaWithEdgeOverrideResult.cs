// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkManager.Outputs
{

    [OutputType]
    public sealed class GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideResult
    {
        /// <summary>
        /// A list of a list of strings. The list of edges associated with the network function group.
        /// </summary>
        public readonly ImmutableArray<ImmutableArray<string>> EdgeSets;
        /// <summary>
        /// The preferred edge to use.
        /// </summary>
        public readonly string? UseEdge;
        /// <summary>
        /// The preferred edge to use.
        /// </summary>
        public readonly string? UseEdgeLocation;

        [OutputConstructor]
        private GetCoreNetworkPolicyDocumentSegmentActionViaWithEdgeOverrideResult(
            ImmutableArray<ImmutableArray<string>> edgeSets,

            string? useEdge,

            string? useEdgeLocation)
        {
            EdgeSets = edgeSets;
            UseEdge = useEdge;
            UseEdgeLocation = useEdgeLocation;
        }
    }
}
