// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelCdiInputSpecificationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum CDI input resolution.
        /// </summary>
        [Input("resolution", required: true)]
        public Input<string> Resolution { get; set; } = null!;

        public ChannelCdiInputSpecificationGetArgs()
        {
        }
        public static new ChannelCdiInputSpecificationGetArgs Empty => new ChannelCdiInputSpecificationGetArgs();
    }
}
