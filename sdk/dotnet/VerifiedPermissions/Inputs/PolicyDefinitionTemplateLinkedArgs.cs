// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedPermissions.Inputs
{

    public sealed class PolicyDefinitionTemplateLinkedArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The ID of the template.
        /// </summary>
        [Input("policyTemplateId", required: true)]
        public Input<string> PolicyTemplateId { get; set; } = null!;

        /// <summary>
        /// The principal of the template linked policy.
        /// </summary>
        [Input("principal")]
        public Input<Inputs.PolicyDefinitionTemplateLinkedPrincipalArgs>? Principal { get; set; }

        /// <summary>
        /// The resource of the template linked policy.
        /// </summary>
        [Input("resource")]
        public Input<Inputs.PolicyDefinitionTemplateLinkedResourceArgs>? Resource { get; set; }

        public PolicyDefinitionTemplateLinkedArgs()
        {
        }
        public static new PolicyDefinitionTemplateLinkedArgs Empty => new PolicyDefinitionTemplateLinkedArgs();
    }
}
