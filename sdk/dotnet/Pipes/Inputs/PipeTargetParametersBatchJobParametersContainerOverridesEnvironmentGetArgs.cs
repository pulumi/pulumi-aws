// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeTargetParametersBatchJobParametersContainerOverridesEnvironmentGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Name of the pipe. If omitted, the provider will assign a random, unique name. Conflicts with `name_prefix`.
        /// </summary>
        [Input("name")]
        public Input<string>? Name { get; set; }

        /// <summary>
        /// Value of parameter to start execution of a SageMaker AI Model Building Pipeline. Maximum length of 1024.
        /// </summary>
        [Input("value")]
        public Input<string>? Value { get; set; }

        public PipeTargetParametersBatchJobParametersContainerOverridesEnvironmentGetArgs()
        {
        }
        public static new PipeTargetParametersBatchJobParametersContainerOverridesEnvironmentGetArgs Empty => new PipeTargetParametersBatchJobParametersContainerOverridesEnvironmentGetArgs();
    }
}
