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
    public sealed class UserPoolUsernameConfiguration
    {
        /// <summary>
        /// Whether username case sensitivity will be applied for all users in the user pool through Cognito APIs.
        /// </summary>
        public readonly bool? CaseSensitive;

        [OutputConstructor]
        private UserPoolUsernameConfiguration(bool? caseSensitive)
        {
            CaseSensitive = caseSensitive;
        }
    }
}
