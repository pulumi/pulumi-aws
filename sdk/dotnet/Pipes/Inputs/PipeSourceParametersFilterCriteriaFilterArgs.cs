// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Pipes.Inputs
{

    public sealed class PipeSourceParametersFilterCriteriaFilterArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The event pattern. At most 4096 characters.
        /// </summary>
        [Input("pattern", required: true)]
        public Input<string> Pattern { get; set; } = null!;

        public PipeSourceParametersFilterCriteriaFilterArgs()
        {
        }
        public static new PipeSourceParametersFilterCriteriaFilterArgs Empty => new PipeSourceParametersFilterCriteriaFilterArgs();
    }
}
