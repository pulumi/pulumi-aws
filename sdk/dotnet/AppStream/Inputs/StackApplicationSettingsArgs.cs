// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppStream.Inputs
{

    public sealed class StackApplicationSettingsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether application settings should be persisted.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        /// <summary>
        /// Name of the settings group.
        /// Required when `enabled` is `true`.
        /// Can be up to 100 characters.
        /// </summary>
        [Input("settingsGroup")]
        public Input<string>? SettingsGroup { get; set; }

        public StackApplicationSettingsArgs()
        {
        }
        public static new StackApplicationSettingsArgs Empty => new StackApplicationSettingsArgs();
    }
}
