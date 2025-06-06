// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SecurityHub.Inputs
{

    public sealed class AutomationRuleActionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// A block that specifies that the automation rule action is an update to a finding field.  Documented below.
        /// </summary>
        [Input("findingFieldsUpdate")]
        public Input<Inputs.AutomationRuleActionFindingFieldsUpdateArgs>? FindingFieldsUpdate { get; set; }

        /// <summary>
        /// Specifies that the rule action should update the `Types` finding field. The `Types` finding field classifies findings in the format of namespace/category/classifier.
        /// </summary>
        [Input("type")]
        public Input<string>? Type { get; set; }

        public AutomationRuleActionArgs()
        {
        }
        public static new AutomationRuleActionArgs Empty => new AutomationRuleActionArgs();
    }
}
