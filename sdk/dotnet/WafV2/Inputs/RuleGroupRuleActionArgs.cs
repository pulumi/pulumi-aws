// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleActionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Instructs AWS WAF to allow the web request. See Allow below for details.
        /// </summary>
        [Input("allow")]
        public Input<Inputs.RuleGroupRuleActionAllowArgs>? Allow { get; set; }

        /// <summary>
        /// Instructs AWS WAF to block the web request. See Block below for details.
        /// </summary>
        [Input("block")]
        public Input<Inputs.RuleGroupRuleActionBlockArgs>? Block { get; set; }

        /// <summary>
        /// Instructs AWS WAF to run a `CAPTCHA` check against the web request. See Captcha below for details.
        /// </summary>
        [Input("captcha")]
        public Input<Inputs.RuleGroupRuleActionCaptchaArgs>? Captcha { get; set; }

        /// <summary>
        /// Instructs AWS WAF to run a check against the request to verify that the request is coming from a legitimate client session. See Challenge below for details.
        /// </summary>
        [Input("challenge")]
        public Input<Inputs.RuleGroupRuleActionChallengeArgs>? Challenge { get; set; }

        /// <summary>
        /// Instructs AWS WAF to count the web request and allow it. See Count below for details.
        /// </summary>
        [Input("count")]
        public Input<Inputs.RuleGroupRuleActionCountArgs>? Count { get; set; }

        public RuleGroupRuleActionArgs()
        {
        }
        public static new RuleGroupRuleActionArgs Empty => new RuleGroupRuleActionArgs();
    }
}
