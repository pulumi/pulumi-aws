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
    public sealed class GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariableIpSetResult
    {
        public readonly ImmutableArray<string> Definitions;

        [OutputConstructor]
        private GetFirewallPolicyFirewallPolicyPolicyVariableRuleVariableIpSetResult(ImmutableArray<string> definitions)
        {
            Definitions = definitions;
        }
    }
}
