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
    public sealed class PipeTargetParametersBatchJobParametersContainerOverrides
    {
        /// <summary>
        /// List of commands to send to the container that overrides the default command from the Docker image or the task definition. You must also specify a container name.
        /// </summary>
        public readonly ImmutableArray<string> Commands;
        /// <summary>
        /// The environment variables to send to the container. You can add new environment variables, which are added to the container at launch, or you can override the existing environment variables from the Docker image or the task definition. You must also specify a container name. Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.PipeTargetParametersBatchJobParametersContainerOverridesEnvironment> Environments;
        /// <summary>
        /// The instance type to use for a multi-node parallel job. This parameter isn't applicable to single-node container jobs or jobs that run on Fargate resources, and shouldn't be provided.
        /// </summary>
        public readonly string? InstanceType;
        /// <summary>
        /// The type and amount of a resource to assign to a container, instead of the default value from the task definition. The only supported resource is a GPU. Detailed below.
        /// </summary>
        public readonly ImmutableArray<Outputs.PipeTargetParametersBatchJobParametersContainerOverridesResourceRequirement> ResourceRequirements;

        [OutputConstructor]
        private PipeTargetParametersBatchJobParametersContainerOverrides(
            ImmutableArray<string> commands,

            ImmutableArray<Outputs.PipeTargetParametersBatchJobParametersContainerOverridesEnvironment> environments,

            string? instanceType,

            ImmutableArray<Outputs.PipeTargetParametersBatchJobParametersContainerOverridesResourceRequirement> resourceRequirements)
        {
            Commands = commands;
            Environments = environments;
            InstanceType = instanceType;
            ResourceRequirements = resourceRequirements;
        }
    }
}
