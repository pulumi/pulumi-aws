// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.EmrServerless.Outputs
{

    [OutputType]
    public sealed class ApplicationInitialCapacity
    {
        /// <summary>
        /// The initial capacity configuration per worker.
        /// </summary>
        public readonly Outputs.ApplicationInitialCapacityInitialCapacityConfig? InitialCapacityConfig;
        /// <summary>
        /// The worker type for an analytics framework. For Spark applications, the key can either be set to `Driver` or `Executor`. For Hive applications, it can be set to `HiveDriver` or `TezTask`.
        /// </summary>
        public readonly string InitialCapacityType;

        [OutputConstructor]
        private ApplicationInitialCapacity(
            Outputs.ApplicationInitialCapacityInitialCapacityConfig? initialCapacityConfig,

            string initialCapacityType)
        {
            InitialCapacityConfig = initialCapacityConfig;
            InitialCapacityType = initialCapacityType;
        }
    }
}
