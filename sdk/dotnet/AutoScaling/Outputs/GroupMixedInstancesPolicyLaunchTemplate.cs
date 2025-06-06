// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Outputs
{

    [OutputType]
    public sealed class GroupMixedInstancesPolicyLaunchTemplate
    {
        /// <summary>
        /// Override the instance launch template specification in the Launch Template.
        /// </summary>
        public readonly Outputs.GroupMixedInstancesPolicyLaunchTemplateLaunchTemplateSpecification LaunchTemplateSpecification;
        /// <summary>
        /// List of nested arguments provides the ability to specify multiple instance types. This will override the same parameter in the launch template. For on-demand instances, Auto Scaling considers the order of preference of instance types to launch based on the order specified in the overrides list. Defined below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GroupMixedInstancesPolicyLaunchTemplateOverride> Overrides;

        [OutputConstructor]
        private GroupMixedInstancesPolicyLaunchTemplate(
            Outputs.GroupMixedInstancesPolicyLaunchTemplateLaunchTemplateSpecification launchTemplateSpecification,

            ImmutableArray<Outputs.GroupMixedInstancesPolicyLaunchTemplateOverride> overrides)
        {
            LaunchTemplateSpecification = launchTemplateSpecification;
            Overrides = overrides;
        }
    }
}
