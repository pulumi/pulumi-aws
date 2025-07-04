// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleStatementRateBasedStatementScopeDownStatementAsnMatchStatementForwardedIpConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The match status to assign to the web request if the request doesn't have a valid IP address in the specified position. Valid values include: `MATCH` or `NO_MATCH`.
        /// </summary>
        [Input("fallbackBehavior", required: true)]
        public Input<string> FallbackBehavior { get; set; } = null!;

        /// <summary>
        /// The name of the HTTP header to use for the IP address.
        /// </summary>
        [Input("headerName", required: true)]
        public Input<string> HeaderName { get; set; } = null!;

        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementAsnMatchStatementForwardedIpConfigGetArgs()
        {
        }
        public static new RuleGroupRuleStatementRateBasedStatementScopeDownStatementAsnMatchStatementForwardedIpConfigGetArgs Empty => new RuleGroupRuleStatementRateBasedStatementScopeDownStatementAsnMatchStatementForwardedIpConfigGetArgs();
    }
}
