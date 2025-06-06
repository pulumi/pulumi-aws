// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudFront.Inputs
{

    public sealed class MonitoringSubscriptionMonitoringSubscriptionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A subscription configuration for additional CloudWatch metrics. See below.
        /// </summary>
        [Input("realtimeMetricsSubscriptionConfig", required: true)]
        public Input<Inputs.MonitoringSubscriptionMonitoringSubscriptionRealtimeMetricsSubscriptionConfigGetArgs> RealtimeMetricsSubscriptionConfig { get; set; } = null!;

        public MonitoringSubscriptionMonitoringSubscriptionGetArgs()
        {
        }
        public static new MonitoringSubscriptionMonitoringSubscriptionGetArgs Empty => new MonitoringSubscriptionMonitoringSubscriptionGetArgs();
    }
}
