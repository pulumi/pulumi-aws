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
    public sealed class V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroup
    {
        /// <summary>
        /// Configuration block for the primary message that Amazon Lex should send to the user. See `message`.
        /// </summary>
        public readonly Outputs.V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessage Message;
        /// <summary>
        /// Configuration blocks for message variations to send to the user. When variations are defined, Amazon Lex chooses the primary message or one of the variations to send to the user. See `variation`.
        /// </summary>
        public readonly ImmutableArray<Outputs.V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariation> Variations;

        [OutputConstructor]
        private V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroup(
            Outputs.V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupMessage message,

            ImmutableArray<Outputs.V2modelsIntentConfirmationSettingDeclinationConditionalDefaultBranchResponseMessageGroupVariation> variations)
        {
            Message = message;
            Variations = variations;
        }
    }
}
