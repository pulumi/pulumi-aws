// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationArgs : global::Pulumi.ResourceArgs
    {
        [Input("customPayloads")]
        private InputList<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationCustomPayloadArgs>? _customPayloads;
        public InputList<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationCustomPayloadArgs> CustomPayloads
        {
            get => _customPayloads ?? (_customPayloads = new InputList<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationCustomPayloadArgs>());
            set => _customPayloads = value;
        }

        [Input("imageResponseCard")]
        public Input<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationImageResponseCardArgs>? ImageResponseCard { get; set; }

        [Input("plainTextMessage")]
        public Input<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationPlainTextMessageArgs>? PlainTextMessage { get; set; }

        [Input("ssmlMessage")]
        public Input<Inputs.V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationSsmlMessageArgs>? SsmlMessage { get; set; }

        public V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationArgs()
        {
        }
        public static new V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationArgs Empty => new V2modelsSlotValueElicitationSettingPromptSpecificationMessageGroupVariationArgs();
    }
}
