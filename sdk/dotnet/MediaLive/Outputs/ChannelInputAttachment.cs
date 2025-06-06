// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Outputs
{

    [OutputType]
    public sealed class ChannelInputAttachment
    {
        /// <summary>
        /// User-specified settings for defining what the conditions are for declaring the input unhealthy and failing over to a different input. See Automatic Input Failover Settings for more details.
        /// </summary>
        public readonly Outputs.ChannelInputAttachmentAutomaticInputFailoverSettings? AutomaticInputFailoverSettings;
        /// <summary>
        /// User-specified name for the attachment.
        /// </summary>
        public readonly string InputAttachmentName;
        /// <summary>
        /// The ID of the input.
        /// </summary>
        public readonly string InputId;
        /// <summary>
        /// Settings of an input. See Input Settings for more details.
        /// </summary>
        public readonly Outputs.ChannelInputAttachmentInputSettings? InputSettings;

        [OutputConstructor]
        private ChannelInputAttachment(
            Outputs.ChannelInputAttachmentAutomaticInputFailoverSettings? automaticInputFailoverSettings,

            string inputAttachmentName,

            string inputId,

            Outputs.ChannelInputAttachmentInputSettings? inputSettings)
        {
            AutomaticInputFailoverSettings = automaticInputFailoverSettings;
            InputAttachmentName = inputAttachmentName;
            InputId = inputId;
            InputSettings = inputSettings;
        }
    }
}
