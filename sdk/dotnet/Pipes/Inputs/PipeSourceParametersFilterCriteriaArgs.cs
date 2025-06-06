// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeSourceParametersFilterCriteriaArgs : global::Pulumi.ResourceArgs
    {
        [Input("filters")]
        private InputList<Inputs.PipeSourceParametersFilterCriteriaFilterArgs>? _filters;

        /// <summary>
        /// An array of up to 5 event patterns. Detailed below.
        /// </summary>
        public InputList<Inputs.PipeSourceParametersFilterCriteriaFilterArgs> Filters
        {
            get => _filters ?? (_filters = new InputList<Inputs.PipeSourceParametersFilterCriteriaFilterArgs>());
            set => _filters = value;
        }

        public PipeSourceParametersFilterCriteriaArgs()
        {
        }
        public static new PipeSourceParametersFilterCriteriaArgs Empty => new PipeSourceParametersFilterCriteriaArgs();
    }
}
