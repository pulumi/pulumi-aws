// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class ThemeConfigurationUiColorPaletteArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Color (hexadecimal) that applies to selected states and buttons.
        /// </summary>
        [Input("accent")]
        public Input<string>? Accent { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any text or other elements that appear over the accent color.
        /// </summary>
        [Input("accentForeground")]
        public Input<string>? AccentForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to error messages.
        /// </summary>
        [Input("danger")]
        public Input<string>? Danger { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any text or other elements that appear over the error color.
        /// </summary>
        [Input("dangerForeground")]
        public Input<string>? DangerForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to the names of fields that are identified as dimensions.
        /// </summary>
        [Input("dimension")]
        public Input<string>? Dimension { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any text or other elements that appear over the dimension color.
        /// </summary>
        [Input("dimensionForeground")]
        public Input<string>? DimensionForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to the names of fields that are identified as measures.
        /// </summary>
        [Input("measure")]
        public Input<string>? Measure { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any text or other elements that appear over the measure color.
        /// </summary>
        [Input("measureForeground")]
        public Input<string>? MeasureForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to visuals and other high emphasis UI.
        /// </summary>
        [Input("primaryBackground")]
        public Input<string>? PrimaryBackground { get; set; }

        /// <summary>
        /// Color (hexadecimal) of text and other foreground elements that appear over the primary background regions, such as grid lines, borders, table banding, icons, and so on.
        /// </summary>
        [Input("primaryForeground")]
        public Input<string>? PrimaryForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to the sheet background and sheet controls.
        /// </summary>
        [Input("secondaryBackground")]
        public Input<string>? SecondaryBackground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any sheet title, sheet control text, or UI that appears over the secondary background.
        /// </summary>
        [Input("secondaryForeground")]
        public Input<string>? SecondaryForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to success messages, for example the check mark for a successful download.
        /// </summary>
        [Input("success")]
        public Input<string>? Success { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any text or other elements that appear over the success color.
        /// </summary>
        [Input("successForeground")]
        public Input<string>? SuccessForeground { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to warning and informational messages.
        /// </summary>
        [Input("warning")]
        public Input<string>? Warning { get; set; }

        /// <summary>
        /// Color (hexadecimal) that applies to any text or other elements that appear over the warning color.
        /// </summary>
        [Input("warningForeground")]
        public Input<string>? WarningForeground { get; set; }

        public ThemeConfigurationUiColorPaletteArgs()
        {
        }
        public static new ThemeConfigurationUiColorPaletteArgs Empty => new ThemeConfigurationUiColorPaletteArgs();
    }
}
