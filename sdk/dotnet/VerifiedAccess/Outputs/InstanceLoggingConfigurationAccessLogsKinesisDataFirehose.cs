// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.VerifiedAccess.Outputs
{

    [OutputType]
    public sealed class InstanceLoggingConfigurationAccessLogsKinesisDataFirehose
    {
        /// <summary>
        /// The name of the delivery stream.
        /// </summary>
        public readonly string? DeliveryStream;
        /// <summary>
        /// Indicates whether logging is enabled.
        /// </summary>
        public readonly bool Enabled;

        [OutputConstructor]
        private InstanceLoggingConfigurationAccessLogsKinesisDataFirehose(
            string? deliveryStream,

            bool enabled)
        {
            DeliveryStream = deliveryStream;
            Enabled = enabled;
        }
    }
}
