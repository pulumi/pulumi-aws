// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearchIngest.Inputs
{

    public sealed class PipelineBufferOptionsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether persistent buffering should be enabled.
        /// </summary>
        [Input("persistentBufferEnabled", required: true)]
        public Input<bool> PersistentBufferEnabled { get; set; } = null!;

        public PipelineBufferOptionsGetArgs()
        {
        }
        public static new PipelineBufferOptionsGetArgs Empty => new PipelineBufferOptionsGetArgs();
    }
}
