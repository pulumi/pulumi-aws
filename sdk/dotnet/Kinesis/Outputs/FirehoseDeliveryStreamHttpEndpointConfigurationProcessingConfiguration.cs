// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Outputs
{

    [OutputType]
    public sealed class FirehoseDeliveryStreamHttpEndpointConfigurationProcessingConfiguration
    {
        /// <summary>
        /// Enables or disables data processing.
        /// </summary>
        public readonly bool? Enabled;
        /// <summary>
        /// Specifies the data processors as multiple blocks. See `processors` block below for details.
        /// </summary>
        public readonly ImmutableArray<Outputs.FirehoseDeliveryStreamHttpEndpointConfigurationProcessingConfigurationProcessor> Processors;

        [OutputConstructor]
        private FirehoseDeliveryStreamHttpEndpointConfigurationProcessingConfiguration(
            bool? enabled,

            ImmutableArray<Outputs.FirehoseDeliveryStreamHttpEndpointConfigurationProcessingConfigurationProcessor> processors)
        {
            Enabled = enabled;
            Processors = processors;
        }
    }
}
