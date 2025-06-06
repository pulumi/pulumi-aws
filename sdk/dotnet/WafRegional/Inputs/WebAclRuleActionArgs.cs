// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafRegional.Inputs
{

    public sealed class WebAclRuleActionArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Specifies how you want AWS WAF Regional to respond to requests that match the settings in a rule. Valid values for `action` are `ALLOW`, `BLOCK` or `COUNT`. Valid values for `override_action` are `COUNT` and `NONE`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public WebAclRuleActionArgs()
        {
        }
        public static new WebAclRuleActionArgs Empty => new WebAclRuleActionArgs();
    }
}
