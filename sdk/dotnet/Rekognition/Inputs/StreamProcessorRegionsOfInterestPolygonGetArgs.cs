// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Rekognition.Inputs
{

    public sealed class StreamProcessorRegionsOfInterestPolygonGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The value of the X coordinate for a point on a Polygon.
        /// </summary>
        [Input("x")]
        public Input<double>? X { get; set; }

        /// <summary>
        /// The value of the Y coordinate for a point on a Polygon.
        /// </summary>
        [Input("y")]
        public Input<double>? Y { get; set; }

        public StreamProcessorRegionsOfInterestPolygonGetArgs()
        {
        }
        public static new StreamProcessorRegionsOfInterestPolygonGetArgs Empty => new StreamProcessorRegionsOfInterestPolygonGetArgs();
    }
}
