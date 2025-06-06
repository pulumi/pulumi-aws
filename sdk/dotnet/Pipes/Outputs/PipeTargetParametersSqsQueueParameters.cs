// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Outputs
{

    [OutputType]
    public sealed class PipeTargetParametersSqsQueueParameters
    {
        /// <summary>
        /// This parameter applies only to FIFO (first-in-first-out) queues. The token used for deduplication of sent messages.
        /// </summary>
        public readonly string? MessageDeduplicationId;
        /// <summary>
        /// The FIFO message group ID to use as the target.
        /// </summary>
        public readonly string? MessageGroupId;

        [OutputConstructor]
        private PipeTargetParametersSqsQueueParameters(
            string? messageDeduplicationId,

            string? messageGroupId)
        {
            MessageDeduplicationId = messageDeduplicationId;
            MessageGroupId = messageGroupId;
        }
    }
}
