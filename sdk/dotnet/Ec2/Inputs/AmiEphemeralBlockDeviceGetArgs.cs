// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Inputs
{

    public sealed class AmiEphemeralBlockDeviceGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Path at which the device is exposed to created instances.
        /// </summary>
        [Input("deviceName", required: true)]
        public Input<string> DeviceName { get; set; } = null!;

        /// <summary>
        /// Name for the ephemeral device, of the form "ephemeralN" where
        /// *N* is a volume number starting from zero.
        /// </summary>
        [Input("virtualName", required: true)]
        public Input<string> VirtualName { get; set; } = null!;

        public AmiEphemeralBlockDeviceGetArgs()
        {
        }
        public static new AmiEphemeralBlockDeviceGetArgs Empty => new AmiEphemeralBlockDeviceGetArgs();
    }
}
