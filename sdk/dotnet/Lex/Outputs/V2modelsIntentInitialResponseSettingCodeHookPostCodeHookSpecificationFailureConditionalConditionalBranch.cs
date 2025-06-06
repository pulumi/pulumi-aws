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
    public sealed class V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranch
    {
        /// <summary>
        /// Configuration block for the expression to evaluate. If the condition is true, the branch's actions are taken. See `condition`.
        /// </summary>
        public readonly Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranchCondition Condition;
        /// <summary>
        /// Name of the branch.
        /// </summary>
        public readonly string Name;
        /// <summary>
        /// Configuration block for the next step in the conversation. See `next_step`.
        /// </summary>
        public readonly Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranchNextStep NextStep;
        /// <summary>
        /// Configuration block for a list of message groups that Amazon Lex uses to respond to the user input. See `response`.
        /// </summary>
        public readonly Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranchResponse? Response;

        [OutputConstructor]
        private V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranch(
            Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranchCondition condition,

            string name,

            Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranchNextStep nextStep,

            Outputs.V2modelsIntentInitialResponseSettingCodeHookPostCodeHookSpecificationFailureConditionalConditionalBranchResponse? response)
        {
            Condition = condition;
            Name = name;
            NextStep = nextStep;
            Response = response;
        }
    }
}
