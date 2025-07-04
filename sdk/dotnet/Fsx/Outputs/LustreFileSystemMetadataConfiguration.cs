// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Fsx.Outputs
{

    [OutputType]
    public sealed class LustreFileSystemMetadataConfiguration
    {
        /// <summary>
        /// Amount of IOPS provisioned for metadata. This parameter should only be used when the mode is set to `USER_PROVISIONED`. Valid Values are `1500`,`3000`,`6000` and `12000` through `192000` in increments of `12000`. Valid values for `INTELLIGENT_TIERING` storage type are `6000` or `12000`.
        /// </summary>
        public readonly int? Iops;
        /// <summary>
        /// Mode for the metadata configuration of the file system. Valid values are `AUTOMATIC`, and `USER_PROVISIONED`. Must be set to `USER_PROVISIONED` for `INTELLIGENT_TIERING` storage type.
        /// 
        /// !&gt; **WARNING:** Updating the value of `iops` from a higher to a lower value will force a recreation of the resource. Any data on the file system will be lost when recreating.
        /// </summary>
        public readonly string? Mode;

        [OutputConstructor]
        private LustreFileSystemMetadataConfiguration(
            int? iops,

            string? mode)
        {
            Iops = iops;
            Mode = mode;
        }
    }
}
