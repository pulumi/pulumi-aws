// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block for the settings on audio input. See `audio_specification`.
        /// </summary>
        [Input("audioSpecification")]
        public Input<Inputs.V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationAudioSpecificationArgs>? AudioSpecification { get; set; }

        /// <summary>
        /// Configuration block for the settings on DTMF input. See `dtmf_specification`.
        /// </summary>
        [Input("dtmfSpecification")]
        public Input<Inputs.V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationDtmfSpecificationArgs>? DtmfSpecification { get; set; }

        /// <summary>
        /// Time for which a bot waits before assuming that the customer isn't going to speak or press a key. This timeout is shared between Audio and DTMF inputs.
        /// </summary>
        [Input("startTimeoutMs", required: true)]
        public Input<int> StartTimeoutMs { get; set; } = null!;

        public V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs()
        {
        }
        public static new V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs Empty => new V2modelsIntentConfirmationSettingPromptSpecificationPromptAttemptsSpecificationAudioAndDtmfInputSpecificationArgs();
    }
}
