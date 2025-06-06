// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Inputs
{

    public sealed class FirewallPolicyFirewallPolicyStatelessRuleGroupReferenceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// An integer setting that indicates the order in which to run the stateless rule groups in a single policy. AWS Network Firewall applies each stateless rule group to a packet starting with the group that has the lowest priority setting.
        /// </summary>
        [Input("priority", required: true)]
        public Input<int> Priority { get; set; } = null!;

        /// <summary>
        /// The Amazon Resource Name (ARN) of the stateless rule group.
        /// </summary>
        [Input("resourceArn", required: true)]
        public Input<string> ResourceArn { get; set; } = null!;

        public FirewallPolicyFirewallPolicyStatelessRuleGroupReferenceArgs()
        {
        }
        public static new FirewallPolicyFirewallPolicyStatelessRuleGroupReferenceArgs Empty => new FirewallPolicyFirewallPolicyStatelessRuleGroupReferenceArgs();
    }
}
