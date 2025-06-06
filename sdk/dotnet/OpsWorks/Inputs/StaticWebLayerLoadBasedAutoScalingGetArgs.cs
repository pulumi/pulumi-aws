// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Inputs
{

    public sealed class StaticWebLayerLoadBasedAutoScalingGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("downscaling")]
        public Input<Inputs.StaticWebLayerLoadBasedAutoScalingDownscalingGetArgs>? Downscaling { get; set; }

        [Input("enable")]
        public Input<bool>? Enable { get; set; }

        [Input("upscaling")]
        public Input<Inputs.StaticWebLayerLoadBasedAutoScalingUpscalingGetArgs>? Upscaling { get; set; }

        public StaticWebLayerLoadBasedAutoScalingGetArgs()
        {
        }
        public static new StaticWebLayerLoadBasedAutoScalingGetArgs Empty => new StaticWebLayerLoadBasedAutoScalingGetArgs();
    }
}
