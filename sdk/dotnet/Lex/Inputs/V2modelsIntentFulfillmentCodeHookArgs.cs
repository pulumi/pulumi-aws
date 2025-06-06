// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Lex.Inputs
{

    public sealed class V2modelsIntentFulfillmentCodeHookArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether the fulfillment code hook is used. When active is false, the code hook doesn't run.
        /// </summary>
        [Input("active")]
        public Input<bool>? Active { get; set; }

        /// <summary>
        /// Whether a Lambda function should be invoked to fulfill a specific intent.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        /// <summary>
        /// Configuration block for settings for update messages sent to the user for long-running Lambda fulfillment functions. Fulfillment updates can be used only with streaming conversations. See `fulfillment_updates_specification`.
        /// </summary>
        [Input("fulfillmentUpdatesSpecification")]
        public Input<Inputs.V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecificationArgs>? FulfillmentUpdatesSpecification { get; set; }

        /// <summary>
        /// Configuration block for settings for messages sent to the user for after the Lambda fulfillment function completes. Post-fulfillment messages can be sent for both streaming and non-streaming conversations. See `post_fulfillment_status_specification`.
        /// </summary>
        [Input("postFulfillmentStatusSpecification")]
        public Input<Inputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecificationArgs>? PostFulfillmentStatusSpecification { get; set; }

        public V2modelsIntentFulfillmentCodeHookArgs()
        {
        }
        public static new V2modelsIntentFulfillmentCodeHookArgs Empty => new V2modelsIntentFulfillmentCodeHookArgs();
    }
}
