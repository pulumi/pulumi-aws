// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecs.Outputs
{

    [OutputType]
    public sealed class TaskSetLoadBalancer
    {
        /// <summary>
        /// The name of the container to associate with the load balancer (as it appears in a container definition).
        /// </summary>
        public readonly string ContainerName;
        /// <summary>
        /// The port on the container to associate with the load balancer. Defaults to `0` if not specified.
        /// 
        /// &gt; **Note:** Specifying multiple `load_balancer` configurations is still not supported by AWS for ECS task set.
        /// </summary>
        public readonly int? ContainerPort;
        /// <summary>
        /// The name of the ELB (Classic) to associate with the service.
        /// </summary>
        public readonly string? LoadBalancerName;
        /// <summary>
        /// The ARN of the Load Balancer target group to associate with the service.
        /// </summary>
        public readonly string? TargetGroupArn;

        [OutputConstructor]
        private TaskSetLoadBalancer(
            string containerName,

            int? containerPort,

            string? loadBalancerName,

            string? targetGroupArn)
        {
            ContainerName = containerName;
            ContainerPort = containerPort;
            LoadBalancerName = loadBalancerName;
            TargetGroupArn = targetGroupArn;
        }
    }
}
