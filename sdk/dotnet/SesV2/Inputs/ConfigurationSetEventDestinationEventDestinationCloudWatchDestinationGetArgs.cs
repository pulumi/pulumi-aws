// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2.Inputs
{

    public sealed class ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("dimensionConfigurations", required: true)]
        private InputList<Inputs.ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationDimensionConfigurationGetArgs>? _dimensionConfigurations;

        /// <summary>
        /// An array of objects that define the dimensions to use when you send email events to Amazon CloudWatch. See `dimension_configuration` Block for details.
        /// </summary>
        public InputList<Inputs.ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationDimensionConfigurationGetArgs> DimensionConfigurations
        {
            get => _dimensionConfigurations ?? (_dimensionConfigurations = new InputList<Inputs.ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationDimensionConfigurationGetArgs>());
            set => _dimensionConfigurations = value;
        }

        public ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationGetArgs()
        {
        }
        public static new ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationGetArgs Empty => new ConfigurationSetEventDestinationEventDestinationCloudWatchDestinationGetArgs();
    }
}
