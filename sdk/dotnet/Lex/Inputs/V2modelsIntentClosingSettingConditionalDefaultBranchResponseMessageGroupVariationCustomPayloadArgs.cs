// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// String that is sent to your application.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs()
        {
        }
        public static new V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs Empty => new V2modelsIntentClosingSettingConditionalDefaultBranchResponseMessageGroupVariationCustomPayloadArgs();
    }
}
