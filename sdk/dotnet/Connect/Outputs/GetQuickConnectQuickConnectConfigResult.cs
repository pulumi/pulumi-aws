// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Connect.Outputs
{

    [OutputType]
    public sealed class GetQuickConnectQuickConnectConfigResult
    {
        /// <summary>
        /// Phone configuration of the Quick Connect. This is returned only if `quick_connect_type` is `PHONE_NUMBER`. The `phone_config` block is documented below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetQuickConnectQuickConnectConfigPhoneConfigResult> PhoneConfigs;
        /// <summary>
        /// Queue configuration of the Quick Connect. This is returned only if `quick_connect_type` is `QUEUE`. The `queue_config` block is documented below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetQuickConnectQuickConnectConfigQueueConfigResult> QueueConfigs;
        /// <summary>
        /// Configuration type of the Quick Connect. Valid values are `PHONE_NUMBER`, `QUEUE`, `USER`.
        /// </summary>
        public readonly string QuickConnectType;
        /// <summary>
        /// User configuration of the Quick Connect. This is returned only if `quick_connect_type` is `USER`. The `user_config` block is documented below.
        /// </summary>
        public readonly ImmutableArray<Outputs.GetQuickConnectQuickConnectConfigUserConfigResult> UserConfigs;

        [OutputConstructor]
        private GetQuickConnectQuickConnectConfigResult(
            ImmutableArray<Outputs.GetQuickConnectQuickConnectConfigPhoneConfigResult> phoneConfigs,

            ImmutableArray<Outputs.GetQuickConnectQuickConnectConfigQueueConfigResult> queueConfigs,

            string quickConnectType,

            ImmutableArray<Outputs.GetQuickConnectQuickConnectConfigUserConfigResult> userConfigs)
        {
            PhoneConfigs = phoneConfigs;
            QueueConfigs = queueConfigs;
            QuickConnectType = quickConnectType;
            UserConfigs = userConfigs;
        }
    }
}
