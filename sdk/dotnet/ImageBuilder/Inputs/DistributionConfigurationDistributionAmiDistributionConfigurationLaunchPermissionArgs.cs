// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Inputs
{

    public sealed class DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs : global::Pulumi.ResourceArgs
    {
        [Input("organizationArns")]
        private InputList<string>? _organizationArns;

        /// <summary>
        /// Set of AWS Organization ARNs to assign.
        /// </summary>
        public InputList<string> OrganizationArns
        {
            get => _organizationArns ?? (_organizationArns = new InputList<string>());
            set => _organizationArns = value;
        }

        [Input("organizationalUnitArns")]
        private InputList<string>? _organizationalUnitArns;

        /// <summary>
        /// Set of AWS Organizational Unit ARNs to assign.
        /// </summary>
        public InputList<string> OrganizationalUnitArns
        {
            get => _organizationalUnitArns ?? (_organizationalUnitArns = new InputList<string>());
            set => _organizationalUnitArns = value;
        }

        [Input("userGroups")]
        private InputList<string>? _userGroups;

        /// <summary>
        /// Set of EC2 launch permission user groups to assign. Use `all` to distribute a public AMI.
        /// </summary>
        public InputList<string> UserGroups
        {
            get => _userGroups ?? (_userGroups = new InputList<string>());
            set => _userGroups = value;
        }

        [Input("userIds")]
        private InputList<string>? _userIds;

        /// <summary>
        /// Set of AWS Account identifiers to assign.
        /// </summary>
        public InputList<string> UserIds
        {
            get => _userIds ?? (_userIds = new InputList<string>());
            set => _userIds = value;
        }

        public DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs()
        {
        }
        public static new DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs Empty => new DistributionConfigurationDistributionAmiDistributionConfigurationLaunchPermissionArgs();
    }
}
