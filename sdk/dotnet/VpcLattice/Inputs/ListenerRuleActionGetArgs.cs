// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerRuleActionGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Describes the rule action that returns a custom HTTP response.
        /// </summary>
        [Input("fixedResponse")]
        public Input<Inputs.ListenerRuleActionFixedResponseGetArgs>? FixedResponse { get; set; }

        /// <summary>
        /// The forward action. Traffic that matches the rule is forwarded to the specified target groups.
        /// </summary>
        [Input("forward")]
        public Input<Inputs.ListenerRuleActionForwardGetArgs>? Forward { get; set; }

        public ListenerRuleActionGetArgs()
        {
        }
        public static new ListenerRuleActionGetArgs Empty => new ListenerRuleActionGetArgs();
    }
}