// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkManager.Inputs
{

    public sealed class GetCoreNetworkPolicyDocumentSegmentActionWhenSentToArgs : global::Pulumi.InvokeArgs
    {
        [Input("segments")]
        private List<string>? _segments;

        /// <summary>
        /// A list of strings. The list of segments that the `send-via` `action` uses.
        /// </summary>
        public List<string> Segments
        {
            get => _segments ?? (_segments = new List<string>());
            set => _segments = value;
        }

        public GetCoreNetworkPolicyDocumentSegmentActionWhenSentToArgs()
        {
        }
        public static new GetCoreNetworkPolicyDocumentSegmentActionWhenSentToArgs Empty => new GetCoreNetworkPolicyDocumentSegmentActionWhenSentToArgs();
    }
}
