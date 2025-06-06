// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs : global::Pulumi.ResourceArgs
    {
        [Input("allowInterrupt")]
        public Input<bool>? AllowInterrupt { get; set; }

        [Input("allowedInputTypes", required: true)]
        public Input<Inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs> AllowedInputTypes { get; set; } = null!;

        [Input("audioAndDtmfInputSpecification")]
        public Input<Inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs>? AudioAndDtmfInputSpecification { get; set; }

        [Input("mapBlockKey", required: true)]
        public Input<string> MapBlockKey { get; set; } = null!;

        [Input("textInputSpecification")]
        public Input<Inputs.V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs>? TextInputSpecification { get; set; }

        public V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs()
        {
        }
        public static new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs Empty => new V2modelsSlotSubSlotSettingSlotSpecificationValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs();
    }
}
