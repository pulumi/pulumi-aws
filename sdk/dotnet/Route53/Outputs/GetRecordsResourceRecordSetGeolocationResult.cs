// *** WARNING: this file was generated by pulumi-language-dotnet. ***
// *** Do not edit by hand unless you're certain you know what you are doing! ***

using System;
using System.Collections.Generic;
using System.Collections.Immutable;
using System.Threading.Tasks;
using Pulumi.Serialization;

namespace Pulumi.Aws.Route53.Outputs
{

    [OutputType]
    public sealed class GetRecordsResourceRecordSetGeolocationResult
    {
        /// <summary>
        /// The two-letter code for the continent.
        /// </summary>
        public readonly string ContinentCode;
        /// <summary>
        /// The two-letter code for a country.
        /// </summary>
        public readonly string CountryCode;
        /// <summary>
        /// The two-letter code for a state of the United States.
        /// </summary>
        public readonly string SubdivisionCode;

        [OutputConstructor]
        private GetRecordsResourceRecordSetGeolocationResult(
            string continentCode,

            string countryCode,

            string subdivisionCode)
        {
            ContinentCode = continentCode;
            CountryCode = countryCode;
            SubdivisionCode = subdivisionCode;
        }
    }
}
