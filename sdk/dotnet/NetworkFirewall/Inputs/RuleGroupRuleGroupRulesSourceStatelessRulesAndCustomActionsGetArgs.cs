// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Inputs
{

    public sealed class RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("customActions")]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsCustomActionGetArgs>? _customActions;

        /// <summary>
        /// Set of configuration blocks containing custom action definitions that are available for use by the set of `stateless rule`. See Custom Action below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsCustomActionGetArgs> CustomActions
        {
            get => _customActions ?? (_customActions = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsCustomActionGetArgs>());
            set => _customActions = value;
        }

        [Input("statelessRules", required: true)]
        private InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleGetArgs>? _statelessRules;

        /// <summary>
        /// Set of configuration blocks containing the stateless rules for use in the stateless rule group. See Stateless Rule below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleGetArgs> StatelessRules
        {
            get => _statelessRules ?? (_statelessRules = new InputList<Inputs.RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsStatelessRuleGetArgs>());
            set => _statelessRules = value;
        }

        public RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsGetArgs()
        {
        }
        public static new RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsGetArgs Empty => new RuleGroupRuleGroupRulesSourceStatelessRulesAndCustomActionsGetArgs();
    }
}
