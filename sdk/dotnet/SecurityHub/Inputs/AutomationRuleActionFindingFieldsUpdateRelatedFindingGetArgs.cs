// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Inputs
{

    public sealed class AutomationRuleActionFindingFieldsUpdateRelatedFindingGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The product-generated identifier for a related finding.
        /// </summary>
        [Input("id", required: true)]
        public Input<string> Id { get; set; } = null!;

        /// <summary>
        /// The ARN of the product that generated a related finding.
        /// </summary>
        [Input("productArn", required: true)]
        public Input<string> ProductArn { get; set; } = null!;

        public AutomationRuleActionFindingFieldsUpdateRelatedFindingGetArgs()
        {
        }
        public static new AutomationRuleActionFindingFieldsUpdateRelatedFindingGetArgs Empty => new AutomationRuleActionFindingFieldsUpdateRelatedFindingGetArgs();
    }
}
