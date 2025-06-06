// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.GlobalAccelerator.Inputs
{

    public sealed class CrossAccountAttachmentResourceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// IP address range, in CIDR format, that is specified as resource.
        /// </summary>
        [Input("cidrBlock")]
        public Input<string>? CidrBlock { get; set; }

        /// <summary>
        /// The endpoint ID for the endpoint that is specified as a AWS resource.
        /// </summary>
        [Input("endpointId")]
        public Input<string>? EndpointId { get; set; }

        /// <summary>
        /// The AWS Region where a shared endpoint resource is located.
        /// </summary>
        [Input("region")]
        public Input<string>? Region { get; set; }

        public CrossAccountAttachmentResourceArgs()
        {
        }
        public static new CrossAccountAttachmentResourceArgs Empty => new CrossAccountAttachmentResourceArgs();
    }
}
