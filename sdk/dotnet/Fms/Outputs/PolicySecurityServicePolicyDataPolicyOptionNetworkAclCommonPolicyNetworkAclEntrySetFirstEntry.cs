// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fms.Outputs
{

    [OutputType]
    public sealed class PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntry
    {
        /// <summary>
        /// A string value containing the IPv4 network range to allow or deny, in CIDR notation.
        /// </summary>
        public readonly string? CidrBlock;
        /// <summary>
        /// A boolean value, if true Firewall Manager creates egress rule. If false Firewall Manager creates ingress rule.
        /// </summary>
        public readonly bool Egress;
        /// <summary>
        /// A configuration block for ICMP protocol: The ICMP type and code. See the `icmp_type_code` block.
        /// </summary>
        public readonly ImmutableArray<Outputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode> IcmpTypeCodes;
        /// <summary>
        /// A string value containing the IPv6 network range to allow or deny, in CIDR notation.
        /// </summary>
        public readonly string? Ipv6CidrBlock;
        /// <summary>
        /// A configuration block for PortRange. See the `port_range` block.
        /// </summary>
        public readonly ImmutableArray<Outputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRange> PortRanges;
        /// <summary>
        /// The protocol number. A value of "-1" means all protocols.
        /// </summary>
        public readonly string Protocol;
        /// <summary>
        /// A string value that indicates whether to allow or deny the traffic that matches the rule. Valid values: `allow`, `deny`.
        /// </summary>
        public readonly string RuleAction;

        [OutputConstructor]
        private PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntry(
            string? cidrBlock,

            bool egress,

            ImmutableArray<Outputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryIcmpTypeCode> icmpTypeCodes,

            string? ipv6CidrBlock,

            ImmutableArray<Outputs.PolicySecurityServicePolicyDataPolicyOptionNetworkAclCommonPolicyNetworkAclEntrySetFirstEntryPortRange> portRanges,

            string protocol,

            string ruleAction)
        {
            CidrBlock = cidrBlock;
            Egress = egress;
            IcmpTypeCodes = icmpTypeCodes;
            Ipv6CidrBlock = ipv6CidrBlock;
            PortRanges = portRanges;
            Protocol = protocol;
            RuleAction = ruleAction;
        }
    }
}
