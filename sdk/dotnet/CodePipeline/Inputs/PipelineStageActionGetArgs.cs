// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Inputs
{

    public sealed class PipelineStageActionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A category defines what kind of action can be taken in the stage, and constrains the provider type for the action. Possible values are `Approval`, `Build`, `Deploy`, `Invoke`, `Source` and `Test`.
        /// </summary>
        [Input("category", required: true)]
        public Input<string> Category { get; set; } = null!;

        [Input("configuration")]
        private InputMap<string>? _configuration;

        /// <summary>
        /// A map of the action declaration's configuration. Configurations options for action types and providers can be found in the [Pipeline Structure Reference](http://docs.aws.amazon.com/codepipeline/latest/userguide/reference-pipeline-structure.html#action-requirements) and [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation. Note: The `DetectChanges` parameter (optional, default value is true) in the `configuration` section causes CodePipeline to automatically start your pipeline upon new commits. Please refer to AWS Documentation for more details: https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference-CodestarConnectionSource.html#action-reference-CodestarConnectionSource-config.
        /// </summary>
        public InputMap<string> Configuration
        {
            get => _configuration ?? (_configuration = new InputMap<string>());
            set => _configuration = value;
        }

        [Input("inputArtifacts")]
        private InputList<string>? _inputArtifacts;

        /// <summary>
        /// A list of artifact names to be worked on.
        /// </summary>
        public InputList<string> InputArtifacts
        {
            get => _inputArtifacts ?? (_inputArtifacts = new InputList<string>());
            set => _inputArtifacts = value;
        }

        /// <summary>
        /// The action declaration's name.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// The namespace all output variables will be accessed from.
        /// </summary>
        [Input("namespace")]
        public Input<string>? Namespace { get; set; }

        [Input("outputArtifacts")]
        private InputList<string>? _outputArtifacts;

        /// <summary>
        /// A list of artifact names to output. Output artifact names must be unique within a pipeline.
        /// </summary>
        public InputList<string> OutputArtifacts
        {
            get => _outputArtifacts ?? (_outputArtifacts = new InputList<string>());
            set => _outputArtifacts = value;
        }

        /// <summary>
        /// The creator of the action being called. Possible values are `AWS`, `Custom` and `ThirdParty`.
        /// </summary>
        [Input("owner", required: true)]
        public Input<string> Owner { get; set; } = null!;

        /// <summary>
        /// The provider of the service being called by the action. Valid providers are determined by the action category. Provider names are listed in the [Action Structure Reference](https://docs.aws.amazon.com/codepipeline/latest/userguide/action-reference.html) documentation.
        /// </summary>
        [Input("provider", required: true)]
        public Input<string> Provider { get; set; } = null!;

        /// <summary>
        /// The region in which to run the action.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        /// <summary>
        /// The ARN of the IAM service role that will perform the declared action. This is assumed through the roleArn for the pipeline.
        /// </summary>
        [Input("roleArn")]
        public Input<string>? RoleArn { get; set; }

        /// <summary>
        /// The order in which actions are run.
        /// </summary>
        [Input("runOrder")]
        public Input<int>? RunOrder { get; set; }

        /// <summary>
        /// The action timeout for the rule.
        /// </summary>
        [Input("timeoutInMinutes")]
        public Input<int>? TimeoutInMinutes { get; set; }

        /// <summary>
        /// A string that identifies the action type.
        /// </summary>
        [Input("version", required: true)]
        public Input<string> Version { get; set; } = null!;

        public PipelineStageActionGetArgs()
        {
        }
        public static new PipelineStageActionGetArgs Empty => new PipelineStageActionGetArgs();
    }
}
