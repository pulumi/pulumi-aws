// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class NetworkInsightsAnalysisReturnPathComponentAclRule
    {
        public readonly string? Cidr;
        public readonly bool? Egress;
        public readonly ImmutableArray<Outputs.NetworkInsightsAnalysisReturnPathComponentAclRulePortRange> PortRanges;
        public readonly string? Protocol;
        public readonly string? RuleAction;
        public readonly int? RuleNumber;

        [OutputConstructor]
        private NetworkInsightsAnalysisReturnPathComponentAclRule(
            string? cidr,

            bool? egress,

            ImmutableArray<Outputs.NetworkInsightsAnalysisReturnPathComponentAclRulePortRange> portRanges,

            string? protocol,

            string? ruleAction,

            int? ruleNumber)
        {
            Cidr = cidr;
            Egress = egress;
            PortRanges = portRanges;
            Protocol = protocol;
            RuleAction = ruleAction;
            RuleNumber = ruleNumber;
        }
    }
}
