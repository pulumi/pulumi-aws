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
    public sealed class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSetting
    {
        /// <summary>
        /// List of default values for a slot.
        /// See the `default_value_specification` argument reference below.
        /// </summary>
        public readonly ImmutableArray<Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingDefaultValueSpecification> DefaultValueSpecifications;
        /// <summary>
        /// Prompt that Amazon Lex uses to elicit the slot value from the user.
        /// See the `aws.lex.V2modelsIntent` resource for details on the `prompt_specification` argument reference - they are identical.
        /// </summary>
        public readonly Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecification PromptSpecification;
        public readonly ImmutableArray<Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingSampleUtterance> SampleUtterances;
        /// <summary>
        /// Specifies the prompts that Amazon Lex uses while a bot is waiting for customer input.
        /// See the `wait_and_continue_specification` argument reference below.
        /// </summary>
        public readonly ImmutableArray<Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecification> WaitAndContinueSpecifications;

        [OutputConstructor]
        private V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSetting(
            ImmutableArray<Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingDefaultValueSpecification> defaultValueSpecifications,

            Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecification promptSpecification,

            ImmutableArray<Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingSampleUtterance> sampleUtterances,

            ImmutableArray<Outputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingWaitAndContinueSpecification> waitAndContinueSpecifications)
        {
            DefaultValueSpecifications = defaultValueSpecifications;
            PromptSpecification = promptSpecification;
            SampleUtterances = sampleUtterances;
            WaitAndContinueSpecifications = waitAndContinueSpecifications;
        }
    }
}
