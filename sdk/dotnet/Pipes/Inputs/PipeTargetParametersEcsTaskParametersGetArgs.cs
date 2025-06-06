// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeTargetParametersEcsTaskParametersGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("capacityProviderStrategies")]
        private InputList<Inputs.PipeTargetParametersEcsTaskParametersCapacityProviderStrategyGetArgs>? _capacityProviderStrategies;

        /// <summary>
        /// List of capacity provider strategies to use for the task. If a capacityProviderStrategy is specified, the launchType parameter must be omitted. If no capacityProviderStrategy or launchType is specified, the defaultCapacityProviderStrategy for the cluster is used. Detailed below.
        /// </summary>
        public InputList<Inputs.PipeTargetParametersEcsTaskParametersCapacityProviderStrategyGetArgs> CapacityProviderStrategies
        {
            get => _capacityProviderStrategies ?? (_capacityProviderStrategies = new InputList<Inputs.PipeTargetParametersEcsTaskParametersCapacityProviderStrategyGetArgs>());
            set => _capacityProviderStrategies = value;
        }

        /// <summary>
        /// Specifies whether to enable Amazon ECS managed tags for the task. Valid values: true, false.
        /// </summary>
        [Input("enableEcsManagedTags")]
        public Input<bool>? EnableEcsManagedTags { get; set; }

        /// <summary>
        /// Whether or not to enable the execute command functionality for the containers in this task. If true, this enables execute command functionality on all containers in the task. Valid values: true, false.
        /// </summary>
        [Input("enableExecuteCommand")]
        public Input<bool>? EnableExecuteCommand { get; set; }

        /// <summary>
        /// Specifies an Amazon ECS task group for the task. The maximum length is 255 characters.
        /// </summary>
        [Input("group")]
        public Input<string>? Group { get; set; }

        /// <summary>
        /// Specifies the launch type on which your task is running. The launch type that you specify here must match one of the launch type (compatibilities) of the target task. The FARGATE value is supported only in the Regions where AWS Fargate with Amazon ECS is supported. Valid Values: EC2, FARGATE, EXTERNAL
        /// </summary>
        [Input("launchType")]
        public Input<string>? LaunchType { get; set; }

        /// <summary>
        /// Use this structure if the Amazon ECS task uses the awsvpc network mode. This structure specifies the VPC subnets and security groups associated with the task, and whether a public IP address is to be used. This structure is required if LaunchType is FARGATE because the awsvpc mode is required for Fargate tasks. If you specify NetworkConfiguration when the target ECS task does not use the awsvpc network mode, the task fails. Detailed below.
        /// </summary>
        [Input("networkConfiguration")]
        public Input<Inputs.PipeTargetParametersEcsTaskParametersNetworkConfigurationGetArgs>? NetworkConfiguration { get; set; }

        /// <summary>
        /// The overrides that are associated with a task. Detailed below.
        /// </summary>
        [Input("overrides")]
        public Input<Inputs.PipeTargetParametersEcsTaskParametersOverridesGetArgs>? Overrides { get; set; }

        [Input("placementConstraints")]
        private InputList<Inputs.PipeTargetParametersEcsTaskParametersPlacementConstraintGetArgs>? _placementConstraints;

        /// <summary>
        /// An array of placement constraint objects to use for the task. You can specify up to 10 constraints per task (including constraints in the task definition and those specified at runtime). Detailed below.
        /// </summary>
        public InputList<Inputs.PipeTargetParametersEcsTaskParametersPlacementConstraintGetArgs> PlacementConstraints
        {
            get => _placementConstraints ?? (_placementConstraints = new InputList<Inputs.PipeTargetParametersEcsTaskParametersPlacementConstraintGetArgs>());
            set => _placementConstraints = value;
        }

        [Input("placementStrategies")]
        private InputList<Inputs.PipeTargetParametersEcsTaskParametersPlacementStrategyGetArgs>? _placementStrategies;

        /// <summary>
        /// The placement strategy objects to use for the task. You can specify a maximum of five strategy rules per task. Detailed below.
        /// </summary>
        public InputList<Inputs.PipeTargetParametersEcsTaskParametersPlacementStrategyGetArgs> PlacementStrategies
        {
            get => _placementStrategies ?? (_placementStrategies = new InputList<Inputs.PipeTargetParametersEcsTaskParametersPlacementStrategyGetArgs>());
            set => _placementStrategies = value;
        }

        /// <summary>
        /// Specifies the platform version for the task. Specify only the numeric portion of the platform version, such as 1.1.0. This structure is used only if LaunchType is FARGATE.
        /// </summary>
        [Input("platformVersion")]
        public Input<string>? PlatformVersion { get; set; }

        /// <summary>
        /// Specifies whether to propagate the tags from the task definition to the task. If no value is specified, the tags are not propagated. Tags can only be propagated to the task during task creation. To add tags to a task after task creation, use the TagResource API action. Valid Values: TASK_DEFINITION
        /// </summary>
        [Input("propagateTags")]
        public Input<string>? PropagateTags { get; set; }

        /// <summary>
        /// The reference ID to use for the task. Maximum length of 1,024.
        /// </summary>
        [Input("referenceId")]
        public Input<string>? ReferenceId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Key-value mapping of resource tags. If configured with a provider `default_tags` configuration block present, tags with matching keys will overwrite those defined at the provider-level.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        /// <summary>
        /// The number of tasks to create based on TaskDefinition. The default is 1.
        /// </summary>
        [Input("taskCount")]
        public Input<int>? TaskCount { get; set; }

        /// <summary>
        /// The ARN of the task definition to use if the event target is an Amazon ECS task.
        /// </summary>
        [Input("taskDefinitionArn", required: true)]
        public Input<string> TaskDefinitionArn { get; set; } = null!;

        public PipeTargetParametersEcsTaskParametersGetArgs()
        {
        }
        public static new PipeTargetParametersEcsTaskParametersGetArgs Empty => new PipeTargetParametersEcsTaskParametersGetArgs();
    }
}
