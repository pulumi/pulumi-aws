// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.S3Control.Outputs
{

    [OutputType]
    public sealed class StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelDetailedStatusCodeMetrics
    {
        /// <summary>
        /// Whether detailed status code metrics are enabled.
        /// </summary>
        public readonly bool? Enabled;

        [OutputConstructor]
        private StorageLensConfigurationStorageLensConfigurationAccountLevelBucketLevelDetailedStatusCodeMetrics(bool? enabled)
        {
            Enabled = enabled;
        }
    }
}
