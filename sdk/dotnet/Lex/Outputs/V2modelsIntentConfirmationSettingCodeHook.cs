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
    public sealed class V2modelsIntentConfirmationSettingCodeHook
    {
        /// <summary>
        /// Whether a dialog code hook is used when the intent is activated.
        /// </summary>
        public readonly bool Active;
        /// <summary>
        /// Whether a Lambda function should be invoked for the dialog.
        /// </summary>
        public readonly bool EnableCodeHookInvocation;
        /// <summary>
        /// Label that indicates the dialog step from which the dialog code hook is happening.
        /// </summary>
        public readonly string? InvocationLabel;
        /// <summary>
        /// Configuration block that contains the responses and actions that Amazon Lex takes after the Lambda function is complete. See `post_code_hook_specification`.
        /// </summary>
        public readonly Outputs.V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecification PostCodeHookSpecification;

        [OutputConstructor]
        private V2modelsIntentConfirmationSettingCodeHook(
            bool active,

            bool enableCodeHookInvocation,

            string? invocationLabel,

            Outputs.V2modelsIntentConfirmationSettingCodeHookPostCodeHookSpecification postCodeHookSpecification)
        {
            Active = active;
            EnableCodeHookInvocation = enableCodeHookInvocation;
            InvocationLabel = invocationLabel;
            PostCodeHookSpecification = postCodeHookSpecification;
        }
    }
}
