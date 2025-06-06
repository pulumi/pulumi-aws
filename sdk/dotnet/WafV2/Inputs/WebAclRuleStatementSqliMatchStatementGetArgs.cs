// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class WebAclRuleStatementSqliMatchStatementGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Part of a web request that you want AWS WAF to inspect. See `field_to_match` below for details.
        /// </summary>
        [Input("fieldToMatch")]
        public Input<Inputs.WebAclRuleStatementSqliMatchStatementFieldToMatchGetArgs>? FieldToMatch { get; set; }

        /// <summary>
        /// Sensitivity that you want AWS WAF to use to inspect for SQL injection attacks. Valid values include: `LOW`, `HIGH`.
        /// </summary>
        [Input("sensitivityLevel")]
        public Input<string>? SensitivityLevel { get; set; }

        [Input("textTransformations", required: true)]
        private InputList<Inputs.WebAclRuleStatementSqliMatchStatementTextTransformationGetArgs>? _textTransformations;

        /// <summary>
        /// Text transformations eliminate some of the unusual formatting that attackers use in web requests in an effort to bypass detection. At least one transformation is required. See `text_transformation` below for details.
        /// </summary>
        public InputList<Inputs.WebAclRuleStatementSqliMatchStatementTextTransformationGetArgs> TextTransformations
        {
            get => _textTransformations ?? (_textTransformations = new InputList<Inputs.WebAclRuleStatementSqliMatchStatementTextTransformationGetArgs>());
            set => _textTransformations = value;
        }

        public WebAclRuleStatementSqliMatchStatementGetArgs()
        {
        }
        public static new WebAclRuleStatementSqliMatchStatementGetArgs Empty => new WebAclRuleStatementSqliMatchStatementGetArgs();
    }
}
