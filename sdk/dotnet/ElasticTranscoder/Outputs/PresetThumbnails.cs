// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElasticTranscoder.Outputs
{

    [OutputType]
    public sealed class PresetThumbnails
    {
        /// <summary>
        /// The aspect ratio of thumbnails. The following values are valid: auto, 1:1, 4:3, 3:2, 16:9
        /// </summary>
        public readonly string? AspectRatio;
        /// <summary>
        /// The format of thumbnails, if any. Valid formats are jpg and png.
        /// </summary>
        public readonly string? Format;
        /// <summary>
        /// The approximate number of seconds between thumbnails. The value must be an integer. The actual interval can vary by several seconds from one thumbnail to the next.
        /// </summary>
        public readonly string? Interval;
        /// <summary>
        /// The maximum height of thumbnails, in pixels. If you specify auto, Elastic Transcoder uses 1080 (Full HD) as the default value. If you specify a numeric value, enter an even integer between 32 and 3072, inclusive.
        /// </summary>
        public readonly string? MaxHeight;
        /// <summary>
        /// The maximum width of thumbnails, in pixels. If you specify auto, Elastic Transcoder uses 1920 (Full HD) as the default value. If you specify a numeric value, enter an even integer between 32 and 4096, inclusive.
        /// </summary>
        public readonly string? MaxWidth;
        /// <summary>
        /// When you set PaddingPolicy to Pad, Elastic Transcoder might add black bars to the top and bottom and/or left and right sides of thumbnails to make the total size of the thumbnails match the values that you specified for thumbnail MaxWidth and MaxHeight settings.
        /// </summary>
        public readonly string? PaddingPolicy;
        /// <summary>
        /// The width and height of thumbnail files in pixels, in the format WidthxHeight, where both values are even integers. The values cannot exceed the width and height that you specified in the Video:Resolution object. (To better control resolution and aspect ratio of thumbnails, we recommend that you use the thumbnail values `max_width`, `max_height`, `sizing_policy`, and `padding_policy` instead of `resolution` and `aspect_ratio`. The two groups of settings are mutually exclusive. Do not use them together)
        /// </summary>
        public readonly string? Resolution;
        /// <summary>
        /// A value that controls scaling of thumbnails. Valid values are: `Fit`, `Fill`, `Stretch`, `Keep`, `ShrinkToFit`, and `ShrinkToFill`.
        /// </summary>
        public readonly string? SizingPolicy;

        [OutputConstructor]
        private PresetThumbnails(
            string? aspectRatio,

            string? format,

            string? interval,

            string? maxHeight,

            string? maxWidth,

            string? paddingPolicy,

            string? resolution,

            string? sizingPolicy)
        {
            AspectRatio = aspectRatio;
            Format = format;
            Interval = interval;
            MaxHeight = maxHeight;
            MaxWidth = maxWidth;
            PaddingPolicy = paddingPolicy;
            Resolution = resolution;
            SizingPolicy = sizingPolicy;
        }
    }
}
