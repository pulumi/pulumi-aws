// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerRuleMatchHttpMatchGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("headerMatches")]
        private InputList<Inputs.ListenerRuleMatchHttpMatchHeaderMatchGetArgs>? _headerMatches;

        /// <summary>
        /// The header matches. Matches incoming requests with rule based on request header value before applying rule action.
        /// </summary>
        public InputList<Inputs.ListenerRuleMatchHttpMatchHeaderMatchGetArgs> HeaderMatches
        {
            get => _headerMatches ?? (_headerMatches = new InputList<Inputs.ListenerRuleMatchHttpMatchHeaderMatchGetArgs>());
            set => _headerMatches = value;
        }

        /// <summary>
        /// The HTTP method type.
        /// </summary>
        [Input("method")]
        public Input<string>? Method { get; set; }

        /// <summary>
        /// The path match.
        /// </summary>
        [Input("pathMatch")]
        public Input<Inputs.ListenerRuleMatchHttpMatchPathMatchGetArgs>? PathMatch { get; set; }

        public ListenerRuleMatchHttpMatchGetArgs()
        {
        }
        public static new ListenerRuleMatchHttpMatchGetArgs Empty => new ListenerRuleMatchHttpMatchGetArgs();
    }
}