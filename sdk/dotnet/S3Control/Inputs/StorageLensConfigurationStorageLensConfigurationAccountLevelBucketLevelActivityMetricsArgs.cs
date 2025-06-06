// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Control.Inputs
{

    public sealed class StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelActivityMetricsArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether the activity metrics are enabled.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        public StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelActivityMetricsArgs()
        {
        }
        public static new StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelActivityMetricsArgs Empty => new StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelActivityMetricsArgs();
    }
}
