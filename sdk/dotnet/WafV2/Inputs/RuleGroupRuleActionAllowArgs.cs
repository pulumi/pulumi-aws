// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class RuleGroupRuleActionAllowArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Defines custom handling for the web request. See Custom Request Handling below for details.
        /// </summary>
        [Input("customRequestHandling")]
        public Input<Inputs.RuleGroupRuleActionAllowCustomRequestHandlingArgs>? CustomRequestHandling { get; set; }

        public RuleGroupRuleActionAllowArgs()
        {
        }
        public static new RuleGroupRuleActionAllowArgs Empty => new RuleGroupRuleActionAllowArgs();
    }
}
