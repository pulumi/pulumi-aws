// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Quicksight.Inputs
{

    public sealed class ThemeConfigurationSheetTileBorderArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The option to enable display of borders for visuals.
        /// </summary>
        [Input("show")]
        public Input<bool>? Show { get; set; }

        public ThemeConfigurationSheetTileBorderArgs()
        {
        }
        public static new ThemeConfigurationSheetTileBorderArgs Empty => new ThemeConfigurationSheetTileBorderArgs();
    }
}
