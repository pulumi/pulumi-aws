// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelEncoderSettingsMotionGraphicsConfigurationMotionGraphicsSettingsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Html Motion Graphics Settings.
        /// </summary>
        [Input("htmlMotionGraphicsSettings")]
        public Input<Inputs.ChannelEncoderSettingsMotionGraphicsConfigurationMotionGraphicsSettingsHtmlMotionGraphicsSettingsGetArgs>? HtmlMotionGraphicsSettings { get; set; }

        public ChannelEncoderSettingsMotionGraphicsConfigurationMotionGraphicsSettingsGetArgs()
        {
        }
        public static new ChannelEncoderSettingsMotionGraphicsConfigurationMotionGraphicsSettingsGetArgs Empty => new ChannelEncoderSettingsMotionGraphicsConfigurationMotionGraphicsSettingsGetArgs();
    }
}
