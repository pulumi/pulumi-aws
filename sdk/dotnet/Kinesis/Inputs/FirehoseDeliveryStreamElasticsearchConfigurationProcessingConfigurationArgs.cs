// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Kinesis.Inputs
{

    public sealed class FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Enables or disables data processing.
        /// </summary>
        [Input("enabled")]
        public Input<bool>? Enabled { get; set; }

        [Input("processors")]
        private InputList<Inputs.FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationProcessorArgs>? _processors;

        /// <summary>
        /// Specifies the data processors as multiple blocks. See `processors` block below for details.
        /// </summary>
        public InputList<Inputs.FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationProcessorArgs> Processors
        {
            get => _processors ?? (_processors = new InputList<Inputs.FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationProcessorArgs>());
            set => _processors = value;
        }

        public FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationArgs()
        {
        }
        public static new FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationArgs Empty => new FirehoseDeliveryStreamElasticsearchConfigurationProcessingConfigurationArgs();
    }
}
