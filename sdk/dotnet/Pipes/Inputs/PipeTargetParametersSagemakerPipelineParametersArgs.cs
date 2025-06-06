// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeTargetParametersSagemakerPipelineParametersArgs : global::Pulumi.ResourceArgs
    {
        [Input("pipelineParameters")]
        private InputList<Inputs.PipeTargetParametersSagemakerPipelineParametersPipelineParameterArgs>? _pipelineParameters;

        /// <summary>
        /// List of Parameter names and values for SageMaker AI Model Building Pipeline execution. Detailed below.
        /// </summary>
        public InputList<Inputs.PipeTargetParametersSagemakerPipelineParametersPipelineParameterArgs> PipelineParameters
        {
            get => _pipelineParameters ?? (_pipelineParameters = new InputList<Inputs.PipeTargetParametersSagemakerPipelineParametersPipelineParameterArgs>());
            set => _pipelineParameters = value;
        }

        public PipeTargetParametersSagemakerPipelineParametersArgs()
        {
        }
        public static new PipeTargetParametersSagemakerPipelineParametersArgs Empty => new PipeTargetParametersSagemakerPipelineParametersArgs();
    }
}
