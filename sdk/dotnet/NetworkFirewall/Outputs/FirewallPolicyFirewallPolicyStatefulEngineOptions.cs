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
    public sealed class FirewallPolicyFirewallPolicyStatefulEngineOptions
    {
        /// <summary>
        /// Amount of time that can pass without any traffic sent through the firewall before the firewall determines that the connection is idle.
        /// </summary>
        public readonly Outputs.FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts? FlowTimeouts;
        /// <summary>
        /// Indicates how to manage the order of stateful rule evaluation for the policy. Default value: `DEFAULT_ACTION_ORDER`. Valid values: `DEFAULT_ACTION_ORDER`, `STRICT_ORDER`.
        /// </summary>
        public readonly string? RuleOrder;
        /// <summary>
        /// Describes how to treat traffic which has broken midstream. Default value: `DROP`. Valid values: `DROP`, `CONTINUE`, `REJECT`.
        /// </summary>
        public readonly string? StreamExceptionPolicy;

        [OutputConstructor]
        private FirewallPolicyFirewallPolicyStatefulEngineOptions(
            Outputs.FirewallPolicyFirewallPolicyStatefulEngineOptionsFlowTimeouts? flowTimeouts,

            string? ruleOrder,

            string? streamExceptionPolicy)
        {
            FlowTimeouts = flowTimeouts;
            RuleOrder = ruleOrder;
            StreamExceptionPolicy = streamExceptionPolicy;
        }
    }
}
