// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Eks.Outputs
{

    [OutputType]
    public sealed class ClusterStorageConfig
    {
        /// <summary>
        /// Configuration block with block storage configuration for the cluster. Detailed below.
        /// </summary>
        public readonly Outputs.ClusterStorageConfigBlockStorage? BlockStorage;

        [OutputConstructor]
        private ClusterStorageConfig(Outputs.ClusterStorageConfigBlockStorage? blockStorage)
        {
            BlockStorage = blockStorage;
        }
    }
}
