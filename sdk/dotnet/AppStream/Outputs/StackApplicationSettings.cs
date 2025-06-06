// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppStream.Outputs
{

    [OutputType]
    public sealed class StackApplicationSettings
    {
        /// <summary>
        /// Whether application settings should be persisted.
        /// </summary>
        public readonly bool Enabled;
        /// <summary>
        /// Name of the settings group.
        /// Required when `enabled` is `true`.
        /// Can be up to 100 characters.
        /// </summary>
        public readonly string? SettingsGroup;

        [OutputConstructor]
        private StackApplicationSettings(
            bool enabled,

            string? settingsGroup)
        {
            Enabled = enabled;
            SettingsGroup = settingsGroup;
        }
    }
}
