// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Inputs
{

    public sealed class PipelineArtifactStoreEncryptionKeyGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The KMS key ARN or ID
        /// </summary>
        [Input("id", required: true)]
        public Input<string> Id { get; set; } = null!;

        /// <summary>
        /// The type of key; currently only `KMS` is supported
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public PipelineArtifactStoreEncryptionKeyGetArgs()
        {
        }
        public static new PipelineArtifactStoreEncryptionKeyGetArgs Empty => new PipelineArtifactStoreEncryptionKeyGetArgs();
    }
}
