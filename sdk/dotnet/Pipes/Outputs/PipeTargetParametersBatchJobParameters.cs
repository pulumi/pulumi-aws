// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Outputs
{

    [OutputType]
    public sealed class PipeTargetParametersBatchJobParameters
    {
        /// <summary>
        /// The array properties for the submitted job, such as the size of the array. The array size can be between 2 and 10,000. If you specify array properties for a job, it becomes an array job. This parameter is used only if the target is an AWS Batch job. Detailed below.
        /// </summary>
        public readonly Outputs.PipeTargetParametersBatchJobParametersArrayProperties? ArrayProperties;
        /// <summary>
        /// The overrides that are sent to a container. Detailed below.
        /// </summary>
        public readonly Outputs.PipeTargetParametersBatchJobParametersContainerOverrides? ContainerOverrides;
        /// <summary>
        /// A list of dependencies for the job. A job can depend upon a maximum of 20 jobs. You can specify a SEQUENTIAL type dependency without specifying a job ID for array jobs so that each child array job completes sequentially, starting at index 0. You can also specify an N_TO_N type dependency with a job ID for array jobs. In that case, each index child of this job must wait for the corresponding index child of each dependency to complete before it can begin. Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.PipeTargetParametersBatchJobParametersDependsOn> DependsOns;
        /// <summary>
        /// The job definition used by this job. This value can be one of name, name:revision, or the Amazon Resource Name (ARN) for the job definition. If name is specified without a revision then the latest active revision is used.
        /// </summary>
        public readonly string JobDefinition;
        /// <summary>
        /// The name of the job. It can be up to 128 letters long.
        /// </summary>
        public readonly string JobName;
        /// <summary>
        /// Additional parameters passed to the job that replace parameter substitution placeholders that are set in the job definition. Parameters are specified as a key and value pair mapping. Parameters included here override any corresponding parameter defaults from the job definition. Detailed below.
        /// </summary>
        public readonly ImmutableDictionary<string, string>? Parameters;
        /// <summary>
        /// The retry strategy to use for failed jobs. When a retry strategy is specified here, it overrides the retry strategy defined in the job definition. Detailed below.
        /// </summary>
        public readonly Outputs.PipeTargetParametersBatchJobParametersRetryStrategy? RetryStrategy;

        [OutputConstructor]
        private PipeTargetParametersBatchJobParameters(
            Outputs.PipeTargetParametersBatchJobParametersArrayProperties? arrayProperties,

            Outputs.PipeTargetParametersBatchJobParametersContainerOverrides? containerOverrides,

            ImmutableArray<Outputs.PipeTargetParametersBatchJobParametersDependsOn> dependsOns,

            string jobDefinition,

            string jobName,

            ImmutableDictionary<string, string>? parameters,

            Outputs.PipeTargetParametersBatchJobParametersRetryStrategy? retryStrategy)
        {
            ArrayProperties = arrayProperties;
            ContainerOverrides = containerOverrides;
            DependsOns = dependsOns;
            JobDefinition = jobDefinition;
            JobName = jobName;
            Parameters = parameters;
            RetryStrategy = retryStrategy;
        }
    }
}
