// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentConfirmationSettingDeclinationResponseMessageGroupVariationSsmlMessageArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// SSML text that defines the prompt.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public V2modelsIntentConfirmationSettingDeclinationResponseMessageGroupVariationSsmlMessageArgs()
        {
        }
        public static new V2modelsIntentConfirmationSettingDeclinationResponseMessageGroupVariationSsmlMessageArgs Empty => new V2modelsIntentConfirmationSettingDeclinationResponseMessageGroupVariationSsmlMessageArgs();
    }
}
