// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityLake.Inputs
{

    public sealed class SubscriberNotificationConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The configurations for HTTPS subscriber notification.
        /// </summary>
        [Input("httpsNotificationConfiguration")]
        public Input<Inputs.SubscriberNotificationConfigurationHttpsNotificationConfigurationGetArgs>? HttpsNotificationConfiguration { get; set; }

        /// <summary>
        /// The configurations for SQS subscriber notification.
        /// There are no parameters within `sqs_notification_configuration`.
        /// </summary>
        [Input("sqsNotificationConfiguration")]
        public Input<Inputs.SubscriberNotificationConfigurationSqsNotificationConfigurationGetArgs>? SqsNotificationConfiguration { get; set; }

        public SubscriberNotificationConfigurationGetArgs()
        {
        }
        public static new SubscriberNotificationConfigurationGetArgs Empty => new SubscriberNotificationConfigurationGetArgs();
    }
}
