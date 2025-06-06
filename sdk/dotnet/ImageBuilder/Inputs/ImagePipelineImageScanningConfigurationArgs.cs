// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ImageBuilder.Inputs
{

    public sealed class ImagePipelineImageScanningConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Configuration block with ECR configuration for image scanning. Detailed below.
        /// </summary>
        [Input("ecrConfiguration")]
        public Input<Inputs.ImagePipelineImageScanningConfigurationEcrConfigurationArgs>? EcrConfiguration { get; set; }

        /// <summary>
        /// Whether image scans are enabled. Defaults to `false`.
        /// </summary>
        [Input("imageScanningEnabled")]
        public Input<bool>? ImageScanningEnabled { get; set; }

        public ImagePipelineImageScanningConfigurationArgs()
        {
        }
        public static new ImagePipelineImageScanningConfigurationArgs Empty => new ImagePipelineImageScanningConfigurationArgs();
    }
}
