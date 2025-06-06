// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkManager.Inputs
{

    public sealed class GetCoreNetworkPolicyDocumentAttachmentPolicyActionArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// The name of the network function group to attach to the attachment policy.
        /// </summary>
        [Input("addToNetworkFunctionGroup")]
        public string? AddToNetworkFunctionGroup { get; set; }

        /// <summary>
        /// Defines how a segment is mapped. Values can be `constant` or `tag`. `constant` statically defines the segment to associate the attachment to. `tag` uses the value of a tag to dynamically try to map to a segment.reference_policies_elements_condition_operators.html) to evaluate.
        /// </summary>
        [Input("associationMethod")]
        public string? AssociationMethod { get; set; }

        /// <summary>
        /// Determines if this mapping should override the segment value for `require_attachment_acceptance`. You can only set this to `true`, indicating that this setting applies only to segments that have `require_attachment_acceptance` set to `false`. If the segment already has the default `require_attachment_acceptance`, you can set this to inherit segment’s acceptance value.
        /// </summary>
        [Input("requireAcceptance")]
        public bool? RequireAcceptance { get; set; }

        /// <summary>
        /// Name of the `segment` to share as defined in the `segments` section. This is used only when the `association_method` is `constant`.
        /// </summary>
        [Input("segment")]
        public string? Segment { get; set; }

        /// <summary>
        /// Maps the attachment to the value of a known key. This is used with the `association_method` is `tag`. For example a `tag` of `stage = “test”`, will map to a segment named `test`. The value must exactly match the name of a segment. This allows you to have many segments, but use only a single rule without having to define multiple nearly identical conditions. This prevents creating many similar conditions that all use the same keys to map to segments.
        /// </summary>
        [Input("tagValueOfKey")]
        public string? TagValueOfKey { get; set; }

        public GetCoreNetworkPolicyDocumentAttachmentPolicyActionArgs()
        {
        }
        public static new GetCoreNetworkPolicyDocumentAttachmentPolicyActionArgs Empty => new GetCoreNetworkPolicyDocumentAttachmentPolicyActionArgs();
    }
}
