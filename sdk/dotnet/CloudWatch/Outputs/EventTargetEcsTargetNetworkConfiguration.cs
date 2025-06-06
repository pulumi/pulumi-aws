// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Outputs
{

    [OutputType]
    public sealed class EventTargetEcsTargetNetworkConfiguration
    {
        /// <summary>
        /// Assign a public IP address to the ENI (Fargate launch type only). Valid values are `true` or `false`. Defaults to `false`.
        /// 
        /// For more information, see [Task Networking](https://docs.aws.amazon.com/AmazonECS/latest/developerguide/task-networking.html)
        /// </summary>
        public readonly bool? AssignPublicIp;
        /// <summary>
        /// The security groups associated with the task or service. If you do not specify a security group, the default security group for the VPC is used.
        /// </summary>
        public readonly ImmutableArray<string> SecurityGroups;
        /// <summary>
        /// The subnets associated with the task or service.
        /// </summary>
        public readonly ImmutableArray<string> Subnets;

        [OutputConstructor]
        private EventTargetEcsTargetNetworkConfiguration(
            bool? assignPublicIp,

            ImmutableArray<string> securityGroups,

            ImmutableArray<string> subnets)
        {
            AssignPublicIp = assignPublicIp;
            SecurityGroups = securityGroups;
            Subnets = subnets;
        }
    }
}
