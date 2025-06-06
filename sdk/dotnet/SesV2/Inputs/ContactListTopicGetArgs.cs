// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2.Inputs
{

    public sealed class ContactListTopicGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Default subscription status to be applied to a contact if the contact has not noted their preference for subscribing to a topic.
        /// </summary>
        [Input("defaultSubscriptionStatus", required: true)]
        public Input<string> DefaultSubscriptionStatus { get; set; } = null!;

        /// <summary>
        /// Description of what the topic is about, which the contact will see.
        /// </summary>
        [Input("description")]
        public Input<string>? Description { get; set; }

        /// <summary>
        /// Name of the topic the contact will see.
        /// </summary>
        [Input("displayName", required: true)]
        public Input<string> DisplayName { get; set; } = null!;

        /// <summary>
        /// Name of the topic.
        /// 
        /// The following arguments are optional:
        /// </summary>
        [Input("topicName", required: true)]
        public Input<string> TopicName { get; set; } = null!;

        public ContactListTopicGetArgs()
        {
        }
        public static new ContactListTopicGetArgs Empty => new ContactListTopicGetArgs();
    }
}
