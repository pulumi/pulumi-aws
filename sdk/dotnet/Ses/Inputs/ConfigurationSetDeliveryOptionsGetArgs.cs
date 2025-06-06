// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Ses.Inputs
{

    public sealed class ConfigurationSetDeliveryOptionsGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Whether messages that use the configuration set are required to use Transport Layer Security (TLS). If the value is `Require`, messages are only delivered if a TLS connection can be established. If the value is `Optional`, messages can be delivered in plain text if a TLS connection can't be established. Valid values: `Require` or `Optional`. Defaults to `Optional`.
        /// </summary>
        [Input("tlsPolicy")]
        public Input<string>? TlsPolicy { get; set; }

        public ConfigurationSetDeliveryOptionsGetArgs()
        {
        }
        public static new ConfigurationSetDeliveryOptionsGetArgs Empty => new ConfigurationSetDeliveryOptionsGetArgs();
    }
}
