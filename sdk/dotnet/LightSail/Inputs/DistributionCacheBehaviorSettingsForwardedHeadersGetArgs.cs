// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LightSail.Inputs
{

    public sealed class DistributionCacheBehaviorSettingsForwardedHeadersGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("headersAllowLists")]
        private InputList<string>? _headersAllowLists;

        /// <summary>
        /// Specific headers to forward to your distribution's origin.
        /// </summary>
        public InputList<string> HeadersAllowLists
        {
            get => _headersAllowLists ?? (_headersAllowLists = new InputList<string>());
            set => _headersAllowLists = value;
        }

        /// <summary>
        /// Headers that you want your distribution to forward to your origin and base caching on. Valid values: `default`, `allow-list`, `all`.
        /// </summary>
        [Input("option")]
        public Input<string>? Option { get; set; }

        public DistributionCacheBehaviorSettingsForwardedHeadersGetArgs()
        {
        }
        public static new DistributionCacheBehaviorSettingsForwardedHeadersGetArgs Empty => new DistributionCacheBehaviorSettingsForwardedHeadersGetArgs();
    }
}
