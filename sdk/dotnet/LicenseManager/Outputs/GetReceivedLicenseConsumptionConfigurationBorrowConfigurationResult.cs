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
    public sealed class GetReceivedLicenseConsumptionConfigurationBorrowConfigurationResult
    {
        /// <summary>
        /// Indicates whether early check-ins are allowed.
        /// </summary>
        public readonly bool AllowEarlyCheckIn;
        /// <summary>
        /// Maximum time for the provisional configuration, in minutes.
        /// </summary>
        public readonly int MaxTimeToLiveInMinutes;

        [OutputConstructor]
        private GetReceivedLicenseConsumptionConfigurationBorrowConfigurationResult(
            bool allowEarlyCheckIn,

            int maxTimeToLiveInMinutes)
        {
            AllowEarlyCheckIn = allowEarlyCheckIn;
            MaxTimeToLiveInMinutes = maxTimeToLiveInMinutes;
        }
    }
}
