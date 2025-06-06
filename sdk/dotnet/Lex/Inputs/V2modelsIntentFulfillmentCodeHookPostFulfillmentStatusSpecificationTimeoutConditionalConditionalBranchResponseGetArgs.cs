// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether the user can interrupt a speech response from Amazon Lex.
        /// </summary>
        [Input("allowInterrupt")]
        public Input<bool>? AllowInterrupt { get; set; }

        [Input("messageGroups")]
        private InputList<Inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupGetArgs>? _messageGroups;

        /// <summary>
        /// Configuration blocks for responses that Amazon Lex can send to the user. Amazon Lex chooses the actual response to send at runtime. See `message_group`.
        /// </summary>
        public InputList<Inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupGetArgs> MessageGroups
        {
            get => _messageGroups ?? (_messageGroups = new InputList<Inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseMessageGroupGetArgs>());
            set => _messageGroups = value;
        }

        public V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseGetArgs()
        {
        }
        public static new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseGetArgs Empty => new V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationTimeoutConditionalConditionalBranchResponseGetArgs();
    }
}
