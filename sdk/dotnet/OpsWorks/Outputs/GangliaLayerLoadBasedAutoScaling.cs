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
    public sealed class GangliaLayerLoadBasedAutoScaling
    {
        public readonly Outputs.GangliaLayerLoadBasedAutoScalingDownscaling? Downscaling;
        public readonly bool? Enable;
        public readonly Outputs.GangliaLayerLoadBasedAutoScalingUpscaling? Upscaling;

        [OutputConstructor]
        private GangliaLayerLoadBasedAutoScaling(
            Outputs.GangliaLayerLoadBasedAutoScalingDownscaling? downscaling,

            bool? enable,

            Outputs.GangliaLayerLoadBasedAutoScalingUpscaling? upscaling)
        {
            Downscaling = downscaling;
            Enable = enable;
            Upscaling = upscaling;
        }
    }
}
