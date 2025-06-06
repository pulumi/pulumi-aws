// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Bedrock.Outputs
{

    [OutputType]
    public sealed class AgentAgentActionGroupActionGroupExecutor
    {
        /// <summary>
        /// Custom control method for handling the information elicited from the user. Valid values: `RETURN_CONTROL`.
        /// To skip using a Lambda function and instead return the predicted action group, in addition to the parameters and information required for it, in the `InvokeAgent` response, specify `RETURN_CONTROL`.
        /// Only one of `custom_control` or `lambda` can be specified.
        /// </summary>
        public readonly string? CustomControl;
        /// <summary>
        /// ARN of the Lambda function containing the business logic that is carried out upon invoking the action.
        /// Only one of `lambda` or `custom_control` can be specified.
        /// </summary>
        public readonly string? Lambda;

        [OutputConstructor]
        private AgentAgentActionGroupActionGroupExecutor(
            string? customControl,

            string? lambda)
        {
            CustomControl = customControl;
            Lambda = lambda;
        }
    }
}
