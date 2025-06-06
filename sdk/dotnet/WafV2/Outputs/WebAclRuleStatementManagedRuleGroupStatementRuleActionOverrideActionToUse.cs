// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Outputs
{

    [OutputType]
    public sealed class WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUse
    {
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllow? Allow;
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlock? Block;
        /// <summary>
        /// Instructs AWS WAF to run a Captcha check against the web request. See `captcha` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseCaptcha? Captcha;
        /// <summary>
        /// Instructs AWS WAF to run a check against the request to verify that the request is coming from a legitimate client session. See `challenge` below for details.
        /// </summary>
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseChallenge? Challenge;
        public readonly Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseCount? Count;

        [OutputConstructor]
        private WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUse(
            Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllow? allow,

            Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseBlock? block,

            Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseCaptcha? captcha,

            Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseChallenge? challenge,

            Outputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseCount? count)
        {
            Allow = allow;
            Block = block;
            Captcha = captcha;
            Challenge = challenge;
            Count = count;
        }
    }
}
