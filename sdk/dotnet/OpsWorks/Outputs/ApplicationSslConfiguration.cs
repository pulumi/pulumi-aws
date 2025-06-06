// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.OpsWorks.Outputs
{

    [OutputType]
    public sealed class ApplicationSslConfiguration
    {
        /// <summary>
        /// The contents of the certificate's domain.crt file.
        /// </summary>
        public readonly string Certificate;
        /// <summary>
        /// Can be used to specify an intermediate certificate authority key or client authentication.
        /// </summary>
        public readonly string? Chain;
        /// <summary>
        /// The private key; the contents of the certificate's domain.key file.
        /// </summary>
        public readonly string PrivateKey;

        [OutputConstructor]
        private ApplicationSslConfiguration(
            string certificate,

            string? chain,

            string privateKey)
        {
            Certificate = certificate;
            Chain = chain;
            PrivateKey = privateKey;
        }
    }
}
