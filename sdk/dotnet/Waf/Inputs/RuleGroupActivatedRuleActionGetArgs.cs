// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Waf.Inputs
{

    public sealed class RuleGroupActivatedRuleActionGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public RuleGroupActivatedRuleActionGetArgs()
        {
        }
        public static new RuleGroupActivatedRuleActionGetArgs Empty => new RuleGroupActivatedRuleActionGetArgs();
    }
}
