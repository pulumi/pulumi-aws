// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleStatementRateBasedStatementScopeDownStatementXssMatchStatementFieldToMatchBodyGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("oversizeHandling")]
        public Input<string>? OversizeHandling { get; set; }

        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementXssMatchStatementFieldToMatchBodyGetArgs()
        {
        }
        public static new RuleGroupRuleStatementRateBasedStatementScopeDownStatementXssMatchStatementFieldToMatchBodyGetArgs Empty => new RuleGroupRuleStatementRateBasedStatementScopeDownStatementXssMatchStatementFieldToMatchBodyGetArgs();
    }
}
