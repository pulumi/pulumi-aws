// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerRuleMatchArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The HTTP criteria that a rule must match.
        /// </summary>
        [Input("httpMatch")]
        public Input<Inputs.ListenerRuleMatchHttpMatchArgs>? HttpMatch { get; set; }

        public ListenerRuleMatchArgs()
        {
        }
        public static new ListenerRuleMatchArgs Empty => new ListenerRuleMatchArgs();
    }
}