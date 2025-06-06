// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Cognito.Outputs
{

    [OutputType]
    public sealed class UserPoolAccountRecoverySetting
    {
        /// <summary>
        /// List of Account Recovery Options of the following structure:
        /// </summary>
        public readonly ImmutableArray<Outputs.UserPoolAccountRecoverySettingRecoveryMechanism> RecoveryMechanisms;

        [OutputConstructor]
        private UserPoolAccountRecoverySetting(ImmutableArray<Outputs.UserPoolAccountRecoverySettingRecoveryMechanism> recoveryMechanisms)
        {
            RecoveryMechanisms = recoveryMechanisms;
        }
    }
}
