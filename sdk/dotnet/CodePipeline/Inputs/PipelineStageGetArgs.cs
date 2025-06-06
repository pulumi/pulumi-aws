// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Inputs
{

    public sealed class PipelineStageGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("actions", required: true)]
        private InputList<Inputs.PipelineStageActionGetArgs>? _actions;

        /// <summary>
        /// The action(s) to include in the stage. Defined as an `action` block below
        /// </summary>
        public InputList<Inputs.PipelineStageActionGetArgs> Actions
        {
            get => _actions ?? (_actions = new InputList<Inputs.PipelineStageActionGetArgs>());
            set => _actions = value;
        }

        /// <summary>
        /// The method to use when a stage allows entry. For example, configuring this field for conditions will allow entry to the stage when the conditions are met.
        /// </summary>
        [Input("beforeEntry")]
        public Input<Inputs.PipelineStageBeforeEntryGetArgs>? BeforeEntry { get; set; }

        /// <summary>
        /// The name of the stage.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        /// <summary>
        /// The method to use when a stage has not completed successfully. For example, configuring this field for rollback will roll back a failed stage automatically to the last successful pipeline execution in the stage.
        /// </summary>
        [Input("onFailure")]
        public Input<Inputs.PipelineStageOnFailureGetArgs>? OnFailure { get; set; }

        /// <summary>
        /// The method to use when a stage has succeeded. For example, configuring this field for conditions will allow the stage to succeed when the conditions are met.
        /// </summary>
        [Input("onSuccess")]
        public Input<Inputs.PipelineStageOnSuccessGetArgs>? OnSuccess { get; set; }

        public PipelineStageGetArgs()
        {
        }
        public static new PipelineStageGetArgs Empty => new PipelineStageGetArgs();
    }
}
