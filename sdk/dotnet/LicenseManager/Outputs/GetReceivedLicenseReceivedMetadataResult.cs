// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.LicenseManager.Outputs
{

    [OutputType]
    public sealed class GetReceivedLicenseReceivedMetadataResult
    {
        /// <summary>
        /// A list of allowed operations.
        /// </summary>
        public readonly ImmutableArray<string> AllowedOperations;
        /// <summary>
        /// Received status.
        /// </summary>
        public readonly string ReceivedStatus;
        /// <summary>
        /// Received status reason.
        /// </summary>
        public readonly string ReceivedStatusReason;

        [OutputConstructor]
        private GetReceivedLicenseReceivedMetadataResult(
            ImmutableArray<string> allowedOperations,

            string receivedStatus,

            string receivedStatusReason)
        {
            AllowedOperations = allowedOperations;
            ReceivedStatus = receivedStatus;
            ReceivedStatusReason = receivedStatusReason;
        }
    }
}
