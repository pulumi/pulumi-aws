// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.MediaLive.Inputs
{

    public sealed class InputDestinationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A unique name for the location the RTMP stream is being pushed to.
        /// </summary>
        [Input("streamName", required: true)]
        public Input<string> StreamName { get; set; } = null!;

        public InputDestinationArgs()
        {
        }
        public static new InputDestinationArgs Empty => new InputDestinationArgs();
    }
}
