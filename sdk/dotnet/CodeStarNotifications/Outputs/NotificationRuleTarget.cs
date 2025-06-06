// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodeStarNotifications.Outputs
{

    [OutputType]
    public sealed class NotificationRuleTarget
    {
        /// <summary>
        /// The ARN of notification rule target. For example, a SNS Topic ARN.
        /// </summary>
        public readonly string Address;
        /// <summary>
        /// The status of the notification rule. Possible values are `ENABLED` and `DISABLED`, default is `ENABLED`.
        /// </summary>
        public readonly string? Status;
        /// <summary>
        /// The type of the notification target. Default value is `SNS`.
        /// </summary>
        public readonly string? Type;

        [OutputConstructor]
        private NotificationRuleTarget(
            string address,

            string? status,

            string? type)
        {
            Address = address;
            Status = status;
            Type = type;
        }
    }
}
