// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.ElastiCache.Outputs
{

    [OutputType]
    public sealed class ServerlessCacheCacheUsageLimits
    {
        /// <summary>
        /// The maximum data storage limit in the cache, expressed in Gigabytes. See `data_storage` Block for details.
        /// </summary>
        public readonly Outputs.ServerlessCacheCacheUsageLimitsDataStorage? DataStorage;
        /// <summary>
        /// The configuration for the number of ElastiCache Processing Units (ECPU) the cache can consume per second. See `ecpu_per_second` Block for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.ServerlessCacheCacheUsageLimitsEcpuPerSecond> EcpuPerSeconds;

        [OutputConstructor]
        private ServerlessCacheCacheUsageLimits(
            Outputs.ServerlessCacheCacheUsageLimitsDataStorage? dataStorage,

            ImmutableArray<Outputs.ServerlessCacheCacheUsageLimitsEcpuPerSecond> ecpuPerSeconds)
        {
            DataStorage = dataStorage;
            EcpuPerSeconds = ecpuPerSeconds;
        }
    }
}
