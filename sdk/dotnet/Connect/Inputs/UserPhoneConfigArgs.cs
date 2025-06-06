// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect.Inputs
{

    public sealed class UserPhoneConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The After Call Work (ACW) timeout setting, in seconds. Minimum value of 0.
        /// </summary>
        [Input("afterContactWorkTimeLimit")]
        public Input<int>? AfterContactWorkTimeLimit { get; set; }

        /// <summary>
        /// When Auto-Accept Call is enabled for an available agent, the agent connects to contacts automatically.
        /// </summary>
        [Input("autoAccept")]
        public Input<bool>? AutoAccept { get; set; }

        /// <summary>
        /// The phone number for the user's desk phone. Required if `phone_type` is set as `DESK_PHONE`.
        /// </summary>
        [Input("deskPhoneNumber")]
        public Input<string>? DeskPhoneNumber { get; set; }

        /// <summary>
        /// The phone type. Valid values are `DESK_PHONE` and `SOFT_PHONE`.
        /// </summary>
        [Input("phoneType", required: true)]
        public Input<string> PhoneType { get; set; } = null!;

        public UserPhoneConfigArgs()
        {
        }
        public static new UserPhoneConfigArgs Empty => new UserPhoneConfigArgs();
    }
}
