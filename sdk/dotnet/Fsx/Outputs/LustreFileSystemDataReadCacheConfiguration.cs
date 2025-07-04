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
    public sealed class LustreFileSystemDataReadCacheConfiguration
    {
        /// <summary>
        /// Size of the file system's SSD read cache, in gibibytes (GiB). Required when the `sizing_mode` is `USER_PROVISIONED`.
        /// </summary>
        public readonly int? Size;
        /// <summary>
        /// Sizing mode for the cache. Valud values are `NO_CACHE`, `USER_PROVISIONED`, and `PROPORTIONAL_TO_THROUGHPUT_CAPACITY`.
        /// </summary>
        public readonly string SizingMode;

        [OutputConstructor]
        private LustreFileSystemDataReadCacheConfiguration(
            int? size,

            string sizingMode)
        {
            Size = size;
            SizingMode = sizingMode;
        }
    }
}
