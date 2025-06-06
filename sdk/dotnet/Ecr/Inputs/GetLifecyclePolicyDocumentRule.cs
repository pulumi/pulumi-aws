// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ecr.Inputs
{

    public sealed class GetLifecyclePolicyDocumentRuleArgs : global::Pulumi.InvokeArgs
    {
        /// <summary>
        /// Specifies the action type.
        /// </summary>
        [Input("action")]
        public Inputs.GetLifecyclePolicyDocumentRuleActionArgs? Action { get; set; }

        /// <summary>
        /// Describes the purpose of a rule within a lifecycle policy.
        /// </summary>
        [Input("description")]
        public string? Description { get; set; }

        /// <summary>
        /// Sets the order in which rules are evaluated, lowest to highest. When you add rules to a lifecycle policy, you must give them each a unique value for `priority`. Values do not need to be sequential across rules in a policy. A rule with a `tag_status` value of "any" must have the highest value for `priority` and be evaluated last.
        /// </summary>
        [Input("priority", required: true)]
        public int Priority { get; set; }

        /// <summary>
        /// Collects parameters describing the selection criteria for the ECR lifecycle policy:
        /// </summary>
        [Input("selection")]
        public Inputs.GetLifecyclePolicyDocumentRuleSelectionArgs? Selection { get; set; }

        public GetLifecyclePolicyDocumentRuleArgs()
        {
        }
        public static new GetLifecyclePolicyDocumentRuleArgs Empty => new GetLifecyclePolicyDocumentRuleArgs();
    }
}
