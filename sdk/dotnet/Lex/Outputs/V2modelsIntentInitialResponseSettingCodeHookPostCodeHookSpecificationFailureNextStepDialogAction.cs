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
    public sealed class V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStepDialogAction
    {
        /// <summary>
        /// If the dialog action is `ElicitSlot`, defines the slot to elicit from the user.
        /// </summary>
        public readonly string? SlotToElicit;
        /// <summary>
        /// Whether the next message for the intent is _not_ used.
        /// </summary>
        public readonly bool? SuppressNextMessage;
        /// <summary>
        /// Action that the bot should execute. Valid values are `ElicitIntent`, `StartIntent`, `ElicitSlot`, `EvaluateConditional`, `InvokeDialogCodeHook`, `ConfirmIntent`, `FulfillIntent`, `CloseIntent`, `EndConversation`.
        /// </summary>
        public readonly string Type;

        [OutputConstructor]
        private V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStepDialogAction(
            string? slotToElicit,

            bool? suppressNextMessage,

            string type)
        {
            SlotToElicit = slotToElicit;
            SuppressNextMessage = suppressNextMessage;
            Type = type;
        }
    }
}
