// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.NetworkFirewall.Inputs
{

    public sealed class LoggingConfigurationLoggingConfigurationGetArgs : global::Pulumi.ResourceArgs
    {
        [Input("logDestinationConfigs", required: true)]
        private InputList<Inputs.LoggingConfigurationLoggingConfigurationLogDestinationConfigGetArgs>? _logDestinationConfigs;

        /// <summary>
        /// Set of configuration blocks describing the logging details for a firewall. See Log Destination Config below for details. At most, only Three blocks can be specified; one for `FLOW` logs and one for `ALERT` logs and one for `TLS` logs.
        /// </summary>
        public InputList<Inputs.LoggingConfigurationLoggingConfigurationLogDestinationConfigGetArgs> LogDestinationConfigs
        {
            get => _logDestinationConfigs ?? (_logDestinationConfigs = new InputList<Inputs.LoggingConfigurationLoggingConfigurationLogDestinationConfigGetArgs>());
            set => _logDestinationConfigs = value;
        }

        public LoggingConfigurationLoggingConfigurationGetArgs()
        {
        }
        public static new LoggingConfigurationLoggingConfigurationGetArgs Empty => new LoggingConfigurationLoggingConfigurationGetArgs();
    }
}
