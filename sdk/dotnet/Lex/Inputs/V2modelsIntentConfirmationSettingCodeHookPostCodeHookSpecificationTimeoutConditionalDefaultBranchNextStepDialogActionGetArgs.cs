// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutConditionalDefaultBranchNextStepDialogActionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// If the dialog action is `ElicitSlot`, defines the slot to elicit from the user.
        /// </summary>
        [Input("slotToElicit")]
        public Input<string>? SlotToElicit { get; set; }

        /// <summary>
        /// Whether the next message for the intent is _not_ used.
        /// </summary>
        [Input("suppressNextMessage")]
        public Input<bool>? SuppressNextMessage { get; set; }

        /// <summary>
        /// Action that the bot should execute. Valid values are `ElicitIntent`, `StartIntent`, `ElicitSlot`, `EvaluateConditional`, `InvokeDialogCodeHook`, `ConfirmIntent`, `FulfillIntent`, `CloseIntent`, `EndConversation`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutConditionalDefaultBranchNextStepDialogActionGetArgs()
        {
        }
        public static new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutConditionalDefaultBranchNextStepDialogActionGetArgs Empty => new V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecificationTimeoutConditionalDefaultBranchNextStepDialogActionGetArgs();
    }
}
