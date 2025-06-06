// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The part of a web request that you want AWS WAF to inspect. See Field to Match below for details.
        /// </summary>
        [Input("fieldToMatch")]
        public Input<Inputs.RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementFieldToMatchArgs>? FieldToMatch { get; set; }

        /// <summary>
        /// Sensitivity that you want AWS WAF to use to inspect for SQL injection attacks. Valid values include: `LOW`, `HIGH`.
        /// </summary>
        [Input("sensitivityLevel")]
        public Input<string>? SensitivityLevel { get; set; }

        [Input("textTransformations", required: true)]
        private InputList<Inputs.RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementTextTransformationArgs>? _textTransformations;

        /// <summary>
        /// Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection.
        /// At least one required.
        /// See Text Transformation below for details.
        /// </summary>
        public InputList<Inputs.RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementTextTransformationArgs> TextTransformations
        {
            get => _textTransformations ?? (_textTransformations = new InputList<Inputs.RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementTextTransformationArgs>());
            set => _textTransformations = value;
        }

        public RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementArgs()
        {
        }
        public static new RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementArgs Empty => new RuleGroupRuleStatementRateBasedStatementScopeDownStatementSqliMatchStatementArgs();
    }
}
