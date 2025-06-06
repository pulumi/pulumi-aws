// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class FlowDefinitionHumanLoopConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The Amazon Resource Name (ARN) of the human task user interface.
        /// </summary>
        [Input("humanTaskUiArn", required: true)]
        public Input<string> HumanTaskUiArn { get; set; } = null!;

        /// <summary>
        /// Defines the amount of money paid to an Amazon Mechanical Turk worker for each task performed. See Public Workforce Task Price details below.
        /// </summary>
        [Input("publicWorkforceTaskPrice")]
        public Input<Inputs.FlowDefinitionHumanLoopConfigPublicWorkforceTaskPriceArgs>? PublicWorkforceTaskPrice { get; set; }

        /// <summary>
        /// The length of time that a task remains available for review by human workers. Valid value range between `1` and `864000`.
        /// </summary>
        [Input("taskAvailabilityLifetimeInSeconds")]
        public Input<int>? TaskAvailabilityLifetimeInSeconds { get; set; }

        /// <summary>
        /// The number of distinct workers who will perform the same task on each object. Valid value range between `1` and `3`.
        /// </summary>
        [Input("taskCount", required: true)]
        public Input<int> TaskCount { get; set; } = null!;

        /// <summary>
        /// A description for the human worker task.
        /// </summary>
        [Input("taskDescription", required: true)]
        public Input<string> TaskDescription { get; set; } = null!;

        [Input("taskKeywords")]
        private InputList<string>? _taskKeywords;

        /// <summary>
        /// An array of keywords used to describe the task so that workers can discover the task.
        /// </summary>
        public InputList<string> TaskKeywords
        {
            get => _taskKeywords ?? (_taskKeywords = new InputList<string>());
            set => _taskKeywords = value;
        }

        /// <summary>
        /// The amount of time that a worker has to complete a task. The default value is `3600` seconds.
        /// </summary>
        [Input("taskTimeLimitInSeconds")]
        public Input<int>? TaskTimeLimitInSeconds { get; set; }

        /// <summary>
        /// A title for the human worker task.
        /// </summary>
        [Input("taskTitle", required: true)]
        public Input<string> TaskTitle { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the human task user interface. Amazon Resource Name (ARN) of a team of workers. For Public workforces see [AWS Docs](https://docs.aws.amazon.com/sagemaker/latest/dg/sms-workforce-management-public.html).
        /// </summary>
        [Input("workteamArn", required: true)]
        public Input<string> WorkteamArn { get; set; } = null!;

        public FlowDefinitionHumanLoopConfigArgs()
        {
        }
        public static new FlowDefinitionHumanLoopConfigArgs Empty => new FlowDefinitionHumanLoopConfigArgs();
    }
}
