// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ec2.Outputs
{

    [OutputType]
    public sealed class AmiFromInstanceEphemeralBlockDevice
    {
        /// <summary>
        /// Path at which the device is exposed to created instances.
        /// </summary>
        public readonly string? DeviceName;
        /// <summary>
        /// Name for the ephemeral device, of the form "ephemeralN" where
        /// *N* is a volume number starting from zero.
        /// </summary>
        public readonly string? VirtualName;

        [OutputConstructor]
        private AmiFromInstanceEphemeralBlockDevice(
            string? deviceName,

            string? virtualName)
        {
            DeviceName = deviceName;
            VirtualName = virtualName;
        }
    }
}
