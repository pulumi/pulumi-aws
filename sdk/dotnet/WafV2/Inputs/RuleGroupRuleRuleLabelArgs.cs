// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleRuleLabelArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The label string.
        /// </summary>
        [Input("name", required: true)]
        public Input<string> Name { get; set; } = null!;

        public RuleGroupRuleRuleLabelArgs()
        {
        }
        public static new RuleGroupRuleRuleLabelArgs Empty => new RuleGroupRuleRuleLabelArgs();
    }
}
