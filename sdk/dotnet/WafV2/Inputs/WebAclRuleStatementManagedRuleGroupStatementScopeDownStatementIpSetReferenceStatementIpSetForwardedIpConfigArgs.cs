// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementIpSetReferenceStatementIpSetForwardedIpConfigArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Match status to assign to the web request if the request doesn't have a valid IP address in the specified position. Valid values include: `MATCH` or `NO_MATCH`.
        /// </summary>
        [Input("fallbackBehavior", required: true)]
        public Input<string> FallbackBehavior { get; set; } = null!;

        /// <summary>
        /// Name of the HTTP header to use for the IP address.
        /// </summary>
        [Input("headerName", required: true)]
        public Input<string> HeaderName { get; set; } = null!;

        /// <summary>
        /// Position in the header to search for the IP address. Valid values include: `FIRST`, `LAST`, or `ANY`. If `ANY` is specified and the header contains more than 10 IP addresses, AWS WAFv2 inspects the last 10.
        /// </summary>
        [Input("position", required: true)]
        public Input<string> Position { get; set; } = null!;

        public WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementIpSetReferenceStatementIpSetForwardedIpConfigArgs()
        {
        }
        public static new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementIpSetReferenceStatementIpSetForwardedIpConfigArgs Empty => new WebAclRuleStatementManagedRuleGroupStatementScopeDownStatementIpSetReferenceStatementIpSetForwardedIpConfigArgs();
    }
}
