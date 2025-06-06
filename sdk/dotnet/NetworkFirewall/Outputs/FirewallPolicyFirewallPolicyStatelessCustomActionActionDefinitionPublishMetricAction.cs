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
    public sealed class FirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction
    {
        /// <summary>
        /// Set of configuration blocks describing dimension settings to use for Amazon CloudWatch custom metrics. See Dimension below for more details.
        /// </summary>
        public readonly ImmutableArray<Outputs.FirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension> Dimensions;

        [OutputConstructor]
        private FirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricAction(ImmutableArray<Outputs.FirewallPolicyFirewallPolicyStatelessCustomActionActionDefinitionPublishMetricActionDimension> dimensions)
        {
            Dimensions = dimensions;
        }
    }
}
