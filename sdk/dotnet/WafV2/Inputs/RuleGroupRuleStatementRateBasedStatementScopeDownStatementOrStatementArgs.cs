// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleStatementRateBasedStatementScopeDownStatementOrStatementArgs : global::Pulumi.ResourceArgs
    {
        [Input("statements", required: true)]
        private InputList<Inputs.RuleGroupRuleStatementArgs>? _statements;

        /// <summary>
        /// The statements to combine.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleStatementArgs> Statements
        {
            get => _statements ?? (_statements = new InputList<Inputs.RuleGroupRuleStatementArgs>());
            set => _statements = value;
        }

        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementOrStatementArgs()
        {
        }
        public static new RuleGroupRuleStatementRateBasedStatementScopeDownStatementOrStatementArgs Empty => new RuleGroupRuleStatementRateBasedStatementScopeDownStatementOrStatementArgs();
    }
}
