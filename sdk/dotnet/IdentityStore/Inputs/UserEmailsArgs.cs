// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.IdentityStore.Inputs
{

    public sealed class UserEmailsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// When `true`, this is the primary email associated with the user.
        /// </summary>
        [Input("primary")]
        public Input<bool>? Primary { get; set; }

        /// <summary>
        /// The type of email.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        /// <summary>
        /// The email address. This value must be unique across the identity store.
        /// </summary>
        [Input("value")]
        public Input<string>? Value { get; set; }

        public UserEmailsArgs()
        {
        }
        public static new UserEmailsArgs Empty => new UserEmailsArgs();
    }
}
