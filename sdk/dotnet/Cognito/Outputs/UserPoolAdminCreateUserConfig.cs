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
    public sealed class UserPoolAdminCreateUserConfig
    {
        /// <summary>
        /// Set to True if only the administrator is allowed to create user profiles. Set to False if users can sign themselves up via an app.
        /// </summary>
        public readonly bool? AllowAdminCreateUserOnly;
        /// <summary>
        /// Invite message template structure. Detailed below.
        /// </summary>
        public readonly Outputs.UserPoolAdminCreateUserConfigInviteMessageTemplate? InviteMessageTemplate;

        [OutputConstructor]
        private UserPoolAdminCreateUserConfig(
            bool? allowAdminCreateUserOnly,

            Outputs.UserPoolAdminCreateUserConfigInviteMessageTemplate? inviteMessageTemplate)
        {
            AllowAdminCreateUserOnly = allowAdminCreateUserOnly;
            InviteMessageTemplate = inviteMessageTemplate;
        }
    }
}
