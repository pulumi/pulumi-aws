// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Acm.Outputs
{

    [OutputType]
    public sealed class CertificateRenewalSummary
    {
        /// <summary>
        /// The status of ACM's managed renewal of the certificate
        /// </summary>
        public readonly string? RenewalStatus;
        /// <summary>
        /// The reason that a renewal request was unsuccessful or is pending
        /// </summary>
        public readonly string? RenewalStatusReason;
        public readonly string? UpdatedAt;

        [OutputConstructor]
        private CertificateRenewalSummary(
            string? renewalStatus,

            string? renewalStatusReason,

            string? updatedAt)
        {
            RenewalStatus = renewalStatus;
            RenewalStatusReason = renewalStatusReason;
            UpdatedAt = updatedAt;
        }
    }
}
