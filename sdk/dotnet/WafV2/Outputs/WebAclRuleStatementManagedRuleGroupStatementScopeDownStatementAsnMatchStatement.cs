// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementAsnMatchStatement
    {
        /// <summary>
        /// List of Autonomous System Numbers (ASNs).
        /// </summary>
        public readonly ImmutableArray<int> AsnLists;
        /// <summary>
        /// Configuration for inspecting IP addresses in an HTTP header that you specify, instead of using the IP address that's reported by the web request origin. See `forwarded_ip_config` below for more details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementAsnMatchStatementForwardedIpConfig? ForwardedIpConfig;

        [OutputConstructor]
        private WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementAsnMatchStatement(
            ImmutableArray<int> asnLists,

            Outputs.WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementAsnMatchStatementForwardedIpConfig? forwardedIpConfig)
        {
            AsnLists = asnLists;
            ForwardedIpConfig = forwardedIpConfig;
        }
    }
}
