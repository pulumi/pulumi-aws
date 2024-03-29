// *** WARNING: this file was generated by the Pulumi Terraform Bridge (tfgen) Tool. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.SesV2.Outputs
{

    [OutputType]
    public sealed class ConfigurationSetDeliveryOptions
    {
        /// <summary>
        /// The name of the dedicated IP pool to associate with the configuration set.
        /// </summary>
        public readonly string? SendingPoolName;
        /// <summary>
        /// Specifies whether messages that use the configuration set are required to use Transport Layer Security (TLS). Valid values: `REQUIRE`, `OPTIONAL`.
        /// </summary>
        public readonly string? TlsPolicy;

        [OutputConstructor]
        private ConfigurationSetDeliveryOptions(
            string? sendingPoolName,

            string? tlsPolicy)
        {
            SendingPoolName = sendingPoolName;
            TlsPolicy = tlsPolicy;
        }
    }
}
