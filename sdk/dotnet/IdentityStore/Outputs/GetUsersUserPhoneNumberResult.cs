// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.IdentityStore.Outputs
{

    [OutputType]
    public sealed class GetUsersUserPhoneNumberResult
    {
        /// <summary>
        /// When `true`, this is the primary phone number associated with the user.
        /// </summary>
        public readonly bool Primary;
        /// <summary>
        /// Type of phone number.
        /// </summary>
        public readonly string Type;
        /// <summary>
        /// User's phone number.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private GetUsersUserPhoneNumberResult(
            bool primary,

            string type,

            string value)
        {
            Primary = primary;
            Type = type;
            Value = value;
        }
    }
}
