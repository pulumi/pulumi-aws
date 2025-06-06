// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Acmpca.Inputs
{

    public sealed class CertificateAuthorityRevocationConfigurationOcspConfigurationArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Boolean value that specifies whether a custom OCSP responder is enabled.
        /// </summary>
        [Input("enabled", required: true)]
        public Input<bool> Enabled { get; set; } = null!;

        /// <summary>
        /// CNAME specifying a customized OCSP domain. Note: The value of the CNAME must not include a protocol prefix such as "http://" or "https://".
        /// </summary>
        [Input("ocspCustomCname")]
        public Input<string>? OcspCustomCname { get; set; }

        public CertificateAuthorityRevocationConfigurationOcspConfigurationArgs()
        {
        }
        public static new CertificateAuthorityRevocationConfigurationOcspConfigurationArgs Empty => new CertificateAuthorityRevocationConfigurationOcspConfigurationArgs();
    }
}
