// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.AppMesh.Inputs
{

    public sealed class VirtualNodeSpecBackendDefaultsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Default client policy for virtual service backends. See above for details.
        /// </summary>
        [Input("clientPolicy")]
        public Input<Inputs.VirtualNodeSpecBackendDefaultsClientPolicyArgs>? ClientPolicy { get; set; }

        public VirtualNodeSpecBackendDefaultsArgs()
        {
        }
        public static new VirtualNodeSpecBackendDefaultsArgs Empty => new VirtualNodeSpecBackendDefaultsArgs();
    }
}
