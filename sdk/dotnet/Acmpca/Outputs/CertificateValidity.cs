// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Acmpca.Outputs
{

    [OutputType]
    public sealed class CertificateValidity
    {
        /// <summary>
        /// Determines how `value` is interpreted. Valid values: `DAYS`, `MONTHS`, `YEARS`, `ABSOLUTE`, `END_DATE`.
        /// </summary>
        public readonly string Type;
        /// <summary>
        /// If `type` is `DAYS`, `MONTHS`, or `YEARS`, the relative time until the certificate expires. If `type` is `ABSOLUTE`, the date in seconds since the Unix epoch. If `type` is `END_DATE`, the  date in RFC 3339 format.
        /// </summary>
        public readonly string Value;

        [OutputConstructor]
        private CertificateValidity(
            string type,

            string value)
        {
            Type = type;
            Value = value;
        }
    }
}
