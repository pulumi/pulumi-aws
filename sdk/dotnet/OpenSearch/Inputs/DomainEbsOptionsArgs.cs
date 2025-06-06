// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpenSearch.Inputs
{

    public sealed class DomainEbsOptionsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether EBS volumes are attached to data nodes in the domain.
        /// </summary>
        [Input("ebsEnabled", required: true)]
        public Input<bool> EbsEnabled { get; set; } = null!;

        /// <summary>
        /// Baseline input/output (I/O) performance of EBS volumes attached to data nodes. Applicable only for the GP3 and Provisioned IOPS EBS volume types.
        /// </summary>
        [Input("iops")]
        public Input<int>? Iops { get; set; }

        /// <summary>
        /// Specifies the throughput (in MiB/s) of the EBS volumes attached to data nodes. Applicable only for the gp3 volume type.
        /// </summary>
        [Input("throughput")]
        public Input<int>? Throughput { get; set; }

        /// <summary>
        /// Size of EBS volumes attached to data nodes (in GiB).
        /// </summary>
        [Input("volumeSize")]
        public Input<int>? VolumeSize { get; set; }

        /// <summary>
        /// Type of EBS volumes attached to data nodes.
        /// </summary>
        [Input("volumeType")]
        public Input<string>? VolumeType { get; set; }

        public DomainEbsOptionsArgs()
        {
        }
        public static new DomainEbsOptionsArgs Empty => new DomainEbsOptionsArgs();
    }
}
