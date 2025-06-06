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
    public sealed class GetJobDefinitionNodePropertyNodeRangePropertyContainerVolumeEfsVolumeConfigurationResult
    {
        /// <summary>
        /// The authorization configuration details for the Amazon EFS file system.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetJobDefinitionNodePropertyNodeRangePropertyContainerVolumeEfsVolumeConfigurationAuthorizationConfigResult> AuthorizationConfigs;
        /// <summary>
        /// The Amazon EFS file system ID to use.
        /// </summary>
        public readonly string FileSystemId;
        /// <summary>
        /// The directory within the Amazon EFS file system to mount as the root directory inside the host.
        /// </summary>
        public readonly string RootDirectory;
        /// <summary>
        /// Determines whether to enable encryption for Amazon EFS data in transit between the Amazon ECS host and the Amazon EFS server
        /// </summary>
        public readonly string TransitEncryption;
        /// <summary>
        /// The port to use when sending encrypted data between the Amazon ECS host and the Amazon EFS server.
        /// </summary>
        public readonly int TransitEncryptionPort;

        [OutputConstructor]
        private GetJobDefinitionNodePropertyNodeRangePropertyContainerVolumeEfsVolumeConfigurationResult(
            ImmutableArray<Outputs.GetJobDefinitionNodePropertyNodeRangePropertyContainerVolumeEfsVolumeConfigurationAuthorizationConfigResult> authorizationConfigs,

            string fileSystemId,

            string rootDirectory,

            string transitEncryption,

            int transitEncryptionPort)
        {
            AuthorizationConfigs = authorizationConfigs;
            FileSystemId = fileSystemId;
            RootDirectory = rootDirectory;
            TransitEncryption = transitEncryption;
            TransitEncryptionPort = transitEncryptionPort;
        }
    }
}
