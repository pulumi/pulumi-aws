// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.WafRegional.Inputs
{

    public sealed class RulePredicateArgs : global::Pulumi.ResourceArgs
    {
        [Input("dataId", required: true)]
        public Input<string> DataId { get; set; } = null!;

        [Input("negated", required: true)]
        public Input<bool> Negated { get; set; } = null!;

        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        public RulePredicateArgs()
        {
        }
        public static new RulePredicateArgs Empty => new RulePredicateArgs();
    }
}
