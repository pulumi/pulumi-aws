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
    public sealed class V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStep
    {
        /// <summary>
        /// Configuration block for action that the bot executes at runtime when the conversation reaches this step. See `dialog_action`.
        /// </summary>
        public readonly Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStepDialogAction? DialogAction;
        /// <summary>
        /// Configuration block for override settings to configure the intent state. See `intent`.
        /// </summary>
        public readonly Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStepIntent? Intent;
        /// <summary>
        /// Map of key/value pairs representing session-specific context information. It contains application information passed between Amazon Lex and a client application.
        /// </summary>
        public readonly ImmutableDictionary<string, string>? SessionAttributes;

        [OutputConstructor]
        private V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStep(
            Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStepDialogAction? dialogAction,

            Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureNextStepIntent? intent,

            ImmutableDictionary<string, string>? sessionAttributes)
        {
            DialogAction = dialogAction;
            Intent = intent;
            SessionAttributes = sessionAttributes;
        }
    }
}
