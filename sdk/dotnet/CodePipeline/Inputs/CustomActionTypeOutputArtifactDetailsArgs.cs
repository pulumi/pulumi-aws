// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CodePipeline.Inputs
{

    public sealed class CustomActionTypeOutputArtifactDetailsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The maximum number of artifacts allowed for the action type. Min: 0, Max: 5
        /// </summary>
        [Input("maximumCount", required: true)]
        public Input<int> MaximumCount { get; set; } = null!;

        /// <summary>
        /// The minimum number of artifacts allowed for the action type. Min: 0, Max: 5
        /// </summary>
        [Input("minimumCount", required: true)]
        public Input<int> MinimumCount { get; set; } = null!;

        public CustomActionTypeOutputArtifactDetailsArgs()
        {
        }
        public static new CustomActionTypeOutputArtifactDetailsArgs Empty => new CustomActionTypeOutputArtifactDetailsArgs();
    }
}
