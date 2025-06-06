// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ssm.Inputs
{

    public sealed class MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersNotificationConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An Amazon Resource Name (ARN) for a Simple Notification Service (SNS) topic. Run Command pushes notifications about command status changes to this topic.
        /// </summary>
        [Input("notificationArn")]
        public Input<string>? NotificationArn { get; set; }

        [Input("notificationEvents")]
        private InputList<string>? _notificationEvents;

        /// <summary>
        /// The different events for which you can receive notifications. Valid values: `All`, `InProgress`, `Success`, `TimedOut`, `Cancelled`, and `Failed`
        /// </summary>
        public InputList<string> NotificationEvents
        {
            get => _notificationEvents ?? (_notificationEvents = new InputList<string>());
            set => _notificationEvents = value;
        }

        /// <summary>
        /// When specified with `Command`, receive notification when the status of a command changes. When specified with `Invocation`, for commands sent to multiple instances, receive notification on a per-instance basis when the status of a command changes. Valid values: `Command` and `Invocation`
        /// </summary>
        [Input("notificationType")]
        public Input<string>? NotificationType { get; set; }

        public MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersNotificationConfigArgs()
        {
        }
        public static new MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersNotificationConfigArgs Empty => new MaintenanceWindowTaskTaskInvocationParametersRunCommandParametersNotificationConfigArgs();
    }
}
