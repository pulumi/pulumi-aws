// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Iot.Inputs
{

    public sealed class TopicRuleStepFunctionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The prefix used to generate, along with a UUID, the unique state machine execution name.
        /// </summary>
        [Input("executionNamePrefix")]
        public Input<string>? ExecutionNamePrefix { get; set; }

        /// <summary>
        /// The ARN of the IAM role that grants access to start execution of the state machine.
        /// </summary>
        [Input("roleArn", required: true)]
        public Input<string> RoleArn { get; set; } = null!;

        /// <summary>
        /// The name of the Step Functions state machine whose execution will be started.
        /// </summary>
        [Input("stateMachineName", required: true)]
        public Input<string> StateMachineName { get; set; } = null!;

        public TopicRuleStepFunctionArgs()
        {
        }
        public static new TopicRuleStepFunctionArgs Empty => new TopicRuleStepFunctionArgs();
    }
}
