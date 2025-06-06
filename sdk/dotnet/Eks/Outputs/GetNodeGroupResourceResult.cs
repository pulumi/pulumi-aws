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
    public sealed class GetNodeGroupResourceResult
    {
        /// <summary>
        /// List of objects containing information about AutoScaling Groups.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetNodeGroupResourceAutoscalingGroupResult> AutoscalingGroups;
        /// <summary>
        /// Identifier of the remote access EC2 Security Group.
        /// </summary>
        public readonly string RemoteAccessSecurityGroupId;

        [OutputConstructor]
        private GetNodeGroupResourceResult(
            ImmutableArray<Outputs.GetNodeGroupResourceAutoscalingGroupResult> autoscalingGroups,

            string remoteAccessSecurityGroupId)
        {
            AutoscalingGroups = autoscalingGroups;
            RemoteAccessSecurityGroupId = remoteAccessSecurityGroupId;
        }
    }
}
