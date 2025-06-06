// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs : global::Pulumi.ResourceArgs
    {
        [Input("allowInterrupt")]
        public Input<bool>? AllowInterrupt { get; set; }

        [Input("allowedInputTypes", required: true)]
        public Input<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAllowedInputTypesArgs> AllowedInputTypes { get; set; } = null!;

        [Input("audioAndDtmfInputSpecification")]
        public Input<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs>? AudioAndDtmfInputSpecification { get; set; }

        [Input("mapBlockKey", required: true)]
        public Input<string> MapBlockKey { get; set; } = null!;

        [Input("textInputSpecification")]
        public Input<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationTextInputSpecificationArgs>? TextInputSpecification { get; set; }

        public V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs()
        {
        }
        public static new V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs Empty => new V2modelsSlotValueElicitationSettingPromptSpecificationPromptAttemptsSpecificationArgs();
    }
}
