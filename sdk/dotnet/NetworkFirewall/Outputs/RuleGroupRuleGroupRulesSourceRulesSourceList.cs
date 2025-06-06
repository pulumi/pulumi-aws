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
    public sealed class RuleGroupRuleGroupRulesSourceRulesSourceList
    {
        /// <summary>
        /// String value to specify whether domains in the target list are allowed or denied access. Valid values: `ALLOWLIST`, `DENYLIST`.
        /// </summary>
        public readonly string GeneratedRulesType;
        /// <summary>
        /// Set of types of domain specifications that are provided in the `targets` argument. Valid values: `HTTP_HOST`, `TLS_SNI`.
        /// </summary>
        public readonly ImmutableArray<string> TargetTypes;
        /// <summary>
        /// Set of domains that you want to inspect for in your traffic flows.
        /// </summary>
        public readonly ImmutableArray<string> Targets;

        [OutputConstructor]
        private RuleGroupRuleGroupRulesSourceRulesSourceList(
            string generatedRulesType,

            ImmutableArray<string> targetTypes,

            ImmutableArray<string> targets)
        {
            GeneratedRulesType = generatedRulesType;
            TargetTypes = targetTypes;
            Targets = targets;
        }
    }
}
