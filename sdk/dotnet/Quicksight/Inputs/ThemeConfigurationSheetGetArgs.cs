// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class ThemeConfigurationSheetGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The display options for tiles. See tile.
        /// </summary>
        [Input("tile")]
        public Input<Inputs.ThemeConfigurationSheetTileGetArgs>? Tile { get; set; }

        /// <summary>
        /// The layout options for tiles. See tile_layout.
        /// </summary>
        [Input("tileLayout")]
        public Input<Inputs.ThemeConfigurationSheetTileLayoutGetArgs>? TileLayout { get; set; }

        public ThemeConfigurationSheetGetArgs()
        {
        }
        public static new ThemeConfigurationSheetGetArgs Empty => new ThemeConfigurationSheetGetArgs();
    }
}
