// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EmrContainers.Inputs
{

    public sealed class VirtualClusterContainerProviderInfoGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Nested list containing EKS-specific information about the cluster where the EMR Containers cluster is running
        /// </summary>
        [Input("eksInfo", required: true)]
        public Input<Inputs.VirtualClusterContainerProviderInfoEksInfoGetArgs> EksInfo { get; set; } = null!;

        public VirtualClusterContainerProviderInfoGetArgs()
        {
        }
        public static new VirtualClusterContainerProviderInfoGetArgs Empty => new VirtualClusterContainerProviderInfoGetArgs();
    }
}
