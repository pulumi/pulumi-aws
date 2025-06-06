// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Sagemaker.Inputs
{

    public sealed class DomainDefaultUserSettingsStudioWebPortalSettingsArgs : global::Pulumi.ResourceArgs
    {
        [Input("hiddenAppTypes")]
        private InputList<string>? _hiddenAppTypes;

        /// <summary>
        /// The Applications supported in Studio that are hidden from the Studio left navigation pane.
        /// </summary>
        public InputList<string> HiddenAppTypes
        {
            get => _hiddenAppTypes ?? (_hiddenAppTypes = new InputList<string>());
            set => _hiddenAppTypes = value;
        }

        [Input("hiddenInstanceTypes")]
        private InputList<string>? _hiddenInstanceTypes;

        /// <summary>
        /// The instance types you are hiding from the Studio user interface.
        /// </summary>
        public InputList<string> HiddenInstanceTypes
        {
            get => _hiddenInstanceTypes ?? (_hiddenInstanceTypes = new InputList<string>());
            set => _hiddenInstanceTypes = value;
        }

        [Input("hiddenMlTools")]
        private InputList<string>? _hiddenMlTools;

        /// <summary>
        /// The machine learning tools that are hidden from the Studio left navigation pane.
        /// </summary>
        public InputList<string> HiddenMlTools
        {
            get => _hiddenMlTools ?? (_hiddenMlTools = new InputList<string>());
            set => _hiddenMlTools = value;
        }

        public DomainDefaultUserSettingsStudioWebPortalSettingsArgs()
        {
        }
        public static new DomainDefaultUserSettingsStudioWebPortalSettingsArgs Empty => new DomainDefaultUserSettingsStudioWebPortalSettingsArgs();
    }
}
