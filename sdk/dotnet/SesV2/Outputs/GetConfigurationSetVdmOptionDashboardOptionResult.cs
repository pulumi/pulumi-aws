// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2.Outputs
{

    [OutputType]
    public sealed class GetConfigurationSetVdmOptionDashboardOptionResult
    {
        /// <summary>
        /// Specifies the status of your VDM engagement metrics collection.
        /// </summary>
        public readonly string EngagementMetrics;

        [OutputConstructor]
        private GetConfigurationSetVdmOptionDashboardOptionResult(string engagementMetrics)
        {
            EngagementMetrics = engagementMetrics;
        }
    }
}