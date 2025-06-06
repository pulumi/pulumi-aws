// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Inputs
{

    public sealed class RuleGroupRuleGroupRuleVariablesGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("ipSets")]
        private InputList<Inputs.RuleGroupRuleGroupRuleVariablesIpSetGetArgs>? _ipSets;

        /// <summary>
        /// Set of configuration blocks that define IP address information. See IP Sets below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRuleVariablesIpSetGetArgs> IpSets
        {
            get => _ipSets ?? (_ipSets = new InputList<Inputs.RuleGroupRuleGroupRuleVariablesIpSetGetArgs>());
            set => _ipSets = value;
        }

        [Input("portSets")]
        private InputList<Inputs.RuleGroupRuleGroupRuleVariablesPortSetGetArgs>? _portSets;

        /// <summary>
        /// Set of configuration blocks that define port range information. See Port Sets below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRuleVariablesPortSetGetArgs> PortSets
        {
            get => _portSets ?? (_portSets = new InputList<Inputs.RuleGroupRuleGroupRuleVariablesPortSetGetArgs>());
            set => _portSets = value;
        }

        public RuleGroupRuleGroupRuleVariablesGetArgs()
        {
        }
        public static new RuleGroupRuleGroupRuleVariablesGetArgs Empty => new RuleGroupRuleGroupRuleVariablesGetArgs();
    }
}
