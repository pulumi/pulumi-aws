// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Outputs
{

    [OutputType]
    public sealed class RuleGroupRuleGroupReferenceSets
    {
        public readonly ImmutableArray<Outputs.RuleGroupRuleGroupReferenceSetsIpSetReference> IpSetReferences;

        [OutputConstructor]
        private RuleGroupRuleGroupReferenceSets(ImmutableArray<Outputs.RuleGroupRuleGroupReferenceSetsIpSetReference> ipSetReferences)
        {
            IpSetReferences = ipSetReferences;
        }
    }
}
