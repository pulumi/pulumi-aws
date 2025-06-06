// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Outputs
{

    [OutputType]
    public sealed class JavaAppLayerLoadBasedAutoScaling
    {
        public readonly Outputs.JavaAppLayerLoadBasedAutoScalingDownscaling? Downscaling;
        public readonly bool? Enable;
        public readonly Outputs.JavaAppLayerLoadBasedAutoScalingUpscaling? Upscaling;

        [OutputConstructor]
        private JavaAppLayerLoadBasedAutoScaling(
            Outputs.JavaAppLayerLoadBasedAutoScalingDownscaling? downscaling,

            bool? enable,

            Outputs.JavaAppLayerLoadBasedAutoScalingUpscaling? upscaling)
        {
            Downscaling = downscaling;
            Enable = enable;
            Upscaling = upscaling;
        }
    }
}
