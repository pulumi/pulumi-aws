// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Inputs
{

    public sealed class InstanceEphemeralBlockDeviceGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("deviceName", required: true)]
        public Input<string> DeviceName { get; set; } = null!;

        [Input("virtualName", required: true)]
        public Input<string> VirtualName { get; set; } = null!;

        public InstanceEphemeralBlockDeviceGetArgs()
        {
        }
        public static new InstanceEphemeralBlockDeviceGetArgs Empty => new InstanceEphemeralBlockDeviceGetArgs();
    }
}
