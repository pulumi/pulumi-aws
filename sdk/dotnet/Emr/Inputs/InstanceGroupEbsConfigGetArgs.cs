// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Emr.Inputs
{

    public sealed class InstanceGroupEbsConfigGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// The number of I/O operations per second (IOPS) that the volume supports.
        /// </summary>
        [Input("iops")]
        public Input<int>? Iops { get; set; }

        /// <summary>
        /// The volume size, in gibibytes (GiB). This can be a number from 1 - 1024. If the volume type is EBS-optimized, the minimum value is 10.
        /// </summary>
        [Input("size", required: true)]
        public Input<int> Size { get; set; } = null!;

        /// <summary>
        /// The volume type. Valid options are 'gp2', 'io1' and 'standard'.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        /// <summary>
        /// The number of EBS Volumes to attach per instance.
        /// </summary>
        [Input("volumesPerInstance")]
        public Input<int>? VolumesPerInstance { get; set; }

        public InstanceGroupEbsConfigGetArgs()
        {
        }
        public static new InstanceGroupEbsConfigGetArgs Empty => new InstanceGroupEbsConfigGetArgs();
    }
}
