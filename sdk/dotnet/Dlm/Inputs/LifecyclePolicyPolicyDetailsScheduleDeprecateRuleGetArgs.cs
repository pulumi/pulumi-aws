// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Dlm.Inputs
{

    public sealed class LifecyclePolicyPolicyDetailsScheduleDeprecateRuleGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("count")]
        public Input<int>? Count { get; set; }

        [Input("interval")]
        public Input<int>? Interval { get; set; }

        [Input("intervalUnit")]
        public Input<string>? IntervalUnit { get; set; }

        public LifecyclePolicyPolicyDetailsScheduleDeprecateRuleGetArgs()
        {
        }
        public static new LifecyclePolicyPolicyDetailsScheduleDeprecateRuleGetArgs Empty => new LifecyclePolicyPolicyDetailsScheduleDeprecateRuleGetArgs();
    }
}
