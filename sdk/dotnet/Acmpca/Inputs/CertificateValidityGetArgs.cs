// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Acmpca.Inputs
{

    public sealed class CertificateValidityGetArgs : global::Pulumi.ResourceArgs
    {
        /// <summary>
        /// Determines how `value` is interpreted. Valid values: `DAYS`, `MONTHS`, `YEARS`, `ABSOLUTE`, `END_DATE`.
        /// </summary>
        [Input("type", required: true)]
        public Input<string> Type { get; set; } = null!;

        /// <summary>
        /// If `type` is `DAYS`, `MONTHS`, or `YEARS`, the relative time until the certificate expires. If `type` is `ABSOLUTE`, the date in seconds since the Unix epoch. If `type` is `END_DATE`, the  date in RFC 3339 format.
        /// </summary>
        [Input("value", required: true)]
        public Input<string> Value { get; set; } = null!;

        public CertificateValidityGetArgs()
        {
        }
        public static new CertificateValidityGetArgs Empty => new CertificateValidityGetArgs();
    }
}
