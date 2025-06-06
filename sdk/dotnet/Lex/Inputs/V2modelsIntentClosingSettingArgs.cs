// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentClosingSettingArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether an intent's closing response is used. When this field is false, the closing response isn't sent to the user. If the active field isn't specified, the default is true.
        /// </summary>
        [Input("active")]
        public Input<bool>? Active { get; set; }

        /// <summary>
        /// Configuration block for response that Amazon Lex sends to the user when the intent is complete. See `closing_response`.
        /// </summary>
        [Input("closingResponse")]
        public Input<Inputs.V2modelsIntentClosingSettingClosingResponseArgs>? ClosingResponse { get; set; }

        /// <summary>
        /// Configuration block for list of conditional branches associated with the intent's closing response. These branches are executed when the `next_step` attribute is set to `EvalutateConditional`. See `conditional`.
        /// </summary>
        [Input("conditional")]
        public Input<Inputs.V2modelsIntentClosingSettingConditionalArgs>? Conditional { get; set; }

        /// <summary>
        /// Next step that the bot executes after playing the intent's closing response. See `next_step`.
        /// </summary>
        [Input("nextStep")]
        public Input<Inputs.V2modelsIntentClosingSettingNextStepArgs>? NextStep { get; set; }

        public V2modelsIntentClosingSettingArgs()
        {
        }
        public static new V2modelsIntentClosingSettingArgs Empty => new V2modelsIntentClosingSettingArgs();
    }
}
