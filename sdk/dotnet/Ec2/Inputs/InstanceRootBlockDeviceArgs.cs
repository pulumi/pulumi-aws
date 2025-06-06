// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class InstanceRootBlockDeviceArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether the volume should be destroyed on instance termination. Defaults to `true`.
        /// </summary>
        [Input("deleteOnTermination")]
        public Input<bool>? DeleteOnTermination { get; set; }

        /// <summary>
        /// Device name, e.g., `/dev/sdh` or `xvdh`.
        /// </summary>
        [Input("deviceName")]
        public Input<string>? DeviceName { get; set; }

        /// <summary>
        /// Whether to enable volume encryption. Defaults to `false`. Must be configured to perform drift detection.
        /// </summary>
        [Input("encrypted")]
        public Input<bool>? Encrypted { get; set; }

        /// <summary>
        /// Amount of provisioned [IOPS](https://docs.aws.amazon.com/AWSEC2/latest/UserGuide/ebs-io-characteristics.html). Only valid for volume_type of `io1`, `io2` or `gp3`.
        /// </summary>
        [Input("iops")]
        public Input<int>? Iops { get; set; }

        /// <summary>
        /// Amazon Resource Name (ARN) of the KMS Key to use when encrypting the volume. Must be configured to perform drift detection.
        /// </summary>
        [Input("kmsKeyId")]
        public Input<string>? KmsKeyId { get; set; }

        [Input("tags")]
        private InputMap<string>? _tags;

        /// <summary>
        /// Map of tags to assign to the device.
        /// </summary>
        public InputMap<string> Tags
        {
            get => _tags ?? (_tags = new InputMap<string>());
            set => _tags = value;
        }

        [Input("tagsAll")]
        private InputMap<string>? _tagsAll;

        /// <summary>
        /// Map of tags assigned to the resource, including those inherited from the provider `default_tags` configuration block.
        /// </summary>
        public InputMap<string> TagsAll
        {
            get => _tagsAll ?? (_tagsAll = new InputMap<string>());
            set => _tagsAll = value;
        }

        /// <summary>
        /// Throughput to provision for a volume in mebibytes per second (MiB/s). This is only valid for `volume_type` of `gp3`.
        /// </summary>
        [Input("throughput")]
        public Input<int>? Throughput { get; set; }

        /// <summary>
        /// ID of the volume. For example, the ID can be accessed like this, `aws_instance.web.root_block_device.0.volume_id`.
        /// </summary>
        [Input("volumeId")]
        public Input<string>? VolumeId { get; set; }

        /// <summary>
        /// Size of the volume in gibibytes (GiB).
        /// </summary>
        [Input("volumeSize")]
        public Input<int>? VolumeSize { get; set; }

        /// <summary>
        /// Type of volume. Valid values include `standard`, `gp2`, `gp3`, `io1`, `io2`, `sc1`, or `st1`. Defaults to the volume type that the AMI uses.
        /// 
        /// Modifying the `encrypted` or `kms_key_id` settings of the `root_block_device` requires resource replacement.
        /// </summary>
        [Input("volumeType")]
        public Input<string>? VolumeType { get; set; }

        public InstanceRootBlockDeviceArgs()
        {
        }
        public static new InstanceRootBlockDeviceArgs Empty => new InstanceRootBlockDeviceArgs();
    }
}
