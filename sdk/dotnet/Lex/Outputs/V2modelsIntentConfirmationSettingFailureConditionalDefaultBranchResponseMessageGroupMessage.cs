// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Outputs
{

    [OutputType]
    public sealed class V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessage
    {
        /// <summary>
        /// Configuration block for a message in a custom format defined by the client application. See `custom_payload`.
        /// </summary>
        public readonly Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessageCustomPayload? CustomPayload;
        /// <summary>
        /// Configuration block for a message that defines a response card that the client application can show to the user. See `image_response_card`.
        /// </summary>
        public readonly Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessageImageResponseCard? ImageResponseCard;
        /// <summary>
        /// Configuration block for a message in plain text format. See `plain_text_message`.
        /// </summary>
        public readonly Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessagePlainTextMessage? PlainTextMessage;
        /// <summary>
        /// Configuration block for a message in Speech Synthesis Markup Language (SSML). See `ssml_message`.
        /// </summary>
        public readonly Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessageSsmlMessage? SsmlMessage;

        [OutputConstructor]
        private V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessage(
            Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessageCustomPayload? customPayload,

            Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessageImageResponseCard? imageResponseCard,

            Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessagePlainTextMessage? plainTextMessage,

            Outputs.V2modelsIntentConfirmationSettingFailureConditionalDefaultBranchResponseMessageGroupMessageSsmlMessage? ssmlMessage)
        {
            CustomPayload = customPayload;
            ImageResponseCard = imageResponseCard;
            PlainTextMessage = plainTextMessage;
            SsmlMessage = ssmlMessage;
        }
    }
}
