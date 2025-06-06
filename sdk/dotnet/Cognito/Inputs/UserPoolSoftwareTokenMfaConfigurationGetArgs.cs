// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito.Inputs
{

    public sealed class UserPoolSoftwareTokenMfaConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Boolean whether to enable software token Multi-Factor (MFA) tokens, such as Time-based One-Time Password (TOTP). To disable software token MFA When `sms_configuration` is not present, the `mfa_configuration` argument must be set to `OFF` and the `software_token_mfa_configuration` configuration block must be fully removed.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        public UserPoolSoftwareTokenMfaConfigurationGetArgs()
        {
        }
        public static new UserPoolSoftwareTokenMfaConfigurationGetArgs Empty => new UserPoolSoftwareTokenMfaConfigurationGetArgs();
    }
}
