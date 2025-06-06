// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class SpotFleetRequestLaunchTemplateConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Launch template specification. See Launch Template Specification below for more details.
        /// </summary>
        [Input("launchTemplateSpecification", required: true)]
        public Input<Inputs.SpotFleetRequestLaunchTemplateConfigLaunchTemplateSpecificationGetArgs> LaunchTemplateSpecification { get; set; } = null!;

        [Input("overrides")]
        private InputList<Inputs.SpotFleetRequestLaunchTemplateConfigOverrideGetArgs>? _overrides;

        /// <summary>
        /// One or more override configurations. See Overrides below for more details.
        /// </summary>
        public InputList<Inputs.SpotFleetRequestLaunchTemplateConfigOverrideGetArgs> Overrides
        {
            get => _overrides ?? (_overrides = new InputList<Inputs.SpotFleetRequestLaunchTemplateConfigOverrideGetArgs>());
            set => _overrides = value;
        }

        public SpotFleetRequestLaunchTemplateConfigGetArgs()
        {
        }
        public static new SpotFleetRequestLaunchTemplateConfigGetArgs Empty => new SpotFleetRequestLaunchTemplateConfigGetArgs();
    }
}
