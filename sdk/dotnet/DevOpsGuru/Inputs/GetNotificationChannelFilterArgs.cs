// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DevOpsGuru.Inputs
{

    public sealed class GetNotificationChannelFilterInputArgs : global::Pulumi.ResourceArgs
    {
        [Input("messageTypes", required: true)]
        private InputList<string>? _messageTypes;

        /// <summary>
        /// Events to receive notifications for.
        /// </summary>
        public InputList<string> MessageTypes
        {
            get => _messageTypes ?? (_messageTypes = new InputList<string>());
            set => _messageTypes = value;
        }

        [Input("severities", required: true)]
        private InputList<string>? _severities;

        /// <summary>
        /// Severity levels to receive notifications for.
        /// </summary>
        public InputList<string> Severities
        {
            get => _severities ?? (_severities = new InputList<string>());
            set => _severities = value;
        }

        public GetNotificationChannelFilterInputArgs()
        {
        }
        public static new GetNotificationChannelFilterInputArgs Empty => new GetNotificationChannelFilterInputArgs();
    }
}
