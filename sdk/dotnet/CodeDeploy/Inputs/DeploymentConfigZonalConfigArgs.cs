// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeDeploy.Inputs
{

    public sealed class DeploymentConfigZonalConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The period of time, in seconds, that CodeDeploy must wait after completing a deployment to the first Availability Zone. CodeDeploy will wait this amount of time before starting a deployment to the second Availability Zone. If you don't specify a value for `first_zone_monitor_duration_in_seconds`, then CodeDeploy uses the `monitor_duration_in_seconds` value for the first Availability Zone.
        /// </summary>
        [Input("firstZoneMonitorDurationInSeconds")]
        public Input<int>? FirstZoneMonitorDurationInSeconds { get; set; }

        /// <summary>
        /// The number or percentage of instances that must remain available per Availability Zone during a deployment. If you don't specify a value under `minimum_healthy_hosts_per_zone`, then CodeDeploy uses a default value of 0 percent. This block is more documented below.
        /// </summary>
        [Input("minimumHealthyHostsPerZone")]
        public Input<Inputs.DeploymentConfigZonalConfigMinimumHealthyHostsPerZoneArgs>? MinimumHealthyHostsPerZone { get; set; }

        /// <summary>
        /// The period of time, in seconds, that CodeDeploy must wait after completing a deployment to an Availability Zone. CodeDeploy will wait this amount of time before starting a deployment to the next Availability Zone. If you don't specify a `monitor_duration_in_seconds`, CodeDeploy starts deploying to the next Availability Zone immediately.
        /// </summary>
        [Input("monitorDurationInSeconds")]
        public Input<int>? MonitorDurationInSeconds { get; set; }

        public DeploymentConfigZonalConfigArgs()
        {
        }
        public static new DeploymentConfigZonalConfigArgs Empty => new DeploymentConfigZonalConfigArgs();
    }
}
