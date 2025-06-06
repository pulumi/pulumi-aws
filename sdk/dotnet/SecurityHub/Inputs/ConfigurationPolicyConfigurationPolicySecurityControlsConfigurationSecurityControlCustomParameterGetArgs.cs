// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Inputs
{

    public sealed class ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("parameters", required: true)]
        private InputList<Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterGetArgs>? _parameters;

        /// <summary>
        /// An object that specifies parameter values for a control in a configuration policy. See below.
        /// </summary>
        public InputList<Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterGetArgs> Parameters
        {
            get => _parameters ?? (_parameters = new InputList<Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterParameterGetArgs>());
            set => _parameters = value;
        }

        /// <summary>
        /// The ID of the security control. For more information see the [Security Hub controls reference] documentation.
        /// </summary>
        [Input("securityControlId", required: true)]
        public Input<string> SecurityControlId { get; set; } = null!;

        public ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterGetArgs()
        {
        }
        public static new ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterGetArgs Empty => new ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterGetArgs();
    }
}
