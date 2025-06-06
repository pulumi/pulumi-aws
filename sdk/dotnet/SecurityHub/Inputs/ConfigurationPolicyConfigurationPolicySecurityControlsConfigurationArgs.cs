// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Inputs
{

    public sealed class ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationArgs : global::Pulumi.ResourceArgs
    {
        [Input("disabledControlIdentifiers")]
        private InputList<string>? _disabledControlIdentifiers;

        /// <summary>
        /// A list of security controls that are disabled in the configuration policy Security Hub enables all other controls (including newly released controls) other than the listed controls. Conflicts with `enabled_control_identifiers`.
        /// </summary>
        public InputList<string> DisabledControlIdentifiers
        {
            get => _disabledControlIdentifiers ?? (_disabledControlIdentifiers = new InputList<string>());
            set => _disabledControlIdentifiers = value;
        }

        [Input("enabledControlIdentifiers")]
        private InputList<string>? _enabledControlIdentifiers;

        /// <summary>
        /// A list of security controls that are enabled in the configuration policy. Security Hub disables all other controls (including newly released controls) other than the listed controls. Conflicts with `disabled_control_identifiers`.
        /// </summary>
        public InputList<string> EnabledControlIdentifiers
        {
            get => _enabledControlIdentifiers ?? (_enabledControlIdentifiers = new InputList<string>());
            set => _enabledControlIdentifiers = value;
        }

        [Input("securityControlCustomParameters")]
        private InputList<Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterArgs>? _securityControlCustomParameters;

        /// <summary>
        /// A list of control parameter customizations that are included in a configuration policy. Include multiple blocks to define multiple control custom parameters. See below.
        /// </summary>
        public InputList<Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterArgs> SecurityControlCustomParameters
        {
            get => _securityControlCustomParameters ?? (_securityControlCustomParameters = new InputList<Inputs.ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationSecurityControlCustomParameterArgs>());
            set => _securityControlCustomParameters = value;
        }

        public ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationArgs()
        {
        }
        public static new ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationArgs Empty => new ConfigurationPolicyConfigurationPolicySecurityControlsConfigurationArgs();
    }
}
