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
    public sealed class V2modelsIntentFulfillmentCodeHook
    {
        /// <summary>
        /// Whether the fulfillment code hook is used. When active is false, the code hook doesn't run.
        /// </summary>
        public readonly bool? Active;
        /// <summary>
        /// Whether a Lambda function should be invoked to fulfill a specific intent.
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// Configuration block for settings for update messages sent to the user for long-running Lambda fulfillment functions. Fulfillment updates can be used only with streaming conversations. See `fulfillment_updates_specification`.
        /// </summary>
        public readonly Outputs.V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecification? FulfillmentUpdatesSpecification;
        /// <summary>
        /// Configuration block for settings for messages sent to the user for after the Lambda fulfillment function completes. Post-fulfillment messages can be sent for both streaming and non-streaming conversations. See `post_fulfillment_status_specification`.
        /// </summary>
        public readonly Outputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecification? PostFulfillmentStatusSpecification;

        [OutputConstructor]
        private V2modelsIntentFulfillmentCodeHook(
            bool? active,

            bool enabled,

            Outputs.V2modelsIntentFulfillmentCodeHookFulfillmentUpdatesSpecification? fulfillmentUpdatesSpecification,

            Outputs.V2modelsIntentFulfillmentCodeHookPostFulfillmentStatusSpecification? postFulfillmentStatusSpecification)
        {
            Active = active;
            Enabled = enabled;
            FulfillmentUpdatesSpecification = fulfillmentUpdatesSpecification;
            PostFulfillmentStatusSpecification = postFulfillmentStatusSpecification;
        }
    }
}
