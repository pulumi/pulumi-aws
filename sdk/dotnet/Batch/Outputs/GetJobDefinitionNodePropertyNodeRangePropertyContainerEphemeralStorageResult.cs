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
    public sealed class GetJobDefinitionNodePropertyNodeRangePropertyContainerEphemeralStorageResult
    {
        public readonly int SizeInGib;

        [OutputConstructor]
        private GetJobDefinitionNodePropertyNodeRangePropertyContainerEphemeralStorageResult(int sizeInGib)
        {
            SizeInGib = sizeInGib;
        }
    }
}
