// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.DataPipeline.Inputs
{

    public sealed class PipelineDefinitionPipelineObjectGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("fields")]
        private InputList<Inputs.PipelineDefinitionPipelineObjectFieldGetArgs>? _fields;

        /// <summary>
        /// Configuration block for Key-value pairs that define the properties of the object. See below
        /// </summary>
        public InputList<Inputs.PipelineDefinitionPipelineObjectFieldGetArgs> Fields
        {
            get => _fields ?? (_fields = new InputList<Inputs.PipelineDefinitionPipelineObjectFieldGetArgs>());
            set => _fields = value;
        }

        /// <summary>
        /// ID of the object.
        /// </summary>
        [Input("id", required: true)]
        public Input<string> Id { get; set; } = null!;

        /// <summary>
        /// ARN of the storage connector.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public PipelineDefinitionPipelineObjectGetArgs()
        {
        }
        public static new PipelineDefinitionPipelineObjectGetArgs Empty => new PipelineDefinitionPipelineObjectGetArgs();
    }
}
