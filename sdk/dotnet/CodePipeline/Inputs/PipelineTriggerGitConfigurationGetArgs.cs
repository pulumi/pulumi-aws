// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Inputs
{

    public sealed class PipelineTriggerGitConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("pullRequests")]
        private InputList<Inputs.PipelineTriggerGitConfigurationPullRequestGetArgs>? _pullRequests;

        /// <summary>
        /// The field where the repository event that will start the pipeline is specified as pull requests. A `pull_request` block is documented below.
        /// </summary>
        public InputList<Inputs.PipelineTriggerGitConfigurationPullRequestGetArgs> PullRequests
        {
            get => _pullRequests ?? (_pullRequests = new InputList<Inputs.PipelineTriggerGitConfigurationPullRequestGetArgs>());
            set => _pullRequests = value;
        }

        [Input("pushes")]
        private InputList<Inputs.PipelineTriggerGitConfigurationPushGetArgs>? _pushes;

        /// <summary>
        /// The field where the repository event that will start the pipeline, such as pushing Git tags, is specified with details. A `push` block is documented below.
        /// </summary>
        public InputList<Inputs.PipelineTriggerGitConfigurationPushGetArgs> Pushes
        {
            get => _pushes ?? (_pushes = new InputList<Inputs.PipelineTriggerGitConfigurationPushGetArgs>());
            set => _pushes = value;
        }

        /// <summary>
        /// The name of the pipeline source action where the trigger configuration, such as Git tags, is specified. The trigger configuration will start the pipeline upon the specified change only.
        /// </summary>
        [Input("sourceActionName", required: true)]
        public Input<string> SourceActionName { get; set; } = null!;

        public PipelineTriggerGitConfigurationGetArgs()
        {
        }
        public static new PipelineTriggerGitConfigurationGetArgs Empty => new PipelineTriggerGitConfigurationGetArgs();
    }
}
