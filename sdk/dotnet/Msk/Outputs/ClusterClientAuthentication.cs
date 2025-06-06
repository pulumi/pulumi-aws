// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Msk.Outputs
{

    [OutputType]
    public sealed class ClusterClientAuthentication
    {
        /// <summary>
        /// Configuration block for specifying SASL client authentication. See below.
        /// </summary>
        public readonly Outputs.ClusterClientAuthenticationSasl? Sasl;
        /// <summary>
        /// Configuration block for specifying TLS client authentication. See below.
        /// </summary>
        public readonly Outputs.ClusterClientAuthenticationTls? Tls;
        /// <summary>
        /// Enables unauthenticated access.
        /// </summary>
        public readonly bool? Unauthenticated;

        [OutputConstructor]
        private ClusterClientAuthentication(
            Outputs.ClusterClientAuthenticationSasl? sasl,

            Outputs.ClusterClientAuthenticationTls? tls,

            bool? unauthenticated)
        {
            Sasl = sasl;
            Tls = tls;
            Unauthenticated = unauthenticated;
        }
    }
}
