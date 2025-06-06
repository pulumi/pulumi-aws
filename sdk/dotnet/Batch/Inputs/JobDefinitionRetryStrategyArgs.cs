// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Batch.Inputs
{

    public sealed class JobDefinitionRetryStrategyArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Number of times to move a job to the `RUNNABLE` status. You may specify between `1` and `10` attempts.
        /// </summary>
        [Input("attempts")]
        public Input<int>? Attempts { get; set; }

        [Input("evaluateOnExits")]
        private InputList<Inputs.JobDefinitionRetryStrategyEvaluateOnExitArgs>? _evaluateOnExits;

        /// <summary>
        /// Evaluate on exit conditions under which the job should be retried or failed. If this parameter is specified, then the `attempts` parameter must also be specified. You may specify up to 5 configuration blocks.
        /// </summary>
        public InputList<Inputs.JobDefinitionRetryStrategyEvaluateOnExitArgs> EvaluateOnExits
        {
            get => _evaluateOnExits ?? (_evaluateOnExits = new InputList<Inputs.JobDefinitionRetryStrategyEvaluateOnExitArgs>());
            set => _evaluateOnExits = value;
        }

        public JobDefinitionRetryStrategyArgs()
        {
        }
        public static new JobDefinitionRetryStrategyArgs Empty => new JobDefinitionRetryStrategyArgs();
    }
}
