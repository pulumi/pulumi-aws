// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class ChannelCdiInputSpecificationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Maximum CDI input resolution.
        /// </summary>
        [Input("resolution", required: true)]
        public Input<string> Resolution { get; set; } = null!;

        public ChannelCdiInputSpecificationArgs()
        {
        }
        public static new ChannelCdiInputSpecificationArgs Empty => new ChannelCdiInputSpecificationArgs();
    }
}
