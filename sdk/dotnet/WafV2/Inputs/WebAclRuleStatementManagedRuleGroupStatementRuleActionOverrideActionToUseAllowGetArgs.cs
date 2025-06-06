// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafV2.Inputs
{

    public sealed class WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllowGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Defines custom handling for the web request. See `custom_request_handling` below for details.
        /// </summary>
        [Input("customRequestHandling")]
        public Input<Inputs.WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllowCustomRequestHandlingGetArgs>? CustomRequestHandling { get; set; }

        public WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllowGetArgs()
        {
        }
        public static new WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllowGetArgs Empty => new WebAclRuleStatementManagedRuleGroupStatementRuleActionOverrideActionToUseAllowGetArgs();
    }
}
