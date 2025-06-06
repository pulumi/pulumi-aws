// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.CloudWatch.Outputs
{

    [OutputType]
    public sealed class InternetMonitorInternetMeasurementsLogDeliveryS3Config
    {
        public readonly string BucketName;
        public readonly string? BucketPrefix;
        public readonly string? LogDeliveryStatus;

        [OutputConstructor]
        private InternetMonitorInternetMeasurementsLogDeliveryS3Config(
            string bucketName,

            string? bucketPrefix,

            string? logDeliveryStatus)
        {
            BucketName = bucketName;
            BucketPrefix = bucketPrefix;
            LogDeliveryStatus = logDeliveryStatus;
        }
    }
}
