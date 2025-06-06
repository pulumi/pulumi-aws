// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Alb.Inputs
{

    public sealed class ListenerMutualAuthenticationGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Valid values are `off` and `on`.
        /// </summary>
        [Input("advertiseTrustStoreCaNames")]
        public Input<string>? AdvertiseTrustStoreCaNames { get; set; }

        /// <summary>
        /// Whether client certificate expiry is ignored. Default is `false`.
        /// </summary>
        [Input("ignoreClientCertificateExpiry")]
        public Input<bool>? IgnoreClientCertificateExpiry { get; set; }

        /// <summary>
        /// Valid values are `off`, `verify` and `passthrough`.
        /// </summary>
        [Input("mode", required: true)]
        public Input<string> Mode { get; set; } = null!;

        /// <summary>
        /// ARN of the elbv2 Trust Store.
        /// </summary>
        [Input("trustStoreArn")]
        public Input<string>? TrustStoreArn { get; set; }

        public ListenerMutualAuthenticationGetArgs()
        {
        }
        public static new ListenerMutualAuthenticationGetArgs Empty => new ListenerMutualAuthenticationGetArgs();
    }
}
