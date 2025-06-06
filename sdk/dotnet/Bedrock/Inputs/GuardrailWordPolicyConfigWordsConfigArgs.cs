// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Inputs
{

    public sealed class GuardrailWordPolicyConfigWordsConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The custom word text.
        /// </summary>
        [Input("text", required: true)]
        public Input<string> Text { get; set; } = null!;

        public GuardrailWordPolicyConfigWordsConfigArgs()
        {
        }
        public static new GuardrailWordPolicyConfigWordsConfigArgs Empty => new GuardrailWordPolicyConfigWordsConfigArgs();
    }
}
