// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualNodeSpecListenerTimeoutHttp2Args : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Idle timeout. An idle timeout bounds the amount of time that a connection may be idle.
        /// </summary>
        [Input("idle")]
        public Input<Inputs.VirtualNodeSpecListenerTimeoutHttp2IdleArgs>? Idle { get; set; }

        /// <summary>
        /// Per request timeout.
        /// </summary>
        [Input("perRequest")]
        public Input<Inputs.VirtualNodeSpecListenerTimeoutHttp2PerRequestArgs>? PerRequest { get; set; }

        public VirtualNodeSpecListenerTimeoutHttp2Args()
        {
        }
        public static new VirtualNodeSpecListenerTimeoutHttp2Args Empty => new VirtualNodeSpecListenerTimeoutHttp2Args();
    }
}
