// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("allow")]
        public Input<Inputs.WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseAllowGetArgs>? Allow { get; set; }

        [Input("block")]
        public Input<Inputs.WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseBlockGetArgs>? Block { get; set; }

        /// <summary>
        /// Instructs AWS WAF to run a Captcha check against the web request. See `captcha` below for details.
        /// </summary>
        [Input("captcha")]
        public Input<Inputs.WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseCaptchaGetArgs>? Captcha { get; set; }

        /// <summary>
        /// Instructs AWS WAF to run a check against the request to verify that the request is coming from a legitimate client session. See `challenge` below for details.
        /// </summary>
        [Input("challenge")]
        public Input<Inputs.WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseChallengeGetArgs>? Challenge { get; set; }

        [Input("count")]
        public Input<Inputs.WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseCountGetArgs>? Count { get; set; }

        public WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseGetArgs()
        {
        }
        public static new WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseGetArgs Empty => new WebAclRuleStatementRuleGroupReferenceStatementRuleActionOverrideActionToUseGetArgs();
    }
}
