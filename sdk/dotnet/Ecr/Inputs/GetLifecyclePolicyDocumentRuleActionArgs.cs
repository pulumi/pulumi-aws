// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecr.Inputs
{

    public sealed class GetLifecyclePolicyDocumentRuleActionInputArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The supported value is `expire`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public GetLifecyclePolicyDocumentRuleActionInputArgs()
        {
        }
        public static new GetLifecyclePolicyDocumentRuleActionInputArgs Empty => new GetLifecyclePolicyDocumentRuleActionInputArgs();
    }
}
