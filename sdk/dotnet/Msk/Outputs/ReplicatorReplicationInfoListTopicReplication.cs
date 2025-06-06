// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Msk.Outputs
{

    [OutputType]
    public sealed class ReplicatorReplicationInfoListTopicReplication
    {
        /// <summary>
        /// Whether to periodically configure remote topic ACLs to match their corresponding upstream topics.
        /// </summary>
        public readonly bool? CopyAccessControlListsForTopics;
        /// <summary>
        /// Whether to periodically configure remote topics to match their corresponding upstream topics.
        /// </summary>
        public readonly bool? CopyTopicConfigurations;
        /// <summary>
        /// Whether to periodically check for new topics and partitions.
        /// </summary>
        public readonly bool? DetectAndCopyNewTopics;
        /// <summary>
        /// Configuration for specifying the position in the topics to start replicating from.
        /// </summary>
        public readonly Outputs.ReplicatorReplicationInfoListTopicReplicationStartingPosition? StartingPosition;
        /// <summary>
        /// Configuration for specifying replicated topic names should be the same as their corresponding upstream topics or prefixed with source cluster alias.
        /// </summary>
        public readonly Outputs.ReplicatorReplicationInfoListTopicReplicationTopicNameConfiguration? TopicNameConfiguration;
        /// <summary>
        /// List of regular expression patterns indicating the topics that should not be replica.
        /// </summary>
        public readonly ImmutableArray<string> TopicsToExcludes;
        /// <summary>
        /// List of regular expression patterns indicating the topics to copy.
        /// </summary>
        public readonly ImmutableArray<string> TopicsToReplicates;

        [OutputConstructor]
        private ReplicatorReplicationInfoListTopicReplication(
            bool? copyAccessControlListsForTopics,

            bool? copyTopicConfigurations,

            bool? detectAndCopyNewTopics,

            Outputs.ReplicatorReplicationInfoListTopicReplicationStartingPosition? startingPosition,

            Outputs.ReplicatorReplicationInfoListTopicReplicationTopicNameConfiguration? topicNameConfiguration,

            ImmutableArray<string> topicsToExcludes,

            ImmutableArray<string> topicsToReplicates)
        {
            CopyAccessControlListsForTopics = copyAccessControlListsForTopics;
            CopyTopicConfigurations = copyTopicConfigurations;
            DetectAndCopyNewTopics = detectAndCopyNewTopics;
            StartingPosition = startingPosition;
            TopicNameConfiguration = topicNameConfiguration;
            TopicsToExcludes = topicsToExcludes;
            TopicsToReplicates = topicsToReplicates;
        }
    }
}
