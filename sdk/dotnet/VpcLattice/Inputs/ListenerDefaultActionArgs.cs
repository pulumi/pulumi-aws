// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VpcLattice.Inputs
{

    public sealed class ListenerDefaultActionArgs : global::Pulumi.ResourceArgs
    {
        [Input("fixedResponse")]
        public Input<Inputs.ListenerDefaultActionFixedResponseArgs>? FixedResponse { get; set; }

        [Input("forwards")]
        private InputList<Inputs.ListenerDefaultActionForwardArgs>? _forwards;

        /// <summary>
        /// Route requests to one or more target groups. See Forward blocks below.
        /// </summary>
        public InputList<Inputs.ListenerDefaultActionForwardArgs> Forwards
        {
            get => _forwards ?? (_forwards = new InputList<Inputs.ListenerDefaultActionForwardArgs>());
            set => _forwards = value;
        }

        public ListenerDefaultActionArgs()
        {
        }
        public static new ListenerDefaultActionArgs Empty => new ListenerDefaultActionArgs();
    }
}