// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GuardDuty.Outputs
{

    [OutputType]
    public sealed class OrganizationConfigurationFeatureAdditionalConfiguration
    {
        /// <summary>
        /// The status of the additional configuration that will be configured for the organization. Valid values: `NEW`, `ALL`, `NONE`.
        /// </summary>
        public readonly string AutoEnable;
        /// <summary>
        /// The name of the additional configuration for a feature that will be configured for the organization. Valid values: `EKS_ADDON_MANAGEMENT`, `ECS_FARGATE_AGENT_MANAGEMENT`, `EC2_AGENT_MANAGEMENT`. Refer to the [AWS Documentation](https://docs.aws.amazon.com/guardduty/latest/APIReference/API_DetectorAdditionalConfiguration.html) for the current list of supported values.
        /// </summary>
        public readonly string Name;

        [OutputConstructor]
        private OrganizationConfigurationFeatureAdditionalConfiguration(
            string autoEnable,

            string name)
        {
            AutoEnable = autoEnable;
            Name = name;
        }
    }
}
