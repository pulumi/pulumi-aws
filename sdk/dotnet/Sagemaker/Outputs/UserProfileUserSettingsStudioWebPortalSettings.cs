// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Outputs
{

    [OutputType]
    public sealed class UserProfileUserSettingsStudioWebPortalSettings
    {
        /// <summary>
        /// The Applications supported in Studio that are hidden from the Studio left navigation pane.
        /// </summary>
        public readonly ImmutableArray<string> HiddenAppTypes;
        /// <summary>
        /// The instance types you are hiding from the Studio user interface.
        /// </summary>
        public readonly ImmutableArray<string> HiddenInstanceTypes;
        /// <summary>
        /// The machine learning tools that are hidden from the Studio left navigation pane.
        /// </summary>
        public readonly ImmutableArray<string> HiddenMlTools;

        [OutputConstructor]
        private UserProfileUserSettingsStudioWebPortalSettings(
            ImmutableArray<string> hiddenAppTypes,

            ImmutableArray<string> hiddenInstanceTypes,

            ImmutableArray<string> hiddenMlTools)
        {
            HiddenAppTypes = hiddenAppTypes;
            HiddenInstanceTypes = hiddenInstanceTypes;
            HiddenMlTools = hiddenMlTools;
        }
    }
}
