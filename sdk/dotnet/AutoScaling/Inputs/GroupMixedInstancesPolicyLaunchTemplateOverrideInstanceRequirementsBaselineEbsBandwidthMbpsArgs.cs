// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AutoScaling.Inputs
{

    public sealed class GroupMixedInstancesPolicyLaunchTemplateOverrideInstanceRequirementsBaselineEbsBandwidthMbpsArgs : global::Pulumi.ResourceArgs
    {
        [Input("max")]
        public Input<int>? Max { get; set; }

        [Input("min")]
        public Input<int>? Min { get; set; }

        public GroupMixedInstancesPolicyLaunchTemplateOverrideInstanceRequirementsBaselineEbsBandwidthMbpsArgs()
        {
        }
        public static new GroupMixedInstancesPolicyLaunchTemplateOverrideInstanceRequirementsBaselineEbsBandwidthMbpsArgs Empty => new GroupMixedInstancesPolicyLaunchTemplateOverrideInstanceRequirementsBaselineEbsBandwidthMbpsArgs();
    }
}
